
package testRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;


import commonPages.TCSLogout;
import constants.PropertyConfigs;
import core.FrameworkServices;
import core.TestScriptStepGenerator;

import stepDefination.StepKeyword;

import util.ConfigReader;
import util.CopyExcelData;
import util.CopyTestData;
import util.CustomAssert;

import util.ExcelDatabase;
import util.GenericMethods;
import util.LoginUserFromSyncMap;
import util.MapOfUserIDAssignedToAllocation;
import util.SetUpWebdriver;

public class TestExecutionSuite extends GenericMethods{


	public static XSSFWorkbook workbook = null;
	public static FileInputStream fileInputStream = null;
	public String GSTNID = "";
	public String PlaceOfSupply="";
	public String ScenarioID = "";
	public String ReturnType="";
	public String executionStatus = "";
	public String LOBName ="";
	String filePath="";
	String MigrationFilePath="";
	String SheetName = "";
	public static String Browser,CONFIG_PATH,BackupUpFolderName,pathForReport,excelFileName;
	public static ConcurrentHashMap<String, ConcurrentHashMap<String,String>> scenarioStatus = new ConcurrentHashMap<>();
	public static ConcurrentHashMap<String, String> AssertFlagForScenarios = new ConcurrentHashMap<>();
	public static ConcurrentHashMap<String, String> VPAssertFlagForScenarios = new ConcurrentHashMap<>();
	public static ConcurrentHashMap<String, String> ScenariosFailureReason = new ConcurrentHashMap<>();
	
	//For Which Role Assign to Which Scenarios.
	public static ConcurrentHashMap<String, String> assignRoleToScenariosID = new ConcurrentHashMap<>();
	
	volatile int counter;
	
	//Added By Suraj 18-07-2022 For Fillo
	Fillo fillo;
	public static Connection conn;
	public static Connection Assertconn;
	Set<Object> uniqueFolder=null;
	File ProductFolder;
	File OverAllExecutionFolder;
	int Countervalue=1;
	int ExcelCounterValue=1;
	
	XSSFRow Newrowhead;
	XSSFSheet ProductNamesheet1;
	Set<String> uniqueScnerioId= new HashSet<>();
	
	//Added by suraj singh	On 02-08-2022
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extentReporter;
	public static ExtentTest extenttest;
	public static ExtentTest extentNodetest;
	
	//Email Report Script
	XSSFWorkbook AllReportInfo;
	CopyExcelData CopyExcelData = new CopyExcelData();
	
	//Added For Getting Count 
	int FailedCount =0;
	int PassedCount =0;
	int TotalScenarioCount=0;
	
	long start,end;
	
	TCSLogout logout;
	
	public String moduleName ="";
	
	@SuppressWarnings("deprecation")
	@Parameters({"TestData_RepositoryFile","LOB"})
	@BeforeSuite
	public void beforeSuite(String TestData_RepositoryFile,String LOB) throws Exception
	{	
		String getLOBName=LOB.trim();
		start = System.currentTimeMillis();
		Browser = ConfigReader.getInstance().getValue(PropertyConfigs.Browser);
		CONFIG_PATH = ConfigReader.getInstance().getValue(PropertyConfigs.TestDataFolder) + File.separator ;
		BackupUpFolderName = ConfigReader.getInstance().getValue("TestDataBackupFolderName");
		
		//Taking Backup For Test data
		CopyTestData.BackupTestData(CONFIG_PATH , BackupUpFolderName);
		
		FileInputStream fileInputMasterStream = new FileInputStream(new File(CONFIG_PATH+"0001_MasterTestSuite.xlsx"));
		FrameworkServices.masterWorkbook = new XSSFWorkbook(fileInputMasterStream);
		
		fileInputStream = new FileInputStream(new File(CONFIG_PATH + TestData_RepositoryFile));
		workbook = new XSSFWorkbook(fileInputStream);
		
		pathForReport = ConfigReader.getInstance().getValue("AllLogFolderName");
		
		File pathForReportfile = new File(pathForReport);
		if(!pathForReportfile.exists()) {
			pathForReportfile.mkdir();
			AllReportInfo = new XSSFWorkbook();
			FileOutputStream out = new FileOutputStream(new File(pathForReportfile+"\\"+getLOBName.concat("_")+ConfigReader.getInstance().getValue("ExcelReport"))+".xlsx");
		      //write operation workbook using file out object 
			AllReportInfo.write(out);
		    out.close();
		    AllReportInfo.close();
		    
		    try {
		    	
				CopyExcelData.copyExcel(pathForReport,ConfigReader.getInstance().getValue("ScenarioSuite").replaceAll("LOB", ConfigReader.getInstance().getValue("ForWhichModuleReport").trim().concat("_"+LOB.trim())),"TestScenarios",getLOBName);

			} catch (Exception e) {
				// TODO: handle exception
				CopyExcelData.copyExcel(pathForReport, ConfigReader.getInstance().getValue("ScenarioSuite").replaceAll("LOB", LOB.trim()),"TestScenarios",getLOBName);
			}
		}
		else
		{
			if(pathForReportfile.exists())
			{
				//check For LOB Report allready Present Delete that File 
			    File checkfilepresent = new File(pathForReportfile+"\\"+getLOBName.concat("_")+ConfigReader.getInstance().getValue("ExcelReport")+".xlsx");
			    if(checkfilepresent.exists())
			    {
			    	deleteFileInDirectory(pathForReportfile);
			    }
	
				AllReportInfo = new XSSFWorkbook();
				FileOutputStream out = new FileOutputStream(new File(pathForReportfile+"\\"+getLOBName.concat("_")+ConfigReader.getInstance().getValue("ExcelReport"))+".xlsx");
				// write operation workbook using file out object
				AllReportInfo.write(out);
				out.close();
				
				try {
					CopyExcelData.copyExcel(pathForReport,ConfigReader.getInstance().getValue("ScenarioSuite").replaceAll("LOB", ConfigReader.getInstance().getValue("ForWhichModuleReport").trim().concat("_"+LOB.trim())),"TestScenarios",getLOBName);

				} catch (Exception e) {
					// TODO: handle exception
					CopyExcelData.copyExcel(pathForReport, ConfigReader.getInstance().getValue("ScenarioSuite").replaceAll("LOB", LOB.trim()),"TestScenarios",getLOBName);

				}

			}
		}
		
		fillo = new Fillo();
		conn= fillo.getConnection(CONFIG_PATH + TestData_RepositoryFile);
		
		//Added By Suraj For Extends Reports
		htmlReporter = new ExtentSparkReporter( TestEngine.excutionFolder+"\\SBIG_SummaryReport.html").viewConfigurer()
			    .viewOrder()
			    .as(new ViewName[] {
				   ViewName.DASHBOARD
				})
			  .apply();
		//create ExtentReports and attach reporter(s)
		htmlReporter.config().setTimelineEnabled(false);
		 extentReporter = new ExtentReports();
		 extentReporter.attachReporter(htmlReporter);
		
		System.out.println("Before Suite Execute");

	}

	@Parameters({"ScenarioID","LOB","Module", "Description", "ScriptReference","TestData_RepositoryFile"})
	@Test(testName = "ScenarioID")
	public void executionSuite(String testScenario_Id,String LOB, String Module, String Description,String scriptReference,String TestData_RepositoryFile)throws Exception
	{
		VPAssertFlagForScenarios.put(testScenario_Id, "No");
		LOBName=LOB;
		moduleName=Module;
		Reporter.log("<B><Font color=\"white\" font size=\"4%\" > Scenerio Description - "+Description+" </Font> </B>");
		scenarioStatus.put(testScenario_Id, new ConcurrentHashMap<String, String>());
		WebDriver driver = null;
		try {
			
			driver=SetUpWebdriver.setupWebDriver(Browser,testScenario_Id);
			
			CustomAssert customAssert = new CustomAssert(driver);
//			CustomAssert.executionFlag = true;
			
			logout= new TCSLogout(driver);
			
			StepKeyword keyword = new StepKeyword(driver);
			for (TestScriptStepGenerator testScriptStepGenerator : FrameworkServices.getScriptStepFromScriptName(scriptReference,LOB)) {
				//Added For Extends Report On 02-08-2022
				//extentNodetest=extenttest.createNode(testScriptStepGenerator.getStepKeyword()+testScriptStepGenerator.getStepGroup());
				// TODO Amiya 05-10-2019
				int SkipStep= Integer.parseInt(ConfigReader.getInstance().getValue("SkipStep"));
				Reporter.log("<B><Font color=\"BLUE\" font size=\"4%\"> Step   "+Countervalue+" - "+ "Executing : "+testScriptStepGenerator.getStepKeyword() + "   </Font></B>");
				if(Integer.parseInt(testScriptStepGenerator.getSerialNoStepKeyword())>=SkipStep)
				{
					keyword.executeTestStep(driver, testScenario_Id, testScriptStepGenerator.getStepKeyword(),testScriptStepGenerator.getReferenceStepKeywordSheetName(),testScriptStepGenerator.getStepGroup(),testScriptStepGenerator.getSerialNoStepKeyword(),workbook,conn,customAssert,AssertFlagForScenarios,VPAssertFlagForScenarios,ScenariosFailureReason,assignRoleToScenariosID);			
				}
				Countervalue++;
			}
			// TODO Amiya 05-10-2019
			if (AssertFlagForScenarios.get(testScenario_Id)!=null && AssertFlagForScenarios.get(testScenario_Id).equalsIgnoreCase("AssertFail")) 
			{
				Reporter.log("<B><Font Color='yellow'>ScenarioID:::"+testScenario_Id+" --> Assert Fail </Font> </B>");
				setScenarioStatus(testScenario_Id,"AssertFail");
				Assert.fail();
			} 
			else
			{
				Reporter.log("<B><Font Color='yellow'>ScenarioID :::"+testScenario_Id+" --> Test Scenario has been passed </Font> </B>");
				setScenarioStatus(testScenario_Id,"PASSED");
			}
			
		} catch (Exception e) {
  		 	e.printStackTrace();
  		 	
  		 	System.out.println("Localized Message"+e.getLocalizedMessage());
  		 	System.out.println("Get Cause"+e.getCause());  		 	
  		 	
  		 	boolean ScenariosFailureReasonFlag=ScenariosFailureReason.containsKey(testScenario_Id);
			if(!ScenariosFailureReasonFlag) 
			{
				ScenariosFailureReason.put(testScenario_Id," Due To Some Application Issue ");
			}
			
			setScenarioStatus(testScenario_Id,"FAILED");
			Reporter.log("<B><Font Color='yellow'> ScenarioID:::"+testScenario_Id+" --> Test Scenario has been Failed </Font> </B>");
			
			SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),testScenario_Id);
			Reporter.log(e.toString());
			throw(e);
//			if(e.getMessage().equals(ConfigReader.getInstance().getValue("CustomExceptionMessage")) && CustomAssert.executionFlag)
//			{	
//				//Assert.assertEquals(true, true);
//			}
//			else
//			{
//			Reporter.log(e.getCause().getMessage());
//			//Assert.assertEquals(true,false);
//			
//			}
		} finally {
			try {
				driver.close();
				driver.quit();
				driver = null;
				System.out.println(++counter);
			} catch (Exception e2) {}
			
			
			//ExcelDatabase.close_connection();
			
			logout.UserIDRelease(testScenario_Id,assignRoleToScenariosID.get(testScenario_Id));
			System.out.println("All Closed");
		}
	}
	
	public static void setScenarioStatus(String testId,String status){
		ConcurrentHashMap<String, String> statusMap = TestExecutionSuite.scenarioStatus.get(testId);
		statusMap.put("Status", status);
	}
	
	
	@AfterClass 
	public void tearDown() throws IOException {
//		ExcelDatabase.updateBorders(MigrationFilePath);
//		ExcelDatabase.updateBorders(filePath);
		
	}
	
	@AfterSuite
	public void afterSuite() throws Exception {
		System.out.println(ScenariosFailureReason.size());
		System.out.println("After Suite method executed");
		System.out.println(" Assertion Size :- " +AssertFlagForScenarios.size());
		System.out.println(scenarioStatus);
		String ScanerioType=LOBName;
		
		 XSSFWorkbook workbook = new XSSFWorkbook();
	    	XSSFSheet sheet = workbook.createSheet(ScanerioType+"_ResultSummary");
	    	int rowNumber = 0;
	    	XSSFRow rowheadHeader = sheet.createRow((short)rowNumber++);
	    	rowheadHeader.createCell(0).setCellValue("Scenario ID");
	    	rowheadHeader.createCell(1).setCellValue("Status");
	    	rowheadHeader.createCell(2).setCellValue("Assertion Status");
	    	rowheadHeader.createCell(3).setCellValue("Failure Reason");
	    	
	    	Iterator<Map.Entry<String, ConcurrentHashMap<String, String>>> parent = scenarioStatus.entrySet().iterator();
	    	while (parent.hasNext()) {
	    	    Map.Entry<String, ConcurrentHashMap<String, String>> parentPair = parent.next();
	    	    System.out.println("parentPair.getKey() :   " + parentPair.getKey() + " parentPair.getValue()  :  " + parentPair.getValue());

	    	    Iterator<Map.Entry<String, String>> child = (parentPair.getValue()).entrySet().iterator();
	    	    XSSFRow rowhead = sheet.createRow((short)rowNumber++);
	    	    rowhead.createCell(0).setCellValue(parentPair.getKey());
	    	    while (child.hasNext()) {
	    	    	
	    	    	String myKey = child.next().getKey();
	    	    	String value = parentPair.getValue().get(myKey);
	    	    	if(myKey.equalsIgnoreCase("Status")) 
	    	    	{
	    	    		rowhead.createCell(1).setCellValue(value);
	    	    	}
	    	    	if(value.equalsIgnoreCase("FAILED"))
	    	    	{
	    	    		rowhead.createCell(3).setCellValue(ScenariosFailureReason.get(parentPair.getKey()));
	    	    	}
	    	    	
	    	    }
	    	}
	       
	    	OverAllExecutionFolder= new File(TestEngine.excutionFolder+"\\OverAllExecutionFolder");
	    	if(!OverAllExecutionFolder.exists())
	    	{
	    		OverAllExecutionFolder.mkdir();
	    	}
	    	
	        FileOutputStream fileOut = new FileOutputStream(TestEngine.excutionFolder+"\\OverAllExecutionFolder\\"+ScanerioType+"_OverAllExecutionReport.xlsx");
	        String cssOut = ".invocation-failed,  .test-failed  { background-color: #E53030; }\n" + 
					".invocation-percent, .test-percent { background-color: #006600; }\n" + 
					".invocation-passed,  .test-passed  { background-color: #0D5D12; }\n" + 
					".invocation-skipped, .test-skipped { background-color: #A5A129; }\n" + 
					"\n" + 
					".main-page {\n" + 
					"  font-size: x-large;\n" + 
					"}\n" + 
					"\n" + 
					"body{background-color: #5A5353;color: white;}\n" + 
					"table{border-color: black;}\n" + 
					"";
	        	
	if(!scenarioStatus.isEmpty()) {
		uniqueFolder= new HashSet<>();
		
		Set<String> productKeys = scenarioStatus.keySet();
		for (String productKey : productKeys) {
			uniqueFolder.add(productKey.split("_")[1]);
		}
		System.out.println("Product Name Size :-"+uniqueFolder.size() +"Product Name"+ uniqueFolder.size());
		
		//Loop For creating Sheet
		for(int i=0;i<uniqueFolder.size();i++)
		{
			XSSFSheet ProductNamesheet = workbook.createSheet(uniqueFolder.toArray()[i].toString());
	    	int newrowNumber = 0;
	    	XSSFRow NewrowheadHeader = ProductNamesheet.createRow((short)newrowNumber++);
	    	NewrowheadHeader.createCell(0).setCellValue("Scenario ID");
         	NewrowheadHeader.createCell(1).setCellValue("Status");
         	NewrowheadHeader.createCell(2).setCellValue("Assertion Status");
         	NewrowheadHeader.createCell(3).setCellValue("Failure Reason");
		}
		
		for(int i=0;i<uniqueFolder.size();i++)
		{
			ProductFolder= new File(TestEngine.excutionFolder+"\\"+ScanerioType+"\\"+uniqueFolder.toArray()[i]);
			
			if(!ProductFolder.exists())
			{
					ProductFolder.mkdir();
					FileWriter fw=new FileWriter(ProductFolder+"\\testng.css");    
			        fw.write(cssOut);    
			        fw.close();
				
					File pass = new File(ProductFolder+"\\PASS");
					File fail = new File(ProductFolder+"\\FAIL");
					//File assertion = new File(TestEngine.excutionFolder + "\\"+ScanerioType+"\\ASSERT");
					
					if(!pass.exists()) {
						pass.mkdir();
						
					}
					if(!fail.exists()) {
						fail.mkdir();
					}
					
					Set<String> keys = scenarioStatus.keySet();
					for (String key : keys)
					{
						System.out.println("=====================================================>" + key);
						ConcurrentHashMap<String,String> map = scenarioStatus.get(key);
						String status = map.get("Status");
						System.out.println(status);
						
						System.out.println("Scenarios Failure Reason ------> "+ScenariosFailureReason.get(key));
						
						
						File htmlFileToMove = new File(TestEngine.excutionFolder + "\\"+ScanerioType+"\\" + key + ".html");
						File xmlFileToMove = new File(TestEngine.excutionFolder + "\\"+ScanerioType+"\\" + key + ".xml");
		
						if(status.equalsIgnoreCase("PASSED")) 
						{
							String ProductFolder=key.split("_")[1];   //Sanjeevani
							boolean uniqueId=uniqueScnerioId.add(key);
							if(uniqueId) 
							{
								extenttest = extentReporter.createTest(key).assignAuthor("AQM QA").assignDevice(ConfigReader.getInstance().getValue("EnvironmentInRunning"));
								extenttest.log(Status.PASS, key+"   PASSED");
								
								ProductNamesheet1=workbook.getSheet(ProductFolder);
								Newrowhead = ProductNamesheet1.createRow((short)ProductNamesheet1.getLastRowNum()+1);
								Newrowhead.createCell(0).setCellValue(key);
								Newrowhead.createCell(1).setCellValue(status);
								Newrowhead.createCell(2).setCellValue("All Assertion Pass");
								
								PassedCount++;
							}
							
						/*	htmlFileToMove.renameTo(new File(TestEngine.excutionFolder +"\\"+ScanerioType+"\\PASS\\" + key + ".html"));
							xmlFileToMove.renameTo(new File(TestEngine.excutionFolder +"\\"+ScanerioType+"\\PASS\\" + key + ".xml"));*/
							
							htmlFileToMove.renameTo(new File(TestEngine.excutionFolder +"\\"+ScanerioType+"\\"+ProductFolder+"\\PASS\\" + key + ".html"));
							xmlFileToMove.renameTo(new File(TestEngine.excutionFolder +"\\"+ScanerioType+"\\"+ProductFolder+"\\PASS\\" + key + ".xml"));
							
							
							
						}else if(status.equalsIgnoreCase("FAILED") || status.equalsIgnoreCase("AssertFail")) {
							
							String ProductFolder=key.split("_")[1];   //Sanjeevani
							boolean uniqueId=uniqueScnerioId.add(key);
							if(uniqueId) 
							{
								extenttest = extentReporter.createTest(key).assignAuthor("AQM QA").assignDevice(ConfigReader.getInstance().getValue("EnvironmentInRunning"));
								extenttest.log(Status.FAIL, key+"   FAILED");
								
								ProductNamesheet1=workbook.getSheet(ProductFolder);
								Newrowhead = ProductNamesheet1.createRow((short)ProductNamesheet1.getLastRowNum()+1);
								Newrowhead.createCell(0).setCellValue(key);
								Newrowhead.createCell(1).setCellValue(status);
								if(status.equalsIgnoreCase("AssertFail"))
								{
									Newrowhead.createCell(2).setCellValue("Assertion Failed Refer Assert Sheet .");
								}
								if(status.equalsIgnoreCase("FAILED"))
								{
									Newrowhead.createCell(3).setCellValue(ScenariosFailureReason.get(key));
								}
								
								FailedCount++;
								
							}
							htmlFileToMove.renameTo(new File(TestEngine.excutionFolder +"\\"+ScanerioType+"\\"+ProductFolder+"\\FAIL\\" + key + ".html"));
							xmlFileToMove.renameTo(new File(TestEngine.excutionFolder +"\\"+ScanerioType+"\\"+ProductFolder+"\\FAIL\\" + key + ".xml"));
							
						}
						else 
						{
							htmlFileToMove.renameTo(new File(TestEngine.excutionFolder +"\\"+ScanerioType+"\\ASSERT\\" + key + ".html"));
							xmlFileToMove.renameTo(new File(TestEngine.excutionFolder + "\\"+ScanerioType+"\\ASSERT\\" + key + ".xml"));
						}
						
					}
					System.out.println("ExcelCounterValue---->"+ExcelCounterValue);
			}
			
		}
		  workbook.write(fileOut);
	      fileOut.close();
	      workbook.close();
		
	}
		conn.close();
		TestExecutionSuite.fileInputStream.close();
		TestExecutionSuite.workbook.close();
		extentReporter.flush();
		System.out.println("After Suite method executed");
		
		fillo = new Fillo();
		
//		Added by Ankush on 01-01-2024 for module wise report 
		String getActualName = ConfigReader.getInstance().getValue("TestDataSuite").replaceAll("LOB", moduleName.replaceAll(moduleName, ConfigReader.getInstance().getValue("ForWhichModuleReport")).concat("_"+LOBName.trim()));
		System.out.println(getActualName);
		
		String checkStringIsEmptyOrNotOnConfig = ConfigReader.getInstance().getValue("ForWhichModuleReport");
		
		if (checkStringIsEmptyOrNotOnConfig!=null && !checkStringIsEmptyOrNotOnConfig.isEmpty()) {
			
			Assertconn = fillo.getConnection(getActualName);
			
		} else {

			Assertconn = fillo.getConnection(ConfigReader.getInstance().getValue("TestDataSuite").replaceAll("LOB", LOBName.trim()));
		}
		
		ArrayList<Object> AllReportValue= new ArrayList<Object>();
		
		int AssertPassCount=ExcelDatabase.getCountOF(Assertconn, "VPAssertTestData", "PASS");
		int AssertFailCount=ExcelDatabase.getCountOF(Assertconn, "VPAssertTestData", "FAIL");
		int TotalAssert=ExcelDatabase.getCountOF(Assertconn, "VPAssertTestData", "TotalAssert");
		int RunTimeVerificationPoint=ExcelDatabase.getCountOF(Assertconn, "VPAssertTestData", "Run Time Test Data");
		int NotExecutedVerificationPoint=ExcelDatabase.getCountOF(Assertconn, "VPAssertTestData", "blank");
		Assertconn.close();
		
		end = System.currentTimeMillis();
		String timeTaken= ((end - start) / 1000) / 60+ " minute  " + ((end - start) / 1000) % 60+ " second";
		
		File pathForReportfile = new File(pathForReport);
		
		if(pathForReportfile.exists())
		{
			if (checkStringIsEmptyOrNotOnConfig!=null && !checkStringIsEmptyOrNotOnConfig.isEmpty() ) {
				
				 CopyExcelData.copyExcel(pathForReport,ConfigReader.getInstance().getValue("TestDataSuite").replaceAll("LOB", ConfigReader.getInstance().getValue("ForWhichModuleReport").trim().concat("_"+LOBName.trim())), "VPAssertTestData", LOBName.trim());
				
			} else {

				CopyExcelData.copyExcel(pathForReport,ConfigReader.getInstance().getValue("TestDataSuite").replaceAll("LOB", LOBName.trim()),"VPAssertTestData",LOBName.trim());
			}
		}
		
		//Added Code For 03-10-2022
		TotalScenarioCount=scenarioStatus.size();
		
		AllReportValue.add(1);
		AllReportValue.add(TotalScenarioCount);
		AllReportValue.add(PassedCount);
		AllReportValue.add(FailedCount);
		AllReportValue.add(TotalAssert);
		AllReportValue.add(AssertPassCount);
		AllReportValue.add(AssertFailCount);
		AllReportValue.add(RunTimeVerificationPoint);
		AllReportValue.add(NotExecutedVerificationPoint);
		AllReportValue.add(timeTaken);
		
		
		CopyExcelData.AssertExecutionReport(pathForReport,AllReportValue,ScanerioType,LOBName.trim());
		AllReportInfo.close();
		
		//clean scenarioStatus Map 
		scenarioStatus.clear();
	}

	//TODO Amiya Modified 09/10/2019
	@SuppressWarnings("static-access")
	public void updateMigrationDataToMasterData(Connection connForTestData, String migrationTestData, String scenarioId,String scenarioUid) throws FilloException {
		try{
			Fillo fillo = new Fillo();
			Connection connOfMigrationTestData = fillo.getConnection(migrationTestData);
			//String ProposalNumber = "";
			
			String fetchMigrationPropasal = "select * from TestScenarios where ScenarioUID='"+scenarioUid+"'";
			Recordset recordsetMigration = connOfMigrationTestData.executeQuery(fetchMigrationPropasal);
			while (recordsetMigration.next()) {
				GSTNID = recordsetMigration.getField("GSTNid");
				PlaceOfSupply=recordsetMigration.getField("PlaceOfSupply");
				ReturnType=recordsetMigration.getField("ReturnType");
			}
			String updateMigrationIntoTestData = "Update MASTERTESTDATA set GSTNID='"+GSTNID+"', PlaceOfSupply='"+PlaceOfSupply+"',ReturnType='"+ReturnType+"' where TCID='"+scenarioId +"'";
			connForTestData.executeUpdate(updateMigrationIntoTestData);
			connOfMigrationTestData.close();
			recordsetMigration.close();
			//TODO Amiya added 27/12/2018
			ExcelDatabase excelDatabase = new ExcelDatabase();
			excelDatabase.sheetsname.add("MASTERTESTDATA");
		}catch(Exception e){
			System.out.println(e);
			Reporter.log(e.getMessage());
		}
	}
	
	/*private synchronized void UserIDRelease(String executionTestScenario_TestScenarioReference){
        String user="";
        if(MapOfUserIDAssignedToAllocation.listOfUserIDForExecution.containsValue(executionTestScenario_TestScenarioReference)){
            user = LoginUserFromSyncMap.getKeyByValue(MapOfUserIDAssignedToAllocation.listOfUserIDForExecution,executionTestScenario_TestScenarioReference);
            if (!user.equals("")){
                MapOfUserIDAssignedToAllocation.listOfUserIDForExecution.put(user,"Free");
            }
            System.out.println("User ID is blank !!!");
        }
        System.out.println("");
        System.out.println("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released");
        System.out.println("After release of USER ID Updated__MAP shows as below");
        System.out.println("Status wise MAP::"+MapOfUserIDAssignedToAllocation.listOfUserIDForExecution.toString());
        System.out.println("");
    }*/
}


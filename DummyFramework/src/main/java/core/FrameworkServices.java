package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import util.ConfigReader;
import util.MapOfUserIDAssignedToAllocation;


public class FrameworkServices {
	
	
	public static XSSFWorkbook masterWorkbook;
	
	public FrameworkServices() throws Exception {
		MapOfUserIDAssignedToAllocation.getInstance();
	}
	
	public List<TestSuiteGenerator> getTestSuiteForExecution() throws Exception{
		String CONFIG_PATH = ConfigReader.getInstance().getValue("TestDataFolder") + File.separator;
		FileInputStream fileInputStream=new FileInputStream(new File(CONFIG_PATH + "0001_MasterTestSuite.xlsx"));
		masterWorkbook=new XSSFWorkbook(fileInputStream);
		XSSFSheet masterSuiteSheet=masterWorkbook.getSheet("MasterTestSuite");
		int numberOfRows=masterSuiteSheet.getLastRowNum();
		int ReferenceIndexForTestSuite=Integer.parseInt(ConfigReader.getInstance().getValue("ReferenceIndex"));
		int LOBNameIndex=Integer.parseInt(ConfigReader.getInstance().getValue("LOBNameIndex"));
		int DesriptionIndex=Integer.parseInt(ConfigReader.getInstance().getValue("DesriptionIndex"));
		int TestData_RepositoryFileIndex=Integer.parseInt(ConfigReader.getInstance().getValue("TestData_RepositoryFileIndex"));
		int BrowserNameIndex=Integer.parseInt(ConfigReader.getInstance().getValue("BrowserNameIndex"));
		int ExecuteFlagIndex=Integer.parseInt(ConfigReader.getInstance().getValue("ExecuteFlagIndex"));
		int TestScenario_RepositoryFileIndex=Integer.parseInt(ConfigReader.getInstance().getValue("TestScenario_RepositoryFileIndex"));
		//Need to Add For MasterStep KeyWord For All Product LOB
		

		List<TestSuiteGenerator> testSuiteGeneratorList=new ArrayList<>();
		for(int i=1;i<=numberOfRows;i++) {
			Row rowData=masterSuiteSheet.getRow(i);
			if(rowData.getCell(ExecuteFlagIndex).getStringCellValue().equalsIgnoreCase("yes")) {
				TestSuiteGenerator testSuiteGenerator=new TestSuiteGenerator();
				testSuiteGenerator.setReference(rowData.getCell(ReferenceIndexForTestSuite).getStringCellValue());
				testSuiteGenerator.setLOBName(rowData.getCell(LOBNameIndex).getStringCellValue());
				testSuiteGenerator.setDesription(rowData.getCell(DesriptionIndex).getStringCellValue());
				testSuiteGenerator.setTestData_RepositoryFile(rowData.getCell(TestData_RepositoryFileIndex).getStringCellValue());
				testSuiteGenerator.setBrowserName(rowData.getCell(BrowserNameIndex).getStringCellValue());
				testSuiteGenerator.setExecuteFlag(rowData.getCell(ExecuteFlagIndex).getStringCellValue());
				testSuiteGenerator.setTestScenario_RepositoryFile(rowData.getCell(TestScenario_RepositoryFileIndex).getStringCellValue());
				testSuiteGeneratorList.add(testSuiteGenerator);
			}
		}
		return testSuiteGeneratorList;  //Two Reference Motor Health
	}

	public static List<TestScriptStepGenerator> getScriptStepFromScriptName( String scriptName, String lOB) throws Exception {
		String CONFIG_PATH = ConfigReader.getInstance().getValue("TestDataFolder") + File.separator;
		FileInputStream fileInputStream=new FileInputStream(new File(CONFIG_PATH + "0001_MasterTestSuite.xlsx"));
		masterWorkbook=new XSSFWorkbook(fileInputStream);
		
		String getMasterTestScriptStep=lOB.toUpperCase().trim();
		System.out.println(getMasterTestScriptStep.concat("_MasterTestScriptStep"));
		
		XSSFSheet masterTestScriptStepsheet=masterWorkbook.getSheet(getMasterTestScriptStep.concat("_MasterTestScriptStep"));
		int numberOfRows=masterTestScriptStepsheet.getLastRowNum();
		int ReferenceIndexForTestStep=Integer.parseInt(ConfigReader.getInstance().getValue("ReferenceIndexForTestStep"));
		int automationScriptName_MasterTestScriptStep_Index=Integer.parseInt(ConfigReader.getInstance().getValue("AutomationScriptName_MasterTestScriptStep_Index"));
		int stepKeywordIndex=Integer.parseInt(ConfigReader.getInstance().getValue("StepKeywordIndex"));
		int stepGroupIndex=Integer.parseInt(ConfigReader.getInstance().getValue("StepGroupIndex"));
		int skipStepIndex=Integer.parseInt(ConfigReader.getInstance().getValue("SkipStepIndex"));
		
		//Added by Suraj 18-07-2022 For New Logic
		int ReferenceStepKeywordSheetName=Integer.parseInt(ConfigReader.getInstance().getValue("ReferenceStepKeywordSheetName"));
		int SerialNoStepKeyword=Integer.parseInt(ConfigReader.getInstance().getValue("SerialNoStepKeyword"));
		
		List<TestScriptStepGenerator> testScriptStepGenerators=new ArrayList<>();
		for(int i=1;i<=numberOfRows;i++) {
			Row rowData=masterTestScriptStepsheet.getRow(i);
			if(rowData.getCell(automationScriptName_MasterTestScriptStep_Index).getStringCellValue().equalsIgnoreCase(scriptName)&&rowData.getCell(skipStepIndex).getStringCellValue().equalsIgnoreCase("No")) {
				TestScriptStepGenerator testScriptStepGenerator=new TestScriptStepGenerator();
				testScriptStepGenerator.setReference(rowData.getCell(ReferenceIndexForTestStep).getStringCellValue());
				testScriptStepGenerator.setAutomationScriptName(rowData.getCell(automationScriptName_MasterTestScriptStep_Index).getStringCellValue());
				testScriptStepGenerator.setStepKeyword(rowData.getCell(stepKeywordIndex).getStringCellValue());
				testScriptStepGenerator.setStepGroup(rowData.getCell(stepGroupIndex).getStringCellValue());
				testScriptStepGenerator.setSkipStep(rowData.getCell(skipStepIndex).getStringCellValue());
				//Added by Suraj 18-07-2022 For New Logic
				testScriptStepGenerator.setReferenceStepKeywordSheetName(rowData.getCell(ReferenceStepKeywordSheetName).getStringCellValue());
				testScriptStepGenerator.setSerialNoStepKeyword(rowData.getCell(SerialNoStepKeyword).getStringCellValue());
				
				testScriptStepGenerators.add(testScriptStepGenerator);
			}
		}
		return testScriptStepGenerators;
	}


	/*public static List<MigrationTestDataGenerator> getMigrationSuiteGenerator(TestSuiteGenerator testSuiteGenerator) throws FileNotFoundException, IOException{
		FileInputStream fileInputStream=new FileInputStream(new File(getConfigProperties().getProperty("TestDataFolder")+testSuiteGenerator.getTestScenario_RepositoryFile()));
		masterWorkbook=new XSSFWorkbook(fileInputStream);
		XSSFSheet migrationTestData=masterWorkbook.getSheet("MigrationTestData");
		int numberOfRows=migrationTestData.getLastRowNum();
		int SrNo=Integer.parseInt(masterConfigProp.getProperty("SrNo"));
		int ScenarioID=Integer.parseInt(masterConfigProp.getProperty("ScenarioID"));
		int Module=Integer.parseInt(masterConfigProp.getProperty("Module"));
		int Desription=Integer.parseInt(masterConfigProp.getProperty("Desription"));
		int Count=Integer.parseInt(masterConfigProp.getProperty("Count"));
		int MigrationScenarioID=Integer.parseInt(masterConfigProp.getProperty("MigrationScenarioID"));
		int Product=Integer.parseInt(masterConfigProp.getProperty("Product"));
		int ExecuteFlag=Integer.parseInt(masterConfigProp.getProperty("ExecuteFlag"));
		int ProposalNumber=Integer.parseInt(masterConfigProp.getProperty("ProposalNumber"));
		int ClientId1=Integer.parseInt(masterConfigProp.getProperty("ClientId1"));
		int ClientId2=Integer.parseInt(masterConfigProp.getProperty("ClientId2"));
		int Status=Integer.parseInt(masterConfigProp.getProperty("Status"));
		int ScriptName=Integer.parseInt(masterConfigProp.getProperty("ScriptName"));
		List<MigrationTestDataGenerator> migrationTestDataList=new ArrayList<>();

		for(int i=1;i<=numberOfRows;i++) {
			Row rowData=migrationTestData.getRow(i);
			if(rowData.getCell(ExecuteFlag).getStringCellValue().equalsIgnoreCase("yes")) {
				MigrationTestDataGenerator migrationTestDataGenerator=new MigrationTestDataGenerator();
				migrationTestDataGenerator.setSrNo((rowData.getCell(SrNo).getStringCellValue()));
				migrationTestDataGenerator.setScenarioID((rowData.getCell(ScenarioID).getStringCellValue()));
				migrationTestDataGenerator.setModule((rowData.getCell(Module).getStringCellValue()));
				migrationTestDataGenerator.setDesription((rowData.getCell(Desription).getStringCellValue()));
				migrationTestDataGenerator.setCount((rowData.getCell(Count).getStringCellValue()));
				migrationTestDataGenerator.setMigrationScenarioID((rowData.getCell(MigrationScenarioID).getStringCellValue()));
				migrationTestDataGenerator.setProduct((rowData.getCell(Product).getStringCellValue()));
				migrationTestDataGenerator.setExecuteFlag((rowData.getCell(ExecuteFlag).getStringCellValue()));
				migrationTestDataGenerator.setProposalNumber((rowData.getCell(ProposalNumber).getStringCellValue()));
				migrationTestDataGenerator.setClientId1((rowData.getCell(ClientId1).getStringCellValue()));
				migrationTestDataGenerator.setClientId2((rowData.getCell(ClientId2).getStringCellValue()));
				migrationTestDataGenerator.setStatus((rowData.getCell(Status).getStringCellValue()));
				migrationTestDataGenerator.setScriptName((rowData.getCell(ScriptName).getStringCellValue()));
				migrationTestDataList.add(migrationTestDataGenerator);
			}
		}
		return migrationTestDataList;
	}*/
	
	public static List<TestScenarioDataGenerator> getScenarioSuiteGenerator(String LOBName) throws Exception{
		String CONFIG_PATH = ConfigReader.getInstance().getValue("TestDataFolder") + File.separator;
		String MigrationPath="";
		FrameworkServices frameworkServices=new FrameworkServices();
		for(TestSuiteGenerator testSuiteGenerator:frameworkServices.getTestSuiteForExecution()) 
		{
			if(testSuiteGenerator.getLOBName().equalsIgnoreCase(LOBName))
			{
				MigrationPath=testSuiteGenerator.getTestScenario_RepositoryFile();
				break;
			}
		}
		FileInputStream fileInputStream=new FileInputStream(new File(CONFIG_PATH.concat(MigrationPath)));
		masterWorkbook=new XSSFWorkbook(fileInputStream);
		XSSFSheet migrationTestData=masterWorkbook.getSheet("TestScenarios");
		int numberOfRows=migrationTestData.getLastRowNum();
		int SrNo=Integer.parseInt(ConfigReader.getInstance().getValue("SrNo"));
		int ScenarioID=Integer.parseInt(ConfigReader.getInstance().getValue("ScenarioID"));
		int Module=Integer.parseInt(ConfigReader.getInstance().getValue("Module"));
		int Product=Integer.parseInt(ConfigReader.getInstance().getValue("Product"));
		int Desription=Integer.parseInt(ConfigReader.getInstance().getValue("Desription"));
		int Count=Integer.parseInt(ConfigReader.getInstance().getValue("Count"));
		int ExecuteFlag=Integer.parseInt(ConfigReader.getInstance().getValue("ExecuteFlag"));
		int Status=Integer.parseInt(ConfigReader.getInstance().getValue("Status"));
		int ScriptName=Integer.parseInt(ConfigReader.getInstance().getValue("ScriptName"));
		int QAName=Integer.parseInt(ConfigReader.getInstance().getValue("QAName"));
		
		//Newly added Field
		int LOB=Integer.parseInt(ConfigReader.getInstance().getValue("LOB"));
		int ProductTypeVarient=Integer.parseInt(ConfigReader.getInstance().getValue("ProductTypeVarient"));
		int BusinessType=Integer.parseInt(ConfigReader.getInstance().getValue("BusinessType"));
		int TestCasesCover=Integer.parseInt(ConfigReader.getInstance().getValue("TestCasesCover"));
		int TotalNumberOfTestCasesCover=Integer.parseInt(ConfigReader.getInstance().getValue("TotalNumberOfTestCasesCover"));
		
		
		
		List<TestScenarioDataGenerator> migrationTestDataList=new ArrayList<>();

		for(int i=1;i<=numberOfRows;i++) {
			Row rowData=migrationTestData.getRow(i);
			if(rowData.getCell(ExecuteFlag).getStringCellValue().equalsIgnoreCase("yes")) {
				TestScenarioDataGenerator migrationTestDataGenerator=new TestScenarioDataGenerator();
				migrationTestDataGenerator.setSrNo((rowData.getCell(SrNo).getStringCellValue()));
				migrationTestDataGenerator.setScenarioID((rowData.getCell(ScenarioID).getStringCellValue()));
				migrationTestDataGenerator.setModule((rowData.getCell(Module).getStringCellValue()));
				migrationTestDataGenerator.setDesription((rowData.getCell(Desription).getStringCellValue()));
				migrationTestDataGenerator.setCount((rowData.getCell(Count).getStringCellValue()));
				migrationTestDataGenerator.setProduct((rowData.getCell(Product).getStringCellValue()));
				migrationTestDataGenerator.setExecuteFlag((rowData.getCell(ExecuteFlag).getStringCellValue()));
				migrationTestDataGenerator.setScriptName((rowData.getCell(ScriptName).getStringCellValue()));
				migrationTestDataGenerator.setQAName((rowData.getCell(QAName).getStringCellValue()));
				migrationTestDataGenerator.setLOB((rowData.getCell(LOB).getStringCellValue()));
				migrationTestDataGenerator.setProductTypeVarient((rowData.getCell(ProductTypeVarient).getStringCellValue()));
				migrationTestDataGenerator.setBusinessType((rowData.getCell(BusinessType).getStringCellValue()));
				migrationTestDataGenerator.setTestCasesCover((rowData.getCell(TestCasesCover).getStringCellValue()));
				migrationTestDataGenerator.setTotalNumberOfTestCasesCover((rowData.getCell(TotalNumberOfTestCasesCover).getStringCellValue()));
				migrationTestDataList.add(migrationTestDataGenerator);
			}
		}
		return migrationTestDataList;
	}
	

}

package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelDatabase {
	
	public static FileInputStream readFile;
	public static HashSet<String> sheetsname=new HashSet<String>();
	public static Fillo fillo=new Fillo();
	public static Connection conn;
	
	public static Connection Connection_excel(String workbookname) throws FilloException {
		conn=fillo.getConnection(workbookname);
		return conn;
	}
	
	//Added By Suraj For Updating Excel Sheet
	public static synchronized String selectQueryForData(Connection conn, String sheetName, String columnname, String ScenarioID,String stepGroup ) throws FilloException {

		String result=null;
		String strQuery="Select "+columnname+" from "+sheetName+" where TCID='"+ScenarioID+"' and GroupName='"+stepGroup+"'";
		Recordset record=conn.executeQuery(strQuery);		
		while(record.next()) {
			result=record.getField(columnname);
		}
		record.close();
		return result;
	}
	
	//Added by Suraj Singh on 30-09-2023
	public static synchronized String selectQueryForData(Connection conn, String sheetName, String columnname,String VPDesc, String ScenarioID,String stepGroup ) throws FilloException {

		String result=null;
		String strQuery="Select * from "+sheetName+" where (TestCaseID='"+ScenarioID+"' and VPdesc='"+VPDesc+"' ) and ( GroupName='"+stepGroup+"')";
		Recordset record=conn.executeQuery(strQuery);		
		while(record.next()) {
			result=record.getField(columnname);
		}
		record.close();
		return result;
	}
	
	
	public static synchronized void DependencyForPartyCodeNoInSameSheet( Connection conn, String sheetName, String columnname, String ScenarioID,String stepGroup, String value) throws FilloException {
		/*String filePath=FrameworkServices.configProp.getProperty("TestDataFolder")+"\\0002_TestData\\Traditional\\1J\\1JTestData.xlsx";
		Fillo fillo=new Fillo();*/

		String strQuery="Update "+sheetName+" set "+columnname+"='"+value+"'  where TCID='"+ScenarioID+"' and GroupName='"+stepGroup+"'";
		conn.executeUpdate(strQuery);

	}
	
	public static synchronized void UpdateValueInOtherSheetThroughRefrence(Connection conn, String referenceStepKeywordSheetName, String ScenarioID, String stepGroup, String DependencyForPartyCodeNoInOtherSheet, String OtherSheetColumn, String ValueToUpdate) throws FilloException {
		/*String filePath=FrameworkServices.configProp.getProperty("TestDataFolder")+"\\0002_TestData\\Traditional\\1J\\1JTestData.xlsx";
		Fillo fillo=new Fillo();*/
		
		String dependencySheetValue=selectQueryForData(conn, referenceStepKeywordSheetName, DependencyForPartyCodeNoInOtherSheet, ScenarioID,stepGroup );
		
		String SheetName= dependencySheetValue.split(" ")[0];
		String ColumnName= dependencySheetValue.split(" ")[1].split(":")[0];
		String[] referenceNo= dependencySheetValue.split(" ")[1].split(":")[1].split(",");
		
		System.out.println("SheetName    "+SheetName);
		System.out.println("ColumnName   "+ColumnName);
		System.out.println("referenceNo    "+referenceNo);
		
		for(int i=0;i<referenceNo.length;i++)
		{
			String UpdateQuery= "UPDATE "+SheetName+" SET "+OtherSheetColumn+"='"+ValueToUpdate+"' WHERE "+ColumnName+"='"+referenceNo[i]+"'";
			System.out.println(UpdateQuery);
			conn.executeUpdate(UpdateQuery);
		}
	}
	
	//Update Value in Assert Test Data For Verification
	public static synchronized void UpdateInAssertTestData(Connection conn, String SheetName,String ScenarioID, String VPdesc ,String ActualValueFromAplication, ConcurrentHashMap<String, String> vPAssertFlagForScenarios) throws Exception
	{
		//Creating List For Quote Number,Policy Number , Collection No
		
		String IsExecuted=vPAssertFlagForScenarios.get(ScenarioID);
		if(IsExecuted.equalsIgnoreCase("No"))
		{
			vPAssertFlagForScenarios.put(ScenarioID,"yes");
			
			String updateExecuteFlag="Update "+SheetName+" set ExecutedFlag='Yes' where TestCaseID='"+ScenarioID+"'";
			conn.executeUpdate(updateExecuteFlag);
		}
		
		List<String> numbers = new ArrayList<String>();
		numbers.add("Quote Number");
		numbers.add("Policy Number");
		numbers.add("Collection Number");
		
		String VPActualData="";
		String VPExpectedData="";
		String ErrorMsg="";
		
		
		/*String updateActualValue="Update "+SheetName+" set VPActualData='"+ActualValueFromAplication+"' where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
		conn.executeUpdate(updateActualValue);*/
		
		String exceptedValue= "select VPExpectedData from "+SheetName+" where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
        VPActualData=ActualValueFromAplication.trim();
        
        Recordset record=conn.executeQuery(exceptedValue);
        while(record.next())
        {
           VPExpectedData=record.getField("VPExpectedData");                
        }
		 
		 //For Quote Number, Policy Number , collection Number
		 if(numbers.contains(VPExpectedData))
		 {
			 VPExpectedData = VPActualData;
		 }
		 
		 if(VPExpectedData.trim()=="" || VPActualData.trim()=="")
		 {
			 ErrorMsg="Run Time Test Data";
		 }
		 
		 if(ErrorMsg.equals(""))
		 {
			 if(VPExpectedData.trim().equals(VPActualData.trim()) && ( VPExpectedData.trim()!="" || VPActualData.trim()!="" ))
				{
                    String updateResult="Update "+SheetName+" set VPActualData='"+VPActualData+"', Result='PASS' where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
					conn.executeUpdate(updateResult);
				}
				else
				{
                    String updateResult="Update "+SheetName+" set VPActualData='"+VPActualData+"', Result='FAIL' where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
					conn.executeUpdate(updateResult);
				}
		 }
		 else
		 {
			 String updateResult="Update "+SheetName+" set VPActualData='"+VPActualData+"', Result='"+ErrorMsg+"' where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
			 int recordSize=conn.executeUpdate(updateResult);
			 if(recordSize>0) 
			 {
				 System.out.println("Record Updated------");
			 }
			 else
			 {
				 throw new FilloException("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
				// System.out.println("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
			 }
		 }
			
	 }
	
	//Update Value in Assert Test Data For Verification With StepGroup
		public static synchronized void UpdateInAssertTestData(Connection conn, String SheetName,String ScenarioID, String VPdesc ,String ActualValueFromAplication, ConcurrentHashMap<String, String> vPAssertFlagForScenarios ,String GroupName) throws Exception
		{
			//Creating List For Quote Number,Policy Number , Collection No
			
			String IsExecuted=vPAssertFlagForScenarios.get(ScenarioID);
			if(IsExecuted.equalsIgnoreCase("No"))
			{
				vPAssertFlagForScenarios.put(ScenarioID,"yes");
				
				String updateExecuteFlag="Update "+SheetName+" set ExecutedFlag='Yes' where TestCaseID='"+ScenarioID+"'";
				conn.executeUpdate(updateExecuteFlag);
			}
			
			List<String> numbers = new ArrayList<String>();
			numbers.add("Quote Number");
			numbers.add("Policy Number");
			numbers.add("Collection Number");
			
			String VPActualData="";
			String VPExpectedData="";
			String ErrorMsg="";
			
			String exceptedValue= "select VPExpectedData from "+SheetName+" where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
	        VPActualData=ActualValueFromAplication.trim();
	        
	        Recordset record=conn.executeQuery(exceptedValue);
	        while(record.next())
	        {
	           VPExpectedData=record.getField("VPExpectedData");                
	        }
			 
			 //For Quote Number, Policy Number , collection Number
			 if(numbers.contains(VPExpectedData))
			 {
				 VPExpectedData = VPActualData;
			 }
			 
			 if(VPExpectedData.trim()=="" || VPActualData.trim()=="")
			 {
				 ErrorMsg="Run Time Test Data";
			 }
			 
			 if(ErrorMsg.equals(""))
			 {
				 if(VPExpectedData.trim().equals(VPActualData.trim()) && ( VPExpectedData.trim()!="" || VPActualData.trim()!="" ))
					{
	                    String updateResult="Update "+SheetName+" set VPActualData='"+VPActualData+"', Result='PASS' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
						conn.executeUpdate(updateResult);
					}
					else
					{
	                    String updateResult="Update "+SheetName+" set VPActualData='"+VPActualData+"', Result='FAIL' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
						conn.executeUpdate(updateResult);
					}
			 }
			 else
			 {
				 String updateResult="Update "+SheetName+" set VPActualData='"+VPActualData+"', Result='"+ErrorMsg+"' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";			
				 int recordSize=conn.executeUpdate(updateResult);
				 if(recordSize>0) 
				 {
					 System.out.println("Record Updated------");
				 }
				 else
				 {
					 throw new FilloException("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
					// System.out.println("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
				 }
			 }
				
		 }
	
	 //Update VP Assert Test Data With Group If Rquired For the Scenarios
	public static synchronized void UpdateInAssertTestData(Connection conn, String SheetName,String ScenarioID, String VPdesc ,String ActualValueFromAplication ,String ExpectedDateTOCheck,String GroupName) throws Exception
	{
		String VPActualData="";
		String VPExpectedData="";
		String ErrorMsg="";
		
		/*String updateActualValue="Update "+SheetName+" set VPActualData='"+ActualValueFromAplication+"' where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
		conn.executeUpdate(updateActualValue);*/
		
		 String exceptedValue= "select VPExpectedData from "+SheetName+" where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
         VPActualData=ActualValueFromAplication.trim();
         
         Recordset record=conn.executeQuery(exceptedValue);
         while(record.next())
         {
            VPExpectedData=record.getField("VPExpectedData");                
         }
		 
		 VPExpectedData = ExpectedDateTOCheck;
		 
		 if(VPExpectedData.trim()=="" || VPActualData.trim()=="")
		 {
			 ErrorMsg="No Get Record To Update VPActualData & VPExpectedData";
		 }
		 
		 if(ErrorMsg.equals(""))
		 {
			 if(VPExpectedData.trim().equals(VPActualData.trim()) && ( VPExpectedData.trim()!="" || VPActualData.trim()!="" ))
				{
                    String updateResult="Update "+SheetName+" set VPActualData='"+VPActualData+"', Result='PASS' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
					conn.executeUpdate(updateResult);
				}
				else
				{
                    String updateResult="Update "+SheetName+" set VPActualData='"+VPActualData+"', Result='FAIL' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
					conn.executeUpdate(updateResult);
				}
		 }
		 else
		 {
			 String updateResult="Update "+SheetName+" set VPActualData='"+VPActualData+"', Result='FAIL' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";			 int recordSize=conn.executeUpdate(updateResult);
			 if(recordSize>0) 
			 {
				 System.out.println("Record Updated------");
			 }
			 else
			 {
				 throw new FilloException("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
				// System.out.println("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
			 }
		 }
	}
	
		//Update Value in Assert Test Data For Verification For Date
		public static synchronized void UpdateInAssertTestData(Connection conn, String SheetName,String ScenarioID, String VPdesc ,String ActualValueFromAplication ,String ExpectedDateTOCheck) throws Exception
		{
			String VPActualData="";
			String VPExpectedData="";
			String ErrorMsg="";
			
			String updateActualValue="Update "+SheetName+" set VPActualData='"+ActualValueFromAplication+"' where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
			conn.executeUpdate(updateActualValue);
			
			 String exceptedValue= "select VPActualData from "+SheetName+" where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
			 
			 Recordset record=conn.executeQuery(exceptedValue);
			 while(record.next())
			 {
				VPActualData =record.getField("VPActualData");
				//VPExpectedData=record.getField("VPExpectedData");
			 }
			 
			 VPExpectedData = ExpectedDateTOCheck;
			 
			 if(VPExpectedData.trim()=="" || VPActualData.trim()=="")
			 {
				 ErrorMsg="No Get Record To Update VPActualData & VPExpectedData";
			 }
			 
			 if(ErrorMsg.equals(""))
			 {
				 if(VPExpectedData.trim().equals(VPActualData.trim()) && ( VPExpectedData.trim()!="" || VPActualData.trim()!="" ))
					{
                        String updateResult="Update "+SheetName+" set VPActualData='"+VPActualData+"', Result='PASS' where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
						conn.executeUpdate(updateResult);
					}
					else
					{
                        String updateResult="Update "+SheetName+" set VPActualData='"+VPActualData+"', Result='PASS' where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
						conn.executeUpdate(updateResult);
					}
			 }
			 else
			 {
				 String updateResult="Update "+SheetName+" set Result='"+ErrorMsg+"' where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
				 int recordSize=conn.executeUpdate(updateResult);
				 if(recordSize>0) 
				 {
					 System.out.println("Record Updated------");
				 }
				 else
				 {
					 throw new FilloException("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
					// System.out.println("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
				 }
			 }
		}
	
		public static synchronized void NSPTUpdateInAssertTestData(Connection conn, String SheetName,String ScenarioID, String VPdesc ,String ActualValueFromAplication ,String GroupName) throws Exception
		{
			String VPActualData="";
			String VPExpectedData="";
			String ErrorMsg="";
			
			String updateActualValue="Update "+SheetName+" set VPActualData='"+ActualValueFromAplication+"' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
			conn.executeUpdate(updateActualValue);
			
			 String exceptedValue= "select * from "+SheetName+" where (TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
			 
			 Recordset record=conn.executeQuery(exceptedValue);
			 while(record.next())
			 {
				VPActualData =record.getField("VPActualData");
				VPExpectedData=record.getField("VPExpectedData");
			 }
			 
			 if(VPExpectedData.trim()=="" || VPActualData.trim()=="")
			 {
				 ErrorMsg="Run Time Test Data";
			 }
			 
			 if(ErrorMsg.equals(""))
			 {
				 if(VPExpectedData.trim().equals(VPActualData.trim()) && ( VPExpectedData.trim()!="" || VPActualData.trim()!="" ))
					{
						String updateResult="Update "+SheetName+"  set Result='PASS' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
						conn.executeUpdate(updateResult);
					}
					else
					{
						String updateResult="Update "+SheetName+" set Result='FAIL' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
						conn.executeUpdate(updateResult);
					}
			 }
			 else
			 {
				 String updateResult="Update "+SheetName+" set Result='"+ErrorMsg+"' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";

				 int recordSize=conn.executeUpdate(updateResult);
				 if(recordSize>0) 
				 {
					 System.out.println("Record Updated------");
				 }
				 else
				 {
					 throw new FilloException("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
					// System.out.println("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
				 }
			 }
				
		}
		
		//Method to Update the Cover IN Motor Details
        public static synchronized void CoverUpdateInAssertTestData(Connection conn, String SheetName,String ScenarioID, String VPdesc ,String ActualValueFromAplication ,String GroupName) throws Exception
        {
             String VPActualData="";
             String VPExpectedData="";
             String ErrorMsg="";

             String exceptedValue= "select VPExpectedData from "+SheetName+" where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
             VPActualData=ActualValueFromAplication.trim();
             
             Recordset record=conn.executeQuery(exceptedValue);
             while(record.next())
             {
                VPExpectedData=record.getField("VPExpectedData");                
             }
             
             if(VPExpectedData.trim()=="" || VPActualData.trim()=="")
             {
                 ErrorMsg="Run Time Test Data";
             }
             
             if(ErrorMsg.equals(""))
             {
            	 if(VPExpectedData.trim().equals(VPActualData.trim()) && ( VPExpectedData.trim()!="" || VPActualData.trim()!="" ))
				{
					String updateResult="Update "+SheetName+" set VPActualData='"+VPActualData+"',Result='PASS' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
					conn.executeUpdate(updateResult);
				}
				else
				{
					String updateResult="Update "+SheetName+" set VPActualData='"+VPActualData+"', Result='FAIL' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
					conn.executeUpdate(updateResult);
				}
             }
             else
             {
            	 String updateResult="Update "+SheetName+" set Result='"+ErrorMsg+"' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
                 int recordSize=conn.executeUpdate(updateResult);
                 if(recordSize>0) 
                 {
                     System.out.println("Record Updated------");
                 }
                 else
                 {
                     throw new FilloException("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
                    // System.out.println("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
                 }
             }
                
        }
        
//		Added by Ankush on 30-01-2023 for updating endorsement details
		public static synchronized void EndorsementUpdateInAssertTestData(Connection conn, String SheetName,String ScenarioID, String VPdesc ,String ActualValueFromAplication ,String GroupName) throws Exception
		{
			String EndorseVPExpectedData="";
			String EndorseVPActualData="";
			String ErrorMsg="";
			
			/*String updateActualValue="Update "+SheetName+" set EndorseVPActualData='"+ActualValueFromAplication+"' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
			conn.executeUpdate(updateActualValue);*/
			
			 String exceptedValue= "select EndorseVPExpectedData from "+SheetName+" where(TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
			 Recordset record=conn.executeQuery(exceptedValue);
			 while(record.next())
			 {
				//EndorseVPActualData =record.getField("EndorseVPActualData");
				EndorseVPExpectedData=record.getField("EndorseVPExpectedData");
			 }
			 
			 EndorseVPActualData=ActualValueFromAplication.trim();
			 
			 if(EndorseVPExpectedData.trim()=="" || EndorseVPActualData.trim()=="")
			 {
				 ErrorMsg="Run Time Test Data";
			 }
			 
			 if(ErrorMsg.equals(""))
			 {
				 if(EndorseVPExpectedData.trim().equals(EndorseVPActualData.trim()) && ( EndorseVPExpectedData.trim()!="" || EndorseVPActualData.trim()!="" ))
					{
						String updateResult="Update "+SheetName+" set EndorseVPActualData='"+ActualValueFromAplication+"', Result='PASS' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
						conn.executeUpdate(updateResult);
					}
					else
					{
						String updateResult="Update "+SheetName+" set EndorseVPActualData='"+ActualValueFromAplication+"', Result='FAIL' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
						conn.executeUpdate(updateResult);
					}
			 }
			 else
			 {
				 String updateResult="Update "+SheetName+" set EndorseVPActualData='"+ActualValueFromAplication+"', Result='"+ErrorMsg+"' where ( TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
				 int recordSize=conn.executeUpdate(updateResult);
				 if(recordSize>0) 
				 {
					 System.out.println("Record Updated------");
				 }
				 else
				 {
					 throw new FilloException("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
					// System.out.println("Record Not Updated For Column------"+VPdesc+"For Sheet "+SheetName);
				 }
			 }
				
		}
		
	/*public void UpdateInAssertTestDataForEndorsement(String SheetName,String ScenarioID, String VPdesc)
	{
		String DummyQuery="Update VPAssertTestData set VPActualData='Arogya Sanjeevani' where TestCaseID='Arogya_Sanjeevani_TC_001' and VPdesc='Product Name'";
		conn.executeUpdate(DummyQuery);
		
		 String exceptedValue= "select * from \"VPAssertTestData\" where TestCaseID='Arogya_Sanjeevani_TC_001' and VPdesc='Product Name'"; 
		 recordset=conn.executeQuery(exceptedValue);
			while(recordset.next())
			{
				System.out.println("Actual Value "+recordset.getField("VPActualData"));
				System.out.println("Excepted Value "+recordset.getField("VPExpectedData"));
			}
		
		String updateResult="Update VPAssertTestData set Result='PASS' where TestCaseID='Arogya_Sanjeevani_TC_001' and VPdesc='Product Name'";
		connection.executeUpdate(updateResult);
	}*/
	
	//TODO Amiya 10-10-2019
	public static void updateBorders(String filepath) throws IOException {	
		try{	
			FileInputStream readFile=new FileInputStream(new File(filepath));
			@SuppressWarnings("resource")
			XSSFWorkbook xssfWorkbook=new XSSFWorkbook(readFile);
			if(xssfWorkbook.getNumberOfSheets()!=0){
				for(int i=0;i<xssfWorkbook.getNumberOfSheets();i++){		
					for(String sheetName: sheetsname){
						if(xssfWorkbook.getSheetName(i).equals(sheetName)){
							XSSFSheet xssfSheet=xssfWorkbook.getSheet(sheetName);
							int numberOfRows=xssfSheet.getLastRowNum();
							for(int j=1;j<=numberOfRows;j++) {
								Row rowData=xssfSheet.getRow(j);
								for (Cell cell : rowData) {				
									XSSFCellStyle style=xssfWorkbook.createCellStyle();
									style.setBorderTop(BorderStyle.THIN);
									style.setBorderBottom(BorderStyle.THIN);
									style.setBorderLeft(BorderStyle.THIN);
									style.setBorderRight(BorderStyle.THIN);
									cell.setCellStyle(style);
								}
							}
						}
					}
				}
			}
			
			else
			{
				Reporter.log("Sheet not Found");
			}
			FileOutputStream fileOutputStream=new FileOutputStream(new File(filepath));
			xssfWorkbook.write(fileOutputStream);
			fileOutputStream.close();
		}
		catch(Exception e){
			Reporter.log(e.toString());
		}
		  finally{
			  readFile.close();
			  } 
	}
	
	//TODO Amiya 10-10-2019
	public void updateCalculationSheet( Connection conn, String sheetName, String columnname, String value) throws FilloException {
		String strQuery="Update "+sheetName+" set "+columnname+"='"+value+"'";
		conn.executeUpdate(strQuery);
	}
	
    //	Added by Ankush 
	public static synchronized String getValueFromSheet(Connection conn, String sheetName, String VPdesc, String ScenarioID,String VPActualData ) throws Exception
	{
		String getdata = "";
		String exceptedValue= "select * from "+sheetName+" where TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"'";
		Recordset record=conn.executeQuery(exceptedValue);		
		while(record.next()) {
			getdata=record.getField(VPActualData);
		}
		record.close();
		return getdata.trim();
	}
	
	//	Added by Ankush for getting multiple data though Group
	public static synchronized String getValueFromSheet(Connection conn, String sheetName, String VPdesc, String ScenarioID,String VPActualData,String GroupName ) throws Exception
	{
		String getdata = "";
		String exceptedValue= "select * from "+sheetName+" where(TestCaseID='"+ScenarioID+"' and VPdesc='"+VPdesc+"') and ( GroupName ='"+GroupName+"')";
		
		Recordset record=conn.executeQuery(exceptedValue);		
		while(record.next()) {
			getdata=record.getField(VPActualData);
		}
		record.close();
		return getdata.trim();
	}
	
	//Added By Suraj For Getting the Count of Assertion
	public static int getCountOF(Connection conn, String sheetName , String ForPASSFAIL ) throws Exception
	{
		int countValue = 0;
		String CheckFor;
		if(!ForPASSFAIL.equalsIgnoreCase("Blank"))
		{
			CheckFor=ForPASSFAIL;
			
		}else CheckFor="";
		try {
			String exceptedValue="NO";
			if(ForPASSFAIL.equalsIgnoreCase("pass")||ForPASSFAIL.equalsIgnoreCase("fail") || ForPASSFAIL.equalsIgnoreCase("Run Time Test Data"))
			{
				 exceptedValue= "select COUNT(Result) from \"VPAssertTestData\" where ( Result='"+CheckFor+"' and ExecutedFlag='yes')";
			}
			else
			{
				if(ForPASSFAIL.equalsIgnoreCase("TotalAssert"))
				{
					exceptedValue= "select COUNT(Result) from \"VPAssertTestData\" where (ExecutedFlag='yes')";
				}
				else exceptedValue= "select COUNT(Result) from \"VPAssertTestData\" where ( Result='"+CheckFor+"' and ExecutedFlag='yes')";
			}
			
			Recordset record=conn.executeQuery(exceptedValue);
			countValue=record.getCount();
			record.close();
			return countValue;
		} catch (Exception e) {
			return countValue;
		}
	}
	
	
}

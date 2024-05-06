package util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.codoid.products.fillo.Connection;

import constants.PropertyConfigs;
import testRunner.TestEngine;

public class DownloadAllFilesFromChromeBrowser extends GenericMethods{

	WebDriver driver=null;
	public static boolean executionFlag=true;
	public DownloadAllFilesFromChromeBrowser(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings({ "deprecation", "unused" })
	public void downloadFromDocumentScreen(WebDriver driver, String testScenarioID, XSSFWorkbook workbook,
			Connection conn, String stepGroup, Properties dataRow, CustomAssert customAssert, ConcurrentHashMap<String, String> assertFlagForScenarios, ConcurrentHashMap<String, String> vPAssertFlagForScenarios, ConcurrentHashMap<String, String> scenariosFailureReason) throws Exception {
		
		File newFoliderFile;
        File exitFilecheck = new File(ConfigReader.getInstance().getValue(PropertyConfigs.DownloadPath));
        
        if (exitFilecheck.exists()) {
        	deleteFileInDirectory(exitFilecheck);
        	exitFilecheck.delete();
        	System.out.println("Old Folder is deleted from..."+ConfigReader.getInstance().getValue(PropertyConfigs.DownloadPath));
        	
        	String newFolder = ConfigReader.getInstance().getValue(PropertyConfigs.DownloadPath);
			 newFoliderFile = new File(newFolder);
			 newFoliderFile.mkdir();
			 System.out.println("New Folder is created in..."+ConfigReader.getInstance().getValue(PropertyConfigs.DownloadPath));
			
		}else {
			
			String newFolder = ConfigReader.getInstance().getValue(PropertyConfigs.DownloadPath);
			 newFoliderFile = new File(newFolder);
			 newFoliderFile.mkdir();
			 System.out.println("New Folder is created in ..."+ConfigReader.getInstance().getValue(PropertyConfigs.DownloadPath));

		}
        
        try {
        	
        	List<WebElement> downloadLink = driver.findElements(By.xpath("//td/a"));
            for (WebElement link : downloadLink) {
            	
            	link.click();
            	Thread.sleep(10000);
    		}
            
		} catch (Exception e) {
			// TODO: handle exception
		}
       
        File folder = new File(ConfigReader.getInstance().getValue(PropertyConfigs.DownloadPath));
        File[] listOfFiles = folder.listFiles();
        

        boolean FileFound = false;
        File f = null;
        long sizeOfFile = 0;
        double actualFileSize = 0;
        
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
               
                
                for (int i = 0; i < listOfFiles.length; i++) {
        			
                	if (listOfFiles[i].getName().endsWith(".zip") || listOfFiles[i].getName().endsWith(".pdf") || listOfFiles[i].getName().endsWith(".txt") || listOfFiles[i].getName().endsWith(".csv")) {
                		
                		sizeOfFile = FileUtils.sizeOf(new File(listOfFile.getAbsolutePath()));
                		actualFileSize = Double.valueOf(String.format("%.2f",(double)sizeOfFile/1024));
        			}
        		}
                
                System.out.println("File name :  " + listOfFile.getName());
                if (actualFileSize > 0 && (fileName.endsWith(".zip") || fileName.endsWith(".pdf") || fileName.endsWith(".txt") || fileName.endsWith(".csv") )) {
                	
                    f = new File(fileName);
                    System.out.println("File has been downloaded successfully");
                    FileFound = true;
                    
                }else System.out.println("File is not present");

            }
        }
        

        if (FileFound) {
        	
        	List<WebElement> documentNameXpath = driver.findElements(By.xpath("//tbody//tr//td[@class='limit ng-scope'][1]//a"));
			List<WebElement> documentTypeXpath = driver.findElements(By.xpath("//td[@class='limit ng-scope'][3]/div"));
			
			String documentName = "",documentType="", comma;
			
//			loop for getting list of Document name
			for(int k=0;k<documentNameXpath.size();k++) {

				if (k == documentNameXpath.size() - 1) {
					comma="";
				}else {
					comma=",";
				}
				
				documentName += documentNameXpath.get(k).getText() + comma;
			}
			
//			loop for getting list of Document Type
			for(int k=0;k<documentTypeXpath.size();k++) {

				if (k == documentTypeXpath.size() - 1) {
					comma="";
				}else {
					comma=",";
				}
				
				documentType += documentTypeXpath.get(k).getText() + comma;
			}
			
			SetUpWebdriver.completeScreenShot(driver,TestEngine.excutionFolder + ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),
					new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date()));
			
        	ExcelDatabase.NSPTUpdateInAssertTestData(conn,dataRow.getProperty("AssertionTestDataSheetName"), testScenarioID, dataRow.getProperty("VerifyFileDownloadStatus").trim(), ("File has been downloaded successfully"!=""?"File has been downloaded successfully":"Record NO Found"),stepGroup);
			ExcelDatabase.NSPTUpdateInAssertTestData(conn,dataRow.getProperty("AssertionTestDataSheetName"), testScenarioID, dataRow.getProperty("VerifyDocumentName").trim(), (documentName!=""?documentName:"Record NO Found"),stepGroup);
			ExcelDatabase.NSPTUpdateInAssertTestData(conn,dataRow.getProperty("AssertionTestDataSheetName"), testScenarioID, dataRow.getProperty("VerifyDocumentType").trim(), (documentType!=""?documentType:"Record NO Found"),stepGroup);

        	customAssert.verifyAssertFlag("File has been downloaded successfully", "File has been downloaded successfully", "File Download Status",testScenarioID,assertFlagForScenarios);
        	 
		}else {
			
			ExcelDatabase.NSPTUpdateInAssertTestData(conn,dataRow.getProperty("AssertionTestDataSheetName"), testScenarioID, dataRow.getProperty("VerifyFileDownloadStatus").trim(), ("File is not downloaded"!=""? "File is not downloaded":"Record NO Found"),stepGroup);
			
			customAssert.verifyAssertFlag("File has been downloaded successfully", "File is not downloaded", "File Download Status",testScenarioID,assertFlagForScenarios);
		}
        
        f.deleteOnExit();
        driver.close();

	}
	

	
}

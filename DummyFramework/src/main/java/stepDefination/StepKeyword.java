package stepDefination;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.fillo.Connection;


import util.CustomAssert;
import util.ExcelRead;

public class StepKeyword extends StepDefination {
	public StepKeyword(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void executeTestStep(WebDriver driver, String testScenarioID, String step, String ReferenceStepKeywordSheetName, String stepGroup,  String SerialNoStepKeyword,XSSFWorkbook workbook, Connection conn, CustomAssert customAssert, ConcurrentHashMap<String, String> assertFlagForScenarios, ConcurrentHashMap<String, String> VPAssertFlagForScenarios, ConcurrentHashMap<String, String> scenariosFailureReason, ConcurrentHashMap<String, String> assignRoleToScenariosID) throws Exception {
		switch (step)
		{
		
		}
 }	
}

	
	


		


	
		
	
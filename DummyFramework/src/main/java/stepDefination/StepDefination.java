package stepDefination;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import util.CustomAssert;
import util.ExcelDatabase;
import util.GenericMethods;

public class StepDefination extends GenericMethods {

	String dbConnectionSheetName = "DatabaseLogin";
	String puttyLoginSheetName = "PuttyLogin";
   static String party="";
	public static String getParty() {
	return party;
}
	
public static void setParty(String party) {
	StepDefination.party = party;
}

	ExcelDatabase excelDatabase = new ExcelDatabase();
	
	public StepDefination(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
}
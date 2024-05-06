package commonPages;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.LoginUserFromSyncMap;
import util.MapOfUserIDAssignedToAllocation;
import util.WaitTime;


public class TCSLogout extends GenericMethods{
	
	
	private By Logout = By.xpath("//i[@title='Logout']");
	
	WebDriverWait wait;
	public TCSLogout(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
	}
	
	public void ClickOnLogoutBtn(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,String referenceStepKeywordSheetName, CustomAssert customAssert, ConcurrentHashMap<String, String> assertFlagForScenarios ) throws Exception
	{
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, "TCS_LoginPage", testCaseName,stepGroup);
		Reporter.log("<B>Logout from Application</B>");
	
		switchtodefaultframe(driver);
		switchtoframe(driver, "head");
		clickForLogin(Logout,"Logout Button");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("LogOut from Application");
		Reporter.log("LogOut from Application sucessfully");
	    switchtodefaultframe(driver);
		
		if(dataRow.getProperty("BOPsLogOut")!=null && !(dataRow.getProperty("BOPsLogOut").isEmpty()))
		{
			if(dataRow.getProperty("BOPsLogOut").equalsIgnoreCase("Yes"))
			{
				UserIDRelease(testCaseName,"BOPS");
			}
		}
		
		if(dataRow.getProperty("PPMCLogOut")!=null && !(dataRow.getProperty("PPMCLogOut").isEmpty()))
		{
			if(dataRow.getProperty("PPMCLogOut").equalsIgnoreCase("Yes"))
			{
				UserIDRelease(testCaseName,"PPMC");
			}
			
		}
		
		if(dataRow.getProperty("UWRLogOut")!=null && !(dataRow.getProperty("UWRLogOut").isEmpty()))
		{
			if(dataRow.getProperty("UWRLogOut").equalsIgnoreCase("Yes"))
			{
				UserIDRelease(testCaseName,"UWRR");
			}
		}
		
		//Motor UWR Level Logout
		if(dataRow.getProperty("UWR5LogOut")!=null && !(dataRow.getProperty("UWR5LogOut").isEmpty()))
		{
			if(dataRow.getProperty("UWR5LogOut").equalsIgnoreCase("Yes"))
			{
				UserIDRelease(testCaseName,"MotorUWRR5Login");
			}
		}
		
		if(dataRow.getProperty("UWR6LogOut")!=null && !(dataRow.getProperty("UWR6LogOut").isEmpty()))
		{
			if(dataRow.getProperty("UWR6LogOut").equalsIgnoreCase("Yes"))
			{
				UserIDRelease(testCaseName,"MotorUWRR6Login");
			}
		}
		
		if(dataRow.getProperty("UWR7LogOut")!=null && !(dataRow.getProperty("UWR7LogOut").isEmpty()))
		{
			if(dataRow.getProperty("UWR7LogOut").equalsIgnoreCase("Yes"))
			{
				UserIDRelease(testCaseName,"MotorUWRR7Login");
			}
		}
		
		if(dataRow.getProperty("UWR8LogOut")!=null && !(dataRow.getProperty("UWR8LogOut").isEmpty()))
		{
			if(dataRow.getProperty("UWR8LogOut").equalsIgnoreCase("Yes"))
			{
				UserIDRelease(testCaseName,"MotorUWRR8Login");
			}
		}
		
		//Added By Suraj RM Login Release
		if(dataRow.getProperty("RMLogOut")!=null && !(dataRow.getProperty("RMLogOut").isEmpty()))
		{
			if(dataRow.getProperty("RMLogOut").equalsIgnoreCase("Yes"))
			{
				UserIDRelease(testCaseName,"MotorRMLogId");
			}
		}
		
//		Added by Ankush for All motor UWR release
		if(dataRow.getProperty("UWRLogOutForAllRoles")!=null && !(dataRow.getProperty("UWRLogOutForAllRoles").isEmpty()))
		{
			if(dataRow.getProperty("UWRLogOutForAllRoles").equalsIgnoreCase("Yes"))
			{
				UserIDRelease(testCaseName,"UWRRLoginForAllRoles");
			}
		}
  }
	
	public synchronized void UserIDRelease(String executionTestScenario_TestScenarioReference,String FORWHICHROLE)
	{
        String user="";
       
        	switch (FORWHICHROLE) {
        	
        	case "BOPS":
        		 if(MapOfUserIDAssignedToAllocation.listOfUserIDForExecution.containsValue(executionTestScenario_TestScenarioReference))
        		 {
					 user = LoginUserFromSyncMap.getKeyByValue(MapOfUserIDAssignedToAllocation.listOfUserIDForExecution,executionTestScenario_TestScenarioReference);
					 if (!user.equals("")){
			                MapOfUserIDAssignedToAllocation.listOfUserIDForExecution.put(user,"Free");
			                System.out.println("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released Form BOPS");
			                Reporter.log("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released Form BOPS");
			            }
					 
        		 }
				 break;
        	
			case "PPMC":
				 if(MapOfUserIDAssignedToAllocation.PPMClistOfUserIDForExecution.containsValue(executionTestScenario_TestScenarioReference))
        		 {
				 user = LoginUserFromSyncMap.getKeyByValue(MapOfUserIDAssignedToAllocation.PPMClistOfUserIDForExecution,executionTestScenario_TestScenarioReference);
				 if (!user.equals("")){
		                MapOfUserIDAssignedToAllocation.PPMClistOfUserIDForExecution.put(user,"Free");
		                System.out.println("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released From PPMC");
		            }
        		 }
				 break;
				
			case "UWRR":
				 if(MapOfUserIDAssignedToAllocation.UWRlistOfUserIDForExecution.containsValue(executionTestScenario_TestScenarioReference))
        		 {
				 user = LoginUserFromSyncMap.getKeyByValue(MapOfUserIDAssignedToAllocation.UWRlistOfUserIDForExecution,executionTestScenario_TestScenarioReference);
				 if (!user.equals("")){
		                MapOfUserIDAssignedToAllocation.UWRlistOfUserIDForExecution.put(user,"Free");
		                System.out.println("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released From UWRR");
		            }
        		 }
				 break;
			
			//Motor UWR Logout
			case "MotorUWRR5Login":
				 if(MapOfUserIDAssignedToAllocation.MotorUWRR5LogId.containsValue(executionTestScenario_TestScenarioReference))
       		 {
				 user = LoginUserFromSyncMap.getKeyByValue(MapOfUserIDAssignedToAllocation.MotorUWRR5LogId,executionTestScenario_TestScenarioReference);
				 if (!user.equals("")){
		                MapOfUserIDAssignedToAllocation.MotorUWRR5LogId.put(user,"Free");
		                System.out.println("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released From MotorUWRR5LogId");
		                Reporter.log("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released Form BOPS");
				 }
       		 }
				 break;
				 
			case "MotorUWRR6Login":
				 if(MapOfUserIDAssignedToAllocation.MotorUWRR6LogId.containsValue(executionTestScenario_TestScenarioReference))
      		 {
				 user = LoginUserFromSyncMap.getKeyByValue(MapOfUserIDAssignedToAllocation.MotorUWRR6LogId,executionTestScenario_TestScenarioReference);
				 if (!user.equals("")){
		                MapOfUserIDAssignedToAllocation.MotorUWRR6LogId.put(user,"Free");
		                System.out.println("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released From MotorUWRR6LogId");
		                Reporter.log("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released Form BOPS");
				 }
      		 }
				 break;
				 
			case "MotorUWRR7Login":
				 if(MapOfUserIDAssignedToAllocation.MotorUWRR7LogId.containsValue(executionTestScenario_TestScenarioReference))
      		 {
				 user = LoginUserFromSyncMap.getKeyByValue(MapOfUserIDAssignedToAllocation.MotorUWRR7LogId,executionTestScenario_TestScenarioReference);
				 if (!user.equals("")){
		                MapOfUserIDAssignedToAllocation.MotorUWRR7LogId.put(user,"Free");
		                System.out.println("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released From MotorUWRR7LogId");
		                Reporter.log("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released Form MotorUWRR7LogId");
				 }
      		 }
				 break;
				 
			case "MotorUWRR8Login":
				 if(MapOfUserIDAssignedToAllocation.MotorUWRR8LogId.containsValue(executionTestScenario_TestScenarioReference))
      		 {
				 user = LoginUserFromSyncMap.getKeyByValue(MapOfUserIDAssignedToAllocation.MotorUWRR8LogId,executionTestScenario_TestScenarioReference);
				 if (!user.equals("")){
		                MapOfUserIDAssignedToAllocation.MotorUWRR8LogId.put(user,"Free");
		                System.out.println("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released From MotorUWRR8LogId");
		                Reporter.log("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released Form MotorUWRR8LogId");
				 }
      		 }
				 break;
				 
			case "MotorRMLogId":
				 if(MapOfUserIDAssignedToAllocation.MotorRMLogId.containsValue(executionTestScenario_TestScenarioReference))
     		 {
				 user = LoginUserFromSyncMap.getKeyByValue(MapOfUserIDAssignedToAllocation.MotorRMLogId,executionTestScenario_TestScenarioReference);
				 if (!user.equals("")){
		                MapOfUserIDAssignedToAllocation.MotorRMLogId.put(user,"Free");
		                System.out.println("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released From RM Login Ids");
		            Reporter.log("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released From RM Login Ids");
				 }
     		 }
				 break;
				 
//			Added by Ankush for All motor UWR release
			case "UWRRLoginForAllRoles":
				 if(MapOfUserIDAssignedToAllocation.MotorUWRRLoginIDForAllRoles.containsValue(executionTestScenario_TestScenarioReference))
     		 {
				 user = LoginUserFromSyncMap.getKeyByValue(MapOfUserIDAssignedToAllocation.MotorUWRRLoginIDForAllRoles,executionTestScenario_TestScenarioReference);
				 if (!user.equals("")){
					 
		                MapOfUserIDAssignedToAllocation.MotorUWRRLoginIDForAllRoles.put(user,"Free");
		                System.out.println("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released From MotorUWRRLoginIDForAllRoles");
		                Reporter.log("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released Form MotorUWRRLoginIDForAllRoles");
				 }
     		 }
				 break;

			default:
				break;
			}
    }
	
}


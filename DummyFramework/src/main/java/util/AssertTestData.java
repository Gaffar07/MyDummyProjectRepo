package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.codoid.products.fillo.Connection;

public class AssertTestData {
	
	public static String AssertFailInfo="";
	
	public void verifyPolicyData(WebDriver driver, String testScenarioID, String step,
			String referenceStepKeywordSheetName, String stepGroup, String serialNoStepKeyword, 
			XSSFWorkbook workbook,Connection conn, CustomAssert customAssert,
			Map<String, String> applicationFetchAssertData) throws Exception {
		
		String sheetName = referenceStepKeywordSheetName;
        Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testScenarioID,stepGroup);
        Map<String, String> exceptedtestData= new HashedMap(dataRow);
        List<String> defaultvalue= new ArrayList<String>();
		defaultvalue.add("TCID");
		defaultvalue.add("ReferenceKey");
		defaultvalue.add("GroupName");
		defaultvalue.add("ExecuteType");
        
        for(String key : exceptedtestData.keySet())
		{
			String ApplicationFetchValue=applicationFetchAssertData.get(key);
			String exceptedAssertValue=exceptedtestData.get(key);
			
			System.out.println("ApplicationFetchValue"+ApplicationFetchValue);
			System.out.println("exceptedAssertValue  "+exceptedAssertValue);
			
			if(!defaultvalue.contains(key))
			{
				if(!ApplicationFetchValue.equalsIgnoreCase(exceptedAssertValue))
				{
					AssertFailInfo = AssertFailInfo+" "+key+"---"+ApplicationFetchValue+",";
				}
				//customAssert.SBIverifyAssert(exceptedAssertValue, ApplicationFetchValue, " Verifying Excepted "+exceptedAssertValue +"With Actual "+ApplicationFetchValue);
			}
		}
        if(AssertFailInfo.equalsIgnoreCase("")) 
        {
        	AssertFailInfo="All Assertion Are Match";
        }
        applicationFetchAssertData.put(testScenarioID, AssertFailInfo);
	}

}

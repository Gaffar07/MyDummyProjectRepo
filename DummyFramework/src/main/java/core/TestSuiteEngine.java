package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import util.ConfigReader;


public class TestSuiteEngine {
	@SuppressWarnings("static-access")
	//ReadConfig
	
	public List<XmlSuite> executeTestSuiteGenerator(FrameworkServices frameworkServices,List<XmlSuite> suiteList) throws Exception {

		for(TestSuiteGenerator testSuiteGenerator:frameworkServices.getTestSuiteForExecution()) {
			XmlSuite suite=new XmlSuite();
			//suite.setName(ConfigReader.getInstance().getValue("ScanerioType"));
			suite.setName(testSuiteGenerator.getLOBName());
			System.out.println("Lob Name :- "+testSuiteGenerator.getLOBName());
			System.out.println(Integer.valueOf(ConfigReader.getInstance().getValue("ThreadCount")));
			suite.setThreadCount(Integer.valueOf(ConfigReader.getInstance().getValue("ThreadCount")));
			suite.setParallel("tests");
			Map<String, String> testSuiteParams=new HashMap<>();
			testSuiteParams.put("TestData_RepositoryFile", testSuiteGenerator.getTestData_RepositoryFile());
			testSuiteParams.put("LOB", testSuiteGenerator.getLOBName());
			suite.setParameters(testSuiteParams);
			
			for(TestScenarioDataGenerator testScenarioDataGenerator:frameworkServices.getScenarioSuiteGenerator(testSuiteGenerator.getLOBName())) 
			{
					XmlTest test=new XmlTest(suite);
					test.setName(testScenarioDataGenerator.getScenarioID());
					test.setVerbose(2);
					Map<String, String> testCaseParams=new HashMap<>();
					testCaseParams.put("ScenarioID", testScenarioDataGenerator.getScenarioID());
					testCaseParams.put("LOB", testScenarioDataGenerator.getLOB());
					testCaseParams.put("Module", testScenarioDataGenerator.getModule());
					testCaseParams.put("Description", testScenarioDataGenerator.getDesription());
					testCaseParams.put("Product",testScenarioDataGenerator.getProduct());
					testCaseParams.put("ScriptReference", testScenarioDataGenerator.getScriptName());
					test.setParameters(testCaseParams);
					List<XmlClass> classes=new ArrayList<>();
					classes.add(new XmlClass("testRunner.TestExecutionSuite"));
					test.setClasses(classes);
			}
			
			suiteList.add(suite);
		}
		return suiteList;
	}
}





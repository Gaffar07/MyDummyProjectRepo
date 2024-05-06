package testRunner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import core.FrameworkServices;
import core.TestSuiteEngine;
import util.ConfigReader;

public class TestEngine {
	
	public static String excutionFolder="";
	public static Process process=null;
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		try {
			//TODO Amiya added 30/11/2018
			ZipSecureFile.setMinInflateRatio(0);
			FrameworkServices frameworkServices=new FrameworkServices();
			TestNG testNG=new TestNG();
			java.util.Date date=new java.util.Date();
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy__hh-mm-ss");
			String folderDate=simpleDateFormat.format(date);
			excutionFolder="D:\\ExecutionReports\\"+ConfigReader.getInstance().getValue("ReportForWhichLOB")+folderDate;
			testNG.setOutputDirectory(excutionFolder);		
			List<XmlSuite> suiteList=new ArrayList<>();
			suiteList=	new TestSuiteEngine().executeTestSuiteGenerator(frameworkServices, suiteList);
			
			for(XmlSuite xml:suiteList) {
				 FileWriter writer; 
			       try { 
			            writer = new FileWriter(new File("testNG.xml")); 
			            writer.write(xml.toXml()); 
			            writer.flush(); 
			            writer.close(); 
			            //System.out.println(new File("testNG.xml").getAbsolutePath());           
			            } catch (IOException e)
			            {
			              e.printStackTrace(); 
			            }
			    
			}
			
			testNG.setXmlSuites(suiteList);
			testNG.run();
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		finally{
			Runtime rt=Runtime.getRuntime();
		//	rt.exec("taskkill /IM chromedriver.exe /F");
			rt.exec("taskkill /F /IM chrome.exe /T");
			rt.exec("taskkill /F /IM chromedriver.exe /T");
			System.out.println("All chromedriver closed --> " +rt);
		}
	}
}
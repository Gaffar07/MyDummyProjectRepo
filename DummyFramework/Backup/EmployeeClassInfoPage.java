package GroupPages;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.android.dx.rop.cst.CstArray.List;
import com.codoid.products.fillo.Connection;

import constants.PropertyConfigs;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.WaitTime;

public class EmployeeClassInfoPage extends Coverdetails {
	
	//Click on ADD btn
	private By Addbtn = By.xpath("//button[@id='AddBtn']");
		
	//	Category Description 
	private By CategoryDescription = By.xpath("//input[@id='Category Description']");
	
	//Save 
	private By Save = By.xpath("//button[@id='Save']");
	
	//Save 
	private By Save1 = By.xpath("//button[@id='SaveBtn']");
	//Ok
	private By OKBtn = By.xpath("//button[contains(text(),'OK')]");
	
	//PED Applicability
	private By PEDApplicability = By.xpath("//select[@id='PED Applicable']");
	
//	Base Sum Insured
	private By BaseSumInsured = By.xpath("//input[@id='Base Sum Insured']");
	
	//Demographic Details 
	private By demographicDetails = By.xpath("//button[@id='Demographic Details']");
	
	//from Age
	private By fromAge = By.xpath("//input[@id='From Age']");
	
	//To Age
	private By toAge = By.xpath("//input[@id='To Age']");
	
	//Relationship Type
	private By relationshipType = By.xpath("//select[@id='Type Of Relationship0']");
	
	//Gender
	private By gender = By.xpath("//select[@id='Gender0']");
	
	//No of lives
	private By nooflives = By.xpath("//input[@id='Text1']");
	
	//Sum Insured
	private By applicableSumInsured = By.xpath("//input[@id='Applicable SumInsured0']");
	
	// Add Row btn 
	private By Addrowbtn = By.xpath("//button[@id='Add Row']");
		
	// Close btn 
	private By closebtn = By.xpath("//button[@id='CloseBtn']");
	
	//covrage list Details
		private By covragelistbtn = By.xpath("//button[@id='Coverage List']");
		
		//Base Cover
		private By BaseCover = By.xpath("//b[contains(text(),'BASE')]");
		
	//RACV - Road Ambulance Expenses
		private By RACVcovercheckbox = By.xpath("(//input[@type='checkbox'])[7]");
		
		//RACV - Road Ambulance Expenses Link
		private By RACVcoverlink = By.xpath("//a[contains(text(),'RACV')]");
		
		//Road Ambulance Option
		private By RoadAmbulanceOptiondropdown = By.xpath("//select[@id='Road Ambulance Option']");
		
		//Absolute Amount drop down
		private By absoluteAmount = By.xpath("//select[@id='Absolute Amount']");
		
		//% of Sum Insured
		private By perOfsumInsured = By.xpath("//select[@id='Percent Sum Insured']");
		
		//ADD btn on cover
		private By Addcoverbtn = By.xpath("(//button[contains(text(),'Add')])[1]");
		
	//POHM - Post-hospitalization Medical Expenses
		private By POHMcovercheckbox = By.xpath("(//input[@type='checkbox'])[5]");
		
		//POHM - Post-hospitalization Medical Expenses link
		private By POHMcoverlink = By.xpath("//a[contains(text(),'POHM')]");
		
		
		//Post-hospitalization days
		private By Posthospitalizationdropdown = By.xpath("//select[@id='Post-hospitalisation Period(Days)']");
		
	//PRHM - Pre â€“ hospitalization Medical Expenses	checkbox
		private By PRHMcovercheckbox = By.xpath("(//input[@type='checkbox'])[4]");
		
		//PRHM - Pre â€“ hospitalization Medical Expenses	Link
		private By PRHMPrecoverlink = By.xpath("//a[contains(text(),'PRHM')]");
		
		//PRHM - Pre -hospitalization days
			private By Prehospitalizationdropdown = By.xpath("//select[@id='Pre-hospitalisation Period(Days)']");
			
	// DCHS - Domiciliary Hospitalization checkbox
			
			private By DCHScovercheckbox = By.xpath("(//input[@type='checkbox'])[7]");
			
			//DCHS - Domiciliary Hospitalization Link
			private By DCHScoverlink = By.xpath("//a[contains(text(),'DCHS')]");
			
			//DCHS SI
			private By DCHSSI = By.xpath("//input[@id='Applicable Suminsured']");
				
		// IPTT - In-patient Hospitalization cover
		
			private By IPTTcovercheckbox = By.xpath("(//input[@type='checkbox'])[8]");
			
			//IPTT - In-patient Hospitalization cover Link
			private By IPTTcoverlink = By.xpath("//a[contains(text(),'IPTT')]");
			
			//IPTTSI
			private By IPTTSI = By.xpath("//input[@id='Applicable Suminsured']");
			
			//Coverage Option
			private By CoverageOptiondropdown = By.xpath("//select[@id='Hospital Coverage Upto']");
			
			//ICU Coverage
			private By ICUCoveragedropdown = By.xpath("//select[@id='Coverage ICU']");
			
			//Room type
			private By    roomtypedropdown = By.xpath("//select[@id='Room Type']");
		
			// DCTT - Day Care Treatment
		
			private By DCTTcovercheckbox = By.xpath("(//input[@type='checkbox'])[6]");
			
			// DCTT - Day Care Treatment Link
			private By DCTTcoverlink = By.xpath("//a[contains(text(),'DCTT')]");
			
	// ORDR - Organ Donor Expenses	
			
			private By ORDRcovercheckbox = By.xpath("(//input[@type='checkbox'])[8]");
			
			// ORDR - Organ Donor Expenses Link
			private By ORDRcoverlink = By.xpath("//a[contains(text(),'ORDR')]");
			
			//ORDRSI
			private By ORDRSI = By.xpath("//input[@id='Applicable Suminsured']");
			
			//premium Rate
			private By ORDRpremiumrate = By.xpath("//input[@id='Premium Rate']");
			
		
	// Save button on BASE Cover
			
			private By savebasecoverbtn = By.xpath("(//button[contains(text(),'Save')])[1]");
			
			
	// Optional Cover	
			
			
			
			private By optionalCover = By.xpath("//b[contains(text(),'Optional')]");
			
			//SPOR - Sports Activity Cover
			private By SPORcovercheckbox = By.xpath("(//input[@type='checkbox'])[3]");
			
			private By SPORcoverlink = By.xpath("//a[contains(text(),'SPOR')]");
			
			private By sportsEligibility = By.xpath("//input[@id='Sports Eligibility']");
			
	// UMM - Ultra Modern Medicine
			
			
			private By UMMcovercheckbox = By.xpath("(//input[@type='checkbox'])[4]");
			
			private By UMMcoverlink = By.xpath("//a[contains(text(),'UMM')]");
			
			
			private By UMMSI = By.xpath("//input[@id='Applicable Suminsured']");
			
	// VCCV - Vaccination Expenses		
	
			private By VCCVcovercheckbox = By.xpath("(//input[@type='checkbox'])[5]");
			
			private By VCCVcoverlink = By.xpath("//a[contains(text(),'VCCV')]");
			
			private By VCCVSI = By.xpath("//select[@id='Vaccination Sum Insured']");
			
			
	// WELL - Wellmother Cover		
	
			private By WELLcovercheckbox = By.xpath("(//input[@type='checkbox'])[6]");
			
			private By WELLcoverlink = By.xpath("//a[contains(text(),'WELL')]");
			
			private By wellloading = By.xpath("//input[@id='Loading %']");
	
	// WLI - Wellness Coach
			
			
			private By WLIcovercheckbox = By.xpath("(//input[@type='checkbox'])[7]");
			
			private By WLIcoverlink = By.xpath("//a[contains(text(),'WLI')]");
			
	//  FTAS - Fitness Assessment		
			
			
			private By FTAScovercheckbox = By.xpath("(//input[@type='checkbox'])[8]");
			
			private By FTAScoverlink = By.xpath("//a[contains(text(),'FTAS')]");	
			
			private By frequencyperyear = By.xpath("//select[@id='Frequency Per Year']");
			
			private By noOfassenssmentPerSession = By.xpath("//select[@id='Assessments Per Session']");
			
	// EXCA - External Congenital Anomaly
			
			
			private By EXCAcovercheckbox = By.xpath("(//input[@type='checkbox'])[9]");
			
			private By EXCAcoverlink = By.xpath("//a[contains(text(),'EXCA')]");
			
			private By EXCASI = By.xpath("//input[@id='Applicable Suminsured']");
			
	// HLTCH - Health Check-up Program			
			
			private By HLTCHcovercheckbox = By.xpath("(//input[@type='checkbox'])[10]");
			
			private By HLTCHcoverlink = By.xpath("//a[contains(text(),'HLTCH')]");
			
			private By checkuplimit = By.xpath("//select[@id='Checkup Limit']");
			
	// DMAS - Domestic Emergency Medical assistance	
			
			private By DMAScovercheckbox = By.xpath("(//input[@type='checkbox'])[12]");
			
			private By DMAScoverlink = By.xpath("//a[contains(text(),'DMAS')]");
			
			private By grosspremium = By.xpath("//input[@id='Gross Premium for Life']");
			
	
	//  HLTHA - Health Assessment		
			
			
			private By HLTHAcovercheckbox = By.xpath("(//input[@type='checkbox'])[13]");
			
			private By HLTHAcoverlink = By.xpath("//a[contains(text(),'HLTHA')]");
			
			private By membereligibility = By.xpath("//select[@id='Member Coverage Option']");
			
	// DCLC - Daily cash for choosing lower category room		
			
			
			private By DCLCcovercheckbox = By.xpath("(//input[@type='checkbox'])[14]");
			
			private By DCLCcoverlink = By.xpath("//a[contains(text(),'DCLC')]");
			
			private By premiumrate = By.xpath("//input[@id='Premium Rate']");
			
	//  HLTHRET - HealthReturns TM	
			
			
			private By HLTHRETcovercheckbox = By.xpath("(//input[@type='checkbox'])[15]");
			
			private By HLTHRETcoverlink = By.xpath("//a[contains(text(),'HLTHRET')]");
			
			private By healthReturnsLimit = By.xpath("//select[@id='HealthReturns Limit']");
			
			private By healthReturnUtilizationPeriod = By.xpath("//select[@id='Health Return Utilization Period']");
			
			private By earnedBenefitsSplit = By.xpath("//select[@id='Earned Benefit Split']");
	
	// RVBE - Recovery Benefit		
			
			private By RVBEcovercheckbox = By.xpath("(//input[@type='checkbox'])[16]");
			
			private By RVBEcoverlink = By.xpath("//a[contains(text(),'HLTHRET')]");
			
			private By RVBESI = By.xpath("//input[@id='Recovery Sum Insured']");
			
	// NBBE - New Born Baby Expenses		
			
			
			private By NBBEcovercheckbox = By.xpath("(//input[@type='checkbox'])[17]");
			
			private By NBBEcoverlink = By.xpath("//a[contains(text(),'NBBE')]");
			
			private By coverageoption = By.xpath("//select[@id='Coverage option4']");
			
			
	// MTEX - Maternity Benefit	
			
			private By MTEXcovercheckbox = By.xpath("(//input[@type='checkbox'])[17]");
			
			private By MTEXcoverlink = By.xpath("//a[contains(text(),'MTEX')]");
			
			private By MTEXcoverageoption = By.xpath("//select[@id='Coverage Option MTEX']");
			
	// INFR - Infertility Treatment		
			
			
			private By INFRcovercheckbox = By.xpath("(//input[@type='checkbox'])[18]");
			
			private By INFRcoverlink = By.xpath("//a[contains(text(),'INFR')]");
			
			private By INFRSI = By.xpath("//select[@id='Infertility Sum Insured']");
			
	//  IMAS - International Emergency Medical assistance		
			
			
			private By IMAScovercheckbox = By.xpath("(//input[@type='checkbox'])[19]");
			
			private By IMAScoverlink = By.xpath("//a[contains(text(),'IMAS')]");	
			
			private By IMASgrosspremium = By.xpath("//input[@id='Gross Premium for Life']");
			
	// HPP - Healthy Pregnancy Program		
			
			private By HPPcovercheckbox = By.xpath("(//input[@type='checkbox'])[20]");
			
			private By HPPcoverlink = By.xpath("//a[contains(text(),'HPP')]");
			
			private By HPPdiscount = By.xpath("//input[@id='Discount %']");
	
	// SCOP - Second E - Opinion
			
			
			private By SCOPcovercheckbox = By.xpath("(//input[@type='checkbox'])[21]");
			
			private By SCOPcoverlink = By.xpath("//a[contains(text(),'SCOP')]");
			
			private By SCOPgrosspremiumperlife = By.xpath("//input[@id='Gross Premium for Life']");
			
			
			
			
			
	// STANDALONE Cover		
			
			
			
			private By standaloneCover = By.xpath("//b[contains(text(),'STANDALONE')]");
			
			
	// APHC - Accidental Hospitalisation - Indemnity		
			
			private By APHCcovercheckbox = By.xpath("(//input[@type='checkbox'])[1]");
			
			private By APHCcoverlink = By.xpath("//a[contains(text(),'APHC')]");
			
			private By APHCSI = By.xpath("//input[@id='Applicable Suminsured']");
			
			private By APHCroomtype = By.xpath("//input[@id='Accidental Room Type']");
			
	// AYSH - Ayush treatment (In-patient Hospitalization)	
			
			
			private By AYSHcovercheckbox = By.xpath("(//input[@type='checkbox'])[2]");
			
			private By AYSHCcoverlink = By.xpath("//a[contains(text(),'AYSH')]");
			
			private By  AYSHSI = By.xpath("//input[@id='Applicable Suminsured']");
			
			
	// CHMP - Chronic Management Program		
			
			private By CHMPcovercheckbox = By.xpath("(//input[@type='checkbox'])[3]");
			
			private By CHMPCcoverlink = By.xpath("//a[contains(text(),'CHMP')]");	
			
			private By CHMPmembereligibility = By.xpath("//select[@id='Member Eligibility']");
			
			
	//  HSCB - Hospital Cash Benefit	
			
			
			private By HSCBcovercheckbox = By.xpath("(//input[@type='checkbox'])[7]");
			
			private By HSCBCcoverlink = By.xpath("//a[contains(text(),'HSCB')]");
			
			private By HSCBSIlimitperday = By.xpath("//input[@id='Limit Per Day']");
			
			
	// OPDE - OPD Expenses		
			
			
			private By OPDEcovercheckbox = By.xpath("(//input[@type='checkbox'])[8]");
			
			private By OPDECcoverlink = By.xpath("//a[contains(text(),'OPDE')]");
			
			private By opdexpenceoption = By.xpath("//select[@id='OPD Option']");
			
			private By coPayment = By.xpath("//select[@id='Co Payment']");
			
			
			
	//	WCIC - Worldwide Critical Illness Cover			
			
			
			private By WCICcovercheckbox = By.xpath("(//input[@type='checkbox'])[8]");
			
			private By WCICcoverlink = By.xpath("//a[contains(text(),'WCIC')]");
			
			private By  WCICSI = By.xpath("//input[@id='Applicable Suminsured']");
			
			
	// PSYC - Psychiatric In-patient Care	
			
			
			private By PSYCcovercheckbox = By.xpath("(//input[@type='checkbox'])[10]");
			
			private By PSYCcoverlink = By.xpath("//a[contains(text(),'PSYC')]");
			
			private By  PSYCSI = By.xpath("//input[@id='Psyc Sum Insured']");
			
			
	// Close btn on Covrage List 	
			
			
			private By closebtncover = By.xpath("(//button[contains(text(),'Close')])[1]");
			
			
	// close btn		
			
			private By  closebutton = By.xpath("//button[@id='Close']");
			
			
			
	// Continue btn		
					
			private By  Continue = By.xpath("//button[@id='btncontinue']");
			
	//PlanOpted
			private By PlanOpted = By.xpath("//select[@id='Plan']");
			
	//SubPlan
			
			private By SubPlan = By.xpath("//select[@id='Sub Plan Type']");
			
	//Currency
			
			private By Currency = By.xpath("//select[@id='Currency']");
			
	//HC - Hospita Cash Cover
			
		private By HospitalCashCover= By.xpath("//b[contains(text(),'HC')]");
			
	//AHCB - Accidental Hospital Cash Benefit
		
		private By AHCBcoverlink= By.xpath("//a[contains(text(),'AHCB')]");
		
		private By CoverageLimit_AHCB= By.xpath("(//div[@class='col-xs-14']/preceding::input[@id='Cover Limit'])[1]");
		
		private By DeductibleDays_AHCB= By.xpath("(//div[@class='col-xs-14']/preceding::select[@id='Deductible Days'])[1]");
		
		private By LimitsperHospitalizationClaim_AHCB= By.xpath("(//div[@class='col-xs-14']/preceding::select[@id='Limit Per Hospitalization'])[1]");
		
		private By OneYearWaitingPeriod_AHCB= By.xpath("(//div[@class='col-xs-14']/preceding::select[@id='One Year Waiting Period'])[1]");
		
		private By CoverageLimitICU_AHCB= By.xpath("(//div[@class='col-xs-14']/preceding::input[@id='ICU Coverage SI'])[1]");
		
		private By PerPolicyYearLimitinDays_AHCB= By.xpath("(//div[@class='col-xs-14']/preceding::select[@id='Per Policy Year Limit'])[1]");
		
		private By InitialWaitingPeriod_AHCB= By.xpath("(//div[@class='col-xs-14']/preceding::select[@id='Initial Waiting Period'])[1]");
		
		private By PreExistingDiseasesWaitingPeriod_AHCB= By.xpath("(//div[@class='col-xs-14']/preceding::select[@id='PED waiting period'])[1]");
		
	//MTEX - Maternity Benefit Expense Cover
		
		private By MTEXcoverlink1= By.xpath("//a[contains(text(),'MTEX')]");
		
		private By CoverageOption_MTEX= By.xpath("//select[@id='Coverage Option MTEX']");
				
	//HSCB - Hospital Cash Benefit
			
		private By HSCBcoverlink= By.xpath("//a[contains(text(),'HSCB')]");
		
		private By CoverageLimit_HSCB= By.xpath("(//div[@class='col-xs-14']/preceding::input[@id='Cover Limit'])[2]");
		
		private By DeductibleDays_HSCB= By.xpath("(//div[@class='col-xs-14']/preceding::select[@id='Deductible Days'])[2]");
		
		private By LimitsperHospitalizationClaim_HSCB= By.xpath("(//div[@class='col-xs-14']/preceding::select[@id='Limit Per Hospitalization'])[2]");
		
		private By OneYearWaitingPeriod_HSCB= By.xpath("(//div[@class='col-xs-14']/preceding::select[@id='One Year Waiting Period'])[2]");
		
		private By CoverageLimitICU_HSCB= By.xpath("(//div[@class='col-xs-14']/preceding::input[@id='ICU Coverage SI'])[2]");
		
		private By PerPolicyYearLimitinDays_HSCB= By.xpath("(//div[@class='col-xs-14']/preceding::select[@id='Per Policy Year Limit'])[2]");
		
		private By InitialWaitingPeriod_HSCB= By.xpath("(//div[@class='col-xs-14']/preceding::select[@id='Initial Waiting Period'])[1]");
		
		private By PreExistingDiseasesWaitingPeriod_HSCB= By.xpath("(//div[@class='col-xs-14']/preceding::select[@id='PED waiting period'])[1]");
		
	//PA - Personal Accident Cover
		
		private By PersonalAccidenCover= By.xpath("//b[contains(text(),'PA')]");
	
	//WEAS - Worldwide Emergency Medical Assistance 
		
		private By WEAScoverlink= By.xpath("//a[contains(text(),'WEAS')]");
				
	//TTDB - Temporary Total Disablement (TTD)
		
		private By TTDBcoverlink= By.xpath("//a[contains(text(),'TTDB')]");	
		
		private By LimitPerWeek= By.xpath("//select[@id='Limit Per Week']");
		
		
		
			
	 public EmployeeClassInfoPage (WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			wait = new WebDriverWait(driver, 30);	
		    } 
			
	   public void fillEmployeeClassDetailsPage (WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	    {
	    	String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
	        Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		   Reporter.log("<B>Traverse To EmployeeClassInfoPage</B>");
	    	
		   String ChildWindow2=driver.getWindowHandle();
		   
		   click(Addbtn, "ADD BTN");
		   
			switchToWindow(driver);

		// Category Description
			Thread.sleep(WaitTime.low);	
			clearAndSenKeys(CategoryDescription,dataRow.getProperty("Category Description"),"Category Description");
			Thread.sleep(WaitTime.low);
			
			if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel V2 (5121)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel (2121)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Protect (4224)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Assure - Covid19 (4230)"))
			{
				//Currency
				selectFromDropdownByVisibleText(Currency,dataRow.getProperty("Currency"),"Currency");
			}
			//save btn
			sendTwoKeys(By.cssSelector("body"),Keys.CONTROL, Keys.END,"Body Element");
			click(Save, "Save BTN");
			Thread.sleep(WaitTime.low);
			
			//ok btn
			Thread.sleep(WaitTime.low);
			click(OKBtn, "Ok BTN");
			
			 
			if(dataRow.getProperty("PremiumCalculationBasis").equalsIgnoreCase("Rack Rates")) {
			
			if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health (4211)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health V2 (5211)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel V2 (5121)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel (2121)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Protect (4224)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Assure - Covid19 (4230)"))
			{
			//PED Applicability
			selectFromDropdownByVisibleText(PEDApplicability,dataRow.getProperty("PEDApplicability"),"PED Applicability");
			Thread.sleep(WaitTime.low);
			}
		
			if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Secure (4000)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Assure - Covid19 (4230)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel V2 (5121)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Travel (2121)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Protect (4224)"))
			{
				//Plan Opted
				selectFromDropdownByVisibleText(PlanOpted,dataRow.getProperty("Plan Opted"),"Plan Opted");
				
				//Sub Plan
				selectFromDropdownByVisibleText(SubPlan,dataRow.getProperty("Sub Plan"),"Sub Plan");
			}
			
			
			
			//Base Sum Insured
			clearAndSenKeys(BaseSumInsured,dataRow.getProperty("BaseSumInsured"),"Base Sum Insured");
			Thread.sleep(WaitTime.low);
			
			//save btn
			sendTwoKeys(By.cssSelector("body"),Keys.CONTROL, Keys.END,"Body Element");
			click(Save, "Save BTN");
			Thread.sleep(WaitTime.low);
			
			//ok btn
			Thread.sleep(WaitTime.low);
			click(OKBtn, "Ok BTN");
			
			}
			
			
			
		if(dataRow.getProperty("PremiumCalculationBasis").equalsIgnoreCase("Rack Rates"))
			{
				// Demographic Details
			
			String ChildWindow1=driver.getWindowHandle();
			click(demographicDetails, "Demographic Details BTN");
			switchToWindow(driver);
			Thread.sleep(WaitTime.low);
			
			//from Age
			clearAndSenKeys(fromAge,dataRow.getProperty("fromAge"),"from Age");
			Thread.sleep(WaitTime.low);
			
			//to Age
			clearAndSenKeys(toAge,dataRow.getProperty("toAge"),"to Age");
			Thread.sleep(WaitTime.low);
			
			//relationship_Type
			selectFromDropdownByVisibleText(relationshipType,dataRow.getProperty("relationship_Type"),"relationship Type");
			Thread.sleep(WaitTime.low);
			
			//Gender
			selectFromDropdownByVisibleText(gender,dataRow.getProperty("Gender"),"gender");
			Thread.sleep(WaitTime.low);
			
			//No_Oflives
			clearAndSenKeys(nooflives,dataRow.getProperty("No_Oflives"),"no of lives");
			Thread.sleep(WaitTime.low);
			
			//SumInsured
			clearAndSenKeys(applicableSumInsured,dataRow.getProperty("SumInsured"),"applicable SumInsured");
			Thread.sleep(WaitTime.low);
			
		//	Add row btn
			
			//click(Addrowbtn, "Add row BTN");
			
			// Demographic Details save btn
			click(Save1, "Save BTN");
			Thread.sleep(WaitTime.low);
			
			//ok btn
			click(OKBtn, "Ok BTN");
			
			// Demographic Details close btn
			click(closebtn, "Close BTN");
			
			driver.switchTo().window(ChildWindow1);
			
			
		// Coverage List Details
			
			click(covragelistbtn, "Demographic Details BTN");
			switchToWindow(driver);
			Thread.sleep(WaitTime.low);
			
	    if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health (4211)")||dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Health V2 (5211)"))
		{
	    	
	    	fillEmployeeDetailsGroup_active_healthPage(driver, workbook, conn, customAssert);
			
		//BASE Cover
 			click(BaseCover, "Base cover");
			
			java.util.List<WebElement> list = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[1]/preceding::div[@id='CoverOptional']/ol/div"));
			
			for(int a=0;a<=list.size();a++)
			{
				int b=a+2;
				String txtnm=list.get(a).getText();
				
				if(dataRow.getProperty("IPTT").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("IPTT"))
				{
					//click(By.xpath("//span[contains(text(),'Cover Groups')]//following::input[b]"), "Base Covers");
					driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input[b]")).click();
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				}
				
				if(dataRow.getProperty("RACV_Road Ambulance Expenses").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("RACV"))
				{
					//click(By.xpath("//span[contains(text(),'Cover Groups')]//following::input[b]"), "Base Covers");
					driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input[b]")).click();
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				}
				
			}
			//(//button[contains(text(),'Add')])[1]/preceding::div[@id='CoverOptional']/ol/div["+txtnm+"]/input[1]
//			String covers= driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::div[@class='coverstyle ng-binding ng-scope'][1]")).getText();			
//			System.out.println(covers);
			
			
			
			
			
			
			
			
			
			
			
		// 	Click on IPTTcover
			click(IPTTcovercheckbox,"RACV CheckBOX");
			Thread.sleep(WaitTime.low);
			
			click(Addcoverbtn,"ADD Button");
			boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
			if (okBTNIPTT == true) {
				click(OKBtn,"OK");
			}
			
		// Click on RACVcover
			click(RACVcovercheckbox,"RACV CheckBOX");
			
			click(Addcoverbtn,"ADD Button");
			boolean okBTNRACV = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
			if (okBTNRACV == true) {
				click(OKBtn,"OK");
			}
			
		// Click On POHMcover & PRHMcover
			click(POHMcovercheckbox,"RACV CheckBOX");
			click(PRHMcovercheckbox,"RACV CheckBOX");
			click(Addcoverbtn,"ADD Button");
			boolean okBTN_POHM_PRHM = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
			if (okBTN_POHM_PRHM == true) {
				click(OKBtn,"OK");
			}
			
		// Click On DCTTcover & DCHScover
			click(DCTTcovercheckbox,"RACV CheckBOX");
			click(DCHScovercheckbox,"RACV CheckBOX");
			click(Addcoverbtn,"ADD Button");
			boolean okBTN_DCTT_DCHS = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
			if (okBTN_DCTT_DCHS == true) {
				click(OKBtn,"OK");
			}
			
		//RACV - Road Ambulance Expenses
			
			if(dataRow.getProperty("RACV_Road Ambulance Expenses").equalsIgnoreCase("Yes"))
			{
//				click(RACVcovercheckbox,"RACV CheckBOX");
//				
//				click(Addcoverbtn,"ADD Button");
//				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
//				if (okBTN == true) {
//					click(OKBtn,"OK");
//				}

				click(RACVcoverlink,"RACV Checkllink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(RoadAmbulanceOptiondropdown, dataRow.getProperty("RoadAmbulanceOption")," BNBE SumInsured ");
				Thread.sleep(WaitTime.low);
				
				if(dataRow.getProperty("RoadAmbulanceOption").equalsIgnoreCase("Absolute Amount"))
				{
				selectFromDropdownByVisibleText(absoluteAmount, dataRow.getProperty("AbsoluteAmount")," absolute Amount ");
				Thread.sleep(WaitTime.low);
				}
				
				if(dataRow.getProperty("RoadAmbulanceOption").equalsIgnoreCase("% of Sum Insured"))
				{
				selectFromDropdownByVisibleText(perOfsumInsured, dataRow.getProperty("PerOfsumInsured"),"per Of sum Insured ");
				Thread.sleep(WaitTime.low);
				}
				
			
				
				}
			
			//POHM - Post-hospitalization Medical Expenses
			
			if(dataRow.getProperty("POHM").equalsIgnoreCase("Yes"))
			{
//				click(POHMcovercheckbox,"RACV CheckBOX");
//				
//				click(Addcoverbtn,"ADD Button");
//				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
//				if (okBTN == true) {
//					click(OKBtn,"OK");
//				}

				click(POHMcoverlink,"POHM Checkllink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(Posthospitalizationdropdown, dataRow.getProperty("Post hospitalization")," BNBE SumInsured ");
				Thread.sleep(WaitTime.low);
				

				
			}
			
			if(dataRow.getProperty("PRHM").equalsIgnoreCase("Yes"))
			{
//				click(PRHMcovercheckbox,"RACV CheckBOX");
//				Thread.sleep(WaitTime.low);
//				
//				click(Addcoverbtn,"ADD Button");
//				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
//				if (okBTN == true) {
//					click(OKBtn,"OK");
//				}

				click(PRHMPrecoverlink,"PRHM Pre coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(Prehospitalizationdropdown, dataRow.getProperty("Pre hospitalization")," BNBE SumInsured ");
				Thread.sleep(WaitTime.low);
				
		
			}
			
			

			if(dataRow.getProperty("DCHS").equalsIgnoreCase("Yes"))
			{
//				click(DCHScovercheckbox,"RACV CheckBOX");
//				Thread.sleep(WaitTime.low);
//				
//				click(Addcoverbtn,"ADD Button");
//				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
//				if (okBTN == true) {
//					click(OKBtn,"OK");
//				}

				click(DCHScoverlink,"PRHM Pre coverlink");
				Thread.sleep(WaitTime.low);
				
//				clearAndSenKeys(DCHSSI,dataRow.getProperty("DCHSSI"),"DCHS SI");
				Thread.sleep(WaitTime.low);
				
			
			}
			
			
			
			if(dataRow.getProperty("IPTT").equalsIgnoreCase("Yes"))
			{
//				click(IPTTcovercheckbox,"RACV CheckBOX");
//				Thread.sleep(WaitTime.low);
//				
//				click(Addcoverbtn,"ADD Button");
//				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
//				if (okBTN == true) {
//					click(OKBtn,"OK");
//				}

				click(IPTTcoverlink,"PRHM Pre coverlink");
				Thread.sleep(WaitTime.low);
				
//				clearAndSenKeys(IPTTSI,dataRow.getProperty("IPTTSI"),"DCHS SI");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(CoverageOptiondropdown, dataRow.getProperty("CoverageOptiondropdown")," BNBE SumInsured ");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(ICUCoveragedropdown, dataRow.getProperty("ICUCover"),"ICU SumInsured ");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(roomtypedropdown, dataRow.getProperty("Roomtype"),"ICU SumInsured ");
				Thread.sleep(WaitTime.low);
				
			
			}
			
			// DCTT - Day Care Treatment
			
			if(dataRow.getProperty("DCTT").equalsIgnoreCase("Yes"))
			{
//				click(DCTTcovercheckbox,"RACV CheckBOX");
//				Thread.sleep(WaitTime.low);
//				
//				click(Addcoverbtn,"ADD Button");
//				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
//				if (okBTN == true) {
//					click(OKBtn,"OK");
//				}

				click(DCTTcoverlink,"PRHM Pre coverlink");
				
				
				
			}
			
			if(dataRow.getProperty("ORDR").equalsIgnoreCase("Yes"))
			{
				click(ORDRcovercheckbox,"ORDR CheckBOX");
				Thread.sleep(WaitTime.low);
				
				click(Addcoverbtn,"ADD Button");
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
				}

				click(ORDRcoverlink,"PRHM Pre coverlink");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(ORDRSI,dataRow.getProperty("ORDRSI"),"DCHS SI");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(ORDRpremiumrate,dataRow.getProperty("ORDRPRemiumRate"),"DCHS SI");
				Thread.sleep(WaitTime.low);
				
			
				
			}
			
			// Save button
			
			click(savebasecoverbtn,"Save btn");
			Thread.sleep(WaitTime.low);
			
			// Ok btn
			
			Thread.sleep(WaitTime.low);
			click(OKBtn,"OK");
			
			
			
			
	// Optional Cover
			
			 
			click(optionalCover, "Base cover");
			
			//SPOR - Sports Activity Cover
			
			if(dataRow.getProperty("SPOR").equalsIgnoreCase("Yes"))
			{
				click(SPORcovercheckbox,"SPOR CheckBOX");
				Thread.sleep(WaitTime.low);
				
				click(Addcoverbtn,"ADD Button");
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
				}

				click(SPORcoverlink,"SPOR coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(sportsEligibility, dataRow.getProperty("Sports Eligibility"),"Sports Eligibility ");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
				
			}
			
			
		// UMM - Ultra Modern Medicine	
			if(dataRow.getProperty("UMM").equalsIgnoreCase("Yes"))
			{
				click(UMMcovercheckbox,"SPOR CheckBOX");
				Thread.sleep(WaitTime.low);
				
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
				}

				click(UMMcoverlink,"SPOR coverlink");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(UMMSI,dataRow.getProperty("UMMSI"),"UMM SI");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
				
			}
			 
		// VCCV - Vaccination Expenses	
			
			if(dataRow.getProperty("VCCV").equalsIgnoreCase("Yes"))
			{
				click(VCCVcovercheckbox,"VCCV CheckBOX");
				Thread.sleep(WaitTime.low);
				
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
				}

				click(VCCVcoverlink,"VCCV coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(VCCVSI,dataRow.getProperty("VCCVSI"),"VCCV SI");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
			}
			 
			
		// WELL - Wellmother Cover	
			
					
			if(dataRow.getProperty("WELL").equalsIgnoreCase("Yes"))
			{
				click(WELLcovercheckbox,"WELL CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(WELLcoverlink,"WELL coverlink");
				Thread.sleep(WaitTime.low);
								
				clearAndSenKeys(wellloading,dataRow.getProperty("WellLoading"),"WELL Loading");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
								
			}
			
		// WLI - Wellness Coach	
			
			if(dataRow.getProperty("WLI").equalsIgnoreCase("Yes"))
			{
				click(WLIcovercheckbox,"WLI CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(WLIcoverlink,"WLI coverlink");
				Thread.sleep(WaitTime.low);
								
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
			}
			
	//   FTAS - Fitness Assessment		
			
			if(dataRow.getProperty("FTAS").equalsIgnoreCase("Yes"))
			{
				click(FTAScovercheckbox,"WLI CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(FTAScoverlink,"WLI coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(frequencyperyear,dataRow.getProperty("VCCVSI"),"Frequency per Policy Year");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(noOfassenssmentPerSession,dataRow.getProperty("VCCVSI"),"No Of Asenssement per session");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
			}
		
	// EXCA - External Congenital Anomaly	
			
			if(dataRow.getProperty("EXCA").equalsIgnoreCase("Yes"))
			{
				click(EXCAcovercheckbox,"EXCA CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(EXCAcoverlink,"EXCA coverlink");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(EXCASI,dataRow.getProperty("EXCASI"),"EXCA Sum insured");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
			}
			
			
	// HLTCH - Health Check-up Program	
			
			if(dataRow.getProperty("HLTCH").equalsIgnoreCase("Yes"))
			{
				click(HLTCHcovercheckbox,"HLTCH CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(HLTCHcoverlink,"HLTCH coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(checkuplimit,dataRow.getProperty("checkuplimit"),"check up limit");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
			}
			
	// DMAS - Domestic Emergency Medical assistance		
			
			if(dataRow.getProperty("DMAS").equalsIgnoreCase("Yes"))
			{
				click(DMAScovercheckbox,"DMAS CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(DMAScoverlink,"DMAS coverlink");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(grosspremium,dataRow.getProperty("Gross Premium"),"Gross Premium");
				Thread.sleep(WaitTime.low);

				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
				
			}
			
			
	//  HLTHA - Health Assessment		
			
			
			if(dataRow.getProperty("HLTHA").equalsIgnoreCase("Yes"))
			{
				click(HLTHAcovercheckbox,"HLTHA CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(HLTHAcoverlink,"HLTHA coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(membereligibility,dataRow.getProperty("MemberEligibility"),"Member Eligibility");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
				
			}
		
	// DCLC - Daily cash for choosing lower category room		
			
			if(dataRow.getProperty("DCLC").equalsIgnoreCase("Yes"))
			{
				click(DCLCcovercheckbox,"DCLC CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(DCLCcoverlink,"DCLC coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(membereligibility,dataRow.getProperty("MemberEligibility"),"Member Eligibility");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(premiumrate,dataRow.getProperty("Premium Rate"),"DCLC Premium Rate");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
			}
			
	//   HLTHRET - HealthReturns TM		
			
			if(dataRow.getProperty("HLTHRET").equalsIgnoreCase("Yes"))
			{
				click(HLTHRETcovercheckbox,"HLTHRET CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(HLTHRETcoverlink,"HLTHRET coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(healthReturnsLimit,dataRow.getProperty("Earned Benefits Split"),"Earned Benefits Split");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(healthReturnUtilizationPeriod,dataRow.getProperty("Health Return Utilization Period"),"Health Return Utilization Period");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(earnedBenefitsSplit,dataRow.getProperty("Earned Benefits Split"),"Earned Benefits Split");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
			}
			
	// RVBE - Recovery Benefit
			
			if(dataRow.getProperty("RVBE").equalsIgnoreCase("Yes"))
			{
				click(RVBEcovercheckbox,"RVBE CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(RVBEcoverlink,"RVBE coverlink");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(RVBESI,dataRow.getProperty("RVBESI"),"RVBESI");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
				
			}
			
	// NBBE - New Born Baby Expenses	
			
			if(dataRow.getProperty("NBBE").equalsIgnoreCase("Yes"))
			{
				click(NBBEcovercheckbox,"NBBE CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(NBBEcoverlink,"NBBE coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(coverageoption,dataRow.getProperty("Coverage Option"),"Coverageoption");
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
			}
			
	//  MTEX - Maternity Benefit		
			
			if(dataRow.getProperty("MTEX").equalsIgnoreCase("Yes"))
			{
				click(MTEXcovercheckbox,"MTEX CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(MTEXcoverlink,"MTEX coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(MTEXcoverageoption,dataRow.getProperty("MTEX coverage Option"),"MTEXcoverageoption");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
			}
			
			
	// INFR - Infertility Treatment		
			
			if(dataRow.getProperty("INFR").equalsIgnoreCase("Yes"))
			{
				click(INFRcovercheckbox,"INFR CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(INFRcoverlink,"INFR coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(INFRSI,dataRow.getProperty("INFRSI"),"INFRSI");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
			}
			
	//  IMAS - International Emergency Medical assistance		
			
			if(dataRow.getProperty("IMAS").equalsIgnoreCase("Yes"))
			{
				click(IMAScovercheckbox,"IMAS CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(IMAScoverlink,"IMAS coverlink");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(IMASgrosspremium,dataRow.getProperty("IMAS Gross Premium"),"IMAS gross premium");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
			}
			
	// HPP - Healthy Pregnancy Program		
			
			
			if(dataRow.getProperty("HPP").equalsIgnoreCase("Yes"))
			{
				click(HPPcovercheckbox,"HPP CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(HPPcoverlink,"HPP coverlink");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(HPPdiscount,dataRow.getProperty("HPP Discount"),"HPP Discount");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
			}
			
			
	// SCOP - Second E - Opinion
			
			if(dataRow.getProperty("SCOP").equalsIgnoreCase("Yes"))
			{
				click(SCOPcovercheckbox,"SCOP CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(SCOPcoverlink,"SCOP coverlink");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SCOPgrosspremiumperlife,dataRow.getProperty("SCOP Gross Premium Per Life "),"SCOP Gross Premium Per Life");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				
			}
			
			
	// Save button
			//Thread.sleep(WaitTime.low);
			//click(savebasecoverbtn,"Save btn");
			
	// Ok btn
			//Thread.sleep(WaitTime.low);
			//click(OKBtn,"OK");
			
	
	// STANDALONE Cover
			
			
			click(standaloneCover, "Base cover");
			Thread.sleep(WaitTime.low);
			
	// APHC - Accidental Hospitalisation - Indemnity
			
			if(dataRow.getProperty("APHC").equalsIgnoreCase("Yes"))
			{
				click(APHCcovercheckbox,"APHC CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(APHCcoverlink,"APHC coverlink");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(APHCSI,dataRow.getProperty("APHCSI"),"APHC SI");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(APHCroomtype,dataRow.getProperty("APHC Romm Type"),"APHC room type");
				Thread.sleep(WaitTime.low);
			
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
			}
			
			
	// AYSH - Ayush treatment (In-patient Hospitalization)		
			
			
			if(dataRow.getProperty("AYSH").equalsIgnoreCase("Yes"))
			{
				click(AYSHcovercheckbox,"AYSH CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(AYSHCcoverlink,"AYSH coverlink");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(AYSHSI,dataRow.getProperty("AYSHSI"),"AYSH SI");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
			}
			
	// CHMP - Chronic Management Program		
			
			if(dataRow.getProperty("CHMP").equalsIgnoreCase("Yes"))
			{
				click(CHMPcovercheckbox,"CHMP CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(CHMPCcoverlink,"CHMP coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(CHMPmembereligibility,dataRow.getProperty("CHMP Member Eligibility"),"CHMP member eligibility");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
			}
			
			
	//  HSCB - Hospital Cash Benefit		
			
			if(dataRow.getProperty("HSCB").equalsIgnoreCase("Yes"))
			{
				click(HSCBcovercheckbox,"HSCB CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(HSCBCcoverlink,"HSCB coverlink");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(HSCBSIlimitperday,dataRow.getProperty("SI_LimitPerDay"),"HSCB SI Per Day");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
			}
			
	
	// OPDE - OPD Expenses
			
			
			if(dataRow.getProperty("HSCB1").equalsIgnoreCase("Yes"))
			{
				click(OPDEcovercheckbox,"OPDE CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(OPDECcoverlink,"OPDE coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(opdexpenceoption,dataRow.getProperty("HSCB_OPD_Expence_Option"),"Opd Expence Option");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(coPayment,dataRow.getProperty("CO_Payment"),"Co Payment");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
			}
			
			
	//	WCIC - Worldwide Critical Illness Cover		
			
			
			if(dataRow.getProperty("WCIC").equalsIgnoreCase("Yes"))
			{
				click(WCICcovercheckbox,"WCIC CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(WCICcoverlink,"WCIC coverlink");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(WCICSI,dataRow.getProperty("WCICSI"),"WCICSI");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
			}
			
			
	// PSYC - Psychiatric In-patient Care		
		
			if(dataRow.getProperty("PSYC").equalsIgnoreCase("Yes"))
			{
				click(PSYCcovercheckbox,"PSYC CheckBOX");
				Thread.sleep(WaitTime.low);
								
				click(Addcoverbtn,"ADD Button");
				Thread.sleep(WaitTime.low);
				boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTN == true) {
					click(OKBtn,"OK");
					}
	
				click(PSYCcoverlink,"PSYC coverlink");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(PSYCSI,dataRow.getProperty("PSYCSI"),"PSYCSI");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
			}
			
	// Close btn		
			Thread.sleep(WaitTime.low);
			click(closebtncover,"Close btn on cover");	
			driver.switchTo().window(ChildWindow1);
	
	}
	
	
	if(dataRow.getProperty("Product").equalsIgnoreCase("Group Activ Secure (4000)"))
	{
		//Click on HC - Hospita Cash Cover
		
		click(HospitalCashCover, "HC - Hospita Cash Cover");
		

		if(dataRow.getProperty("AHCB - Accidental Hospital Cash Benefit").equalsIgnoreCase("Yes"))
		{
			
			click(Addcoverbtn,"ADD Button");
			Thread.sleep(WaitTime.low);
			boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
			if (okBTN == true) {
				click(OKBtn,"OK");
				}
			
			click(AHCBcoverlink,"AHCB coverlink");
			Thread.sleep(WaitTime.low);
			
			clearAndSenKeys(CoverageLimit_AHCB,dataRow.getProperty("Coverage Limit_AHCB"),"Coverage Limit");
			Thread.sleep(WaitTime.low);
			
			selectFromDropdownByVisibleText(DeductibleDays_AHCB,dataRow.getProperty("Deductible Days_AHCB"),"Deductible Days");
			Thread.sleep(WaitTime.low);
			
			selectFromDropdownByVisibleText(LimitsperHospitalizationClaim_AHCB,dataRow.getProperty("Limits per Hospitalization Claim_AHCB"),"Limits per Hospitalization Claim");
			Thread.sleep(WaitTime.low);
			
			clearAndSenKeys(OneYearWaitingPeriod_AHCB,dataRow.getProperty("One Year Waiting Period_AHCB"),"One Year Waiting Period");
			Thread.sleep(WaitTime.low);
			
			clearAndSenKeys(CoverageLimitICU_AHCB,dataRow.getProperty("Coverage Limit- ICU_AHCB"),"Coverage Limit- ICU");
			Thread.sleep(WaitTime.low);
			
			selectFromDropdownByVisibleText(PerPolicyYearLimitinDays_AHCB,dataRow.getProperty("Per Policy Year Limit in Days_AHCB"),"Per Policy Year Limit in Days");
			Thread.sleep(WaitTime.low);
		
			selectFromDropdownByVisibleText(InitialWaitingPeriod_AHCB,dataRow.getProperty("Initial Waiting Period_AHCB"),"Initial Waiting Period");
			Thread.sleep(WaitTime.low);
			selectFromDropdownByVisibleText(PreExistingDiseasesWaitingPeriod_AHCB,dataRow.getProperty("Pre- Existing Diseases Waiting Period_AHCB"),"Pre- Existing Diseases Waiting Period");
			Thread.sleep(WaitTime.low);
			
			click(savebasecoverbtn,"Save btn");
			Thread.sleep(WaitTime.low);
			
			click(OKBtn,"OK");
			Thread.sleep(WaitTime.low);
			
			
		}
		
		if(dataRow.getProperty("MTEX - Maternity Benefit Expense Cover").equalsIgnoreCase("Yes"))
		{
			
			click(Addcoverbtn,"ADD Button");
			Thread.sleep(WaitTime.low);
			boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
			if (okBTN == true) {
				click(OKBtn,"OK");
				}
			
			click(MTEXcoverlink1,"MTEX coverlink");
			Thread.sleep(WaitTime.low);
			
			selectFromDropdownByVisibleText(CoverageOption_MTEX,dataRow.getProperty("Coverage Option_MTEX"),"Coverage Option");
			Thread.sleep(WaitTime.low);
			
			click(savebasecoverbtn,"Save btn");
			Thread.sleep(WaitTime.low);
			
			click(OKBtn,"OK");
			Thread.sleep(WaitTime.low);
			
			
			
		}
			
		if(dataRow.getProperty("HSCB - Hospital Cash Benefit").equalsIgnoreCase("Yes"))
		{
			click(Addcoverbtn,"ADD Button");
			Thread.sleep(WaitTime.low);
			boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
			if (okBTN == true) {
				click(OKBtn,"OK");
				}
			
			
			
			click(HSCBcoverlink,"HSCB coverlink");
			Thread.sleep(WaitTime.low);
			
			clearAndSenKeys(CoverageLimit_HSCB,dataRow.getProperty("Coverage Limit_HSCB"),"Coverage Limit");
			Thread.sleep(WaitTime.low);
			
			selectFromDropdownByVisibleText(DeductibleDays_HSCB,dataRow.getProperty("Deductible Days_HSCB"),"Deductible Days");
			Thread.sleep(WaitTime.low);
			
			selectFromDropdownByVisibleText(LimitsperHospitalizationClaim_HSCB,dataRow.getProperty("Limits per Hospitalization Claim_HSCB"),"Limits per Hospitalization Claim");
			Thread.sleep(WaitTime.low);
			
			clearAndSenKeys(OneYearWaitingPeriod_HSCB,dataRow.getProperty("One Year Waiting Period_HSCB"),"One Year Waiting Period");
			Thread.sleep(WaitTime.low);
			
			clearAndSenKeys(CoverageLimitICU_HSCB,dataRow.getProperty("Coverage Limit- ICU_HSCB"),"Coverage Limit- ICU");
			Thread.sleep(WaitTime.low);
			
			selectFromDropdownByVisibleText(PerPolicyYearLimitinDays_HSCB,dataRow.getProperty("Per Policy Year Limit in Days_HSCB"),"Per Policy Year Limit in Days");
			Thread.sleep(WaitTime.low);
		
			selectFromDropdownByVisibleText(InitialWaitingPeriod_HSCB,dataRow.getProperty("Initial Waiting Period_HSCB"),"Initial Waiting Period");
			Thread.sleep(WaitTime.low);
			selectFromDropdownByVisibleText(PreExistingDiseasesWaitingPeriod_HSCB,dataRow.getProperty("Pre- Existing Diseases Waiting Period_HSCB"),"Pre- Existing Diseases Waiting Period");
			Thread.sleep(WaitTime.low);
			
			click(savebasecoverbtn,"Save btn");
			Thread.sleep(WaitTime.low);
			
			click(OKBtn,"OK");
			Thread.sleep(WaitTime.low);
			
			
			
		}
			
		
		//Click on PA - Personal Accident
		
				click(PersonalAccidenCover, "PA - Personal Accident");
				
				if(dataRow.getProperty("WEAS - Worldwide Emergency Medical Assistance").equalsIgnoreCase("Yes"))
				{
					
					click(Addcoverbtn,"ADD Button");
					Thread.sleep(WaitTime.low);
					boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTN == true) {
						click(OKBtn,"OK");
						}
					
					click(WEAScoverlink,"WEAS coverlink");
					Thread.sleep(WaitTime.low);
					
					click(savebasecoverbtn,"Save btn");
					Thread.sleep(WaitTime.low);
					
					click(OKBtn,"OK");
					Thread.sleep(WaitTime.low);
					
				}
				
				if(dataRow.getProperty("TTDB - Temporary Total Disablement (TTD)").equalsIgnoreCase("Yes"))
				{
				
					click(Addcoverbtn,"ADD Button");
					Thread.sleep(WaitTime.low);
					boolean okBTN = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTN == true) {
						click(OKBtn,"OK");
						}
					
					click(TTDBcoverlink,"TTDB coverlink");
					Thread.sleep(WaitTime.low);
					
					
					
					
					
					
				}
				
				
				
				
	}
	}
			
	// Save btn		
			sendTwoKeys(By.cssSelector("body"),Keys.CONTROL, Keys.END,"Body Element");
			click(Save, "Save BTN");
			Thread.sleep(WaitTime.low);
			
			//ok btn
			Thread.sleep(WaitTime.low);
			click(OKBtn, "Ok BTN");
			
	// Close btn
			click(closebutton,"Close button");
			
			driver.switchTo().window(ChildWindow2);
	 		switchtodefaultframe(driver);
	 		switchtoframe(driver, "display"); 
	 		switchtoframe(driver, "containerFrame");
	// Continue btn	
			click(Continue,"Continue button");

	    } 
	    
}
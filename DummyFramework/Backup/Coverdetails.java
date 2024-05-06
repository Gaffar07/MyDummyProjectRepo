package GroupPages;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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

public class Coverdetails extends GenericMethods{
	
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
		
//		Base Sum Insured
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

				private String testCaseName;

				private String stepGroup;
				
		// Optional Cover
				
				private By optionalCover = By.xpath("//b[contains(text(),'Optional')]");
		
		//HLTHRET - HealthReturns TM
				
				private By HLTHRETcoverlink = By.xpath("//a[contains(text(),'HLTHRET')]");
				
				private By healthReturnsLimit = By.xpath("//select[@id='HealthReturns Limit']");
				
				private By healthReturnUtilizationPeriod = By.xpath("//select[@id='Health Return Utilization Period']");
				
				private By earnedBenefitsSplit = By.xpath("//select[@id='Earned Benefit Split']");
				
		//HPP - Healthy Pregnancy Program
				
				private By HPPcoverlink = By.xpath("//a[contains(text(),'HPP')]");
				
				private By HPPdiscount = By.xpath("//input[@id='Discount %']");
				
		//HLTHA - Health Assessment
				
				private By HLTHAcoverlink = By.xpath("//a[contains(text(),'HLTHA')]");
				
				private By membereligibility = By.xpath("//select[@id='Member Coverage Option']");
			
		//HLTCH - Health Check-up Program
				
				private By HLTCHcoverlink = By.xpath("//a[contains(text(),'HLTCH')]");
				
				private By checkuplimit = By.xpath("//select[@id='Checkup Limit']");
				
		// FTAS - Fitness Assessment
				
				private By FTAScoverlink = By.xpath("//a[contains(text(),'FTAS')]");	
				
				private By frequencyperyear = By.xpath("//select[@id='Frequency Per Year']");
				
				private By noOfassenssmentPerSession = By.xpath("//select[@id='Assessments Per Session']");
				
		//EXCA - External Congenital Anomaly
				
				private By EXCAcoverlink = By.xpath("//a[contains(text(),'EXCA')]");
				
				private By EXCASI = By.xpath("//input[@id='Applicable Suminsured']");
				
		// DMAS - Domestic Emergency Medical assistance		
				
				private By DMAScoverlink = By.xpath("//a[contains(text(),'DMAS')]");
				
				private By grosspremium = By.xpath("//input[@id='Gross Premium for Life']");
				
		//DCLC - Daily cash for choosing lower category room
				
				private By DCLCcoverlink = By.xpath("//a[contains(text(),'DCLC')]");
				
				private By premiumrate = By.xpath("//input[@id='Premium Rate']");
		
		// IMAS - International Emergency Medical assistance
				

				private By IMAScoverlink = By.xpath("//a[contains(text(),'IMAS')]");	
				
				private By IMASgrosspremium = By.xpath("//input[@id='Gross Premium for Life']");
				
		//WLI - Wellness Coach
				
				private By WLIcoverlink = By.xpath("//a[contains(text(),'WLI')]");
		
		// WELL - Wellmother Cover
				
				private By WELLcoverlink = By.xpath("//a[contains(text(),'WELL')]");
				
				private By wellloading = By.xpath("//input[@id='Loading %']");
				
		//VCCV - Vaccination Expenses
				
				private By VCCVcoverlink = By.xpath("//a[contains(text(),'VCCV')]");
				
				private By VCCVSI = By.xpath("//select[@id='Vaccination Sum Insured']");
				
		//UMM - Ultra Modern Medicine
				
				private By UMMcoverlink = By.xpath("//a[contains(text(),'UMM')]");
				
				
				private By UMMSI = By.xpath("//input[@id='Applicable Suminsured']");
		
		//SPOR - Sports Activity Cover
				
				private By SPORcoverlink = By.xpath("//a[contains(text(),'SPOR')]");
				
				private By sportsEligibility = By.xpath("//input[@id='Sports Eligibility']");
		
		// SCOP - Second E - Opinion
				
				private By SCOPcoverlink = By.xpath("//a[contains(text(),'SCOP')]");
				
				private By SCOPgrosspremiumperlife = By.xpath("//input[@id='Gross Premium for Life']");
				
		//INFR - Infertility Treatment
				
				private By INFRcoverlink = By.xpath("//a[contains(text(),'INFR')]");
				
				private By INFRSI = By.xpath("//select[@id='Infertility Sum Insured']");
				
				
	// MTEX - Maternity Benefit	
						
				private By MTEXcovercheckbox = By.xpath("(//input[@type='checkbox'])[17]");
						
				private By MTEXcoverlink = By.xpath("//a[contains(text(),'MTEX')]");
						
			    private By MTEXcoverageoption = By.xpath("//select[@id='Coverage Option MTEX']");
			
		//NBBE - New Born Baby Expenses		
				
				private By NBBEcoverlink = By.xpath("//a[contains(text(),'NBBE')]");
				
				private By coverageoption = By.xpath("//select[@id='Coverage option4']");
		
		//RVBE - Recovery Benefit
				
				private By RVBEcoverlink = By.xpath("//a[contains(text(),'HLTHRET')]");
				
				private By RVBESI = By.xpath("//input[@id='Recovery Sum Insured']");
				
	    // Standalone Cover
			
				private By standaloneCover = By.xpath("//b[contains(text(),'STANDALONE')]");
				
				
		//AYSH - Ayush treatment (In-patient Hospitalization)
				
				private By AYSHCcoverlink = By.xpath("//a[contains(text(),'AYSH')]");
				
				private By  AYSHSI = By.xpath("//input[@id='Applicable Suminsured']");
				
		//APHC - Accidental Hospitalisation - Indemnity
				
				private By APHCcoverlink = By.xpath("//a[contains(text(),'APHC')]");
				
				private By APHCSI = By.xpath("//input[@id='Applicable Suminsured']");
				
				private By APHCroomtype = By.xpath("//input[@id='Accidental Room Type']");
		
				
		//PSYC - Psychiatric In-patient Care
				
				private By PSYCcoverlink = By.xpath("//a[contains(text(),'PSYC')]");
				
				private By  PSYCSI = By.xpath("//input[@id='Psyc Sum Insured']");
				
			
		// OPDE - OPD Expenses
			
				private By OPDECcoverlink = By.xpath("//a[contains(text(),'OPDE')]");
				
				private By opdexpenceoption = By.xpath("//select[@id='OPD Option']");
				
				private By coPayment = By.xpath("//select[@id='Co Payment']");
				
				
		//HSCB - Hospital Cash Benefit	
				
				private By HSCBCcoverlink = By.xpath("//a[contains(text(),'HSCB')]");
				
				private By HSCBSIlimitperday = By.xpath("//input[@id='Limit Per Day']");
				
				
		// CHMP - Chronic Management Program
				
				private By CHMPCcoverlink = By.xpath("//a[contains(text(),'CHMP')]");	
				
				private By CHMPmembereligibility = By.xpath("//select[@id='Member Eligibility']");
				
		// WCIC - Worldwide Critical Illness Cover
				
				private By WCICcoverlink = By.xpath("//a[contains(text(),'WCIC')]");
				
				private By  WCICSI = By.xpath("//input[@id='Applicable Suminsured']");
				
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
				
	//MTEX - Maternity Benefit Expense Cover
				
				private By MTEXcoverlink1= By.xpath("//a[contains(text(),'MTEX')]");
				
				private By CoverageOption_MTEX= By.xpath("//select[@id='Coverage Option MTEX']");
				
   //PA - Personal Accident
				
				private By PersonalAccidentCover= By.xpath("//b[contains(text(),'PA')]");			
				
  //CSI - Cost of Support Items
				
				private By CSIcoverlink= By.xpath("//a[contains(text(),'CSI')]");
				
				private By  SumInsured_CSI = By.xpath("//input[@id='Cover Limit']");
				
  //DB - Disappearance Benefit
				
				private By DBcoverlink= By.xpath("//a[contains(text(),'Disappearance Benefit')]");
				
				private By  SumInsured_DB = By.xpath("//input[@id='Cover Limit']");
				
  //DPPE - Damage to Personal Protective Equipment
				
				private By DPPEcoverlink= By.xpath("//a[contains(text(),'DPPE')]");
				
				private By  SumInsured_DPPE = By.xpath("//input[@id='Cover Limit']");
				
	//EDBC - Education Fund for Children
				
				private By EDBCcoverlink= By.xpath("//a[contains(text(),'EDBC')]");
				
				private By  SumInsured_EDBC = By.xpath("//input[@id='Cover Limit']");
				
	//FUEX - Funeral Expenses
				
				private By FUEXcoverlink= By.xpath("//a[contains(text(),'FUEX')]");
				
				private By  SumInsured_FUEX = By.xpath("//input[@id='Cover Limit']");
				
	//HVMB - Modification Benefit (Residence)			
				
				private By HVMBcoverlink= By.xpath("//a[contains(text(),'HVMB')]");
				
				private By  SumInsured_HVMB = By.xpath("//input[@id='Cover Limit']");
				
	//HVMB1 - Modification Benefit (Vehicle)			
				
				private By HVMB1coverlink= By.xpath("//a[contains(text(),'HVMB1')]");
				
				private By  SumInsured_HVMB1 = By.xpath("//input[@id='Cover Limit']");
				
	//LOJ - Loss of Job		
				
				private By LOJcoverlink= By.xpath("//a[contains(text(),'LOJ')]");
				
				private By EmploymentType= By.xpath("//select[@id='Type of Employment']");
				
				private By SalaryInformationAvailable= By.xpath("//select[@id='Salary Info Available']");
				
				private By  SalaryPerMonth = By.xpath("//input[@id='Salary Per Month']");
				
	//ME - Medical Expenses
				
				
				private By MEcoverlink= By.xpath("//a[contains(text(),'ME')]");
				
				private By CoverPercentage= By.xpath("//select[@id='Cover Percentage']");
				
				private By RoomType= By.xpath("//select[@id='Room Type']");
				
	//MFC1 - Marriage Fund for Children
				
				private By MFC1coverlink= By.xpath("//a[contains(text(),'MFC1')]");
				
				private By  SumInsured_MFC1 = By.xpath("//input[@id='Cover Limit']");
				
				
	//OPDE - Out-patient Expenses
				
				private By OPDEcoverlink= By.xpath("//a[contains(text(),'OPDE')]");
				
				private By  SumInsured_OPDE = By.xpath("//input[@id='Cover Limit']");	
				
	//ORBF - Orphan Benefit for Children
				
				private By ORBFcoverlink= By.xpath("//a[contains(text(),'ORBF')]");
				
				private By  SumInsured_ORBF = By.xpath("//input[@id='Cover Limit']");	
				
	//PPDB - Permanent Partial Disablement (PPD)
				
				private By PPDBcoverlink= By.xpath("//a[contains(text(),'PPDB')]");
				
				private By  SumInsured_PPDB = By.xpath("//input[@id='Cover Limit']");	
				
	//PTDB - Permanent Total Disablement (PTD)
				
				private By PTDBcoverlink= By.xpath("//a[contains(text(),'PTDB')]");
				
				private By  SumInsured_PTDB = By.xpath("//input[@id='Cover Limit']");
				
				
	//RACB - Road Ambulance Cover
				
				private By RACBcoverlink= By.xpath("//a[contains(text(),'RACB')]");
				
				private By  SumInsured_RACB = By.xpath("//input[@id='Cover Limit']");
				
	//RCB1 - Rehabilitation/ Counseling Benefit			
				
				private By RCB1coverlink= By.xpath("//a[contains(text(),'RCB1')]");
				
				private By  SumInsured_RCB1 = By.xpath("//input[@id='Cover Limit']");
				
	//RERE - Repatriation of Mortal Remains			
				
				private By REREcoverlink= By.xpath("//a[contains(text(),'RERE')]");
				
				private By  SumInsured_RERE = By.xpath("//input[@id='Cover Limit']");
				
				
	//RVBE - Recovery Benefit
				
				private By RVBE1coverlink= By.xpath("//a[contains(text(),'RVBE')]");
				
				private By  SumInsured_RVBE = By.xpath("//input[@id='Cover Limit']");
				
	
				
	//TIM - Transportation of Imported Medicine			
				
				private By TIMcoverlink= By.xpath("//a[contains(text(),'TIM')]");
				
				private By  SumInsured_TIM = By.xpath("//input[@id='Cover Limit']");
				
	//TTDB - Temporary Total Disablement (TTD)			
				
				private By TTDBcoverlink= By.xpath("//a[contains(text(),'TTDB')]");
				
				private By  SumInsured_TTDB = By.xpath("//input[@id='Cover Limit']");
				
				private By LimitPerWeek= By.xpath("//select[@id='Limit Per Week']");
				
				private By MaximumPayableDuration= By.xpath("//select[@id='Maximum Payable Duration']");
				
	//COMV - Compassionate visit			
				
				private By COMVcoverlink= By.xpath("//a[contains(text(),'COMV')]");
				
				private By  SumInsured_COMV = By.xpath("//input[@id='Cover Limit']");
				
	//COBE - Coma Benefit
				
				private By COBEcoverlink= By.xpath("//a[contains(text(),'COBE')]");
				
				private By  SumInsured_COBE = By.xpath("//input[@id='Cover Limit']");	
				
	//CBP - Chauffeur Benefit (Per day)
				
				private By CBPcoverlink= By.xpath("//a[contains(text(),'CBP')]");
				
				private By  SumInsured_CBP = By.xpath("//input[@id='Cover Limit']");
				
				
	//BNBE - Burns Benefit		
				
				private By BNBEcoverlink= By.xpath("//a[contains(text(),'BNBE')]");
				
				private By  SumInsured_BNBE = By.xpath("//input[@id='Cover Limit']");
				
	//BBBF - Broken Bones Benefit
				
				private By BBBFcoverlink= By.xpath("//a[contains(text(),'BBBF')]");
				
				private By  SumInsured_BBBF = By.xpath("//input[@id='Cover Limit']");

				
	//APHC - Accidental In-patient Hospitalization (limited to India)
				
				private By APHC1coverlink= By.xpath("//a[contains(text(),'APHC')]");
				
				private By  SumInsured_APHC = By.xpath("//input[@id='Cover Limit']");
				
				private By RoomType1= By.xpath("//select[@id='Room Type']");
				
				
	//AHC - Accidental Hospital Cash
				
				private By AHCcoverlink= By.xpath("//a[contains(text(),'AHC')]");
				
				private By  SumInsured_AHC = By.xpath("//input[@id='Cover Limit']");
				
				private By Maximumdayslimitper_AHC= By.xpath("//input[@id='Maximum Days Limit Per Claim']");
				
				private By  DeductibleDays_AHC = By.xpath("//select[@id='Deductible Days']");
				
				private By PerPolicyYearLimitinDays_AHC= By.xpath("//select[@id='Per Policy Year Limit']");
				
				
	//ACCD - Accidental Death Cover (AD)
				
				private By ACCDcoverlink= By.xpath("//a[contains(text(),'ACCD')]");
				
				private By  SumInsured_ACCD = By.xpath("//input[@id='Cover Limit']");
				
		
				
	//DTMT - Domestic Travel for Medical Treatment			
				
				private By DTMTcoverlink= By.xpath("//a[contains(text(),'DTMT')]");
				
				private By  SumInsured_DTMT = By.xpath("//input[@id='Cover Limit']");
				
				
	// CI - Critical Illness
				
				private By CriticalIllnessCover = By.xpath("//b[contains(text(),'Critical')]");
		
	//CIL - Critical Illness Benefit			
				
				
				private By CILcoverlink= By.xpath("//a[contains(text(),'CIL')]");
				
				private By  SumInsured_CIL = By.xpath("//input[@id='Cover Limit']");
				
				private By CoverageOption_CIL= By.xpath("//select[@id='Coverage option']");
				
				private By CriticalIllnessesGroupCovered= By.xpath("//select[@id='Critical Illness Group Covered']");
				
				private By SurvivalPeriodinDays_CIL= By.xpath("//select[@id='Critical Survival Period']");
				
	//EDBC1 - Education Fund for Children	
				
				
				private By EDBC1coverlink= By.xpath("//a[contains(text(),'EDBC1')]");
				
				private By  SumInsured_EDBC1 = By.xpath("//input[@id='Sum Insured']");
				
				private By CoverageOption_EDBC1= By.xpath("//select[@id='Coverage option1']");
				
				private By  MaximumDependentChildren_EDBC1 = By.xpath("//input[@id='Maximum Dependent Children']");
				
				
	//LOPC - Loan Protection			
				
				private By LOPCcoverlink= By.xpath("//a[contains(text(),'LOPC')]");
				
				private By  CoverageLimitperEMI_LOPC = By.xpath("//input[@id='Cover Limit']");
				
				private By EMICoverage_LOPC= By.xpath("//select[@id='EMI Coverage']");	
				
				
	//MFC - Marriage Fund for Children
				
				private By MFCcoverlink= By.xpath("//a[contains(text(),'MFC')]");
				
				private By  SumInsured_MFC = By.xpath("//input[@id='Sum Insured']");
				
				private By CoverageOption_MFC= By.xpath("//select[@id='Coverage option1']");
				
				private By  MaximumDependentChildren_MFC = By.xpath("//input[@id='Maximum Dependent Children']");
				
				
	//RCB - Rehabilitation/ Counseling Benefit
				
				private By RCBcoverlink= By.xpath("//a[contains(text(),'RCB')]");
				
				private By  SumInsured_RCB = By.xpath("//input[@id='Cover Limit']");
				
	//VIRUSD - Virus Detection			
				private By VirusDetectionCover= By.xpath("//b[contains(text(),'VIRUSD')]");
				
				
	//VDH - Virus Detection and Hospitalization
				
				private By VDHcoverlink= By.xpath("//a[contains(text(),'MFC')]");
				
				private By  VDHSumInsured = By.xpath("//input[@id='Applicable Suminsured']");
				
				private By VDHApplicability= By.xpath("//select[@id='Applicability']");
				
				
	//VDPO - Virus Detection Pay out
				
				private By VDPOcoverlink= By.xpath("//a[contains(text(),'VDPO')]");
				
				private By  VDPOSumInsured = By.xpath("//input[@id='Applicable Suminsured']");
				
				private By VDPOApplicability= By.xpath("//select[@id='Applicability']");
				
	//OPTCVR - Optional Coverage			
				
				private By OptionalCoverage_19Cover= By.xpath("//b[contains(text(),'OPTCVR')]");
				
	//RT - Reunion Travel
				
				private By RTcoverlink= By.xpath("//a[contains(text(),'RT')]");
				
				private By  RTSumInsured = By.xpath("//select[@id='Reunion Sum Insured']");
				
				private By RTApplicability= By.xpath("//select[@id='Applicability']");
				
				
	//HOSP - Hospitalization
				
				private By HospitalizationCover= By.xpath("//b[contains(text(),'HOSP')]");
				
	//ERAC - Emergency Road Ambulance Cover
				
				private By ERACcoverlink= By.xpath("//a[contains(text(),'ERAC')]");
				
				private By  ERACCoverageLimit = By.xpath("//input[@id='Cover Limit']");
				
	//PRHM - Pre – hospitalization Medical Expenses
				
				private By PRHMcoverlink= By.xpath("//a[contains(text(),'PRHM')]");
				
				private By  PRHMPreHospitalizationPeriod = By.xpath("//input[@id='Pre-Hospitalization Period in Days']");
				
				
				
	//POHM - Post – hospitalization Medical Expenses
				
				private By POHMcoverlink_19= By.xpath("//a[contains(text(),'POHM')]");
				
				private By  POHMPostHospitalizationPeriod = By.xpath("//input[@id='Pre-Hospitalization Period in Days']");
				
	//OETOOPCVR - Optional Extensions to Out Patient Cover
				
				private By OETOOPCVRCover= By.xpath("//b[contains(text(),'OETOOPCVR')]");
				
				
	//CSM - Cancer screening & Mammography
				
				private By CSMcoverlink= By.xpath("//a[contains(text(),'CSM')]");
				
				private By  CSM_SimInsured = By.xpath("//input[@id='Cover Limit']");
				
				
	//VCCV - Vaccination Charges
				
				private By VCCVcoverlink_Travel= By.xpath("//a[contains(text(),'VCCV')]");
				
				private By  VCCV_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
	//RCC - Radiotherapy and Chemotherapy Charges
				
				private By RCCcoverlink_Travel= By.xpath("//a[contains(text(),'RCC')]");
				
				private By  RCC_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
	//TMNDOT - Treatment of Mental & Nervous Disorder
				
				private By TMNDOTcoverlink_Travel= By.xpath("//a[contains(text(),'TMNDOT')]");
				
				private By  TMNDOT_SumInsured = By.xpath("//input[@id='Cover Limit']");
	
	//PMC - Psychological and Mental Counselling
				
				private By PMCcoverlink_Travel= By.xpath("//a[contains(text(),'PMC')]");
				
				private By  PMC_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				
	//NEOPD - Non-emergency OPD consultation
				
				private By NEOPDcoverlink= By.xpath("//a[contains(text(),'NEOPD')]");
				
				private By  NEOPD_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
	//OETOMCVR - Optional Extensions to Medical Cover
				
				private By OETOMCVRCover= By.xpath("//b[contains(text(),'OETOMCVR')]");
				
	//PSI - Professional Sports Injury
				
				private By PSIcoverlink= By.xpath("//a[contains(text(),'PSI')]");
				
				private By PSI_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
	//ADSB - Adventure Sports Injury
				
				private By ADSBcoverlink= By.xpath("//a[contains(text(),'ADSB')]");
				
				private By ADSB_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
	//MT - Maternity
				
				private By MTcoverlink= By.xpath("//a[contains(text(),'MT')]");
				
				private By MT_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By MT_PrePostNatalExpensesLimit = By.xpath("//input[@id='Pre-Post Natal Expenses']");
				
				private By MT_NoOfClaimsLimit = By.xpath("//input[@id='Number of claims Limit']");
				
				private By MT_ClaimOption= By.xpath("//select[@id='Maternity Claim Option']");
				
				private By MT_MinTravelDayForEligibility= By.xpath("//select[@id='Minimum Travel Days for Eligibility']");
				
				private By MT_WaitingPeriodInMonths= By.xpath("//select[@id='Waiting Period in months']");
				
				private By MT_PrePostNatalExpenses = By.xpath("//select[@id='Pre-Post Natal Expenses Applicable']");
				
	//MCOM - Maternity Complications			
				
				private By MCOMcoverlink= By.xpath("//a[contains(text(),'MCOM')]");
				
				private By MCOM_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
	//DAA - Drug And Alcohol Abuse
				
				private By DAAcoverlink= By.xpath("//a[contains(text(),'DAA')]");
				
				private By DAA_CoverageLimit = By.xpath("//select[@id='Cover limit Percentage']");
				
	// CF - Corporate Floater
				
				private By CFcoverlink= By.xpath("//a[contains(text(),'CF')]");
				
				private By CF_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By CF_NoOfClaimsUnit = By.xpath("//input[@id='Number of claims Limit']");
				
				private By CF_MaxAmountPerClaim = By.xpath("//input[@id='Maximum Amount Per Claim']");
				
				private By CF_ClaimOption = By.xpath("//select[@id='Corporate Floater Claim option']");
				
	//PEDMC - Pre-Existing Disease Cover In Life Threatening Medical Condition
				
				private By PEDMCcoverlink= By.xpath("//a[contains(text(),'PEDMC')]");
				
				private By PEDMC_CoverageLimit = By.xpath("//input[@id='Coverage Limit Percentage']");
	
	//SII - Self-Inflicted Injury
				
				private By SIIcoverlink= By.xpath("//a[contains(text(),'SII')]");
				
				private By SII_CoverageLimit = By.xpath("//select[@id='Cover limit Percentage']");
				
				
	//MEDICALCVR - Medical Cover
				
				private By MEDICALCVRCover= By.xpath("//b[contains(text(),'MEDICALCVR')]");			
				
	//IPIDC - In-patient Care For Injury with day care treatment
				
				private By IPIDCcoverlink= By.xpath("//a[contains(text(),'IPIDC')]");
				
				private By IPIDC_CoPay = By.xpath("//select[@id='Co-Pay Percent']");
				
				private By IPIDC_RestrictionForEmergencyCare = By.xpath("//select[@id='Restriction for Emergency Care']");
				
				private By IPIDC_AutomaticExtensionDateLimit = By.xpath("//select[@id='Automatic Extension Days Limit']");
				
				private By IPIDC_AutomaticExtensionLimit = By.xpath("//input[@id='Automatic Extension limit']");
				
				private By IPIDC_Discount = By.xpath("//input[@id='Discount %']");
				
				private By IPIDC_SumInsured = By.xpath("//input[@id='Cover Limit']");

				private By IPIDC_PerHospitalizationMinLimit = By.xpath("//input[@id='Per Hospitalization Min Limit']");
				
				
				
	//IPDCT - In-patient Care with day care treatment
				
				private By IPDCTCcoverlink= By.xpath("//a[contains(text(),'IPDCT')]");
				
				private By IPDCT_CoPay = By.xpath("//select[@id='Co-Pay Percent']");
				
				private By IPDCT_RestrictionForEmergencyCare = By.xpath("//select[@id='Restriction for Emergency Care']");
				
				private By IPDCT_AutomaticExtensionDaysLimit = By.xpath("//select[@id='Automatic Extension Days Limit']");
				
				private By IPDCT_AutomaticExtensionLimit = By.xpath("//input[@id='Automatic Extension limit']");
				
				private By IPDCT_Discount = By.xpath("//input[@id='Discount %']");
				
				private By IPDCT_SumInsured = By.xpath("//input[@id='Cover Limit']");

				private By IPDCT_PerHospitalizationMinLimit = By.xpath("//input[@id='Per Hospitalization Min Limit']");
				
				
				
	//OBTOMCVR - Optional Benefits to Medical Cover
				
				private By OBTOMCVRCover= By.xpath("//b[contains(text(),'OBTOMCVR')]");
				
	//RMEX - Repatriation of Mortal Remains
				
				private By RMEXcoverlink= By.xpath("//a[contains(text(),'MCOM')]");
				
				private By RMEX_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
	//PACCI - Personal Accident
				
				private By PACCIcoverlink= By.xpath("//a[contains(text(),'PACCI')]");
				
				private By PACCI_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By PACCI_PTDLimit = By.xpath("//input[@id='PTD Limit']");
				
				private By PACCI_DeathLimit = By.xpath("//input[@id='Death Limit']");
				
				private By PACCI_MaximumAggregatePolicyLimit = By.xpath("//input[@id='Maximum aggregate Policy limit']");
				
				private By PACCI_CoverageOption = By.xpath("//select[@id='Coverage option5']");
		
	//DCB - Delay of Checked-in Baggage
				
				private By DCBcoverlink= By.xpath("//a[contains(text(),'DCB')]");
				
				private By DCB_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By DCB_DeductibleInHours = By.xpath("//select[@id='Deductible in hours']");
				
				
	//LOCB - Loss of Checked-in Baggage

				private By LOCBcoverlink= By.xpath("//a[contains(text(),'LOCB')]");
				
				private By LOCB_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By LOCB_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
	//LOP - Loss of Passport
				
				private By LOPcoverlink= By.xpath("//a[contains(text(),'LOP')]");
				
				private By LOP_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By LOP_Deductible = By.xpath("//input[@id='Coverage Deductible']");	
				
	//ME - Medical Evacuation
				
				private By MEcoverlink_Travel= By.xpath("//a[contains(text(),'Medical Evacuation')]");
				
				private By ME_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By ME_Deductible = By.xpath("//input[@id='Coverage Deductible']");	
				
	//OPC - Out-patient Care
				
				private By OPCcoverlink_Travel= By.xpath("//a[contains(text(),'Medical Evacuation')]");
				
				private By OPC_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By OPC_Deductible = By.xpath("//input[@id='Coverage Deductible']");	
				
				private By OPC_CoPay = By.xpath("//input[@id='Coverage Deductible']");
				
		
	//BBD - Bail Bond
				
				private By BBDcoverlink_Travel= By.xpath("//a[contains(text(),'BBD')]");
				
				private By BBD_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
	//CCF - Common Carrier Fatality
				
				private By CCFcoverlink_Travel= By.xpath("//a[contains(text(),'CCF')]");
				
				private By CCF_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By CCF_BenefitOptions = By.xpath("//select[@id='Benefit Options']");
				
				
	//CV - Compassionate Visit
				
				private By CVcoverlink_Travel= By.xpath("//a[contains(text(),'Compassionate')]");
				
				private By CV_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By CV_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
				private By CV_MinimumDaysOfHospitalization = By.xpath("//select[@id='Minimum days of hospitalization']");
				
	//DCOI - Dental Expenses
				
				private By DCOIcoverlink_Travel= By.xpath("//a[contains(text(),'DCOI')]");
				
				private By DCOI_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By DCOI_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
	//EHAE - Emergency Hotel Accommodation / Extension
				
				private By EHAEcoverlink_Travel= By.xpath("//a[contains(text(),'EHAE')]");
				
				private By EHAE_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By EHAE_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
	//EHV - Emergency Home Visit
				
				private By EHVcoverlink_Travel= By.xpath("//a[contains(text(),'EHV')]");
				
				private By EHV_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				
	//GFO - Golf fees and other non transferable ticket expenses
				
				private By GFOcoverlink_Travel= By.xpath("//a[contains(text(),'GFO')]");
				
				private By GFO_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By GFO_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
	//HAD - Hijack distress allowance
				
				private By HADcoverlink_Travel= By.xpath("//a[contains(text(),'HAD')]");
				
				private By HAD_LimitPerDay = By.xpath("//input[@id='Limit Per Day']");
				
				private By HAD_DeductibleInHours = By.xpath("//select[@id='Deductible in Hours']");
				
	//HB - Home Burglary
				
				private By HBcoverlink_Travel= By.xpath("//a[contains(text(),'Burglary')]");
				
				private By HB_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By HB_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				 
	//HC - Home Care
				
				private By HCcoverlink_Travel= By.xpath("//a[contains(text(),'Home Care')]");
				
				private By HC_LimitPerDay = By.xpath("//input[@id='Limit Per Day']");
				
				private By HC_Deductible = By.xpath("//select[@id='Home Care Deductible']");
				
	//HCT - Hotel Cancellation
			
				private By HCTcoverlink_Travel= By.xpath("//a[contains(text(),'HCT')]");
				
				private By HCT_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By HCT_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
				
	//HLCU - Health Check-up
				
				private By HLCUcoverlink_Travel= By.xpath("//a[contains(text(),'HLCU')]");
				
				private By HLCU_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By HLCU_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
				private By HLCU_CoPay = By.xpath("//select[@id='Co-Pay Percent']");
		
	//HOCB - Daily Allowance
				
				private By HOCBcoverlink_Travel= By.xpath("//a[contains(text(),'HOCB')]");
				
				private By HOCB_LimitPerDay = By.xpath("//input[@id='Limit Per Day']");
				
				private By HOCB_DeductibleInDays = By.xpath("//select[@id='Deductible in days']");
				
	//IDT - Identity Document Theft
				
				private By IDTcoverlink_Travel= By.xpath("//a[contains(text(),'IDT')]");
				
				private By IDT_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By IDT_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
	//LLTHM - Loss of Laptop/ Tablet / Hand baggage / Mobile
				
				private By LLTHMcoverlink_Travel= By.xpath("//a[contains(text(),'LLTHM')]");
				
				private By LLTHM_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By LLTHM_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
				private By LLTHM_CoPay = By.xpath("//select[@id='Co-Pay Percent']");
				
	//LSE - Lifestyle Support		
				
				private By LSEcoverlink_Travel= By.xpath("//a[contains(text(),'LSE')]");
				
				private By LSE_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				
		//MCON - Missed Connection
				
				private By MCONcoverlink_Travel= By.xpath("//a[contains(text(),'HOCB')]");
				
				private By MCON_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By MCON_DeductibleInHours = By.xpath("//select[@id='Missed connection in hours']");
				
	//MGC - Mugging Cover	
				
				private By MGCcoverlink_Travel= By.xpath("//a[contains(text(),'MGC')]");
				
				private By MGC_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
	//MTEX - Maternity Cash Benefit
				
				private By MTEXcoverlink_Travel= By.xpath("//a[contains(text(),'MGC')]");
				
				private By MTEX_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By MTEX_WaitingPeriodInMonths = By.xpath("//select[@id='Waiting Period in Months']");
				
	//MTMCI - Mid Trip Medical cover continuance in India
				
				
				private By MTMCIcoverlink_Travel= By.xpath("//a[contains(text(),'MTMCI')]");
				
				private By MTMCI_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By MTMCI_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
				private By MTMCI_CoPay = By.xpath("//select[@id='Co-Pay Percent']");
				
				private By MTMCI_MaximumDaysCovered = By.xpath("//select[@id='Max Days Covered']");
				
	//OPCI - Out-patient Care for Injury
				
				private By OPCIcoverlink_Travel= By.xpath("//a[contains(text(),'OPCI')]");
				
				private By OPCI_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By OPCI_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
				private By OPCI_CoPay = By.xpath("//select[@id='Co-Pay Percent']");
				
				
	//PACCOM - Parent Accommodation
				
				
				private By PACCOMcoverlink_Travel= By.xpath("//a[contains(text(),'OPCI')]");
				
				private By PACCOM_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By PACCOM_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
				private By PACCOM_CoPay = By.xpath("//select[@id='Co-Pay Percent']");
				
	//PL - Personal Liability		
				
				private By PLcoverlink_Travel= By.xpath("//a[contains(text(),'Personal Liability')]");
				
				private By PL_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By PL_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
	//PRCE - Political Risk and Catastrophe Evacuation
				
				private By PRCEcoverlink_Travel= By.xpath("//a[contains(text(),'PRCE')]");
				
				private By PRCE_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By PRCE_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
				private By PRCE_HotelAccommodationperdaylimit = By.xpath("//select[@id='Hotel Accommodation per day limit']");
		
				
	//RMC - Return of Minor Child
				
				
				private By RMCcoverlink_Travel= By.xpath("//a[contains(text(),'RMC')]");
				
				private By RMC_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By RMC_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
				private By RMC_MinDaysOfHospitalization = By.xpath("//select[@id='Minimum days of hospitalization']");
				
				
				
	//RS - Replacement of Staff
				
				
				private By RSCcoverlink_Travel= By.xpath("//a[contains(text(),'Replacement of Staff')]");
				
				private By RS_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By RS_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
				
	//SI - Study Interruption	
				
				private By SIcoverlink_Travel= By.xpath("//a[contains(text(),'Study Interruption')]");
				
				private By SI_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				
	//SP - Sponsor Protection
			
				private By SPcoverlink_Travel= By.xpath("//a[contains(text(),'Sponsor Protection')]");
				
				private By SP_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
	//TCI - Trip Cancellation & Interruption
				
				private By TCIcoverlink_Travel= By.xpath("//a[contains(text(),'TCI')]");
				
				private By TCI_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By TCI_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
	//TD - Trip Delay
				
				private By TDcoverlink_Travel= By.xpath("//a[contains(text(),'Trip Delay')]");
				
				private By TD_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By TD_DeductibleUnit = By.xpath("//select[@id='Deductible_Unit']");
				
				private By TD_Deductible = By.xpath("//select[@id='Trip Delay Deductible']");
				
				
	//UGBC - Up-gradation to Business Class
				
				private By UGBCcoverlink_Travel= By.xpath("//a[contains(text(),'UGBC')]");
				
				private By UGBC_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By UGBC_MinimumDaysOfHospitalization = By.xpath("//select[@id='Minimum days of hospitalization']");
				
				
	//BB - Bounced Booking
				
				private By BBcoverlink_Travel= By.xpath("//a[contains(text(),'Bounced Booking')]");
				
				private By BB_SumInsured = By.xpath("//input[@id='Cover Limit']");
				
				private By BB_Deductible = By.xpath("//input[@id='Coverage Deductible']");
				
				
				
				
			public Coverdetails (WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			wait = new WebDriverWait(driver, 30);	
		    } 
	 
	 //Group Activ Health (4211) || Group Activ Health V2 (5211) Covers
			
	  public  void fillEmployeeDetailsGroup_active_healthPage (WebDriver driver,XSSFWorkbook workbook,Connection conn,CustomAssert customAssert) throws Exception
	   
	  {
		  String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
	       Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		   Reporter.log("<B>Traverse To Group_active_healthPage</B>");
		  
		  click(BaseCover, "Base cover");
			
			java.util.List<WebElement> list = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[1]/preceding::div[@id='CoverOptional']/ol/div"));
			
			for(int a=0;a<=list.size();a++)
			{
				int b =a+2;
				String txtnm=(list.get(a)).getText();
				
				
				if(dataRow.getProperty("IPTT - In-patient Hospitalization cover").equalsIgnoreCase("Yes"))
				{
						
				 if(txtnm.contains("IPTT"))
					
				{
					
					driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]")).click();
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
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				}
				
				if(dataRow.getProperty("POHM").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("POHM"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				}
				
				if(dataRow.getProperty("PRHM").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("PRHM"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				}
				
				if(dataRow.getProperty("DCHS").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("DCHS"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				}
				
				if(dataRow.getProperty("DCTT").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("DCTT"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				}
				
				if(dataRow.getProperty("ORDR").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("ORDR"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
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
			
			//RACV - Road Ambulance Expenses
			
			if(dataRow.getProperty("RACV_Road Ambulance Expenses").equalsIgnoreCase("Yes"))
			{				
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
				click(POHMcoverlink,"POHM Checkllink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(Posthospitalizationdropdown, dataRow.getProperty("Post hospitalization")," BNBE SumInsured ");
				Thread.sleep(WaitTime.low);
			}
			
			//PRHM - Pre – hospitalization Medical Expenses
			
			if(dataRow.getProperty("PRHM").equalsIgnoreCase("Yes"))
			{
				click(PRHMPrecoverlink,"PRHM Pre coverlink");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(Prehospitalizationdropdown, dataRow.getProperty("Pre hospitalization")," BNBE SumInsured ");
				Thread.sleep(WaitTime.low);
			}
			
			//DCHS - Domiciliary Hospitalization
			
			if(dataRow.getProperty("DCHS").equalsIgnoreCase("Yes"))
			{
				click(DCHScoverlink,"PRHM Pre coverlink");
				Thread.sleep(WaitTime.low);
				
//				clearAndSenKeys(DCHSSI,dataRow.getProperty("DCHSSI"),"DCHS SI");
				Thread.sleep(WaitTime.low);
			}
			
			
			//IPTT - In-patient Hospitalization cover
			
			if(dataRow.getProperty("IPTT - In-patient Hospitalization cover").equalsIgnoreCase("Yes"))
			{

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

				click(DCTTcoverlink,"PRHM Pre coverlink");
			}
			
			// ORDR - Organ Donor Expenses
			
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
			
			click(optionalCover, "optional cover");
			
		java.util.List<WebElement> optionalCover_list = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[2]/preceding::div[@id='CoverOptional']/ol/div"));
			
		for(int a=0;a<=optionalCover_list.size();a++)
		{
			int b =a+3;
			String txtnm=(optionalCover_list.get(a)).getText();
			
			//HLTHRET - HealthReturns TM
			
			if(dataRow.getProperty("HLTHRET").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("HLTHRET"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			//HPP - Healthy Pregnancy Program
			
			if(dataRow.getProperty("HPP").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("HPP"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			//HLTHA - Health Assessment
			
			if(dataRow.getProperty("HLTHA").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("HLTHA"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			
			//HLTCH - Health Check-up Program
			
			if(dataRow.getProperty("HLTCH").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("HLTCH"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			// FTAS - Fitness Assessment
			
			if(dataRow.getProperty("FTAS").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("FTAS"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
			}
			
			click(FTAScoverlink,"FTA coverlink");
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
			
			//EXCA - External Congenital Anomaly
			
			if(dataRow.getProperty("EXCA").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("EXCA"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			// DMAS - Domestic Emergency Medical assistance
			
			if(dataRow.getProperty("DMAS").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("DMAS"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			//DCLC - Daily cash for choosing lower category room
			
			if(dataRow.getProperty("DCLC").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("DCLC"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			// IMAS - International Emergency Medical assistance
			
			if(dataRow.getProperty("IMAS").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("IMAS"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			//WLI - Wellness Coach
			
			if(dataRow.getProperty("WLI").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("WLI"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
			}
			
			click(WLIcoverlink,"WLI coverlink");
			Thread.sleep(WaitTime.low);
							
			click(savebasecoverbtn,"Save btn");
			Thread.sleep(WaitTime.low);
			
			click(OKBtn,"OK");
			Thread.sleep(WaitTime.low);
			}
			
			// WELL - Wellmother Cover
			
			if(dataRow.getProperty("WELL").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("WELL"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			//VCCV - Vaccination Expenses
			if(dataRow.getProperty("VCCV").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("VCCV"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			//UMM - Ultra Modern Medicine
			if(dataRow.getProperty("UMM").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("UMM"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			//SPOR - Sports Activity Cover
			if(dataRow.getProperty("SPOR").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("SPOR"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			// SCOP - Second E - Opinion
			if(dataRow.getProperty("SCOP").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("SCOP"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			//INFR - Infertility Treatment
			if(dataRow.getProperty("INFR").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("INFR"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			//MTEX - Maternity Benefit
			if(dataRow.getProperty("MTEX - Maternity Benefit Expense Cover").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("MTEX - Maternity Benefit Expense Cover"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
			//NBBE - New Born Baby Expenses
			
			if(dataRow.getProperty("NBBE").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("NBBE"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
			}
			
			click(NBBEcoverlink,"NBBE coverlink");
			Thread.sleep(WaitTime.low);
			
			selectFromDropdownByVisibleText(coverageoption,dataRow.getProperty("Coverage Option"),"Coverageoption");
			
			click(savebasecoverbtn,"Save btn");
			Thread.sleep(WaitTime.low);
			
			click(OKBtn,"OK");
			Thread.sleep(WaitTime.low);
			}
			
			// RVBE - Recovery Benefit
			
			if(dataRow.getProperty("RVBE").equalsIgnoreCase("Yes"))
			{
			if(txtnm.contains("RVBE"))
			{
				
				WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
				Ele.click();
				
				try
				{
					Ele.click();
				}
				catch(Exception e) {}
				//click((By) Ele,"ADD Button");
				click(Addcoverbtn,"ADD Button");
				boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
				if (okBTNIPTT == true) 
				{
					click(OKBtn,"OK");
				}
				break;
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
			
	}
	 
	   
		// Standalone Cover
		
				click(standaloneCover, "standalone cover");
				Thread.sleep(WaitTime.low);
					
				java.util.List<WebElement> standalone_list = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[3]/preceding::div[@id='CoverOptional']/ol/div"));
					
				for(int a=0;a<=standalone_list.size();a++)
				{
					int b =a+4;
					String txtnm=(standalone_list.get(a)).getText();
					
					
					//AYSH - Ayush treatment (In-patient Hospitalization)
					
					if(dataRow.getProperty("AYSH").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("AYSH"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						break;
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
					
					//APHC - Accidental Hospitalisation - Indemnity
					
					if(dataRow.getProperty("APHC").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("APHC"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						break;
					}
					
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
					
					//PSYC - Psychiatric In-patient Care
					
					if(dataRow.getProperty("PSYC").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("PSYC"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						break;
					}
					
					Thread.sleep(WaitTime.low);
					
					click(PSYCcoverlink,"PSYC coverlink");
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(PSYCSI,dataRow.getProperty("PSYCSI"),"PSYCSI");
					Thread.sleep(WaitTime.low);
					
					click(savebasecoverbtn,"Save btn");
					Thread.sleep(WaitTime.low);
					
					click(OKBtn,"OK");
					Thread.sleep(WaitTime.low);
					}
					
					// OPDE - OPD Expenses
					
					if(dataRow.getProperty("HSCB1").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("HSCB1"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						break;
					}
					
					Thread.sleep(WaitTime.low);
					
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
					
					//HSCB - Hospital Cash Benefit
					
					
					if(dataRow.getProperty("HSCB").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("HSCB"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						break;
					}
					
					Thread.sleep(WaitTime.low);
					
					click(HSCBCcoverlink,"HSCB coverlink");
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(HSCBSIlimitperday,dataRow.getProperty("SI_LimitPerDay"),"HSCB SI Per Day");
					Thread.sleep(WaitTime.low);
					
					click(savebasecoverbtn,"Save btn");
					Thread.sleep(WaitTime.low);
					
					click(OKBtn,"OK");
					Thread.sleep(WaitTime.low);
					}
					
					
				// CHMP - Chronic Management Program
					
					if(dataRow.getProperty("CHMP").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("CHMP"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						break;
					}
					
					Thread.sleep(WaitTime.low);
					
					click(CHMPCcoverlink,"CHMP coverlink");
					Thread.sleep(WaitTime.low);
					
					selectFromDropdownByVisibleText(CHMPmembereligibility,dataRow.getProperty("CHMP Member Eligibility"),"CHMP member eligibility");
					Thread.sleep(WaitTime.low);
					
					click(savebasecoverbtn,"Save btn");
					Thread.sleep(WaitTime.low);
					
					click(OKBtn,"OK");
					Thread.sleep(WaitTime.low);
					}
					
					// WCIC - Worldwide Critical Illness Cover
					
					if(dataRow.getProperty("WCIC").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("WCIC"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						break;
					}
					
					Thread.sleep(WaitTime.low);
				
					click(WCICcoverlink,"WCIC coverlink");
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(WCICSI,dataRow.getProperty("WCICSI"),"WCICSI");
					Thread.sleep(WaitTime.low);
					
					click(savebasecoverbtn,"Save btn");
					Thread.sleep(WaitTime.low);
					
					click(OKBtn,"OK");
					Thread.sleep(WaitTime.low);
					}
					
					
				}
	 }	
	  
	  public  void fillEmployeeDetailsGroup_active_SecurePage (WebDriver driver,XSSFWorkbook workbook,Connection conn,CustomAssert customAssert) throws Exception
	    {
		  String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
	       Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		   Reporter.log("<B>Traverse To Group_active_SecurePage</B>");
	  
		   
		 //Click on HC - Hospita Cash Cover
			
			click(HospitalCashCover, "HC - Hospita Cash Cover");
			Thread.sleep(WaitTime.low);
			
			java.util.List<WebElement> HospitalCashCover_list = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[1]/preceding::div[@id='CoverOptional']/ol/div"));
				
			for(int a=0;a<=HospitalCashCover_list.size();a++)
			{
				int b =a+2;
				String txtnm=(HospitalCashCover_list.get(a)).getText();
		   
				// AHCB - Accidental Hospital Cash Benefit
				if(dataRow.getProperty("AHCB - Accidental Hospital Cash Benefit").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("AHCB"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
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
				
				//HSCB - Hospital Cash Benefit
				if(dataRow.getProperty("HSCB - Hospital Cash Benefit").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("HSCB"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
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
			
				// MTEX - Maternity Benefit Expense Cover
				if(dataRow.getProperty("MTEX - Maternity Benefit Expense Cover").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("MTEX"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
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
				
				
				
		   
			}
		   
			//Click on PA - Personal Accident
			
			click(PersonalAccidentCover, "PA - Personal Accident");
			Thread.sleep(WaitTime.low);
		   
			java.util.List<WebElement> PersonalAccidentCover_list = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[2]/preceding::div[@id='CoverOptional']/ol/div"));
			
			for(int a=0;a<=PersonalAccidentCover_list.size();a++)
			{
				
				int b =a+3;
				String txtnm=(PersonalAccidentCover_list.get(a)).getText();
				
				//CSI - Cost of Support Items
				if(dataRow.getProperty("CSI - Cost of Support Items").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("CSI"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(CSIcoverlink,"CSI - Cost of Support Items");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_CSI,dataRow.getProperty("Sum Insured_CSI"),"Sum Insured CSI");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//DB - Disappearance Benefit
				if(dataRow.getProperty("DB - Disappearance Benefit").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("Disappearance"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(DBcoverlink,"DB - Disappearance Benefit");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_DB,dataRow.getProperty("Sum Insured_DB"),"Sum Insured DB");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//DPPE - Damage to Personal Protective Equipment
				if(dataRow.getProperty("DPPE - Damage to Personal Protective Equipment").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("DPPE"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(DPPEcoverlink,"DPPE - Damage to Personal Protective Equipment");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_DPPE,dataRow.getProperty("Sum Insured_DPPE"),"Sum Insured DPPE");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//WEAS - Worldwide Emergency Medical Assistance
				if(dataRow.getProperty("WEAS - Worldwide Emergency Medical Assistance").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("WEAS"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				
				//EDBC - Education Fund for Children
				if(dataRow.getProperty("EDBC - Education Fund for Children").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("EDBC"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(EDBCcoverlink,"EDBC - Education Fund for Children");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_EDBC,dataRow.getProperty("Sum Insured_EDBC"),"Sum Insured EDBC");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//FUEX - Funeral Expenses
				if(dataRow.getProperty("FUEX - Funeral Expenses").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("FUEX"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(FUEXcoverlink,"FUEX - Funeral Expenses");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_FUEX,dataRow.getProperty("Sum Insured_FUEX"),"Sum Insured FUEX");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//HVMB - Modification Benefit (Residence)
				
				if(dataRow.getProperty("HVMB - Modification Benefit (Residence)").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("HVMB"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(HVMBcoverlink,"HVMB - Modification Benefit (Residence)");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_HVMB,dataRow.getProperty("Sum Insured_HVMB"),"Sum Insured HVMB");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//HVMB1 - Modification Benefit (Vehicle)
				if(dataRow.getProperty("HVMB1 - Modification Benefit (Vehicle)").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("HVMB1"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(HVMB1coverlink,"HVMB1 - Modification Benefit (Vehicle)");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_HVMB1,dataRow.getProperty("Sum Insured_HVMB"),"Sum Insured HVMB1");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//LOJ - Loss of Job
				
				if(dataRow.getProperty("LOJ - Loss of Job").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("LOJ"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(LOJcoverlink,"LOJ - Loss of Job");
				Thread.sleep(WaitTime.low);
				
				/*
				 * clearAndSenKeys(SumInsured_LOJ,dataRow.getProperty("Sum Insured_LOJ"
				 * ),"Sum Insured LOJ"); Thread.sleep(WaitTime.low);
				 */
				
				selectFromDropdownByVisibleText(EmploymentType,dataRow.getProperty("Employment Type"),"Employment Type");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(SalaryInformationAvailable,dataRow.getProperty("Salary Information Available"),"Salary Information Available");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SalaryPerMonth,dataRow.getProperty("Salary Per Month"),"Salary Per Month");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//ME - Medical Expenses
				if(dataRow.getProperty("ME - Medical Expenses").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("Medical"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(MEcoverlink,"ME - Medical Expenses");
				Thread.sleep(WaitTime.low);
				
				/*
				 * clearAndSenKeys(SumInsured_LOJ,dataRow.getProperty("Sum Insured_LOJ"
				 * ),"Sum Insured LOJ"); Thread.sleep(WaitTime.low);
				 */
				
				selectFromDropdownByVisibleText(CoverPercentage,dataRow.getProperty("Cover Percentage"),"Cover Percentage");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(RoomType,dataRow.getProperty("Room Type"),"Room Type");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//MFC1 - Marriage Fund for Children
				
				if(dataRow.getProperty("MFC1 - Marriage Fund for Children").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("MFC1"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(MFC1coverlink,"MFC1 - Marriage Fund for Children");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_MFC1,dataRow.getProperty("Sum Insured_MFC1"),"Sum Insured MFC1");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//OPDE - Out-patient Expenses
				if(dataRow.getProperty("OPDE - Out-patient Expenses").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("OPDE"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(OPDEcoverlink,"OPDE - Out-patient Expenses");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_OPDE,dataRow.getProperty("Sum Insured_OPDE"),"Sum Insured OPDE");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//ORBF - Orphan Benefit for Children
				if(dataRow.getProperty("ORBF - Orphan Benefit for Children").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("ORBF"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(ORBFcoverlink,"ORBF - Orphan Benefit for Children");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_ORBF,dataRow.getProperty("Sum Insured_ORBF"),"Sum Insured ORBF");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//PPDB - Permanent Partial Disablement (PPD)
				if(dataRow.getProperty("PPDB - Permanent Partial Disablement (PPD)").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("PPDB"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(PPDBcoverlink,"PPDB - Permanent Partial Disablement (PPD)");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_PPDB,dataRow.getProperty("Sum Insured_PPDB"),"Sum Insured PPDB");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//PTDB - Permanent Total Disablement (PTD)
				if(dataRow.getProperty("PTDB - Permanent Total Disablement (PTD)").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("PTDB"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(PTDBcoverlink,"PTDB - Permanent Total Disablement (PTD)");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_PTDB,dataRow.getProperty("Sum Insured_PTDB"),"Sum Insured PTDB");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//RACB - Road Ambulance Cover
				if(dataRow.getProperty("RACB - Road Ambulance Cover").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("RACB"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(RACBcoverlink,"RACB - Road Ambulance Cover");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_RACB,dataRow.getProperty("Sum Insured_RACB"),"Sum Insured RACB");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//RCB1 - Rehabilitation/ Counseling Benefit
				
				if(dataRow.getProperty("RCB1 - Rehabilitation/ Counseling Benefit").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("RCB1"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(RCB1coverlink,"RCB1 - Rehabilitation/ Counseling Benefit");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_RCB1,dataRow.getProperty("Sum Insured_RCB1"),"Sum Insured RCB1");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//RERE - Repatriation of Mortal Remains
				if(dataRow.getProperty("RERE - Repatriation of Mortal Remains").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("RERE"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(REREcoverlink,"RERE - Repatriation of Mortal Remains");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_RERE,dataRow.getProperty("Sum Insured_RERE"),"Sum Insured RERE");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//RVBE - Recovery Benefit
				if(dataRow.getProperty("RVBE - Recovery Benefit").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("RVBE"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(RVBE1coverlink,"RVBE - Recovery Benefit");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_RVBE,dataRow.getProperty("Sum Insured_RVBE"),"Sum Insured RVBE");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//SAC - Sports Activity Cover
				
				if(dataRow.getProperty("SAC - Sports Activity Cover").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("SAC"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				
				}
				
				//SCOP1 - Second E-opinion
				if(dataRow.getProperty("SCOP1 - Second E-opinion").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("SCOP1"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				
				}
				
				//TIM - Transportation of Imported Medicine
				if(dataRow.getProperty("TIM - Transportation of Imported Medicine").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("TIM"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(TIMcoverlink,"TIM - Transportation of Imported Medicine");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_TIM,dataRow.getProperty("Sum Insured_TIM"),"Sum Insured TIM");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//TTDB - Temporary Total Disablement (TTD)
				if(dataRow.getProperty("TTDB - Temporary Total Disablement (TTD)").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("TTDB"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(TTDBcoverlink,"TTDB - Temporary Total Disablement (TTD)");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(LimitPerWeek,dataRow.getProperty("Limit Per Week"),"Limit Per Week");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(MaximumPayableDuration,dataRow.getProperty("Maximum Payable Duration"),"Maximum Payable Duration");
				Thread.sleep(WaitTime.low);
				
				
				clearAndSenKeys(SumInsured_TTDB,dataRow.getProperty("Sum Insured_TTDB"),"Sum Insured TTDB");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//COMV - Compassionate visit
				if(dataRow.getProperty("COMV - Compassionate visit").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("COMV"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(COMVcoverlink,"COMV - Compassionate visit");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_COMV,dataRow.getProperty("Sum Insured_COMV"),"Sum Insured COMV");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//COBE - Coma Benefit
				if(dataRow.getProperty("COBE - Coma Benefit").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("COBE"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(COBEcoverlink,"COBE - Coma Benefit");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_COBE,dataRow.getProperty("Sum Insured_COBE"),"Sum Insured COBE");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//CBP - Chauffeur Benefit (Per day)
				if(dataRow.getProperty("CBP - Chauffeur Benefit (Per day)").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("CBP"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(CBPcoverlink,"CBP - Chauffeur Benefit (Per day)");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_CBP,dataRow.getProperty("Sum Insured_CBP"),"Sum Insured CBP");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				
				//BNBE - Burns Benefit
				if(dataRow.getProperty("BNBE - Burns Benefit").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("BNBE"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(BNBEcoverlink,"BNBE - Burns Benefit");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_BNBE,dataRow.getProperty("Sum Insured_BNBE"),"Sum Insured BNBE");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//BBBF - Broken Bones Benefit
				if(dataRow.getProperty("BBBF - Broken Bones Benefit").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("BBBF"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(BBBFcoverlink,"BBBF - Broken Bones Benefit");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_BBBF,dataRow.getProperty("Sum Insured_BBBF"),"Sum Insured BBBF");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}

				//APHC - Accidental In-patient Hospitalization (limited to India)
				if(dataRow.getProperty("APHC - Accidental In-patient Hospitalization (limited to India)").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("APHC"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(APHC1coverlink,"APHC - Accidental In-patient Hospitalization (limited to India)");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_APHC,dataRow.getProperty("Sum Insured_APHC"),"Sum Insured APHC");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(RoomType1,dataRow.getProperty("Room Type"),"Room Type");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//AHC - Accidental Hospital Cash
				if(dataRow.getProperty("AHC - Accidental Hospital Cash").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("APHC"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(AHCcoverlink,"AHC - Accidental Hospital Cash");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_AHC,dataRow.getProperty("Sum Insured_AHC"),"Sum Insured AHC");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(Maximumdayslimitper_AHC,dataRow.getProperty("Maximum days limit per_AHC"),"Maximum days limit per_AHC");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(PerPolicyYearLimitinDays_AHC,dataRow.getProperty("Per Policy Year Limit in Days_AHC"),"Per Policy Year Limit in Days_AHC");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(DeductibleDays_AHC,dataRow.getProperty("Deductible Days_AHC"),"Deductible Days_AHC");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//ACCD - Accidental Death Cover (AD)
				if(dataRow.getProperty("ACCD - Accidental Death Cover (AD)").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("ACCD"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(ACCDcoverlink,"ACCD - Accidental Death Cover (AD)");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_ACCD,dataRow.getProperty("Sum Insured_ACCD"),"Sum Insured ACCD");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}

				//DTMT - Domestic Travel for Medical Treatment
				if(dataRow.getProperty("DTMT - Domestic Travel for Medical Treatment").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("DTMT"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(DTMTcoverlink,"DTMT - Domestic Travel for Medical Treatment");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_DTMT,dataRow.getProperty("Sum Insured_DTMT"),"Sum Insured DTMT");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
			}
		   
			//Click on CI - Critical Illness
			
			click(CriticalIllnessCover, "CI - Critical Illness");
			Thread.sleep(WaitTime.low);
		   
			java.util.List<WebElement> CriticalIllnessCover_list = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[3]/preceding::div[@id='CoverOptional']/ol/div"));
			
			for(int a=0;a<=CriticalIllnessCover_list.size();a++)
			{
				
				int b =a+4;
				String txtnm=(CriticalIllnessCover_list.get(a)).getText();
			
				
				//CIL - Critical Illness Benefit
				if(dataRow.getProperty("CIL - Critical Illness Benefit").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("CIL"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(CILcoverlink,"CIL - Critical Illness Benefit");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_CIL,dataRow.getProperty("Sum Insured_CIL"),"Sum Insured CIL");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(CoverageOption_CIL,dataRow.getProperty("Coverage Option_CIL"),"Coverage Option_CIL");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(CriticalIllnessesGroupCovered,dataRow.getProperty("Critical Illnesses Group Covered"),"Critical Illnesses Group Covered");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(SurvivalPeriodinDays_CIL,dataRow.getProperty("Survival Period in Days_CIL"),"Survival Period in Days_CIL");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//EDBC1 - Education Fund for Children
				if(dataRow.getProperty("EDBC1 - Education Fund for Children").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("EDBC1"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(EDBC1coverlink,"EDBC1 - Education Fund for Children");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_EDBC1,dataRow.getProperty("Sum Insured_EDBC1"),"Sum Insured EDBC1");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(CoverageOption_EDBC1,dataRow.getProperty("Coverage Option_EDBC1"),"Coverage Option_EDBC1");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(MaximumDependentChildren_EDBC1,dataRow.getProperty("Maximum Dependent Children_EDBC1"),"Maximum Dependent Children_EDBC1");
				Thread.sleep(WaitTime.low);
		
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//LOPC - Loan Protection
				
				if(dataRow.getProperty("LOPC - Loan Protection").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("LOPC"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(LOPCcoverlink,"LOPC - Loan Protection");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(EMICoverage_LOPC,dataRow.getProperty("EMI Coverage_LOPC"),"EMI Coverage_LOPC");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(CoverageLimitperEMI_LOPC,dataRow.getProperty("Coverage Limit per EMI_LOPC"),"Coverage Limit per EMI_LOPC");
				Thread.sleep(WaitTime.low);
		
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//MFC - Marriage Fund for Children
				if(dataRow.getProperty("MFC - Marriage Fund for Children").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("MFC"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(MFCcoverlink,"MFC - Marriage Fund for Children");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(CoverageOption_MFC,dataRow.getProperty("Coverage Option_MFC"),"Coverage Option_MFC");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(MaximumDependentChildren_MFC,dataRow.getProperty("Maximum Dependent Children_MFC"),"Maximum Dependent Children_MFC");
				Thread.sleep(WaitTime.low);
		
				clearAndSenKeys(SumInsured_MFC,dataRow.getProperty("Sum Insured_MFC"),"Sum Insured_MFC");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//RCB - Rehabilitation/ Counseling Benefit
				if(dataRow.getProperty("RCB - Rehabilitation/ Counseling Benefit").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("RCB"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(RCBcoverlink,"RCB - Rehabilitation/ Counseling Benefit");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(SumInsured_RCB,dataRow.getProperty("Sum Insured_RCB"),"Sum Insured_RCB");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//SCOP - Second E-opinion
				if(dataRow.getProperty("SCOP - Second E-opinion").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("SCOP"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//WECO - Wellness Coach
				
				if(dataRow.getProperty("WECO - Wellness Coach").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("WECO"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
			}
				
	}
	
	  public  void fillEmployeeDetailsGroup_AssureCovid19Page (WebDriver driver,XSSFWorkbook workbook,Connection conn,CustomAssert customAssert) throws Exception
	    {
		  String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
	       Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		   Reporter.log("<B>Traverse To Group_active_AssureCovid19Page</B>");
	  
	  
	    //VIRUSD - Virus Detection
		   if(dataRow.getProperty("VIRUSD(VirusDetection)").equalsIgnoreCase("Yes"))
			{
		    click(VirusDetectionCover, "VIRUSD - Virus Detection");
			Thread.sleep(WaitTime.low);
			}
		   
			java.util.List<WebElement> VirusDetectionCover_list = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[1]/preceding::div[@id='CoverOptional']/ol/div"));
				
			for(int a=0;a<=VirusDetectionCover_list.size();a++)
			{
				int b =a+2;
				String txtnm=(VirusDetectionCover_list.get(a)).getText();
		   
				//VDH - Virus Detection and Hospitalization
				if(dataRow.getProperty("VDH").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("VDH"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(VDHcoverlink,"VDH - Virus Detection and Hospitalization");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(VDHApplicability,dataRow.getProperty("VDHApplicability"),"Applicability");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(VDHSumInsured,dataRow.getProperty("VDHSumInsured"),"Sum Insured");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//VDPO - Virus Detection Pay out
				if(dataRow.getProperty("VDPO").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("VDPO"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(VDPOcoverlink,"VDPO - Virus Detection Pay out");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(VDPOApplicability,dataRow.getProperty("VDPOApplicability"),"Applicability");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(VDPOSumInsured,dataRow.getProperty("VDPOSumInsured"),"Sum Insured");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
			}
	    
			//OPTCVR - Optional Coverage
			if(dataRow.getProperty("OPTCVR(OptionalCoverage)").equalsIgnoreCase("Yes"))
			{
		    click(OptionalCoverage_19Cover, "OPTCVR - Optional Coverage");
			Thread.sleep(WaitTime.low);
			}
			
			java.util.List<WebElement> OptionalCoverageCover_list = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[2]/preceding::div[@id='CoverOptional']/ol/div"));
				
			for(int a=0;a<=OptionalCoverageCover_list.size();a++)
			{
				int b =a+3;
				String txtnm=(OptionalCoverageCover_list.get(a)).getText();
				
				//RT - Reunion Travel
				if(dataRow.getProperty("ReunionTravel(RT)").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("Reunion"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(RTcoverlink,"RT - Reunion Travel");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(RTSumInsured,dataRow.getProperty("RTSumInsured"),"Sum Insured");
				Thread.sleep(WaitTime.low);
				
				selectFromDropdownByVisibleText(RTApplicability,dataRow.getProperty("RTApplicability"),"Applicability");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
			}
	    
	    //HOSP - Hospitalization
			if(dataRow.getProperty("Hospitalization(HOSP)").equalsIgnoreCase("Yes"))
			{
		    click(HospitalizationCover, "HOSP - Hospitalization");
			Thread.sleep(WaitTime.low);
			}
			
			java.util.List<WebElement> HospitalizationCover_list = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[3]/preceding::div[@id='CoverOptional']/ol/div"));
				
			for(int a=0;a<=HospitalizationCover_list.size();a++)
			{
				int b =a+4;
				String txtnm=(HospitalizationCover_list.get(a)).getText();
	    
				//ERAC - Emergency Road Ambulance Cover
				if(dataRow.getProperty("ERAC").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("ERAC"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(ERACcoverlink,"ERAC - Emergency Road Ambulance Cover");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(ERACCoverageLimit,dataRow.getProperty("ERAC(CoverageLimit)"),"CoverageLimit");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//PRHM - Pre – hospitalization Medical Expenses
				if(dataRow.getProperty("PRHM").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("PRHM"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(PRHMcoverlink,"PRHM - Pre – hospitalization Medical Expenses");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(PRHMPreHospitalizationPeriod,dataRow.getProperty("PRHM(Pre-Hospitalization Period)"),"PRHM(Pre-Hospitalization Period)");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//POHM - Post – hospitalization Medical Expenses
				if(dataRow.getProperty("POHM").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("POHM"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				
				click(POHMcoverlink_19,"POHM - Post – hospitalization Medical Expenses");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(POHMPostHospitalizationPeriod,dataRow.getProperty("POHM(Post-HospitalizationPeriod)"),"POHM(Post-HospitalizationPeriod)");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
				//IPTT - In-patient Hospitalization
				if(dataRow.getProperty("IPTT").equalsIgnoreCase("Yes"))
				{
				if(txtnm.contains("IPTT"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					Ele.click();
					
					try
					{
						Ele.click();
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					break;
				}
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				
	    
	    
			}
	    
	   }
	  
	  public  void fillEmployeeDetailsGroup_active_TravelPage (WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	  												
	  {
		  String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
	       Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		   Reporter.log("<B>Traverse To Group_active_TravelPage</B>");
		  
		   //OETOOPCVR - Optional Extensions to Out Patient Cover
		   
		   if(dataRow.getProperty("OETOOPCVR").equalsIgnoreCase("Yes"))
			{
			   click(OETOOPCVRCover, "OETOOPCVR - Optional Extensions to Out Patient Cover");
			
			}
		   
		   
		    
		    java.util.List<WebElement> list = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[1]/preceding::div[@id='CoverOptional']/ol/div"));
		    int count=1;
		    
			for(int a=0;a<=list.size();a++)
			{
			
				int b =a+2;
				
				//int c= a+count;
//				String txtnm=(list.get(a)).getText();
				String txtnm=driver.findElement(By.xpath("(//button[contains(text(),'Add')])[1]/preceding::div[@id='CoverOptional']/ol/div["+count+"]")).getText();
				count=count/count;
				//CSM - Cancer screening & Mammography
				if(txtnm.contains("CSM"))
				{
					if(dataRow.getProperty("CSM").equalsIgnoreCase("Yes"))
					{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					
					try
					{
						Ele.click();
						Thread.sleep(WaitTime.low);
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					
				
				
						click(CSMcoverlink,"CSM - Cancer screening & Mammography");
						Thread.sleep(WaitTime.low);
				
						clearAndSenKeys(CSM_SimInsured,dataRow.getProperty("CSM_SimInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
				
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
				
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
					}
					else 
					{
						count=count+1;
						
					}
					
				}
				
				
				//VCCV - Vaccination Charges
				if(txtnm.contains("VCCV"))
				{
				if(dataRow.getProperty("VCCV").equalsIgnoreCase("Yes"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					
					try
					{
						Ele.click();
						Thread.sleep(WaitTime.low);
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					
				
				click(VCCVcoverlink_Travel,"VCCV - Vaccination Charges");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(VCCV_SumInsured,dataRow.getProperty("VCCV_SumInsured"),"Sum Insured");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				else
				{
					count=count+1;
					
				}
				}
				
				//RCC - Radiotherapy and Chemotherapy Charges
				if(txtnm.contains("RCC"))
				{
				if(dataRow.getProperty("RCC").equalsIgnoreCase("Yes"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					
					try
					{
						Ele.click();
						Thread.sleep(WaitTime.low);
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					
				
				
				click(RCCcoverlink_Travel,"RCC - Radiotherapy and Chemotherapy Charges");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(RCC_SumInsured,dataRow.getProperty("RCC_SumInsured"),"Sum Insured");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				else
				{
					count=count+1;
					
				}
				}
				
				//TMNDOT - Treatment of Mental & Nervous Disorder
				if(txtnm.contains("TMNDOT"))
				{
				if(dataRow.getProperty("TMNDOT").equalsIgnoreCase("Yes"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					
					try
					{
						Ele.click();
						Thread.sleep(WaitTime.low);
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					
				
				
				click(TMNDOTcoverlink_Travel,"TMNDOT - Treatment of Mental & Nervous Disorder");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(TMNDOT_SumInsured,dataRow.getProperty("TMNDOT_SumInsured"),"Sum Insured");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				else
				{
					count=count+1;
					
				}
				}
				
				
				//PMC - Psychological and Mental Counselling
				if(txtnm.contains("PMC"))
				{
				if(dataRow.getProperty("PMC").equalsIgnoreCase("Yes"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					
					try
					{
						Ele.click();
						Thread.sleep(WaitTime.low);
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					
				
				
				click(PMCcoverlink_Travel,"PMC - Psychological and Mental Counselling");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(PMC_SumInsured,dataRow.getProperty("TMNDOT_SumInsured"),"Sum Insured");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				else
				{
					count=count+1;
					
				}
				}
				
				
				//NEOPD - Non-emergency OPD consultation
				if(txtnm.contains("NEOPD"))
				{
				if(dataRow.getProperty("NEOPD").equalsIgnoreCase("Yes"))
				{
					
					WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
					
					try
					{
						Ele.click();
						Thread.sleep(WaitTime.low);
					}
					catch(Exception e) {}
					//click((By) Ele,"ADD Button");
					click(Addcoverbtn,"ADD Button");
					boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
					if (okBTNIPTT == true) 
					{
						click(OKBtn,"OK");
					}
					
				
				
				click(NEOPDcoverlink,"PMC - Psychological and Mental Counselling");
				Thread.sleep(WaitTime.low);
				
				clearAndSenKeys(NEOPD_SumInsured,dataRow.getProperty("NEOPD_SumInsured"),"Sum Insured");
				Thread.sleep(WaitTime.low);
				
				click(savebasecoverbtn,"Save btn");
				Thread.sleep(WaitTime.low);
				
				click(OKBtn,"OK");
				Thread.sleep(WaitTime.low);
				}
				else
				{
						count=count+1;
						
						
				}
			}
			
	}
			
			
			
			//OETOMCVR - Optional Extensions to Medical Cover
			   
			   if(dataRow.getProperty("OETOMCVR").equalsIgnoreCase("Yes"))
				{
				   click(OETOMCVRCover, "OETOMCVR - Optional Extensions to Medical Cover");
				}
			   
				java.util.List<WebElement> OETOMCVRCoverlist = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[2]/preceding::div[@id='CoverOptional']/ol/div"));
				
				for(int a=0;a<=OETOMCVRCoverlist.size();a++)
				{
					int b =a+3;
					String txtnm=(OETOMCVRCoverlist.get(a)).getText();
					
					
					//PSI - Professional Sports Injury
					if(dataRow.getProperty("PSI").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("PSI"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
							Thread.sleep(WaitTime.low);
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						
					
					
					click(PSIcoverlink,"PSI - Professional Sports Injury");
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(PSI_SumInsured,dataRow.getProperty("PSI_SumInsured"),"Sum Insured");
					Thread.sleep(WaitTime.low);
					
					click(savebasecoverbtn,"Save btn");
					Thread.sleep(WaitTime.low);
					
					click(OKBtn,"OK");
					Thread.sleep(WaitTime.low);
					}
					}
					
					//ADSB - Adventure Sports Injury
					if(dataRow.getProperty("ADSB").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("ADSB"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
							Thread.sleep(WaitTime.low);
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						
					
					
					click(ADSBcoverlink,"ADSB - Adventure Sports Injury");
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(ADSB_SumInsured,dataRow.getProperty("ADSB_SumInsured"),"Sum Insured");
					Thread.sleep(WaitTime.low);
					
					click(savebasecoverbtn,"Save btn");
					Thread.sleep(WaitTime.low);
					
					click(OKBtn,"OK");
					Thread.sleep(WaitTime.low);
					}
					}
					
					//MT - Maternity
					if(dataRow.getProperty("MT").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("MT"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
							Thread.sleep(WaitTime.low);
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						
					
					
					click(MTcoverlink,"MT - Maternity");
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(MT_SumInsured,dataRow.getProperty("MT_SumInsured"),"Sum Insured");
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(MT_PrePostNatalExpensesLimit,dataRow.getProperty("MT_PrePostNatalExpensesLimit"),"Pre Natal and Post Natal Expenses Limit");
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(MT_NoOfClaimsLimit,dataRow.getProperty("MT_NoOfClaimsLimit"),"Number of claims Limit");
					Thread.sleep(WaitTime.low);
					
					
					selectFromDropdownByVisibleText(MT_ClaimOption,dataRow.getProperty("MT_ClaimOption"),"Claim Option");
					Thread.sleep(WaitTime.low);
					
					selectFromDropdownByVisibleText(MT_MinTravelDayForEligibility,dataRow.getProperty("MT_MinTravelDayForEligibility"),"Min Travel Day For Eligibility");
					Thread.sleep(WaitTime.low);
					
					selectFromDropdownByVisibleText(MT_WaitingPeriodInMonths,dataRow.getProperty("MT_WaitingPeriodInMonths"),"Waiting Period in months");
					Thread.sleep(WaitTime.low);
					
					selectFromDropdownByVisibleText(MT_PrePostNatalExpenses,dataRow.getProperty("MT_PrePostNatalExpenses"),"Pre Natal and Post Natal Expenses");
					Thread.sleep(WaitTime.low);
					
					click(savebasecoverbtn,"Save btn");
					Thread.sleep(WaitTime.low);
					
					click(OKBtn,"OK");
					Thread.sleep(WaitTime.low);
					}
					}
					
					//MCOM - Maternity Complications
					
					if(dataRow.getProperty("MCOM").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("MCOM"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
							Thread.sleep(WaitTime.low);
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						
					
					
					click(MCOMcoverlink,"MCOM - Maternity Complications");
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(MCOM_SumInsured,dataRow.getProperty("MCOM_SumInsured"),"Sum Insured");
					Thread.sleep(WaitTime.low);
					
					click(savebasecoverbtn,"Save btn");
					Thread.sleep(WaitTime.low);
					
					click(OKBtn,"OK");
					Thread.sleep(WaitTime.low);
					}
					}
					
					//DAA - Drug And Alcohol Abuse
					
					if(dataRow.getProperty("DAA").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("DAA"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
							Thread.sleep(WaitTime.low);
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						
					
					
					click(DAAcoverlink,"DAA - Drug And Alcohol Abuse");
					Thread.sleep(WaitTime.low);
					
					selectFromDropdownByVisibleText(DAA_CoverageLimit,dataRow.getProperty("DAA_CoverageLimit"),"Coverage Limit (in %)");
					Thread.sleep(WaitTime.low);
					
					click(savebasecoverbtn,"Save btn");
					Thread.sleep(WaitTime.low);
					
					click(OKBtn,"OK");
					Thread.sleep(WaitTime.low);
					}
					}
					
					//CF - Corporate Floater
					if(dataRow.getProperty("CF").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("CF"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
							Thread.sleep(WaitTime.low);
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						
					
					
					click(CFcoverlink,"CF - Corporate Floater");
					Thread.sleep(WaitTime.low);
					
					selectFromDropdownByVisibleText(CF_ClaimOption,dataRow.getProperty("CF_ClaimOption"),"Claim option");
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(CF_SumInsured,dataRow.getProperty("CF_SumInsured"),"Sum Insured");
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(CF_NoOfClaimsUnit,dataRow.getProperty("CF_NoOfClaimsUnit"),"Number of claims Limit");
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(CF_MaxAmountPerClaim,dataRow.getProperty("CF_MaxAmountPerClaim"),"Maximum Amount Per Claim");
					Thread.sleep(WaitTime.low);
					
					click(savebasecoverbtn,"Save btn");
					Thread.sleep(WaitTime.low);
					
					click(OKBtn,"OK");
					Thread.sleep(WaitTime.low);
					}
					}
					
					//PEDMC - Pre-Existing Disease Cover In Life Threatening Medical Condition
					if(dataRow.getProperty("PEDMC").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("PEDMC"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
							Thread.sleep(WaitTime.low);
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						
					
					
					click(PEDMCcoverlink,"PEDMC - Pre-Existing Disease Cover In Life Threatening Medical Condition");
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(PEDMC_CoverageLimit,dataRow.getProperty("PEDMC_CoverageLimit"),"Coverage Limit (in %)");
					Thread.sleep(WaitTime.low);
					
					click(savebasecoverbtn,"Save btn");
					Thread.sleep(WaitTime.low);
					
					click(OKBtn,"OK");
					Thread.sleep(WaitTime.low);
					}
					}
					
					//SII - Self-Inflicted Injury
					if(dataRow.getProperty("SII").equalsIgnoreCase("Yes"))
					{
					if(txtnm.contains("SII"))
					{
						
						WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
						Ele.click();
						
						try
						{
							Ele.click();
							Thread.sleep(WaitTime.low);
						}
						catch(Exception e) {}
						//click((By) Ele,"ADD Button");
						click(Addcoverbtn,"ADD Button");
						boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
						if (okBTNIPTT == true) 
						{
							click(OKBtn,"OK");
						}
						
					
					
					click(SIIcoverlink,"SII - Self-Inflicted Injury");
					Thread.sleep(WaitTime.low);
					
					selectFromDropdownByVisibleText(SII_CoverageLimit,dataRow.getProperty("SII_CoverageLimit"),"Coverage Limit (in %)");
					Thread.sleep(WaitTime.low);
					
					click(savebasecoverbtn,"Save btn");
					Thread.sleep(WaitTime.low);
					
					click(OKBtn,"OK");
					Thread.sleep(WaitTime.low);
					}
					
				}
					
		}
			
				//MEDICALCVR - Medical Cover
				   
				   if(dataRow.getProperty("MEDICALCVR").equalsIgnoreCase("Yes"))
					{
					   click(MEDICALCVRCover, "MEDICALCVR - Medical Cover");
					}
				   
					java.util.List<WebElement> MEDICALCVRCoverlist = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[3]/preceding::div[@id='CoverOptional']/ol/div"));
					
					for(int a=0;a<=MEDICALCVRCoverlist.size();a++)
					{
						int b =a+4;
						String txtnm=(MEDICALCVRCoverlist.get(a)).getText();
						
						//IPIDC - In-patient Care For Injury with day care treatment
						if(dataRow.getProperty("IPIDC").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("IPIDC"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(IPIDCcoverlink,"IPIDC - In-patient Care For Injury with day care treatment");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(IPIDC_CoPay,dataRow.getProperty("IPIDC_CoPay"),"Co-Pay");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(IPIDC_RestrictionForEmergencyCare,dataRow.getProperty("IPIDC_RestrictionForEmergencyCare"),"Restriction for Emergency Care");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(IPIDC_AutomaticExtensionDateLimit,dataRow.getProperty("IPIDC_AutomaticExtensionDateLimit"),"Automatic Extension Days Limit");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(IPIDC_AutomaticExtensionLimit,dataRow.getProperty("IPIDC_AutomaticExtensionLimit"),"Automatic Extension Limit");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(IPIDC_Discount,dataRow.getProperty("IPIDC_Discount %"),"Discount %");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(IPIDC_SumInsured,dataRow.getProperty("IPIDC_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(IPIDC_PerHospitalizationMinLimit,dataRow.getProperty("IPIDC_PerHospitalizationMinLimit"),"Per Hospitalization Min Limit");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//IPDCT - In-patient Care with day care treatment
						if(dataRow.getProperty("IPDCT").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("IPDCT"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(IPDCTCcoverlink,"IPDCT - In-patient Care with day care treatment");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(IPDCT_CoPay,dataRow.getProperty("IPDCT_CoPay"),"Co-Pay");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(IPDCT_RestrictionForEmergencyCare,dataRow.getProperty("IPDCT_RestrictionForEmergencyCare"),"Restriction for Emergency Care");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(IPDCT_AutomaticExtensionDaysLimit,dataRow.getProperty("IPDCT_AutomaticExtensionDaysLimit"),"Automatic Extension Days Limit");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(IPDCT_AutomaticExtensionLimit,dataRow.getProperty("IPDCT_AutomaticExtensionLimit"),"Automatic Extension Limit");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(IPDCT_Discount,dataRow.getProperty("IPDCT_Discount %"),"Discount %");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(IPDCT_SumInsured,dataRow.getProperty("IPDCT_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(IPDCT_PerHospitalizationMinLimit,dataRow.getProperty("IPDCT_PerHospitalizationMinLimit"),"Per Hospitalization Min Limit");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
					}
			
					//OBTOMCVR - Optional Benefits to Medical Cover
					
					if(dataRow.getProperty("OBTOMCVR").equalsIgnoreCase("Yes"))
					{
					   click(OBTOMCVRCover, "OBTOMCVR - Optional Benefits to Medical Cover");
					}
			
					java.util.List<WebElement> OBTOMCVRCoverlist = driver.findElements(By.xpath("(//button[contains(text(),'Add')])[4]/preceding::div[@id='CoverOptional']/ol/div"));
					
					for(int a=0;a<=OBTOMCVRCoverlist.size();a++)
					{
						int b =a+5;
						String txtnm=(OBTOMCVRCoverlist.get(a)).getText();
						
						//RMEX - Repatriation of Mortal Remains
						
						if(dataRow.getProperty("RMEX").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("RMEX"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(RMEXcoverlink,"RMEX - Repatriation of Mortal Remains");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(RMEX_SumInsured,dataRow.getProperty("RMEX_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//PACCI - Personal Accident
						if(dataRow.getProperty("PACCI").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("PACCI"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(PACCIcoverlink,"PACCI - Personal Accident");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(PACCI_CoverageOption,dataRow.getProperty("PACCI_CoverageOption"),"Coverage Option");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(PACCI_PTDLimit,dataRow.getProperty("PACCI_PTDLimit"),"PTD Limit");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(PACCI_SumInsured,dataRow.getProperty("PACCI_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(PACCI_DeathLimit,dataRow.getProperty("PACCI_DeathLimit"),"Death Limit");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(PACCI_MaximumAggregatePolicyLimit,dataRow.getProperty("PACCI_MaximumAggregatePolicyLimit"),"	Maximum aggregate Policy limit");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//DCB - Delay of Checked-in Baggage
						if(dataRow.getProperty("DCB").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("DCB"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(DCBcoverlink,"DCB - Delay of Checked-in Baggage");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(DCB_DeductibleInHours,dataRow.getProperty("DCB_DeductibleInHours"),"Deductible in hours");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(DCB_SumInsured,dataRow.getProperty("DCB_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						
						//LOCB - Loss of Checked-in Baggage
						if(dataRow.getProperty("LOCB").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("LOCB"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(LOCBcoverlink,"LOCB - Loss of Checked-in Baggage");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(LOCB_Deductible,dataRow.getProperty("LOCB_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(LOCB_SumInsured,dataRow.getProperty("LOCB_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//LOP - Loss of Passport
						if(dataRow.getProperty("LOP").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("LOP"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(LOPcoverlink,"LOP - Loss of Passport");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(LOP_Deductible,dataRow.getProperty("LOP_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(LOP_SumInsured,dataRow.getProperty("LOP_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//ME - Medical Evacuation
						if(dataRow.getProperty("ME").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("Medical"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(MEcoverlink_Travel,"ME - Medical Evacuation");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(ME_Deductible,dataRow.getProperty("ME_Deductible"),"Deductible in hours");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(ME_SumInsured,dataRow.getProperty("ME_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//OPC - Out-patient Care
						if(dataRow.getProperty("OPC").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("OPC"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(OPCcoverlink_Travel,"OPC - Out-patient Care");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(OPC_CoPay,dataRow.getProperty("OPC_CoPay"),"Co Pay");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(OPC_Deductible,dataRow.getProperty("OPC_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(OPC_SumInsured,dataRow.getProperty("OPC_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//BBD - Bail Bond
						if(dataRow.getProperty("BBD").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("BBD"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(BBDcoverlink_Travel,"BBD - Bail Bond");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(BBD_SumInsured,dataRow.getProperty("BBD_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}

						//CCF - Common Carrier Fatality
						if(dataRow.getProperty("CCF").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("CCF"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(CCFcoverlink_Travel,"CCF - Common Carrier Fatality");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(CCF_SumInsured,dataRow.getProperty("CCF_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(CCF_BenefitOptions,dataRow.getProperty("CCF_BenefitOptions"),"Benefit Options");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//CV - Compassionate Visit
						if(dataRow.getProperty("CV").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("Compassionate"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(CVcoverlink_Travel,"CV - Compassionate Visit");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(CV_SumInsured,dataRow.getProperty("CV_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(CV_Deductible,dataRow.getProperty("CV_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(CV_MinimumDaysOfHospitalization,dataRow.getProperty("CV_MinimumDaysOfHospitalization"),"Minimum days of hospitalization");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//DCOI - Dental Expenses
						if(dataRow.getProperty("DCOI").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("DCOI"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(DCOIcoverlink_Travel,"DCOI - Dental Expenses");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(DCOI_SumInsured,dataRow.getProperty("DCOI_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(DCOI_Deductible,dataRow.getProperty("DCOI_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//ECA - Emergency Cash Advance
						if(dataRow.getProperty("ECA").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("ECA"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							break;
						}
						}
						
						//EHAE - Emergency Hotel Accommodation / Extension
						if(dataRow.getProperty("EHAE").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("EHAE"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(EHAEcoverlink_Travel,"EHAE - Emergency Hotel Accommodation / Extension");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(EHAE_SumInsured,dataRow.getProperty("EHAE_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(EHAE_Deductible,dataRow.getProperty("EHAE_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//EHV - Emergency Home Visit
						if(dataRow.getProperty("EHV").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("EHV"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(EHVcoverlink_Travel,"EHV - Emergency Home Visit");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(EHV_SumInsured,dataRow.getProperty("EHV_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//GFO - Golf fees and other non transferable ticket expenses
						if(dataRow.getProperty("GFO").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("GFO"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(GFOcoverlink_Travel,"GFO - Golf fees and other non transferable ticket expenses");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(GFO_SumInsured,dataRow.getProperty("GFO_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(GFO_Deductible,dataRow.getProperty("GFO_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//HAD - Hijack distress allowance
						if(dataRow.getProperty("HAD").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("HAD"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(HADcoverlink_Travel,"HAD - Hijack distress allowance");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(HAD_LimitPerDay,dataRow.getProperty("HAD_LimitPerDay"),"Limit Per day");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(HAD_DeductibleInHours,dataRow.getProperty("HAD_DeductibleInHours"),"Deductible In Hours");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//HB - Home Burglary
						if(dataRow.getProperty("HB").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("Burglary"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(HBcoverlink_Travel,"HB - Home Burglary");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(HB_SumInsured,dataRow.getProperty("HB_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(HB_Deductible,dataRow.getProperty("HB_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//HC - Home Care
						if(dataRow.getProperty("HC").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("Home Care"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(HCcoverlink_Travel,"HB - Home Burglary");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(HC_Deductible,dataRow.getProperty("HC_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(HC_LimitPerDay,dataRow.getProperty("HC_LimitPerDay"),"Limit Per Day");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//HCT - Hotel Cancellation
						if(dataRow.getProperty("HCT").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("HCT"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(HCTcoverlink_Travel,"HCT - Hotel Cancellation");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(HCT_SumInsured,dataRow.getProperty("HCT_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(HCT_Deductible,dataRow.getProperty("HCT_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//HLCU - Health Check-up
						if(dataRow.getProperty("HLCU").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("HLCU"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						click(HLCUcoverlink_Travel,"HLCU - Health Check-up");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(HLCU_SumInsured,dataRow.getProperty("HLCU_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(HLCU_Deductible,dataRow.getProperty("HLCU_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(HLCU_CoPay,dataRow.getProperty("HLCU_CoPay"),"Co Pay");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//HOCB - Daily Allowance
						if(dataRow.getProperty("HOCB").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("HOCB"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(HOCBcoverlink_Travel,"HOCB - Daily Allowance");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(HOCB_LimitPerDay,dataRow.getProperty("HOCB_LimitPerDay"),"Limit Per Day");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(HOCB_DeductibleInDays,dataRow.getProperty("HOCB_DeductibleInDays"),"Deductible in days");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//IDT - Identity Document Theft
						if(dataRow.getProperty("IDT").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("IDT"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(IDTcoverlink_Travel,"IDT - Identity Document Theft");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(IDT_SumInsured,dataRow.getProperty("IDT_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(IDT_Deductible,dataRow.getProperty("IDT_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//LLTHM - Loss of Laptop/ Tablet / Hand baggage / Mobile
						if(dataRow.getProperty("LLTHM").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("LLTHM"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(LLTHMcoverlink_Travel,"LLTHM - Loss of Laptop/ Tablet / Hand baggage / Mobile");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(LLTHM_SumInsured,dataRow.getProperty("LLTHM_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(LLTHM_Deductible,dataRow.getProperty("LLTHM_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(LLTHM_CoPay,dataRow.getProperty("LLTHM_CoPay"),"Co Pay");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//LSE - Lifestyle Support
						if(dataRow.getProperty("LSE").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("LSE"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(LSEcoverlink_Travel,"LSE - Lifestyle Support");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(LSE_SumInsured,dataRow.getProperty("LSE_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//MCON - Missed Connection
						if(dataRow.getProperty("MCON").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("MCON"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(MCONcoverlink_Travel,"MCON - Missed Connection");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(MCON_SumInsured,dataRow.getProperty("MCON_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(MCON_DeductibleInHours,dataRow.getProperty("MCON_DeductibleInHours"),"Deductible In Hours");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//MGC - Mugging Cover
						if(dataRow.getProperty("MGC").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("MGC"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(MGCcoverlink_Travel,"MGC - Mugging Cover");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(MGC_SumInsured,dataRow.getProperty("MGC_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//MTEX - Maternity Cash Benefit
						if(dataRow.getProperty("MTEX").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("MTEX"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(MTEXcoverlink_Travel,"MTEX - Maternity Cash Benefit");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(MTEX_SumInsured,dataRow.getProperty("MTEX_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(MTEX_WaitingPeriodInMonths,dataRow.getProperty("MTEX_WaitingPeriodInMonths"),"Waiting Period In Months");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//MTMCI - Mid Trip Medical cover continuance in India
						if(dataRow.getProperty("MTMCI").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("MTMCI"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(MTMCIcoverlink_Travel,"MTMCI - Mid Trip Medical cover continuance in India");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(MTMCI_SumInsured,dataRow.getProperty("MTMCI_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(MTMCI_Deductible,dataRow.getProperty("MTMCI_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(MTMCI_CoPay,dataRow.getProperty("MTMCI_CoPay"),"Co-Pay");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(MTMCI_MaximumDaysCovered,dataRow.getProperty("MTEX_WaitingPeriodInMonths"),"Maximum Days Covered");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//OPCI - Out-patient Care for Injury
						if(dataRow.getProperty("OPCI").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("OPCI"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(OPCIcoverlink_Travel,"OPCI - Out-patient Care for Injury");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(OPCI_SumInsured,dataRow.getProperty("OPCI_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(OPCI_Deductible,dataRow.getProperty("OPCI_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(OPCI_CoPay,dataRow.getProperty("OPCI_CoPay"),"Co-Pay");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						
						//PACCOM - Parent Accommodation
						if(dataRow.getProperty("PACCOM").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("PACCOM"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(PACCOMcoverlink_Travel,"OPCI - Out-patient Care for Injury");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(PACCOM_SumInsured,dataRow.getProperty("PACCOM_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(PACCOM_Deductible,dataRow.getProperty("PACCOM_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(PACCOM_CoPay,dataRow.getProperty("PACCOM_CoPay"),"Co-Pay");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//PL - Personal Liability
						if(dataRow.getProperty("PL").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("Personal Liability"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(PLcoverlink_Travel,"PL - Personal Liability");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(PL_SumInsured,dataRow.getProperty("PL_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(PL_Deductible,dataRow.getProperty("PL_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//PRCE - Political Risk and Catastrophe Evacuation
						if(dataRow.getProperty("PRCE").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("PRCE"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(PRCEcoverlink_Travel,"OPCI - Out-patient Care for Injury");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(PRCE_SumInsured,dataRow.getProperty("PRCE_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(PRCE_Deductible,dataRow.getProperty("PRCE_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(PRCE_HotelAccommodationperdaylimit,dataRow.getProperty("PRCE_HotelAccommodationperdaylimit"),"Hotel Accommodation per day limit");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//RMC - Return of Minor Child
						if(dataRow.getProperty("RMC").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("RMC"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(RMCcoverlink_Travel,"RMC - Return of Minor Child");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(RMC_SumInsured,dataRow.getProperty("RMC_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(RMC_Deductible,dataRow.getProperty("RMC_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(RMC_MinDaysOfHospitalization,dataRow.getProperty("RMC_MinDaysOfHospitalization"),"Minimum days of hospitalization");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//RS - Replacement of Staff
						if(dataRow.getProperty("RS").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("Replacement of Staff"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(RSCcoverlink_Travel,"RS - Replacement of Staff");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(RS_SumInsured,dataRow.getProperty("RS_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(RS_Deductible,dataRow.getProperty("RS_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//SI - Study Interruption
						if(dataRow.getProperty("SI").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("Study Interruption"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(SIcoverlink_Travel,"SI - Study Interruption");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(SI_SumInsured,dataRow.getProperty("SI_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//SP - Sponsor Protection
						if(dataRow.getProperty("SP").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("Sponsor Protection"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(SPcoverlink_Travel,"SP - Sponsor Protection");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(SP_SumInsured,dataRow.getProperty("SP_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//TCI - Trip Cancellation & Interruption
						if(dataRow.getProperty("TCI").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("TCI"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(TCIcoverlink_Travel,"TCI - Trip Cancellation & Interruption");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(TCI_SumInsured,dataRow.getProperty("TCI_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(TCI_Deductible,dataRow.getProperty("TCI_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//TD - Trip Delay
						if(dataRow.getProperty("TD").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("Trip Delay"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(TDcoverlink_Travel,"TD - Trip Delay");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(TD_SumInsured,dataRow.getProperty("TD_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(TD_DeductibleUnit,dataRow.getProperty("TD_DeductibleUnit"),"Deductible Unit");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(TD_Deductible,dataRow.getProperty("TD_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//UGBC - Up-gradation to Business Class
						if(dataRow.getProperty("UGBC").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("UGBC"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(UGBCcoverlink_Travel,"UGBC - Up-gradation to Business Class");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(UGBC_SumInsured,dataRow.getProperty("UGBC_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						selectFromDropdownByVisibleText(UGBC_MinimumDaysOfHospitalization,dataRow.getProperty("UGBC_MinimumDaysOfHospitalization"),"Minimum Days Of Hospitalization");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						//BB - Bounced Booking
						if(dataRow.getProperty("BB").equalsIgnoreCase("Yes"))
						{
						if(txtnm.contains("Bounced Booking"))
						{
							
							WebElement Ele = driver.findElement(By.xpath("//span[contains(text(),'Cover Groups')]//following::input["+b+"]"));
							Ele.click();
							
							try
							{
								Ele.click();
							}
							catch(Exception e) {}
							//click((By) Ele,"ADD Button");
							click(Addcoverbtn,"ADD Button");
							boolean okBTNIPTT = getSize(By.xpath("//button[contains(text(),'OK')]"),"Button") !=0;
							if (okBTNIPTT == true) 
							{
								click(OKBtn,"OK");
							}
							
						
						click(BBcoverlink_Travel,"BB - Bounced Booking");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(BB_SumInsured,dataRow.getProperty("BB_SumInsured"),"Sum Insured");
						Thread.sleep(WaitTime.low);
						
						clearAndSenKeys(BB_Deductible,dataRow.getProperty("BB_Deductible"),"Deductible");
						Thread.sleep(WaitTime.low);
						
						click(savebasecoverbtn,"Save btn");
						Thread.sleep(WaitTime.low);
						
						click(OKBtn,"OK");
						Thread.sleep(WaitTime.low);
						}
						}
						
						
				}
					
	  
	  
	  }
}
	  
	  
	  
	  
	  
	  
	  


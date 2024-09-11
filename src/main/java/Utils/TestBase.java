package Utils;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import javax.mail.MessagingException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


//import AshBrokerage.core.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	protected final Logger logger = LogManager.getLogger(getClass());
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static FileReader fileReader;
	//public WebDriver driver;
	public static WebDriver driver;
	public static Date date = new Date();
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	public static String dt = formatter.format(date);
	public static String reportDestination = "Report_Generator/Crowdfunding_App_Report" + dt + ".html";
	
	/*
	
	public static WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void initialize(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://dynamic-advisor-qa.techf.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			System.out.println("chrome is launched");
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://dynamic-advisor-qa.techf.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			System.out.println("firefox is launched");
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://dynamic-advisor-qa.techf.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			System.out.println("edgedriver is launched");
			
		}
		
	}*/

	/*	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			System.out.println("Google Chrome browser launched successfully.");
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			System.out.println("FirefoxDriver browser opened successfully.");
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			System.out.println("Microsoft Edge browser opened successfully.");
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Browser not supported: " + browser);
		}
		driver.manage().window().maximize();
		 Frontend : driver.get("https://crowdfunding-frontend-delta.vercel.app");
		 Backend  : driver.get("https://crowdfunding-admin-gamma.vercel.app");
	}  
	*/

	/*	 @BeforeMethod
	 @Parameters("browser")
	 public void setup(@Optional("chrome") String browser) {
	public void lunchBroeser(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://crowdfunding-frontend-delta.vercel.app");
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://crowdfunding-frontend-delta.vercel.app");
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://crowdfunding-frontend-delta.vercel.app");
			
			break;
		default:
			
			driver = null;
			
			break;
			
		}

	 } */

	/* 	public WebDriver setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://crowdfunding-frontend-delta.vercel.app");
		return driver;
	} */

	@BeforeTest(alwaysRun=true)
	public void setup() {       
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://crowdfunding-frontend-delta.vercel.app");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		System.out.println("Google Chrome browser launched successfully.");
	}
	
	@BeforeSuite(alwaysRun = true)
	public void reportsetup() throws IOException {
		extentReportSpark();
	}
	
	public void extentReportSpark() throws IOException {
		//Extent Reports, Extent Spark Report
		// Delete everything from reports folder expect .gitkeep
		File dir = new File(System.getProperty("user.dir") + "/Report_Generator");
		File[] files = dir.listFiles();
		for (File file : files) {
			// convert the file name into string
			String fileName = file.toString();
			int index = fileName.lastIndexOf('.');
			if (index > 0) {
				String extension = fileName.substring(index + 1);
				if (extension.equalsIgnoreCase("html") || extension.equalsIgnoreCase("zip")) {
					String filePath = fileName;
					File deleteFile = new File(filePath);
					deleteFile.delete();
				}
			}
		}

		spark = new ExtentSparkReporter(reportDestination);  
		extent = new ExtentReports();
		extent.attachReporter(spark);

		spark.config().setDocumentTitle("Crowd Funding Automation Testing Report");
		spark.config().setReportName("Crowd Funding Automation Test Suite");
		spark.config().setResourceCDN(dt);
		spark.config().setTimelineEnabled(Boolean.TRUE);
		spark.config().setOfflineMode(Boolean.TRUE);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		spark.config().setTimelineEnabled(Boolean.TRUE);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Device processor" , "Intel(R) Core(TM) i5-4590 CPU @ 3.30GHz 3.30 GHz");
		extent.setSystemInfo("Installed RAM Device" , "8,00 GB");
		extent.setSystemInfo("System type" , "4-bit operating system");
		extent.setSystemInfo("Execution Platform", "Windows 10 Pro");
		extent.setSystemInfo("Execution Platform Vession", "22H2");
		extent.setSystemInfo("Test Environment", "Staging (https:// dynamic-advisor-qa.techf.com)");
		extent.setSystemInfo("Execution Browser","Chrome");
		extent.setSystemInfo("Report Generator By","Mahendra Chauhan");
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException,MessagingException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED " + result.getName());  //
			test.log(Status.FAIL, "TEST CASE FAILED " + result.getThrowable());
			String pathString=TestBase.screenShot(driver, result.getName());
			test.addScreenCaptureFromPath(pathString);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED " + result.getName());
		}
	// driver.close();
	}
	
	@AfterTest
	public void afterTest() {
		 driver.close();
	}
	
	@AfterSuite
	public void endReports() {
		extent.flush();
	}
	
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshot_Attachment\\" + filename + "_" + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return destination;
	}
	
	/* @AfterMethod 
	public void tearDown() {
		if (driver != null) {
			 driver.quit(); 
		}
	}*/
}
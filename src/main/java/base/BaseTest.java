package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import utils.EmailUtils;
import utils.ExtentReprts;
import utils.Log;
public class BaseTest {

	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;

	@BeforeSuite
	public void setupReport() {
		extent = ExtentReprts.getReportInstance();
	}

	@AfterSuite
	public void teardownReport() {
		extent.flush();

		String reportPath = ExtentReprts.reportPath;
		EmailUtils.sendTestReport(reportPath);

	}

	@BeforeMethod
	public void setup() {
		Log.info("Starting Webdriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("navigating to url");
		driver.get("https://admin-demo.nopcommerce.com/login");
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshotPath = ExtentReprts.captureScreenshot(driver, "LoginFailure");
			test.fail("Test Failed..Screenshotattached.",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		if (driver != null) {
			Log.info("closing browser");
			driver.quit();
		}
	}
}

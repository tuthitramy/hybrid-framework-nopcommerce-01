package commons;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class BaseTest {
	public WebDriver driver;
	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case ("chrome"):
			System.setProperty("webdriver.chrome.driver",
					GlobalConstants.PROJECT_PATH + "\\browserDriver_main\\chromedriver.exe");
			driver = new ChromeDriver();

			break;
		case ("firefox"):
			System.setProperty("webdriver.gecko.driver",
					GlobalConstants.PROJECT_PATH + "\\browserDriver_main\\geckodriver.exe");
			driver = new FirefoxDriver();

			break;

		case ("edge"):
			System.setProperty("webdriver.edge.driver",
					GlobalConstants.PROJECT_PATH + "\\browserDriver_main\\msedgedriver.exe");
			driver = new EdgeDriver();

			break;

		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.SHORT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("");
		return driver;

	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		switch (browserName) {
		case ("chrome"):
			System.setProperty("webdriver.chrome.driver",
					GlobalConstants.PROJECT_PATH + "\\browserDriver_main\\chromedriver.exe");
			driver = new ChromeDriver();

			break;
		case ("firefox"):
			System.setProperty("webdriver.gecko.driver",
					GlobalConstants.PROJECT_PATH + "\\browserDriver_main\\geckodriver.exe");
			driver = new FirefoxDriver();

			break;

		case ("edge"):
			System.setProperty("webdriver.edge.driver",
					GlobalConstants.PROJECT_PATH + "\\browserDriver_main\\msedgedriver.exe");
			driver = new EdgeDriver();

			break;

		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;

	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				System.out.println(" -------------------------- PASSED -------------------------- ");
			} else {
				System.out.println(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				System.out.println(" -------------------------- PASSED -------------------------- ");
			} else {
				System.out.println(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

}

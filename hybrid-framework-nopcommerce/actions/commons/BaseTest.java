package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class BaseTest {
	public WebDriver driver;
	private String projectPath = System.getProperty("user.dir");;

	protected WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case ("chrome"):
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();

			break;
		case ("firefox"):
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();

			break;

		case ("edge"):
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();

			break;

		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		return driver;

	}

}

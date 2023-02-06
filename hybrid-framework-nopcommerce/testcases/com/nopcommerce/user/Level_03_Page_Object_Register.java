package com.nopcommerce.user;

import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

public class Level_03_Page_Object_Register {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	String firstName = "Automation_My";
	String lastName = "FC";
	Random rand;
	String password;
	String randEmail;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		rand = new Random();
		randEmail = "automationfc" + rand.nextInt(100) + "@gmail.com";
		password = "123456";
//		
	}

	@Test
	public void Register_01_Empty_Data() {
		homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMesssageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMesssageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMesssageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMesssageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMesssageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("gts");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMesssageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Register_03_Register_Success() {
		homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(randEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void Register_04_Existing_Email() {
		homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("automationfc.vn@gmail.com");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getExistingEmailErrorMessage(), "The specified email already exists");

	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("automationfc.vn@gmail.com");
		registerPage.inputToPasswordTextbox("123");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.getErrorMesssageAtPasswordTextbox()
				.contains("Password must meet the following rules:\nmust have at least 6 characters"));

	}

	@Test
	public void Register_06_Confirm_Password_Not_Match() {
		homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("automationfc.vn@gmail.com");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("abcedf");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.getErrorMesssageAtConfirmPasswordTextbox()
				.contains("The password and confirmation password do not match."));


	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}

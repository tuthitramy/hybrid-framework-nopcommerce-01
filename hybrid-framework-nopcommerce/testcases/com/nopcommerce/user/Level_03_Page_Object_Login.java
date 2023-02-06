package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	String summaryErrorMessage;
	String firstName = "Automation_My";
	String lastName = "FC";
	Random rand;
	String randEmail;
	String password = "123456";
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com/");

		firstName = "Automation_My";
		lastName = "FC";
		password = "123456";
		rand = new Random();
		randEmail = "automationfc" + rand.nextInt(100) + "@gmail.com";

		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		loginPage = new LoginPageObject(driver);

//		
//
		homePage.clickToRegisterLink();
//		registerPage = new RegisterPageObject(driver);
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(randEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test(enabled = true)
	public void Login_01_Empty_Data() {

		homePage.clickToLoginLink();
//		loginPage = new LoginPageObject(driver);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test(enabled = true)
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
//		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox("abc");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Not_Register_Email() {
		homePage.clickToLoginLink();
//		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox("abc@gmail.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		summaryErrorMessage = loginPage.getSummaryErrorMessage();

		Assert.assertTrue(
				summaryErrorMessage.contains("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(summaryErrorMessage.contains("No customer account found"));

	}

	@Test
	public void Login_04_Not_Input_Password() {
		homePage.clickToLoginLink();
//		loginPage = new LoginPageObject(driver);
		System.out.println("TC_04: " + randEmail);
		loginPage.inputToEmailTextbox(randEmail);
		loginPage.clickToLoginButton();
		summaryErrorMessage = loginPage.getSummaryErrorMessage();
		Assert.assertTrue(
				summaryErrorMessage.contains("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(summaryErrorMessage.contains("The credentials provided are incorrect"));

	}

	@Test
	public void Login_05_Incorrect_Password() {
		homePage.clickToLoginLink();
//		loginPage = new LoginPageObject(driver);
		System.out.println("TC_05: " + randEmail);
		loginPage.inputToEmailTextbox(randEmail);
		loginPage.inputToPasswordTextbox("abc123");
		loginPage.clickToLoginButton();
		summaryErrorMessage = loginPage.getSummaryErrorMessage();
		Assert.assertTrue(
				summaryErrorMessage.contains("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(summaryErrorMessage.contains("The credentials provided are incorrect"));

	}

	@Test
	public void Login_06_Login_Success() {
		homePage.clickToLoginLink();
//		loginPage = new LoginPageObject(driver);
		System.out.println("TC_06: " + randEmail);
		loginPage.inputToEmailTextbox(randEmail);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isLoginSucess());

	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}

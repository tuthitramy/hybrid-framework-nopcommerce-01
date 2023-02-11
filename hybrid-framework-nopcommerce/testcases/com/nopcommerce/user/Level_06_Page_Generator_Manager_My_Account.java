package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Level_06_Page_Generator_Manager_My_Account extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserMyAccountPageObject myAccountPage;
	String firstName = "Automation_My";
	String lastName = "FC";
	Random rand;
	String password;
	String randEmail;

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		rand = new Random();
		randEmail = "automationfc" + rand.nextInt(10000) + "@gmail.com";
		password = "123456";
		// Register account
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(randEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		// Login
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(randEmail);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isLoginSucess());

	}

	@Test
	public void My_Account_01_Update_Customer_Infor() {
		myAccountPage = homePage.clickToMyAccountLink();
		myAccountPage.checkToFemailRadioButton();
		myAccountPage.inputToFirstNameTextbox("Automation");
		myAccountPage.inputToLastNameTextbox("FC");
		myAccountPage.inputToBirthDayDropdown("1");
		myAccountPage.inputToBirthMonthDropdown("1");
		myAccountPage.inputToBirthYearDropdown("1999");
		myAccountPage.inputToEmailTextbox(randEmail);
		myAccountPage.inputToCompanyTextbox("Automation FC");
		myAccountPage.clickToSaveButton();
		Assert.assertEquals(myAccountPage.getInforUpdateMessage(), "The customer info has been updated successfully.");

	}

	@Test(enabled = true)
	public void My_Account_02_Add_Address() {
		myAccountPage.clickToAddressesLink();
		myAccountPage.clickToAddNewButton();
		myAccountPage.inputAddressFirstNameTextbox(firstName);
		myAccountPage.inputAddressLastNameTextbox(lastName);
		myAccountPage.inputAddressEmailTextbox(randEmail);
		myAccountPage.inputAddressCompanyTextbox("OMIOMI001");
		myAccountPage.selectCountryDropdown("United States");
		myAccountPage.selectStateProvince("Alaska");
		myAccountPage.inputAddressCityTextbox("New York");
		myAccountPage.inputAddress1Textbox("aaaa");
		myAccountPage.inputAddress2Textbox("bbbbbb");
		myAccountPage.inputAddressZipPostcodeTextbox("1234343");
		myAccountPage.inputAddressPhoneNumberTextbox("09434328");
		myAccountPage.inputAddressFaxTextbox("123132545");
		
		
		
		
	}

	@Test(enabled = false)
	public void Register_03_Register_Success() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(randEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test(enabled = false)
	public void Register_04_Existing_Email() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("automationfc.vn@gmail.com");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getExistingEmailErrorMessage(), "The specified email already exists");
	}

	@Test(enabled = false)
	public void Register_05_Password_Less_Than_6_Chars() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("automationfc.vn@gmail.com");
		registerPage.inputToPasswordTextbox("123");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.getErrorMesssageAtPasswordTextbox()
				.contains("Password must meet the following rules:\nmust have at least 6 characters"));

	}

	@Test(enabled = false)
	public void Register_06_Confirm_Password_Not_Match() {
		registerPage = homePage.clickToRegisterLink();
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
//		driverBaseTest.quit();
	}

}

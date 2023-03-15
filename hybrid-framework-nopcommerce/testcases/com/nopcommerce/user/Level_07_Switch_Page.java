package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountFooterPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageObjects.nopCommerce.user.UserShippingReturnPageObject;
import pageObjects.nopCommerce.user.UserSitemapPageObject;
import pageObjects.nopCommerce.user.UserWishlistPageObject;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserSearchPageObject searchPage;
	private UserShippingReturnPageObject shippingPage;
	private UserSitemapPageObject sitemapPage;
	private UserMyAccountFooterPageObject myAccountFooterPage;
	private UserWishlistPageObject wishlistPage;
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
		registerPage = homePage.clickToRegisterLink(driver);
		rand = new Random();
		randEmail = "automationfc" + rand.nextInt(10000) + "@gmail.com";
		password = "123456";

	}

	@Test
	public void SwitchUI_01_Register() {
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(randEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test(enabled = true)
	public void SwitchUI_02_Login() {
		loginPage = homePage.openLoginPage(driver);
		loginPage.inputToEmailTextbox(randEmail);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isLoginSucess(driver));

	}

	@AfterClass
	public void afterClass() {
//		driverBaseTest.quit();
	}

}

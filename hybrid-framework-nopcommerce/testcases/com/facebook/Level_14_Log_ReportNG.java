package com.facebook;

import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_14_Log_ReportNG extends BaseTest {
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })

	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = pageObjects.facebook.PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_DisPlayed() {
		log.info("Create -  Step 01: Open register page");
		loginPage.clickToCreateNewAccountButton();
		
		log.info("Create -  Step 02: verify Email textbox is displayed");
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());

	}

	@Test(enabled = true)
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		loginPage.inputEmailAddressToTextbox("tuthitr@gmail.com");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isReEnterEmailAddressTextboxDisplayed());

		loginPage.clearValueInEmailAddressToTextbox();
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isReEnterEmailAddressTextboxUndisplayed());

	}

	@Test(enabled = true)
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickToCloseButton();
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isReEnterEmailAddressTextboxUndisplayed());

	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}

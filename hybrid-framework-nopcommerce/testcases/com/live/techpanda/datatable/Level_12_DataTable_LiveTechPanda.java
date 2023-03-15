package com.live.techpanda.datatable;

import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.liveTechPanda.HomePageObject;
import pageObjects.liveTechPanda.LoginPageObject;
import pageUIs.liveTechPanda.HomePageUI;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_12_DataTable_LiveTechPanda extends BaseTest {
	HomePageObject homePage;
	LoginPageObject loginPage;

	@Parameters({ "browser", "url" })

	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = pageObjects.liveTechPanda.PageGeneratorManager.getLoginPage(driver);
		homePage = loginPage.login();
		homePage.closePopup();
	}

	@Test
	public void Table_01_Search_Data_By_Name_Value() {
		homePage.searchDataWithInputValueToTextboxByColumnName("Name", "Automation FC");
		homePage.clickToSearchButton();
		homePage.clickToResetFilterButton();
		
//		homePage.checkToCheckboxToSelectRecordByID("79064");
//		homePage.selectValueFromActionValue("Assign a Customer Group");
//		homePage.selectActionGroupDropdown("Retailer");
//		homePage.clickToSubmitButton();
//		Assert.assertEquals(homePage.getTextElement(driver, HomePageUI.GROUP_NAME_BY_ID, "79064"), "Retailer");
//		homePage.searchDataWithID("79064", "");
//		homePage.clickToSearchButton();
//		homePage.sleepInSecond(5);
//		homePage.clickToSelectTypeButton("Select All");

	}

	@Test
	public void Table_02_Search_Data_By_Group_Value() {
		homePage.selectValueFromDropdownByColumnName("Group", "General");
		homePage.clickToSearchButton();
		homePage.clickToResetFilterButton();

	}

	@Test
	public void Table_03_Search_Data_By_ID() {
		homePage.searchDataWithID("79059", "79069");
		homePage.clickToSearchButton();

	}

	@Test
	public void Table_04_Assign_Customer_Group() {
		homePage.clickToSelectTypeButton("Select Visible");
		homePage.selectValueFromActionValue("Assign a Customer Group");
		homePage.selectActionGroupDropdown("Wholesale");
		

	}

	@Test
	public void Table_05_Delete_Data_By_ID_Value() {
		homePage.clickToSelectTypeButton("Unselect Visible");
		homePage.checkToCheckboxToSelectRecordByID("79059");
		homePage.selectValueFromActionValue("Delete");
		homePage.clickToSubmitButton();
		Assert.assertFalse(homePage.isElementDisplayed(driver, HomePageUI.VALUE_ROW_BY_ID, "79059"));
		

	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}

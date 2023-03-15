package com.jquery.datatable;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.jQuery.HomePageObject;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_10_DataTable_DataGrid extends BaseTest {
	HomePageObject homePage;
	Random rand;
	String femalesValues, malesValues, ageValues, yearValues, totalValues;

	@Parameters({ "browser", "url" })

	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = pageObjects.jQuery.PageGeneratorManager.getHomePage(driver);
		rand = new Random();
		femalesValues = String.valueOf(rand.nextInt(100000));
		malesValues = String.valueOf(rand.nextInt(100000));
		ageValues = String.valueOf(rand.ints(1, 150));
		yearValues = String.valueOf(rand.ints(2001, 2090));
		totalValues = String.valueOf(rand.nextInt(10000000));

	}

	@Test
	public void Table_01_AddNewData() {
//		homePage.openPagingByPageNumber("10");
//		homePage.clickToAddButton();
		homePage.addNewRecord(femalesValues, "VietNam", malesValues, ageValues, yearValues, totalValues);
//		System.out.println(femalesValues);
		Assert.assertTrue(homePage.isDataAddedSuccess("VietNam"));

	}

	@Test(enabled = true)
	public void Table_02_SearchDataByField() {
//		homePage.refreshCurrentPage(driver);
//		homePage.sendKeysToFilterTextboxByName("Country", "VietNam");
//		homePage.getValueEachRowsAtAllPages();

	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}

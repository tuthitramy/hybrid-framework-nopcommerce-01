package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;

	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementVisible(driver, LoginPageUI.PAGE_NUMBER, pageNumber);
		clickToElement(driver, LoginPageUI.PAGE_NUMBER, pageNumber);

	}

	public void clickToAddButton() {
		waitForElementClickable(driver, LoginPageUI.ADD_BUTTON);
		clickToElement(driver, LoginPageUI.ADD_BUTTON);

	}

	public void addNewRecord(String femalesValues, String countryValues, String malesValues, String ageValues,
			String yearValues, String totalValues) {
		clickToAddButton();
		sendkeysToElement(driver, LoginPageUI.ADD_NEW_RECORD_EACH_TEXTBOX, femalesValues, "females");
		sendkeysToElement(driver, LoginPageUI.ADD_NEW_RECORD_EACH_TEXTBOX, countryValues, "country");
		sendkeysToElement(driver, LoginPageUI.ADD_NEW_RECORD_EACH_TEXTBOX, malesValues, "males");
		sendkeysToElement(driver, LoginPageUI.ADD_NEW_RECORD_EACH_TEXTBOX, ageValues, "age");
		sendkeysToElement(driver, LoginPageUI.ADD_NEW_RECORD_EACH_TEXTBOX, yearValues, "year");
		sendkeysToElement(driver, LoginPageUI.ADD_NEW_RECORD_EACH_TEXTBOX, totalValues, "total");

		clickToElement(driver, LoginPageUI.SUBMIT_ADD_NEW_RECORD);

	}

	public void clickToCustomizeButton() {
		waitForElementClickable(driver, LoginPageUI.CUSTOMIZE_BUTTON);
		clickToElement(driver, LoginPageUI.CUSTOMIZE_BUTTON);

	}

	public void sendKeysToFilterTextboxByName(String textboxName, String value) {
		waitForElementVisible(driver, LoginPageUI.DYNAMIC_FILTER_TEXTBOX, textboxName);
		sendkeysToElement(driver, LoginPageUI.DYNAMIC_FILTER_TEXTBOX, value, textboxName);

	}
	public boolean isDataAddedSuccess(String countryValue) {
		sendKeysToFilterTextboxByName("Country", countryValue);
//		String feValue = getTextElement(driver, HomePageUI.ROW_FOR_EACH_PAGE, "females");
//		System.out.println(feValue);
		return isElementDisplayed(driver, LoginPageUI.ROW_FOR_EACH_PAGE, "country",countryValue);

	}

	public List<String> getValueEachRowsAtAllPages() {
		int totalPage = getElementSize(driver, LoginPageUI.TOTAL_PAGES);
		System.out.println("Total size: " + totalPage);
		List<String> allRowValuesAllPage = new ArrayList<String>();
		for (int index = 1; index <= totalPage; index++) {
			openPagingByPageNumber(String.valueOf(index));
			sleepInSecond(3);
			List<WebElement> allRowElementEachPage = getListElement(driver, LoginPageUI.ROW_FOR_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValuesAllPage.add(eachRow.getText());

			}

		}
		for (String value : allRowValuesAllPage) {
			System.out.println("====================================");
			System.out.println(value);
		}

		return allRowValuesAllPage;
	}

}

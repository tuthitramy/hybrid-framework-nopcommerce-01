package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;
import pageUIs.jQuery.HomePageUI2;

public class HomePageObject2 extends BasePage {
	WebDriver driver;

	public HomePageObject2(WebDriver driver) {
		this.driver = driver;

	}

	public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String inputValue) {
		int columnIndex = getElementSize(driver, HomePageUI2.COLUMN_INDEX_BY_NAME,columnName)+1;	
		System.out.println(columnIndex);
		waitForElementVisible(driver, HomePageUI2.ROW_TEXTBOX_BY_COLUMN_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		sendkeysToElement(driver, HomePageUI2.ROW_TEXTBOX_BY_COLUMN_AND_ROW_INDEX, inputValue, rowNumber,String.valueOf(columnIndex) );
		
	}

	public void selectValueInCountryDropdown(String rowNumber, String inputValue) {
		waitForElementVisible(driver, HomePageUI2.COUNTRY_DROPDOWN_BY_ROW_INDEX,rowNumber);
		selectItemByValueInDefaultDropdown(driver, HomePageUI2.COUNTRY_DROPDOWN_BY_ROW_INDEX,inputValue, rowNumber);
		
	}
	public void checkToNPOCheckbox(String rowNumber) {
		waitForElementVisible(driver, HomePageUI2.NPO_CHECKBOX_BY_ROW_INDEX,rowNumber);
		checktoDefaultCheckboxOrRadio(driver,HomePageUI2.NPO_CHECKBOX_BY_ROW_INDEX, rowNumber);
		
	}
	public void clickToIconByTitle(String iconTitle, String rowNumber) {
		waitForElementClickable(driver, HomePageUI2.ICON_BY_TITLE_AND_BY_ROW_INDEX, iconTitle, rowNumber);
		clickToElementByJS(driver, HomePageUI2.ICON_BY_TITLE_AND_BY_ROW_INDEX, iconTitle, rowNumber);
		
	}

}

	
package pageObjects.liveTechPanda;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.liveTechPanda.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;

	}

	public void closePopup() {
		waitForElementClickable(driver, HomePageUI.CLOSE_BUTTON);
		clickToElement(driver, HomePageUI.CLOSE_BUTTON);
	}

	public void searchDataWithInputValueToTextboxByColumnName(String columnName, String inputValue) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		System.out.println("Column index: " + columnIndex);
		waitForElementVisible(driver, HomePageUI.FILTER_TEXTBOX_BY_COLUMN_INDEX, String.valueOf(columnIndex));
		sendkeysToElement(driver, HomePageUI.FILTER_TEXTBOX_BY_COLUMN_INDEX, inputValue, String.valueOf(columnIndex));
	}

	public void searchDataWithID(String fromValue, String toValue) {
		waitForElementVisible(driver, HomePageUI.ID_FILTER_FROM_TEXTBOX);
		sendkeysToElement(driver, HomePageUI.ID_FILTER_FROM_TEXTBOX, fromValue);
		waitForElementVisible(driver, HomePageUI.ID_FILTER_TO_TEXTBOX);
		sendkeysToElement(driver, HomePageUI.ID_FILTER_TO_TEXTBOX, toValue);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, HomePageUI.FILTER_ACTION_BY_NAME, "Search");
		clickToElement(driver, HomePageUI.FILTER_ACTION_BY_NAME, "Search");
		sleepInSecond(10);
	}

	public void selectValueFromDropdownByColumnName(String columnName, String inputValue) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		System.out.println("Column index: " + columnIndex);
		waitForElementVisible(driver, HomePageUI.FILTER_DROPDOWN_BY_COLUMN_INDEX, String.valueOf(columnIndex));
		selectItemByTextInDefaultDropdown(driver, HomePageUI.FILTER_DROPDOWN_BY_COLUMN_INDEX, inputValue,
				String.valueOf(columnIndex));

	}

	public void clickToResetFilterButton() {
		waitForElementClickable(driver, HomePageUI.FILTER_ACTION_BY_NAME, "Reset Filter");
		clickToElementByJS(driver, HomePageUI.FILTER_ACTION_BY_NAME, "Reset Filter");
		sleepInSecond(15);
	}

	public void selectValueFromActionValue(String inputValue) {
		waitForElementClickable(driver, HomePageUI.ACTION_DROPDOWN);
		selectItemByTextInDefaultDropdown(driver, HomePageUI.ACTION_DROPDOWN, inputValue);
	}

	public void checkToCheckboxToSelectRecordByID(String... IDs) {
		waitForElementClickable(driver, HomePageUI.SELECT_RECORD_CHECKBOX_BY_ID, IDs);
		checktoDefaultCheckboxOrRadio(driver, HomePageUI.SELECT_RECORD_CHECKBOX_BY_ID, IDs);
	}

	private boolean isActionGroupDropdownDisPlay() {
		selectValueFromActionValue("Assign a Customer Group");
		return isElementDisplayed(driver, HomePageUI.ACTION_GROUP_DROPDOWN);
	}

	public void selectActionGroupDropdown(String inputValue) {
		if (isActionGroupDropdownDisPlay() == true) {
			selectItemByTextInDefaultDropdown(driver, HomePageUI.ACTION_GROUP_DROPDOWN, inputValue);

		} else {
			throw new RuntimeException("Please select Assign a Customer Group to do next steps ");

		}
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, HomePageUI.SUBMIT_BUTTON);
		clickToElement(driver, HomePageUI.SUBMIT_BUTTON);
	}

	public void clickToSelectTypeButton(String selectORUnselectType) {
		waitForElementClickable(driver, HomePageUI.SELECT_UNSELECT_TYPE_BY_NAME, selectORUnselectType);
		clickToElementByJS(driver, HomePageUI.SELECT_UNSELECT_TYPE_BY_NAME, selectORUnselectType);

	}


}

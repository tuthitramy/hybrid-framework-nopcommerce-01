package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.LoginPageUI;
import pageUIs.nopCommerce.user.MyAccountPageUI;

public class UserMyAccountPageObject extends BasePage {
	private WebDriver driver;

	public UserMyAccountPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void checkToFemailRadioButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, MyAccountPageUI.FEMALE_RADIOBOX);
		checktoDefaultCheckboxOrRadio(driver, MyAccountPageUI.FEMALE_RADIOBOX);

	}

	public void inputToFirstNameTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendkeysToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, string);
	}

	public void inputToLastNameTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		sendkeysToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, string);

	}

	public void inputToBirthDayDropdown(String value) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.BIRTHDAY_DROPDOWN);
		selectItemByValueInDefaultDropdown(driver, MyAccountPageUI.BIRTHDAY_DROPDOWN, value);

	}

	public void inputToBirthMonthDropdown(String value) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.BIRTHMONTH_DROPDOWN);
		selectItemByValueInDefaultDropdown(driver, MyAccountPageUI.BIRTHMONTH_DROPDOWN, value);

	}

	public void inputToBirthYearDropdown(String value) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.BIRTHYEAR_DROPDOWN);
		selectItemByValueInDefaultDropdown(driver, MyAccountPageUI.BIRTHYEAR_DROPDOWN, value);

	}

	public void inputToEmailTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, string);

	}

	public void inputToCompanyTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.COMPANY_TEXTBOX);
		sendkeysToElement(driver, MyAccountPageUI.COMPANY_TEXTBOX, string);

	}

	public void clickToCustomerInforSaveButton() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_INFOR_SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.CUSTOMER_INFOR_SAVE_BUTTON);

	}
	public void clickToAddressSaveButton() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADDRESS_SAVE_BUTTON);

	}

	public String getUpdateMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.UPDATE_MESSAGE);
		return getTextElement(driver, MyAccountPageUI.UPDATE_MESSAGE);
	}

	public void clickToAddressesLink() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_LINK);
		clickToElement(driver, MyAccountPageUI.ADDRESSES_LINK);
		
	}

	public void clickToAddNewButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,MyAccountPageUI.ADD_NEW_BUTTON);
		clickToElement(driver,MyAccountPageUI.ADD_NEW_BUTTON);
		
	}

	public void inputAddressFirstNameTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.ADDRESS_FIRST_NAME_TEXTBOX);
		sendkeysToElement(driver,MyAccountPageUI.ADDRESS_FIRST_NAME_TEXTBOX, string);
		
	}

	public void inputAddressLastNameTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.ADDRESS_LAST_NAME_TEXTBOX);
		sendkeysToElement(driver,MyAccountPageUI.ADDRESS_LAST_NAME_TEXTBOX, string);
		
	}

	public void inputAddressEmailTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX);
		sendkeysToElement(driver,MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX, string);
		
	}

	public void inputAddressCompanyTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.ADDRESS_COMPANY_TEXTBOX);
		sendkeysToElement(driver,MyAccountPageUI.ADDRESS_COMPANY_TEXTBOX, string);
		
	}

	public void selectCountryDropdown(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.ADDRESS_COUNTRY_DROPDOWN);
		selectItemByValueInDefaultDropdown(driver, MyAccountPageUI.ADDRESS_COUNTRY_DROPDOWN, string);
		
	}

	public void selectStateProvince(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.ADDRESS_PROVINCE_DROPDOWN);
		selectItemByValueInDefaultDropdown(driver, MyAccountPageUI.ADDRESS_PROVINCE_DROPDOWN, string);
		
	}

	public void inputAddress2Textbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.ADDRESS_2_TEXTBOX);
		sendkeysToElement(driver,MyAccountPageUI.ADDRESS_2_TEXTBOX, string);
		
	}

	public void inputAddressZipPostcodeTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.ADDRESS_POSTCODE_TEXTBOX);
		sendkeysToElement(driver,MyAccountPageUI.ADDRESS_POSTCODE_TEXTBOX, string);
		
	}

	public void inputAddressCityTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.ADDRESS_CITY_TEXTBOX);
		sendkeysToElement(driver,MyAccountPageUI.ADDRESS_CITY_TEXTBOX, string);
		
	}

	public void inputAddressPhoneNumberTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX);
		sendkeysToElement(driver,MyAccountPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX, string);
		
	}

	public void inputAddressFaxTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.ADDRESS_FAX_TEXTBOX);
		sendkeysToElement(driver,MyAccountPageUI.ADDRESS_FAX_TEXTBOX, string);
		
	}

	public void inputAddress1Textbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.ADDRESS_01_TEXTBOX);
		sendkeysToElement(driver,MyAccountPageUI.ADDRESS_01_TEXTBOX, string);
		
	}
	public void clickToChangePWLink() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
		
	}
	public void inputToOldPasswordTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeysToElement(driver,MyAccountPageUI.OLD_PASSWORD_TEXTBOX, string);
		
	}
	public void inputToNewPasswordTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeysToElement(driver,MyAccountPageUI.NEW_PASSWORD_TEXTBOX, string);
		
	}
	public void inputToConfirmPasswordTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeysToElement(driver,MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX, string);
		
	}

	public void ClickToChangePasswordButton() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver,MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
		
		
	}
	public UserHomePageObject ClickTologOutLink() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,MyAccountPageUI.LOGOUT_LINK);
		clickToElement(driver,MyAccountPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
		
		
	}
	
	
}

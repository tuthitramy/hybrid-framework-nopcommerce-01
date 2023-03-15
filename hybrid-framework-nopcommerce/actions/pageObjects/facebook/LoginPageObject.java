package pageObjects.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.ClearElement;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);

	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS);
	}

	public void inputEmailAddressToTextbox(String string) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS);
		sendkeysToElement(driver, LoginPageUI.EMAIL_ADDRESS, string);
	}
	public void clearValueInEmailAddressToTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS);
		getWebElement(driver, LoginPageUI.EMAIL_ADDRESS).clear();
	}

	public boolean isReEnterEmailAddressTextboxDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.CONFIRMATION_EMAIL_ADDRESS_TEXTBOX);
	}
	public void clickToCloseButton() {
		waitForElementVisible(driver, LoginPageUI.CLOSE_BUTTON);
		clickToElement(driver, LoginPageUI.CLOSE_BUTTON);
	}

	public boolean isReEnterEmailAddressTextboxUndisplayed() {
		
		return isElementUndisplayed(driver, LoginPageUI.CONFIRMATION_EMAIL_ADDRESS_TEXTBOX);
	}

}

package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {

	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		// TODO Auto-generated construcr stub
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public String getErrorMessageAtEmailTextbox() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, LoginPageUI.ERROR_MESSAGE_AT_EMAIL_TEXTBOX);
		return getTextElement(driver, LoginPageUI.ERROR_MESSAGE_AT_EMAIL_TEXTBOX);
	}

	public void inputToEmailTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, string);

	}

	public void inputToPasswordTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, string);

	}

	public String getSummaryErrorMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.SUMMARY_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.SUMMARY_ERROR_MESSAGE);
	}
	public UserHomePageObject loginAsUser(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

}

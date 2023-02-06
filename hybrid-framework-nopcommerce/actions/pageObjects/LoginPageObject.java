package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickToLoginButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

	}

	public String getErrorMessageAtEmailTextbox() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, LoginPageUI.ERROR_MESSAGE_AT_EMAIL_TEXTBOX);
		return getTextElement(driver, LoginPageUI.ERROR_MESSAGE_AT_EMAIL_TEXTBOX);
	}

	public void inputToEmailTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, string);

	}

	public void inputToPasswordTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, string);

	}

	public String getSummaryErrorMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.SUMMARY_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.SUMMARY_ERROR_MESSAGE);
	}

	public boolean isLoginSucess() {
		// TODO Auto-generated method stub
		return isElementDisplayed(driver, HomePageUI.LOGOUT_LINK);
	}

}

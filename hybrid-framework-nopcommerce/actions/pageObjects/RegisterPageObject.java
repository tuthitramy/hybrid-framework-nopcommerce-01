package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public String getErrorMesssageAtFirstNameTextbox() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMesssageAtLastNameTextbox() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.lAST_NAME_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.lAST_NAME_ERROR_MESSAGE);

	}

	public String getErrorMesssageAtPasswordTextbox() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);

	}
	public String getErrorMesssageAtEmailTextbox() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);

	}
	public String getErrorMesssageAtConfirmPasswordTextbox() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);

	}
	public void inputToFirstNameTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, string);}
		

	public void inputToLastNameTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, string);
		
	}
	public void inputToEmailTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, string);
		
	}
	public void inputToPasswordTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, string);
		
	}

	public void inputToConfirmPasswordTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, string);
		
	}

	public String getRegisterSuccessMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public String getExistingEmailErrorMessage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.EXISTING_MAIL_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.EXISTING_MAIL_ERROR_MESSAGE);
	}



}

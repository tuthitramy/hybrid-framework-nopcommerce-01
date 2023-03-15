package pageObjects.liveTechPanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveTechPanda.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;

	}

	public HomePageObject login() {
		waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendkeysToElement(driver, LoginPageUI.USERNAME_TEXTBOX, "user01");
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, "guru99com");
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);

	}

}

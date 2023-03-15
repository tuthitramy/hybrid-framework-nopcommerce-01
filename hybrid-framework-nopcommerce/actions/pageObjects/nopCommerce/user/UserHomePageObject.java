package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.LoginPageUI;
import pageUIs.nopCommerce.user.UserBasePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public boolean isMyAccountDisplayed() {
		waitForElementClickable(driver, UserBasePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserBasePageUI.MY_ACCOUNT_LINK);
	}

}

package commons;

import org.openqa.selenium.WebDriver;

import pageObject.nopCommerce.admin.AdminDashboardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.facebook.LoginPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountFooterPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageObjects.nopCommerce.user.UserShippingReturnPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserSitemapPageObject;
import pageObjects.nopCommerce.user.UserWishlistPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserMyAccountPageObject getUserMyAccountPage(WebDriver driver) {
		return new UserMyAccountPageObject(driver);
	}

	public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserSearchPageObject(driver);
	}

	public static UserShippingReturnPageObject getUserShippingReturnPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserShippingReturnPageObject(driver);
	}

	public static UserSitemapPageObject getUserSitemapPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserSitemapPageObject(driver);
	}

	public static UserMyAccountFooterPageObject getUserMyAccountFooterPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserMyAccountFooterPageObject(driver);
	}

	public static UserWishlistPageObject getUserWishlistPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserWishlistPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	public static UserShoppingCartPageObject getUserShoppingCartPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserShoppingCartPageObject(driver);

	}
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

}

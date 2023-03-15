package commons;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.nopCommerce.admin.AdminDashboardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountFooterPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageObjects.nopCommerce.user.UserShippingReturnPageObject;
import pageObjects.nopCommerce.user.UserSitemapPageObject;
import pageObjects.nopCommerce.user.UserWishlistPageObject;
import pageUIs.nopCommerce.admin.AdminBasePageUI;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.UserBasePageUI;

public class BasePage extends UserBasePageUI {
	private static final String BasePageUI = null;

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);

	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();

	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();

	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();

	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());

	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void senkeytoAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToExpectWindow(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindowsIDs = driver.getWindowHandles();
		for (String id : allWindowsIDs) {
			driver.switchTo().window(id);

			String actualPageTitle = driver.getTitle();
			if (actualPageTitle.equals(expectedPageTitle)) {
				break;

			}

		}

	}

	private By getByLocator(String locatorType) {
		By by = null;
		System.out.println("Locator type= " + locatorType);
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=")
				|| locatorType.startsWith("CLASS=")) {
			by = By.className(locatorType.substring(6));

		} else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=")
				|| locatorType.startsWith("XPATH=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator Type is not supported");
		}
		return by;

	}

	private String getDynamicXpath(String locatorType, String... dynamicValues) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);

		}
		return locatorType;

	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getListElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));

	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}

	public void sendkeysToElement(WebDriver driver, String locatorType, String inputValue) {
		getWebElement(driver, getDynamicXpath(locatorType)).clear();
		getWebElement(driver, getDynamicXpath(locatorType)).sendKeys(inputValue);

	}

	public void sendkeysToElement(WebDriver driver, String locatorType, String inputValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(inputValue);

	}

	public void selectItemByValueInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType)));
		select.selectByValue(textItem);
	}

	public void selectItemByTextInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType)));
		select.selectByVisibleText(textItem);
	}

	public void selectItemByValueInDefaultDropdown(WebDriver driver, String locatorType, String textItem,
			String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByValue(textItem);

	}

	public void selectItemByTextInDefaultDropdown(WebDriver driver, String locatorType, String textItem,
			String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);

	}

	public String getSelectedItemInDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();

	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getAttributeValue(WebDriver driver, String locatorType, String name) {
		return getWebElement(driver, locatorType).getAttribute(name);

	}

	public String getTextElement(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();

	}

	public String getCssValue(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getCssValue(locatorType);

	}

	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValues) {
		return getListElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}

	public void checktoDefaultCheckboxOrRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected() != true) {
			element.click();
		}
	}

	public void checktoDefaultCheckboxOrRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (element.isSelected() != true) {
			element.click();
		}
	}

	public void unchecktoDefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected() == true) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		try {
			return getWebElement(driver, locatorType).isDisplayed();

		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isElementUndisplayed(WebDriver driver, String locatorType) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		List<WebElement> elements = getListElement(driver, locatorType);
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);

		if (elements.size() == 0) {
			System.out.println("Element is not in DOM");
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element is in DOM but undisplayed");
			return true;

		} else {
			System.out.println("Element is in DOM and visible");
			return false;
		}

	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();

	}
//	public boolean isElementUndisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
//		boolean status = true;
//		if(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed()) {
//			status =false;
//		}
//	}

	public boolean isElementSelected(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isSelected();

	}

	public boolean isElementEnabled(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isEnabled();

	}

	public void switchToIframeFrame(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));

	}

	public void switchToDefaultContent(WebDriver driver, String xpathLocator) {
		driver.switchTo().defaultContent();

	}

	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();

	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locatorType, String dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element,
				"style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element,
				"style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType, String... dynamicValues) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}

	public void scrollToElement(WebDriver driver, String locatorType, String dynamicValues) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType, String... DynamicValues) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, getDynamicXpath(locatorType, DynamicValues)));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		if (status) {
			return true;

		} else {
			return false;
		}
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, getDynamicXpath(locatorType)));
		return status;
	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions
				.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(
				ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = System.getProperty("user.dir") + getDirectorySlash("uploadFiles");
		String fullFileName = "";

		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}

		fullFileName = fullFileName.trim();

		getWebElement(driver, HomePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
	}

	public String getDirectorySlash(String folderName) {
		String separator = System.getProperty("file.separator");
		return separator + folderName + separator;
	}

	public BasePage openPageAtHeaderLinkByName(WebDriver driver, String linkName) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_PAGE_AT_HEADER_AREA, linkName);
		clickToElementByJS(driver, UserBasePageUI.DYNAMIC_PAGE_AT_HEADER_AREA, linkName);
//		clickToElement(driver, UserBasePageUI.DYNAMIC_PAGE_AT_HEADER_AREA, linkName);
		switch (linkName) {
		case "Register":
			return PageGeneratorManager.getUserRegisterPage(driver);
		case "Log in":
			return PageGeneratorManager.getUserLoginPage(driver);
		case "Log out":
			return PageGeneratorManager.getUserHomePage(driver);
		case "Wishlist":
			return PageGeneratorManager.getUserWishlistPage(driver);
		case "Shopping cart":
			return PageGeneratorManager.getUserShoppingCartPage(driver);
		case "My account":
			return PageGeneratorManager.getUserMyAccountPage(driver);
		default:
			throw new RuntimeException("Invalid link name at header area ");
		}
	}

	public boolean isLoginSucess(WebDriver driver) {
		// TODO Auto-generated method stub
		return getWebElement(driver, getDynamicXpath(UserBasePageUI.DYNAMIC_PAGE_AT_HEADER_AREA, "Log out"))
				.isDisplayed();
	}

	public UserHomePageObject openHomePage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, UserBasePageUI.HOMEPAGE_LINK);
		clickToElement(driver, UserBasePageUI.HOMEPAGE_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public BasePage openPageAtFooterLinkByName(WebDriver driver, String linkName) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_PAGE_AT_FOOTER_AREA, linkName);
//		clickToElementByJS(driver, UserBasePageUI.DYNAMIC_PAGE_AT_FOOTER_AREA, linkName);
		clickToElement(driver, UserBasePageUI.DYNAMIC_PAGE_AT_FOOTER_AREA, linkName);
		switch (linkName) {
		case "My Account":
			return PageGeneratorManager.getUserMyAccountPage(driver);
		case "Sitemap":
			return PageGeneratorManager.getUserSitemapPage(driver);
		case "Shopping cart":
			return PageGeneratorManager.getUserShoppingCartPage(driver);
		case "Wishlist":
			return PageGeneratorManager.getUserWishlistPage(driver);
		case "Shipping & returns":
			return PageGeneratorManager.getUserShippingReturnPage(driver);
		default:
			throw new RuntimeException("Invalid link name at footer area ");
		}
	}

}

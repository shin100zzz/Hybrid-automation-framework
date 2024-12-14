package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopCommerce.user.UserCustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage{
	WebDriver driver;
	
	public UserCustomerInforPageObject (WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isCustomerInforPageDisplayed() {
		waitForElementInVisible(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}
}
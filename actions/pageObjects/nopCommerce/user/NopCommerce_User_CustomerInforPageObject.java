package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopCommerce.user.CustomerInforPageUI;
import pageUI.nopCommerce.user.HomePageUI;

public class NopCommerce_User_CustomerInforPageObject extends BasePage{
	WebDriver driver;
	
	public NopCommerce_User_CustomerInforPageObject (WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isCustomerInforPageDisplayed() {
		waitForElementInVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}
	
}
package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopCommerce.user.CustomerInforPageUI;

public class CustomerInforPageObject_Nop extends BasePage{
	WebDriver driver;
	
	public CustomerInforPageObject_Nop (WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isCustomerInforPageDisplayed() {
		waitForElementInVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}
}
package pageObjects.nopCommerce.admin;
import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class NopCommerce_Admin_DashboardPageObject extends BasePage{
	WebDriver driver;

	public NopCommerce_Admin_DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
 
	public boolean isDashboardHeaderDisplayed() {
		waitForElementInVisible(driver, AdminDashboardPageUI.DASHBAORD_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBAORD_HEADER);
	}
}
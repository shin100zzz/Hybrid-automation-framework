package pageObjects.nopCommerce.admin;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopCommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage{
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
 
	public boolean isDashboardHeaderDisplayed() {
		waitForElementInVisible(driver, AdminDashboardPageUI.DASHBAORD_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBAORD_HEADER);
	}
}
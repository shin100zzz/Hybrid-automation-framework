package pageObjects.nopCommerce.admin;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inpuToUsernameTextbox(String emailAddress) {
		waitForAllElementInVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX,emailAddress);
	}
	
	public void inpuToPasswordTextbox(String password) {
		waitForAllElementInVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX,password);
	}
	
	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPageOfnopCommerce(driver);
		
	}
	public AdminDashboardPageObject loginAsAdmin(String email, String password) {
		inpuToUsernameTextbox(email);
		inpuToPasswordTextbox(password);
		return clickToLoginButton();
	}
 
}
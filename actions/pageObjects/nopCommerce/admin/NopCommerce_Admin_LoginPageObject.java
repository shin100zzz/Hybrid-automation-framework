package pageObjects.nopCommerce.admin;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopCommerce.admin.AdminLoginPageUI;

public class NopCommerce_Admin_LoginPageObject extends BasePage{
	WebDriver driver;

	public NopCommerce_Admin_LoginPageObject(WebDriver driver) {
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
	
	public NopCommerce_Admin_DashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
		
	}
	public NopCommerce_Admin_DashboardPageObject loginAsAdmin(String email, String password) {
		inpuToUsernameTextbox(email);
		inpuToPasswordTextbox(password);
		return clickToLoginButton();
	}
 
}
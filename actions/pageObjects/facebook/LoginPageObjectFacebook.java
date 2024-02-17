package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUIFacebook;

public class LoginPageObjectFacebook extends BasePage{
	WebDriver driver;
	
	public LoginPageObjectFacebook (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToCreatNewAccountButton() {
		waitForElementClickable(driver, LoginPageUIFacebook.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUIFacebook.CREATE_NEW_ACCOUNT_BUTTON);
	}
	
	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUIFacebook.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUIFacebook.EMAIL_ADDRESS_TEXTBOX);
	}

	public void enterToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUIFacebook.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUIFacebook.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {
		return isElementDisplayed(driver, LoginPageUIFacebook.COMFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickCloseIconRegisterForm() {
		waitForElementClickable(driver, LoginPageUIFacebook.CLOSE_ICON);
		clickToElement(driver, LoginPageUIFacebook.CLOSE_ICON);
	}

	public boolean isConfirmEmailAddressTextboxUndisplayed() {
		return isElementUndisplayed(driver, LoginPageUIFacebook.COMFIRM_EMAIL_ADDRESS_TEXTBOX);
	}
	
	
	
}

package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopCommerce.user.LoginPageUI;

public class NopCommerce_User_LoginPageObject extends BasePage{
	
	private WebDriver driver;

	public NopCommerce_User_LoginPageObject (WebDriver driver) {
		this.driver = driver;
		
	}

	public NopCommerce_User_HomePageObject clickToLoginButton() {
		waitForElementInVisible(driver, LoginPageUI.LOGIN_BUTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTON);
		return PageGeneratorManager.getUserHomePageOfnopCommerce(driver);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementClickable(driver,LoginPageUI.EMAIL);
		sendkeyToElement(driver,LoginPageUI.EMAIL,email);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementClickable(driver,LoginPageUI.PASSWORD);
		sendkeyToElement(driver,LoginPageUI.PASSWORD,password);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver,LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver,LoginPageUI.LOGIN_ERROR_MESSAGE);
		return getElementText(driver,LoginPageUI.LOGIN_ERROR_MESSAGE);
	}

	public String RetErrorMessageAtEmailTextbox() {
		// TODO Auto-generated method stub
		return null;
	}

	public NopCommerce_User_HomePageObject loginAsUser(String email, String password) {
		inputToEmailTextBox(email);
		inputToPasswordTextBox(password);
		return clickToLoginButton();
		 
	}

}
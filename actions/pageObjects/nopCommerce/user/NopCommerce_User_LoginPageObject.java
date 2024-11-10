package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopCommerce.user.LoginPageUI;

public class NopCommerce_User_LoginPageObject extends BasePage{
	
	// Biến global
	private WebDriver driver;

	// Hàm khởi tạo cùng tên với clas ko có kiểu trả về.
	// Khi khở tạo 1 đối tượng của class đó thì hàm khởi tạo sẽ được gọi đầu tiên		
	// Hàm này được gọi tên là Constructor
	public NopCommerce_User_LoginPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementInVisible(driver, LoginPageUI.LOGIN_BUTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTON);
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
		waitForElementVisible(driver,LoginPageUI.LOGIN_ERROR_MESSAGE);
		return getElementText(driver,LoginPageUI.LOGIN_ERROR_MESSAGE);
	}


}
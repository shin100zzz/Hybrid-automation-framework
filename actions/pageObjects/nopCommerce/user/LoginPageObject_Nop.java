package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopCommerce.user.LoginPageUI_Nop;

public class LoginPageObject_Nop extends BasePage{
	
	// Biến global
	private WebDriver driver;

	// Hàm khởi tạo cùng tên với clas ko có kiểu trả về.
	// Khi khở tạo 1 đối tượng của class đó thì hàm khởi tạo sẽ được gọi đầu tiên		
	// Hàm này được gọi tên là Constructor
	public LoginPageObject_Nop (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementInVisible(driver, LoginPageUI_Nop.LOGIN_BUTON);
		clickToElement(driver, LoginPageUI_Nop.LOGIN_BUTON);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementClickable(driver,LoginPageUI_Nop.EMAIL);
		sendkeyToElement(driver,LoginPageUI_Nop.EMAIL,email);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementClickable(driver,LoginPageUI_Nop.PASSWORD);
		sendkeyToElement(driver,LoginPageUI_Nop.PASSWORD,password);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,LoginPageUI_Nop.EMAIL_ERROR_MESSAGE);
		return getElementText(driver,LoginPageUI_Nop.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver,LoginPageUI_Nop.LOGIN_ERROR_MESSAGE);
		return getElementText(driver,LoginPageUI_Nop.LOGIN_ERROR_MESSAGE);
	}

	public String RetErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,LoginPageUI_Nop.LOGIN_ERROR_MESSAGE);
		return getElementText(driver,LoginPageUI_Nop.LOGIN_ERROR_MESSAGE);
	}


}
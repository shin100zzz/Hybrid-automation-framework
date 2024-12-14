package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopCommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage{
	
	// Biến global
	private WebDriver driver;

	// Hàm khởi tạo cùng tên với clas ko có kiểu trả về.
	// Khi khở tạo 1 đối tượng của class đó thì hàm khởi tạo sẽ được gọi đầu tiên		
	// Hàm này được gọi tên là Constructor
	public UserLoginPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementInVisible(driver, UserLoginPageUI.LOGIN_BUTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTON);
		return PageGeneratorManager.getUserHomePageOfnopCommerce(driver);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementClickable(driver,UserLoginPageUI.EMAIL);
		sendkeyToElement(driver,UserLoginPageUI.EMAIL,email);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementClickable(driver,UserLoginPageUI.PASSWORD);
		sendkeyToElement(driver,UserLoginPageUI.PASSWORD,password);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver,UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver,UserLoginPageUI.LOGIN_ERROR_MESSAGE);
		return getElementText(driver,UserLoginPageUI.LOGIN_ERROR_MESSAGE);
	}

	public String RetErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,UserLoginPageUI.RE_ERROR_MESSAGE);
		return getElementText(driver,UserLoginPageUI.RE_ERROR_MESSAGE);
	}
	
	public UserHomePageObject loginAsUser(String email, String password) {
		inputToEmailTextBox(email);
		inputToPasswordTextBox(password);
		return clickToLoginButton();
		 
	}
}
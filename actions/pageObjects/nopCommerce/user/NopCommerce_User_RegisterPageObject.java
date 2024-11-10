
package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopCommerce.user.RegisterPageUI;

public class NopCommerce_User_RegisterPageObject extends BasePage {
	// Biến global
	private WebDriver driver;

	// Hàm khởi tạo cùng tên với clas ko có kiểu trả về.
	// Khi khở tạo 1 đối tượng của class đó thì hàm khởi tạo sẽ được gọi đầu tiên		
	// Hàm này được gọi tên là Constructor
	public NopCommerce_User_RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputTofirstnameTextbox(String firstName) {
		waitForElementClickable(driver,RegisterPageUI.FIRST_NAME);
		sendkeyToElement(driver,RegisterPageUI.FIRST_NAME,firstName);
	}
	
	public void inputTolastnameTextbo(String lastName) {
		waitForElementClickable(driver,RegisterPageUI.LAST_NAME);
		sendkeyToElement(driver,RegisterPageUI.LAST_NAME,lastName);
	}
	
	public void inputToEmailTextbox(String existingEmail) {
		waitForElementClickable(driver,RegisterPageUI.EMAIL);
		sendkeyToElement(driver,RegisterPageUI.EMAIL,existingEmail);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver,RegisterPageUI.PASSWORD);
		sendkeyToElement(driver,RegisterPageUI.PASSWORD,password);
	}
	
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementClickable(driver,RegisterPageUI.CONFIRM_PASSWORD);
		sendkeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD,confirmPassword);
	}
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);
	}
	
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver,RegisterPageUI.REGISTER_RESULT_MESSAGE);
		return getElementText(driver,RegisterPageUI.REGISTER_RESULT_MESSAGE);
	}
	
	public void clickTologoutLink() {
		waitForElementClickable(driver,RegisterPageUI.LOGOUT_BUTTON);
		clickToElement(driver,RegisterPageUI.LOGOUT_BUTTON);
	}
	
	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver,RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver,RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver,RegisterPageUI.PASSWORD_ERROR_MESSAGE );
		return getElementText(driver,RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailExistTextbox() {
		waitForElementVisible(driver,RegisterPageUI.EMAIL_EXIST_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI.EMAIL_EXIST_ERROR_MESSAGE);
	}

}
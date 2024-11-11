
package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopCommerce.user.RegisterPageUI_Nop;

public class RegisterPageObject_Nop extends BasePage {
	// Biến global
	private WebDriver driver;

	// Hàm khởi tạo cùng tên với clas ko có kiểu trả về.
	// Khi khở tạo 1 đối tượng của class đó thì hàm khởi tạo sẽ được gọi đầu tiên		
	// Hàm này được gọi tên là Constructor
	public RegisterPageObject_Nop(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputTofirstnameTextbox(String firstName) {
		waitForElementClickable(driver,RegisterPageUI_Nop.FIRST_NAME);
		sendkeyToElement(driver,RegisterPageUI_Nop.FIRST_NAME,firstName);
	}
	
	public void inputTolastnameTextbo(String lastName) {
		waitForElementClickable(driver,RegisterPageUI_Nop.LAST_NAME);
		sendkeyToElement(driver,RegisterPageUI_Nop.LAST_NAME,lastName);
	}
	
	public void inputToEmailTextbox(String existingEmail) {
		waitForElementClickable(driver,RegisterPageUI_Nop.EMAIL);
		sendkeyToElement(driver,RegisterPageUI_Nop.EMAIL,existingEmail);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver,RegisterPageUI_Nop.PASSWORD);
		sendkeyToElement(driver,RegisterPageUI_Nop.PASSWORD,password);
	}
	
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementClickable(driver,RegisterPageUI_Nop.CONFIRM_PASSWORD);
		sendkeyToElement(driver,RegisterPageUI_Nop.CONFIRM_PASSWORD,confirmPassword);
	}
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver,RegisterPageUI_Nop.REGISTER_BUTTON);
		clickToElement(driver,RegisterPageUI_Nop.REGISTER_BUTTON);
	}
	
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver,RegisterPageUI_Nop.REGISTER_RESULT_MESSAGE);
		return getElementText(driver,RegisterPageUI_Nop.REGISTER_RESULT_MESSAGE);
	}
	
	public void clickTologoutLink() {
		waitForElementClickable(driver,RegisterPageUI_Nop.LOGOUT_BUTTON);
		clickToElement(driver,RegisterPageUI_Nop.LOGOUT_BUTTON);
	}
	
	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver,RegisterPageUI_Nop.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI_Nop.FIRST_NAME_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver,RegisterPageUI_Nop.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI_Nop.LAST_NAME_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,RegisterPageUI_Nop.EMAIL_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI_Nop.EMAIL_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver,RegisterPageUI_Nop.PASSWORD_ERROR_MESSAGE );
		return getElementText(driver,RegisterPageUI_Nop.PASSWORD_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver,RegisterPageUI_Nop.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI_Nop.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailExistTextbox() {
		waitForElementVisible(driver,RegisterPageUI_Nop.EMAIL_EXIST_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI_Nop.EMAIL_EXIST_ERROR_MESSAGE);
	}

}
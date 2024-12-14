package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopCommerce.user.UserLoginPageUI;
import pageUI.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	// Biến global
	private WebDriver driver;

	// Hàm khởi tạo cùng tên với clas ko có kiểu trả về.
	// Khi khở tạo 1 đối tượng của class đó thì hàm khởi tạo sẽ được gọi đầu tiên		
	// Hàm này được gọi tên là Constructor
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserHomePageObject clickTologoutLink() {
		waitForElementInVisible(driver, UserLoginPageUI.LOGOUT_LINK);
		clickToElement(driver, UserLoginPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePageOfnopCommerce(driver);
	}
	
	public void inputTofirstnameTextbox(String firstName) {
		waitForElementClickable(driver,UserRegisterPageUI.FIRST_NAME);
		sendkeyToElement(driver,UserRegisterPageUI.FIRST_NAME,firstName);
	}
	
	public void inputTolastnameTextbo(String lastName) {
		waitForElementClickable(driver,UserRegisterPageUI.LAST_NAME);
		sendkeyToElement(driver,UserRegisterPageUI.LAST_NAME,lastName);
	}
	
	public void inputToEmailTextbox(String existingEmail) {
		waitForElementClickable(driver,UserRegisterPageUI.EMAIL);
		sendkeyToElement(driver,UserRegisterPageUI.EMAIL,existingEmail);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver,UserRegisterPageUI.PASSWORD);
		sendkeyToElement(driver,UserRegisterPageUI.PASSWORD,password);
	}
	
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementClickable(driver,UserRegisterPageUI.CONFIRM_PASSWORD);
		sendkeyToElement(driver,UserRegisterPageUI.CONFIRM_PASSWORD,confirmPassword);
	}
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver,UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver,UserRegisterPageUI.REGISTER_BUTTON);
	}
	
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver,UserRegisterPageUI.REGISTER_RESULT_MESSAGE);
		return getElementText(driver,UserRegisterPageUI.REGISTER_RESULT_MESSAGE);
	}
	
	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver,UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver,UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver,UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver,UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver,UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver,UserRegisterPageUI.PASSWORD_ERROR_MESSAGE );
		return getElementText(driver,UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver,UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver,UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailExistTextbox() {
		waitForElementVisible(driver,UserRegisterPageUI.EMAIL_EXIST_ERROR_MESSAGE);
		return getElementText(driver,UserRegisterPageUI.EMAIL_EXIST_ERROR_MESSAGE);
	}

}
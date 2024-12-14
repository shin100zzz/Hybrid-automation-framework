package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopCommerce.user.UserHomePageUI;
import pageUI.nopCommerce.user.UserLoginPageUI;

public class UserHomePageObject extends BasePage{
	// Biến global
	private WebDriver driver;

	// Hàm khởi tạo cùng tên với clas ko có kiểu trả về.
	// Khi khở tạo 1 đối tượng của class đó thì hàm khởi tạo sẽ được gọi đầu tiên
	// Hàm này được gọi tên là Constructor
	public UserHomePageObject(WebDriver driver) {
		// Biến local
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementInVisible(driver, UserLoginPageUI.LOGIN_BUTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTON);
	}
	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPageOfnopCommerce(driver);
	} 

	public UserLoginPageObject clickTologinLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPageOfnopCommerce(driver);
	}

	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPageOfnopCommerce(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		}

	public UserCustomerInforPageObject openMyAccount() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver,UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPageOfnopCommerce(driver);
	}

}
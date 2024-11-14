package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopCommerce.user.HomePageUI_Nop;
import pageUI.nopCommerce.user.LoginPageUI_Nop;

public class HomePageObject_Nop extends BasePage{
	// Biến global
	private WebDriver driver;

	// Hàm khởi tạo cùng tên với clas ko có kiểu trả về.
	// Khi khở tạo 1 đối tượng của class đó thì hàm khởi tạo sẽ được gọi đầu tiên
	// Hàm này được gọi tên là Constructor
	public HomePageObject_Nop(WebDriver driver) {
		// Biến local
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementInVisible(driver, LoginPageUI_Nop.LOGIN_BUTON);
		clickToElement(driver, LoginPageUI_Nop.LOGIN_BUTON);
	}
	public LoginPageObject_Nop openLoginPage() {
		waitForElementClickable(driver, HomePageUI_Nop.LOGIN_LINK);
		clickToElement(driver, HomePageUI_Nop.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPageOfnopCommerce(driver);
	} 

	public LoginPageObject_Nop clickTologinLink() {
		waitForElementClickable(driver, HomePageUI_Nop.LOGIN_LINK);
		clickToElement(driver, HomePageUI_Nop.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPageOfnopCommerce(driver);
	}

	public RegisterPageObject_Nop clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI_Nop.REGISTER_LINK);
		clickToElement(driver, HomePageUI_Nop.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPageOfnopCommerce(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI_Nop.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI_Nop.MY_ACCOUNT_LINK);
		}

}
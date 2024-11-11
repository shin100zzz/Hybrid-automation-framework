package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
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
	
	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI_Nop.REGISTER_LINK);
		clickToElement(driver, HomePageUI_Nop.REGISTER_LINK);
	}

	public void clickTologinLink() {
		waitForElementClickable(driver, HomePageUI_Nop.LOGIN_LINK);
		clickToElement(driver, HomePageUI_Nop.LOGIN_LINK);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI_Nop.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI_Nop.MY_ACCOUNT_LINK);
		}

	public void openMyAccount() {
		waitForElementClickable(driver, HomePageUI_Nop.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI_Nop.MY_ACCOUNT_LINK);
	}

	public void openLoginPage() {
		waitForElementClickable(driver, HomePageUI_Nop.LOGIN_LINK);
		clickToElement(driver, HomePageUI_Nop.LOGIN_LINK);
	}
	

	
}
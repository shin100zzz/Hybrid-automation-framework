package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.user.AddressPageObject_Nop;
import pageObjects.nopCommerce.user.CustomerInforPageObject_Nop;
import pageObjects.nopCommerce.user.HomePageObject_Nop;
import pageObjects.nopCommerce.user.RegisterPageObject_Nop;
import pageObjects.nopCommerce.user.RewardPointPageObject_Nop;
import pageObjects.nopCommerce.user.LoginPageObject_Nop;
import pageObjects.nopCommerce.user.MyProductReviewPageObject_Nop;

public class PageGeneratorManager {
	
	public static HomePageObject_Nop getHomePage(WebDriver driver) {
		return new HomePageObject_Nop(driver);
	}
	
	public static HomePageObject_Nop getUserHomePageOfnopCommerce(WebDriver driver) {
		return new HomePageObject_Nop(driver);
	}
	
	public static LoginPageObject_Nop getLoginPage(WebDriver driver) {
		return new LoginPageObject_Nop(driver);
	}

	public static LoginPageObject_Nop getUserLoginPageOfnopCommerce(WebDriver driver) {
		return new LoginPageObject_Nop(driver);
	}

	public static RegisterPageObject_Nop getUserRegisterPageOfnopCommerce(WebDriver driver) {
		return new RegisterPageObject_Nop(driver);
	}

	public static CustomerInforPageObject_Nop getUserCustomerInforPageOfnopCommerce(WebDriver driver) {
		return new CustomerInforPageObject_Nop(driver);
	}
	
	public static AddressPageObject_Nop getAddressPageOfnopCommerce(WebDriver driver) {
		return new AddressPageObject_Nop(driver);
	}
	
	public static MyProductReviewPageObject_Nop getMyProductReviewPageOfnopCommerce(WebDriver driver) {
		return new MyProductReviewPageObject_Nop(driver);
	}
	
	public static RewardPointPageObject_Nop getRewardPointageOfnopCommerce(WebDriver driver) {
		return new RewardPointPageObject_Nop(driver);
	}
}
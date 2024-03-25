package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.facebook.LoginPageObject;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.nopCommerce.user.NopCommerce_User_AddressPageObject;
import pageObjects.nopCommerce.user.NopCommerce_User_CustomerInforPageObject;
import pageObjects.nopCommerce.user.NopCommerce_User_HomePageObject;
import pageObjects.nopCommerce.user.NopCommerce_User_LoginPageObject;
import pageObjects.nopCommerce.user.NopCommerce_User_MyProductReviewPageObject;
import pageObjects.nopCommerce.user.NopCommerce_User_RegisterPageObject;
import pageObjects.nopCommerce.user.NopCommerce_User_RewardPointPageObject;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static NopCommerce_User_HomePageObject getUserHomePageOfnopCommerce(WebDriver driver) {
		return new NopCommerce_User_HomePageObject(driver);
	}
	
	public static NopCommerce_User_LoginPageObject getUserLoginPageOfnopCommerce(WebDriver driver) {
		return new NopCommerce_User_LoginPageObject(driver);
	}

	public static NopCommerce_User_RegisterPageObject getUserRegisterPageOfnopCommerce(WebDriver driver) {
		return new NopCommerce_User_RegisterPageObject(driver);
	}

	public static NopCommerce_User_CustomerInforPageObject getUserCustomerInforPageOfnopCommerce(WebDriver driver) {
		return new NopCommerce_User_CustomerInforPageObject(driver);
	}

	public static NopCommerce_User_AddressPageObject getUserAddressPageOfnopCommerce(WebDriver driver) {
		return new NopCommerce_User_AddressPageObject(driver);
	}
	
	public static NopCommerce_User_MyProductReviewPageObject getUserMyProductReviewPageOfnopCommerce(WebDriver driver) {
		return new NopCommerce_User_MyProductReviewPageObject(driver);
	}

	public static NopCommerce_User_RewardPointPageObject getUserRewardPointageOfnopCommerce(WebDriver driver) {
		return new NopCommerce_User_RewardPointPageObject(driver);
	}
}

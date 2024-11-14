package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.user.HomePageObject_Nop;
import pageObjects.nopCommerce.user.RegisterPageObject_Nop;
import pageObjects.nopCommerce.user.LoginPageObject_Nop;

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
}
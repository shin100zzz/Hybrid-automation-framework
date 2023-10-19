package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.facebook.LoginPageObject;
import pageObjects.jQuery.dataTable.HomePageObject;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

}

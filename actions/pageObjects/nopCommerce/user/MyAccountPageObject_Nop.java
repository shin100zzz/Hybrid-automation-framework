package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MyAccountPageObject_Nop extends BasePage {
	WebDriver driver;
	
	public MyAccountPageObject_Nop(WebDriver driver) {
		this.driver = driver;
	}

}
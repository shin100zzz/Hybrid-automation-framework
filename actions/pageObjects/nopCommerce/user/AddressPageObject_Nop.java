package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AddressPageObject_Nop extends BasePage {
	WebDriver driver;
	
	public AddressPageObject_Nop(WebDriver driver) {
		this.driver = driver;
	}
}
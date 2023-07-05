package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Shopify_LoginWithPartnerUI;

public class Shopify_LoginWithPartnerObject extends BasePage{

	WebDriver driver;
	
	public Shopify_LoginWithPartnerObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openBrowser() {
		openAnyUrl(driver, "https://partners.shopify.com/2393784/stores");
	}

	public void setTextToEmail(String email) {
		waitForElementInVisible(driver, Shopify_LoginWithPartnerUI.EMAIL, 10);
		delay(5);
		sendkeyToElement(driver, Shopify_LoginWithPartnerUI.EMAIL, email );

	}
	
	public void setTextToPassword(String password) {
		waitForElementInVisible(driver, Shopify_LoginWithPartnerUI.PASSWORD, 10);
		delay(5);
		sendkeyToElement(driver, Shopify_LoginWithPartnerUI.PASSWORD, password );
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, Shopify_LoginWithPartnerUI.NEXT_OR_LOGIN_BUTTON, 10);
		delay(5);
		clickToElement(driver, Shopify_LoginWithPartnerUI.NEXT_OR_LOGIN_BUTTON);

	}

}

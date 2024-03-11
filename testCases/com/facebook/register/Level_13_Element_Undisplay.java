package com.facebook.register;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.facebook.LoginPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_13_Element_Undisplay extends BaseTest {
	private LoginPageObject loginPage;
	private WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = getBrowserDriver(browser, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreatNewAccountButton();
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());

		loginPage.enterToEmailAddressTextbox("auto@gmail.com");
		loginPage.delay(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
	}

	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		// Verify false - cho ham tra ve displayed
		loginPage.enterToEmailAddressTextbox("");
		loginPage.delay(2);
		verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickCloseIconRegisterForm();
		loginPage.delay(2);

		// Verify False - mong doi Confirm email Undisplayed (false)
		// isDisplayed: ban chat ko kiem tra 1 elment ko co torng DOM duoc
//		verifyFalse(loginPage.isConfirmEmailAddressTextboxUndisplayed());
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

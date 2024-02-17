package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObjectnopCommerceUser;
import pageObjects.nopCommerce.user.UserLoginPageObjectnopCommerceUser;
import pageObjects.nopCommerce.user.UserMyAccountPageObjectNopCommerce;
import pageObjects.nopCommerce.user.UserRegisterPageObjectnopCommerceUser;

public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	private UserHomePageObjectnopCommerceUser homePage;
	private UserRegisterPageObjectnopCommerceUser registerPage;
	private UserLoginPageObjectnopCommerceUser loginPage;
	private UserMyAccountPageObjectNopCommerce myAccountPage;
	String firstName,lastName,invalidEmai1,existingEmail,validPassword,incorrectPassword;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getHomePage(driver);
	
	firstName ="Automation";
	lastName = "FC";
	invalidEmai1 ="afc@afc.com@.vn";
	existingEmail ="afc123@gmail.com.vn";
	validPassword ="123456";
	incorrectPassword = "654987";
	
	System.out.println("Pre-Condition - Step 01: Click to Register link");
	registerPage = homePage.clickToRegisterLink();
	
	System.out.println]n("Pre-Condition - Step 02: Input to required fields"); 
	registerPage.inputTofirstnameTextbox(firstName); 
	registerPage.inputTolastnameTextbo(lastName); 
	registerPage.inputToEmailTextbox(existingEmail); 
	registerPage.inputToPasswordTextbox(validPassword); 
	registerPage.inputToConfirmPasswordTextbox(validPassword);
	
	System.out.println("Pre-Condition - Step 03: Click to Register button"); 
	registerPage.clickToRegisterButton();
	
	System.out.println("Pre-Condition - Step 04: Verify success message displayed");
	Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	
	System.out.println("Pre-Condition - Step 05: Click to Logout link");
	homePage = registerPage.clickTologoutLink();

	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.clickTologintink();
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.RetErrorMessageAtEmailTextbox(), "Please enter vour enail");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		loginPage = homePage.clickToLogintink();
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the erro");
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		loginPage = homePage.clickTologintink();
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox();
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful1(),
				"Login was unsuccessful. Please correct the error");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		loginPage = homePage.clickTologinLink();
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {

	}
}

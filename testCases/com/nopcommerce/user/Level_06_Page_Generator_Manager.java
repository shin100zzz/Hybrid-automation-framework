package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.HomePageObject_Nop;
import pageObjects.nopCommerce.user.LoginPageObject_Nop;
import pageObjects.nopCommerce.user.RegisterPageObject_Nop;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_Manager extends BaseTest{
	private WebDriver driver;
	
	String emailAddress,firstName,lastName,validPassword,invalidPassword,inValidemailAddress;
	
	String projectPath = System.getProperty("user.dir");
	private HomePageObject_Nop homePage;
	private RegisterPageObject_Nop registerPage ;
	private LoginPageObject_Nop loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser)
	{
		driver = getBrowserDriver(browser);
		homePage = PageGeneratorManager.getHomePage(driver);
		emailAddress = "test"+generateFakeNumber()+"@gmail.com";
		firstName = "Automation";
		lastName = "FC";
		validPassword = "123456";
		invalidPassword = "321";
		
		// Precondition
		
		homePage.clickToRegisterLink();
		
		registerPage.inputTofirstnameTextbox(firstName); 
		registerPage.inputTolastnameTextbo(lastName); 
		registerPage.inputToEmailTextbox(emailAddress); 
		registerPage.inputToPasswordTextbox(validPassword); 
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		registerPage.clickTologoutLink();
		// Click Logout thì sẽ quay về trang home
	}
	
	@Test
	public void TC_01_Login_Empty_Data(){
		homePage.clickTologinLink();
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
		
	}
	
	@Test
	public void TC_02_Login_Invalid_Email(){
		homePage.clickTologinLink();
		
		loginPage.inputToEmailTextBox("2345@@fdd.com");
		loginPage.inputToPasswordTextBox(validPassword);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
		
	}
	@Test
	public void TC_03_Login_Email_Not_Found(){
		homePage.clickTologinLink();
		
		loginPage.inputToEmailTextBox("2345@fdd.com");
		loginPage.inputToPasswordTextBox(validPassword);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	
	}
	@Test
	public void TC_04_Login_Existing_Email_Empty_Password(){
		homePage.clickTologinLink();
		
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	
	}
	@Test
	public void TC_05_Login_Existing_Email_Incorrect_Password(){
		homePage.clickTologinLink();
		
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox("343543423");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	
	@Test
	public void TC_06_Login_Success(){
		homePage.clickTologinLink();
		
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(validPassword);
		loginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	
	@AfterClass
	public void AfterClass()
	{
		driver.quit();
	}
	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
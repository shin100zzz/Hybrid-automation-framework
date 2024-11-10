package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.user.NopCommerce_User_HomePageObject;
import pageObjects.nopCommerce.user.NopCommerce_User_LoginPageObject;
import pageObjects.nopCommerce.user.NopCommerce_User_RegisterPageObject;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object_Pattern_III_Login{
	private WebDriver driver;
	
	String emailAddress,firstName,lastName,validPassword,invalidPassword,inValidemailAddress;
	
	String projectPath = System.getProperty("user.dir");
	private NopCommerce_User_HomePageObject homePage;
	private NopCommerce_User_RegisterPageObject registerPage ;
	private NopCommerce_User_LoginPageObject loginPage;
	
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		
		emailAddress = "test"+generateFakeNumber()+"@gmail.com";
		firstName = "Automation";
		lastName = "FC";
		validPassword = "123456";
		invalidPassword = "321";
		
		// Precondition
		homePage = new NopCommerce_User_HomePageObject(driver);
		homePage.clickToRegisterLink();
		registerPage = new NopCommerce_User_RegisterPageObject(driver);
		
		registerPage.inputTofirstnameTextbox(firstName); 
		registerPage.inputTolastnameTextbo(lastName); 
		registerPage.inputToEmailTextbox(emailAddress); 
		registerPage.inputToPasswordTextbox(validPassword); 
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		registerPage.clickTologoutLink();
		// Click Logout thì sẽ quay về trang home
		homePage = new NopCommerce_User_HomePageObject(driver);
	}
	
	@Test
	public void TC_01_Login_Empty_Data(){
		homePage.clickTologinLink();
		
		loginPage = new NopCommerce_User_LoginPageObject(driver);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
		
	}
	
	@Test
	public void TC_02_Login_Invalid_Email(){
		homePage.clickTologinLink();
		
		loginPage = new NopCommerce_User_LoginPageObject(driver);
		
		loginPage.inputToEmailTextBox("2345@@fdd.com");
		loginPage.inputToPasswordTextBox(validPassword);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
		
	}
	@Test
	public void TC_03_Login_Email_Not_Found(){
		homePage.clickTologinLink();
		
		loginPage = new NopCommerce_User_LoginPageObject(driver);
		
		loginPage.inputToEmailTextBox("2345@fdd.com");
		loginPage.inputToPasswordTextBox(validPassword);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	
	}
	@Test
	public void TC_04_Login_Existing_Email_Empty_Password(){
		homePage.clickTologinLink();
		
		loginPage = new NopCommerce_User_LoginPageObject(driver);
		
		loginPage.inputToEmailTextBox(emailAddress);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	
	}
	@Test
	public void TC_05_Login_Existing_Email_Incorrect_Password(){
		homePage.clickTologinLink();
		
		loginPage = new NopCommerce_User_LoginPageObject(driver);
		
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox("343543423");
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	
	@Test
	public void TC_06_Login_Success(){
		homePage.clickTologinLink();
		
		// Từ trang Home click Login link qua trang Login
		loginPage = new NopCommerce_User_LoginPageObject(driver);
		
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
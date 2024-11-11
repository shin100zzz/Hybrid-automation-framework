package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.user.HomePageObject_Nop;
import pageObjects.nopCommerce.user.RegisterPageObject_Nop;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object_Pattern_I_Register{
	private WebDriver driver;
	
	String emailAddress,firstName,lastName,validPassword,invalidPassword;
	
	private HomePageObject_Nop homePage;
	private RegisterPageObject_Nop registerPage ;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		
		homePage = new HomePageObject_Nop(driver);
		
		emailAddress = "test"+generateFakeNumber()+"@gmail.com";
		firstName = "Automation";
		lastName = "FC";
		validPassword = "123456";
		invalidPassword = "321";
	}
	
	@Test
	public void Register_01_Empty_Data()
	{
		homePage.clickToRegisterLink();
		// Click Register link nhảy qya trnag Register
		registerPage = new RegisterPageObject_Nop(driver);
			
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}
	
	@Test
	public void Register_02_Invalid_Email()
	{
		homePage.clickToRegisterLink();
		// Click Register link nhảy qya trnag Register
		registerPage = new RegisterPageObject_Nop(driver);
		
		registerPage.inputTofirstnameTextbox(firstName); 
		registerPage.inputTolastnameTextbo(lastName); 
		registerPage.inputToEmailTextbox("12345678@@2ws");
		registerPage.inputToPasswordTextbox(validPassword); 
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Wrong email");
	}
	
	@Test
	public void Register_03_Success()
	{
		homePage.clickToRegisterLink();
		// Click Register link nhảy qya trnag Register
		registerPage = new RegisterPageObject_Nop(driver);
		
		registerPage.inputTofirstnameTextbox(firstName); 
		registerPage.inputTolastnameTextbo(lastName); 
		registerPage.inputToEmailTextbox(emailAddress); 
		registerPage.inputToPasswordTextbox(validPassword); 
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		homePage.clickToRegisterLink();
	}
	
	@Test
	public void Register_04_Existing_Email()
	{
		homePage.clickToRegisterLink();
		// Click Register link nhảy qya trnag Register
		registerPage = new RegisterPageObject_Nop(driver);
		
		registerPage.inputTofirstnameTextbox(firstName); 
		registerPage.inputTolastnameTextbo(lastName); 
		registerPage.inputToEmailTextbox(emailAddress); 
		registerPage.inputToPasswordTextbox(validPassword); 
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtEmailExistTextbox(), "The specified email already exists");
	}
	
	@Test
	public void Register_05_Password_Less_Than_6_Chars()
	{
		homePage.clickToRegisterLink();
		// Click Register link nhảy qya trnag Register
		registerPage = new RegisterPageObject_Nop(driver);
		
		registerPage.inputTofirstnameTextbox(firstName); 
		registerPage.inputTolastnameTextbo(lastName); 
		registerPage.inputToEmailTextbox(emailAddress); 
		registerPage.inputToPasswordTextbox(invalidPassword); 
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}
	
	@Test
	public void Register_06_Invalid_ConfirmPassword()
	{
		homePage.clickToRegisterLink();
		// Click Register link nhảy qya trnag Register
		registerPage = new RegisterPageObject_Nop(driver);
		
		registerPage.inputTofirstnameTextbox(firstName); 
		registerPage.inputTolastnameTextbo(lastName); 
		registerPage.inputToEmailTextbox(emailAddress); 
		registerPage.inputToPasswordTextbox(validPassword); 
		registerPage.inputToConfirmPasswordTextbox(invalidPassword);
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
		
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
package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Register_Apply_BasePage extends BasePage{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers/chromedriver");
		driver = new ChromeDriver();
		
		emailAddress = "test"+generateFakeNumber()+"@gmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
	}
	
	@Test
	public void TC_01_Register_Empty_Data()
	{
		clickToElement(driver,"xpath=//a[@class='ico-register']");
		clickToElement(driver,"xpath=//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver,"xpath=//span[@id='FirstName-error']"),"First name is required.");
		Assert.assertEquals(getElementText(driver,"xpath=//span[@id='LastName-error']"),"Last name is required.");
		Assert.assertEquals(getElementText(driver,"xpath=//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver,"xpath=//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver,"xpath=//span[@id='ConfirmPassword-error']"), "Password is required.");
		
	}
	
	@Test
	public void TC_02_Register_Invalid_Email()
	{
		clickToElement(driver,"xpath=//a[@class='ico-register']");
		sendkeyToElement(driver,"xpath=//input[@id='FirstName']","Automation");
		sendkeyToElement(driver,"xpath=//input[@id='LastName']","FC");
		sendkeyToElement(driver,"xpath=//input[@id='Email']","123@456#%**");
		sendkeyToElement(driver,"xpath=//input[@id='Password']","123456"); 
		sendkeyToElement(driver,"xpath=//input[@id='ConfirmPassword']","123456"); 
		clickToElement(driver,"xpath=//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver,"xpath=//span[@id='Email-error']"), "Wrong email");
	}
	
	@Test
	public void TC_03_Register_Success()
	{
		clickToElement(driver,"xpath=//a[@class='ico-register']");
		sendkeyToElement(driver,"xpath=//input[@id='FirstName']","Automation");
		sendkeyToElement(driver,"xpath=//input[@id='LastName']","FC");
		sendkeyToElement(driver,"xpath=//input[@id='Email']",emailAddress);
		sendkeyToElement(driver,"xpath=//input[@id='Password']","123456"); 
		sendkeyToElement(driver,"xpath=//input[@id='ConfirmPassword']","123456"); 
		clickToElement(driver,"xpath=//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver,"xpath=//div[@class='result']"), "Your registration completed");
		
		clickToElement(driver,"xpath=//a[@class='ico-register']");
	}
	
	@Test
	public void TC_04_Register_Existing_Email()
	{
		clickToElement(driver,"xpath=//a[@class='ico-register']");
		sendkeyToElement(driver,"xpath=//input[@id='FirstName']","Automation");
		sendkeyToElement(driver,"xpath=//input[@id='LastName']","FC");
		sendkeyToElement(driver,"xpath=//input[@id='Email']",emailAddress);
		sendkeyToElement(driver,"xpath=//input[@id='Password']","123456"); 
		sendkeyToElement(driver,"xpath=//input[@id='ConfirmPassword']","123456"); 
		clickToElement(driver,"xpath=//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver,"xpath=//div[@class='message-error validation-summary-errors']"), "The specified email already exists");
	}
	
	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars()
	{
		clickToElement(driver,"xpath=//a[@class='ico-register']");
		sendkeyToElement(driver,"xpath=//input[@id='FirstName']","Automation");
		sendkeyToElement(driver,"xpath=//input[@id='LastName']","FC");
		sendkeyToElement(driver,"xpath=//input[@id='Email']",emailAddress);
		sendkeyToElement(driver,"xpath=//input[@id='Password']","123"); 
		sendkeyToElement(driver,"xpath=//input[@id='ConfirmPassword']","123"); 
		clickToElement(driver,"xpath=//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver,"xpath=//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
		
	}
	
	@Test
	public void TC_06_Register_Invalid_ConfirmPassword()
	{
		clickToElement(driver,"xpath=//a[@class='ico-register']");
		sendkeyToElement(driver,"xpath=//input[@id='FirstName']","Automation");
		sendkeyToElement(driver,"xpath=//input[@id='LastName']","FC");
		sendkeyToElement(driver,"xpath=//input[@id='Email']",emailAddress);
		sendkeyToElement(driver,"xpath=//input[@id='Password']","123456"); 
		sendkeyToElement(driver,"xpath=//input[@id='ConfirmPassword']","123567"); 
		clickToElement(driver,"xpath=//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver,"xpath=//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
		
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
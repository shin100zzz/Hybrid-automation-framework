package com.nopcommerce.user;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_05_Headless_Browser extends BaseTest{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser)
	{
		driver = getBrowserDriver(browser);
		emailAddress = "test"+generateFakeNumber()+"@gmail.com";
	}
	
	@Test
	public void TC_01_Register_Empty_Data()
	{
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(),"Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required."); // Not use 
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");
	}
	
	@Test
	public void TC_02_Register_Invalid_Email()
	{
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
		driver.findElement(By.cssSelector("input#Email")).sendKeys("123@456#%**");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456"); 
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys ("123456"); 
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Please enter a valid email address.");
	}
	
	
	@AfterClass
	public void AfterClass()
	{
		
	}
	

}
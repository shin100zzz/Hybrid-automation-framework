package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_05_Multiple_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName)
	{
		System.out.println("Run on " + browserName);
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers/chromedriver");
			driver = new ChromeDriver();
		}else if(browserName.equals("h_chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers/geckodriver");
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "//browserDrivers/msedgedriver");
			driver = new EdgeDriver();
		}
		
		emailAddress = "test"+generateFakeNumber()+"@gmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
	}
	
	@Test
	public void TC_01_Register_Empty_Data()
	{
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(),"Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");
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
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
	}
	
	
	@AfterClass
	public void AfterClass()
	{
		
	}
	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}

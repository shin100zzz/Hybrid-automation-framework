package common;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.Shopify_LoginWithPartnerObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Shopify_LoginWithParner extends BaseTest{
	
	// Declar
	private WebDriver driver;
	
	// Declar + Init
	Shopify_LoginWithPartnerObject formLogin;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
  @Parameters("browser")
  @BeforeClass  
  public void beforeClass(String browserName) {
	  	driver = getBrowserDriver(browserName);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://partners.shopify.com/2393784/stores");
		
		formLogin = new Shopify_LoginWithPartnerObject(driver);
  }	 
	 
  @Test
  public void LoginWithShopifyDevelopment() {
	  formLogin.setTextToEmail("nghia.nguyen@apps-cyclone.com");
	  formLogin.clickToLoginButton();
	  formLogin.setTextToPassword("123@xyz!NghiaNguyen");
	  formLogin.clickToLoginButton();
	  
  }

@AfterClass
  public void afterClass() {
//	driver.quit();
  }

}
 
package common;

import org.testng.annotations.Test;

import pageObjects.Shopify_LoginWithPartnerObject;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Shopify_LoginWithParner {
	
	// Declar
	private WebDriver driver;
	
	// Declar + Init
	Shopify_LoginWithPartnerObject formLogin;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

  @BeforeClass  
  public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");		
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//			System.setProperty("webdriver.chrome.driver",projectPath + "/browserDrivers/chromedriver");
		}

		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
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
 
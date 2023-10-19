package commons;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driverBaseTest;
	private String projectPath = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");
	
	public void delay(long time) {
		 try {
			 Thread.sleep(time*1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		
		if (osName.contains("Mac OS X")) {
			if(browserList == BrowserList.CHROME) {
				System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers/chromedriver");		
				driverBaseTest = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				driverBaseTest = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP_VERSION) {
				WebDriverManager.chromedriver().driverVersion("95.0.4638.17").setup();
				driverBaseTest = new ChromeDriver();				
			}else if(browserList == BrowserList.H_CHROME) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new ChromeDriver(options);				
			}else if(browserList == BrowserList.H_CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new ChromeDriver(options);				
			}else if(browserList == BrowserList.FIREFOX) {
				System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers/geckodriver");		
				driverBaseTest = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				driverBaseTest = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP_VERSION) {
				WebDriverManager.firefoxdriver().driverVersion("95.0.4638.17").setup();
				driverBaseTest = new FirefoxDriver();				
			}else if(browserList == BrowserList.H_FIREFOX) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new FirefoxDriver(options);			
			}else if(browserList == BrowserList.H_FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new FirefoxDriver(options);				
			}else {
				throw new RuntimeException("Browser name invalid");
			}
		}
		else { // Windows
			if(browserList == BrowserList.CHROME) {
				System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers/chromedriver");		
				driverBaseTest = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				driverBaseTest = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP_VERSION) {
				WebDriverManager.chromedriver().driverVersion("95.0.4638.17").setup();
				driverBaseTest = new ChromeDriver();				
			}else if(browserList == BrowserList.H_CHROME) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new ChromeDriver(options);				
			}else if(browserList == BrowserList.H_CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new ChromeDriver(options);				
			}else if(browserList == BrowserList.FIREFOX) {
				System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers/geckodriver");		
				driverBaseTest = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				driverBaseTest = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP_VERSION) {
				WebDriverManager.firefoxdriver().driverVersion("95.0.4638.17").setup();
				driverBaseTest = new FirefoxDriver();				
			}else if(browserList == BrowserList.H_FIREFOX) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new FirefoxDriver(options);			
			}else if(browserList == BrowserList.H_FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new FirefoxDriver(options);				
			}else {
				throw new RuntimeException("Browser name invalid");
			}
		}
		
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalVariable.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.get(GlobalVariable.PORTAL_DEV_URL);
		return driverBaseTest;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String url) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		
		if (osName.contains("Mac OS X")) {
			if(browserList == BrowserList.CHROME) {
				System.setProperty("webdriver.chrome.driver", projectPath + File.separator+ "browserDrivers"+ File.separator+ "chromedriver");		
				driverBaseTest = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				driverBaseTest = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP_VERSION) {
				WebDriverManager.chromedriver().driverVersion("95.0.4638.17").setup();
				driverBaseTest = new ChromeDriver();				
			}else if(browserList == BrowserList.H_CHROME) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new ChromeDriver(options);				
			}else if(browserList == BrowserList.H_CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new ChromeDriver(options);				
			}else if(browserList == BrowserList.FIREFOX) {
				System.setProperty("webdriver.gecko.driver", projectPath + File.separator+ "browserDrivers"+ File.separator+ "geckodriver");		
				driverBaseTest = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				driverBaseTest = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP_VERSION) {
				WebDriverManager.firefoxdriver().driverVersion("95.0.4638.17").setup();
				driverBaseTest = new FirefoxDriver();				
			}else if(browserList == BrowserList.H_FIREFOX) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new FirefoxDriver(options);			
			}else if(browserList == BrowserList.H_FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new FirefoxDriver(options);				
			}else {
				throw new RuntimeException("Browser name invalid");
			}
		}
		else { // Windows
			if(browserList == BrowserList.CHROME) {
				System.setProperty("webdriver.chrome.driver", projectPath +File.separator+ "browserDrivers"+ File.separator+ "chromedriver");		
				driverBaseTest = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				driverBaseTest = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP_VERSION) {
				WebDriverManager.chromedriver().driverVersion("95.0.4638.17").setup();
				driverBaseTest = new ChromeDriver();				
			}else if(browserList == BrowserList.H_CHROME) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new ChromeDriver(options);				
			}else if(browserList == BrowserList.H_CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new ChromeDriver(options);				
			}else if(browserList == BrowserList.FIREFOX) {
				System.setProperty("webdriver.gecko.driver", projectPath + File.separator+ "browserDrivers"+ File.separator+ "geckodriver");		
				driverBaseTest = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				driverBaseTest = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP_VERSION) {
				WebDriverManager.firefoxdriver().driverVersion("95.0.4638.17").setup();
				driverBaseTest = new FirefoxDriver();				
			}else if(browserList == BrowserList.H_FIREFOX) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new FirefoxDriver(options);			
			}else if(browserList == BrowserList.H_FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driverBaseTest = new FirefoxDriver(options);				
			}else {
				throw new RuntimeException("Browser name invalid");
			}
		}
		
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalVariable.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.get(url);
		return driverBaseTest;
	}
	
	protected String getEnvironmentUr(String serverName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		if (environment == EnvironmentList.DEV) {
		envUrl = "https: / /demo.nopcommerce.com/";
		} else if (environment == EnvironmentList.TESTING) {
		envUrl = "https: //admin-demo.nopcommerce.com";
		} else if (environment == EnvironmentList.STAGING) {
		envUrl = "https://staging.orangehrmlive.com";
		} else if (environment == EnvironmentList. PRODUCTION) {
		envUrl = "https://production.orangehrmlive.com";
		}
		return envUrl;
	}
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			System.out.println("---------------------- PASSED ----------------------");
		} catch (Throwable e) {
			System.out.println("---------------------- FAILED ----------------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			System.out.println("---------------------- PASSED ----------------------");
		} catch (Throwable e) {
			System.out.println("---------------------- FAILED ----------------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.println("---------------------- PASSED ----------------------");
		} catch (Throwable e) {
			System.out.println("---------------------- FAILED ----------------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
}

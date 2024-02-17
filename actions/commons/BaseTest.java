package commons;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");
	protected final Log log;
	
	// Constructor
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	public void delay(long time) {
		 try {
			 Thread.sleep(time*1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(1000);
	}
	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		
		if (osName.contains("Mac OS X")) {
			if(browserList == BrowserList.CHROME) {
				System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers/chromedriver");		
				driver = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP_VERSION) {
				WebDriverManager.chromedriver().driverVersion("114.0.5735.90").setup();
				driver = new ChromeDriver();				
			}else if(browserList == BrowserList.H_CHROME) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driver = new ChromeDriver(options);				
			}else if(browserList == BrowserList.H_CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driver = new ChromeDriver(options);				
			}else if(browserList == BrowserList.FIREFOX) {
				System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers/geckodriver");		
				driver = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP_VERSION) {
				WebDriverManager.firefoxdriver().driverVersion("95.0.4638.17").setup();
				driver = new FirefoxDriver();				
			}else if(browserList == BrowserList.H_FIREFOX) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driver = new FirefoxDriver(options);			
			}else if(browserList == BrowserList.H_FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driver = new FirefoxDriver(options);				
			}else {
				throw new RuntimeException("Browser name invalid");
			}
		}
		else { // Windows
			if(browserList == BrowserList.CHROME) {
				System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers/chromedriver");		
				driver = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP_VERSION) {
				WebDriverManager.chromedriver().driverVersion("95.0.4638.17").setup();
				driver = new ChromeDriver();				
			}else if(browserList == BrowserList.H_CHROME) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driver = new ChromeDriver(options);				
			}else if(browserList == BrowserList.H_CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driver = new ChromeDriver(options);				
			}else if(browserList == BrowserList.FIREFOX) {
				System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers/geckodriver");		
				driver = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP_VERSION) {
				WebDriverManager.firefoxdriver().driverVersion("95.0.4638.17").setup();
				driver = new FirefoxDriver();				
			}else if(browserList == BrowserList.H_FIREFOX) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driver = new FirefoxDriver(options);			
			}else if(browserList == BrowserList.H_FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driver = new FirefoxDriver(options);				
			}else {
				throw new RuntimeException("Browser name invalid");
			}
		}
		
		driver.manage().timeouts().implicitlyWait(GlobalVariable.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(GlobalVariable.PORTAL_DEV_URL);
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String url) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		
		if (osName.contains("Mac OS X")) {
			if(browserList == BrowserList.CHROME) {
				System.setProperty("webdriver.chrome.driver", projectPath + File.separator+ "browserDrivers"+ File.separator+ "chromedriver");		
				driver = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP_VERSION) {
				WebDriverManager.chromedriver().driverVersion("95.0.4638.17").setup();
				driver = new ChromeDriver();				
			}else if(browserList == BrowserList.H_CHROME) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driver = new ChromeDriver(options);				
			}else if(browserList == BrowserList.H_CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driver = new ChromeDriver(options);				
			}else if(browserList == BrowserList.FIREFOX) {
				System.setProperty("webdriver.gecko.driver", projectPath + File.separator+ "browserDrivers"+ File.separator+ "geckodriver");		
				driver = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP_VERSION) {
				WebDriverManager.firefoxdriver().driverVersion("95.0.4638.17").setup();
				driver = new FirefoxDriver();				
			}else if(browserList == BrowserList.H_FIREFOX) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driver = new FirefoxDriver(options);			
			}else if(browserList == BrowserList.H_FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driver = new FirefoxDriver(options);				
			}else {
				throw new RuntimeException("Browser name invalid");
			}
		}
		else { // Windows
			if(browserList == BrowserList.CHROME) {
				System.setProperty("webdriver.chrome.driver", projectPath +File.separator+ "browserDrivers"+ File.separator+ "chromedriver");		
				driver = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();				
			}else if(browserList == BrowserList.CHROME_SETUP_VERSION) {
				WebDriverManager.chromedriver().driverVersion("95.0.4638.17").setup();
				driver = new ChromeDriver();				
			}else if(browserList == BrowserList.H_CHROME) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driver = new ChromeDriver(options);				
			}else if(browserList == BrowserList.H_CHROME_SETUP) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driver = new ChromeDriver(options);				
			}else if(browserList == BrowserList.FIREFOX) {
				System.setProperty("webdriver.gecko.driver", projectPath + File.separator+ "browserDrivers"+ File.separator+ "geckodriver");		
				driver = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();				
			}else if(browserList == BrowserList.FIREFOX_SETUP_VERSION) {
				WebDriverManager.firefoxdriver().driverVersion("95.0.4638.17").setup();
				driver = new FirefoxDriver();				
			}else if(browserList == BrowserList.H_FIREFOX) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driver = new FirefoxDriver(options);			
			}else if(browserList == BrowserList.H_FIREFOX_SETUP) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driver = new FirefoxDriver(options);				
			}else {
				throw new RuntimeException("Browser name invalid");
			}
		}
		
		driver.manage().timeouts().implicitlyWait(GlobalVariable.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
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
			log.info("---------------------- PASSED ----------------------");
		} catch (Throwable e) {
			log.info("---------------------- FAILED ----------------------");
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
			log.info("---------------------- PASSED ----------------------");
		} catch (Throwable e) {
			log.info("---------------------- FAILED ----------------------");
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
			log.info("---------------------- PASSED ----------------------");
		} catch (Throwable e) {
			log.info("---------------------- FAILED ----------------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
}

package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");
	
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
		
		if (osName.contains("Mac OS X")) {
			if(browserName == "chrome") {
				System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers/chromedriver");		
				driver = new ChromeDriver();				
			}else if(browserName == "chrome_setup") {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();				
			}else if(browserName == "chrome_setup_version") {
				WebDriverManager.chromedriver().driverVersion("130.0.6723.69").setup();
				driver = new ChromeDriver();				
			}else if(browserName == "chrome_H") {
				System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers/chromedriver");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driver = new ChromeDriver(options);				
			}else if(browserName == "chrome_H_setup") {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driver = new ChromeDriver(options);
			}else if(browserName == "firefox") {
				System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers/geckodriver");		
				driver = new FirefoxDriver();				
			}else if(browserName == "firefox_setup") {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();				
			}else if(browserName == "firefox_setup_version") {
				WebDriverManager.firefoxdriver().driverVersion("95.0.4638.17").setup();
				driver = new FirefoxDriver();				
			}else if(browserName == "firefox_H") {
				System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers/geckodriver");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driver = new FirefoxDriver(options);			
			}else if(browserName == "firefox_H_setup") {
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
			if(browserName == "chrome") {
				System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver");		
				driver = new ChromeDriver();				
			}else if(browserName == "chrome_setup") {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();				
			}else if(browserName == "chrome_setup_version") {
				WebDriverManager.chromedriver().driverVersion("130.0.6723.69").setup();
				driver = new ChromeDriver();				
			}else if(browserName == "chrome_H") {
				System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver");	
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driver = new ChromeDriver(options);				
			}else if(browserName == "chrome_H_setup") {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("-headless");
				options.addArguments("window-size=1920x1080");
				driver = new ChromeDriver(options);			
			}else if(browserName == "firefox") {
				System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver");		
				driver = new FirefoxDriver();				
			}else if(browserName == "firefox_setup") {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();				
			}else if(browserName == "firefox_setup_version") {
				WebDriverManager.firefoxdriver().driverVersion("95.0.4638.17").setup();
				driver = new FirefoxDriver();				
			}else if(browserName == "firefox_H") {
				System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driver = new FirefoxDriver(options);			
			}else if(browserName == "firefox_H_setup") {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driver = new FirefoxDriver(options);				
			}else {
				throw new RuntimeException("Browser name invalid");
			}
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(GlobalVariable.PORTAL_DEV_URL);
		return driver;
	}
}
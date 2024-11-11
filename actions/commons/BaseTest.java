package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName) {
		
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
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://demo.nopcommerce.com");
			return driver;
	}

	
}
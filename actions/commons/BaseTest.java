package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");
	
	protected WebDriver getBrowserDriver(String browserName) {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");		
			WebDriverManager.firefoxdriver().setup();
		} 
		else {
			if(browserName.equals("firefox")) {
//				System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else 
				if(browserName.equals("chrome")) {
//				System.setProperty("webdriver.chrome.driver",projectPath + "/browserDrivers/chromedriver");
				WebDriverManager.chromedriver().driverVersion("114.0.5735.16").setup();
				driver = new ChromeDriver();
			}
//			else if(browserName.equals("edge")) {
//				System.setProperty("webdriver.edge.driver",projectPath + "/browserDrivers/msedgedriver");
//				driver = new EdgeDriver();
//			}
			else {
				throw new RuntimeException("Browser name invalid");
			}
		}
		
		return driver;
	}
	
}

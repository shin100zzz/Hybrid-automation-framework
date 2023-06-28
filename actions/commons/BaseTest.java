package commons;

import org.openqa.selenium.WebDriver;

public class BaseTest {
	WebDriver driver;
	BasePage webUI;
	
	// Khoi tao
	

	public void TC_01() {
		webUI = BasePage.getWebUIObject();
		webUI.clickToElement(driver, "213");
	}
}

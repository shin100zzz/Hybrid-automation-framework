package pageObjects.jQuery.uploadFile;

import org.openqa.selenium.WebDriver;

public class Jquery_UploadFile_PageGeneratorManager {

	public static Jquery_UploadFile_HomePageObject getHomePage(WebDriver driver) {
		return new Jquery_UploadFile_HomePageObject(driver);
	}
	
}

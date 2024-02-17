package pageObjects.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUIjQueryUploadFile;

public class Jquery_UploadFile_HomePageObject extends BasePage {
	private WebDriver driver;

	public Jquery_UploadFile_HomePageObject (WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isFileLoadedByName (String fileName) {
		waitForElementVisible(driver, HomePageUIjQueryUploadFile.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUIjQueryUploadFile.FILE_NAME_LOADED, fileName);
	}

	public boolean isFileLinkUploadedByName (String fileName) {
		waitForElementVisible(driver, HomePageUIjQueryUploadFile.FILE_NAME_LOADED_LINK, fileName);
		return isElementDisplayed(driver, HomePageUIjQueryUploadFile.FILE_NAME_LOADED_LINK, fileName);
	}
	
	public boolean isFileImageUploadedByName (String fileName) {
		waitForElementVisible(driver, HomePageUIjQueryUploadFile.FILE_NAME_LOADED_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUIjQueryUploadFile.FILE_NAME_LOADED_IMAGE, fileName);
	}
	
	public void clickToStartButton() {
		List<WebElement> startButtons = getListElements(driver, HomePageUIjQueryUploadFile.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			delay(2);
		}
	}

}

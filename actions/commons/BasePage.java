package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;	
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	private long timeout =30;
	
	public void openAnyUrl(String url) {
		driver.get(url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getPageSourceCode() {
		return driver.getPageSource();
	}
	
	public void backToPage() {
		driver.navigate().back();
	}
	
	public void forwardToPage() {
		driver.navigate().forward(); 
	}
	
	public void refreshCurrentPage() {
		driver.navigate().refresh(); 
	}
	
	public Alert waitForAlertPresence () {
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert() {
		Alert alert = waitForAlertPresence();
		alert.accept();
	}
	
	public void cancelAlert() {
		waitForAlertPresence().dismiss();		
	}
	
	public String getTextAlert() {
		return waitForAlertPresence().getText();		
	}
	
	public void sendkeyToAlert(String textValue) {
		waitForAlertPresence().sendKeys(textValue);
	}
	
	public void switchToWindowByID(String winDowID) {
		Set<String> allWinDowIDs = driver.getWindowHandles();
		for (String id : allWinDowIDs) {
			if (!id.equals(winDowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	public void switchToWindowByTitle(String tabTitle) {
		Set<String> allWinDowIDs = driver.getWindowHandles();
		for (String id : allWinDowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(tabTitle)) {
				break;
			}
		}
	}
	
	public void closeAllWindowsWithoutParent(String partentID) {
		Set<String> allWinDowIDs = driver.getWindowHandles();
		for (String id : allWinDowIDs) {
			if (!id.equals(partentID)) {
				driver.switchTo().window(id);
				driver.close(); 
			}
			driver.switchTo().window(partentID);
		}
	}
	
	public By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	 
	public WebElement getElement(String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}
	
	public List<WebElement> getElements(String xpathLocator) {
		return driver.findElements(getByXpath(xpathLocator));
	}
	
	public void clickToElement(String xpathLocator, String textValue) {
		WebElement element = getElement(xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}

	public void selectItemDefaultDropdown(String xpathLocator, String textValue) {
		Select select = new Select(getElement(xpathLocator));
		select.selectByValue(textValue);
	}
	
	public String getSelectItemDefaultDropdown(String xpathLocator) {
		Select select = new Select(getElement(xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(String xpathLocator) {
		Select select = new Select(getElement(xpathLocator));
		return select.isMultiple();
	} 
	
	public void selectItemInCustomDropdown(String parentLocator, String childItemLocator, String expectedItem) {
		getElement(parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver,timeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	
	public void sleepInSecond(long time) {
		 try {
			 Thread.sleep(time*1000  );
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(String xpathLocator) {
		return getElements(xpathLocator).size();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

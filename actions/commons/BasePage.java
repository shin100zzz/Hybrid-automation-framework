package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);
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
	
	public List<WebElement> getListElements(String xpathLocator) {
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
	
	public void selectItemInCustomDropdown(String parentxpathLocator, String childItemxpathLocator, String expectedItem) {
		getElement(parentxpathLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, timeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemxpathLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				
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
		return getListElements(xpathLocator).size();
	}
	
	public void checkToDefaultCheckboxRadio(String xpathLocator) {
		WebElement element = getElement(xpathLocator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckboxRadio(String xpathLocator) {
		WebElement element = getElement(xpathLocator);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(String xpathLocator) {
		return getElement(xpathLocator).isDisplayed();
	}
	
	public boolean isElementSelected(String xpathLocator) {
		return getElement(xpathLocator).isSelected();
	}
	
	public boolean isElementEnabled(String xpathLocator) {
		return getElement(xpathLocator).isEnabled();
	}
	
	public void swtichToFrameIframe(String xpathLocator) {
		driver.switchTo().frame(getElement(xpathLocator));
	}
	
	public void swtichToDefaultContent(String xpathLocator) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(xpathLocator)).perform();
	}

	public void scrollToBottomPage() {	
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(String xpathLocator) {
		WebElement element = getElement( xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(String xpathLocator) {
		jsExecutor.executeScript("arguments[0].click();", getElement( xpathLocator));
	}

	public void scrollToElement(String xpathLocator) {	
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement( xpathLocator));
	}

	public void removeAttributeInDOM(String xpathLocator, String attributeRemove) {	
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement( xpathLocator));
	}

	public boolean areJQueryAndJSLoadedSuccess() {
		explicitWait = new WebDriverWait(driver, timeout);
		

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(String xpathLocator) {		
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement( xpathLocator));
	}

	public boolean isImageLoaded(String xpathLocator) {
		
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement( xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitForElementVisible(String xpathLocator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	public void waitForAllElementVisible(String xpathLocator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	
	public void waitForElementInVisible(String xpathLocator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	public void waitForAllElementInVisible(String xpathLocator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElements(xpathLocator)));
	}
	
	public void waitForElementClickable(String xpathLocator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	
	
	
	
	
	
}

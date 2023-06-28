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
	WebElement element;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);
	private long timeout =30;
	
	public static BasePage getWebUIObject() {
		return new BasePage();
	}
	
	public void openAnyUrl(WebDriver driver,String url) {
		driver.get(url);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver){
		driver.navigate().forward(); 
	}
	
	public void refreshCurrentPage(WebDriver driver){
		driver.navigate().refresh(); 
	}
	
	public Alert waitForAlertPresence (WebDriver driver){
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver){
		Alert alert = waitForAlertPresence(driver);
		alert.accept();
	}
	
	public void cancelAlert(WebDriver driver){
		waitForAlertPresence(driver).dismiss();		
	}
	
	public String getTextAlert(WebDriver driver){
		return waitForAlertPresence(driver).getText();		
	}
	
	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}
	
	public void switchToWindowByID(WebDriver driver, String winDowID) {
		Set<String> allWinDowIDs = driver.getWindowHandles();
		for (String id : allWinDowIDs) {
			if (!id.equals(winDowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver, String tabTitle) {
		Set<String> allWinDowIDs = driver.getWindowHandles();
		for (String id : allWinDowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(tabTitle)) {
				break;
			}
		}
	}
	
	public void closeAllWindowsWithoutParent(WebDriver driver, String partentID) {
		Set<String> allWinDowIDs = driver.getWindowHandles();
		for (String id : allWinDowIDs) {
			if (!id.equals(partentID)) {
				driver.switchTo().window(id);
				driver.close(); 
			}
			driver.switchTo().window(partentID);
		}
	}
	
	private By getByXpath(WebDriver driver, String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	 
	private WebElement getElement(WebDriver driver,String xpathLocator) {
		return driver.findElement(getByXpath(driver,xpathLocator));
	}
	
	private List<WebElement> getListElements(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXpath(driver,xpathLocator));
	}
	
	public void clickToElement(WebDriver driver,String xpathLocator) {
		driver.findElement(getByXpath(driver, xpathLocator)).click();
	}

	public void sendkeyToElement(WebDriver driver, String xpathLocator,String textValue) {
		element = driver.findElement(getByXpath(driver, xpathLocator));
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void selectItemDefaultDropdown(WebDriver driver, String xpathLocator, String textValue) {
		Select select = new Select(getElement(driver,xpathLocator));
		select.selectByValue(textValue);
	}
	
	public String getSelectItemDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getElement(driver,xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getElement(driver,xpathLocator));
		return select.isMultiple();
	} 
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentxpathLocator, String childItemxpathLocator, String expectedItem, long timeout) {
		getElement(driver,parentxpathLocator).click();
		delay(1);

		explicitWait = new WebDriverWait(driver, timeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(driver,childItemxpathLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				delay(1);

				item.click();
				delay(1);
				break;
			}
		}
	}
	
	public void delay(long time) {
		 try {
			 Thread.sleep(time*1000  );
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getHexaColorFromRGBA(WebDriver driver, String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(WebDriver driver, String xpathLocator) {
		return getListElements(driver,xpathLocator).size();
	}
	
	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getElement(driver,xpathLocator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		element = getElement(driver,xpathLocator);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		return getElement(driver,xpathLocator).isDisplayed();
	}
	
	public boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getElement(driver,xpathLocator).isSelected();
	}
	
	public boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return getElement(driver,xpathLocator).isEnabled();
	}
	
	public void swtichToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getElement(driver,xpathLocator));
	}
	
	public void swtichToDefaultContent(WebDriver driver, String xpathLocator) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver,xpathLocator)).perform();
	}

	public void scrollToBottomPage() {	
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String xpathLocator) {
		WebElement element = getElement(driver,xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		delay(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(driver,xpathLocator));
	}

	public void scrollToElement(WebDriver driver, String xpathLocator) {	
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {	
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, xpathLocator));
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

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {		
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitForElementVisible(WebDriver driver, String xpathLocator, long timeout) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(driver,xpathLocator)));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String xpathLocator, long timeout) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(driver,xpathLocator)));
	}
	
	public void waitForElementInVisible(WebDriver driver, String xpathLocator, long timeout) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(driver,xpathLocator)));
	}
	
	public void waitForAllElementInVisible(WebDriver driver, String xpathLocator, long timeout) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver,xpathLocator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String xpathLocator, long timeout) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(driver,xpathLocator)));
	}
	
	
	
	
	
	
}

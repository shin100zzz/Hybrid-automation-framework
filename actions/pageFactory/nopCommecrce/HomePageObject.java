package pageFactory.nopCommecrce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory{
	// Biến global
	private WebDriver driver;

	// Hàm khởi tạo cùng tên với clas ko có kiểu trả về.
	// Khi khở tạo 1 đối tượng của class đó thì hàm khởi tạo sẽ được gọi đầu tiên
	// Hàm này được gọi tên là Constructor
	public HomePageObject(WebDriver driver) {
		// Biến local
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using = "")
	private WebElement registerLink;
	
	@FindBy(xpath = "")
	private WebElement loginLink;
	
	@FindBy(css = "")
	private WebElement myAccount;
	
	// Page Object/ Action
	public void clickToRegisterLink() {
		waitForElementClickable(driver,loginLink);
		clickToElement(driver, loginLink);
	}

	public void clickTologinLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, myAccount);
		return isElementDisplayed(driver, myAccount);
		}

	
}
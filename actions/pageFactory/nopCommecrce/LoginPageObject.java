package pageFactory.nopCommecrce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory{
	
	// Biến global
	private WebDriver driver;

	// Hàm khởi tạo cùng tên với clas ko có kiểu trả về.
	// Khi khở tạo 1 đối tượng của class đó thì hàm khởi tạo sẽ được gọi đầu tiên		
	// Hàm này được gọi tên là Constructor
	public LoginPageObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "")
	private WebElement loginButton;
	
	@FindBy(id = "")
	private WebElement emailAdrress;
	
	@FindBy(id = "")
	private WebElement passWord;
	
	@FindBy(id = "")
	private WebElement emailErrorMessage;
	
	@FindBy(id = "")
	private WebElement loginErrorMessage;
	
	@FindBy(id = "")
	private WebElement reErrorMessage;
	
	public void clickToLoginButton() {
		waitForElementInVisible(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementClickable(driver,emailAdrress);
		sendkeyToElement(driver,emailAdrress,email);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementClickable(driver,passWord);
		sendkeyToElement(driver,passWord,password);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,loginErrorMessage);
		return getElementText(driver,loginErrorMessage);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver,reErrorMessage);
		return getElementText(driver,reErrorMessage);
	}

	public String RetErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,reErrorMessage);
		return getElementText(driver,reErrorMessage);
	}


}

package pageFactory.nopCommecrce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUI.nopCommerce.user.RegisterPageUI_Nop;

public class RegisterPageObject extends BasePageFactory {
	// Biến global
	private WebDriver driver;

	// Hàm khởi tạo cùng tên với clas ko có kiểu trả về.
	// Khi khở tạo 1 đối tượng của class đó thì hàm khởi tạo sẽ được gọi đầu tiên		
	// Hàm này được gọi tên là Constructor
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "")
	private WebElement firstNameXpath;
	
	@FindBy(id = "")
	private WebElement lastNameXpath;

	@FindBy(id = "")
	private WebElement existingEmailXpath;
	
	@FindBy(id = "")
	private WebElement passwordXpath;
	
	@FindBy(id = "")
	private WebElement confirmPasswordXpath;
	
	@FindBy(id = "")
	private WebElement registerButton;
	
	@FindBy(id = "")
	private WebElement registerResultMessage;
	
	@FindBy(id = "")
	private WebElement logoutButton;
	
	@FindBy(id = "")
	private WebElement firstNameError;
	
	@FindBy(id = "")
	private WebElement lastNameError;

	@FindBy(id = "")
	private WebElement existingEmailError;
	
	@FindBy(id = "")
	private WebElement passwordError;
	
	@FindBy(id = "")
	private WebElement confirmPasswordError;
	
	public void inputTofirstnameTextbox(String firstName) {
		waitForElementClickable(driver,firstNameXpath);
		sendkeyToElement(driver,firstNameXpath,firstName);
	}
	
	public void inputTolastnameTextbo(String lastName) {
		waitForElementClickable(driver,lastNameXpath);
		sendkeyToElement(driver,lastName,lastName);
	}
	
	public void inputToEmailTextbox(String existingEmail) {
		waitForElementClickable(driver,existingEmailXpath);
		sendkeyToElement(driver,existingEmailXpath,existingEmail);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver,passwordXpath);
		sendkeyToElement(driver,passwordXpath,password);
	}
	
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementClickable(driver,confirmPasswordXpath);
		sendkeyToElement(driver,confirmPasswordXpath,confirmPassword);
	}
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver,registerButton);
		clickToElement(driver,registerButton);
	}
	
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver,registerResultMessage);
		return getElementText(driver,registerResultMessage);
	}
	
	public void clickTologoutLink() {
		waitForElementClickable(driver,logoutButton);
		clickToElement(driver,logoutButton);
	}
	
	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver,firstNameError);
		return getElementText(driver,firstNameError);
	}
	
	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver,lastNameError);
		return getElementText(driver,lastNameError);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,existingEmailError);
		return getElementText(driver,existingEmailError);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver,passwordError );
		return getElementText(driver,passwordError);
	}
	
	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver,confirmPasswordError);
		return getElementText(driver,confirmPasswordError);
	}

	public String getErrorMessageAtEmailExistTextbox() {
		waitForElementVisible(driver,existingEmailError);
		return getElementText(driver,existingEmailError);
	}

}
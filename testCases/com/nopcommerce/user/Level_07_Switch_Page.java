package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;

import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	String firstName,lastName,emailAddress,validPassword;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {	
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getUserHomePageOfnopCommerce(driver);
	
	firstName ="Automation";
	lastName = "FC";
	emailAddress ="afc" + generateFakeNumber() + "@gmail.com.vn";
	validPassword ="123456";
	}
	
	@Test
	public void User_01_Register() {
		System.out.println("Pre-Condition - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		System.out.println("Pre-Condition - Step 02: Input to required fields"); 
		registerPage.inputTofirstnameTextbox(firstName); 
		registerPage.inputTolastnameTextbo(lastName); 
		registerPage.inputToEmailTextbox(emailAddress); 
		registerPage.inputToPasswordTextbox(validPassword); 
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		System.out.println("Pre-Condition - Step 03: Click to Register button"); 
		registerPage.clickToRegisterButton();
		
		System.out.println("Pre-Condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Pre-Condition - Step 05: Click to Logout link");
		homePage = registerPage.clickTologoutLink();
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.clickTologinLink();
		loginPage.clickToLoginButton();
		
		loginPage = homePage.clickTologinLink();
		
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(validPassword);
	}

	@Test
	public void User_03_Login_Customer_Infor() {
		customerInforPage = homePage.openMyAccount();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	} 

	@Test
	public void User_04_Switch_Page() {
	// Knowledge của Page Object:
	// Một page A khi chuyển qua page B thì phái viết 1 hàm 
	// (action: open/ click/..: link/ button/ image/..) để mở page B đó lên
	
	// Customer Infor -> Address
	addressPage = customerInforPage.openAddressPage(driver);
	// Address -> My Product Review
	myProductReviewPage = addressPage.openMyProductReviewPage(driver);
	// My Product Review -> Reward Point
	rewardPointPage = myProductReviewPage.openRewardPoint(driver);
	// Reward Point -> Address
	addressPage = rewardPointPage.openAddressPage(driver);
	// Address -> Reward Point
	rewardPointPage = addressPage.openRewardPoint(driver);
	// Reward Point -> My Product Review
	myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
	// My Product Review -> Address
	addressPage = myProductReviewPage.openAddressPage(driver);
	customerInforPage = addressPage.openCustomerInforPage(driver);
	myProductReviewPage = customerInforPage.openMyProductReviewPage(driver);
	
	}
	@Test
	public void User_05_Switch_Role() {
	// Role User -> Role Admin
	}
	
	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
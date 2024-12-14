package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalVariable;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	
	String userEmailAddress,userPassword,adminEmailAddress,adminPassword;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	userHomePage = PageGeneratorManager.getUserHomePageOfnopCommerce(driver);
	
	userEmailAddress = "nghia12344321@gmail.com";
	userPassword = "123456";
	adminEmailAddress ="admin@yourstore.com"; 
	adminPassword = "admin";
	
	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();
		
		// Login as User role
		userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
		// Home page -> Customer infor
		userCustomerInforPage = userHomePage.openMyAccount();
		
		// Customer infor > Click logout -> Home page
		userHomePage = userCustomerInforPage.clickToLogoutLinkUserPage(driver);
		
		// User home page -> Open Admin page
		userHomePage.openAnyUrl(driver,GlobalVariable.ADMIN_DEV_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPageOfnopCommerce(driver);
		
		// Login as Admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
		
		// Dashboard page -> Click Logout -> Login Page Admin
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAdminPage(driver);
	}
	
	@Test
	public void Role_Admin_To_User() {
		// Login Page Admin -> Open User url -> Home
		adminLoginPage.openAnyUrl(driver, GlobalVariable.PORTAL_DEV_URL);
		userHomePage = PageGeneratorManager.getUserHomePageOfnopCommerce(driver);
		
		// Home page -> Login page user
		userLoginPage = userHomePage.openLoginPage();
		 
		// Login as User role
		userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}


	@AfterClass
	public void afterClass() {
 
	}
}
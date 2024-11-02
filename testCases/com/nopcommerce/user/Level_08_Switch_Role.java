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
import pageObjects.nopCommerce.admin.NopCommerce_Admin_DashboardPageObject;
import pageObjects.nopCommerce.admin.NopCommerce_Admin_LoginPageObject;
import pageObjects.nopCommerce.user.NopCommerce_User_HomePageObject;
import pageObjects.nopCommerce.user.NopCommerce_User_LoginPageObject;

public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	
	private NopCommerce_User_HomePageObject userHomePage;
	private NopCommerce_User_LoginPageObject loginPage;
	private NopCommerce_Admin_LoginPageObject adminLoginPage;
	private NopCommerce_Admin_DashboardPageObject adminDashboardPage;
	String userEmailAddress,userPassword,adminEmailAddress,adminPassword;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	userHomePage = PageGeneratorManager.getUserHomePageOfnopCommerce(driver);
	
	userEmailAddress = "nghia12344321@gmail.com";
	userPassword = "123456";
	adminEmailAddress =""; 
	adminPassword = "";
	}

	@Test
	public void Role_01_User_To_Admin() {
		loginPage = userHomePage.openLoginPage();
		
		// Login as User role
		loginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
		userHomePage.openMyAccount();
		
		userHomePage.openAnyUrl(driver,GlobalVariable.ADMIN_DEV_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		// Login as Admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
	}


	@AfterClass
	public void afterClass() {
 
	}
}
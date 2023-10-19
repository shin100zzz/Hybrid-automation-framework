package com.jquery;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

public class DataTable_DataGrid extends BaseTest {
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browser, String url) {
	  driver = getBrowserDriver(browser, url);
	  homePage = PageGeneratorManager.getHomePage(driver);
	}
  
	@Test
	public void Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();
		delay(2);
		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "1", "Shindy");
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "2", "Shindy Nuls");
		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "3", "12");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "4", "Japan");
		homePage.checkToCheckBoxByColumnNameAtRowNumber("NPO?", "2");
		homePage.uncheckToCheckBoxByColumnNameAtRowNumber("NPO?", "1");
		
		homePage.clickToIconByRowNumber("8", "Remove Current Row");
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

	private WebDriver driver;

}

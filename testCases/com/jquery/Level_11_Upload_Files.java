package com.jquery;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Upload_Files extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;

	String sharpfileName = "CSharp.png";
	String javafileName = "Java.png";
	String pythonFileName = "Python.png";
	String rubyFileName = "Ruby.png";
	String[] multipleFileNames= {sharpfileName, javafileName, pythonFileName, rubyFileName};

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = getBrowserDriver(browser, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC01_upload_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, sharpfileName);
		Assert.assertTrue(homePage.isFileLoadedByName(sharpfileName));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUploadedByName(sharpfileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(sharpfileName));
	}

	@Test
	public void TC02_upload_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);
		
		homePage.uploadMultipleFiles(driver, multipleFileNames);
		
		Assert.assertTrue(homePage.isFileLoadedByName(sharpfileName));
		Assert.assertTrue(homePage.isFileLoadedByName(javafileName));
		Assert.assertTrue(homePage.isFileLoadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(rubyFileName));
		
		homePage.clickToStartButton();
		
		Assert.assertTrue(homePage.isFileLinkUploadedByName(sharpfileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(javafileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(rubyFileName));
		
		Assert.assertTrue(homePage.isFileImageUploadedByName(sharpfileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(javafileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(rubyFileName));
	}
	
	@AfterClass
	public void afterClass() {
		
	}

}

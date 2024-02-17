package pageObjects.jQuery.dataTable;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerjQueryDataTable {

	public static Jquery_DataTable_HomePageObject getHomePage(WebDriver driver) {
		return new Jquery_DataTable_HomePageObject(driver);
	}
	
}

package pageObjects.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject (WebDriver driver) {
		this.driver = driver;
	}
	
	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAl_PAGINATION);
		System.out.println("Total size = " + totalPage);
		
		List<String> allRowValueAllPage = new ArrayList<String>();
		
		for (int index = 1; index < totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			
			List<WebElement> allRowElementEachPage = getListElements(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
			allRowValueAllPage.add(eachRow.getText());
			}
		}
		return allRowValueAllPage;
	}
	
	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1 ;
		System.out.println(columnIndex);
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf (columnIndex)); 
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf (columnIndex));
	}
	
	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		System.out.println(columnIndex);
		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf (columnIndex));
		selectItemDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf (columnIndex));
	}
	
	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);
	}
	
	public void checkToCheckBoxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		System.out.println(columnIndex);
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf (columnIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf (columnIndex));
	}

	public void uncheckToCheckBoxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		System.out.println(columnIndex);
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf (columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf (columnIndex));
	}
	
	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
	}
}
  
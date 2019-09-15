package com.mirshad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mirshad.core.PageBase;

public class GoogleHomePage extends PageBase {
	
public GoogleHomePage(WebDriver _driver) {
		super(_driver);
		
	}

@FindBy(name="q")
private WebElement txtboxSearch;

@FindBy(name="btnK")
private WebElement buttonSearch;

public void enterSearchText(String text) {
	txtboxSearch.clear();
	txtboxSearch.sendKeys(text);
}

public void clickSearch() {
	buttonSearch.click();
}

public GoogleResultsPage searchGoogle(String text) {
	enterSearchText(text);
	clickSearch();
	return new GoogleResultsPage(driver);
}
}

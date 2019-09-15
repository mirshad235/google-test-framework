package com.mirshad.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mirshad.core.PageBase;

public class GoogleResultsPage extends PageBase{
	
	
	
	@FindBy(className="bkWMgd")
	private List<WebElement> resultsBlocks;

	@FindBy(className="TbwUpd")
	private List<WebElement> resultsLink;
	
	@FindBy(className="LC20lb")
	private List<WebElement> resultsNames;
	
	
	public GoogleResultsPage(WebDriver _driver) {
		super(_driver);
		
	}
	
	public GoogleLandingPage selectResult(int index) {
		
		if(index == 1) 
			resultsBlocks.get(0).findElements(By.className("TbwUpd")).get(0).click();
		else 
			resultsBlocks.get(2).findElements(By.className("TbwUpd")).get(index-2).click();
	
		return new GoogleLandingPage(driver);
	}
	
	public String getSiteName(int index) {
		String sitename;
		if(index == 1) 
			sitename = resultsBlocks.get(0).findElements(By.className("LC20lb")).get(0).getText();
		else
			sitename = resultsBlocks.get(2).findElements(By.className("LC20lb")).get(index-2).getText();
			
	    return sitename;
	}
	
	public int getNumberofResultsBlocks() {
		return resultsBlocks.size();
	}
	
	
	

}

package com.mirshad.pages;

import java.util.Iterator;
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
		// Time to time google results block structure changed (Ex: some times 'People also ask' sections appears etc.
	   // This solution is given to overcome all these changes and click the given result irrespective of the structure changes.
		int count = 0; 
		resultsblockloop:for (Iterator<WebElement> iterator = resultsBlocks.iterator(); iterator.hasNext();) {
				WebElement webElement = (WebElement) iterator.next();
				List<WebElement> innereles = webElement.findElements(By.className("LC20lb"));
				
				for (Iterator<WebElement> iterator2 = innereles.iterator(); iterator2.hasNext();) {
					WebElement innerwebElement = (WebElement) iterator2.next();
					if(!innerwebElement.getText().isEmpty()) count ++;
					if(index == count) {
						innerwebElement.click();
						break resultsblockloop;
					}
				}
				
		}
	
		return new GoogleLandingPage(driver);
	}
	
	public String getSiteName(int index) {
		
		// Time to time google results block structure changed (Ex: some times 'People also ask' sections appears etc.
		// This solution is given to overcome all these changes and click the given result block irrespective of the structure changes.
		
		
		String sitename;
		int count = 0; 
		for (Iterator<WebElement> iterator = resultsBlocks.iterator(); iterator.hasNext();) {
				WebElement webElement = (WebElement) iterator.next();
				List<WebElement> innereles = webElement.findElements(By.className("LC20lb"));
				
				for (Iterator<WebElement> iterator2 = innereles.iterator(); iterator2.hasNext();) {
					WebElement innerwebElement = (WebElement) iterator2.next();
					sitename = innerwebElement.getText();
					System.out.println(sitename);
					if(!sitename.isEmpty()) count ++;
					if(index == count) return sitename;
				}
				
		}
		return "N/A";
	}
	
	public int getNumberofResultsBlocks() {
		return resultsBlocks.size();
	}
	
	
	

}

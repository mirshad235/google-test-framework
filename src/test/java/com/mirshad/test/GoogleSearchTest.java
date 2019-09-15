package com.mirshad.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mirshad.core.TestBase;
import com.mirshad.pages.GoogleHomePage;
import com.mirshad.pages.GoogleLandingPage;
import com.mirshad.pages.GoogleResultsPage;

public class GoogleSearchTest extends TestBase {
	
private GoogleHomePage home;	
private GoogleResultsPage results;	
private GoogleLandingPage landing;	
	
@Test
	public void checkGoogleAvailability() {
		home = new GoogleHomePage(driver);
		Assert.assertEquals(home.getPageTitle().trim(), "Google","Home Page Availability");
	}
	
	@Test
	public void checkGoogleSearch() {
		results = home.searchGoogle("SQL");
		Assert.assertTrue(results.getNumberofResultsBlocks() > 0 , "Results Availability");
		
	} 
	
	
	@Test
	public void checkGoogleResult() {
		//Getting the site name in the 2nd result - for later verification
		String site_name = results.getSiteName(2);
		//Click on the second result ( Any result can be clicked - just need to pass the parameter 
		landing = results.selectResult(2);
		Assert.assertEquals(landing.getPageTitle().trim(),site_name);
	}

}

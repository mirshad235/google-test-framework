package com.mirshad.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mirshad.util.DriverManager;

public class TestBase {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = DriverManager.getDriver();
	}
	
	
	
	@AfterClass
	
	public void tearDown() {
		if(null != driver)
			driver.quit();
	}

}

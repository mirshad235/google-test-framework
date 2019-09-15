package com.mirshad.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

private static  WebDriver driver ;

public static WebDriver getDriver(){
	
	if (null == driver) {
		createDriver();
	}
	
	return driver;
	
}

private static void createDriver(){
	String driver_type = Config.getConfig("driver.type");
	String base_url = Config.getConfig("base.url");
	
	
	switch (driver_type) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
		
    case "firefox":
    	WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
    case "chrome-headless":
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
		break;

	default:
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
	}
	
	driver.get(base_url);
}


}

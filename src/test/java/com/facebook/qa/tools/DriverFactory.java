package com.facebook.qa.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public enum BrowserType {
		FIREFOX,
		CHROME
	}
	
	public static WebDriver getWebDriver(String type){
		WebDriver driver = null;
		
		switch(type){
			case "FIREFOX":
				driver = new FirefoxDriver();
				break;
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", 
						"src/test/java/resources/chromedriver.exe");
				driver = new ChromeDriver();
				break;
		}
		return driver;
	}
}

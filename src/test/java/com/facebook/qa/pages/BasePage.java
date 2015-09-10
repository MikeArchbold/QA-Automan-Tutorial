package com.facebook.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BasePage {
	
	WebDriver driver;
	String url;
	String title;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void loadPage(){
		driver.get(url);
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	public void click(WebElement element){
		element.click();
	}
	
	public void setText(WebElement element, String text){
		element.clear();
		element.sendKeys(text);
		Assert.assertEquals(element.getAttribute("value"), text);
	}
}

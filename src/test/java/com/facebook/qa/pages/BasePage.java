package com.facebook.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage {
	
	WebDriver driver;
	String url;
	String title;
	
	HashMap<String, WebElement> map;
	
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
		element.click();
		element.clear();
		element.sendKeys(text);
		Assert.assertEquals(element.getAttribute("value"), text);
	}
	
	public void selectInDropdown(WebElement element, String value){
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public String getURL(){
		return url;
	}
	
	public String getTitle(){
		return title;
	}
}

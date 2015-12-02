package com.facebook.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

	String url;
	String title;

	WebDriver driver;
	WebDriverWait wait;
	
	HashMap<String, WebElement> map;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	protected void assertText(WebElement element, String text){
		Assert.assertEquals(element.getText(), text);
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
	
	public void clearText(WebElement element){
		element.clear();
		System.out.print("clearText\n");
		System.out.println("this is stupid" + element.getAttribute("value"));
		if (!(element.getAttribute("value") == null) && 
				!element.getAttribute("value").equals(""))
			Assert.fail(element.getTagName() + " text field not cleared!");
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

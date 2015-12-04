package com.facebook.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {

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
	
	public void waitUntilVisible(WebElement element){
		WebElement waitElement = wait.until(
		        ExpectedConditions.visibilityOf(element));
		waitElement.isDisplayed();
		try{
			Thread.sleep(3000);
		} catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
	
	public void click(WebElement element){
		element.click();
	}
	
	public void setText(WebElement element, String text){
		element.click();
		element.clear();
		element.sendKeys(text);
		
		String textInElement;
		if (element.getAttribute("value") == null){
			textInElement = element.getText();
		} else{
			textInElement = element.getAttribute("value");
		}
		
		Assert.assertEquals(textInElement.replaceAll("\\s+",""),
				text.replaceAll("\\s+",""));
	}
	
	public void clearText(WebElement element){
		element.clear();
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

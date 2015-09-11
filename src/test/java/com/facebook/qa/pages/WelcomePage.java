package com.facebook.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage{
	
	@FindBy(xpath=".//*[@class='rfloat _ohf']/h2") WebElement headerTitle;
	
	public WelcomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getUsernameText(){
		return headerTitle.getText();
	}
}

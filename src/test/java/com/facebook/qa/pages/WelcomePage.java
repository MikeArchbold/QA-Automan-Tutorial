package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage {
	
	@FindBy(xpath=".//*[@class='rfloat _ohf']/h2") WebElement headerTitle;
	
	public String getUsernameText(){
		return headerTitle.getText();
	}
}

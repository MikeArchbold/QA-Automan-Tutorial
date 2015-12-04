package com.facebook.qa.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	@FindBy(css=".uiContextualLayer.uiContextualLayerRight > div > div > div > a") WebElement errorBox;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.url = "https://www.facebook.com/login.php";
		this.title = "Log into Facebook | Facebook";
	}
	
	public boolean checkErrorHeader(String text){
		try{
			return errorBox.getText().equals(text);
		}
		catch(NoSuchElementException ex){
			return false;
		}
	}
}

package com.facebook.qa.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	public static final String URL = "https://www.facebook.com/login.php";
	public static final String TITLE = "Log into Facebook | Facebook";
	
	@FindBy(css=".pam.login_error_box.uiBoxRed>div:first-child") WebElement errorBox;
	
	public boolean checkErrorHeader(String text){
		try{
			return errorBox.getText().equals(text);
		}
		catch(NoSuchElementException ex){
			return false;
		}
	}
}

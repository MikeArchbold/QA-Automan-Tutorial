package com.facebook.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

//tutorial 6
public class FacebookMainPage {
	
	public static final String URL = "https://www.facebook.com/";
	public static final String TITLE = "Facebook - Log In or Sign Up";
	
	@FindBy(id="email") WebElement field_EmailLogin;
	@FindBy(id="pass") WebElement field_PasswordLogin;
	@FindBy(id="u_0_x") WebElement button_LogIn;
	
	WebDriver driver;
	
	public FacebookMainPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void setText_EmailField(String username){
		field_EmailLogin.sendKeys(username);
		Assert.assertEquals(username, field_EmailLogin.getAttribute("value"));
	}
	
	public void setText_PasswordField(String password){
		field_PasswordLogin.sendKeys(password);
		Assert.assertEquals(password, field_PasswordLogin.getAttribute("value"));
	}
	
	public void clickLoginMain(){
		button_LogIn.click();
	}
}

package com.facebook.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

//tutorial 6
public class FacebookMainPage extends BasePage{
	
	HashMap<String, Integer> date;
	
	@FindBy(id="email") WebElement field_EmailLogin;
	@FindBy(id="pass") WebElement field_PasswordLogin;
	@FindBy(xpath=".//*[@name='firstname']") WebElement field_FirstName;
	@FindBy(xpath=".//*[@name='lastname']") WebElement field_LastName;
	@FindBy(xpath=".//*[@name='reg_email__']") WebElement field_EmailSignUp;
	@FindBy(xpath=".//*[@name='reg_email_confirmation__']") WebElement field_ReenterEmail;
	@FindBy(xpath=".//*[@name='reg_passwd__']") WebElement field_PasswordSignUp;
	
	@FindBy(id="month") WebElement dropdown_Month;
	@FindBy(id="day") WebElement dropdown_Day;
	@FindBy(id="year") WebElement dropdown_Year;
	
	@FindBy(css="#loginbutton") WebElement button_LogIn;
	
	public FacebookMainPage(WebDriver driver){
		super(driver);
		this.url = "https://www.facebook.com/";
		this.title = "Facebook - Log In or Sign Up";
		
		date = new HashMap<String, Integer>();
	}
	
	public void login(String email, String password){
		wait.until(ExpectedConditions.elementToBeClickable(field_EmailLogin));
		setText_EmailLogin(email);
		setText_PasswordLogin(password);
		clickLoginMain();	
	}
	
	public void setText_EmailLogin(String username){
		setText(field_EmailLogin, username);
	}
	
	public void setText_PasswordLogin(String password){
		setText(field_PasswordLogin, password);
	}
	
	public void clickLoginMain(){
		click(button_LogIn);
	}
	
	public void setText_FirstName(String fName){
		setText(field_FirstName, fName);
	}
	
	public void setText_LastName(String lName){
		setText(field_LastName, lName);
	}
	
	public void setText_EmailSignUp(String email){
		setText(field_EmailSignUp, email);
		setText(field_ReenterEmail, email);
	}
	
	public void setText_PasswordSignUp(String password){
		setText(field_PasswordSignUp, password);
	}
	
	public void dropdown_Bday(String month, String day, String year){
		selectInDropdown(dropdown_Month, month);
		selectInDropdown(dropdown_Day, day);
		selectInDropdown(dropdown_Year, year);
	}
}

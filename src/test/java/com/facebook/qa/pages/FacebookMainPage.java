package com.facebook.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//tutorial 6
public class FacebookMainPage extends BasePage{
	
	public static final String URL = "https://www.facebook.com/";
	public static final String TITLE = "Facebook - Log In or Sign Up";
	
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
	
	@FindBy(id="u_0_x") WebElement button_LogIn;
	
	public FacebookMainPage(WebDriver driver){
		super(driver);
		this.url = "https://www.facebook.com/";
		this.title = "Facebook - Log In or Sign Up";
		
		date = new HashMap<String, Integer>();
		
		//may want to put these in xml
		date.put("9", 9);
		date.put("10", 9);
		date.put("1999", 1999);
	}
	
	public void setText_EmailField(String username){
		field_EmailLogin.sendKeys(username);
		Assert.assertEquals(field_EmailLogin.getAttribute("value"), username);
	}
	
	public void setText_PasswordField(String password){
		field_PasswordLogin.sendKeys(password);
		Assert.assertEquals(field_PasswordLogin.getAttribute("value"), password);
	}
	
	public void clickLoginMain(){
		button_LogIn.click();
	}
	
	public void setText_FirstName(String fName){
		field_FirstName.click();
		field_FirstName.sendKeys(fName);
		Assert.assertEquals(field_FirstName.getAttribute("value"), fName);
	}
	
	public void setText_LastName(String lName){
		field_LastName.click();
		field_LastName.sendKeys(lName);
		Assert.assertEquals(field_LastName.getAttribute("value"), lName);
	}
	
	public void setText_EmailSignUp(String email){
		field_EmailSignUp.click();
		field_EmailSignUp.sendKeys("hi");
		//field_ReenterEmail.click();
		field_ReenterEmail.sendKeys("hey");
		//Assert.assertEquals(field_EmailSignUp.getAttribute("value"), email);
	}
	
	public void setText_PasswordSignUp(String password){
		field_PasswordSignUp.click();
		field_PasswordSignUp.sendKeys(password);
		Assert.assertEquals(field_PasswordSignUp.getAttribute("value"), password);
	}
	
	public void dropdown_Bday(String month, String day, String year){
		HashMap<String, WebElement> dateDropDowns = new HashMap<String, WebElement>();
		dateDropDowns.put(month, dropdown_Month);
		dateDropDowns.put(day, dropdown_Day);
		dateDropDowns.put(year, dropdown_Year);

		for(HashMap.Entry<String, WebElement> e : dateDropDowns.entrySet()){
			//e.getValue().click();
			System.out.println("Key: " + e.getKey());
			System.out.println("Value: " + e.getValue());
			Select select = new Select(e.getValue());
			select.selectByValue(e.getKey());
		}
	}
}

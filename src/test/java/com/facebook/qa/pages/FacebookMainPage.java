package com.facebook.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		setText(field_EmailLogin, username);
	}
	
	public void setText_PasswordField(String password){
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
		/*HashMap<String, WebElement> dateDropDowns = new HashMap<String, WebElement>();
		dateDropDowns.put(month, dropdown_Month);
		dateDropDowns.put(day, dropdown_Day);
		dateDropDowns.put(year, dropdown_Year);

		for(HashMap.Entry<String, WebElement> e : dateDropDowns.entrySet()){
			Select select = new Select(e.getValue());
			select.selectByValue(e.getKey());
		}*/
	}
}

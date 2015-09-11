package com.facebook.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.facebook.qa.pages.FacebookMainPage;

public class SignUpTest {

	WebDriver driver;
	FacebookMainPage fbMainPage;
	
	@BeforeClass(alwaysRun=true)
	public void setup(){
		driver = new FirefoxDriver();
		fbMainPage = PageFactory.initElements(driver, 
				FacebookMainPage.class);
	}
	
	@AfterClass(alwaysRun=true)
	public void teardown(){
	//	driver.quit();
	}
	
	@Test(groups={"p1"})
	public void mainPageSignUp(){
		fbMainPage.loadPage();
		fbMainPage.setText_EmailSignUp("qa");
		fbMainPage.setText_FirstName("John");
		fbMainPage.setText_LastName("auto");
		fbMainPage.setText_PasswordSignUp("1234");
		fbMainPage.dropdown_Bday("9", "10", "1999");
	}
}

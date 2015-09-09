package com.facebook.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.facebook.qa.data.HomePage;
import com.facebook.qa.pages.FacebookMainPage;
import com.facebook.qa.pages.LoginPage;
import com.facebook.qa.pages.WelcomePage;
import com.facebook.qa.tools.ReadXMLFile;

public class LoginTest {
	
	String[][] users;
	FacebookMainPage fbMainPage;
	LoginPage fbLoginPage;
	WelcomePage fbWelcomePage;
	WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	public void setup(){
		driver = new FirefoxDriver();
		fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
		fbLoginPage = PageFactory.initElements(driver, LoginPage.class);
		fbWelcomePage = PageFactory.initElements(driver, WelcomePage.class);
		users = ReadXMLFile.getUsersXML();
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown(){
		driver.quit();
	}
	
	@Test(groups = {"p1", "pageLoads"})
	// dataProvider="pages", dataProviderClass=HomePage.class)
	public void loadPage(){
		driver.get(FacebookMainPage.URL);
		Assert.assertEquals(driver.getTitle(), FacebookMainPage.TITLE);
	}

	@Test(groups={"p1", "field"}, dependsOnMethods = "loadPage")
	public void fillOutEmailField(){
		String email = "example@gmail.com";
		fbMainPage.setText_EmailField(email);
	}
	
	@Test(groups={"p1", "field"}, dependsOnMethods = "fillOutEmailField")
	public void fillOutPasswordField(){
		String password = "123456";
		fbMainPage.setText_PasswordField(password);
	}
	
	@Test(groups={"p2"}, dataProviderClass=HomePage.class, dataProvider="login") 
	public void testLoginMainPage(String user, String pass, String errorType) {
		driver.manage().deleteAllCookies();
		driver.get(FacebookMainPage.URL);
		Assert.assertEquals(driver.getTitle(), FacebookMainPage.TITLE);
		fbMainPage.setText_EmailField(user);
		fbMainPage.setText_PasswordField(pass);
		fbMainPage.clickLoginMain();
		
		//when all cookies deleted defaults to welcome page
		if (errorType.equals("none")){
			System.out.println(fbWelcomePage.getUsernameText());
			Assert.assertEquals(fbWelcomePage.getUsernameText(), "Welcome to Facebook, John");
		}
		else{
			Assert.assertTrue(fbLoginPage.checkErrorHeader("Please re-enter"
					+ " your password"), "Error expected: "+ errorType);
		}
	}
}
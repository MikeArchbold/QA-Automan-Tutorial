package com.facebook.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
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
	WebDriverWait wait;
	
	@BeforeClass(alwaysRun = true)
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		
		fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
		fbLoginPage = PageFactory.initElements(driver, LoginPage.class);
		fbWelcomePage = PageFactory.initElements(driver, WelcomePage.class);
		users = ReadXMLFile.getUsersXML();
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown(){
		driver.quit();
	}
	
	@Parameters({"browserType"})
	@Test(groups = {"p1", "pageLoads"})
	public void loadPage(@Optional("Firefox") String browserType){
		System.out.println(browserType);
		fbMainPage.loadPage();
	}

	@Test(groups={"p1", "field"}, dependsOnMethods = "loadPage")
	public void fillOutEmailField(){
		String email = "example@gmail.com";
		fbMainPage.setText_EmailLogin(email);
	}
	
	@Test(groups={"p1", "field"}, dependsOnMethods = "fillOutEmailField")
	public void fillOutPasswordField(){
		String password = "123456";
		fbMainPage.setText_PasswordLogin(password);
	}
	
	@Test(groups={"p2"}, dataProviderClass=HomePage.class, dataProvider="login") 
	public void testLoginMainPage(String user, String pass, String errorType) {
		driver.manage().deleteAllCookies();
		fbMainPage.loadPage();
		fbMainPage.login(user, pass);
		
		//when all cookies deleted defaults to welcome page
		if (errorType.equals("none")){
			System.out.println(fbWelcomePage.getUsernameText());
			Assert.assertEquals(fbWelcomePage.getUsernameText(), "John Tester");
		}
		else{
			Assert.assertTrue(fbLoginPage.checkErrorHeader("Please re-enter"
					+ " your password"), "Error expected: "+ errorType);
		}
	}
}
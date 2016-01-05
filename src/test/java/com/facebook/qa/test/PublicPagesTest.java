package com.facebook.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.facebook.qa.data.HomePage;
import com.facebook.qa.pages.FacebookMainPage;
import com.facebook.qa.pages.NewsFeedPage;
import com.facebook.qa.pages.PublicProfilePage;
import com.facebook.qa.pages.WelcomePage;

public class PublicPagesTest{
	
	WebDriver driver;
	FacebookMainPage fbMainPage;
	NewsFeedPage fbNewsFeedPage;
	PublicProfilePage fbPublicPage;
	WelcomePage fbWelcomePage;
	
	@BeforeClass
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
		fbNewsFeedPage = PageFactory.initElements(driver, NewsFeedPage.class);
		fbPublicPage = PageFactory.initElements(driver, PublicProfilePage.class);
		fbWelcomePage = PageFactory.initElements(driver, WelcomePage.class);
	}
	
	@AfterClass
	public void teardown(){
		driver.quit();
	}
	
	@Test(dataProviderClass=HomePage.class, dataProvider="correctLogin")
	public void correctLogin(String email, String password){
		fbMainPage.loadPage();
		fbMainPage.login(email, password);
	}
	
	@Test(dependsOnMethods="correctLogin")
	public void checkLinks(){
		fbNewsFeedPage.search("Jeff Bridges");
		fbPublicPage.openAboutSection();
		String link = fbPublicPage.getLinkURL();
		driver.get(link);
		Assert.assertEquals(driver.getTitle(), "Welcome To Jeff Bridges.com");
	}
}
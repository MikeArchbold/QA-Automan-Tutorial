package com.facebook.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.facebook.qa.data.HomePage;
import com.facebook.qa.pages.FacebookMainPage;
import com.facebook.qa.pages.NewsFeedPage;
import com.facebook.qa.pages.PublicProfilePage;

/*testing GUI functionality of the main feed page*/
public class FeedTest {
	
	WebDriver driver;
	WebDriverWait wait;
	FacebookMainPage fbMainPage;
	NewsFeedPage fbNewsFeed;
	PublicProfilePage fbPublicProfile;
	
	@BeforeClass(alwaysRun = true)
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
		fbNewsFeed = PageFactory.initElements(driver, NewsFeedPage.class);
		fbPublicProfile = PageFactory.initElements(driver, PublicProfilePage.class);
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown(){
		driver.quit();
	}
	
	@Test(dataProviderClass=HomePage.class, dataProvider="correctLogin")
	public void correctLogin(String user, String password){
		fbMainPage.loadPage();
		fbMainPage.login(user, password);
	}
	
	//write a post w/ an emote
	@Test(dependsOnMethods="correctLogin")
	public void cancelPost(){
		fbNewsFeed.editNewsFeedText("Hello");
		fbNewsFeed.openEmotesWindow();
		fbNewsFeed.selectExcitedEmote();
		fbNewsFeed.clearNewsFeedText();
		fbNewsFeed.removeEmotes();
	}
	
	//search for a public page and validate it has been correctly found
	@Test(dependsOnMethods="correctLogin")
	public void findPublicPage(){
		fbNewsFeed.search("Jeff Bridges", wait);
		fbPublicProfile.verifyPageTitle("Jeff Bridges");
	}
}
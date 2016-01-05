package com.facebook.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.pages.FacebookMainPage;

public class Sandbox {

	public static void main(String[] args) throws InterruptedException{
		System.out.println(System.getProperty("java.version"));
		String user = "qa.automan.tutorial@gmail.com";
		String password = "auto1234";
		
		WebDriver driver = new FirefoxDriver();
		FacebookMainPage fbMainPage = new FacebookMainPage(driver);
		fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
		
		fbMainPage.loadPage();
		fbMainPage.login(user, password);
		
		//open chat window, create a new message
		driver.findElement(By.cssSelector("#fbDockChatBuddylistNub > a")).click();
		driver.findElement(By.cssSelector(".clearfix.fbNubFlyoutTitlebar > div:nth-of-type(1) > div:nth-of-type(1) > a")).click();
		driver.findElement(By.cssSelector(".close.button")).click();
		driver.findElement(By.cssSelector(".titlebarTextWrapper")).click();
	}
}
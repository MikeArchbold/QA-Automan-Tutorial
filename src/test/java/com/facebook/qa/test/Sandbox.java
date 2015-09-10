package com.facebook.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.facebook.qa.pages.FacebookMainPage;

public class Sandbox {

	//javascript changing ids...use css???
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://facebook.com");
		FacebookMainPage mp  = PageFactory.initElements(driver, FacebookMainPage.class);
		System.out.println("running");
		mp.setText_EmailSignUp("qa");
		mp.setText_FirstName("John");
		mp.setText_LastName("auto");
		mp.setText_PasswordSignUp("1234");
		mp.dropdown_Bday("9", "10", "1999");
	}
}

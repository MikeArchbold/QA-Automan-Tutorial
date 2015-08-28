package com.facebook.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import data.HomePage;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	public void setup(){
		driver = new FirefoxDriver();
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown(){
		//driver.quit();
	}
	
	@Test(groups = {"p1", "pageLoads"}, dataProvider="pages", dataProviderClass=HomePage.class)
	public void loadPage(String url, String title){
		driver.get(url);
		Assert.assertEquals(driver.getTitle(), title);
	}

	@Test(groups={"p2", "field"}, dependsOnMethods = "loadPage")
	public void fillOutEmailField(){
		String email = "example@gmail.com";
		WebElement loginName = driver.findElement(By.id("email"));
		loginName.sendKeys(email);
		Assert.assertEquals(loginName.getAttribute("value"), email);
	}
	
	@Test(groups={"p2", "field"}, dependsOnMethods = "fillOutEmailField")
	public void fillOutPasswordField(){
		String password = "123456";
		WebElement passwordField = driver.findElement(By.id("pass"));
		passwordField.sendKeys(password);
		Assert.assertEquals(passwordField.getAttribute("value"), password);
	}
}
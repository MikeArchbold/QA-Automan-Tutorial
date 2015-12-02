package com.facebook.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublicProfilePage extends BasePage{

	@FindBy(css="#fbProfileCover > div:nth-of-type(3) > div:nth-of-type(1) > h2 > span:nth-of-type(1)")
	WebElement textbox_pageTitle;

	public PublicProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void verifyPageTitle(String title){
		assertText(textbox_pageTitle, title);
	}
}

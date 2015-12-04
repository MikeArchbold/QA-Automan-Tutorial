package com.facebook.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublicProfilePage extends BasePage{

	@FindBy(css="#fbProfileCover > div:nth-of-type(3) > div:nth-of-type(1) > h2 > span:nth-of-type(1)")
	WebElement textbox_pageTitle;
	@FindBy(xpath=".//*[@data-id='1']/div/div[2]/div/div")
	WebElement link_aboutSection;
	@FindBy(css=".uiList.fbSettingsList > li:nth-of-type(3) > div > div:nth-of-type(2) > div> a")
	WebElement link_website;
	
	public PublicProfilePage(WebDriver driver) {
		super(driver);
	}

	public void verifyPageTitle(String title){
		assertText(textbox_pageTitle, title);
	}

	public void openAboutSection() {
		click(link_aboutSection);
	}
	
	public void clickPersonalLink(String title){
		click(link_website);
		verifyWebsiteTitle(title);
	}
}

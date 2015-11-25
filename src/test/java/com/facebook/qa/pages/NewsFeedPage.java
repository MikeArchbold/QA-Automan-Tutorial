package com.facebook.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsFeedPage extends BasePage{
	
	@FindBy(xpath=".//*[@id='mentionsInput']/div/div[2]/div/div/textarea")
	WebElement textbox_NewsFeed;
	@FindBy(css=".uiTextareaAutogrow")
	WebElement textbox_NewsFeedWithEmote;
	@FindBy(css="#composerActionTagger > span")
	WebElement button_OpenEmotesWindow;
	@FindBy(xpath=".//*[@class='uiTypeaheadView uiContextualTypeaheadView']/ul/li[1]/span")
	WebElement listItem_Feeling;
	@FindBy(css=".uiScrollableAreaContent > div > ul > li:nth-of-type(3)")
	WebElement listItem_Excited;
	@FindBy(css="._2yg._4zz-  > div:nth-of-type(9) > div > div:nth-of-type(2) > div > button")
	WebElement button_RemoveEmote;
	
	public void editNewsFeedText(String text){
		setText(textbox_NewsFeed, text);
	}
	
	public void clearNewsFeedText(){
		System.out.print("not working");
		clearText(textbox_NewsFeedWithEmote);
	}
	
	public void openEmotesWindow(){
		click(button_OpenEmotesWindow);
	}
	
	public void selectExcitedEmote(){
		click(listItem_Feeling);
		click(listItem_Excited);
	}
	
	public void removeEmotes(){
		click(button_OpenEmotesWindow);
		click(button_RemoveEmote);
	}
	
	public NewsFeedPage(WebDriver driver){
		super(driver);
	}
}

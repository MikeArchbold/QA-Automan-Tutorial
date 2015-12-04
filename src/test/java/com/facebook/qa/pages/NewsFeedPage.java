package com.facebook.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	@FindBy(xpath=".//*[@action='/search/web/direct_search.php']/div/div/div/div/div[3]")
	WebElement textbox_searchBox;
	@FindBy(xpath=".//*[@id='js_a']/ul/li[1]")
	WebElement listItem_firstSearch;
	@FindBy(css="#fbDockChatBuddylistNub > a")
	WebElement button_openChat;
	@FindBy(css=".clearfix.fbNubFlyoutTitlebar > div:nth-of-type(1) > div:nth-of-type(1) > a")
	WebElement button_createNewMessage;
	@FindBy(css=".close.button")
	WebElement button_closeMessage;
	@FindBy(css=".titlebarTextWrapper")
	WebElement button_closeChat;
	
	public NewsFeedPage(WebDriver driver){
		super(driver);
	}
	
	public void editNewsFeedText(String text){
		setText(textbox_NewsFeed, text);
	}
	
	public void search(String text, WebDriverWait wait){
		setText(textbox_searchBox, text);
		waitUntilVisible(listItem_firstSearch);
		click(listItem_firstSearch);
	}
	
	public void openChat(){
		click(button_openChat);
	}
	
	public void openNewMessage(){
		click(button_createNewMessage);
	}
	
	public void closeMessage(){
		click(button_closeMessage);
	}
	
	public void closeChat(){
		click(button_closeChat);
	}
	
	public void clearNewsFeedText(){
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
}

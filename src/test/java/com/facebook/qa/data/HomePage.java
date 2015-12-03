package com.facebook.qa.data;

import org.testng.annotations.DataProvider;

import com.facebook.qa.tools.ReadXMLFile;

public class HomePage {
	
	@DataProvider(name="pages")
	public static Object[][] pages(){
		return new Object[][]{
			{"http://facebook.com", "Facebook - Log In or Sign Up"},
			{"http://google.com", "Google"},
			{"http://yahoo.com", "Yahoo"}
		};
	}
	
	@DataProvider(name="login")
	public static Object[][] login(){
		String [][] users = ReadXMLFile.getUsersXML();
		return new Object[][]{
			{users[0][0], users[0][1], users[0][2]},
			{users[1][0], users[1][1], users[1][2]}
		};
	}
	
	@DataProvider(name="correctLogin")
	public static Object[][] correctLogin(){
		String [][] users = ReadXMLFile.getUsersXML();
		return new Object[][]{
			{users[0][0], users[0][1]},
		};
	}
}
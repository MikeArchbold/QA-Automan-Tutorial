package com.facebook.qa.test;

import java.io.File;

public class Sandbox {

	//javascript changing ids...use css???
	public static void main(String[] args) throws InterruptedException{
//		
		String user = System.getProperty("user.name");
		System.out.println(user);
		System.out.println("/home/" + user + "/users.xml");
		File fXmlFile = new File("/home/" + user + "/users.xml");
		
//		WebDriver driver = new FirefoxDriver();
//		//driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.get("http://facebook.com");
//		FacebookMainPage mp  = PageFactory.initElements(driver, FacebookMainPage.class);
//		System.out.println("running");
//		mp.setText_EmailSignUp("qa");
//		mp.setText_FirstName("John");
//		mp.setText_LastName("auto");
//		mp.setText_PasswordSignUp("1234");
//		mp.dropdown_Bday("9", "10", "1999");
	}
}

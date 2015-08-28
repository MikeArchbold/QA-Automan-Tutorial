package data;

import org.testng.annotations.DataProvider;

public class HomePage {
	
	@DataProvider(name="pages")
	public static Object[][] pages(){
		return new Object[][]{
			{"http://facebook.com", "Facebook - Log In or Sign Up"},
			{"http://google.com", "Google"},
			{"http://yahoo.com", "Yahoo"}
		};
	}
}

import static java.lang.Math.abs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {

	public static void main(String[] args) throws InterruptedException{
		double money = 33.33;
		System.out.println(String.format("$%,.2f", abs(money)));
		System.out.println(3 + "hi");
		int number = 1;
		System.out.println(number + " " + (number == 1 ? "this" : "taht"));
		/*WebDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		
		WebElement textbox = driver.findElement(By.cssSelector("#email"));
		textbox.sendKeys("my username");
		
		WebElement forgotLink = driver.findElement(By.cssSelector(".login_form_label_field>a"));
		forgotLink.click();
		
		Thread.sleep(2000L);
		
		driver.get("http://www.amazon.com");
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		List<WebElement> headers = driver.findElements(By.cssSelector(".nav-line-2"));
		for(WebElement element : headers){
			System.out.println(element.getText());
		}
		
		WebElement account00 = driver.findElement(By.cssSelector("#nav-link-yourAccount>.nav-line-2"));
		account00.click();
		
		driver.close();*/
	}

}

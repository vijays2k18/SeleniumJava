package Testing.SeleniumTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MaximizeWindow_DeleteCookies {
	
	@Test
	public void run() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// Maximize Window
		driver.manage().window().maximize();
		// Delete all Cookies
		driver.manage().deleteAllCookies();
		// Delete particular Cookies for before launching a URL
		driver.manage().deleteCookieNamed("YourCookieName");
		driver.get("https://www.google.com/");
	}

}

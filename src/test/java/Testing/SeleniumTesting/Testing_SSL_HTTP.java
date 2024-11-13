package Testing.SeleniumTesting;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing_SSL_HTTP {
	
	@Test
	public void run()
	{
		ChromeOptions options = new ChromeOptions();
		// This line bypass ssl certification of website
		options.setAcceptInsecureCerts(true); // you set true you access ssl expired website
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options); // pass chromeoptions object in chromeDriver class
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://expired.badssl.com/");
	}

}

package Testing.SeleniumTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTags {
	
	@Test
	public void run()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		int countofAllLinks = driver.findElements(By.tagName("a")).size();
		System.out.println(countofAllLinks);
		// Limiting Scope of Driver
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		int countofFooterLinks = footerDriver.findElements(By.tagName("a")).size();
		System.out.println(countofFooterLinks);
		// Column Driver 1
		WebElement columnDriver = footerDriver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
		int countofColumnDriver = columnDriver.findElements(By.tagName("a")).size();
		System.out.println(countofColumnDriver);
		
		for(int i=1;i<=countofColumnDriver;i++) {
			String clickonTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonTab);
		}
	}

}

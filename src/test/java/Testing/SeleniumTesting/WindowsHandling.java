package Testing.SeleniumTesting;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {
	
	
	@Test
	public void run()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String userName = driver.findElement(By.cssSelector(".im-para.red")).getText();
		//Please email us at mentor@rahulshettyacademy.com with below template to receive response
		String password = userName.split("at")[1].trim();
	    // mentor@rahulshettyacademy.com with below template
		String expectedUserName = password.split(" ")[0].trim();
		System.out.println(expectedUserName);
	
		
		
	}

}

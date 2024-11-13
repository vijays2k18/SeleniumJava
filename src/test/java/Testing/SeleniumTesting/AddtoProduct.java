package Testing.SeleniumTesting;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddtoProduct {
	
	@Test
	public void run() throws InterruptedException
	{
		String itemNames[] = {"Tomato"};
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		for(int i=1;i<productNames.size();i++)
		{
			String actualItemNames = productNames.get(i).getText();
			// Almonds - 1/4 Kg
			String actualItemNames1 = actualItemNames.split("-")[0].trim();
			System.out.println(actualItemNames1);
			List<String> expectedNames = Arrays.asList(itemNames);
			Thread.sleep(3000);
			if(expectedNames.contains(actualItemNames1)) {
				j++;
				List<WebElement> addToCartButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='ADD TO CART']")));
				addToCartButtons.get(i).click();
				if(j==expectedNames.size()) {
					break;
				}
			
			}
		}
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='PROCEED TO CHECKOUT']")));
		checkoutButton.click();
		
		
	}

}

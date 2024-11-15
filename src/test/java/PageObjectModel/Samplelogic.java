package PageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObject.CardDetails;
import PageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Samplelogic {
	 WebDriver driver;
	 SoftAssert as;
	
	 @Test
	 public void demo() throws InterruptedException {
	     try {
	    	 ChromeOptions options = new ChromeOptions();
	    	 options.addArguments("--disable-notifications");
	         WebDriverManager.chromedriver().setup();
	         driver = new ChromeDriver(options);
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	         driver.get("https://rahulshettyacademy.com/client");
	         LandingPage landingPage = new LandingPage(driver);
	         landingPage.loginCredentials("vijays2k18@gmail.com", "vijay1234");

	         // Wait for products to load
	         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	         List<WebElement> productSize = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='card-body']/h5/b")));

	         // Loop through products
	         for (int i = 1; i <= productSize.size(); i++) {
	             String actualProducts = productSize.get(i).getText();
	             System.out.println(actualProducts);

	             if (actualProducts.equalsIgnoreCase("IPHONE 13 PRO")) {
	                 try {
	                     // Find "Add to Cart" button for the specific product
	                     List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[contains(text(), 'Add To Cart')]"));
	                     addToCartButtons.get(i).click();  // Click the corresponding "Add to Cart" button
	                 } catch (Exception e) {
	                     System.out.println("Error clicking 'Add To Cart' for IPHONE 13 PRO: " + e.getMessage());
	                 }
	             }
	             Thread.sleep(5000);

	             if (actualProducts.equalsIgnoreCase("ADIDAS ORIGINAL")) {
	                 try {
	                     // Find "Add to Cart" button for the specific product
	                     List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[contains(text(), 'Add To Cart')]"));
	                     addToCartButtons.get(i).click();  // Click the corresponding "Add to Cart" button
	                 } catch (Exception e) {
	                     System.out.println("Error clicking 'Add To Cart' for ADIDAS ORIGINAL: " + e.getMessage());
	                 }
	                 Thread.sleep(5000);
	             }

	             if (actualProducts.equalsIgnoreCase("QWERTY")) {
	                 try {
	                     // Find "Add to Cart" button for the specific product
	                     List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[contains(text(), 'Add To Cart')]"));
	                     addToCartButtons.get(i).click();  // Click the corresponding "Add to Cart" button
	                 } catch (Exception e) {
	                     System.out.println("Error clicking 'Add To Cart' for QWERTY: " + e.getMessage());
	                 }
	                 Thread.sleep(5000);
	             }
	         }
	     } catch (Exception e) {
	         System.out.println(e);
	     }

	     // Cart area: Compare products in cart and proceed to checkout
	     driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	     List<WebElement> productsNameAdded = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));

	     for (int i = 0; i < productsNameAdded.size(); i++) {
	         String expectedProducts = productsNameAdded.get(i).getText();
	         System.out.println(expectedProducts);

	         // Check each product name independently
	         if (expectedProducts.equalsIgnoreCase("ADIDAS ORIGINAL") || 
	             expectedProducts.equalsIgnoreCase("IPHONE 13 PRO") || 
	             expectedProducts.equalsIgnoreCase("QWERTY")) {
	             driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
	             break; // Exit loop once checkout is clicked
	         }
	     }
	     
	     CardDetails cardpage = new CardDetails(driver);
	     cardpage.cardDetails("423", "India");
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("visa");
		     Thread.sleep(2000);
	     List<WebElement> options =driver.findElements(By.cssSelector(".ta-results.list-group.ng-star-inserted button"));
	     
	     for(WebElement option:options) {
	    	 if(option.getText().equalsIgnoreCase("india")) {
	    		 option.click();
	    	 }
	     }
	     
	     driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
	     System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Thankyou for the order.']")).getText());
	     driver.close();
	 }




	}





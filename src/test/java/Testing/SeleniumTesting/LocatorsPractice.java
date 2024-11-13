package Testing.SeleniumTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsPractice {
	
	@Test
	public void run() throws InterruptedException
	{
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.get("https://rahulshettyacademy.com/locatorspractice/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.findElement(By.id("inputUsername")).sendKeys("vijays2k18@gmail.com");
				driver.findElement(By.name("inputPassword")).sendKeys("1234567");
				driver.findElement(By.id("chkboxOne")).click();
				driver.findElement(By.id("chkboxTwo")).click();
				driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error")));
				String expectedValues = driver.findElement(By.cssSelector(".error")).getText();
				String actualValues = "* Incorrect username or password";
				SoftAssert as = new SoftAssert();
				as.assertEquals(actualValues, expectedValues);
				as.assertAll();
				System.out.println("Assertion Completed no error");
				driver.findElement(By.xpath("//a[normalize-space()='Forgot your password?']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Forgot password']")));
				driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("vijay");
				driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("vijays2k18@gmail.com");
				driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("8080808080");
				driver.findElement(By.xpath("//button[normalize-space()='Reset Login']")).click();
				String fullText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
				String actualPassword = fullText.split("'")[1].trim();
				System.out.println("Temporary Password: " + actualPassword);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Go to Login']")));
				driver.findElement(By.xpath("//button[normalize-space()='Go to Login']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputUsername")));
				driver.findElement(By.id("inputUsername")).sendKeys("vijays2k18@gmail.com");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("inputPassword")));
				driver.findElement(By.name("inputPassword")).sendKeys(actualPassword);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chkboxOne")));
				driver.findElement(By.id("chkboxOne")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chkboxTwo")));
				driver.findElement(By.id("chkboxTwo")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Sign In']")));
				driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
				System.out.println(driver.findElement(By.xpath("//p[normalize-space()='You are successfully logged in.']")).getText());
				driver.close();
				
	}

}

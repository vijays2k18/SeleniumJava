package Testing.SeleniumTesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownPractise {
	
	
	@Test
	public void demo()
	{
		try {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select s1 = new Select(staticDropDown);
		s1.selectByIndex(1);
		System.out.println(s1.getFirstSelectedOption().getText());
		s1.selectByVisibleText("USD");
		System.out.println(s1.getFirstSelectedOption().getText());
		s1.selectByValue("AED");
		System.out.println(s1.getFirstSelectedOption().getText());
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		int i=1;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		int j=1;
		while(j<=2)
		{
			driver.findElement(By.id("hrefIncChd")).click();
			j++;
		}
		
		int k=1;
		while(k<=3) {
			driver.findElement(By.id("hrefIncInf")).click();
			k++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(	driver.findElement(By.id("divpaxinfo")).getText());
		
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Chennai (MAA)']")).click();
		driver.findElement(By.xpath("(//a[@value='BLR'][normalize-space()='Bengaluru (BLR)'])[2]")).click();
		
		driver.findElement(By.id("autosuggest")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option : options) {
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		// Java Alert Handling
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("name")).sendKeys("Vijay");
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.id("name")).sendKeys("Vijay");
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		driver.close();
		}
		catch(Exception ex)
		{
			System.out.println("Exception"+ex);
		}
		
	}
	

}

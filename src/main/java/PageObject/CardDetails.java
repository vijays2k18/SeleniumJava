package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardDetails {
	
WebDriver driver;
	
	public CardDetails(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='payment__cc']//div[2]//input[1]")
	public WebElement CVV;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	public WebElement Country;
	
	public void cardDetails(String cvv, String country) {
		CVV.sendKeys(cvv);

		Country.sendKeys(country);
	}

}

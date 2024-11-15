package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	public WebElement userName;
	
	@FindBy(id="userPassword")
	public WebElement userPassword;
	

	@FindBy(id="login")
	public WebElement login;
	
	public void loginCredentials(String userMail,String userPass) {
		
		userName.sendKeys(userMail);
		userPassword.sendKeys(userPass);
		login.click();
	}
	

}

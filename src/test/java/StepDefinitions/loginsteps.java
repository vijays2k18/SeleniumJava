package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginsteps {

    WebDriver driver;

    @Given("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://rahulshettyacademy.com/client");
            driver.findElement(By.id("userEmail")).sendKeys("vijays2k18@gmail.com");
            driver.findElement(By.id("userPassword")).sendKeys("vijay1234");
            driver.findElement(By.id("login")).click();
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
        }
    }

    @When("the user adds products to the cart one by one")
    public void the_user_adds_products_to_the_cart_one_by_one() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> productSize = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='card-body']/h5/b")));

            for (int i = 1; i <= productSize.size(); i++) {
                String actualProducts = productSize.get(i).getText();
                System.out.println(actualProducts);

                if (actualProducts.equalsIgnoreCase("IPHONE 13 PRO") || 
                    actualProducts.equalsIgnoreCase("ADIDAS ORIGINAL") || 
                    actualProducts.equalsIgnoreCase("QWERTY")) {
                    try {
                        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[contains(text(), 'Add To Cart')]"));
                        addToCartButtons.get(i).click();
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        System.out.println("Error clicking 'Add To Cart' for " + actualProducts + ": " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error adding products to the cart: " + e.getMessage());
        }
    }

    @When("clicks the checkout button")
    public void clicks_the_checkout_button() {
        try {
            driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
            List<WebElement> productsNameAdded = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));

            for (int i = 0; i < productsNameAdded.size(); i++) {
                String expectedProducts = productsNameAdded.get(i).getText();
                System.out.println(expectedProducts);

                if (expectedProducts.equalsIgnoreCase("ADIDAS ORIGINAL") || 
                    expectedProducts.equalsIgnoreCase("IPHONE 13 PRO") || 
                    expectedProducts.equalsIgnoreCase("QWERTY")) {
                    driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error during checkout: " + e.getMessage());
        }
    }

    @Then("the final result should display the order confirmation")
    public void the_final_result_should_display_the_order_confirmation() throws InterruptedException {
        try {
            driver.findElement(By.xpath("//div[@class='payment__cc']//div[2]//input[1]")).sendKeys("423");
            driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("visa");
            driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
            Thread.sleep(2000);

            List<WebElement> options = driver.findElements(By.cssSelector(".ta-results.list-group.ng-star-inserted button"));
            for (WebElement option : options) {
                if (option.getText().equalsIgnoreCase("india")) {
                    option.click();
                }
            }

            driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
            System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Thankyou for the order.']")).getText());
        } catch (Exception e) {
            System.out.println("Error during order confirmation: " + e.getMessage());
        } finally {
            if (driver != null) {
            	Thread.sleep(2000); // Allow connections to settle
            	driver.quit();

            }
        }
    }
}

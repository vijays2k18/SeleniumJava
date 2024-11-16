package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/Cucumber/Ecommerce.feature",
    glue = "StepDefinitions/loginsteps.java", // Ensure this path is correct
    monochrome = true,// Ensure your feature file has this tag
    plugin = {"pretty", "html:target/cucumber-reports.html"} // Optional: for report generation
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = "stepDefinitions", // Package where your step definitions are located
        monochrome = true, // Whether to display output in monochrome mode (true/false)
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Plugins for generating reports
        tags = "@Smoke" // Tags to specify which scenarios to run
)
public class TestRunner {
}

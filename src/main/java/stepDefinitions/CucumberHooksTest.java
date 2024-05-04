package stepDefinitions;

import basePages.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.AssertFactory;
import utilities.AssertionCollector;

public class CucumberHooksTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(CucumberHooksTest.class);

    // Before hook to set up preconditions before each scenario
    @Before
    public void setup() {
        System.out.println("Before Hook Started");
        setBrowser();
    }

    // After hook to perform cleanup after each scenario
    @After
    public void teardown(Scenario scenario) {
        AssertFactory assertFactory = AssertFactory.getInstance();
        assertFactory.assertAll();
        closeBrowser();
        closeDriver();
        System.out.println("After Hook Executed");
    }
}

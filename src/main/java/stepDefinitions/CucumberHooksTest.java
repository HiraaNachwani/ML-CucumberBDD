package stepDefinitions;

import basePages.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BrowserDriverFactory;

public class CucumberHooksTest extends BaseTest {


    // Before hook to set up preconditions before each scenario
    @Before
    public void setup() {
        System.out.println("Before Hook Started");
        setBrowser();

    }

    // After hook to perform cleanup after each scenario
    @After
    public void teardown() {
        closeBrowser();
        closeDriver();
        System.out.println("After Hook Executed");
    }


}

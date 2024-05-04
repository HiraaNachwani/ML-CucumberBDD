package stepDefinitions;

import basePages.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.AssertFactory;
import utilities.ExcelDataProvider;
import utilities.ExtentManager;
import utilities.ExtentTestReporter;

import java.util.Map;

public class CucumberHooksTest extends BaseTest {

    public static Map<String, Map<String, Map<String, Object>>> excelDataMap;

    // Before hook to set up preconditions before each scenario
    @Before
    public void setup(Scenario scenario) {
        ExtentTestReporter.startTest(scenario.getName());
        excelDataMap = ExcelDataProvider.getExcelDataMap();
        setBrowser();
    }

    // After hook to perform cleanup after each scenario
    @After
    public void teardown(Scenario scenario) {
        closeBrowser();
        closeDriver();
        ExtentTestReporter.endTest(scenario);
        ExtentManager.getInstance().flush();
        AssertFactory.getInstance().assertAll();
        System.out.println("After Hook Executed");
    }
}

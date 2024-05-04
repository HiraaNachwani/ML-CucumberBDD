package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;

/**
 * Manages the creation and configuration of the ExtentReports instance.
 */
public class ExtentManager {

    private static ExtentReports extentReports;
    private static String reportPath = System.getProperty("user.dir") + "/testReports/Regression_ExtentReport.html";

    /**
     * Get the instance of ExtentReports, creating it if necessary.
     * @return The ExtentReports instance.
     */
    public static synchronized ExtentReports getInstance() {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
            extentReports.attachReporter(extentSparkReporter);
        }
        return extentReports;
    }

    /**
     * Handle the test result and log it in the Extent Report.
     * @param test The ExtentTest object representing the test.
     * @param scenario The Cucumber scenario object.
     */
    public static void handleTestResult(ExtentTest test, Scenario scenario) {
        if (test == null) {
            System.err.println("ExtentTest object is null. Cannot handle test result.");
            return;
        }
        if (scenario.isFailed()) {
            test.fail("Test Case Failed: " + scenario.getName());
        } else {
            test.pass("Test Case Passed: " + scenario.getName());
        }
    }
}

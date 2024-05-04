package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.Scenario;

/**
 * Utility class to manage ExtentTest objects and report test results.
 */
public class ExtentTestReporter {

    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    /**
     * Start a new test and return the ExtentTest object.
     *
     * @param testName The name of the test.
     * @return The ExtentTest object representing the test.
     */
    public static synchronized ExtentTest startTest(String testName) {
        // Create a new ExtentTest object for the given test name
        ExtentTest test = ExtentManager.getInstance().createTest(testName);

        // Store the ExtentTest object in the thread-local storage
        extentTestThreadLocal.set(test);

        return test;
    }

    /**
     * Log a message with the specified status for the current test.
     *
     * @param info    Status of the log message.
     * @param message The log message to be recorded.
     */
    public static void log(Status info, String message) {
        ExtentTest test = extentTestThreadLocal.get();
        if (test == null) {
            // If ExtentTest object is null, log an error message
            System.err.println("ExtentTest object is null. Cannot log message: " + message);
            return;
        }

        // Log the message with the specified status
        test.log(info, message);

        // Capture and attach screenshot if status is fail
        if (info == Status.FAIL) {
            // If the status is fail, capture and attach a screenshot to the Extent report
            ScreenshotFactory.captureAndAttachScreenshot(test);
        }
    }

    /**
     * Handle the completion of the test and report the result.
     *
     * @param scenario Result of the executed test method.
     */
    public static void endTest(Scenario scenario) {
        ExtentTest test = extentTestThreadLocal.get();
        if (test == null) {
            // If ExtentTest object is null, log an error message
            System.err.println("ExtentTest object is null. Cannot handle test end.");
            return;
        }

        // Handle the test result using ExtentManager
        ExtentManager.handleTestResult(test, scenario);

        // Clean up thread-local storage
        extentTestThreadLocal.remove();
    }
}

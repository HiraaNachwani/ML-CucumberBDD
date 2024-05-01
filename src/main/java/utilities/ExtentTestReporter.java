package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;

public class ExtentTestReporter {
    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    /**
     * Start a new test and return the ExtentTest object.
     *
     * @param testName The name of the test.
     * @param desc     Description of the test.
     */
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = ExtentManager.getInstance().createTest(testName, desc);
        extentTestThreadLocal.set(test);
        return test;
    }

    /**
     * Log a message with the specified status for the current test.
     * @param info Status of the log message.
     * @param message The log message to be recorded.
     */
    public static void logger(Status info, String message) {
        ExtentTest test = extentTestThreadLocal.get();
        if (test != null) {
            test.log(info, message);
        } else {
            System.out.println("Test object is null. Please start the test before logging.");
        }
    }

    /**
     * Handle the completion of the test.
     * @param iTestResult Result of the executed test method.
     */
    public static void endTest(ITestResult iTestResult) {
        ExtentTest test = extentTestThreadLocal.get();
        if (test != null) {
            ExtentManager.handleTestResult(test, iTestResult);
            extentTestThreadLocal.remove(); // Clean up thread-local storage
        } else {
            System.out.println("Test object is null. Please start the test before ending.");
        }
    }
}

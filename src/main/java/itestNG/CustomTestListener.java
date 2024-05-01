package itestNG;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExtentTestReporter;

public class CustomTestListener implements ITestListener {

    /**
     * This method is invoked before the test suite starts.
     */
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite started: " + context.getName());
    }

    /**
     * This method is invoked after the test suite finishes.
     */
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite finished: " + context.getName());
    }

    /**
     * This method is invoked when a test method starts executing.
     */
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
        ExtentTestReporter.logger(Status.INFO, "Test Started: " + result.getName());
    }

    /**
     * This method is invoked when a test method successfully completes execution.
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        ExtentTestReporter.logger(Status.PASS, "Test Passed: " + result.getName());
        ExtentTestReporter.endTest(result);
    }

    /**
     * This method is invoked when a test method fails during execution.
     */
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        ExtentTestReporter.logger(Status.FAIL, "Test Failed: " + result.getName());
        ExtentTestReporter.endTest(result);
    }

    /**
     * This method is invoked when a test method is skipped.
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
        ExtentTestReporter.logger(Status.SKIP, "Test Skipped: " + result.getName());
        ExtentTestReporter.endTest(result);
    }

    /**
     * This method is invoked when a test fails within the success percentage.
     * Not implemented in this example.
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ExtentTestReporter.logger(Status.INFO, "Test Failed with Success Percentage: " + result.getName());
        ExtentTestReporter.endTest(result);
    }

}

package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;

public class ExtentManager {

    private static ExtentReports extentReports;
    private static String reportPath = System.getProperty("user.dir") + "/testReports/RegressionReport.html";

    public static ExtentReports getInstance() {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
            extentReports.attachReporter(extentSparkReporter);
        }
        return extentReports;
    }

    public static void handleTestResult(ExtentTest test, ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped: " + result.getThrowable());
        } else {
            test.log(Status.PASS, "Test Case Passed");
        }
        // End the test after reporting its result
        test.getModel().getLogs().clear();
    }
}

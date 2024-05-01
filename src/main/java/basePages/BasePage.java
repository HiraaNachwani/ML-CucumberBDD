package basePages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.BrowserDriverFactory;
import utilities.ExtentTestReporter;

public class BasePage {

    // Generic method to initialize PageFactory for a given page class using reflection
    protected synchronized <T> T initPage(Class<T> pageClass) {
        WebDriver driver = BrowserDriverFactory.getDriver();
        return PageFactory.initElements(driver, pageClass);
    }

    // Generic method to assert page title
    public synchronized void assertPageTitle(String expectedTitle) {
        WebDriver driver = BrowserDriverFactory.getDriver();
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected. Actual: " + actualTitle + ", Expected: " + expectedTitle);
            // Logging the assertion result if it passes
            ExtentTestReporter.logger(Status.PASS, "Page title matches expected: " + expectedTitle);
        } catch (AssertionError e) {
            // Logging the assertion result if it fails
            ExtentTestReporter.logger(Status.FAIL, "Page title does not match expected. Actual: " + actualTitle + ", Expected: " + expectedTitle);
            throw e; // Re-throwing the exception to fail the test
        }
    }
}

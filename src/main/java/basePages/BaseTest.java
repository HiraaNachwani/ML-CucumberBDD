package basePages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserDriverFactory;
import utilities.ExtentTestReporter;

import java.time.Duration;

/**
 * BaseTest class contains common methods used in test classes.
 */
public class BaseTest {

    /**
     * Initializes the page object using PageFactory.
     *
     * @param pageClass The class of the page object to initialize
     * @param <T>       The type of the page object
     * @return An instance of the page object
     */
    protected synchronized <T> T initPage(Class<T> pageClass) {
        try {
            WebDriver driver = BrowserDriverFactory.getDriver();
            return PageFactory.initElements(driver, pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestReporter.log(Status.FAIL, "Failed to initialize page: " + pageClass.getSimpleName());
            // Log the exception
            return null;
        }
    }

    /**
     * Opens the application URL in the browser.
     *
     * @param URL The URL of the application
     */
    public void openApplication(String URL) {
        try {
            WebDriver driver = BrowserDriverFactory.getDriver();
            driver.get(URL);
            ExtentTestReporter.log(Status.PASS, "Opened application URL: " + URL);
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestReporter.log(Status.FAIL, "Failed to open application URL: " + URL);
            // Log the exception
        }
    }

    /**
     * Sets up the browser with desired configurations.
     */
    public void setBrowser() {
        try {
            BrowserDriverFactory.createDriver();
            WebDriver driver = BrowserDriverFactory.getDriver();
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
                ExtentTestReporter.log(Status.PASS, "Browser setup completed successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestReporter.log(Status.FAIL, "Failed to set up browser");
            // Log the exception
        }
    }

    /**
     * Closes the WebDriver instance.
     */
    public synchronized static void closeDriver() {
        try {
            WebDriver driver = BrowserDriverFactory.getDriver();
            if (driver != null) {
                driver.quit(); // Quit the WebDriver
                ExtentTestReporter.log(Status.PASS, "WebDriver instance closed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestReporter.log(Status.FAIL, "Failed to close WebDriver instance");
            // Log the exception
        }
    }

    /**
     * Closes the browser window.
     */
    public synchronized static void closeBrowser() {
        try {
            WebDriver driver = BrowserDriverFactory.getDriver();
            if (driver != null) {
                driver.close(); // Close the browser window
                ExtentTestReporter.log(Status.PASS, "Browser window closed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestReporter.log(Status.FAIL, "Failed to close browser window");
            // Log the exception
        }
    }
}

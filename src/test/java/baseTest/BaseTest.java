package baseTest;

import com.aventstack.extentreports.Status;
import constants.ConfigPropertyConstants;
import basePages.BasePage;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.*;

// Base class for test classes, contains common setup and teardown methods
public class BaseTest extends BasePage {

    protected static Map<String, Map<String, Map<String, Object>>> excelDataMap;

    @BeforeSuite
    public void beforeSuite() {
        try {
            excelDataMap = ExcelDataProvider.getExcelDataMap();
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception
        }
    }

    @BeforeTest
    public synchronized void beforeTest() {
        try {
            BrowserDriverFactory.createDriver();
            WebDriver driver = BrowserDriverFactory.getDriver(); // Get WebDriver instance
            driver.manage().deleteAllCookies(); // Delete all cookies
            driver.manage().window().maximize(); // Maximize the browser window
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Set implicit wait timeout
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5)); // Set page load timeout
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception
        }
    }

    @AfterTest
    public synchronized void afterTest() {
        try {
            // Close the WebDriver after each test
            closeBrowser();
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception
        }
    }

    @AfterSuite
    public synchronized void afterSuite() {
        try {
            ExtentManager.getInstance().flush();
            closeDriver();
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception
        }
    }

    // Teardown method to close the WebDriver when tests are finished
    public synchronized static void closeDriver() {
        try {
            WebDriver driver = BrowserDriverFactory.getDriver();
            if (driver != null) {
                driver.quit(); // Quit the WebDriver

            }
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception
        }
    }

    // Teardown method to close the browser window when tests are finished
    public synchronized static void closeBrowser() {
        try {
            WebDriver driver = BrowserDriverFactory.getDriver();
            if (driver != null) {
                driver.close(); // Close the browser window
                ExtentTestReporter.logger(Status.INFO, "Browser closed successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception
        }
    }

    // Method to open the application using the URL from config constants
    public void openApplication() {
        try {
            WebDriver driver = BrowserDriverFactory.getDriver();
            driver.get(ConfigPropertyConstants.URL);
            ExtentTestReporter.logger(Status.INFO, "Application launched successfully");
        } catch (Exception e) {
            ExtentTestReporter.logger(Status.INFO, "Application failed to launch");
            System.out.println("Exception occurred during openApplication(): " + e.getMessage());
            // Log the exception
        }
    }
}

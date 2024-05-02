package basePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserDriverFactory;

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
        } catch (Exception e) {
            e.printStackTrace();
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
            }
        } catch (Exception e) {
            e.printStackTrace();
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
            }
        } catch (Exception e) {
            e.printStackTrace();
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
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception
        }
    }
}

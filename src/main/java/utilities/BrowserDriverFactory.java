package utilities;

import com.aventstack.extentreports.Status;
import constants.ConfigPropertyConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDriverFactory {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public synchronized static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public synchronized static void createDriver() {
        WebDriver driver = null;
        String browserName = ConfigPropertyConstants.BROWSER;

        switch (browserName.toLowerCase()) {
            case "chrome":
                // System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                // System.setProperty("webdriver.gecko.driver", "path_to_geckodriver");
                driver = new FirefoxDriver();
                break;
            case "ie":
                // System.setProperty("webdriver.ie.driver", "path_to_IEDriverServer");
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified in config file: " + browserName);
        }

        // Store the driver instance in the ThreadLocal variable
        driverThreadLocal.set(driver);
    }
}

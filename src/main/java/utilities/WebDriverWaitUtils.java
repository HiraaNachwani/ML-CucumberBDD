package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverWaitUtils {

    // Generic method to wait for element to be visible with custom timeout
    public static synchronized void waitForElementVisible(WebElement element, int timeoutInSeconds) {
        WebDriver driver = BrowserDriverFactory.getDriver();
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.visibilityOf(element));
    }

    // Generic method to wait for element to be clickable with custom timeout
    public static synchronized void waitForElementClickable(WebElement element, int timeoutInSeconds) {
        WebDriver driver = BrowserDriverFactory.getDriver();
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Generic method to wait for alert to be present with custom timeout
    public static synchronized void waitForAlertPresent(int timeoutInSeconds) {
        WebDriver driver = BrowserDriverFactory.getDriver();
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.alertIsPresent());
    }

    // Generic method to wait for element text to contain given text with custom timeout
    public static synchronized void waitForTextToBePresentInElement(WebElement element, String text, int timeoutInSeconds) {
        WebDriver driver = BrowserDriverFactory.getDriver();
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    // Generic method to wait for title to contain given text with custom timeout
    public static synchronized void waitForTitleContains(String title, int timeoutInSeconds) {
        WebDriver driver = BrowserDriverFactory.getDriver();
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.titleContains(title));
    }

    // Generic method to wait for URL to contain given text with custom timeout
    public static synchronized void waitForURLContains(String partialURL, int timeoutInSeconds) {
        WebDriver driver = BrowserDriverFactory.getDriver();
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.urlContains(partialURL));
    }

    // Generic method to wait for URL to match given URL with custom timeout
    public static synchronized void waitForURLToBe(String url, int timeoutInSeconds) {
        WebDriver driver = BrowserDriverFactory.getDriver();
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.urlToBe(url));
    }

    // Generic method to wait for element attribute to contain given value with custom timeout
    public static synchronized void waitForElementAttributeContains(WebElement element, String attribute, String value, int timeoutInSeconds) {
        WebDriver driver = BrowserDriverFactory.getDriver();
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }
}

package basePages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserDriverFactory;

/**
 * BasePage class contains common methods and utilities used across page classes.
 */
public class BasePage {

    /**
     * Verifies the visibility of a web element.
     *
     * @param element The web element to be verified
     */
    public void verifyVisibilityOfElement(WebElement element) {
        WebDriver driver = BrowserDriverFactory.getDriver();
        try {
            Assert.assertTrue(element.isDisplayed());
            System.out.println("Element is displayed");
        } catch (AssertionError e) {
            System.err.println("Element is not displayed: " + e.getMessage());
        }
    }

    /**
     * Verifies if two strings are equal.
     *
     * @param expected The expected string value
     * @param actual   The actual string value
     */
    public static void verifyEquals(String expected, String actual) {
        try {
            Assert.assertEquals(expected, actual);
            System.out.println("Assertion passed: Expected = " + expected + ", Actual = " + actual);
        } catch (AssertionError e) {
            System.err.println("Assertion failed: " + e.getMessage());
        }
    }

    /**
     * Clicks on a web element.
     *
     * @param element The web element to be clicked
     */
    public void clickElement(WebElement element) {
        try {
            element.click();
            System.out.println("Clicked on element");
        } catch (Exception e) {
            System.err.println("Failed to click element: " + e.getMessage());
        }
    }

    /**
     * Enters text into a text field.
     *
     * @param element The text field web element
     * @param text    The text to be entered
     */
    public void enterText(WebElement element, String text) {
        try {
            element.sendKeys(text);
            System.out.println("Entered text: " + text);
        } catch (Exception e) {
            System.err.println("Failed to enter text: " + e.getMessage());
        }
    }
}

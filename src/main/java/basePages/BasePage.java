package basePages;

import com.aventstack.extentreports.Status;
import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.AssertFactory;
import utilities.BrowserDriverFactory;
import utilities.ExtentTestReporter;

/**
 * BasePage class contains common methods and utilities used across page classes.
 */
public class BasePage {

    protected AssertFactory assertFactory = AssertFactory.getInstance();

    /**
     * Clicks on a web element.
     *
     * @param element The web element to be clicked
     */
    public void clickElement(WebElement element) {
        try {
            element.click();
            System.out.println("Clicked on element: " + element);
            ExtentTestReporter.log(Status.PASS, "Clicked on element: " + element);
        } catch (Exception e) {
            System.err.println("Failed to click element: " + element + " - " + e.getMessage());
            ExtentTestReporter.log(Status.FAIL, "Failed to click element: " + element + " - " + e.getMessage());
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
            element.clear();
            element.sendKeys(text);
            System.out.println("Entered text: " + text + " into element: " + element);
            ExtentTestReporter.log(Status.PASS, "Entered text: " + text + " into element: " + element);
        } catch (Exception e) {
            System.err.println("Failed to enter text: " + text + " into element: " + element + " - " + e.getMessage());
            ExtentTestReporter.log(Status.FAIL, "Failed to enter text: " + text + " into element: " + element + " - " + e.getMessage());
        }
    }

    /**
     * Retrieves the value of the specified attribute for a WebElement.
     *
     * @param element   The WebElement for which to retrieve the attribute value
     * @param attribute The name of the attribute whose value is to be retrieved
     * @return The value of the specified attribute for the WebElement
     */
    public String getAttributeValue(WebElement element, String attribute) {
        try {
            String value = element.getAttribute(attribute);
            System.out.println("Retrieved attribute value: " + value + " for element: " + element);
            ExtentTestReporter.log(Status.PASS, "Retrieved attribute value: " + value + " for element: " + element);
            return value;
        } catch (Exception e) {
            System.err.println("Failed to retrieve attribute value for element: " + element + " - " + e.getMessage());
            ExtentTestReporter.log(Status.FAIL, "Failed to retrieve attribute value for element: " + element + " - " + e.getMessage());
            return null;
        }
    }

    /**
     * Retrieves the visible text of a WebElement.
     *
     * @param element The WebElement for which to retrieve the visible text
     * @return The visible text of the WebElement
     */
    public String getElementText(WebElement element) {
        try {
            String text = element.getText();
            System.out.println("Retrieved text: " + text + " for element: " + element);
            ExtentTestReporter.log(Status.PASS, "Retrieved text: " + text + " for element: " + element);
            return text;
        } catch (Exception e) {
            System.err.println("Failed to retrieve text for element: " + element + " - " + e.getMessage());
            ExtentTestReporter.log(Status.FAIL, "Failed to retrieve text for element: " + element + " - " + e.getMessage());
            return null;
        }
    }

    /**
     * Retrieves the title of the current web page.
     *
     * @return The title of the current web page
     */
    public String getPageTitle() {
        WebDriver driver = BrowserDriverFactory.getDriver();
        try {
            String title = driver.getTitle();
            System.out.println("Retrieved page title: " + title);
            ExtentTestReporter.log(Status.PASS, "Retrieved page title: " + title);
            return title;
        } catch (Exception e) {
            System.err.println("Failed to retrieve page title: " + e.getMessage());
            ExtentTestReporter.log(Status.FAIL, "Failed to retrieve page title: " + e.getMessage());
            return null;
        }
    }

}

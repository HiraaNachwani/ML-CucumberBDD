package utilities;

import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AssertFactory {

    private static AssertFactory instance;
    private final List<AssertionError> errors = new CopyOnWriteArrayList<>(); // Use CopyOnWriteArrayList for thread safety


    private AssertFactory() {
        // Private constructor to prevent instantiation from outside
    }

    public static AssertFactory getInstance() {
        if (instance == null) {
            instance = new AssertFactory();
        }
        return instance;
    }

    /**
     * Verifies the visibility of a web element.
     *
     * @param element The web element to be verified
     */
    public void verifyVisibilityOfElement(WebElement element) {
        WebDriver driver = BrowserDriverFactory.getDriver();
        try {
            Assert.assertTrue(element.isDisplayed());
            String logMessage = "Element '" + element.toString() + "' is displayed";
            System.out.println(logMessage);
            ExtentTestReporter.log(Status.PASS, logMessage);
        } catch (AssertionError e) {
            String errorMessage = "Element '" + element.toString() + "' is not displayed: " + e.getMessage();
            System.err.println(errorMessage);
            ExtentTestReporter.log(Status.FAIL, errorMessage);
            errors.add(e);
        }
    }

    /**
     * Custom assertion method to verify if a condition is true.
     *
     * @param condition The condition to be verified
     * @param message   The message to be displayed on assertion failure
     */
    public void verifyTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(message, condition);
            String logMessage = "Assertion passed: " + message;
            System.out.println(logMessage);
            ExtentTestReporter.log(Status.PASS, logMessage);
        } catch (AssertionError e) {
            String errorMessage = "Assertion failed: " + message + " - " + e.getMessage();
            System.err.println(errorMessage);
            ExtentTestReporter.log(Status.FAIL, errorMessage);
            errors.add(e);
        }
    }


    /**
     * Verifies if two strings are equal.
     *
     * @param expected The expected string value
     * @param actual   The actual string value
     */
    public void verifyEquals(String expected, String actual) {
        try {
            Assert.assertEquals(expected, actual);
            String logMessage = "Assertion passed: Expected = " + expected + ", Actual = " + actual;
            System.out.println(logMessage);
            ExtentTestReporter.log(Status.PASS, logMessage);
        } catch (AssertionError e) {
            String errorMessage = "Assertion failed: Expected = " + expected + ", Actual = " + actual + " - " + e.getMessage();
            System.err.println(errorMessage);
            ExtentTestReporter.log(Status.FAIL, errorMessage);
            errors.add(e);
        }
    }

    /**
     * Verifies if two integers are equal.
     *
     * @param expected The expected integer value
     * @param actual   The actual integer value
     */
    public void verifyEquals(int expected, int actual) {
        try {
            Assert.assertEquals(expected, actual);
            String logMessage = "Assertion passed: Expected = " + expected + ", Actual = " + actual;
            System.out.println(logMessage);
            ExtentTestReporter.log(Status.PASS, logMessage);
        } catch (AssertionError e) {
            String errorMessage = "Assertion failed: Expected = " + expected + ", Actual = " + actual + " - " + e.getMessage();
            System.err.println(errorMessage);
            ExtentTestReporter.log(Status.FAIL, errorMessage);
            errors.add(e);
        }
    }

    /**
     * Verifies if two booleans are equal.
     *
     * @param expected The expected boolean value
     * @param actual   The actual boolean value
     */
    public void verifyEquals(boolean expected, boolean actual) {
        try {
            Assert.assertEquals(expected, actual);
            String logMessage = "Assertion passed: Expected = " + expected + ", Actual = " + actual;
            System.out.println(logMessage);
            ExtentTestReporter.log(Status.PASS, logMessage);
        } catch (AssertionError e) {
            String errorMessage = "Assertion failed: Expected = " + expected + ", Actual = " + actual + " - " + e.getMessage();
            System.err.println(errorMessage);
            ExtentTestReporter.log(Status.FAIL, errorMessage);
            errors.add(e);
        }
    }

    /**
     * Verifies if two doubles are equal with a delta tolerance for floating-point comparisons.
     *
     * @param expected The expected double value
     * @param actual   The actual double value
     * @param delta    The maximum allowed difference between the expected and actual values
     */
    public void verifyEquals(double expected, double actual, double delta) {
        try {
            Assert.assertEquals(expected, actual, delta);
            String logMessage = "Assertion passed: Expected = " + expected + ", Actual = " + actual;
            System.out.println(logMessage);
            ExtentTestReporter.log(Status.PASS, logMessage);
        } catch (AssertionError e) {
            String errorMessage = "Assertion failed: Expected = " + expected + ", Actual = " + actual + " - " + e.getMessage();
            System.err.println(errorMessage);
            ExtentTestReporter.log(Status.FAIL, errorMessage);
            errors.add(e);
        }
    }

    /**
     * Verifies if two objects are equal using their equals method.
     *
     * @param expected The expected object
     * @param actual   The actual object
     */
    public void verifyEquals(Object expected, Object actual) {
        try {
            Assert.assertEquals(expected, actual);
            String logMessage = "Assertion passed: Expected = " + expected + ", Actual = " + actual;
            System.out.println(logMessage);
            ExtentTestReporter.log(Status.PASS, logMessage);
        } catch (AssertionError e) {
            String errorMessage = "Assertion failed: Expected = " + expected + ", Actual = " + actual + " - " + e.getMessage();
            System.err.println(errorMessage);
            ExtentTestReporter.log(Status.FAIL, errorMessage);
            errors.add(e);
        }
    }

    // Add more assertion methods as needed...

    public synchronized void assertAll() {
        if (!errors.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Soft assertion failures:\n");
            for (AssertionError error : errors) {
                errorMessage.append(error.getMessage()).append("\n");
            }
            errors.clear();
            throw new AssertionError(errorMessage.toString());

        }
    }
}

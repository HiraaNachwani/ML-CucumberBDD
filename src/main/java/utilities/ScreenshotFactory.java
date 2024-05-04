package utilities;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

/**
 * Utility class to capture and manage screenshots.
 */
public class ScreenshotFactory {

    private static final String SCREENSHOT_DIR = "screenshots";

    /**
     * Captures a screenshot and saves it as a file.
     *
     * @param screenshotName The name to be given to the screenshot file.
     */
    public static void captureScreenshot(String screenshotName) {
        try {
            // Get the WebDriver instance from the BrowserDriverFactory
            WebDriver driver = BrowserDriverFactory.getDriver();

            // Capture screenshot as a File object
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Define the destination path for the screenshot
            String destinationPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
            File destination = new File(destinationPath);

            // Copy the screenshot file to the destination path
            Files.copy(source.toPath(), destination.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Captures a screenshot and attaches it to the Extent report.
     *
     * @param test The ExtentTest object to which the screenshot should be attached.
     */
    public synchronized static void captureAndAttachScreenshot(ExtentTest test) {
        try {
            // Get the WebDriver instance from the BrowserDriverFactory
            WebDriver driver = BrowserDriverFactory.getDriver();

            // Capture screenshot as bytes
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Convert the byte array to Base64 encoded string and attach to Extent report
            test.addScreenCaptureFromBase64String(Base64.getEncoder().encodeToString(screenshotBytes));
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}

package testClasses;

import baseTest.BaseTest;
import com.aventstack.extentreports.Status;
import constants.ExcelSheetConstants;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.pages.HomePage;
import utilities.ExtentTestReporter;

import java.lang.reflect.Method;
import java.util.Map;

// Test class for verifying Pizza Hut home page functionality
public class PizzaHutLoginTest extends BaseTest {

    // Instance variables
    HomePage homePage;
    private String className;
    Map<String, Map<String, Object>> checkOutPageData;
    Map<String, Map<String, Object>> homePageData;

    // Method to execute before the first test method in the class
    @BeforeClass
    public void beforeClass() {
        // Initialize class-level data before any test method
        className = this.getClass().getSimpleName();
        homePage = initPage(HomePage.class);
        homePageData = excelDataMap.get(ExcelSheetConstants.HOME_PAGE);
        checkOutPageData = excelDataMap.get(ExcelSheetConstants.CHECKOUT_PAGE);
    }

    // Method to execute before each test method
    @BeforeMethod
    public void beforeMethod(Method method) {
        // Setup method-level data before each test method
        // For example, initialize SoftAssert instance
    }

    // Test method
    @Test
    public void T01_VerifyUserLoginTest(Method method) {
        // Test method to verify the functionality of the Pizza Hut home page
        ExtentTestReporter.startTest(method.getName(), "Verify user login test functionality").assignCategory(className);
        openApplication();
        homePage.assertPageTitle("Order Pizza Online - Delivery and Takeawy");
        // Additional test steps
        System.out.println(homePageData.get("userName").get("Value1"));
        System.out.println(checkOutPageData.get("firstName").get("Value1"));
        ExtentTestReporter.logger(Status.INFO, "Test Step: Description for test1");
        ExtentTestReporter.logger(Status.PASS, "Test Step: Description for test1");
    }

    // Method to execute after each test method
    @AfterMethod
    public void afterMethod(ITestResult result) {
        // Clean up method-level data after each test method
        // For example, clean up SoftAssert instance
        //TestReporter.endTest(result);
    }

    // Method to execute after all test methods in the class have been run
    @AfterClass
    public void afterClass() {
        // Clean up class-level data after all test methods in the class
    }
}

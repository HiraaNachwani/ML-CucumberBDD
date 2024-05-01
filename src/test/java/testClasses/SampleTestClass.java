package testClasses;

import baseTest.BaseTest;
import org.testng.annotations.*;

// Sample test class demonstrating the usage of TestNG annotations
public class SampleTestClass extends BaseTest {

    @BeforeClass
    public void beforeClass() {
        // Code to be executed once before the first test method in the class
    }

    @BeforeMethod
    public void beforeMethod() {
        // Code to be executed before each test method
    }

    @Test
    public void T01_VerifyHomePage() {
        // Test method to verify the functionality of the home page
    }

    @AfterMethod
    public void afterMethod() {
        // Code to be executed after each test method
    }

    @AfterClass
    public void afterClass() {
        // Code to be executed once after all test methods in the class have been run
    }
}

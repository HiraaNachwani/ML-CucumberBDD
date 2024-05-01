package pom.pages;

import basePages.BasePage;

// HomePage class represents the page object for the home page of the application
public class HomePage extends BasePage {

    // Method to verify the title of the home page
    public void verifyHomePageTitle(String title) {
        assertPageTitle(title);
    }
}

package pom.pages;

import basePages.BasePage;
import utilities.AssertFactory;

public class DealsPage extends BasePage {

    /**
     * Verifies the title of the current web page.
     *
     * @param title The expected title of the page
     */
    public void verifyTitleOfPage(String title){
        assertFactory.verifyEquals(title, getPageTitle());
    }
}

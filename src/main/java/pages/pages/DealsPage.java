package pages.pages;

import basePages.BasePage;

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

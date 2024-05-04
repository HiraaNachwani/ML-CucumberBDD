package pages.pages;

import basePages.BasePage;

public class CheckoutPage extends BasePage {

    public void verifyPageTitle(String title){
        assertFactory.verifyEquals(title, getPageTitle());
    }
}

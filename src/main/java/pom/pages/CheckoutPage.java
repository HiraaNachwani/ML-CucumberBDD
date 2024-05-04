package pom.pages;

import basePages.BasePage;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import utilities.AssertFactory;

public class CheckoutPage extends BasePage {

    public void verifyPageTitle(String title){
        assertFactory.verifyEquals(title, getPageTitle());
    }
}

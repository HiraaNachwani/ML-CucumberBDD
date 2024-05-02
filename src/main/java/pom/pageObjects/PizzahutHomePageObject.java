package pom.pageObjects;

/**
 * Class containing locators for elements on the Home page
 */
public class PizzahutHomePageObject {

    // XPath locator for the delivery tab
    public static final String DIV_DELIVERY_TAB = "//div[@data-item-id='tab--delivery']";

    // XPath locator for the location input field
    public static final String INP_LOCATION = "//input[@data-synth='input--google-places']";

    // XPath locator for the first auto-suggested location
    public static final String DIV_FIRST_AUTOSUGGESTIONS = "(//div[@class='typography-4'])[1]";
}

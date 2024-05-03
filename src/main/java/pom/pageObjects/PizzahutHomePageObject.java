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

    public static final String DIV_BLACK_SCREEN = "//div[@aria-label='OfferCollectionOverlay']";

    public static final String BTN_CLOSE_OFFER = "//button[@data-testid='close-offer-collection']";

    public static final String TXT_THIRD_OPTION = "(//p[@data-synth='hut-option-name-distance'])[3]";

    public static final String BTN_START_YOUR_ORDER = "//span[text()='Start your order']";




}

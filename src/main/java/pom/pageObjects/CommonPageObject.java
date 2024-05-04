package pom.pageObjects;

public class CommonPageObject {

    /* Menu BAR ITEMS */

    // INPUT BUTTON to VEGETARIAN OPTION
    public static final String INP_VEGETARIAN = "(//p[text()='Vegetarian']/parent::span/parent::div/parent::div/input)[1]";

    // Link to Pizza Menu in the menu bar
    public static final String LNK_PIZZA_MENU_BAR="//a[@data-synth='link--pizzas--side']";

    // Link to Drinks Menu in the menu bar
    public static final String LNK_DRINKS_MENU_BAR = "//a[@data-synth='link--drinks--side']";

    /* Your Basket ITEMS */

    // Basket Items & products
    public static final String DIV_BASKET_ITEM = "//div[@data-testid='basket-item-product']";

    // Subtotal price in the basket
    public static final String SPN_SUBTOTAL_PRICE = "//span[text()='Subtotal']/parent::span/following-sibling::span";

    // Total Tax price in the basket
    public static final String SPN_TAX_PRICE ="//span[text()='Total Tax']/parent::span/following-sibling::span";

    // Amount payable in the basket
    public static final String SPN_AMOUNT_PAYABLE = "//span[text()='Amount payable']/parent::span/following-sibling::span";

    // Left item count in the checkout link
    public static final String SPN_CHECKOUT_LEFT_ITEM_COUNT ="//div[@class='relative']/a[@data-synth='link--checkout']/span[contains(@class, 'text-left')]/span";

    // Price shown on the right side of the checkout link
    public static final String SPN_CHECKOUT_RIGHT_PRICE ="//div[@class='relative']/a[@data-synth='link--checkout']/span[contains(@class, 'text-right')]/span";

    // Button to remove a specific Margherita item
    public static final String BTN_REMOVE_MARGHERITA ="//button[@data-synth='basket-item-remove--margherita-bestseller-pan-personal']";

    //Button to click on Checkout Basket
    public  static final String BTN_CHECKOUT_BASKET = "//span[text()='Checkout']";
}

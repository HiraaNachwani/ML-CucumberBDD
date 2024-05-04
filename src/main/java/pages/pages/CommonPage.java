package pages.pages;

import basePages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageObjects.CommonPageObject;

public class CommonPage extends BasePage {

    public Double subTotal;
    public Double taxPrice;
    public Double amountPayble;
    public static Double previousAmount;

    // WebElements
    @FindBy(xpath = CommonPageObject.INP_VEGETARIAN)
    WebElement inpVegeratian;

    @FindBy(xpath = CommonPageObject.LNK_PIZZA_MENU_BAR)
    WebElement lnkPizzaMenuBar;

    @FindBy(xpath = CommonPageObject.LNK_DRINKS_MENU_BAR)
    WebElement lnkDrinksMenuBar;

    @FindBy(xpath = CommonPageObject.DIV_BASKET_ITEM)
    WebElement divBasketItem;

    @FindBy(xpath = CommonPageObject.SPN_SUBTOTAL_PRICE)
    WebElement spnSubTotalPrice;

    @FindBy(xpath = CommonPageObject.SPN_TAX_PRICE)
    WebElement spnTaxPrice;

    @FindBy(xpath = CommonPageObject.SPN_AMOUNT_PAYABLE)
    WebElement spnAmountPayable;

    @FindBy(xpath = CommonPageObject.SPN_CHECKOUT_LEFT_ITEM_COUNT)
    WebElement spnCheckoutLeftItemCount;

    @FindBy(xpath = CommonPageObject.SPN_CHECKOUT_RIGHT_PRICE)
    WebElement spnCheckoutRightPrice;

    @FindBy(xpath = CommonPageObject.BTN_REMOVE_MARGHERITA)
    WebElement btnRemoveMargherita;

    @FindBy(xpath = CommonPageObject.BTN_CHECKOUT_BASKET)
    WebElement btnCheckoutBasket;

    // Method to verify the default value of the Vegetarian button
    public void verifyVegeterianButtonDefaultValue() {
        assertFactory.verifyEquals(false, Boolean.parseBoolean(getAttributeValue(inpVegeratian, "value")));
    }

    // Method to click on the Pizza Menu link
    public void clickOnPizzaMenu() {
        clickElement(lnkPizzaMenuBar);
    }

    // Method to click on the Drinks Menu link
    public void clickOnDrinksMenu() {
        clickElement(lnkDrinksMenuBar);
    }

    // Method to verify the visibility of basket items
    public void verifyBasketItems() {
        assertFactory.verifyVisibilityOfElement(divBasketItem);
    }

    // Method to verify the order total summary
    public void verifyOrderTotalSummary() {
        subTotal = Double.parseDouble(getElementText(spnSubTotalPrice).replace("₹", ""));
        taxPrice = Double.parseDouble(getElementText(spnTaxPrice).replace("₹", ""));
        amountPayble = Double.parseDouble(getElementText(spnAmountPayable).replace("₹", ""));
        assertFactory.verifyEquals(subTotal + taxPrice, amountPayble);

        CommonPage.previousAmount = amountPayble;
    }

    public void verifyNewPriceIsGreater() {
        amountPayble = Double.parseDouble(getElementText(spnAmountPayable).replace("₹", ""));
        assertFactory.verifyTrue(amountPayble > CommonPage.previousAmount, "New Price is greater than previous price");

        CommonPage.previousAmount = amountPayble;
    }

    // Method to verify the item count in the checkout link
    public void verifyCheckoutLeftItemCount(String text) {
        assertFactory.verifyEquals(text, getElementText(spnCheckoutLeftItemCount));
    }

    // Method to verify the price in the checkout link
    public void verifyCheckoutRightPrice() {
        assertFactory.verifyEquals(CommonPage.previousAmount, Double.parseDouble(getElementText(spnCheckoutRightPrice).replace("₹", "")));
    }

    // Method to click on the "Remove Margherita Pizza" button
    public void clickOnRemoveMargheritaPizza() {
        clickElement(btnRemoveMargherita);
    }

    //Method to click on the Checkout Basket button
    public void clickOnCheckoutButton(){
        clickElement(btnCheckoutBasket);
    }
}

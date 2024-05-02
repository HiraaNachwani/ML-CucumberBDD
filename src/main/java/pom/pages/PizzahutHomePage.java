package pom.pages;

import basePages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.pageObjects.PizzahutHomePageObject;
import utilities.WebDriverWaitUtils;

/**
 * Page class for the Pizza Hut home page
 */
public class PizzahutHomePage extends BasePage {

    // WebElements
    @FindBy(xpath = PizzahutHomePageObject.DIV_DELIVERY_TAB)
    WebElement divDeliveryTab;

    @FindBy(xpath = PizzahutHomePageObject.INP_LOCATION)
    WebElement inpLocation;

    @FindBy(xpath = PizzahutHomePageObject.DIV_FIRST_AUTOSUGGESTIONS)
    WebElement divFirstAutosuggestions;

    // Method to verify if the delivery tab is visible
    public void verifyDeliveryTabIsVisible() {
        verifyVisibilityOfElement(divDeliveryTab);
    }

    // Method to set the location in the input field
    public void setLocation(String location) {
        enterText(inpLocation, location);
    }

    // Method to click the first auto-suggestion
    public void clickFirstAutoSuggestion() {
        WebDriverWaitUtils.waitForElementClickable(divFirstAutosuggestions, 5);
        clickElement(divFirstAutosuggestions);
    }
}

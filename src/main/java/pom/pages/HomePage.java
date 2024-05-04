package pom.pages;

import basePages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.pageObjects.HomePageObject;
import utilities.AssertFactory;
import utilities.WebDriverWaitUtils;

/**
 * Page class for the Pizza Hut home page
 */
public class HomePage extends BasePage {

    // WebElements
    @FindBy(xpath = HomePageObject.DIV_DELIVERY_TAB)
    WebElement divDeliveryTab;

    @FindBy(xpath = HomePageObject.INP_LOCATION)
    WebElement inpLocation;

    @FindBy(xpath = HomePageObject.DIV_FIRST_AUTOSUGGESTIONS)
    WebElement divFirstAutosuggestions;

    @FindBy(xpath = HomePageObject.DIV_BLACK_SCREEN)
    WebElement divBlackScreen;

    @FindBy(xpath = HomePageObject.BTN_CLOSE_OFFER)
    WebElement btnCloseOffer;

    @FindBy(xpath = HomePageObject.TXT_THIRD_OPTION)
    WebElement txtThirdOption;

    @FindBy(xpath = HomePageObject.BTN_START_YOUR_ORDER)
    WebElement btnStartYourOrder;

    // Method to verify if the delivery tab is visible
    public void verifyDeliveryTabIsVisible() {
        assertFactory.verifyVisibilityOfElement(divDeliveryTab); // Verifies if the delivery tab is visible
    }

    // Method to set the location in the input field
    public void setLocation(String location) {
        enterText(inpLocation, location); // Sets the location in the input field
    }

    // Method to click the first auto-suggestion
    public void clickFirstAutoSuggestion() {
        WebDriverWaitUtils.waitForElementClickable(divFirstAutosuggestions, 5); // Waits for the first auto-suggestion to be clickable
        clickElement(divFirstAutosuggestions); // Clicks the first auto-suggestion
    }

    // Method to verify the presence of the black overlay screen
    public void verifyBlackOverlayScreen(){
        WebDriverWaitUtils.waitForElementVisible(divBlackScreen, 10); // Waits for the black overlay screen to be visible
    }

    // Method to click the close button of the offer collection
    public void clickCloseOfferButton(){
        clickElement(btnCloseOffer); // Clicks the close button of the offer collection
    }

    // Method to click the third nearest Hut option
    public void clickThirdNearestHut(){
        clickElement(txtThirdOption); // Clicks the third nearest Hut option
    }

    // Method to click the "Start your order" button
    public void clickStartYourOrder(){
        clickElement(btnStartYourOrder); // Clicks the "Start your order" button
    }
}

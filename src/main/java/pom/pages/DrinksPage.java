package pom.pages;

import basePages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.pageObjects.DrinksPageObject;

public class DrinksPage extends BasePage {

    // WebElements
    @FindBy(xpath = DrinksPageObject.BTN_ADD_PEPSI)
    WebElement btnAddPepsi;

    // Method to click the "Add Pepsi" button
    public void clickAddPepsi() {
        clickElement(btnAddPepsi);
    }
}

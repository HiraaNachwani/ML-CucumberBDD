package pom.pages;

import basePages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.pageObjects.PizzasPageObject;

public class PizzasPage extends BasePage {

    // WebElements
    @FindBy(xpath = PizzasPageObject.BTN_ADD_MARGHERITA)
    WebElement btnAddMargherita;

    // Method to click the "Add Margherita" button
    public void clickAddMargherita() {
        clickElement(btnAddMargherita);
    }
}

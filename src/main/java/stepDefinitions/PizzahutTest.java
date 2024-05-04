package stepDefinitions;

import basePages.BaseTest;
import constants.ExcelSheetConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.pages.*;

import java.util.Map;

/**
 * Step definitions for Pizza Hut application tests.
 */
public class PizzahutTest extends BaseTest {

    // Declare page objects
    HomePage homePage;
    CommonPage commonPage;
    DealsPage dealsPage;
    DrinksPage drinksPage;
    PizzasPage pizzasPage;
    CheckoutPage checkoutPage;
    Map<String, Map<String, Object>> checkOutPageData;
    Map<String, Map<String, Object>> commonPageData;
    Map<String, Map<String, Object>> dealsPageData;

    /**
     * Constructor to initialize page objects.
     */
    public PizzahutTest() {
        this.homePage = initPage(HomePage.class);
        this.commonPage = initPage(CommonPage.class);
        this.dealsPage = initPage(DealsPage.class);
        this.drinksPage = initPage(DrinksPage.class);
        this.pizzasPage = initPage(PizzasPage.class);
        this.checkoutPage = initPage(CheckoutPage.class);
        this.commonPageData = CucumberHooksTest.excelDataMap.get(ExcelSheetConstants.COMMON_PAGE);
        this.dealsPageData = CucumberHooksTest.excelDataMap.get(ExcelSheetConstants.DEALS_PAGE);
        this.checkOutPageData = CucumberHooksTest.excelDataMap.get(ExcelSheetConstants.CHECKOUT_PAGE);
    }

    // Step Definitions

    // Step 1: Given User launch Pizzahut application with {string}
    @Given("User launch Pizzahut application with {string}")
    public void user_launch_pizzahut_application_with(String string) {
        openApplication(string);
    }

    // Step 2: Then User see pop up for delivery asking for enter location
    @Then("User see pop up for delivery asking for enter location")
    public void user_see_pop_up_for_delivery_asking_for_enter_location() {
        homePage.verifyDeliveryTabIsVisible();
    }

    // Step 3: And User type address as {string}
    @And("User type address as {string}")
    public void user_type_address_as(String string) {
        homePage.setLocation(string);
    }

    // Step 4: Then User select first auto populate drop down option
    @Then("User select first auto populate drop down option")
    public void user_select_first_auto_populate_drop_down_option() {
        homePage.clickFirstAutoSuggestion();
    }

    // Step 5: And User wait for auto location black pop up screen
    @And("User wait for auto location black pop up screen")
    public void user_wait_for_auto_location_black_pop_up_screen() {
        homePage.verifyBlackOverlayScreen();
    }

    // Step 6: Then User close the pop up screen
    @Then("User close the pop up screen")
    public void user_close_the_pop_up_screen() {
        homePage.clickCloseOfferButton();
    }

    // Step 7: And User select third option from nearby Hut
    @And("User select third option from nearby Hut")
    public void user_select_third_option_from_nearby_hut() {
        homePage.clickThirdNearestHut();

//      Below Statement is required if we execute suite in morning hours before stores openining hours
//     homePage.clickStartYourOrder();
    }

    // Step 8: Then User navigate to deals page
    @Then("User navigate to deals page")
    public void user_navigate_to_deals_page() {
        dealsPage.verifyTitleOfPage((String) dealsPageData.get("pageTitle").get("Value1"));
    }

    // Step 9: Then User validate vegetarian radio button flag is off
    @Then("User validate vegetarian radio button flag is off")
    public void user_validate_vegetarian_radio_button_flag_is_off() {
        commonPage.verifyVegeterianButtonDefaultValue();
    }

    // Step 10: Then User clicks on Pizzas menu bar option
    @Then("User clicks on Pizzas menu bar option")
    public void user_clicks_on_pizzas_menu_bar_option() {
        commonPage.clickOnPizzaMenu();
    }

    // Step 11: When User select add button of any pizza from Recommended
    @When("User select add button of any pizza from Recommended")
    public void user_select_add_button_of_any_pizza_from_recommended() {
        pizzasPage.clickAddMargherita();
    }

    // Step 12: Then User see that the pizza is getting added under Your Basket
    @Then("User see that the pizza is getting added under Your Basket")
    public void user_see_that_the_pizza_is_getting_added_under_your_basket() {
        commonPage.verifyBasketItems();
    }

    // Step 13: Then User validate pizza price plus Tax in checkout price
    @Then("User validate pizza price plus Tax in checkout price")
    public void user_validate_pizza_price_plus_tax_in_checkout_price() {
        commonPage.verifyOrderTotalSummary();
    }

    // Step 14: Then User validate checkout button contains Item count
    @Then("User validate checkout button contains Item count")
    public void user_validate_checkout_button_contains_item_count() {
        commonPage.verifyCheckoutLeftItemCount((String) commonPageData.get("itemCount").get("Value1"));
    }

    // Step 15: Then User validate checkout button contains total price count
    @Then("User validate checkout button contains total price count")
    public void user_validate_checkout_button_contains_total_price_count() {
        commonPage.verifyCheckoutRightPrice();
    }

    // Step 16: Then User clicks on Drinks option
    @Then("User clicks on Drinks option")
    public void user_clicks_on_drinks_option() {
        commonPage.clickOnDrinksMenu();
    }

    // Step 17: Then User select Pepsi option to add into the Basket
    @Then("User select Pepsi option to add into the Basket")
    public void user_select_pepsi_option_to_add_into_the_basket() {
        drinksPage.clickAddPepsi();
    }

    // Step 18: Then User see {string} are showing under checkout button
    @Then("User see {string} are showing under checkout button")
    public void user_see_items_are_showing_under_checkout_button(String itemCount) {
        commonPage.verifyCheckoutLeftItemCount(itemCount);
    }

    // Step 19: Then User see total price is now more than before
    @Then("User see total price is now more than before")
    public void user_see_total_price_is_now_more_than_before() {
        commonPage.verifyNewPriceIsGreater();
    }

    // Step 20: Then User remove the Pizza item from Basket
    @Then("User remove the Pizza item from Basket")
    public void user_remove_the_pizza_item_from_basket() {
        commonPage.clickOnRemoveMargheritaPizza();
    }

    // Step 21: Then User see {string} showing in checkout button
    @Then("User see {string} showing in checkout button")
    public void user_see_item_showing_in_checkout_button(String itemCount) {
        commonPage.verifyCheckoutLeftItemCount(itemCount);
    }

    // Step 22: Then User Clicks on Checkout button
    @Then("User Clicks on Checkout button")
    public void user_clicks_on_checkout_button() {
        commonPage.clickOnCheckoutButton();
    }

    // Step 23: Then User navigate to Checkout Page and verifies title.
    @Then("User navigate to Checkout Page and verifies title.")
    public void user_navigate_to_checkout_page_and_verifies_title() {
        checkoutPage.verifyPageTitle((String)checkOutPageData.get("pageTitle").get("Value1"));
    }
}

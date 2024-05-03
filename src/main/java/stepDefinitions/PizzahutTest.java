package stepDefinitions;

import basePages.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import pom.pages.PizzahutHomePage;

public class PizzahutTest extends BaseTest {

    PizzahutHomePage pizzahutHomePage;

    public PizzahutTest() {

        this.pizzahutHomePage = initPage(PizzahutHomePage.class);
    }

    @Given("User launch Pizzahut application with {string}")
    public void user_launch_pizzahut_application_with(String string) {
        openApplication(string);
    }

    @Then("User see pop up for delivery asking for enter location")
    public void user_see_pop_up_for_delivery_asking_for_enter_location() {
        pizzahutHomePage.verifyDeliveryTabIsVisible();
    }

    @And("User type address as {string}")
    public void user_type_address_as(String string) {
        pizzahutHomePage.setLocation(string);
    }

    @Then("User select first auto populate drop down option")
    public void user_select_first_auto_populate_drop_down_option() {
        pizzahutHomePage.clickFirstAutoSuggestion();
    }

    @And("User wait for auto location black pop up screen")
    public void user_wait_for_auto_location_black_pop_up_screen() {
        pizzahutHomePage.verifyBlackOverlayScreen();
    }

    @Then("User close the pop up screen")
    public void user_close_the_pop_up_screen() {
        pizzahutHomePage.clickCloseOfferButton();
    }

    @And("User select third option from nearby Hut")
    public void user_select_third_option_from_nearby_hut() {
        pizzahutHomePage.clickThirdNearestHut();
        pizzahutHomePage.clickStartYourOrder();
    }

    @Then("User navigate to deals page")
    public void user_navigate_to_deals_page() {

    }

    @Then("User validate vegetarian radio button flag is off")
    public void user_validate_vegetarian_radio_button_flag_is_off() throws InterruptedException {
        Thread.sleep(10000);

    }


}

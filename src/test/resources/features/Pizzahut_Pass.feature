Feature: Verify Pizza Hut Functionality - Passed

  @Smoke
  Scenario Outline: Validate Pizzahut pizza order flow - passed
    Given User launch Pizzahut application with "<URL>"
    When User see pop up for delivery asking for enter location
    Then User type address as "<Location>"
    And User select first auto populate drop down option
    And User wait for auto location black pop up screen
    Then User close the pop up screen
    When User type address as "<Location>"
    And User select first auto populate drop down option
    And User select third option from nearby Hut
    Then User navigate to deals page
    Then User validate vegetarian radio button flag is off
    And User clicks on Pizzas menu bar option
    When User select add button of any pizza from Recommended
    Then User see that the pizza is getting added under Your Basket
    And User validate pizza price plus Tax in checkout price
    Then User validate checkout button contains Item count
    And User validate checkout button contains total price count
    Then User clicks on Drinks option
    And User select Pepsi option to add into the Basket
    Then User see "2 items" are showing under checkout button
    And User see total price is now more than before
    Then User remove the Pizza item from Basket
    And User see "1 item" showing in checkout button
    Then User Clicks on Checkout button
    And User navigate to Checkout Page and verifies title.

    Examples:
      | URL                         | Location            |
      | https://www.pizzahut.co.in/ | lulu mall bangalore |
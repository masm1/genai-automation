Feature: Products page validation

  Background:
    Given User is logged in

  @regression
  Scenario: Verify products page loads
    Then Products page title should be displayed

  Scenario: Add product to cart
    When User adds backpack to cart
    Then Remove button should be displayed

  Scenario: Remove product from cart
    When User adds backpack to cart
    And User removes backpack from cart
    Then Remove button should not be displayed

  Scenario: Sort products by price low to high
    When User sorts products by "Price (low to high)"
    Then First product price should be lowest
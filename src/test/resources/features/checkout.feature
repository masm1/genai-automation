Feature: Checkout functionality

  Background:
    Given User has added product to cart

  Scenario: Complete successful checkout
    When User enters first name "Sumit" last name "QA" and postal code "201301"
    And User completes checkout
    Then Order confirmation message should be displayed

  Scenario: Checkout without first name
    When User enters first name "" last name "QA" and postal code "201301"
    Then Error message should be shown
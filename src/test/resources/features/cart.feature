Feature: Cart functionality

  Background:
    Given User is logged in

  Scenario: Verify item appears in cart
    When User adds backpack to cart
    And User clicks on cart icon
    Then Product should be visible in cart
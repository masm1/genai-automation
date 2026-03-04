Feature: Login functionality

  @smoke
  Scenario: Valid login
    Given User is on login page
    When User enters username "standard_user" and password "secret_sauce"
    And User clicks login button
    Then User should land on products page

  @negative
  Scenario: Invalid login
    Given User is on login page
    When User enters username "invalid_user" and password "wrong_password"
    And User clicks login button
    Then Error message should be displayed
Feature: Logout functionality

  Background:
    Given User is logged in

  Scenario: Verify logout
    When User clicks logout
    Then User should be redirected to login page
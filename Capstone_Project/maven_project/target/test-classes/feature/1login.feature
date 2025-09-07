Feature: Login functionality

  Scenario: User logs in successfully
    Given the user is on the login page
    When the user logs in with valid credentials
    Then the user should be logged in successfully

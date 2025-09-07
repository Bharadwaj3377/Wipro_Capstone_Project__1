Feature: Logout

  Scenario: User logs out
    Given user is logged to site
    When user logs out
    Then user should be redirected to login page

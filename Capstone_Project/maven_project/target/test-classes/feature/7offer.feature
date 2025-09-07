Feature: Offers

  Scenario: User checks offers
    Given user is logged to page
    When user navigates to offers
    Then offers should be displayed

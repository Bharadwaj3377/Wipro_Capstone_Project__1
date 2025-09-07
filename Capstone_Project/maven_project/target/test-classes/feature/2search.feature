Feature: Product Search

  Scenario: User searches for a product
    Given user is logged in
    When user searches for "iphone"
    Then relevant products should be displayed

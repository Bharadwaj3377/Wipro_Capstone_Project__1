Feature: Product Search

  Scenario Outline: User searches for a product
    Given user is logged in
    When user searches for "<product>"
    Then relevant products should be displayed

  Examples:
    | product |
    | iphone  |
    | laptop  |
    | speaker |

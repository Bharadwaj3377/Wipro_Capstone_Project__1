Feature: Product Filters

  Scenario: User applies filters
    Given user is logged to filters
    When user applies brand and price filters
    Then filtered products should be displayed

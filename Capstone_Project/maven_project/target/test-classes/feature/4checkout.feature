Feature: Checkout

  Scenario: User checks out a product
    Given user is logged in for product
    When user proceeds to checkout
    Then checkout page should be displayed

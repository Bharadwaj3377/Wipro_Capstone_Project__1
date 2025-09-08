Feature: Cart Management

  Scenario: User adds and removes product from cart
    Given user is logged to
    When user adds and removes a product from the cart
    Then cart should be updated

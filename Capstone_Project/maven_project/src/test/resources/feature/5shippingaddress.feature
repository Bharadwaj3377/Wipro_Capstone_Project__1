Feature: Shipping Address

  Scenario: User enters shipping details
    Given user is on shipping address page
    When user enters shipping details
      | FirstName | John   |
      | LastName  | Doe    |
      | Address   | 123 Main St |
      | State     | CA     |
      | Pincode   | 90001  |
    Then order summary should be displayed

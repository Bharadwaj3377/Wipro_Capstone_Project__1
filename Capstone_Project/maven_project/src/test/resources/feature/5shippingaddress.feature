Feature: Shipping Address

  Scenario Outline: User enters shipping details
    Given user is on shipping address page
    When user enters "<FirstName>", "<LastName>", "<Address>", "<State>", "<Pincode>"
    Then order summary should be displayed

  Examples:
    | FirstName | LastName | Address       | State | Pincode |
    | John      | Doe      | 123 Main St   | CA    | 90001   |
    | Alice     | Smith    | 456 Market Rd | NY    | 10001   |
    | Bob       | Brown    | 789 Lake Ave  | TX    | 73301   |

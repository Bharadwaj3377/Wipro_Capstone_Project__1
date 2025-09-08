Feature: Brand Shopping

  Scenario: User shops by brand
    Given the user is logged to the page
    When the user applies brand filter
    Then products from the selected brand should be displayed

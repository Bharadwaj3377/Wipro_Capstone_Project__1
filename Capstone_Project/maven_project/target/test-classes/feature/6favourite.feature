Feature: Favourites

  Scenario: User manages favourites
    Given user is logged in website 
    When user adds and views favourites
    Then favourites should be displayed

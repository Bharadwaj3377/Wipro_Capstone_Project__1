Feature: Multiple Login Methods

  Scenario Outline: User logs in using different login methods
    Given the user is on the login page
    When the user chooses "<loginMethod>"
    Then the user should be logged in successfully

  Examples:
    | loginMethod |
    | login_1     |
    | login_2     |
    | login_3     |
    | login_4     |
    | login_5     |

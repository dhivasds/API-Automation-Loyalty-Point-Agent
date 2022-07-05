Feature: Claim Daily Login
  As a user
  I want to able claim daily login
  So that i can claim daily login

  Scenario Outline: Claim Daily Login Functionality
    Given I set an endpoint for daily login
    When I request "<input>" POST daily login
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after claim daily login
    Examples:
      | input | sCode | message |
      | validToken    | 201 | ClaimDailyLogin   |
      | invalidToken  | 401 | Unauthorized      |


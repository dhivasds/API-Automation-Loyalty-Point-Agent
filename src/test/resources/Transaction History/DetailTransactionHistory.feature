Feature: Detail Transaction History
  As a user
  I want to able see transaction history
  So that i can see detail transaction history

  Scenario Outline: Detail Transaction History Functionality
    Given I set an endpoint for detail transaction history
    When I request "<input>" GET transaction history
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after get detail transaction history
    Examples:
      | input | sCode | message |
      | validToken    | 201 | DetailTransaction  |
      | invalidToken  | 401 | Unauthorized       |


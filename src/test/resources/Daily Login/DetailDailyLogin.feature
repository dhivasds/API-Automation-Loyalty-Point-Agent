Feature: Detail Daily Login
  As a user
  I want to able see daily login
  So that i can see detail daily login

  Scenario Outline: Detail Daily Login Functionality
    Given I set an endpoint for detail daily login
    When I request "<input>" GET daily login
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after get detail daily login
    Examples:
      | input | sCode | message |
      | validToken    | 200 | DetailDailyLogin   |
      | invalidToken  | 401 | Unauthorized       |


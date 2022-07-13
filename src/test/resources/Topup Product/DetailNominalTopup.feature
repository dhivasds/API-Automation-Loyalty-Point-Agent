Feature: Detail Nominal Top up
  As a user
  I want to able see nominal topup
  So that i can see detail nominal topup

  Scenario Outline: Detail Nominal Top up Functionality
    Given I set an endpoint for detail Top up
    When I request "<input>" GET detail top up
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after get detail top up
    Examples:
      | input | sCode | message |
      | validToken    | 200 | getDetailTopup  |
      | invalidToken  | 401 | unauthorized    |


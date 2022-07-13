Feature: Delete Nominal Top up
  As a Admin
  I want to delete nominal top up
  So that i can delete nominal top up

  Scenario Outline: Delete Nominal Top up Functionality
    Given I set an endpoint for delete nominal top up
    When I request "<input>" DELETE nominal top up
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after delete nominal top up
    Examples:
      | input | sCode | message |
      | validToken    | 201 | DeleteTopup   |
      | invalidToken  | 401 | Unauthorized  |
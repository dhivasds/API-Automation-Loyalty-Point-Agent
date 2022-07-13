Feature: Top up Bank Transfer
  As a user
  I want to top up Bank Transfer
  So that i success to top up Bank Transfer

  Scenario Outline: Top up Bank Transfer Functionality
    Given I set an endpoint for add Top up Bank Transfer
    When I request "<input>" POST add top up Bank Transfer
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after add top up Bank Transfer
    Examples:
      | input | sCode | message |
      | validToken    | 201 | CreateTransaction |
      | invalidToken  | 401 | Unauthorized      |
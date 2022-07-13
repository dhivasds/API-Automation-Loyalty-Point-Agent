Feature: Add Nominal Top up
  As a admin
  I want to able to add nominal top up
  So that i can add nominal top up

  Scenario Outline: Add Nominal Top up Functionality
    Given I set an endpoint for add Top up
    When I request "<input>" POST add top up
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after add top up
    Examples:
      | input | sCode | message |
      | validToken            | 201 | AddTopupProduct     |
      | invalidToken          | 401 | Unauthorized        |
      | inputNullAmount       | 400 | AmountRequired      |
      | inputNullGrossAmount  | 400 | GrossAmountRequired  |

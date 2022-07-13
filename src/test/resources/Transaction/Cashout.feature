Feature: Cashout
  As a user
  I want to cashout
  So that i success to cashout

  Scenario Outline: Quota Functionality
    Given I set an endpoint for cashout
    When I request "<input>" POST cashout
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after cashout
    Examples:
      | input | sCode | message |
      | inputValidCashout      | 201 | CashoutSuccess |
      | inputInvalidProduct    | 400 | ProductNotFound |
      | inputInvalidToken      | 401 | Unauthorized    |

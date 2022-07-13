Feature: Pulsa
  As a user
  I want to buy pulsa
  So that i success to buy pulsa

  Scenario Outline: Pulsa Functionality
    Given I set an endpoint for buy pulsa
    When I request "<input>" POST pulsa
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after buy pulsa
    Examples:
      | input | sCode | message |
      | inputValidPulsa      | 201 | BuyPulsaSuccess |
      | inputInvalidProduct  | 400 | ProductNotFound |
      | inputEmptyStock      | 400 | ProductEmpty    |
      | inputInvalidToken    | 401 | Unauthorized    |

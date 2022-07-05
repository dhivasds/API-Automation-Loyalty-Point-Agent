Feature: Quota
  As a user
  I want to buy quota
  So that i success to buy quota

  Scenario Outline: Quota Functionality
    Given I set an endpoint for buy quota
    When I request "<input>" POST quota
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after buy quota
    Examples:
      | input | sCode | message |
      | inputValidQuota      | 201 | BuyQuotaSuccess |
      | inputInvalidProduct  | 400 | ProductNotFound |
      | inputEmptyStock      | 400 | ProductEmpty    |
      | inputInvalidToken    | 401 | Unauthorized    |

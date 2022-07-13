Feature: Add Quota Product
  As a admin
  I want to add quota product
  So that i can to add quota product

  Scenario Outline: Add Quota Product Functionality
    Given I set an endpoint for add quota product
    When I request "<input>" POST quota product
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after add quota product
    Examples:
      | input | sCode | message |
      | inputValidQuota         | 201 | AddQuotaSuccess     |
      | inputInvalidProviderId  | 400 | ProviderNotFound    |
      | inputInvalidStock       | 400 | StockAtLeast        |
      | inputNullProvider       | 400 | ProviderIdRequired  |
      | inputNullGrossAmount    | 400 | GrossAmountRequired |
      | inputNullStock          | 400 | StockRequired       |

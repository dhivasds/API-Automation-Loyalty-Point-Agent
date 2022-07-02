Feature: Update Quota Product
  As a admin
  I want to update quota product
  So that i can to update quota product

  Scenario Outline: Quota Product Functionality
    Given I set an endpoint for update quota product
    When I request "<input>" PUT quota product
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after update quota product
    Examples:
      | input | sCode | message |
      | inputValidUpdateQuota   | 201 | UpdateQuotaSuccess  |
      | inputInvalidProviderId  | 400 | ProviderNotFound    |
      | inputInvalidStock       | 400 | StockAtLeast        |
      | inputNullProvider       | 400 | ProviderIdRequired  |
      | inputNullGrossAmount    | 400 | GrossAmountRequired |
      | inputNullStock          | 400 | StockRequired       |

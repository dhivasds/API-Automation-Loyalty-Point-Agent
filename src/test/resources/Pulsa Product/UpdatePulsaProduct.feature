Feature: Update Pulsa Product
  As a admin
  I want to update pulsa product
  So that i can to update pulsa product

  Scenario Outline: Update Quota Product Functionality
    Given I set an endpoint for update pulsa product
    When I request "<input>" PUT pulsa product
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after update pulsa product
    Examples:
      | input | sCode | message |
      | inputValidPulsa         | 201 | UpdatePulsaSuccess  |
      | inputInvalidProviderId  | 400 | ProviderNotFound    |
      | inputInvalidStock       | 400 | StockAtLeast        |
      | inputNullProvider       | 400 | ProviderIdRequired  |
      | inputNullDenom          | 400 | DenomRequired       |
      | inputNullGrossAmount    | 400 | GrossAmountRequired |
      | inputNullStock          | 400 | StockRequired       |

Feature: Add Pulsa Product
  As a admin
  I want to add pulsa product
  So that i can to add pulsa product

  Scenario Outline: Add Pulsa Product Functionality
    Given I set an endpoint for add pulsa product
    When I request "<input>" POST pulsa product
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after add pulsa product
    Examples:
      | input | sCode | message |
      | inputValidPulsa         | 201 | AddPulsaSuccess     |
      | inputInvalidProviderId  | 400 | ProviderNotFound    |
      | inputInvalidStock       | 400 | StockAtLeast        |
      | inputNullProvider       | 400 | ProviderIdRequired  |
      | inputNullDenom          | 400 | DenomRequired       |
      | inputNullGrossAmount    | 400 | GrossAmountRequired |
      | inputNullStock          | 400 | StockRequired       |

#Feature: Add Quota Product
#  As a admin
#  I want to add quota product
#  So that i can to add quota product
#
#  Scenario Outline: Quota Product Functionality
#    Given I set an endpoint for add quota product
#    When I request "<input>" POST quota product
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after add quota product
#    Examples:
#      | input | sCode | message |
#      | inputValidToken   | 201 | AddQuotaSuccess    |
#      | inputValidToken   | 400 | ProviderNotFound   |
#      | InputValidToken   | 400 | StockAtLeast       |
#      | InputValidToken   | 400 | NullProvider       |
#      | InputValidToken   | 400 | NullGrossAmount    |
#      | InputValidToken   | 400 | NullStock          |

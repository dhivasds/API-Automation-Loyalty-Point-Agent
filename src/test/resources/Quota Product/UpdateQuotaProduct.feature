#Feature: Update Quota Product
#  As a admin
#  I want to update quota product
#  So that i can to update quota product
#
#  Scenario Outline: Quota Product Functionality
#    Given I set an endpoint for update quota product
#    When I request "<input>" PUT quota product
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after update quota product
#    Examples:
#      | input | sCode | message |
#      | inputValidToken   | 201 | UpdateQuotaSuccess |
#      | inputValidToken   | 400 | ProviderNotFound   |
#      | InputValidToken   | 400 | StockAtLeast       |
#      | InputValidToken   | 400 | NullProvider       |
#      | InputValidToken   | 400 | NullGrossAmount    |
#      | InputValidToken   | 400 | NullStock          |

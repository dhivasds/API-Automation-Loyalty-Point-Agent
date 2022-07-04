#Feature: Detail Quota Product
#  As a user
#  I want to see all quota product
#  So that i can see the quota product
#
#  Scenario Outline: Detail Quota Product Functionality
#    Given I set an endpoint for quota product
#    When I request "<input>" GET quota product
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after get detail quota product
#    Examples:
#      | input | sCode | message |
#      | inputValidToken   | 200 | DetailQuotaProduct |
#      | inputInvalidToken | 401 | Unauthorized       |
#

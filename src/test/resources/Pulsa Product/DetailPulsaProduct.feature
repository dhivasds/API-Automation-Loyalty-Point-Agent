#Feature: Detail Pulsa Product
#  As a user
#  I want to see all pulsa product
#  So that i can see the pulsa product
#
#  Scenario Outline: Detail Pulsa Product Functionality
#    Given I set an endpoint for pulsa product
#    When I request "<input>" GET pulsa product
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after get detail pulsa product
#    Examples:
#      | input | sCode | message |
#      | inputValidToken   | 200 | DetailPulsaProduct |
#      | inputInvalidToken | 401 | Unauthorized       |
#

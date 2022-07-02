#Feature: Detail Provider
#  As a user
#  I want to see all provider
#  So that i can see the all provider
#
#  Scenario Outline: Provider Functionality
#    Given I set an endpoint for provider
#    When I request "<input>" GET provider
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after get detail provider
#    Examples:
#      | input | sCode | message |
#      | inputValidToken   | 200 | DetailProvider |
#      | inputInvalidToken | 401 | unauthorized   |
#

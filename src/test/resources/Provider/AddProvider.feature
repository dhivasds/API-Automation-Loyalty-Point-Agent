#Feature: Add Provider
#  As a admin
#  I want to add provider
#  So that i can to add provider
#
#  Scenario Outline: Provider Functionality
#    Given I set an endpoint for add provider
#    When I request "<input>" POST provider
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after add provider
#    Examples:
#      | input | sCode | message |
#      | inputValidToken   | 201 | AddProviderSuccess |
#      | inputInvalidToken | 401 | Unauthorized       |
#      | inputNullName     | 400 | NameRequired       |

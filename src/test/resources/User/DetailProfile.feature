#Feature: Detail Account
#  As a user
#  I want to able get detail account
#  So that i can see detail my account
#
#  Scenario Outline: Detail Account Functionality
#    Given I set an endpoint for user
#    When I request "<input>" GET user
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after get detail account
#    Examples:
#      | input | sCode | message |
#      | inputValidToken   | 200 | getDetailAccount |
#      | inputInvalidToken | 401 | unauthorized     |

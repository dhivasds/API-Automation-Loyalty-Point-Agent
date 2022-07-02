#Feature: Update User
#  As a user
#  I want to able update data in my account
#  So that i can change data in my account
#
#  Scenario Outline: Update User Functionality
#    Given I set an endpoint for user update
#    When I request "<input>" POST user
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after update user
#    Examples:
#      | input | sCode | message |
#      | inputValidToken   | 201 | updateSuccess |
#      | inputInvalidToken | 401 | unauthorized  |
#      | inputEmailExist   | 400 | emailExist    |

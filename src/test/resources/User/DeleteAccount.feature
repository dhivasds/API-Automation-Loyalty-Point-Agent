#Feature: Delete User
#  As a user
#  I want to able delete my account
#  So that i can delete my account
#
#  Scenario Outline: Delete User Functionality
#    Given I set an endpoint for delete user
#    When I request "<input>" DELETE user
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after delete account
#    Examples:
#      | input | sCode | message |
#      | validToken   | 201  | DeleteSuccess |
#      | invalidToken | 401  | Unauthorized  |
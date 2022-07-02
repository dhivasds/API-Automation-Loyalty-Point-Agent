#Feature: Delete Provider
#  As a Admin
#  I want to delete provider
#  So that i can delete provider
#
#  Scenario Outline: Delete Nominal Provider Functionality
#    Given I set an endpoint for delete provider
#    When I request "<input>" DELETE provider
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after delete provider
#    Examples:
#      | input | sCode | message |
#      | validToken    | 201 | DeleteProvider   |
#      | invalidToken  | 401 | Unauthorized  |
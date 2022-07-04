#Feature: Delete Pulsa Product
#  As a Admin
#  I want to delete pulsa product
#  So that i can delete pulsa product
#
#  Scenario Outline: Delete Nominal Provider Functionality
#    Given I set an endpoint for delete pulsa product
#    When I request "<input>" DELETE pulsa product
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after delete pulsa product
#    Examples:
#      | input | sCode | message |
#      | validToken    | 201 | DeletePulsaProduct   |
#      | invalidToken  | 401 | Unauthorized         |
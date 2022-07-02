#Feature: Top up Gopay
#  As a user
#  I want to top up Gopay
#  So that i success to top up Gopay
#
#  Scenario Outline: Top up Gopay Functionality
#    Given I set an endpoint for add Top up Gopay
#    When I request "<input>" POST add top up Gopay
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after add top up Gopay
#    Examples:
#      | input | sCode | message |
#      | validToken    | 201 | CreateTransaction |
#      | invalidToken  | 401 | Unauthorized      |
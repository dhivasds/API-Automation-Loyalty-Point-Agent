Feature: Delete Quota Product
  As a Admin
  I want to delete quota product
  So that i can delete quota product

  Scenario Outline: Delete Nominal Provider Functionality
    Given I set an endpoint for delete quota product
    When I request "<input>" DELETE quota product
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after delete quota product
    Examples:
      | input | sCode | message |
#      | validToken    | 201 | DeleteProvider   |
      | invalidToken  | 401 | Unauthorized     |
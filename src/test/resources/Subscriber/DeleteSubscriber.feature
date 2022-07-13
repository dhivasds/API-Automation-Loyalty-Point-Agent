Feature: Delete Subscriber
  As a Admin
  I want to delete subscriber
  So that i can delete subscriber

  Scenario Outline: Delete Subscriber Functionality
    Given I set an endpoint for delete subscriber
    When I request "<input>" DELETE subscriber
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after delete subscriber
    Examples:
      | input | sCode | message |
      | emailHasSubscribe  | 201 | DeleteSubsSuccess  |
      | emailNotSubscribe  | 400 | SubscriberNotFound |
      | invalidToken       | 401 | Unauthorized       |
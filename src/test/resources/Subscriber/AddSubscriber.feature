Feature: Add Subscriber
  As a user
  I want to add subscriber
  So that i can to add subscriber

  Scenario Outline: Add Subscriber Functionality
    Given I set an endpoint for add subscriber
    When I request "<input>" POST subscriber
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after add subscriber
    Examples:
      | input | sCode | message |
      | InputRandomEmail  | 201 | AddSubscriberSuccess  |
      | InputEmailExist   | 400 | EmailHasSubscriber    |
      | InputInvalidEmail | 400 | InvalidEmail          |
      | InputNullEmail    | 400 | EmailRequired         |
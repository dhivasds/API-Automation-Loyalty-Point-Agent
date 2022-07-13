Feature: Detail Subscribers
  As a admin
  I want to see all subscribers
  So that i can see the subscribers

  Scenario Outline: Detail Subscriber Functionality
    Given I set an endpoint for subscribers
    When I request "<input>" GET subscribers
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after get detail subscribers
    Examples:
      | input | sCode | message |
      | validToken        | 200 | DetailSubscriber  |
      | inputInvalidToken | 401 | Unauthorized      |
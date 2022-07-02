#Feature: Update Password
#  As a user
#  I want to able update password in my account
#  So that i can to update my password
#
#  Scenario Outline: Update Password Functionality
#    Given I set an endpoint for update password
#    When I request "<input>" POST update password
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after update password
#    Examples:
#      | input | sCode | message |
#      | InputValidToken   | 201 | UpdatePasswordSuccess |
#      | InvalidToken      | 401 | Unauthorized          |
#      | InputLessPassword | 400 | PasswordInvalid       |
#      | InputNullPassword | 400 | PasswordRequired      |
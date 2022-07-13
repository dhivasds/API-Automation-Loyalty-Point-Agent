Feature: Login User
  As a user
  I want to login
  So that i can login

  Scenario Outline: Login User Functionality
    Given I set an endpoint for login user
    When I request "<input>" POST login user
    Then I validate the status code is "<sCode>"
    And validate the data detail "<message>" after login
    Examples:
      | input | sCode | message |
      | InputValidData              | 200 | SuccessfullyLoginUser    |
      | InputNotRegisteredAccount   | 400 | EmailOrPasswordIncorrect |
      | InputInvalidPassword        | 400 | EmailOrPasswordIncorrect |
      | InputPasswordLessCharacters | 400 | PasswordInvalid          |
      | InputInvalidEmail           | 400 | EmailInvalid             |
      | InputNullEmail              | 400 | EmailRequired            |
      | InputNullPassword           | 400 | PasswordRequired         |
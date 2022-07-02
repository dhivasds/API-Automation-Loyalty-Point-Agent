#Feature: Register
#  As a user
#  I want to register
#  So that i can create an account
#
#  Scenario Outline: Register Functionality
#    Given I set an endpoint for register
#    When I request "<input>" POST register
#    Then I validate the status code is "<sCode>"
#    And validate the data detail "<message>" after register
#    Examples:
#      | input | sCode | message |
#      | InputValidRegister          | 201 | AccountRegister  |
#      | InputSameData               | 400 | UserExists       |
#      | InputInvalidEmail           | 400 | EmailInvalid     |
##      | InputPasswordLessCharacters | 400 | PasswordInvalid  |
#      | InputPhoneLessNumbers       | 400 | PhoneInvalid     |
#      | InputNullName               | 400 | NameRequired     |
#      | InputNullEmail              | 400 | EmailRequired    |
#      | InputNullPassword           | 400 | PasswordRequired |
#      | InputNullPhone              | 400 | PhoneRequired    |
#      | InputPhoneWithCharacters    | 400 | PhoneMustNumber  |

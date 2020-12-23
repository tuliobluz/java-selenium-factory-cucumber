Feature: User account
  In oder to manager the account
  As a guest or registered user
  The user will be able to create, login and reset password

  Scenario: Register a new account
    Given The user is on the register page
    When The user fills the field
    And The user submits
    Then The user should see the welcome message

  Scenario: Reset password
    Given The user is on the forgot password
    When The user fills the field
    And The user submits
    Then The user should see the reset password message
Feature: User account
  In oder to manager the account
  As a guest or registered user
  The user will be able to create, login and reset password

  Background:
    Given The user is on the register page

  Scenario: Register a new account
    When The user fills the field
    And The user submits
    Then The user should see the welcome message

  Scenario: Reset password
    When The user goes to forgot password
    And The user fills the field
    And The user submits
    Then The user should see the reset password message
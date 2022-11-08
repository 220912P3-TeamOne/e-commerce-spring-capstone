Feature: Reset Password
  Scenario: User or admin resets their password
    Given the user is on the reset password page
    When the user types in their email address
    When the user clicks on reset password link button
    Then the user should receive a confirmation alert that they reset their password

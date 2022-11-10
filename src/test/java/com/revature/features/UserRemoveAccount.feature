Feature: Deactivate User
  Scenario: User logs in with new credentials
    Then User redirects to profile page
    Then User enters "deactivate"
    Then User clicks on deactivate
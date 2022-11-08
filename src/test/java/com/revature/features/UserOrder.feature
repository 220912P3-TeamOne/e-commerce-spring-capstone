Feature: Past Orders
  Background:
    Given The user has logged in

  Scenario: User want to see past orders
    Then User should see available products on Homepage and sees logout button
    Then User clicks on orders
    Then User should see past orders
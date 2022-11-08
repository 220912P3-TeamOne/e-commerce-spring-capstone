Feature: User Profile
  Scenario: A user can create a profile page
    Given the user is signed in
    When the user is on the profile page
    Then the user should be on the User Dashboard page

    Scenario: A user can modify a profile page
      Given the user is on the User Dashboard page
      When the user types in "Const" into the First Name Field
      When the user types in "Var" into the Last Name Field
      When the user types in "PassPass#1" into the Password Field
      When the user clicks on the update button
      Then the user should receive an alert that reads "You've successfully updated your profile!"
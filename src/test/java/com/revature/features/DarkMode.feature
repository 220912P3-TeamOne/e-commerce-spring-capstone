Feature: Dark Mode

  Scenario: A user, Guest or Admin can change the color scheme from normal to dark mode

    Given a user is on the logged in.

    When User clicks on the Switch track
    Then color scheme changes from normal mode to dark mode


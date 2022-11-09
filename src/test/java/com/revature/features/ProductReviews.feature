Feature: Product Reviews

  Scenario: A User can leave detailed reviews for each product and rate them on a defined scale.

    Given The User is on the home page
    When The User hovers over a product card
    When The User clicks on the viewBox
    Then The User should be on the Product Reviews page
    When The User clicks on a rating star
    When The User enters a comment
    When The user clicks on the Submit review button
    Then A Reviews Card should be displayed with the name,rating and comment










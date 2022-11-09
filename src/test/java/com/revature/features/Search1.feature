Feature: Search

  Scenario: A user can search the name of a product
    Given the user is on the home page
    When the user types the name of a product into the search bar
    When the user enters return
    Then the user should see the product displayed

  Scenario: A user can search a keyword of a product
    Given the user is on the home page
    When the user types a keyword of a product into the searchbar
    When the user enters return
    Then the user should see the product displayed

  Scenario: A user can search a partial keyword of a product
    Given the user is on the home page
    When the user types a partial keyword of a product into the searchbar
    When the user enters return
    Then the user should see the product displayed

  Scenario: Searches with no relation to products will not receive results
    Given the user is on the home page
    When the user types a string unrelated to any product into the searchbar
    When the user enters return
    Then no products should be displayed

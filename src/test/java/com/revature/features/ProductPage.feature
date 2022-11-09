Feature: Create or Update a product

  Background: Logged in as an administrator
    Given the user is on the home page
    Given a user is logged in.


  Scenario: An administrator can create a product
    When a user clicks on edit products
    When the user clicks on create new product
    When a user enters a product name
    When a user enters a product description
    When a user enters an image URL
    When a user enters a product price
    When a user clicks create product
    Then the user should be on the update product page.

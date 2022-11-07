Feature: Cart with login
  Background:
    Given The user has logged in

  Scenario: User adds product to a cart
    Then User should see available products on Homepage and sees logout button
    When User Hovers over to product and adds product to the cart
    When User clicks on cart icon when logged in
    Then User is redirected to cart page
    Then User should see the product added to cart

  Scenario: User modifies quantity of the product added to cart
    When User increses product quantity by "1"
    Then User should see "2" in quantity
    When User decreases product quantity by "1"
    Then User should see "1" in quantity

  Scenario: User deletes product from the cart
    When User clicks on delete
    Then User should not see the product inside the cart

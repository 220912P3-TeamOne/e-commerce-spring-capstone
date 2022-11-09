Feature: Product Details without Login
  Scenario: User sees product details
    When User is on Homepage
    Then User Hovers over to product and click on product details button
    Then User should see product details
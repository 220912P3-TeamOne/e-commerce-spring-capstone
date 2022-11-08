Feature: User Notification

    Scenario: User adds product to cart
      Given a user is on the login page.
      When a user enters the correct username
      When a user enters the correct password
      When a user clicks sign in
      Then User should see available products on Homepage and sees logout button
      When User Hovers over to product and adds product to the cart
      When User clicks on cart icon when logged in
      Then User is redirected to cart page
      Then User should see the product added to cart

    Scenario: User checkout
      Then User clicks on checkout
      Then User enters "fname" in firstname
      Then User enters "lname" in lastname
      Then User enters "address1" in address
      Then User enters "city" in city
      Then User enters "state" in state
      Then User enters "00000" in zip code
      Then User enters "country" in country
      Then User clicks on next
      Then User selects Payment Method
      Then User clicks on Submit Payment
      Then User clicks on Place order
      Then User should see a order confirmation notification
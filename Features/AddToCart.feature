  Feature: Add To Cart

  @hTest
  Scenario: User is able to Login and user is able to search the product and user is able to add product in the cart.
  Given the user navigates to login page
  When user enters email and password
  And the user clicks on the Login button
  Then the user should be redirected to the MyAccount Page
  When user enters the product name "MacBook" in the search bar
  And user clicks on the search button
  Then user should be able to see the search products
  When user click on the Product
  Then user successfully navigates to the product display page
  When user clicks on the Add To Cart option
  Then user is able to see the Successfull Add to Cart message displayed on the screen for "MacBook"
Feature: Search Product

    #@hTest
  Scenario: User is able to search the product by using search functionality
    Given user is able to see the Home Page
    When user enters the product name "iPhone" in the search bar
    And user clicks on the search button
    Then user should be able to see the search products

  #@hTest
  Scenario: User is able to search the product by using search functionality
    Given user is able to see the Home Page
    When user enters the product name "MacBook Air" in the search bar
    And user clicks on the search button
    Then user should be able to see the search products

  #@hTest
  Scenario: User is able to see the No product found message if the product is not available on the Website
    Given user is able to see the Home Page
    When user enters the product name "FitBit" in the search bar
    And user clicks on the search button
    Then user should be able to see the message "There is no product that matches the search criteria."

    #@hTest
  Scenario: User is able to see the No product found message when user is not giving any input into the seach box
    Given user is able to see the Home Page
    When user clicks on the search button
    Then user should be able to see the message "There is no product that matches the search criteria."

    #@hTest
  Scenario: User is able to Login and user is able to search the products
    Given the user navigates to login page
    When user enters email and password
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page
    When user enters the product name "iPhone" in the search bar
    And user clicks on the search button
    Then user should be able to see the search products

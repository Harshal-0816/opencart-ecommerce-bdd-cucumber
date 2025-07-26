Feature: Search Product

    @hTest
  Scenario: User is able to search the product by using search functionality
    Given user is able to see the Home Page
    When user enters the product name "iPhone" in the search bar
    And user clicks on the search button
    Then user should be able to see the search products
Feature: Login

    #@hTest
  Scenario: Successful Login with Valid Credentials
    Given the user navigates to login page
    When user enters email and password
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page

  #@hTest
  Scenario Outline: Data Driven Login and Logout scenario
    Given the user navigates to login page
    When user enters "<Email>" and "<Password>"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page
    When user navigates to the Myaccount dropdown
    When user click on the Logout button
    Then user should be redirected to the logout page

    Examples:
      | Email             | Password    |
      | zuri08@gmail.com  | harshal@123 |
      | zuri123@gmail.com | zuri@123    |

  #@hTest
  Scenario Outline: Successful Login with InValid Credentials
    Given the user navigates to login page
    When user enters "<Email>" and "<Password>"
    And the user clicks on the Login button
    Then System throws an error as "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."

    Examples:
    |    Email          |  Password   |
    | star123@gmail.com | star@123    |
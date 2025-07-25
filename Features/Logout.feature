Feature: Logout Feature

   #@hTest
  Scenario: User is able to logout successfully.
    Given the user navigates to login page
    When user enters email and password
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page
    When user navigates to the Myaccount dropdown
    When user click on the Logout button
    Then user should be redirected to the logout page




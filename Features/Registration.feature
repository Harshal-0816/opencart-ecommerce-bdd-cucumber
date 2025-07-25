Feature: Account Registration

  #@htest
  Scenario: Successful Account Registration
    Given the user navigates to Register Account page
    When the user enters "Harshal" "Velani" "harshal@gmail.com" "0123456789" "abc@123" "abc@123"
    And the user selects Privacy Policy
    And the user clicks on Continue button
    Then the user account should get created successfully

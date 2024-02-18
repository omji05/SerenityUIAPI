Feature: Login to application

  @Run1
  Scenario: Verifying the valid login
    When user open the application
    And user enters "Admin" as username and "admin123" as password
    Then user should be able to successfully login
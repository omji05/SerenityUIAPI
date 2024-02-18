Feature: Login to Cura Health

  Background: Navigate to application
    Given user open the application


  @Run1
  Scenario: Verify successful login to Cura heath
#    Given user open the application
    And user enters "John Doe" as username and "ThisIsNotAPassword" as password
    Then user should be able to successfully login
Feature: Login to Cura Health

  Background: Navigate to application
    Given user open the application


  @Run
  Scenario: Verify successful login to Cura heath 1
    And user enters "John Doe" as username and "ThisIsNotAPassword" as password
    Then user should be able to successfully login

  @Run
  Scenario: Verify successful login to Cura heath 2
    And user enters "John Doe" as username and "ThisIsNotAPassword" as password
    Then user should be able to successfully login

  @Run
  Scenario: Verify successful login to Cura heath 7
    And user enters "John Doe" as username and "ThisIsNotAPassword" as password
    Then user should be able to successfully login
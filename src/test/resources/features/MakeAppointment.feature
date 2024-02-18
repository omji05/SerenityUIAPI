Feature: Making an appointment

  Background: User is on Make Appointment page
    Given user open the application
    And user enters "John Doe" as username and "ThisIsNotAPassword" as password
    Then user should be able to successfully login

  @Run
  Scenario Outline: Making an appointment
    And user select facility as "<Facility>" from dropdown
    And user select healthcare program as "<healthCareProgram>" radio button
    And user select date as "<Date>"
    And user update comment as "<Comment>"
    And user click on Book Appointment button

    Examples:
      | Facility                     | healthCareProgram | Comment                |Date|
      | Tokyo CURA Healthcare Center | Medicaid          | This is a test comment |21/03/2024|
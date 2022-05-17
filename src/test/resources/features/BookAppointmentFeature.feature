Feature: Test book appointment feature
  Scenario: Book appointment for the given facility center
    Given user is on loginPage
    When user login the facility center
    Then user selects "Hongkong CURA Healthcare Center" as facility center and comment as "Please book appointment" and book the appointment
    And user confirms the appointment in the selected facility center "Hongkong CURA Healthcare Center"
    And user close the browser
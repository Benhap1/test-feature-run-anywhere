Feature: Trainee Profile Management
  As a Trainee
  I want to manage my profile and status
  So that my information remains up to date

  Background:
    Given the system is initialized with a trainee "natali.ageeva"
    And I am authenticated as trainee "natali.ageeva"

  @Profile
  Scenario: Successfully retrieve own profile
    When I request my trainee profile
    Then the trainee response status should be 200
    And the profile should contain the lastName "Ageeva"

  @Update
  Scenario: Successfully update profile information
    When I update my trainee profile with the following details:
      | firstName | lastName | isActive | address |
      | Natalochka| Ageeva  | true     | London  |
    Then the response status should be 200
    And the updated trainee firstName should be "Natalochka"
    And the updated trainee address should be "London"

  @Activation
  Scenario Outline: Change trainee activation status
    When I send a request to set trainee activation status to <status>
    Then the response status should be 200
    And my trainee profile status should be <status>

    Examples:
      | status |
      | false  |
      | true   |

  @Delete
  Scenario: Delete own trainee profile
    When I delete my trainee profile
    Then the response status should be 200
    And the trainee "natali.ageeva" should no longer exist
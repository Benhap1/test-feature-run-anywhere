Feature: Training Types Management
  As a user
  I want to retrieve the list of available training types
  So that I can select the correct specialization for trainers or sessions

  Background:
    Given the system has the following training types:
      | name     |
      | Yoga     |
      | Crossfit |
      | Boxing  |

  @GetTrainingTypes
  Scenario: Successfully retrieve all training types
    When I request all training types
    Then the training types response status should be 200
    And the response should contain the following training types:
      | Yoga     |
      | Crossfit |
      | Boxing   |
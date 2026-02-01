Feature: Training Management
  As a Trainer
  I want to create and delete training sessions
  So that I can manage the fitness schedules of my trainees

  Background:
    Given the system has a trainee "natali.ageeva"
    And the system has a trainer "lilia.levada"
    And I am authenticated as trainer "lilia.levada"

  @AddTraining
  Scenario: Successfully add a new training session
    When I create a training session with the following details:
      | traineeUsername | trainingName    | date       | duration |
      | natali.ageeva   | Morning Yoga    | 2026-12-01 | 60       |
    Then the training response status should be 200

  @DeleteTraining
  Scenario: Successfully delete an existing training session
    Given a training session exists between "natali.ageeva" and "lilia.levada"
    When I delete that training session
    Then the training response status should be 204
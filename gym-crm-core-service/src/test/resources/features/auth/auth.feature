Feature: Authentication and Registration
  As a User (Trainee or Trainer)
  I want to register and manage my credentials
  So that I can securely access the Gym CRM system

  @TraineeRegistration
  Scenario: Successfully register a new trainee
    When I register a trainee with the following details:
      | firstName | lastName | address    |
      | Natali    | Ageeva   | Melitopol  |
    Then the auth response status should be 201
    And the response should contain a username and password

  @TrainerRegistration
  Scenario: Successfully register a new trainer
    When I register a trainer with the following details:
      | firstName | lastName | specializationName |
      | Lilia     | Levada   | Crossfit           |
    Then the auth response status should be 201
    And the response should contain a username and password

  @Login
  Scenario: Successfully login and receive JWT
    Given a trainee "natali.ageeva" exists with password "p@ssword123"
    When I login with username "natali.ageeva" and password "p@ssword123"
    Then the auth response status should be 200
    And the response should contain a JWT token

  @ChangePassword
  Scenario: Successfully change password
    Given a trainee "natali.ageeva" exists with password "p@ssword123"
    When I change password for "natali.ageeva" from "p@ssword123" to "new.P@ssword77"
    Then the auth response status should be 200
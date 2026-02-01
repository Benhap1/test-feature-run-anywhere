Feature: Trainer Workload E2E Asynchronous Flow
  As a Trainer
  I want my training activities to be reflected in my workload via messaging
  So that my monthly statistics are always up to date

  Scenario: Registration, Multiple Training Updates, and Deletion via ActiveMQ
    # 1. Registration & Initial Check
    Given a new trainee "natali.ageeva" registers on the Gym Service
    Given a new trainer "lilia.levada" registers on the Gym Service
    And the trainer "lilia.levada" logs in to obtain a JWT token
    Then the trainer "lilia.levada" should eventually exist in the Workload Service

    # 2. Login
    Then the trainer "lilia.levada" should eventually exist in the Workload Service

    # 3. Add First Training (90 min)
    When the trainer "lilia.levada" adds a 90-minute training named "Cardio" for "2026-03-10"
    Then the training should be accepted by the Gym Service
    And the workload for "lilia.levada" should eventually show 90 minutes for "MARCH" 2026

    # 4. Add Second Training (60 min)
    When the trainer "lilia.levada" adds a 60-minute training named "Pilates Fusion" for "2026-03-15"
    Then the training should be accepted by the Gym Service
    And the workload for "lilia.levada" should eventually show 150 minutes for "MARCH" 2026

    # 5. Delete One Training (Remove the 90 min Yoga Session)
    When the trainer "lilia.levada" deletes the training named "Cardio"
    Then the workload for "lilia.levada" should eventually show 60 minutes for "MARCH" 2026

    # 6. Delete Profile
    When the trainer profile "lilia.levada" is deleted
    Then the workload for "lilia.levada" should eventually be removed from the system
Feature: Trainer Workload Statistics
  As a user of the Gym CRM
  I want to retrieve a trainer's monthly training summary
  So that I can monitor their workload

  Scenario: Successfully retrieve existing trainer statistics
    Given the workload system is clean
    And a workload exists for trainer "lilia.levada" with the following data:
      | year | month   | duration |
      | 2026 | MAY     | 60       |
      | 2026 | JUNE    | 120      |
    When I request the workload for trainer "lilia.levada"
    Then the workload response status should be 200
    And the response should contain "Lilia" and "Levada"
    And the response should show 60 minutes for "MAY" 2026
    And the response should show 120 minutes for "JUNE" 2026
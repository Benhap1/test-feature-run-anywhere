package com.gymcrm.gym_crm_spring.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record TrainerTrainingsListResponse(
        List<TrainerTrainingResponse> trainings
) {
    public record TrainerTrainingResponse(
            UUID id,
            String trainingName,
            LocalDate trainingDate,
            String trainingType,
            int trainingDuration,
            String traineeUsername
    ) {}
}
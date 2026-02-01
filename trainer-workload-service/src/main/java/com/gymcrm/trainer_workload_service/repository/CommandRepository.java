package com.gymcrm.trainer_workload_service.repository;

import com.gymcrm.trainer_workload_service.dto.TrainerWorkloadRequest;
import com.gymcrm.trainer_workload_service.entity.TrainerWorkload;

public interface CommandRepository {
    void createTrainerIfNotExists(TrainerWorkload trainerWorkload);
    void updateTrainerYearMonthDuration(TrainerWorkloadRequest request);
    void deleteByUsername(String username);
}

package com.gymcrm.trainer_workload_service.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MonthSummary {
    private String month;
    private int trainingSummaryDuration;
}

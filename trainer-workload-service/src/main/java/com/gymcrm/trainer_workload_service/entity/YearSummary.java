package com.gymcrm.trainer_workload_service.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YearSummary {
    private int year;
    private List<MonthSummary> months;
}
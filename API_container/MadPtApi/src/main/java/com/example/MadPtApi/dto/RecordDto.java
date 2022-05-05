package com.example.MadPtApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordDto {
    @JsonProperty("exercise_id")
    private Long exerciseId;
    @JsonProperty("start_time")
    private Long startTime;
    @JsonProperty("end_time")
    private Long endTime;
    private int reps;
    private int sets;
    // reps를 list로 받아야할듯
    @JsonProperty("avg_score")
    private double avgScore;
}

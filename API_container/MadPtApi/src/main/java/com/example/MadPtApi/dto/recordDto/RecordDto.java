package com.example.MadPtApi.dto.recordDto;

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
    @JsonProperty("real_time")
    private int realTime;
    private int reps;
    private int sets;
    @JsonProperty("avg_score")
    private double avgScore;
}

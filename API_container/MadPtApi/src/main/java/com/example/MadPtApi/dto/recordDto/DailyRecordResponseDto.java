package com.example.MadPtApi.dto.recordDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyRecordResponseDto {
    @JsonProperty("exercise_name")
    private String exerciseName;
    @JsonProperty("start_time")
    private Long startTime;
    private int reps;
    private int sets;
    @JsonProperty("burned_kcal")
    private double burnedKcal;
}

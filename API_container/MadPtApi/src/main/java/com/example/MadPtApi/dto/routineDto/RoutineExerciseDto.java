package com.example.MadPtApi.dto.routineDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoutineExerciseDto {
    @JsonProperty("exercise_id")
    private Long exerciseId;
    private int reps;
    private int sets;
}

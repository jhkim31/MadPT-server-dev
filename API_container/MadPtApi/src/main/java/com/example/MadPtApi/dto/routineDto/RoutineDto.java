package com.example.MadPtApi.dto.routineDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoutineDto {
    @JsonProperty("routine_name")
    private String routineName;
    private Long date;
    private int breaktime;
    @JsonProperty("exercise_list")
    List<RoutineExerciseDto> routineExerciseDtoList;
}

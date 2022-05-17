package com.example.MadPtApi.controller;

import com.example.MadPtApi.domain.Routine;
import com.example.MadPtApi.domain.RoutineExercise;
import com.example.MadPtApi.dto.PostResponseDto;
import com.example.MadPtApi.dto.routineDto.RoutineDto;
import com.example.MadPtApi.dto.routineDto.RoutineExerciseDto;
import com.example.MadPtApi.dto.routineDto.RoutineResponseDto;
import com.example.MadPtApi.dto.routineDto.RoutineSaveRequestDto;
import com.example.MadPtApi.service.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/routine")
public class RoutineController {

    private final RoutineService routineService;

    @PostMapping()
    public PostResponseDto saveRoutine(@RequestHeader("member_id") Long id, @RequestBody RoutineSaveRequestDto routineSaveRequestDto) {
        Long routineId = routineService.saveRoutine(id, routineSaveRequestDto);

        PostResponseDto postResponseDto;
        if (routineId > 0L) {
            postResponseDto = PostResponseDto.builder()
                    .success(0)
                    .error(0)
                    .result("success")
                    .build();
        } else {
            postResponseDto = PostResponseDto.builder()
                    .success(1)
                    .error(1)
                    .result("fail")
                    .build();
        }

        return postResponseDto;
    }

    @GetMapping
    public RoutineResponseDto getRoutine(@RequestHeader("member_id") Long id) {
        List<Routine> routineList = routineService.getRoutine(id);

        List<RoutineDto> routineDtoList = new ArrayList<>();
        for (Routine routine : routineList) {
            List<RoutineExerciseDto> routineExerciseDtoList = new ArrayList<>();
            RoutineExerciseDto routineExerciseDto;

            for (RoutineExercise routineExercise : routine.getRoutineExerciseList()) {
                routineExerciseDto = RoutineExerciseDto.builder()
                        .exerciseId(routineExercise.getId())
                        .reps(routineExercise.getReps())
                        .sets(routineExercise.getSets())
                        .build();
                routineExerciseDtoList.add(routineExerciseDto);
            }
            // LocalDateTime -> Timestamp
            Timestamp timestamp = Timestamp.valueOf(routine.getDate());
            RoutineDto routineDto = RoutineDto.builder()
                    .routineName(routine.getName())
                    .date(timestamp.getTime())
                    .breaktime(routine.getBreaktime())
                    .routineExerciseDtoList(routineExerciseDtoList)
                    .build();
            routineDtoList.add(routineDto);
        }

        return RoutineResponseDto.builder().routineResponseDtoList(routineDtoList).build();
    }
}

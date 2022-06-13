package com.example.MadPtApi.controller;

import com.example.MadPtApi.dto.PostResponseDto;
import com.example.MadPtApi.dto.goalDto.GoalSaveRequestDto;
import com.example.MadPtApi.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goal")
public class GoalController {

    private final GoalService goalService;

    /**
     * 목표 저장
     */
    @PostMapping
    public PostResponseDto saveGaol(@RequestHeader("Member-Id") Long id, @RequestBody GoalSaveRequestDto goalSaveRequestDto) {
        Long goalId = goalService.saveGoal(id, goalSaveRequestDto);

        PostResponseDto postResponseDto;
        if (goalId != 0L) {
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

}

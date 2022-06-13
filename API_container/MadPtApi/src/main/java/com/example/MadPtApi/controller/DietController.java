package com.example.MadPtApi.controller;

import com.example.MadPtApi.dto.PostResponseDto;
import com.example.MadPtApi.dto.dietDto.DietSaveRequestDto;
import com.example.MadPtApi.service.DietService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@RestController
@RequestMapping("/diet")
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @PostMapping
    public PostResponseDto saveDiet(@RequestHeader("member_id") Long id, @RequestBody DietSaveRequestDto dietSaveRequestDto) {
        // timestamp -> LocalDateTime 변환
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(dietSaveRequestDto.getDate()), TimeZone.getDefault().toZoneId());

        Long diet_id = dietService.addDietList(id, localDateTime, dietSaveRequestDto.getSimpleTotalKcal(), dietSaveRequestDto.getDietType(), dietSaveRequestDto.getDietList());
        PostResponseDto postResponseDto;
        if (diet_id != 0L) {
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
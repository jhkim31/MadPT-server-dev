package com.example.MadPtApi.controller;

import com.example.MadPtApi.dto.dietDto.DailyDietListDto;
import com.example.MadPtApi.dto.dietDto.DietResponseDto;
import com.example.MadPtApi.service.DietService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistic")
@RequiredArgsConstructor
public class StatisticController {

    private final DietService dietService;

    /**
     * 날짜별 식단 조회
     */
    @GetMapping("/diet")
    public DietResponseDto getDiet(@RequestHeader("member_id") Long id,  @RequestParam Long date) {
        List<DailyDietListDto> dailyDietListDtos = dietService.findDiet(id, date);
        return DietResponseDto.builder().dailyDietList(dailyDietListDtos).build();
    }

    /**
     * 날짜별 운동 기록 조회
     */

    /**
     * 일별 데이터 받아오기
     */

    /**
     * 월별 데이터 받아오기
     */

}

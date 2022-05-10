package com.example.MadPtApi.controller;

import com.example.MadPtApi.dto.dietDto.DailyDietDto;
import com.example.MadPtApi.dto.dietDto.DailyDietListResponseDto;
import com.example.MadPtApi.dto.recordDto.DailyRecordListResponseDto;
import com.example.MadPtApi.dto.recordDto.DailyRecordResponseDto;
import com.example.MadPtApi.service.DietService;
import com.example.MadPtApi.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistic")
@RequiredArgsConstructor
public class StatisticController {

    private final DietService dietService;
    private final RecordService recordService;

    /**
     * 일별 식단 조회
     */
    @GetMapping("/diet")
    public DailyDietListResponseDto getDiet(@RequestHeader("member_id") Long id, @RequestParam Long date) {
        List<DailyDietDto> dailyDietDtos = dietService.findDiet(id, date);
        return DailyDietListResponseDto.builder().dailyDietList(dailyDietDtos).build();
    }

    /**
     * 일별 운동 기록 조회
     */
    @GetMapping("/record")
    public DailyRecordListResponseDto getRecord(@RequestHeader("member_id") Long id, @RequestParam Long date) {
        List<DailyRecordResponseDto> recordResponseDtoList = recordService.findRecord(id, date);
        return DailyRecordListResponseDto.builder().recordResponseDtoList(recordResponseDtoList).build();
    }


    /**
     * 일별 데이터 받아오기
     */

    /**
     * 월별 데이터 받아오기
     */

}

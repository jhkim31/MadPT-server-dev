package com.example.MadPtApi.controller;

import com.example.MadPtApi.dto.dietDto.DailyDietDto;
import com.example.MadPtApi.dto.dietDto.DailyDietListResponseDto;
import com.example.MadPtApi.dto.recordDto.DailyRecordListResponseDto;
import com.example.MadPtApi.dto.recordDto.DailyRecordResponseDto;
import com.example.MadPtApi.dto.statisticDto.CalendarDailyDto;
import com.example.MadPtApi.dto.statisticDto.CalendarDto;
import com.example.MadPtApi.dto.statisticDto.DailySummaryDto;
import com.example.MadPtApi.service.DietService;
import com.example.MadPtApi.service.RecordService;
import com.example.MadPtApi.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistic")
@RequiredArgsConstructor
public class StatisticController {

    private final DietService dietService;
    private final RecordService recordService;
    private final StatisticService statisticService;

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
     * 일별 메인 데이터 받아오기
     * @return
     */
    @GetMapping("/day-summary")
    public DailySummaryDto getDailyData(@RequestHeader("member_id") Long id, @RequestParam Long date) {
        return statisticService.getDailyTotalData(id, date);
    }

    /**
     * 월별 데이터 받아오기
     */
    @GetMapping("/calendar")
    public CalendarDto getCalendarData(@RequestHeader("member_id") Long id, @RequestParam Long date) {
        List<CalendarDailyDto> monthlyData = statisticService.getMonthlyData(id, date);
        return CalendarDto.builder().dailyDtoList(monthlyData).build();
    }

}

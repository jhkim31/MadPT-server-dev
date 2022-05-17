package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Diet;
import com.example.MadPtApi.domain.Goal;
import com.example.MadPtApi.domain.Member;
import com.example.MadPtApi.domain.Record;
import com.example.MadPtApi.dto.statisticDto.CalendarDailyDto;
import com.example.MadPtApi.dto.statisticDto.DailySummaryDto;
import com.example.MadPtApi.repository.DietRepository;
import com.example.MadPtApi.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StatisticService {

    private final MemberService memberService;
    private final DietService dietService;
    private final RecordService recordService;
    private final GoalService goalService;
    private final DietRepository dietRepository;
    private final RecordRepository recordRepository;

    /**
     * 일별 총합 데이터 조회
     */
    public DailySummaryDto getDailyTotalData(Long clientId, Long date) {
        // 회원 몸무게 조회
        double weight = memberService.getMemberWeight(clientId);

        // 회원 목표 조회
        Goal goal = goalService.getGoal(clientId);

        // 회원 소모 칼로리 조회
        double dailyBurnedKcal = recordService.getDailyBurnedKcal(clientId, date);

        // 회원 섭취 칼로리 조회
        HashMap<String, Double> dietKcalHashMap = dietService.getDietKcal(clientId, date);

        // Breakfast, Lunch, Dinner, Snack
        DailySummaryDto dailySummaryDto = DailySummaryDto.builder()
                .weight(weight)
                .burnedKcal(dailyBurnedKcal)
                .breakfastKcal(dietKcalHashMap.get("Breakfast"))
                .lunchKcal(dietKcalHashMap.get("Lunch"))
                .dinnerKcal(dietKcalHashMap.get("Dinner"))
                .snackKcal(dietKcalHashMap.get("Snack"))
                .goalDietKcal(goal.getDietKcal())
                .goalExerciseKcal(goal.getExerciseKcal())
                .goalWeight(goal.getWeight())
                .build();

        return dailySummaryDto;
    }

    /**
     * 월별 데이터 조회
     */
    public List<CalendarDailyDto> getMonthlyData(Long clientId, Long date) {
        // 회원 엔티티 조회
        Member member = memberService.findMember(clientId);

        // timestamp 변환
        Timestamp timestamp = new Timestamp(date);
        LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
        int month = localDate.getMonthValue();
        int days = localDate.lengthOfMonth();
        int year = localDate.getYear();

        HashMap<Integer, Double> monthlyDietKcal = dietService.getMonthlyDietKcal(member, days, month);
        HashMap<Integer, Double> monthlyBurnedKcal = recordService.monthlyBurnedKcal(member, month, days);

        List<CalendarDailyDto> dailyDtoList = new ArrayList<>();
        for (int i = 1; i <= days; i++) {
            if (monthlyDietKcal.get(i) == 0 && monthlyBurnedKcal.get(i) == 0) {
                continue;
            }

            LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(year, month, i), LocalTime.now());
            CalendarDailyDto dto = CalendarDailyDto.builder()
                        .date(Timestamp.valueOf(localDateTime).getTime())
                        .dailyDietKcal(monthlyDietKcal.get(i))
                        .dailyBurnedKcal(monthlyBurnedKcal.get(i))
                        .build();
            dailyDtoList.add(dto);
        }

        return dailyDtoList;
    }

}

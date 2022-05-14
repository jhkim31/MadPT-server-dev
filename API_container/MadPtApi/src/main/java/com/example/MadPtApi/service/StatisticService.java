package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Goal;
import com.example.MadPtApi.dto.statisticDto.DailySummaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StatisticService {

    private final MemberService memberService;
    private final DietService dietService;
    private final RecordService recordService;
    private final GoalService goalService;

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

}

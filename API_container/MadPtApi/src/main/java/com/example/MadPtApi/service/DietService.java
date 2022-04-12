package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.*;
import com.example.MadPtApi.repository.DietRepository;
import com.example.MadPtApi.repository.FoodRepository;
import com.example.MadPtApi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DietService {

    private final DietRepository dietRepository;
    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;

    /**
     * 식단 저장
     */
    @Transactional
    public Long addDiet(Long memberId, Long foodId, LocalDateTime date, double weight, DietType dietType) {
        // 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Food food = foodRepository.findOne(foodId);

        // DietFood 생성
        DietFood dietFood = DietFood.createDietFood(food, weight);

        // Diet 생성
        Diet diet = Diet.createDiet(member, date, dietType, dietFood);

        dietRepository.save(diet);

        return diet.getId();
    }

    /**
     * 날짜 별 식단 정보 조회
     */
    public List<Diet> findDiet(Long memberId, LocalDateTime start, LocalDateTime end) {
        // 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        // member 조회 안되면 예외 처리
        return dietRepository.findDietsByMemberIdAndDietDate(member.getId(), start, end);
    }
}

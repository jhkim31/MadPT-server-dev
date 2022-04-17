package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.*;
import com.example.MadPtApi.dto.dietDto.DietSaveRequestDto;
import com.example.MadPtApi.repository.DietRepository;
import com.example.MadPtApi.repository.FoodRepository;
import com.example.MadPtApi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DietService {

    private final DietRepository dietRepository;
    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;

    /**
     * 식단 List 저장
     */
    public Long addDietList(Long memberId, LocalDateTime date, String dietType, List<DietSaveRequestDto> dietSaveRequestDtoList) {
        List<DietFood> dietFoodList = new ArrayList<>();
        Member member = memberRepository.findOne(memberId);

        for (DietSaveRequestDto dto : dietSaveRequestDtoList) {
            Food food = null;
            if (dto.isCustom()) {
                food = Food.builder().foodName(dto.getFoodName()).build(); // 커스텀 입력시 Food 생성
                foodRepository.save(food);
            }
            else {
                Long foodId = Long.parseLong(dto.getFoodId().trim());
                food = foodRepository.findOne(foodId);
            }
            // DietFood 생성
            DietFood dietFood = DietFood.createDietFood(food, dto.getWeight(), dto.getCount(), dto.getUnit());
            dietFoodList.add(dietFood);
        }

        Diet diet = Diet.createDiet(member, date, DietType.valueOf(dietType), dietFoodList);
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

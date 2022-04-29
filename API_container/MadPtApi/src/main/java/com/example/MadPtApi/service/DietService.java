package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.*;
import com.example.MadPtApi.dto.dietDto.DietListDto;
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
import java.util.Optional;

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
    @Transactional
    public Long addDietList(Long memberId, LocalDateTime date, String dietType, List<DietListDto> dietListDtos) {
        List<DietFood> dietFoodList = new ArrayList<>();
        Member member = memberRepository.findOne(memberId);

        for (DietListDto dto : dietListDtos) {
            DietFood dietFood = null;

            if (dto.isCustom()) {
                // 커스텀 입력시 Food 생성 후 저장
                Food customFood = Food.builder().foodName(dto.getFoodName()).build();
                foodRepository.save(customFood);


                dietFood = DietFood.createDietFood(customFood, dto.getWeight(), dto.getCount(), dto.getUnit());
            }else {
                // 음식 조회
                Optional<Food> food = foodRepository.findById(dto.getFoodId());
                if (food.isPresent()) {
                    // DietFood 생성
                    dietFood = DietFood.createDietFood(food.get(), dto.getWeight(), dto.getCount(), dto.getUnit());
                }
            }
            // 식단 리스트에 저장
            dietFoodList.add(dietFood);
        }

        Diet diet = Diet.createDiet(member, date, DietType.valueOf(dietType), dietFoodList);
        dietRepository.save(diet);
        return diet.getId();
    }
    // 식단 추가

    // 식단 삭제

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

package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.*;
import com.example.MadPtApi.dto.dietDto.DailyDietDto;
import com.example.MadPtApi.dto.dietDto.DietFoodDto;
import com.example.MadPtApi.dto.dietDto.DietDto;
import com.example.MadPtApi.dto.foodDto.FoodSimpleDataDto;
import com.example.MadPtApi.repository.DietRepository;
import com.example.MadPtApi.repository.FoodRepository;
import com.example.MadPtApi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DietService {

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;
    private final DietRepository dietRepository;
    private final DietFoodService dietFoodService;

    /**
     * 식단 List 저장
     */
    @Transactional
    public Long addDietList(Long memberId, LocalDateTime date, double simpleTotalKcal, String dietType, List<DietDto> dietDtoList) {
        List<DietFood> dietFoodList = new ArrayList<>();
        // 회원 엔티티 조회
        Member member = memberRepository.findByClientId(memberId); // 예외 처리 해야됌

        for (DietDto dto : dietDtoList) {
            DietFood dietFood = null;

            if (dto.isCustom()) {
                // 커스텀 입력시 Food 생성 후 저장
                Food customFood = Food.builder()
                        .foodName(dto.getFoodName())
                        .foodData(FoodData.builder()
                                .defaultKcal(dto.getDietKcal())
                                .defaultWeight(dto.getWeight())
                                .build())
                        .isCustom(true)
                        .build();
                foodRepository.save(customFood);

                // DietFood 생성
                dietFood = DietFood.createDietFood(customFood, dto.getDietKcal(), dto.getWeight(), dto.getCount(), dto.getUnit());
            } else {
                // 음식 조회
                Optional<Food> food = foodRepository.findById(dto.getFoodId());
                if (food.isPresent()) {
                    // DietFood 생성
                    dietFood = DietFood.createDietFood(food.get(), dto.getDietKcal(), dto.getWeight(), dto.getCount(), dto.getUnit());
                }
            }
            // 식단 리스트에 저장
            dietFoodList.add(dietFood);
        }

        Diet diet = Diet.createDiet(member, date, DietType.valueOf(dietType), simpleTotalKcal, dietFoodList);
        dietRepository.save(diet);
        return diet.getId();
    }
    // 식단 추가

    // 식단 삭제

    /**
     * 일별 식단 정보 조회
     */
    public List<DailyDietDto> findDiet(Long memberId, Long date) {
        // 회원 엔티티 조회
        Member member = memberRepository.findByClientId(memberId);// member 조회 안되면 예외 처리 필요

        // timestamp 변환
        Timestamp timestamp = new Timestamp(date);
        LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
        LocalDateTime startOfDay = localDate.atStartOfDay();
        LocalDateTime endOfDay = LocalTime.MAX.atDate(localDate);

        // Diet 리스트 조회
        List<Diet> dietList = dietRepository.findDietsByMemberIdAndDietDate(member.getId(), startOfDay, endOfDay);

        // 결과 DTO
        List<DailyDietDto> dailyDietDtoList = new ArrayList<>();

        for (Diet d : dietList) {
            String dietType = d.getDietType().toString();
            double simpleTotalKcal = d.getSimpleTotalKcal();
            // DietFood 조회
            List<DietFood> dietFoodList = dietFoodService.findDietFood(d.getId());

            // DietFoodDto 리스트 생성
            List<DietFoodDto> dietFoodDtoList = new ArrayList<>();

            // DietFoodDto 생성 후 리스트에 추가
            for (DietFood dietFood : dietFoodList) {
                Food food = dietFood.getFood();

                // FoodSimpleDataDto 생성
                FoodSimpleDataDto foodSimpleDataDto = getFoodSimpleDataDto(dietFood, food);

                // DietFoodDto 생성
                DietFoodDto dietDto = DietFoodDto.builder()
                        .foodName(food.getFoodName())
                        .dietKcal(dietFood.getDietKcal())
                        .weight(dietFood.getFoodWeight())
                        .count(dietFood.getCount())
                        .unit(dietFood.getUnit())
                        .isCustom(food.isCustom())
                        .foodSimpleDataDto(foodSimpleDataDto)
                        .build();
                dietFoodDtoList.add(dietDto);
            }

            // DailyDietListDto 생성
            DailyDietDto dailyDietDto = DailyDietDto.builder()
                    .dietType(dietType)
                    .simpleDietKcal(simpleTotalKcal)
                    .dietFoodDtoList(dietFoodDtoList)
                    .build();
            dailyDietDtoList.add(dailyDietDto);
        }

        return dailyDietDtoList;
    }

    /**
     * 섭취 탄단지 비율 계산 로직
     */
    private FoodSimpleDataDto getFoodSimpleDataDto(DietFood dietFood, Food food) {
        FoodData foodData = food.getFoodData();

        double ratio = dietFood.getDietKcal() / foodData.getDefaultKcal();

        double carbohydrate = 0;
        double protein = 0;
        double fat = 0;

        if (!food.isCustom()) {
            carbohydrate = Math.round(foodData.getDefaultCarbohydrate() * ratio * 100) / 100.0;
            protein = Math.round(foodData.getDefaultProtein() * ratio * 100) / 100.0;
            fat = Math.round(foodData.getDefaultFat() * ratio * 100) / 100.0;
        }


        // FoodSimpleDataDto 생성
        FoodSimpleDataDto foodSimpleDataDto;

        foodSimpleDataDto = FoodSimpleDataDto.builder()
                .defaultCarbohydrate(carbohydrate)
                .defaultProtein(protein)
                .defaultFat(fat)
                .build();
        return foodSimpleDataDto;
    }
}

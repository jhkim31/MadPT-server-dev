package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Diet;
import com.example.MadPtApi.domain.Food;
import com.example.MadPtApi.domain.FoodData;
import com.example.MadPtApi.domain.Member;
import com.example.MadPtApi.dto.dietDto.DailyDietDto;
import com.example.MadPtApi.dto.dietDto.DietDto;
import com.example.MadPtApi.repository.DietRepository;
import com.example.MadPtApi.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class DietServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    DietService dietService;
    @Autowired
    DietRepository dietRepository;
    @Autowired
    FoodService foodService;
    @Autowired
    DietFoodService dietFoodService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 식단_저장() throws Exception {
        // given
        Member member = Member.builder()
                .name("JungRak")
                .build();

        em.persist(member);

        Food food = Food.builder()
                .foodName("제육볶음")
                .foodData(new FoodData())
                .build();
        em.persist(food);

        double weight = 100.0;
        LocalDateTime dateTime = LocalDateTime.now();

        // when
        //Long dietId = dietService.addDiet(member.getId(), food.getId(), dateTime, weight, DietType.Lunch, FoodType.NUTRITION);

        // then
/*        Diet diet = dietRepository.findById(dietId).get();
        assertEquals(dietId, diet.getId());
        assertEquals(dateTime, diet.getDietDate());*/
    }
    @Test
    public void 여러_식단_저장() throws Exception {
        // given
        Member member = Member.builder()
                .name("JungRak")
                .clientId(1L)
                .build();

        memberRepository.save(member);
        //Member memberByClientId = memberRepository.findMemberByClientId(1L);


        Food food1 = getFood("제육", "CJ", false);
        Long foodId1 = foodService.saveFood(food1);
        Food food2 = getFood("돈까스", "풀무원", false);
        Long foodId2 = foodService.saveFood(food2);

        DietDto dto1 = DietDto.builder()
                .foodId(foodId1)
                .foodName("제육")
                .dietKcal(0)
                .weight(110.0)
                .count(2)
                .unit("접시")
                .isCustom(false)
                .build();

        DietDto dto2 = DietDto.builder()
                .foodId(foodId2)
                .foodName("돈까스")
                .weight(210.0)
                .count(3)
                .unit("조각")
                .isCustom(false)
                .build();

        DietDto dto3 = DietDto.builder()
                .foodId(0L)
                .foodName("사과주스")
                .weight(100.0)
                .count(1)
                .unit("컵")
                .isCustom(true)
                .build();
        List<DietDto> dtoList = new ArrayList<>();

        dtoList.add(dto1);
        dtoList.add(dto2);
        dtoList.add(dto3);

        LocalDateTime localDateTime = LocalDateTime.now();
        double simpleTotalKcal = 300.0;
        // when
        //Long result = dietService.addDietList(1L, localDateTime, simpleTotalKcal, "Lunch", dtoList);
        //System.out.println(dietService.addDietList(1L, localDateTime, simpleTotalKcal, "Lunch", dtoList));

        // then
        //Diet diet = dietRepository.findById(dietId).get();
        //System.out.println(diet.getDietFoodList().size());
    }

    // Food Entity 생성 메소드
    private Food getFood(String foodName, String makerName, boolean isCustom) {
        return Food.builder()
                .foodName(foodName)
                .makerName(makerName)
                .foodData(FoodData.builder()
                        .defaultKcal(45.2)
                        .defaultCarbohydrate(10.1)
                        .defaultFat(11.1)
                        .defaultProtein(12.1)
                        .build())
                .isCustom(isCustom)
                .build();
    }


    @Test
    public void 커스텀_입력_테스트() throws Exception {
        // given

        // when
        // then
    }

    @Test
    public void 식단_리스트_조회() throws Exception {
        // given
        Long date = 1651582676000L;
        Timestamp timestamp = new Timestamp(date);
        LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
        LocalDateTime startOfDay = localDate.atStartOfDay();
        LocalDateTime endOfDay = LocalTime.MAX.atDate(localDate);

        // when
        List<Diet> dietList = dietRepository.findDietsByMemberIdAndDietDate(1L, startOfDay, endOfDay);
        System.out.println(dietList.size());

        // then
        try {
            List<DailyDietDto> dietResult = dietService.findDiet(1L, date);
            System.out.println(dietResult.size());
        } catch (Exception e) {
            System.out.println("에러");
        }
    }

    /**
     * 월별 식단 조회
     */
    @Test
    public void 월별_식단_조회() throws Exception {
        // given
        List<Diet> dietsByMonth = dietRepository.findDietsByMonth(1L,8);
        System.out.println(dietsByMonth.size());
        // when
        // then
    }

}
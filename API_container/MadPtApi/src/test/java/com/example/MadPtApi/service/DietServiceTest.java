package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.*;
import com.example.MadPtApi.repository.DietRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DietServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    DietService dietService;
    @Autowired
    DietRepository dietRepository;

    @Test
    public void 식단_저장() throws Exception {
        // given
        Member member = new Member();
        member.setName("Kim");
        em.persist(member);

        Food food = Food.builder()
                .foodName("제육볶음")
                .foodData(new FoodData())
                .foodType(FoodType.NUTRITION)
                .build();
        em.persist(food);

        double weight = 100.0;
        LocalDateTime dateTime = LocalDateTime.now();

        // when
        Long dietId = dietService.addDiet(member.getId(), food.getId(), dateTime, weight, DietType.Lunch, FoodType.NUTRITION);

        // then
        Diet diet = dietRepository.findById(dietId).get();
        assertEquals(dietId, diet.getId());
        assertEquals(dateTime, diet.getDietDate());
    }

    @Test
    public void 식단_조회() throws Exception {
        // given

        // when
        // then
    }
}
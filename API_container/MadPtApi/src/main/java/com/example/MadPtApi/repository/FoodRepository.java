package com.example.MadPtApi.repository;

import com.example.MadPtApi.domain.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class FoodRepository {

    private final EntityManager em;

    // 저장
    public void save(Food food) {
        em.persist(food);
    }

    // 조회
    public Food findOne(Long id) {
        return em.find(Food.class, id);
    }
    // 음식 이름으로 여러개 조회
    public List<Food> findFoodByName (String foodName) {
        return em.createQuery("select f from Food f where f.foodName like :foodName", Food.class)
                .setParameter("foodName", "%"+foodName +"%")
                .getResultList();
    }

    // 커스텀 입력 저장
}

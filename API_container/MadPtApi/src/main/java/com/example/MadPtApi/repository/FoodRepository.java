package com.example.MadPtApi.repository;

import com.example.MadPtApi.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

/*    // 음식 이름으로 여러개 조회
    public List<Food> findFoodByName (String foodName) {
        return em.createQuery("select f from Food f where f.foodName like :foodName", Food.class)
                .setParameter("foodName", "%"+foodName +"%")
                .getResultList();
    }*/
    /**
     *     @Query("select d from Diet d where d.member.id = :memberId and d.dietDate between :start and :end")
     *     List<Diet> findDietsByMemberIdAndDietDate(@Param("memberId") Long memberId, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
     */

    List<Food> findFoodsByFoodNameIsContaining(String foodName);
}

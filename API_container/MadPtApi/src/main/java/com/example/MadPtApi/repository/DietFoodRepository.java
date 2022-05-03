package com.example.MadPtApi.repository;

import com.example.MadPtApi.domain.DietFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietFoodRepository extends JpaRepository<DietFood, Long> {
    List<DietFood> findDietFoodsByDietId(Long dietFoodId);
}

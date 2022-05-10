package com.example.MadPtApi.repository;

import com.example.MadPtApi.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    Goal findByMember_ClientId(Long id);
}

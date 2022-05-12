package com.example.MadPtApi.repository;

import com.example.MadPtApi.domain.Member;
import com.example.MadPtApi.domain.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
    List<Routine> findRoutinesByMember(Member member);

    List<Routine> findRoutinesByMemberId(Long memberId);
}

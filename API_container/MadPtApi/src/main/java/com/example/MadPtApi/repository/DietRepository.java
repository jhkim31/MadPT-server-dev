package com.example.MadPtApi.repository;

import com.example.MadPtApi.domain.Diet;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Repository
public interface DietRepository extends JpaRepository<Diet, Long> {

    @Query("select d from Diet d where d.member.id = :memberId and d.dietDate between :start and :end")
    List<Diet> findDietsByMemberIdAndDietDate(@Param("memberId") Long memberId, @Param("start") Date start, @Param("end") Date end);
}

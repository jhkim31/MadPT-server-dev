package com.example.MadPtApi.repository;

import com.example.MadPtApi.domain.Diet;
import com.example.MadPtApi.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    @Query("select r from Record r where r.member.id = :memberId and r.startTime between :start and :end")
    List<Record> findRecordByMemberIdAndRecordDate(@Param("memberId") Long memberId, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}

package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Member;
import com.example.MadPtApi.domain.Record;
import com.example.MadPtApi.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final MemberService memberService;

    /**
     * 운동 정보 저장
     */
    @Transactional
    public Long saveRecord(Record record) {
        recordRepository.save(record);
        return record.getId();
    }

    /**
     * 날짜별 운동 정보 조회
     */
    public List<Record> findRecord(Long memberId, LocalDateTime start, LocalDateTime end) {
        // 엔티티 조회
        Member member = memberService.findMember(memberId);

        return recordRepository.findRecordByMemberIdAndRecordDate(memberId, start, end);
    }



}

package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Exercise;
import com.example.MadPtApi.domain.ExerciseData;
import com.example.MadPtApi.domain.Member;
import com.example.MadPtApi.domain.Record;
import com.example.MadPtApi.dto.RecordDto;
import com.example.MadPtApi.dto.RecordSaveRequestDto;
import com.example.MadPtApi.repository.ExerciseRepository;
import com.example.MadPtApi.repository.MemberRepository;
import com.example.MadPtApi.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final ExerciseRepository exerciseRepository;

    /**
     * 운동 정보 저장
     */
    @Transactional
    public int saveRecord(Long memberId, RecordSaveRequestDto recordSaveRequestDto) {
        // 회원 엔티티
        Member member = memberRepository.findByClientId(memberId);
        int breakTime = recordSaveRequestDto.getBreakTime();

        List<RecordDto> recordDtoList = recordSaveRequestDto.getRecordDtoList();
        List<Record> recordList = new ArrayList<>();
        // Record 엔티티 생성
        for (RecordDto dto : recordDtoList) {
            Exercise exercise = exerciseRepository.findById(dto.getExerciseId()).orElseThrow(() -> new IllegalArgumentException("no such exercise data"));
            LocalDateTime startTime = timestampConverter(dto.getStartTime());
            LocalDateTime endTime = timestampConverter(dto.getEndTime());

            Record record = Record.builder()
                    .exercise(exercise)
                    .startTime(startTime)
                    .endTime(endTime)
                    .reps(dto.getReps())
                    .sets(dto.getSets())
                    .avgScore(dto.getAvgScore())
                    .breakTime(breakTime)
                    .build();
            record.setMember(member);

            recordList.add(record);

        }
        // 저장
        List<Record> savedRecordList = recordRepository.saveAll(recordList);

        return savedRecordList.size();
    }


    /**
     * 날짜별 운동 정보 조회
     */
    public List<Record> findRecord(Long memberId, LocalDateTime start, LocalDateTime end) {
        // 엔티티 조회
        Member member = memberService.findMember(memberId);

        return recordRepository.findRecordByMemberIdAndRecordDate(memberId, start, end);
    }

    private LocalDateTime timestampConverter(Long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone.getDefault().toZoneId());
    }


}

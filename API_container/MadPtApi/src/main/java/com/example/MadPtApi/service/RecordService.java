package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Exercise;
import com.example.MadPtApi.domain.ExerciseData;
import com.example.MadPtApi.domain.Member;
import com.example.MadPtApi.domain.Record;
import com.example.MadPtApi.dto.RecordRequestDto;
import com.example.MadPtApi.repository.ExerciseRepository;
import com.example.MadPtApi.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final MemberService memberService;
    private final ExerciseRepository exerciseRepository;

    /**
     * 운동 정보 저장
     */
    @Transactional
    public void saveRecord(Long memberId, List<RecordRequestDto> recordRequestDtoList) {
        // 회원 엔티티
        Member member = memberService.findMember(memberId);

        for (RecordRequestDto dto : recordRequestDtoList) {
            Exercise exercise = null;
            Optional<Exercise> exerciseResult = exerciseRepository.findById(dto.getExerciseId());
            if (exerciseResult.isPresent()) {
                exercise = exerciseResult.get();
            }
            ExerciseData exerciseData = ExerciseData.builder()
                    .reps(dto.getReps())
                    .build();

            Record record = Record.builder()
                    .member(member)
                    .exercise(exercise)
                    .startTime(dto.getStartTime())
                    .endTime(dto.getEndTime())
                    .exerciseData(exerciseData)
                    .build();

            recordRepository.save(record);
        }
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

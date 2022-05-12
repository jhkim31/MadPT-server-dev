package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Exercise;
import com.example.MadPtApi.domain.Routine;
import com.example.MadPtApi.domain.RoutineExercise;
import com.example.MadPtApi.domain.Member;
import com.example.MadPtApi.dto.routineDto.RoutineExerciseDto;
import com.example.MadPtApi.dto.routineDto.RoutineSaveRequestDto;
import com.example.MadPtApi.repository.ExerciseRepository;
import com.example.MadPtApi.repository.MemberRepository;
import com.example.MadPtApi.repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoutineService {

    private final RoutineRepository routineRepository;
    private final MemberRepository memberRepository;
    private final ExerciseRepository exerciseRepository;

    /**
     * 루틴 저장
     */
    @Transactional
    public Long saveRoutine(Long clientId, RoutineSaveRequestDto routineSaveRequestDto) {
        // 회원 엔티티 조회
        Member member = memberRepository.findByClientId(clientId);
        // timestamp -> LocalTimeDate
        LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(routineSaveRequestDto.getDate()), TimeZone.getDefault().toZoneId());
        // Routine 엔티티 생성
        Routine routine = Routine.builder()
                .member(member)
                .date(date)
                .breaktime(routineSaveRequestDto.getBreaktime())
                .name(routineSaveRequestDto.getRoutineName())
                .routineExerciseList(new ArrayList<>())
                .build();

        List<RoutineExerciseDto> routineExerciseDtoList = routineSaveRequestDto.getRoutineExerciseDtoList();
        // RoutineExercise 엔티티 생성
        for (RoutineExerciseDto dto : routineExerciseDtoList) {
            Exercise exercise = exerciseRepository.findById(dto.getExerciseId()).orElseThrow(() -> new IllegalArgumentException("no such exercise data"));
            RoutineExercise routineExercise = RoutineExercise.builder()
                    .exercise(exercise)
                    .reps(dto.getReps())
                    .sets(dto.getSets())
                    .build();

            routine.setRoutineExercise(routineExercise);
        }

        routineRepository.save(routine);

        return routine.getId();
    }

    /**
     * 루틴 조회
     */
    public List<Routine>  getRoutine(Long clientId) {
        Member member = memberRepository.findByClientId(clientId);

        return routineRepository.findRoutinesByMemberId(member.getId());
    }

    /**
     * 루틴 수정
     */

    /**
     * 루틴 삭제
     */
}

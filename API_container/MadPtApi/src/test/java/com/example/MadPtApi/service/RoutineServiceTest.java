package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Exercise;
import com.example.MadPtApi.domain.Member;
import com.example.MadPtApi.domain.Routine;
import com.example.MadPtApi.domain.RoutineExercise;
import com.example.MadPtApi.repository.ExerciseRepository;
import com.example.MadPtApi.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RoutineServiceTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    RoutineService routineService;
    @Autowired
    ExerciseRepository exerciseRepository;
    /**
     * 루틴 조회
     */
    @Test
    public void 루틴_조회() throws Exception {
        Member member = memberRepository.findByClientId(1L);
        Exercise exercise = exerciseRepository.findById(1L).get();
        // given
        RoutineExercise routineExercise = RoutineExercise.builder()
                .exercise(exercise)
                .reps(10)
                .sets(10)
                .build();

        Routine routine = Routine.builder()
                .name("testRoutine")
                .member(member)
                .date(LocalDateTime.now())
                .routineExerciseList(new ArrayList<>())
                .build();

        routine.setRoutineExercise(routineExercise);

        // when
        List<Routine> routineList = routineService.getRoutine(member.getClientId());

        // then
        assertEquals(1, routineList.size());
        System.out.println(routineList.get(0).getId());
    }

}
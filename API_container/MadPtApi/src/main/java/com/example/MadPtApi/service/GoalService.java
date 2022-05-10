package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Goal;
import com.example.MadPtApi.domain.Member;
import com.example.MadPtApi.dto.goalDto.GoalSaveRequestDto;
import com.example.MadPtApi.repository.GoalRepository;
import com.example.MadPtApi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalService {

    private final GoalRepository goalRepository;
    private final MemberRepository memberRepository;

    /**
     * 목표 저장
     */
    public Long saveGoal(Long clientId, GoalSaveRequestDto dto) {
        Member member = memberRepository.findByClientId(clientId);

        Goal existGaol = goalRepository.findByMember_ClientId(member.getClientId());
        Goal goal;
        if (existGaol == null) {
            goal = Goal.builder()
                    .member(member)
                    .dietKcal(dto.getDietKcal())
                    .exerciseKcal(dto.getExerciseKcal())
                    .weight(dto.getWeight())
                    .build();
        } else {
            goal = Goal.builder()
                    .member(member)
                    .id(existGaol.getId())
                    .dietKcal(dto.getDietKcal())
                    .exerciseKcal(dto.getExerciseKcal())
                    .weight(dto.getWeight())
                    .build();
        }

        goalRepository.save(goal);

        return goal.getId();
    }

    /**
     * 목표 조회
     */

}

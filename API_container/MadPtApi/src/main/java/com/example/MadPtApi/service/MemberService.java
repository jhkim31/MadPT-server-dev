package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.GenderType;
import com.example.MadPtApi.domain.Goal;
import com.example.MadPtApi.domain.Member;
import com.example.MadPtApi.dto.memberDto.MemberSignUpDto;
import com.example.MadPtApi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final GoalService goalService;

    /*
     * 회원 가입
     */
    @Transactional
    public Long join(Long clientId, MemberSignUpDto memberSignUpDto) {
        Member member = Member.builder()
                .clientId(clientId)
                .name(memberSignUpDto.getName())
                .height(memberSignUpDto.getHeight())
                .weight(memberSignUpDto.getWeight())
                .genderType(GenderType.valueOf(memberSignUpDto.getGenderType()))
                .build();

        memberRepository.save(member);

        // 회원 가입시 회원 목표 초기화
        goalService.setGoal(member);

        return member.getId();
    }
/*

    // 회원 중복 확인
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
*/
    /**
     * 회원 몸무게 조회
     */
    public double getMemberWeight(Long clientId) {
        Member member = memberRepository.findByClientId(clientId);
        return member.getWeight();
    }

    /**
     * 회원 몸무게 수정 -> JPA Dirty Checking 활용
     */
    @Transactional
    public void updateMemberWeight(Long clientId, double weight) {
        Member member = memberRepository.findByClientId(clientId);
        member.updateWeight(weight);
    }

    /**
     * 회원 조회
     */
    public Member findMember(Long clientId) {
        return memberRepository.findByClientId(clientId);
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
}

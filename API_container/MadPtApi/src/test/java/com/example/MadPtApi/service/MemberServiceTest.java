package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Member;
import com.example.MadPtApi.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    public void 회원_가입() throws Exception {
        // given

        // when

        // then
    }
/*
    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");
        Member member2 = new Member();
        member2.setName("kim");

        // when
        memberService.join(member1);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }*/

    @Test
    public void 회원_조회_테스트() throws Exception {
        // given
        Long clientId = 1L;
        // when
        Member member = memberRepository.findByClientId(clientId);
        // then
        System.out.println(member.getId());
    }

    @Test
    public void 회원_로그인() throws Exception {
        // given
        Long clientId = 1L;
        // when
        Member member = memberService.findMember(1L);
        // then
        assertEquals(2L, member.getId());
    }
}
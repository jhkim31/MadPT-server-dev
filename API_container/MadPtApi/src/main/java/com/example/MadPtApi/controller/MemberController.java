package com.example.MadPtApi.controller;

import com.example.MadPtApi.dto.PostResponseDto;
import com.example.MadPtApi.dto.memberDto.MemberSignUpDto;
import com.example.MadPtApi.dto.memberDto.MemberWeightUpdateDto;
import com.example.MadPtApi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 가입
     */
    @PostMapping("/sign-up")
    public PostResponseDto singUp(@RequestHeader("member_id") Long clientId, @RequestBody MemberSignUpDto memberSignUpDto) {
        Long memberId = memberService.join(clientId, memberSignUpDto);
        PostResponseDto postResponseDto;
        if (memberId != 0L) {
            postResponseDto = PostResponseDto.builder()
                    .success(0)
                    .error(0)
                    .result("success")
                    .build();
        } else {
            postResponseDto = PostResponseDto.builder()
                    .success(1)
                    .error(1)
                    .result("fail")
                    .build();
        }

        return postResponseDto;
    }

    /**
     * 로그인
     */
    @GetMapping("/login")
    public boolean login(@RequestHeader("member_id") Long clientId) {
        boolean loginCheck = false;
        if (memberService.findMember(clientId) != null) {
            loginCheck = true;
        }
        return loginCheck;
    }

    /**
     * 회원 몸무게 수정
     */
    @PostMapping("/update-weight")
    public void updateMemberWeight(@RequestHeader("member_id") Long clientId, @RequestBody MemberWeightUpdateDto memberWeightUpdateDto) {
        memberService.updateMemberWeight(clientId, memberWeightUpdateDto.getWeight());
    }
}

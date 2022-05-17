package com.example.MadPtApi.controller;

import com.example.MadPtApi.dto.socialDto.SocialMemberDto;
import com.example.MadPtApi.dto.socialDto.SocialRankDto;
import com.example.MadPtApi.service.SocialService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/social")
@RequiredArgsConstructor
public class SocialController {

    private final SocialService socialService;

    @GetMapping("/rank")
    public SocialRankDto getFriendList(@Param("date") Long date) {
        List<SocialMemberDto> rankList = socialService.getRankList(date);

        return SocialRankDto.builder().friends(rankList).build();
    }

}

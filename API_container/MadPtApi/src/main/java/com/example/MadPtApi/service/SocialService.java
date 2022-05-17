package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Member;
import com.example.MadPtApi.dto.recordDto.DailyRecordResponseDto;
import com.example.MadPtApi.dto.socialDto.SocialMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialService {

    private final MemberService memberService;
    private final RecordService recordService;


    /**
     * 랭킹 조회
     */
    public List<SocialMemberDto> getRankList(Long date) {
        // 회원 목록 조회
        List<Member> memberList = memberService.findMembers();

        List<SocialMemberDto> dtoList = new ArrayList<>();

        for (Member member : memberList) {
            List<DailyRecordResponseDto> recordList = recordService.findRecord(member.getClientId(), date);
            double burnedKcal = 0;
            for (DailyRecordResponseDto dto : recordList) {
                burnedKcal += dto.getBurnedKcal();
            }
            SocialMemberDto socialMemberDto = SocialMemberDto.builder()
                    .name(member.getName())
                    .burnedKcal(burnedKcal)
                    .build();
            dtoList.add(socialMemberDto);
        }
        // 내림차순 정렬
        dtoList.sort((SocialMemberDto o1, SocialMemberDto o2) -> (int) (o2.getBurnedKcal() - o1.getBurnedKcal()));

        return dtoList;
    }
}

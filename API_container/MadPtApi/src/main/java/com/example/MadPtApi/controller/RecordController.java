package com.example.MadPtApi.controller;

import com.example.MadPtApi.dto.PostResponseDto;
import com.example.MadPtApi.dto.RecordDto;
import com.example.MadPtApi.dto.RecordSaveRequestDto;
import com.example.MadPtApi.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @PostMapping("/result")
    public PostResponseDto saveRecord(@RequestHeader("member_id") Long id, @RequestBody RecordSaveRequestDto recordRequestDto) {

        // record Service
        int resultSize = recordService.saveRecord(id, recordRequestDto);

        PostResponseDto postResponseDto;
        if (resultSize > 0) {
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
}

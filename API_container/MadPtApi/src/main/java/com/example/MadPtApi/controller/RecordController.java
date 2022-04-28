package com.example.MadPtApi.controller;

import com.example.MadPtApi.dto.RecordRequestDto;
import com.example.MadPtApi.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @PostMapping("/fitness/save-results")
    public void saveRecord(@RequestHeader("memberId") Long id, @RequestBody List<RecordRequestDto> recordRequestDtoList) {
        recordService.saveRecord(id, recordRequestDtoList);
    }
}

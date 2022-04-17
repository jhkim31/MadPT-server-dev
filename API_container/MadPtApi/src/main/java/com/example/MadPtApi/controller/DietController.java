package com.example.MadPtApi.controller;

import com.example.MadPtApi.dto.dietDto.DietSaveRequestDto;
import com.example.MadPtApi.service.DietService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/diet")
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @PostMapping
    public void saveDiet(@RequestHeader("memberId") Long id, @RequestBody String date, @RequestBody String diet_type, @RequestBody List<DietSaveRequestDto> dietSaveRequestDto) {
        dietService.addDietList(id, LocalDateTime.parse(date), diet_type, dietSaveRequestDto);
    }

}

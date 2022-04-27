package com.example.MadPtApi.controller;
import com.example.MadPtApi.dto.dietDto.DietSaveRequestDto;
import com.example.MadPtApi.service.DietService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/diet")
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @PostMapping
    public boolean saveDiet(@RequestHeader("memberId") Long id, @RequestBody DietSaveRequestDto dietSaveRequestDto) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(dietSaveRequestDto.getDate()), TimeZone.getDefault().toZoneId());
        System.out.println(localDateTime);
        System.out.println(dietSaveRequestDto.getDietType());
        System.out.println(dietSaveRequestDto.getDietList().get(0).getFoodName());
        System.out.println("check");
        Long diet_id = dietService.addDietList(id, localDateTime, dietSaveRequestDto.getDietType(), dietSaveRequestDto.getDietList());
        System.out.println("diet saved : " + diet_id);
        return true;
    }

}
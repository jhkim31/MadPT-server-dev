package com.example.MadPtApi.controller;

import com.example.MadPtApi.dto.dietDto.DietSaveRequestDto;
import com.example.MadPtApi.service.DietService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diet")
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @PostMapping
    public void saveDiet(@RequestBody DietSaveRequestDto dietSaveRequestDto) {

    }

    @GetMapping
    public void getDiet() {

    }
}

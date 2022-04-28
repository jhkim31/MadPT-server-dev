package com.example.MadPtApi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordRequestDto {
    private Long exerciseId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int score;
    // reps를 list로 받아야할듯
    private int[] reps;
}

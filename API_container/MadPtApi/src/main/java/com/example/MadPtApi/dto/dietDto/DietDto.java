package com.example.MadPtApi.dto.dietDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietDto {
    private String foodName;
    private LocalDateTime localDateTime;
    private double kcal;
    private double weight;
    private int count;
    private String unit;
}

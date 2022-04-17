package com.example.MadPtApi.dto.dietDto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietSaveRequestDto {
    private String foodId;
    private String foodName;
    private String dietType;
    private int weight;
    private int count;
    private String unit;
    private boolean isCustom;
}

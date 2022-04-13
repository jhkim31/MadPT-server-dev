package com.example.MadPtApi.dto.dietDto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietSaveRequestDto {
    private String memberId;
    private String foodId;
    private String foodName;
    private String foodType;
    private String dietType;
    private int weight;
}

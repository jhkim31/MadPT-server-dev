package com.example.MadPtApi.dto.statisticDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalendarDto {
    @JsonProperty("monthly_data")
    List<CalendarDailyDto> dailyDtoList;
}

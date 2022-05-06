package com.example.MadPtApi.dto.recordDto;

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
public class DailyRecordListResponseDto {
    @JsonProperty("record_list")
    private List<DailyRecordResponseDto> recordResponseDtoList;
}

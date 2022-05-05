package com.example.MadPtApi.dto;

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
public class RecordSaveRequestDto {
    @JsonProperty("breaktime")
    private int breakTime;
    @JsonProperty("records")
    private List<RecordDto> recordDtoList;
}

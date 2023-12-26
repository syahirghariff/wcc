package com.wcc.distanceservice.dto;

import com.wcc.dto.PostcodeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DistanceResponse {
    private PostcodeDto from;
    private PostcodeDto to;
    private Double distance;
    private final String unit="km";
}

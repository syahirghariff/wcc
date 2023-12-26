package com.wcc.distanceservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DistanceRequest {
    @NotNull
    private String from;

    @NotNull
    private String to;
}

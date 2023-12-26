package com.wcc.distanceservice.controller;

import com.wcc.distanceservice.dto.DistanceRequest;
import com.wcc.distanceservice.dto.DistanceResponse;
import com.wcc.distanceservice.service.DistanceService;
import com.wcc.dto.Response;
import com.wcc.util.ResponseUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/distance")
@Slf4j
public class DistanceController {

    private final DistanceService distanceService;

    @Autowired
    public DistanceController(DistanceService distanceService){
        this.distanceService = distanceService;
    }

    @PostMapping
    public ResponseEntity<Response<DistanceResponse>> calculateDistance (@RequestBody @Valid DistanceRequest request) {
        log.info("POST DISTANCE={}", request);
        DistanceResponse response = distanceService.getDistanceBetweenPostcodes(request);
        log.info("RESULT={}", response);
        return ResponseUtil.successResponse(response);
    }
}

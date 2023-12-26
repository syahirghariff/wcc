package com.wcc.postcodeservice.controller;

import com.wcc.dto.PostcodeDto;
import com.wcc.dto.Response;
import com.wcc.postcodeservice.service.PostcodeService;
import com.wcc.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/postcode")
@Slf4j
public class PostcodeController {

    private final PostcodeService postcodeService;

    @Autowired
    public PostcodeController(PostcodeService postcodeService) {
        this.postcodeService = postcodeService;
    }

    @PutMapping
    public ResponseEntity<Response<PostcodeDto>> updatePostcode(@RequestBody PostcodeDto postcode){
        log.info("PUT POSTCODE={}", postcode);
        PostcodeDto results = postcodeService.updatePostcode(postcode);
        log.info("RESULT={}", results);
        return ResponseUtil.successResponse(results);
    }

    @GetMapping("/{postcode}")
    public ResponseEntity<Response<PostcodeDto>> getByPostcode(@PathVariable String postcode) {
        log.info("GET POSTCODE={}", postcode);
        PostcodeDto results = postcodeService.findByPostcode(postcode);
        log.info("RESULT={}", results);
        return ResponseUtil.successResponse(results);
    }
}

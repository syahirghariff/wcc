package com.wcc.distanceservice.feign;

import com.wcc.dto.PostcodeDto;
import com.wcc.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("postcode-service")
public interface PostcodeService {

    @GetMapping("/api/v1/postcode/{postcode}")
    Response<PostcodeDto> getByPostcode(@PathVariable String postcode);
}

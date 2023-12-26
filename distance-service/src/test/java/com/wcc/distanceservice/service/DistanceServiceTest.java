package com.wcc.distanceservice.service;

import com.wcc.distanceservice.dto.DistanceRequest;
import com.wcc.distanceservice.dto.DistanceResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DistanceServiceTest {

    @Autowired
    DistanceService distanceService;

    @Test
    public void calculateDistance(){
        String from = "AB10 1XG";
        String to = "AB10 6RN";

        DistanceRequest distanceRequest = new DistanceRequest();
        distanceRequest.setFrom(from);
        distanceRequest.setTo(to);

        DistanceResponse response = distanceService.getDistanceBetweenPostcodes(distanceRequest);
        Assert.assertEquals(response.getDistance(), Double.valueOf(0.8050258301348989));
    }
}

package com.wcc.postcodeservice.service;

import com.wcc.dto.PostcodeDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PostcodeServiceTest {

    @Autowired
    PostcodeService postcodeService;

    @Test
    public void findByPostcode(){

        String testPostcode = "AB10 1XG";
        PostcodeDto postcode = postcodeService.findByPostcode(testPostcode);

        PostcodeDto test = PostcodeDto.builder()
                .postcode("AB10 1XG")
                .latitude(BigDecimal.valueOf(57.14415601))
                .longitude(BigDecimal.valueOf(-2.11486401))
                .build();

        Assert.assertEquals(postcode, test);
    }
}

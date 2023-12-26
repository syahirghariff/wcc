package com.wcc.postcodeservice.service;

import com.wcc.dto.PostcodeDto;
import com.wcc.postcodeservice.exception.RecordNotFoundException;
import com.wcc.postcodeservice.model.Postcode;
import com.wcc.postcodeservice.repository.PostcodeRepo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostcodeServiceImpl implements PostcodeService{

    private final PostcodeRepo postcodeRepo;

    @Autowired
    public PostcodeServiceImpl(PostcodeRepo postcodeRepo){
        this.postcodeRepo = postcodeRepo;
    }

    @Override
    public PostcodeDto findByPostcode(String postcode) {
        return postcodeRepo.findByPostcode(postcode)
                .map(pc -> PostcodeDto.builder()
                        .postcode(pc.getPostcode())
                        .longitude(pc.getLongitude())
                        .latitude(pc.getLatitude())
                        .build())
                .orElseThrow(()-> new RecordNotFoundException("Postcode cannot be found"));
    }

    @Override
    public PostcodeDto updatePostcode(PostcodeDto postcodeDto) {
        PostcodeDto response = new PostcodeDto();
        postcodeRepo.findByPostcode(postcodeDto.getPostcode())
                .ifPresentOrElse(postcode -> {
                    Optional.ofNullable(postcodeDto.getLatitude())
                            .ifPresent(postcode::setLatitude);

                    Optional.ofNullable(postcodeDto.getLongitude())
                            .ifPresent(postcode::setLongitude);

                    Postcode results = postcodeRepo.save(postcode);
                    if (ObjectUtils.isNotEmpty(results)) {
                        response.setPostcode(results.getPostcode())
                                .setLatitude(results.getLatitude())
                                .setLongitude(results.getLongitude());
                    }
                },
                ()->{ throw new RecordNotFoundException("Postcode cannot be found"); });

        return response;
    }
}

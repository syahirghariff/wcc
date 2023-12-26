package com.wcc.postcodeservice.service;

import com.wcc.dto.PostcodeDto;

public interface PostcodeService {

    PostcodeDto findByPostcode(String postcode);

    PostcodeDto updatePostcode(PostcodeDto postcodeDto);

}

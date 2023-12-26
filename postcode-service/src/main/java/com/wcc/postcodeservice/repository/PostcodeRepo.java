package com.wcc.postcodeservice.repository;

import com.wcc.postcodeservice.model.Postcode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostcodeRepo extends JpaRepository<Postcode, Integer> {

    Optional<Postcode> findByPostcode(String postcode);
}

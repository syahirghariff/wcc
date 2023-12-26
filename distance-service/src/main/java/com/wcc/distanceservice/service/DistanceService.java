package com.wcc.distanceservice.service;

import com.wcc.distanceservice.dto.DistanceRequest;
import com.wcc.distanceservice.dto.DistanceResponse;
import com.wcc.distanceservice.exception.RecordNotFoundException;
import com.wcc.distanceservice.feign.PostcodeService;
import com.wcc.dto.PostcodeDto;
import com.wcc.dto.Response;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistanceService {

    private final PostcodeService postcodeService;

    private final static double EARTH_RADIUS = 6371;

    @Autowired
    public DistanceService(PostcodeService postcodeService){
        this.postcodeService = postcodeService;
    }

    public DistanceResponse getDistanceBetweenPostcodes(DistanceRequest request){

        var fromOptional = Optional.of(postcodeService.getByPostcode(StringUtils.upperCase(request.getFrom())));
        fromOptional.map(Response::getStatus)
                .filter(s-> s == HttpStatus.NOT_FOUND)
                .ifPresent((s)-> {throw new RecordNotFoundException("From Postcode cannot be found");});

        var toOptional = Optional.of(postcodeService.getByPostcode(StringUtils.upperCase(request.getTo())));
        toOptional.map(Response::getStatus)
                .filter(s-> s == HttpStatus.NOT_FOUND)
                .ifPresent((s)-> {throw new RecordNotFoundException("To Postcode cannot be found");});

        PostcodeDto from = fromOptional.map(Response::getResponse)
                .orElse(null);

        PostcodeDto to = toOptional.map(Response::getResponse)
                .orElse(null);

        if (ObjectUtils.anyNull(from, to)) {
            throw new RecordNotFoundException("From/To Postcode cannot be found");
        }

        Double distance = calculateDistance(from.getLatitude().doubleValue(),
                from.getLongitude().doubleValue(),
                to.getLatitude().doubleValue(),
                to.getLongitude().doubleValue());

        return DistanceResponse.builder()
                .from(from)
                .to(to)
                .distance(distance)
                .build();
    }

    private double calculateDistance(double latitude, double longitude,
                                     double latitude2, double longitude2) {
        double lon1Radians = Math.toRadians(longitude);
        double lon2Radians = Math.toRadians(longitude2);
        double lat1Radians = Math.toRadians(latitude);
        double lat2Radians = Math.toRadians(latitude2);
        double a = haversine(lat1Radians, lat2Radians)
                + Math.cos(lat1Radians) * Math.cos(lat2Radians) * haversine(lon1Radians, lon2Radians);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return (EARTH_RADIUS * c);
    }

    private double haversine(double deg1, double deg2) {
        return square(Math.sin((deg1 - deg2) / 2.0));
    }
    private double square(double x) {
        return x * x;
    }
}

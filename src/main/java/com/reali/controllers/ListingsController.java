package com.reali.controllers;

import com.reali.entities.House;
import com.reali.response.Feature;
import com.reali.response.FeatureCollection;
import com.reali.response.Geometry;
import com.reali.response.HousePropertiesMap;
import com.reali.services.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListingsController {
    private Logger logger = LoggerFactory.getLogger(ListingsController.class);

    @Autowired
    private HouseService houseService;

    @GetMapping("/listings")
    public ResponseEntity<?> searchListings(
            @RequestParam(value="min_price", required=false) String minPrice,
            @RequestParam(value="max_price", required=false) String maxPrice,
            @RequestParam(value="min_bed", required=false) String minBed,
            @RequestParam(value="max_bed", required=false) String maxBed,
            @RequestParam(value="min_bath", required=false) String minBath,
            @RequestParam(value="max_bath", required=false) String maxBath
    ) {

        int minPriceInt = Integer.MIN_VALUE;
        int maxPriceInt = Integer.MAX_VALUE;
        int minBedInt = Integer.MIN_VALUE;
        int maxBedInt = Integer.MAX_VALUE;
        int minBathInt = Integer.MIN_VALUE;
        int maxBathInt = Integer.MAX_VALUE;

        try {
            if (minPrice != null && minPrice.length() > 0) {
                minPriceInt = Integer.parseInt(minPrice);
            }
            if (maxPrice != null && maxPrice.length() > 0) {
                maxPriceInt = Integer.parseInt(maxPrice);
            }
            if (minBed != null && minBed.length() > 0) {
                minBedInt = Integer.parseInt(minBed);
            }
            if (maxBed != null && maxBed.length() > 0) {
                maxBedInt = Integer.parseInt(maxBed);
            }
            if (minBath != null && minBath.length() > 0) {
                minBathInt = Integer.parseInt(minBath);
            }
            if (maxBath != null && maxBath.length() > 0) {
                maxBathInt = Integer.parseInt(maxBath);
            }

        } catch(NumberFormatException nfe) {
            logger.error("Invalid/Incorrect search parameter: ", nfe);
            return ResponseEntity.badRequest().build();
        }


        List<House> results = houseService.findByParams(minPriceInt, maxPriceInt, minBedInt, maxBedInt, minBathInt, maxBathInt);

        FeatureCollection responseObject = createResponseBody(results);


        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(responseObject);
    }

    private FeatureCollection createResponseBody(List<House> results) {
        FeatureCollection fc = new FeatureCollection();
        for(House house: results) {
            Feature feature = new Feature(house);
            fc.addFeature(feature);
        }
        return fc;
    }
}

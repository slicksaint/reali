package com.reali.services;

import com.reali.entities.House;
import com.reali.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    public List<House> findByParams(
            int minPrice, int maxPrice, int minBeds, int maxBeds, int minBaths, int maxBaths) {
        return houseRepository.findByPriceBetweenAndBedroomsBetweenAndBathroomsBetween(
                minPrice, maxPrice, minBeds, maxBeds, minBaths, maxBaths);
    }
}

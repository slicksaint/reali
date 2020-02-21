package com.reali.repositories;

import com.reali.entities.House;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HouseRepository extends CrudRepository<House, Long> {
    List<House> findByPriceBetweenAndBedroomsBetweenAndBathroomsBetween(
            int minPrice, int maxPrice, int minBeds, int maxBeds, int minBaths, int maxBaths);
}

package com.reali.response;

import com.reali.entities.House;

import java.util.HashMap;
import java.util.Map;

public class HousePropertiesMap extends HashMap<String, Object> {

    public HousePropertiesMap(House house) {
        this.put("id", house.getId());
        this.put("street", house.getStreet());
        this.put("status", house.getStatus());
        this.put("price", house.getPrice());
        this.put("bedrooms", house.getBedrooms());
        this.put("bathrooms", house.getBathrooms());
        this.put("sq_ft", house.getSq_ft());
    }

}

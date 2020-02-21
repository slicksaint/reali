package com.reali.response;


import com.reali.entities.House;

import java.io.Serializable;

public class Feature implements Serializable {
    private String type = "Feature";

    private Geometry geometry;

    private HousePropertiesMap properties;

    public Feature(Geometry geometry, HousePropertiesMap properties) {
        this.geometry = geometry;
        this.properties = properties;
    }

    public Feature(House house) {
        this.geometry = new Geometry(house.getLat(), house.getLng());
        this.properties = new HousePropertiesMap(house);
    }

    public String getType() {
        return type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public HousePropertiesMap getProperties() {
        return properties;
    }
}

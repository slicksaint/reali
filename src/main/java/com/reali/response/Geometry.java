package com.reali.response;

import java.io.Serializable;

public class Geometry  implements Serializable {
    private String type = "Point";

    private double[] coordinates = new double[2];

    public Geometry(double lat, double lan) {
        coordinates[0] = lat;
        coordinates[1] = lan;
    }

    public String getType() {
        return type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }
}

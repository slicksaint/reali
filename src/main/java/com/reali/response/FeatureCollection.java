package com.reali.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FeatureCollection implements Serializable {
    private String type = "FeatureCollection";

    private List<Feature> features = new ArrayList<Feature>();

    public String getType() {
        return type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public void addFeature(Feature feature) {
        this.features.add(feature);
    }
}

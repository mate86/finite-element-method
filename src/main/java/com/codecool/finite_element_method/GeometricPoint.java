package com.codecool.finite_element_method;

import java.util.Map;

public abstract class GeometricPoint {
    protected Map<String, Double> coordinates;

    public Map<String, Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Map<String, Double> coordinates) {
        this.coordinates = coordinates;
    }
}

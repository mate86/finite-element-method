package com.codecool.finite_element_method;

import java.util.HashMap;

public class PointOfRod extends GeometricPoint {
    public PointOfRod(double coordinateX) {
        this.coordinates = new HashMap<>();
        this.coordinates.put("x", coordinateX);
        this.coordinates.put("y", 0.0);
    }
}

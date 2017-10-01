package com.codecool.finite_element_method;

import java.util.ArrayList;
import java.util.HashMap;

public class Rod extends GeometricObject {

    public Rod(double rodLength, int numberOfPoints) {
        this.objectSize = new HashMap<>();
        this.objectSize.put("x", rodLength);
        this.numberOfPoints = numberOfPoints;
        this.geometricPointList = new ArrayList<>();
    }

    @Override
    public void deformingObject(Force force) {
    }
}

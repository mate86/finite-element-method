package com.codecool.finite_element_method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Rod extends GeometricObject {

    public Rod(double rodLength, int numberOfPoints) {
        this.objectSize = new HashMap<>();
        this.objectSize.put("x", rodLength);
        this.numberOfPoints = numberOfPoints;
        this.geometricPointList = dividingObjectToPoints();
    }

    @Override
    protected List<GeometricPoint> dividingObjectToPoints() {
        List<GeometricPoint> geometricPoints = new ArrayList<>();
        double rodLength = objectSize.get("x");
        double distanceOfPoints = rodLength / (numberOfPoints - 1);
        for (int i = 0; i < numberOfPoints - 1; i++) {
            GeometricPoint newPoint = new PointOfRod(distanceOfPoints * i);
            geometricPoints.add(newPoint);
        }
        GeometricPoint newPoint = new PointOfRod(rodLength);
        geometricPoints.add(newPoint);
        return geometricPoints;
    }

    @Override
    public void deformingObject(Force force) {
    }
}

package com.codecool.finite_element_method;

import java.util.List;
import java.util.Map;

public abstract class GeometricObject {
    protected Map<String, Double> objectSize;
    protected int numberOfPoints;
    protected List<GeometricPoint> geometricPointList;

    public Map<String, Double> getObjectSize() {
        return objectSize;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public List<GeometricPoint> getGeometricPointList() {
        return geometricPointList;
    }

    abstract protected List<GeometricPoint> dividingObjectToPoints();

    abstract public void deformingObject(Force force);
}

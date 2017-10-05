package com.codecool.finite_element_method;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Rod {
    protected double objectSize;
    protected int numberOfPoints;
    protected List<Point2D> geometricPointList;

    public Rod(double objectSize, int numberOfPoints) {
        this.objectSize = objectSize;
        this.numberOfPoints = numberOfPoints;
        this.geometricPointList = dividingObjectToPoints();
    }

    public double getObjectSize() {
        return objectSize;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
        this.geometricPointList = dividingObjectToPoints();
    }

    public List<Point2D> getGeometricPointList() {
        return geometricPointList;
    }

    protected List<Point2D> dividingObjectToPoints() {
        List<Point2D> geometricPoints = new ArrayList<>();
        double distanceOfPoints = objectSize / (numberOfPoints - 1);
        for (int i = 0; i < numberOfPoints - 1; i++) {
            Point2D newPoint = new Point2D(distanceOfPoints * i, 0.0);
            geometricPoints.add(newPoint);
        }
        Point2D newPoint = new Point2D(objectSize, 0.0);
        geometricPoints.add(newPoint);
        return geometricPoints;
    }

    public void deformingObject(Force force) {

    }
}

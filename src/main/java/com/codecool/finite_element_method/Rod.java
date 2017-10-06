package com.codecool.finite_element_method;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public abstract class Rod {
    protected double rodLength;
    protected double E; // Young-modulus
    protected double I; // Second moment of area
    protected List<Point2D> geometricPointList;

    public double getRodLength() {
        return rodLength;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.geometricPointList = dividingObjectToPoints(numberOfPoints);
    }

    public List<Point2D> getGeometricPointList() {
        return geometricPointList;
    }

    protected void setGeometricPointList(List<Point2D> geometricPointList) {
        this.geometricPointList = geometricPointList;
    }

    protected List<Point2D> dividingObjectToPoints(int numberOfPoints) {
        List<Point2D> geometricPoints = new ArrayList<>();
        double distanceOfPoints = rodLength / (numberOfPoints - 1);
        for (int i = 0; i < numberOfPoints - 1; i++) {
            Point2D newPoint = new Point2D(distanceOfPoints * i, 0.0);
            geometricPoints.add(newPoint);
        }
        Point2D newPoint = new Point2D(rodLength, 0.0);
        geometricPoints.add(newPoint);
        return geometricPoints;
    }

    public abstract Rod deformingObject(Force force);

    protected double calculatingCoordinateY(double coordinateX, Force force) {
        return -force.getMagnitude() * Math.sin(Math.toRadians(force.getAngle())) * Math.pow(coordinateX, 2) * (3 * rodLength - coordinateX) / (6 * E * I);
    }
}

package com.codecool.finite_element_method;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Rod {
    private double rodLength;
    private int numberOfPoints;
    private double R; // Radius in metre
    private double E; // Young-modulus
    private double I; // Second moment of area
    private List<Point2D> geometricPointList;


    public Rod(double rodLength, double R, double E, int numberOfPoints) {
        this.rodLength = rodLength;
        this.numberOfPoints = numberOfPoints;
        this.geometricPointList = dividingObjectToPoints();
        this.R = R;
        this.E = E; // Steel
        this.I = Math.PI / 4 * Math.pow(R, 4);
    }

    public double getRodLength() {
        return rodLength;
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

    private void setGeometricPointList(List<Point2D> geometricPointList) {
        this.geometricPointList = geometricPointList;
    }

    private List<Point2D> dividingObjectToPoints() {
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

    public Rod deformingObject(Force force) {
        List<Point2D> newPointList = new ArrayList<>();
        for (Point2D point : geometricPointList) {
            Point2D newPoint = new Point2D(point.getX(), calculatingCoordinateY(point.getX(), force));
            newPointList.add(newPoint);
        }
        Rod newRod = new Rod(rodLength, R, E, numberOfPoints);
        newRod.setGeometricPointList(newPointList);
        return newRod;
    }

    private double calculatingCoordinateY(double coordinateX, Force force) {
        return -force.getMagnitude() * Math.sin(Math.toRadians(force.getAngle())) * Math.pow(coordinateX, 2) * (3 * rodLength - coordinateX) / (6 * E * I);
    }
}

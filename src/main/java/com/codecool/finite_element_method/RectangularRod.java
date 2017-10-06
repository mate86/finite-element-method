package com.codecool.finite_element_method;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class RectangularRod extends Rod {
    protected double a;
    protected double b;

    public RectangularRod(double rodLength, double a, double b, double E, int numberOfPoints) {
        this.rodLength = rodLength;
        this.geometricPointList = dividingObjectToPoints(numberOfPoints);
        this.a = a;
        this.b = b;
        this.E = E;
        this.I = a * Math.pow(b, 3) / 12;
    }

    @Override
    public RectangularRod deformingObject(Force force) {
        List<Point2D> newPointList = new ArrayList<>();
        for (Point2D point : geometricPointList) {
            Point2D newPoint = new Point2D(point.getX(), calculatingCoordinateY(point.getX(), force));
            newPointList.add(newPoint);
        }
        RectangularRod newRectangularRod = new RectangularRod(rodLength, a, b, E, geometricPointList.size());
        newRectangularRod.setGeometricPointList(newPointList);
        return newRectangularRod;
    }
}

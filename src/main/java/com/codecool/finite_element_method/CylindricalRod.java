package com.codecool.finite_element_method;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class CylindricalRod extends Rod {
    protected double R; // Radius in metre

    public CylindricalRod(double rodLength, double R, double E, int numberOfPoints) {
        this.rodLength = rodLength;
        this.geometricPointList = dividingObjectToPoints(numberOfPoints);
        this.R = R;
        this.E = E;
        this.I = Math.PI / 4 * Math.pow(R, 4);
    }

    @Override
    public CylindricalRod deformingObject(Force force) {
        List<Point2D> newPointList = new ArrayList<>();
        for (Point2D point : geometricPointList) {
            Point2D newPoint = new Point2D(point.getX(), calculatingCoordinateY(point.getX(), force));
            newPointList.add(newPoint);
        }
        CylindricalRod newCylindricalRod = new CylindricalRod(rodLength, R, E, geometricPointList.size());
        newCylindricalRod.setGeometricPointList(newPointList);
        return newCylindricalRod;
    }
}

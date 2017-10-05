package com.codecool.finite_element_method;

import javafx.geometry.Point2D;


public class Force {
    private double magnitude;
    private double angle;
    private Point2D coordinatesOfForce;

    public Force(double magnitude, double angle) {
        this.magnitude = magnitude;
        this.angle = angle;
        this.coordinatesOfForce = new Point2D(Math.round(magnitude * Math.cos(Math.toRadians(angle))), Math.round(magnitude * Math.sin(Math.toRadians(angle))));
    }

    public Point2D getCoordinatesOfForce() {
        return coordinatesOfForce;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
        this.coordinatesOfForce = new Point2D(Math.round(magnitude * Math.cos(Math.toRadians(angle))), Math.round(magnitude * Math.sin(Math.toRadians(angle))));
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
        this.coordinatesOfForce = new Point2D(Math.round(magnitude * Math.cos(Math.toRadians(angle))), Math.round(magnitude * Math.sin(Math.toRadians(angle))));
    }
}

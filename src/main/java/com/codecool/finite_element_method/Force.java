package com.codecool.finite_element_method;

public class Force {
    private double magnitude;
    private double angle;

    public Force(double magnitude, double angle) {
        this.magnitude = magnitude;
        this.angle = angle;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}

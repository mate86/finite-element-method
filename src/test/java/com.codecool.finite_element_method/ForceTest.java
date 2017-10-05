package com.codecool.finite_element_method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForceTest {
    @Test
    void testCreatingNewForce() {
        Force force = new Force(10.0, 0.001);
        assertEquals(10.0, force.getMagnitude());
        assertEquals(0.001, force.getAngle());
    }

    @Test
    void testSetMagnitudeOfForce() {
        Force force = new Force(5.0, 12.9);
        assertEquals(5.0, force.getMagnitude());

        force.setMagnitude(20.7);
        assertEquals(20.7, force.getMagnitude());
    }

    @Test
    void testSetAngleOfForce() {
        Force force = new Force(5.0, 12.9);
        assertEquals(12.9, force.getAngle());

        force.setAngle(359.9);
        assertEquals(359.9, force.getAngle());
    }

    @Test
    void testCoordinatesIfAngleIsBiggerThan360() {
        Force force = new Force(5.0, 0.001);
        double expectedX = force.getCoordinatesOfForce().getX();
        double expectedY = force.getCoordinatesOfForce().getY();

        force.setAngle(360.001);
        assertEquals(expectedX, force.getCoordinatesOfForce().getX());
        assertEquals(expectedY, force.getCoordinatesOfForce().getY());
    }
}

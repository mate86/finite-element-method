package com.codecool.finite_element_method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RodTest {
    @Test
    void testCreatingNewRod() {
        Rod rod = new Rod(50.0, 10);
        assertEquals(50.0, rod.getObjectSize());
    }

    @Test
    void testLengthOfPointList() {
        Rod rod = new Rod(50.0, 10);
        assertEquals(10, rod.getGeometricPointList().size());
    }

    @Test
    void testSetNumberOfPoints() {
        Rod rod = new Rod(50.0, 10);
        rod.setNumberOfPoints(20);
        assertEquals(20, rod.getNumberOfPoints());
        assertEquals(20, rod.getGeometricPointList().size());
    }

    @Test
    void testDividingRodToEqualSections() {
        Rod rod = new Rod(50.0, 5);
        assertEquals(0.0, (double) rod.geometricPointList.get(0).getX());
        assertEquals(12.5, (double) rod.geometricPointList.get(1).getX());
        assertEquals(25.0, (double) rod.geometricPointList.get(2).getX());
        assertEquals(37.5, (double) rod.geometricPointList.get(3).getX());
        assertEquals(50.0, (double) rod.geometricPointList.get(4).getX());
    }
}

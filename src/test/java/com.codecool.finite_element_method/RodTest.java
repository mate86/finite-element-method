package com.codecool.finite_element_method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RodTest {
    @Test
    void testCreatingNewRod() {
        Rod rod = new Rod(50.0, 2.0E-2, 2.0E11, 10);
        assertEquals(50.0, rod.getRodLength());
    }

    @Test
    void testLengthOfPointList() {
        Rod rod = new Rod(50.0, 2.0E-2, 2.0E11, 10);
        assertEquals(10, rod.getGeometricPointList().size());
    }

    @Test
    void testSetNumberOfPoints() {
        Rod rod = new Rod(50.0, 2.0E-2, 2.0E11, 10);
        rod.setNumberOfPoints(20);
        assertEquals(20, rod.getNumberOfPoints());
        assertEquals(20, rod.getGeometricPointList().size());
    }

    @Test
    void testDividingRodToEqualSections() {
        Rod rod = new Rod(50.0, 2.0E-2, 2.0E11, 5);
        assertEquals(0.0, (double) rod.getGeometricPointList().get(0).getX());
        assertEquals(12.5, (double) rod.getGeometricPointList().get(1).getX());
        assertEquals(25.0, (double) rod.getGeometricPointList().get(2).getX());
        assertEquals(37.5, (double) rod.getGeometricPointList().get(3).getX());
        assertEquals(50.0, (double) rod.getGeometricPointList().get(4).getX());
    }

    @Test
    void testDeformingRod() {
        Rod rod = new Rod(1.0, 2.0E-2, 2.0E11, 11);
        Force force = new Force(1000.0, 90); // Deforming the rod with 1000N
        rod.deformingObject(force);
        assertEquals(0.0, rod.getGeometricPointList().get(0).getY(), 0.000001);
        assertEquals(-0.001611444, rod.getGeometricPointList().get(3).getY(), 0.000001);
        assertEquals(-0.00414466, rod.getGeometricPointList().get(5).getY(), 0.000001);
        assertEquals(-0.007473651, rod.getGeometricPointList().get(7).getY(), 0.000001);
        assertEquals(-0.013262912, rod.getGeometricPointList().get(10).getY(), 0.000001);
    }
}

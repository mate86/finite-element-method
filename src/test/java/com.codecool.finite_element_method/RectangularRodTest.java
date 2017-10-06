package com.codecool.finite_element_method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangularRodTest {
    @Test
    void testCreatingNewRectangularRod() {
        RodFactory rodFactory = new RodFactory();
        Rod rod = rodFactory.getRod(Shape.RECTANGLE, 10, 3.0, 0.03, 0.05, 2.0E11);
        assertEquals(3.0, rod.getRodLength());
    }

    @Test
    void testLengthOfRectangularPointList() {
        RodFactory rodFactory = new RodFactory();
        Rod rod = rodFactory.getRod(Shape.RECTANGLE, 10, 50.0, 0.03, 0.05, 2.0E11);
        assertEquals(10, rod.getGeometricPointList().size());
    }

    @Test
    void testSetRectangularPointList() {
        RodFactory rodFactory = new RodFactory();
        Rod rod = rodFactory.getRod(Shape.RECTANGLE, 10, 50.0, 0.03, 0.05, 2.0E11);
        assertEquals(10, rod.getGeometricPointList().size());
        rod.setNumberOfPoints(20);
        assertEquals(20, rod.getGeometricPointList().size());
    }

    @Test
    void testDividingRectangularRodToEqualSections() {
        RodFactory rodFactory = new RodFactory();
        Rod rod = rodFactory.getRod(Shape.RECTANGLE, 5, 50.0, 0.03, 0.05, 2.0E11);
        assertEquals(0.0, (double) rod.getGeometricPointList().get(0).getX());
        assertEquals(12.5, (double) rod.getGeometricPointList().get(1).getX());
        assertEquals(25.0, (double) rod.getGeometricPointList().get(2).getX());
        assertEquals(37.5, (double) rod.getGeometricPointList().get(3).getX());
        assertEquals(50.0, (double) rod.getGeometricPointList().get(4).getX());
    }

    @Test
    void testDeformingRectangularRod() {
        RodFactory rodFactory = new RodFactory();
        Rod rod = rodFactory.getRod(Shape.RECTANGLE, 11, 1.0, 0.03, 0.05, 2.0E11);
        Force force = new Force(1000.0, 90); // Deforming the rod with 1000N
        Rod deformedRod = rod.deformingObject(force);
        assertEquals(0.0, deformedRod.getGeometricPointList().get(0).getY(), 0.000001);
        assertEquals(-0.000648, deformedRod.getGeometricPointList().get(3).getY(), 0.000001);
        assertEquals(-0.001666667, deformedRod.getGeometricPointList().get(5).getY(), 0.000001);
        assertEquals(-0.003005333, deformedRod.getGeometricPointList().get(7).getY(), 0.000001);
        assertEquals(-0.005333333, deformedRod.getGeometricPointList().get(10).getY(), 0.000001);
    }
}

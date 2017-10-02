package com.codecool.finite_element_method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RodTest {
    @Test
    void testCreatingNewRod() {
        GeometricObject rod = new Rod(50.0, 10);
        double rodLength = rod.getObjectSize().get("x");
        assertEquals(50.0, rodLength);
    }

    @Test
    void testLengthOfPointList() {
        GeometricObject rod = new Rod(50.0, 10);
        assertEquals(10, rod.getGeometricPointList().size());
    }

    @Test
    void testDividingRodToEqualSections() {
        GeometricObject rod = new Rod(50.0, 5);
        assertEquals(0.0, (double) rod.geometricPointList.get(0).getCoordinates().get("x"));
        assertEquals(12.5, (double) rod.geometricPointList.get(1).getCoordinates().get("x"));
        assertEquals(25.0, (double) rod.geometricPointList.get(2).getCoordinates().get("x"));
        assertEquals(37.5, (double) rod.geometricPointList.get(3).getCoordinates().get("x"));
        assertEquals(50.0, (double) rod.geometricPointList.get(4).getCoordinates().get("x"));
    }
}

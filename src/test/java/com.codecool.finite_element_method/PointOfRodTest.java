package com.codecool.finite_element_method;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointOfRodTest {
    @Test
    void testCreatingNewPoint() {
        GeometricPoint geometricPoint = new PointOfRod(3.5);
        double coordinateX = geometricPoint.getCoordinates().get("x");
        double coordinateY = geometricPoint.getCoordinates().get("y");
        assertEquals(3.5, coordinateX);
        assertEquals(0.0, coordinateY);
    }

    @Test
    void testSettingCoordinateY() {
        PointOfRod geometricPoint = new PointOfRod(3.5);
        Map<String, Double> coordinates = geometricPoint.getCoordinates();
        coordinates.replace("y", 0.5);
        geometricPoint.setCoordinates(coordinates);
        double coordinateX = geometricPoint.getCoordinates().get("x");
        double coordinateY = geometricPoint.getCoordinates().get("y");
        assertEquals(3.5, coordinateX);
        assertEquals(0.5, coordinateY);
    }
}

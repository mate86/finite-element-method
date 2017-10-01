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
    void testSettingForce() {
        Force force = new Force(10.0, 0.001);
        force.setMagnitude(30.2);
        force.setAngle(359.9);
        assertEquals(30.2, force.getMagnitude());
        assertEquals(359.9, force.getAngle());
    }
}

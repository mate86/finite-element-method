package com.codecool.finite_element_method;

public class RodFactory {
    public Rod getRod(Shape shape, int numberOfPoints, double... params) {
        switch (shape) {
            case CIRCLE:
                return new CylindricalRod(params[0], params[1], params[2], numberOfPoints);
            case RECTANGLE:
                return new RectangularRod(params[0], params[1], params[2], params[3], numberOfPoints);
            default:
                break;
        }
        return null;
    }
}

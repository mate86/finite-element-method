package mate86.finite_element;

import java.util.ArrayList;
import java.util.List;

public class Point {
    private List<Double> coordinates = new ArrayList<>();

    public Point(double x, double y) {
        coordinates.add(x);
        coordinates.add(y);
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double x, double y) {
        this.coordinates.set(0, x);
        this.coordinates.set(1, y);
    }
}

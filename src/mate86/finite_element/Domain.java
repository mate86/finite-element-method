package mate86.finite_element;

import java.util.ArrayList;
import java.util.List;

public abstract class Domain {
    protected int numberOfPoints;
    protected List<Point> pointsOfDomain = new ArrayList<>();

    public List<Point> getPointsOfDomain() {
        return pointsOfDomain;
    }

    public void addPointToDomain(Point point) {
        this.pointsOfDomain.add(point);
    }
}

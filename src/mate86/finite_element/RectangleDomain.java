package mate86.finite_element;

public class RectangleDomain extends Domain {
    private double lengthX;
    private double lengthY;

    public RectangleDomain(double x, double y, int numberOfPoints) {
        this.lengthX = x;
        this.lengthY = y;
        this.numberOfPoints = numberOfPoints;
    }

    public void partitioningDomain() {

    }
}

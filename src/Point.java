
/**
 * The type Point.
 */
public class Point {
    private double x;
    private double y;

    /**
     * Instantiates a new Point.
     *
     * @param x the x.
     * @param y the y.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * A function that calculates distance between two points.
     *
     * @param other point.
     * @return the distance of this point to the other point.
     */
    public double distance(Point other) {
        double distance = ((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y));
        return Math.sqrt(distance);
    }

    /**
     * A function that checks whether two points are equal.
     *
     * @param other point.
     * @return true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        return ((this.x == other.x) && (this.y == other.y));
    }

    /**
     * Gets x values of this point.
     *
     * @return the x
     */
    public double getX() {
        return (this.x);
    }

    /**
     * Gets y values of this point.
     *
     * @return the y
     */
    public double getY() {
        return (this.y);
    }
}
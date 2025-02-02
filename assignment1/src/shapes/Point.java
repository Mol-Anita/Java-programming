package shapes;

/**
 * Class representing 2d points
 */

public class Point {
    protected double x;
    protected double y;

    /**
     * @param x coordinated x of the point
     * @param y coordinate y of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

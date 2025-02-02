package shapes;

/**
 * Abstract class representing shapes by their center and side lengths.
 */
public abstract class GeometricShape {
    private Point center;
    private double sideLength;

    GeometricShape() {}

    /**
     *
     * @param centerX x coordinate of shape's center point
     * @param centerY y coordinate of shape's center point
     * @param sideLength length of shape's sides
     * @throws IllegalArgumentException if sideLength is less than 0
     */
    GeometricShape(double centerX, double centerY, double sideLength) {
        /**
         * Shape's center point in 2D
         */
        this.center = new Point(centerX, centerY);
        /**
         * Length of the shape's sides.
         */
        if (sideLength >= 0){
            this.sideLength = sideLength;
        }
        else throw new IllegalArgumentException("sideLength must be greater than 0");

    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    /**
     *  Calculates the area of the smallest bounding rectangle of the given shape.
     * @return area of the shape's smallest bounding rectangle
     */
    public abstract Double boundingRectangleArea();

    public abstract String toString();
}

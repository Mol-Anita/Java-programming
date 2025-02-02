package shapes;

/**
 * Class representing a square with its center point and side length in 2D,
 * knowing that it has a side perpendicular to the x-axis on a 2D plane.
 */
public class Square extends GeometricShape {
    Square() {}

    /**
     *
     * @param x x coordinate of the square's center point
     * @param y y coordinate of the square's center point
     * @param sideLength length of the square's sides, must be greater than 0
     */
    public Square(double x, double y, double sideLength) {
        super(x, y, sideLength);
    }

    /**
     * Calculates the area of the square's smallest bounding rectangle.
     * @return area of the square's smallest bounding rectangle
     */
    @Override
    public Double boundingRectangleArea() {
        return getSideLength() * getSideLength();
    }

    @Override
    public String toString() {
        return "Square - center: " + getCenter() + ", side length: " + getSideLength() + "bounding rectangle area: " + boundingRectangleArea();
    }
}

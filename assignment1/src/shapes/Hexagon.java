package shapes;

/**
 * Class representing hexagons in 2D, with their center point and side length.
 *
 */
public class Hexagon extends GeometricShape {
    Hexagon() {}

    /**
     *
     * @param x x coordinate of hexagon point of the shape
     * @param y y coordinate of hexagon point of the shape
     * @param sideLength length of the hexagon's sides, must be greater than 0
     */
    public Hexagon(double x, double y, double sideLength) {
        super(x, y, sideLength);
    }

    /**
     * Calculates the area of the hexagon's bounding rectangle.
     * @return area of the hexagon's bounding rectangle calculated with the formula 4*radius^2
     */
    @Override
    public Double boundingRectangleArea() {

        return 2 * getSideLength() * getSideLength() * Math.sqrt(3);
    }

    @Override
    public String toString() {
        return "Hexagon - center: "+ getCenter() + ", side length: " + getSideLength() + ", bounding rectangle area: " + boundingRectangleArea();
    }
}

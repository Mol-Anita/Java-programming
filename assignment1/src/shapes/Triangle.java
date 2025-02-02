package shapes;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Class representing equilateral triangle with its center point and side length, given that
 * it has a side perpendicular to the x-axis on a 2D plane.
 */
public class Triangle extends GeometricShape {
    Triangle() {}

    /**
     *
     * @param x x coordinate of the triangle's center point
     * @param y y coordinate of the triangle's center point
     * @param sideLength length of the triangle's sides, must be greater than 0
     */
    public Triangle(double x, double y, double sideLength) {
        super(x, y, sideLength);
    }

    /**
     * Calculates the area of the triangle's smallest bounding rectangle/
     * @return area of the triangle's smallest bounding rectangle
     */
    @Override
    public Double boundingRectangleArea() {
        Double rectangleWidth = getSideLength();
        Double rectangleHeight = (Math.sqrt(3) / 2) * getSideLength();
        return rectangleHeight * rectangleWidth;
    }

    @Override
    public String toString(){
        return "Triangle - center: " + getCenter() + "side length: " + getSideLength() + "bounding rectangle area: " + boundingRectangleArea();
    }
}

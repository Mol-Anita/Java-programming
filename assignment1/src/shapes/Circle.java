package shapes;

/**
 * Class representing circles in 2D, with their center point and radius, given as side length.
 *
 */
public class Circle extends GeometricShape {
    /**
     *
     * @param x x coordinate of the circle's center
     * @param y y coordinate of the shape's center
     * @param radius radius of the circle,must be greater than 0
     */
    public Circle(double x, double y, double radius) {
        super(x, y, radius);
    }

    /**
     * Calculates the area of the circle's bounding rectangle.
     * @return area of the circle's bounding rectangle calculated with the formula 4*radius^2
     */
    @Override
    public Double boundingRectangleArea() {
        return 4*getSideLength()*getSideLength();
    }

    @Override
    public String toString(){
        return "Circle - center: " + this.getCenter() + ", radius: "+ this.getSideLength() + ", bounding rectangle area: " + boundingRectangleArea();
    }
}

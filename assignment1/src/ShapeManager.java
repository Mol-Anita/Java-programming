import shapes.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Class that helps in the managing of geometric shapes read from a given file.
 */
public class ShapeManager {
    private final ArrayList<GeometricShape> shapes;

    public ShapeManager() {
        shapes = new ArrayList<>();
    }

    /**
     * Reads the data of geometric shapes and adds them to the shapes list
     *
     * @param filePath path to the file from which the data should be loaded
     * @throws FileNotFoundException      if the file that has been given is not found
     * @throws IncorrectTypeException     if the read shape type is incorrect
     * @throws InvalidFileFormatException if the file formatting is incorrect
     */
    public void readShapesFromFile(String filePath) throws FileNotFoundException, IncorrectTypeException, InvalidFileFormatException {
        Scanner scanner = new Scanner(new FileReader(filePath));

        try {
            int numberOfElements = scanner.nextInt();
            while (scanner.hasNext() && numberOfElements > 0) {
                String type = scanner.next();
                double centerX = scanner.nextDouble();
                double centerY = scanner.nextDouble();
                double sideLength = scanner.nextDouble();
                GeometricShape elem;
                switch (type) {
                    case "C" -> elem = new Circle(centerX, centerY, sideLength);
                    case "S" -> elem = new Square(centerX, centerY, sideLength);
                    case "T" -> elem = new Triangle(centerX, centerY, sideLength);
                    case "H" -> elem = new Hexagon(centerX, centerY, sideLength);
                    default -> throw new IncorrectTypeException("Given type specifier is incorrect!\n");
                }
                numberOfElements--;
                shapes.add(elem);
            }
        } catch (IndexOutOfBoundsException | NoSuchElementException e){
            throw new InvalidFileFormatException("Invalid file format!\n");
        }
    }

    /**
     * Returns the geometric shape with the biggest bounding rectangle.
     * @return reference to the shape with the biggest bounding rectangle, null if
     * the shapes array is empty
     */
    public GeometricShape getShapeWBBRect(){
        final GeometricShape[] biggestRect = {null};
        final double[] maxArea = {0};
        shapes.forEach( (shape) -> {
            if (maxArea[0] < shape.boundingRectangleArea()){
                maxArea[0] = shape.boundingRectangleArea();
                biggestRect[0] = shape;
            }
        });
        return biggestRect[0];
    }
}

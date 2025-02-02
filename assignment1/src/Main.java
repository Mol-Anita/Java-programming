import shapes.GeometricShape;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShapeManager shapeManager = new ShapeManager();
        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        try {
            shapeManager.readShapesFromFile(filePath);
            GeometricShape bbrShape = shapeManager.getShapeWBBRect();
            if (bbrShape != null) {
                System.out.println(bbrShape.toString());
            } else {
                System.out.println("No shape found");
            }
        } catch (IncorrectTypeException | InvalidFileFormatException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("File has not been found");
        }
    }


}
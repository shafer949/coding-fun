import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        double totalPerimeter = 0.0;
        Point previousPoint = s.getLastPoint();
        
        for (Point currentPoint : s.getPoints()) {
            double currentDistance = previousPoint.distance(currentPoint);
            totalPerimeter = totalPerimeter + currentDistance;
            previousPoint = currentPoint;
        }
        return totalPerimeter;
    }

    public int getNumberOfPoints (Shape s) {
        int numberOfPoints = 0;
        
        for(Point currentPoint : s.getPoints()) {
            numberOfPoints++;
        }
        return numberOfPoints;
    }

    public double getAverageLength(Shape s) {
        double length = getPerimeter(s);
        double numberOfPoints = getNumberOfPoints(s);
        double averageLength = length / numberOfPoints;

        return averageLength;
    }

    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        Point previousPoint = s.getLastPoint();
        
        for (Point currentPoint : s.getPoints()) {
            double currentDistance = previousPoint.distance(currentPoint);
            if (currentDistance > largestSide) {
                largestSide = currentDistance;
            }
            previousPoint = currentPoint;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        double largestX = 0.0;
        
        for (Point currentPoint : s.getPoints()) {
            double currentX = currentPoint.getX();
            
            if (currentX > largestX) {
                largestX = currentX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource directory = new DirectoryResource();
        double largestPerimeter = 0.0;
        
        for (File f : directory.selectedFiles()) {
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perimeter = getPerimeter(shape);
            
            if (perimeter > largestPerimeter) {
                    largestPerimeter = perimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource directory = new DirectoryResource();
        double largestPerimeter = 0.0;
        File fileWithLargestPerimeter = null;
        
        for (File f : directory.selectedFiles()) {
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perimeter = getPerimeter(shape);
            
            if (perimeter > largestPerimeter) {
                System.out.println("Perimeter : " + perimeter);

                    largestPerimeter = perimeter;
                    fileWithLargestPerimeter = f;
                                System.out.println("largestPerimeter : " + largestPerimeter);
                                            System.out.println("f : " + fileWithLargestPerimeter);
            }
        }
        return fileWithLargestPerimeter.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numberOfPoints = getNumberOfPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        
        System.out.println("The perimeter is : " + length);
        System.out.println("The number of points are : " + numberOfPoints);
        System.out.println("The average length is : " + averageLength);
        System.out.println("The largest side is : " + largestSide);
        System.out.println("The largest X is : " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter is: " + largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        String file = getFileWithLargestPerimeter();
        System.out.println("File with the largest perimeter is: " + file);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double perimeter = getPerimeter(triangle);
        System.out.println("The perimeter is: " + perimeter);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //select 1 file to test
        pr.testPerimeter();
        //select multiple files to test
        pr.testPerimeterMultipleFiles();
        //select multiple files to test
        pr.testFileWithLargestPerimeter();
    }
}

public class ShapeCalculator {
    // ! Enum representing different shapes
    public enum Shape {
        CIRCLE(2.0) {
            // @Override
            double calculateArea() {
                return Math.PI * Math.pow(radius, 2);
            }

            // @Override
            double calculatePerimeter() {
                return 2 * Math.PI * radius;
            }
        },
        SQUARE(5.0) {
            // @Override
            double calculateArea() {
                return sideLength * sideLength;
            }

            // @Override
            double calculatePerimeter() {
                return 4 * sideLength;
            }
        },
        TRIANGLE(3.0, 4.0, 5.0) {
            // @Override
            double calculateArea() {
                double s = (side1 + side2 + side3) / 2;
                return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
            }

            // @Override
            double calculatePerimeter() {
                return side1 + side2 + side3;
            }
        };

        double sideLength;
        double radius;
        double side1, side2, side3;

        Shape(double sideLength) {
            this.sideLength = sideLength;
        }

        Shape(double side1, double side2, double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }

        abstract double calculateArea();
        abstract double calculatePerimeter();
    }

    public static void main(String[] args) {
        for (Shape shape : Shape.values()) {
            System.out.println("Shape: " + shape);
            System.out.println("Area: " + shape.calculateArea());
            System.out.println("Perimeter: " + shape.calculatePerimeter());
            System.out.println();
        }
    }
}

import java.util.Scanner;

public class SpeedConverter {

    private static int fromUnit, toUnit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Speed Converter CLI!");
        System.out.println("Available Units:");
        System.out.println(
                "1. meters per second\n2. meters per hour\n3. kilometers per hour\n4. inches per second\n5. inches per hour\n6. feet per second\n7. feet per hour\n8. miles per second\n9. miles per hour\n10. knots");

        System.out.print("Enter the speed value: ");
        double speed = scanner.nextDouble();

        System.out.print("Enter the unit of the speed (1-10): ");
        fromUnit = scanner.nextInt();

        System.out.print("Enter the target unit (1-10): ");
        toUnit = scanner.nextInt();

        double convertedSpeed = convertSpeed(speed, fromUnit, toUnit);

        System.out.println("Converted speed: " + convertedSpeed);
        scanner.close();
    }

    private static double convertSpeed(double speed, int fromUnit, int toUnit) {
        switch (fromUnit) {
            case 1 -> {
                // Meters per second
                return convertToMetersPerSecond(speed, toUnit);
            }
            case 2 -> {
                // Meters per hour
                return convertToMetersPerHour(speed, toUnit);
            }
            case 3 -> {
                // Kilometers per hour
                return convertToKilometersPerHour(speed, toUnit);
            }
            case 4 -> {
                // Inches per second
                return convertToInchesPerSecond(speed, toUnit);
            }
            case 5 -> {
                // Inches per hour
                return convertToInchesPerHour(speed, toUnit);
            }
            case 6 -> {
                // Feet per second
                return convertToFeetPerSecond(speed, toUnit);
            }
            case 7 -> {
                // Feet per hour
                return convertToFeetPerHour(speed, toUnit);
            }
            case 8 -> {
                // Miles per second
                return convertToMilesPerSecond(speed, toUnit);
            }
            case 9 -> {
                // Miles per hour
                return convertToMilesPerHour(speed, toUnit);
            }
            case 10 -> {
                // Knots
                return convertToKnots(speed, toUnit);
            }
            default -> {
                System.out.println("Invalid input. Please enter a number from 1 to 10.");
                return 0.0;
            }
        }
    }

    private static double convertToMetersPerSecond(double speed, int toUnit) {
        switch (toUnit) {
            case 1 -> {
                // Meters per second
                return speed;
            }
            case 2 -> {
                // Meters per hour
                return speed * 3600.0;
            }
            case 3 -> {
                // Kilometers per hour
                return speed * 3.6;
            }
            case 4 -> {
                // Inches per second
                return speed * 39.3701;
            }
            case 5 -> {
                // Inches per hour
                return speed * 141732.0; // 1 inch per second = 141732 inches per hour
            }
            case 6 -> {
                // Feet per second
                return speed * 3.28084;
            }
            case 7 -> {
                // Feet per hour
                return speed * 11811.0; // 1 foot per second = 11811 feet per hour
            }
            case 8 -> {
                // Miles per second
                return speed * 0.000621371;
            }
            case 9 -> {
                // Miles per hour
                return speed * 2.23694;
            }
            case 10 -> {
                // Knots
                return speed * 1.94384;
            }
            default -> {
                System.out.println("Invalid input. Please enter a number from 1 to 10.");
                return 0.0;
            }
        }
    }

    // Add similar conversion methods for the other units
    // ... (similar conversion methods for other units)
    private static double convertToMetersPerHour(double speed, int toUnit) {
        switch (toUnit) {
            case 1 -> {
                // Meters per second
                return speed / 3600.0;
            }
            case 2 -> {
                // Meters per hour
                return speed;
            }
            case 3 -> {
                // Kilometers per hour
                return speed / 1000.0;
            }
            case 4 -> {
                // Inches per second
                return speed / 39.3701 / 3600.0;
            }
            case 5 -> {
                // Inches per hour
                return speed / 39.3701;
            }
            case 6 -> {
                // Feet per second
                return speed / 3.28084 / 3600.0;
            }
            case 7 -> {
                // Feet per hour
                return speed / 3.28084;
            }
            case 8 -> {
                // Miles per second
                return speed / 1609.34 / 3600.0;
            }
            case 9 -> {
                // Miles per hour
                return speed / 1609.34;
            }
            case 10 -> {
                // Knots
                return speed / 1852.0;
            }
            default -> {
                System.out.println("Invalid input. Please enter a number from 1 to 10.");
                return 0.0;
            }
        }
    }

    // ... (similar conversion methods for other units)
    private static double convertToKilometersPerHour(double speed, int toUnit) {
        switch (toUnit) {
            case 1 -> {
                // Meters per second
                return speed / 3600.0;
            }
            case 2 -> {
                // Meters per hour
                return speed;
            }
            case 3 -> {
                // Kilometers per hour
                return speed / 1000.0;
            }
            case 4 -> {
                // Inches per second
                return speed / 39.3701 / 3600.0;
            }
            case 5 -> {
                // Inches per hour
                return speed / 39.3701;
            }
            case 6 -> {
                // Feet per second
                return speed / 3.28084 / 3600.0;
            }
            case 7 -> {
                // Feet per hour
                return speed / 3.28084;
            }
            case 8 -> {
                // Miles per second
                return speed / 1609.34 / 3600.0;
            }
            case 9 -> {
                // Miles per hour
                return speed / 1609.34;
            }
            case 10 -> {
                // Knots
                return speed / 1852.0;
            }
            default -> {
                System.out.println("Invalid input. Please enter a number from 1 to 10.");
                return 0.0;
            }
        }
    }

    private static double convertToInchesPerSecond(double speed, int toUnit) {
        switch (toUnit) {
            case 1 -> {
                // Meters per second
                return speed / 3600.0;
            }
            case 2 -> {
                // Meters per hour
                return speed;
            }
            case 3 -> {
                // Kilometers per hour
                return speed / 1000.0;
            }
            case 4 -> {
                // Inches per second
                return speed / 39.3701 / 3600.0;
            }
            case 5 -> {
                // Inches per hour
                return speed / 39.3701;
            }
            case 6 -> {
                // Feet per second
                return speed / 3.28084 / 3600.0;
            }
            case 7 -> {
                // Feet per hour
                return speed / 3.28084;
            }
            case 8 -> {
                // Miles per second
                return speed / 1609.34 / 3600.0;
            }
            case 9 -> {
                // Miles per hour
                return speed / 1609.34;
            }
            case 10 -> {
                // Knots
                return speed / 1852.0;
            }
            default -> {
                System.out.println("Invalid input. Please enter a number from 1 to 10.");
                return 0.0;
            }
        }
    }

    private static double convertToInchesPerHour(double speed, int toUnit) {
        switch (toUnit) {
            case 1 -> {
                // Meters per second
                return speed / 3600.0;
            }
            case 2 -> {
                // Meters per hour
                return speed;
            }
            case 3 -> {
                // Kilometers per hour
                return speed / 1000.0;
            }
            case 4 -> {
                // Inches per second
                return speed / 39.3701 / 3600.0;
            }
            case 5 -> {
                // Inches per hour
                return speed / 39.3701;
            }
            case 6 -> {
                // Feet per second
                return speed / 3.28084 / 3600.0;
            }
            case 7 -> {
                // Feet per hour
                return speed / 3.28084;
            }
            case 8 -> {
                // Miles per second
                return speed / 1609.34 / 3600.0;
            }
            case 9 -> {
                // Miles per hour
                return speed / 1609.34;
            }
            case 10 -> {
                // Knots
                return speed / 1852.0;
            }
            default -> {
                System.out.println("Invalid input. Please enter a number from 1 to 10.");
                return 0.0;
            }
        }
    }

    private static double convertToFeetPerSecond(double speed, int toUnit) {
        switch (toUnit) {
            case 1 -> {
                // Meters per second
                return speed / 3600.0;
            }
            case 2 -> {
                // Meters per hour
                return speed;
            }
            case 3 -> {
                // Kilometers per hour
                return speed / 1000.0;
            }
            case 4 -> {
                // Inches per second
                return speed / 39.3701 / 3600.0;
            }
            case 5 -> {
                // Inches per hour
                return speed / 39.3701;
            }
            case 6 -> {
                // Feet per second
                return speed / 3.28084 / 3600.0;
            }
            case 7 -> {
                // Feet per hour
                return speed / 3.28084;
            }
            case 8 -> {
                // Miles per second
                return speed / 1609.34 / 3600.0;
            }
            case 9 -> {
                // Miles per hour
                return speed / 1609.34;
            }
            case 10 -> {
                // Knots
                return speed / 1852.0;
            }
            default -> {
                System.out.println("Invalid input. Please enter a number from 1 to 10.");
                return 0.0;
            }
        }
    }

    private static double convertToFeetPerHour(double speed, int toUnit) {
        switch (toUnit) {
            case 1 -> {
                // Meters per second
                return speed / 3600.0;
            }
            case 2 -> {
                // Meters per hour
                return speed;
            }
            case 3 -> {
                // Kilometers per hour
                return speed / 1000.0;
            }
            case 4 -> {
                // Inches per second
                return speed / 39.3701 / 3600.0;
            }
            case 5 -> {
                // Inches per hour
                return speed / 39.3701;
            }
            case 6 -> {
                // Feet per second
                return speed / 3.28084 / 3600.0;
            }
            case 7 -> {
                // Feet per hour
                return speed / 3.28084;
            }
            case 8 -> {
                // Miles per second
                return speed / 1609.34 / 3600.0;
            }
            case 9 -> {
                // Miles per hour
                return speed / 1609.34;
            }
            case 10 -> {
                // Knots
                return speed / 1852.0;
            }
            default -> {
                System.out.println("Invalid input. Please enter a number from 1 to 10.");
                return 0.0;
            }
        }
    }

    private static double convertToMilesPerSecond(double speed, int toUnit) {
        switch (toUnit) {
            case 1 -> {
                // Meters per second
                return speed / 3600.0;
            }
            case 2 -> {
                // Meters per hour
                return speed;
            }
            case 3 -> {
                // Kilometers per hour
                return speed / 1000.0;
            }
            case 4 -> {
                // Inches per second
                return speed / 39.3701 / 3600.0;
            }
            case 5 -> {
                // Inches per hour
                return speed / 39.3701;
            }
            case 6 -> {
                // Feet per second
                return speed / 3.28084 / 3600.0;
            }
            case 7 -> {
                // Feet per hour
                return speed / 3.28084;
            }
            case 8 -> {
                // Miles per second
                return speed / 1609.34 / 3600.0;
            }
            case 9 -> {
                // Miles per hour
                return speed / 1609.34;
            }
            case 10 -> {
                // Knots
                return speed / 1852.0;
            }
            default -> {
                System.out.println("Invalid input. Please enter a number from 1 to 10.");
                return 0.0;
            }
        }
    }

    private static double convertToMilesPerHour(double speed, int toUnit) {
        switch (toUnit) {
            case 1 -> {
                // Meters per second
                return speed / 3600.0;
            }
            case 2 -> {
                // Meters per hour
                return speed;
            }
            case 3 -> {
                // Kilometers per hour
                return speed / 1000.0;
            }
            case 4 -> {
                // Inches per second
                return speed / 39.3701 / 3600.0;
            }
            case 5 -> {
                // Inches per hour
                return speed / 39.3701;
            }
            case 6 -> {
                // Feet per second
                return speed / 3.28084 / 3600.0;
            }
            case 7 -> {
                // Feet per hour
                return speed / 3.28084;
            }
            case 8 -> {
                // Miles per second
                return speed / 1609.34 / 3600.0;
            }
            case 9 -> {
                // Miles per hour
                return speed / 1609.34;
            }
            case 10 -> {
                // Knots
                return speed / 1852.0;
            }
            default -> {
                System.out.println("Invalid input. Please enter a number from 1 to 10.");
                return 0.0;
            }
        }
    }

    private static double convertToKnots(double speed, int toUnit) {
        switch (toUnit) {
            case 1 -> {
                // Meters per second
                return speed / 3600.0;
            }
            case 2 -> {
                // Meters per hour
                return speed;
            }
            case 3 -> {
                // Kilometers per hour
                return speed / 1000.0;
            }
            case 4 -> {
                // Inches per second
                return speed / 39.3701 / 3600.0;
            }
            case 5 -> {
                // Inches per hour
                return speed / 39.3701;
            }
            case 6 -> {
                // Feet per second
                return speed / 3.28084 / 3600.0;
            }
            case 7 -> {
                // Feet per hour
                return speed / 3.28084;
            }
            case 8 -> {
                // Miles per second
                return speed / 1609.34 / 3600.0;
            }
            case 9 -> {
                // Miles per hour
                return speed / 1609.34;
            }
            case 10 -> {
                // Knots
                return speed / 1852.0;
            }
            default -> {
                System.out.println("Invalid input. Please enter a number from 1 to 10.");
                return 0.0;
            }
        }
    }
}

/ Meters per second
                return speed / 3600.0;
            case 2: // Meters per hour
                return speed;
            case 3: // Kilometers per hour
                return speed / 1000.0;
            case 4: // Inches per second
                return speed / 39.3701 / 3600.0;
            case 5: // Inches per hour
                return speed / 39.3701;
            case 6: // Feet per second
                return speed / 3.28084 / 3600.0;
            case 7: // Feet per hour
                return speed / 3.28084;
            case 8: // Miles per second
                return speed / 1609.34 / 3600.0;
            case 9: // Miles per hour
                return speed / 1609.34;
            case 10: // Knots
                return speed / 1852.0;
            default:
                System.out.println("Invalid input. Please enter a number from 1 to 10.");
                return 0.0;
        }
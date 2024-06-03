public class DayOfWeekExample {
    // ! Define an enum for days of the week
    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        // ! Assuming today is MONDAY
        Day today = Day.MONDAY;

        // ! Use a switch statement to perform different actions based on the day
        switch (today) {
            case MONDAY:
                System.out.println("It's a workday. You have a busy week ahead.");
                break;
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
                System.out.println("It's a workday. Keep up the good work.");
                break;
            case FRIDAY:
                System.out.println("It's Friday! Enjoy your day at work and the weekend ahead.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("It's the weekend! Time to relax and have fun.");
                break;
            default:
                System.out.println("Invalid day!");
        }
    }
}

public class MathUtils {
    // ! Static method to calculate the average of an array of numbers
    public static double calculateAverage(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input array is empty or null.");
        }

        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }

        return sum / numbers.length;
    }

    public static void main(String[] args) {
        double[] values = { 5.5, 10.0, 15.5, 20.0, 25.5 };

        // ! Calculate the average using the static method without creating an instance
        System.out.println("Average: " + MathUtils.calculateAverage(values)); // ! Output: Average: 15.3
    }
}

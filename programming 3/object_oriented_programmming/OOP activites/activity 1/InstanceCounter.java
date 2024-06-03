
public class InstanceCounter {
    // ! Static variable to count instances
    private static int instanceCount = 0;

    public InstanceCounter() {
        // ! Increment the instance count when a new instance is created
        instanceCount++;
    }

    // ! Static method to get the instance count
    public static int getInstanceCount() {
        return instanceCount;
    }

    public static void main(String[] args) {
        // ! Create some instances of the class
        for (int i = 0; i < 5; i++) {
            InstanceCounter instances = new InstanceCounter();
        }

        // ! Get and print the instance count using the static method
        System.out.println("Number of instances created: " + InstanceCounter.getInstanceCount()); // ! Output: Number of instances created: 3
    }
}

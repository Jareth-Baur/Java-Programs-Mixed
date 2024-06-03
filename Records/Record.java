package Records;

public class Record {
    public static void main(String[] args) {
        EmployeeClass employeeClass = new EmployeeClass("Jerry", 12345);
        System.out.println(employeeClass);

        EmployeeRecord employeeRecord = new EmployeeRecord("Kramer", 54321);
        System.out.println(employeeRecord);

    }
}

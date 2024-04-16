import java.util.Scanner;

public class AddEmployee {
    public static void addEmployee(Scanner scanner) {
        System.out.println("\nAdd Employee:");
        System.out.print("Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Job Title: ");
        String jobTitle = scanner.nextLine();
        System.out.print("Division: ");
        String division = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();

        // Add employee to the database (implementation required)

        System.out.println("Employee added successfully!\n");
    }
}
import java.util.Scanner;
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        System.out.println("Welcome to the Employee Management System, you can perform the following actions.\n");
        System.out.println("1. Add Employee (Not Implemented)");
        System.out.println("2. Search Employee (Needs Modification)");
        System.out.println("3. Update Employee (Not Implemented)");
        System.out.println("4. Generate Reports (Not Implemented)");
        System.out.println("5. Exit\n");
        System.out.println("Type in the action you want to take (1-5): ");

        int choice = userInputScanner.nextInt();
        userInputScanner.nextLine();

        switch (choice) {
            case 1:
                AddEmployee newEmployee = new AddEmployee();
                AddEmployee.addEmployee(userInputScanner);
                break;
            case 2:
                // Implement search employee function
                SearchEmployee searchEmployee = new SearchEmployee();
                SearchEmployee.searchEmployee(userInputScanner);
                break;
            case 3:
                // Implement update employee function
                break;
            case 4:
                // Implement generate reports function
                break;
            case 5:
                System.out.println("The Employee Management System will now close.");
                userInputScanner.close();
                return;
            default:
                System.out.println("Invalid choice. Please enter a number from 1 to 5.\n");
        }
    }
}
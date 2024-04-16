import java.sql.*;
import java.util.Scanner;
public class SearchEmployee {

    public static void searchEmployee(Scanner scanner) {
        String url = "jdbc:mysql://localhost:3306/employeeData";
        String user = "root";
        String password = "Your Password Here";
        StringBuilder output = new StringBuilder("");
        Connection myConn = null;

        try {
            myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();

            System.out.println("Select search criteria:");
            System.out.println("1. Search by name");
            System.out.println("2. Search by empid");
            System.out.println("3. Search by SSN (Not Implemented Yet)");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            String sqlQuery = "";

            switch (choice) {
                case 1:
                    System.out.print("Enter employee's name: ");
                    String employeeName = scanner.nextLine();
                    sqlQuery = "SELECT e.Fname, e.Lname, e.email, jt.job_title, e.empid " +
                            "FROM employees e  " +
                            "JOIN employee_job_titles ejt ON e.empid = ejt.empid " +
                            "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id  " +
                            "WHERE CONCAT(e.Fname, ' ', e.Lname) LIKE '%" + employeeName + "%' " +
                            "ORDER BY e.empid ; ";
                    break;
                case 2:
                    System.out.print("Enter employee's empid: ");
                    int empid = scanner.nextInt();
                    sqlQuery = "SELECT e.Fname, e.Lname, e.email, jt.job_title, e.empid " +
                            "FROM employees e  " +
                            "JOIN employee_job_titles ejt ON e.empid = ejt.empid " +
                            "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id  " +
                            "WHERE e.empid = " + empid;
                    break;
                case 3:
                    System.out.print("Enter employee's SSN: ");
                    String ssn = scanner.nextLine();
                    sqlQuery = "???";
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return; // Exit the method if choice is invalid
            }

            ResultSet myRS = myStmt.executeQuery(sqlQuery);
            Payroll p1 = new Payroll();
            boolean employeeFound = false;
            while (myRS.next()) {
                employeeFound = true;
                output.append("Name= " + myRS.getString("e.Fname") + " " + myRS.getString("e.Lname") + "\t");
                output.append("Title=" + myRS.getString("jt.job_title") + "     " + myRS.getString("e.email") + "\n");
                output.append(p1.getPayByMonth(myRS.getInt("e.empid"), myConn));
                output.append("\n");
            }
            if (!employeeFound) {
                System.out.println("Employee not found.");
            } else {
                System.out.print(output.toString()); // Print the final output after processing the employee
            }
        } catch (SQLException e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
            // Close the connection in the finally block to ensure it gets closed even if an exception occurs
            try {
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}

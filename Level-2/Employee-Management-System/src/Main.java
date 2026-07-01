import entity.Employee;
import exception.EmployeeNotFoundException;
import exception.EmptyDataException;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        EmployeeService employeeService = new EmployeeServiceImpl();

        while (running) {
            System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("---------------------------");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. View Employee By Id");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.println(" ");
            System.out.print("Enter choice: ");
            int choice = scan.nextInt();

            try {
                switch (choice) {
                    case 1:
                        Employee employee = new Employee();

                        System.out.print("Enter Employee ID: ");
                        employee.setId(scan.nextInt());
                        scan.nextLine();
                        System.out.print("Enter First Name: ");
                        employee.setFirstName(scan.nextLine());
                        System.out.print("Enter Last Name: ");
                        employee.setLastName(scan.nextLine());
                        System.out.print("Enter Age: ");
                        employee.setAge(scan.nextInt());
                        scan.nextLine();
                        System.out.print("Enter Phone Number: ");
                        employee.setPhoneNumber(scan.nextLine());
                        System.out.print("Enter Position: ");
                        employee.setPosition(scan.nextLine());
                        System.out.print("Enter Salary: ");
                        employee.setSalary(scan.nextDouble());
                        scan.nextLine();

                        employeeService.addEmployee(employee);
                        break;

                    case 2:
                        employeeService.viewAllEmployees();
                        break;

                    case 3:
                        System.out.print("Enter Employee ID: ");
                        Integer id = scan.nextInt();
                        scan.nextLine();

                        employeeService.viewEmployeeById(id);
                        break;

                    case 4:
                        System.out.print("Enter Employee ID: ");
                        Integer id1 = scan.nextInt();
                        scan.nextLine();

                        Employee employee1 = new Employee();

                        System.out.print("Enter First Name: ");
                        employee1.setFirstName(scan.nextLine());
                        System.out.print("Enter Last Name: ");
                        employee1.setLastName(scan.nextLine());
                        System.out.print("Enter Age: ");
                        employee1.setAge(scan.nextInt());
                        scan.nextLine();
                        System.out.print("Enter Phone Number: ");
                        employee1.setPhoneNumber(scan.nextLine());
                        System.out.print("Enter Position: ");
                        employee1.setPosition(scan.nextLine());
                        System.out.print("Enter Salary: ");
                        employee1.setSalary(scan.nextDouble());
                        scan.nextLine();

                        employeeService.updateEmployee(employee1, id1);
                        break;

                    case 5:
                        System.out.print("Enter Employee ID: ");
                        Integer id2 = scan.nextInt();
                        scan.nextLine();

                        employeeService.deleteEmployee(id2);
                        break;

                    case 6:
                        running = false;
                        System.out.println("Logging out...");
                        break;

                    default:
                        System.err.println("Invalid choice!");
                        break;
                }

            } catch (EmployeeNotFoundException | EmptyDataException exception) {
                System.out.println(exception.getMessage());
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}

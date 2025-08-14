package employee_;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDriver {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeCRUD employeeCRUD = new EmployeeCRUD();
		
		Scanner scanner = new Scanner(System.in);
		
		
		while (true) {
            System.out.println("\n ----Employee Database App----");
            System.out.println("1. Insert Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. View Employee By ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:{
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    
                    System.out.print("Enter Department: ");
                    String department = scanner.next();
                    
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    
                    employeeCRUD.insertEmployee(id,name,department,salary);
                }break;

                case 2:
                	employeeCRUD.fetchAllEmployees();
                    break;

                case 3:{
                    System.out.print("Enter ID: ");
                    employeeCRUD.fetchEmployeeById(scanner.nextInt());
                }break;

                case 4:{
                    System.out.print("Enter ID: ");
                    int updateId = scanner.nextInt();
                    
                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();
                    
                    employeeCRUD.updateEmployeeSalary(updateId, newSalary);
                }break;

                case 5:{
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();

                    employeeCRUD.deleteEmployee(id);
                }break;

                case 6:
                    System.out.println("Exit");
                    //scanner.close();
                    //System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
	}
}

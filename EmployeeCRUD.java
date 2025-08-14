package employee_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeCRUD {

	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1_db","root","root");
	}
	
	public void insertEmployee(int id, String name, String department, double salary) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, department);
		preparedStatement.setDouble(4, salary);
		
		preparedStatement.execute();
		//connection.close();
		System.out.println("Successfully Employee inserted ");
		connection.close();

	}
	
	public void fetchAllEmployees() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");
       
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
        	System.out.println("id: "+resultSet.getInt(1));
        	System.out.println("name: "+resultSet.getString(2));
        	System.out.println("department: "+resultSet.getString(3));
        	System.out.println("salary: "+resultSet.getDouble(4));
        }
        connection.close();
        System.out.println("All employees fetched");
	}
	
	public void fetchEmployeeById(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id=?");
        preparedStatement.setInt(1, id);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
        	System.out.println("id: "+resultSet.getInt(1));
        	System.out.println("name: "+resultSet.getString(2));
        	System.out.println("department: "+resultSet.getString(3));
        	System.out.println("salary: "+resultSet.getDouble(4));
        }else {
        	System.out.println("employee not found");
        }
        
        connection.close();
       
	}
	
	public void updateEmployeeSalary(int id, double newSalary) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update employee set salary=? where id=?");
		preparedStatement.setDouble(1, newSalary);
		preparedStatement.setInt(2, id);

        preparedStatement.execute();
		
		connection.close();
		
		System.out.println("Successfully employee data updated");
		
	}
	
	public void deleteEmployee(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where id=?");
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		
        connection.close();
		
		System.out.println("Successfully employee deleted");
	
    }
}

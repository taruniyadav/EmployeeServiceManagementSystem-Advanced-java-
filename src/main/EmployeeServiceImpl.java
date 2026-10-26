package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public ArrayList<Employee> getemployees() throws SQLException {
		
		ArrayList<Employee> getEmployees = new ArrayList<>();
		
		Connection con = Dbconnection.getConnection();
		
		PreparedStatement ps = con.prepareStatement("select * from Employee");
		
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			
			Employee emp = new Employee(rs.getInt("Employee_id"),rs.getString("Employee_name"),
					rs.getDouble("Employee_salary"),rs.getInt("projects"),rs.getInt("Experience"));
			
			getEmployees.add(emp);
		}
		
		ps.close();
		con.close();
		rs.close();
		return getEmployees;
	}
	
	@Override
	
	public Employee getEmployeeById(int Employee_id) throws SQLException{
		
		
		Employee EmpId = null;
		
		Connection con = Dbconnection.getConnection();
		
		PreparedStatement ps = con.prepareStatement("select * from Employee where Employee_id =?");
		
		ps.setInt(1, Employee_id);
		ResultSet rs = ps.executeQuery();
		
		
		if(rs.next()) {
			
			EmpId = new Employee(rs.getInt("Employee_id"),rs.getString("Employee_name"),
					rs.getDouble("Employee_salary"),rs.getInt("projects"),rs.getInt("Experience"));
			
		}
		rs.close();
		ps.close();
		con.close();
		
		return EmpId;
	}
		
	

	@Override
	public void giveIncrement(int Employee_id, double amount) throws SQLException {
		
		double newSalary = 0;
		Connection con = Dbconnection.getConnection();
		PreparedStatement ps1 = con.prepareStatement("select Employee_salary from Employee where Employee_id = ?");;
		PreparedStatement ps2;
		PreparedStatement ps3;
		try {
			
			con.setAutoCommit(false);//setting the commit to false beacuse it is deafulty set
			//to true and it will commit if both the operations are not successfully executed..
			
			
			ps1.setInt(1, Employee_id);

			ResultSet rs =  ps1.executeQuery();
			
			if(rs.next()) {
				
				double previousSalary = rs.getDouble("Employee_salary");
				
				newSalary = previousSalary + amount;
				
				ps2 = con.prepareStatement("insert into Increment(Employee_id,previous_salary,increment_amount,new_salary)"
						+ " values(?,?,?,?)");
				
				ps2.setInt(1,Employee_id);
				ps2.setDouble(2, previousSalary);
				ps2.setDouble(3,amount);
				ps2.setDouble(4, newSalary);
				ps2.executeUpdate(); 
				
				ps2.close();
				
				
				ps3 = con.prepareStatement("update Employee set Employee_salary = ? where Employee_id = ?");
				ps3.setDouble(1, newSalary);
				ps3.setInt(2, Employee_id);
				
				ps3.executeUpdate();
				ps3.close();
				
				con.commit();// commiting only after the two operations are successfully executed..
				
			}
			
			
			
		}
		catch(SQLException e) {
			con.rollback();
			throw new RuntimeException(e);
			
		}
		finally {
			ps1.close(); 
			con.close();
			
		}
		
		
		
	}


}

package main;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeService {
	
	ArrayList<Employee> getemployees() throws SQLException;
	
	Employee getEmployeeById(int Employee_id) throws SQLException;
	
	void giveIncrement(int Employee_id, double amount) throws SQLException;
	
	
	

}

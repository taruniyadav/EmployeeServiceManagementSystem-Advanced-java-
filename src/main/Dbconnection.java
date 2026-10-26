package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection { 

	public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/Employeebackend_db";
		
		String name = "root";
		String password = "******";
		
		Connection co = DriverManager.getConnection(url,name,password);
		
		return co;
	}

}

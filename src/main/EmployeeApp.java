package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;



public class EmployeeApp {

	public static void main(String[] args) throws SQLException {
		
		EmployeeService empl = new EmployeeServiceImpl();
		Scanner  sc = new Scanner(System.in);
		
		boolean run = true;
		
		while(run) {
			
			try {
				
				//retrieving the information of the employees
				System.out.print("Enter '1' to retrieve the information of all the employees else press any key: ");
				int ch = sc.nextInt();
				
				if(ch == 1) {
					ArrayList<Employee> getemp = empl.getemployees();
					
					for(Employee emp1: getemp) {
						System.out.println
						(	
							"ID          : "+emp1.getEmployee_id()+"\n"+
							"NAME        : "+emp1.getEmployee_name()+"\n"+
							"SALARY      : "+emp1.getEmployee_salary()+"\n"+
							"EXPERIENCE  : "+emp1.getExperience()+"\n"+
							"PROJECTS    : "+emp1.getProjects()+"\n"+
							"----------------------------------------------------------------------------------"
						);
					}
				}
				
				System.out.println("\n");
				
				
				//retrieving the employee id to increment the salary
				
				System.out.print("Enter the Employee Id to know the Employee Details: ");
				int id = sc.nextInt();
				Employee getempbyid = empl.getEmployeeById(id);
				
				boolean getId = true;
				while(getId) {
					
					if(getempbyid != null) {
						
						System.out.println
						(	
							"NAME        : "+getempbyid.getEmployee_name()+"\n"+
							"SALARY      : "+getempbyid.getEmployee_salary()+"\n"+
							"EXPERIENCE  : "+getempbyid.getExperience()+"\n"+
							"PROJECTS    : "+getempbyid.getProjects()+"\n"
						);
						
						getId = false;
						
						
						

					}
					else {
						
						System.out.println("ID not found");
						System.out.print("Please enter the correct Id else enter 0 to exit: ");
						id = sc.nextInt();
						getempbyid = empl.getEmployeeById(id);
						if(id == 0) {
							
							System.out.println("process has terminated");
							run = false;
							break;
						}
						
					}
					
				}
				
				
				if(id == 0) {
					break;
				}
				
				//by using the id we are going to get the previous-salary and  add the bonuses to the salary
				
				double prev_salary = 0;//initialize the value to 0 so that it won't have the previous value stored in it
				
				prev_salary = getempbyid.getEmployee_salary();
				
				double new_salary = 0;
				
				double increment_amt = 0;
				
				int exp = getempbyid.getExperience();
				double exp_bonus = 0;
				
				if(exp <= 5) {
					exp_bonus = 10000;
				}
				else if(exp <= 10) {
					exp_bonus = 20000;
				}
				else if(exp <= 15) {
					exp_bonus = 30000;
				}
				else if(exp <= 20) {
					exp_bonus = 40000;
				}else {
					System.out.println("No experience bonus..");
				}
				
				int projects = getempbyid.getProjects();
				double project_bonus = 0;
				
				if(projects <= 5) {
					project_bonus = 5000;
				}
				else if(projects <= 10) {
					project_bonus = 10000;
				}
				else if(projects <= 15) {
					project_bonus = 15000;
				}
				else if(projects <= 20) {
					project_bonus = 20000;
				}else {
					System.out.println("No project bonus..");
				}
				
				increment_amt = exp_bonus + project_bonus;
				
				empl.giveIncrement(id, increment_amt);
				System.out.println("salary incremented successfully!!!");
				
				System.out.println("enter '1' to continue process  and press any key to stop");
				
				int stop = sc.nextInt();
				
				if(stop != 1) {
					run = false;
				}
				
				
				
			}
			catch(SQLException e) {
				
				throw new RuntimeException(e);
				
			}
			
		}
		
		
	
	}

}

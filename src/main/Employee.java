package main;

public class Employee {

	private int Employee_id;
	
	private String  Employee_name;
	private double Employee_salary;
	private int projects;
	private int Experience;
	
	
	public Employee(int Employee_id, String Employee_name, double Employee_salary, int projects, int Experience) {
		this.Employee_id = Employee_id;
		this.Employee_name = Employee_name;
		this.Employee_salary = Employee_salary;
		this.projects = projects;
		this.Experience = Experience;
	}
	
	public int getEmployee_id() {
		return Employee_id;
	}
	

	
	public int getEmployee_id(int id) {
		return Employee_id;
	}
	
	public void setEmployee_id(int employee_id) {
		Employee_id = employee_id;
	}


	public String getEmployee_name() {
		return Employee_name;
	}


	public void setEmployee_name(String employee_name) {
		Employee_name = employee_name;
	}


	public double getEmployee_salary() {
		return Employee_salary;
	}


	public void setEmployee_salary(double employee_salary) {
		Employee_salary = employee_salary;
	}


	public int getProjects() {
		return projects;
	}


	public void setProjects(int projects) {
		this.projects = projects;
	}

	
	public int getExperience() {
		return Experience;
	}

	
	public void setExperience(int experience) {
		Experience = experience;
	}

}

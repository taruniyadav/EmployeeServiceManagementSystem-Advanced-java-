package main;

public class Increment {

	private int increment_id;
	private int Employee_id;
	private double previous_salary;
	private double increment_amount;
	private double new_salary;
	
	
	public Increment(int increment_id,int Employee_id,double previous_salary,double increment_amount,double new_salary) {
		this.Employee_id = Employee_id;
		this.increment_id = increment_id;
		this.increment_amount = increment_amount;
		this.previous_salary = previous_salary;
		this.new_salary = new_salary;
	}
	public int getIncrement_id() {
		return increment_id;
	}
	public void setIncrement_id(int increment_id) {
		this.increment_id = increment_id;
	}
	public double getPrevious_salary() {
		return previous_salary;
	}
	public void setPrevious_salary(double previous_salary) {
		this.previous_salary = previous_salary;
	}
	public double getIncrement_amount() {
		return increment_amount;
	}
	public void setIncrement_amount(double increment_amount) {
		this.increment_amount = increment_amount;
	}
	public int getEmployee_id() {
		return Employee_id;
	}
	public void setEmployee_id(int Employee_id) {
		this.Employee_id = Employee_id;
	}
	public double getNew_salary() {
		return new_salary;
	}
	public void setNew_salary(double new_salary) {
		this.new_salary = new_salary;
	}
	
	

}

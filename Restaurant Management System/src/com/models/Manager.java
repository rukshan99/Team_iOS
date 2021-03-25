package com.models;

public class Manager extends Employee {
	
	private static final double minSalaryRate = 200.00;
	
	public Manager() {
		super();
	}
	
	public Manager(int empID, String password) {
		super(empID, password);
		this.salaryRate = minSalaryRate;
	}
	
	public Manager(int empID, double salary, int workingHours) {
		super(empID, salary, workingHours);	
		this.salaryRate = minSalaryRate;
	}

	public Manager(int empID, String firstName, String lastName, String password) {		
		super(empID, firstName, lastName, password);	
		this.salaryRate = minSalaryRate;
	}
	
	public Manager(int empID, String firstName, String lastName, String email, String phoneNumber, String password) {
		super(empID, firstName, lastName, email, phoneNumber, password);	
		this.salaryRate = minSalaryRate;	
	}
	
	@Override
	protected void setSalaryRate(double newSalaryRate) {		
		if( newSalaryRate > minSalaryRate  ) {			
			this.salaryRate = newSalaryRate;
		}		
		else			
			this.salaryRate = minSalaryRate;		
	}
	
	/*@Override
	public double calculateSalary() {		
		if( getWorkingStatus() != FINISH )
            return 0;
        
       this.salary =  this.salaryRate * calculateWorkingHours();
       return salary;       
    } */
  
}

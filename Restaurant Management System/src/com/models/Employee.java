package com.models;

import java.time.LocalTime;

public abstract class Employee {	

	private int empID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String password;
	private int workingHours;
	private byte workingStatus;
		
	protected LocalTime LogInTime;
	protected LocalTime LogOutTime;
	protected double salaryRate;
	protected double salary;
	
	public static final byte NOT_ACTIVE = 0;
	public static final byte ACTIVE = 1;
	public static final byte FINISH = 2;	
	
	public Employee() {}
	
	public Employee(int empID, double salary, int workingHours) {
		super();
		this.empID = empID;
		this.salary = salary;
		this.workingHours = workingHours;
	}
	
	public Employee(int empID, String password) {
		super();
		this.empID = empID;
		this.password = password;
	}

	public Employee(int empID, String firstName, String lastName, String password) {		
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;		
	}
	
	public Employee(int empID, String firstName, String lastName, String email, String phoneNumber, String password) {
		super();
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	public int getEmpID() {
		return empID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}	

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}	

	public String getPassword() {
		return password;
	}

	public byte getWorkingStatus() {
		return workingStatus;
	}
	
	public LocalTime getLogInTime() {
		return LogInTime;
	}

	public LocalTime getLogOutTime() {
		return LogOutTime;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setWorkingStatus(byte workingStatus) {
		this.workingStatus = workingStatus;
	}

	public void setLogInTime(LocalTime logInTime) {
		LogInTime = logInTime;
	}

	public void setLogOutTime(LocalTime logOutTime) {
		LogOutTime = logOutTime;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public void logInTime() {
		this.LogInTime = LocalTime.now();
		this.workingStatus = ACTIVE;
	}
	
	public void logOutTime() {		
		if( workingStatus == ACTIVE ) {			
			this.LogOutTime = LocalTime.now();
			this.workingStatus = FINISH; 
		}		
	}
		
	public int calculateWorkingHours() {	
		int workhours = 0;
		
		if( getWorkingStatus() == FINISH ) {			
			 workhours =  LogOutTime.getHour() - LogInTime.getHour();
		}
		
		return workhours;
	}
	
	public double calculateSalary() {		
		if( getWorkingStatus() != FINISH )
            return 0;
        
       this.salary =  this.salaryRate * calculateWorkingHours();
       return salary;       
    } 
	
	protected abstract void setSalaryRate( double newSalaryRate );
	//protected abstract double calculateSalary();
	
}

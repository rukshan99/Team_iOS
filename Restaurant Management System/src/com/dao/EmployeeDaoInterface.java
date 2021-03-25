package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.models.Employee;
import com.models.Manager;
import com.models.StaffMember;

public interface EmployeeDaoInterface{
	public void insertEmployee( Employee emp, String type )throws SQLException;
	public void deleteEmployee( int id )throws SQLException;
	public void updateEmployee(Employee emp) throws SQLException;	
//	public ArrayList<Employee> getManagerList() throws SQLException ;	
	
}


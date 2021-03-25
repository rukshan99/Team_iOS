package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.models.Employee;
import com.models.Manager;
import com.models.StaffMember;
import com.utill.DBUtill;

public class EmployeeDao implements  EmployeeDaoInterface{

	
	static Connection con = DBUtill.getConnection();

	@Override
	public void insertEmployee(Employee emp, String type) throws SQLException {
		
		PreparedStatement pst = con.prepareStatement("insert into employee_details values(?,?,?,?,?,?,?)");
		pst.setInt(1, emp.getEmpID());
		pst.setString(2, emp.getFirstName());
		pst.setString(3, emp.getLastName());
		pst.setString(4, emp.getEmail());
		pst.setString(5, emp.getPhoneNumber());
		pst.setString(6, type);
		pst.setString(7, emp.getPassword());
		
		pst.executeUpdate();		
	}

	@Override
	public void deleteEmployee(int empid) throws SQLException {
		PreparedStatement pst = con.prepareStatement("delete from employee_details where id = ?");
		pst.setInt( 1, empid );
		pst.executeUpdate();
		
	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		PreparedStatement pst = con.prepareStatement("update employee_details set fname=?,"+"lname=?,"+"email=?,"+"phone_number=?,"+"u_Password=? where id = ?");;
		
		pst.setString(1,emp.getFirstName());
		pst.setString(2, emp.getLastName());
		pst.setString(3, emp.getEmail());
		pst.setString(4, emp.getPhoneNumber());
		pst.setString(5, emp.getPassword());
		pst.setInt(6,  emp.getEmpID());
		
		pst.executeUpdate();		
	}

/*	@Override
	public ArrayList<Employee> getManagerList() throws SQLException {
		
		ArrayList<Employee> list = new ArrayList<>();
		PreparedStatement pst = con.prepareStatement("select * from employee_details");
		ResultSet rst = pst.executeQuery();
		
		while( rst.next() ) {
			
			int ID = rst.getInt(1);
			String firstName = rst.getString(2);
			String lastName = rst.getString(3);
			String email = rst.getString(4);
			String phone_number = rst.getString(5);
			String type = rst.getString(6);
			String password = rst.getString(7);
			
			list.add(new Manager(ID, firstName, lastName, email ,phone_number, password));
		}
		return list;
	}
*/

/*	@Override
	public ArrayList<StaffMember> getStaffMemberList() throws SQLException {
		
		ArrayList<StaffMember> staffList = new ArrayList<StaffMember>();
		PreparedStatement pst = con.prepareStatement("select * from employee_details");
		ResultSet rst = pst.executeQuery();
		
		while( rst.next() ) {
			
			int ID = rst.getInt(1);
			String firstName = rst.getString(2);
			String lastName = rst.getString(3);
			String email = rst.getString(4);
			String phone_number = rst.getString(5);
			String type = rst.getString(6);
			String password = rst.getString(7);
			
			staffList.add(new StaffMember(ID, firstName, lastName, email ,phone_number, password));
		}
		return staffList;
	}
	
*/	

	
	
}

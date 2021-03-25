package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.utill.DBUtill;

public class SalaryDao implements SalaryDaoInterface{

	static Connection con = DBUtill.getConnection();
	
	@Override
	public void insertSalary(int id, int workingHours, double salary,int month) throws SQLException {
		
		PreparedStatement pst = con.prepareStatement("insert into salary (eid,hours,salary,emonth) values(?,?,?,?)");
		
		pst.setInt(1, id);
		pst.setInt(2, workingHours);
		pst.setDouble(3, salary);
		
		String mo = null;
		
		switch(month) {
		
		case 1 :
				mo = "January";
				break;
		case 2 :
			mo = "February";
			break;
		case 3 :
			mo = "March";
			break;
		case 4 :
			mo = "April";
			break;
			
		case 5 :
			mo = "May";
			break;
		
		case 6 :
			mo = "June";
			break;
			
		case 7 :
			mo = "July";
			break;
		case 8 :
			mo = "August";
			break;
		case 9 :
			mo = "September";
			break;
			
		case 10 :
			mo = "October";
			break;
		
		case 11 :
			mo = "November";
			break;
			
		case 12 :
			mo = "December";
			break;
		}
		pst.setString(4, mo);
	
		
		pst.executeUpdate();		
	}

	@Override
	public void deleteSalary(int id) throws SQLException {
		PreparedStatement pst = con.prepareStatement("delete from salary where eid = ?");
		pst.setInt( 1, id);
		pst.executeUpdate();
		
	}

	@Override
	public void updateSalary(int id, int workingHours, double salary) throws SQLException {
	

		PreparedStatement pst = con.prepareStatement("update salary set hours=?,"+"salary=? where eid = ?");
		
		pst.setInt(1, workingHours);
		pst.setDouble(2, salary);
		pst.setInt(3, id);
		
		pst.executeUpdate();		
		
	}

}

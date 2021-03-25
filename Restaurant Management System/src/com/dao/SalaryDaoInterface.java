package com.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.models.Menu;

public interface SalaryDaoInterface {

	public void insertSalary( int id, int workingHours, double salary, int month  )throws SQLException;
	public void deleteSalary( int id )throws SQLException;
	public void updateSalary(int id, int workingHours, double salary )throws SQLException;
	

}

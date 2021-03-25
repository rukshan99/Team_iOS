package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.utill.DBUtill;

public class SalaryDetailDao implements SalaryDetailDaoInterface {

	static Connection con = DBUtill.getConnection();
	
	@Override
	public void insertSalaryDetail(int id, double risk, double other, double advance, double loan) throws SQLException {
		PreparedStatement pst = con.prepareStatement("insert into salarydetail  values(?,?,?,?,?)");
		
		pst.setInt(1, id);
		pst.setDouble(2, risk);
		pst.setDouble(3,  other);
		pst.setDouble(4, advance);
		pst.setDouble(5, loan);
		pst.executeUpdate();		
	}

	@Override
	public void deleteSalaryDetail(int id) throws SQLException {
		PreparedStatement pst = con.prepareStatement("delete from salarydetail where id = '"+id+"'");
	
		pst.executeUpdate();
		
	}

	@Override
	public void updateAdvanceSalaryDetail(int id, double advance) throws SQLException {
		

		PreparedStatement pst = con.prepareStatement("update salarydetail set advance = ? where id = '"+id+"'");
		
		pst.setDouble(1, advance);		
		pst.executeUpdate();
	}

	@Override
	public void updateLoanSalaryDetail(int id, double loan) throws SQLException {
		
		PreparedStatement pst = con.prepareStatement("update salarydetail set loan = ? where id = '"+id+"'");
		
		pst.setDouble(1, loan);		
		pst.executeUpdate();
	}

	@Override
	public void updateOtherSalaryDetail(int id, double other) throws SQLException {
		PreparedStatement pst = con.prepareStatement("update salarydetail set other = ? where id = '"+id+"'");
		
		pst.setDouble(1, other);		
		pst.executeUpdate();
		
	}

	@Override
	public void updateRiskSalaryDetail(int id, double risk) throws SQLException {
		
		PreparedStatement pst = con.prepareStatement("update salarydetail set risk = ? where id = '"+id+"'");
		
		pst.setDouble(1, risk);		
		pst.executeUpdate();
	}

}

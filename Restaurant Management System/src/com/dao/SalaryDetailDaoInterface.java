package com.dao;

import java.sql.SQLException;

public interface SalaryDetailDaoInterface {

	
	public void insertSalaryDetail( int id, double risk, double other, double advance, double loan   )throws SQLException;
	public void deleteSalaryDetail( int id )throws SQLException;
	public void updateAdvanceSalaryDetail(int id, double advance )throws SQLException;
	public void updateLoanSalaryDetail(int id, double loan )throws SQLException;
	public void updateOtherSalaryDetail(int id, double other )throws SQLException;
	public void updateRiskSalaryDetail(int id, double risk )throws SQLException;
}

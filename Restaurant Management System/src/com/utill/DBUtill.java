package com.utill;

import com.models.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class DBUtill {
	
	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement pst = null;
	private static Statement stmt = null;
	
	private static final String url = "jdbc:mysql://localhost:3306/restaurant_management_system";
	private static final String user = "root";
	private static final String passwrd = "";	 
	
	static {		
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection( url, user, passwrd);
		} catch (ClassNotFoundException e) {
			System.err.println("Exception :" +e.getMessage());
		} catch (SQLException e) {
			System.err.println("Exception :" +e.getMessage());
		}		
	}
	
	public DBUtill() {}
	
	public static Connection getConnection(){
		return con;
	}	
	
	public Employee searchByUserId(int userId) {				
		try {
			stmt = con.createStatement();
			String sql = "select* from employee_details where id = '"+userId+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String email = rs.getString(4);
				String p_Num = rs.getString(5);
				String uType = rs.getString(6);
				String uPassword = rs.getString(7);
				
				if(uType.equalsIgnoreCase("ADMIN"))
					return new Manager(id, fname, lname, email, p_Num, uPassword);
				
				else
					return new StaffMember(id, fname, lname, email, p_Num, uPassword);
			}									
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}	
	
    public Menu searchMenuItemById(int itemID) {		
		try {
			stmt = con.createStatement();
			String sql = "select* from menu where id = '"+itemID+"'";
			rs = stmt.executeQuery(sql);
			
			if( rs.next() ) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				String menutype = rs.getString(4);
				byte[] img = rs.getBytes("image");
				
								
				return new Menu( id, name, price, menutype, img);
			}
		}catch( SQLException e ) {
			System.err.println("Exception :" +e.getMessage());
		}
		
		return null;
		
	}
    
    public Order searchOrderById(int orderID) {				
    	try {
			stmt = con.createStatement();
			String sql = "select o.id,o.staffid,o.status,o.total,o.datetime,e.fname,e.lname from myorder o, employee_details e where o.staffid=e.id AND o.id = '"+orderID+"'";
			
			rs = stmt.executeQuery(sql);
			int id =0;
			if( rs.next() ) {
				
					id = rs.getInt(1);
					int staffid  = rs.getInt(2);
					String status = rs.getString(3);
					double price = (double)rs.getDouble(4);
					Date date = rs.getDate(5);
			
					String fname = rs.getString(6);
					String lname = rs.getString(7);
				
					String staffName = (fname + " " + lname);
				
				
				byte orderstatus = 0;
				if(status.equalsIgnoreCase("Active") ) {
					orderstatus = Order.ORDER_ACTIVE;
				}else if( status.equalsIgnoreCase("Closed") ) {
					orderstatus = Order.ORDER_CLOSED;
				}else if( status.equalsIgnoreCase("Cancelled") ) {
					orderstatus = Order.ORDER_CANCELED;
				}
				
				return new Order( id, staffid, staffName, price, orderstatus, date);
			}
		}catch(Exception e ) {
			//System.err.println("Exception :" +e.getMessage());
		}
		
    int id = 0;
	String status = null;
	double price = 0.0;
	byte orderstatus = 0;
	
			try {
			
				String sql = "select id,status,total from myorder where id = '"+orderID+"' ";
				rs = stmt.executeQuery(sql);
				
				if (rs.next()) {
					id = rs.getInt(1);
					status = rs.getString(2);
					price = (double)rs.getDouble(3);
												
					orderstatus = 0;
					if(status.equalsIgnoreCase("Active") ) {
						orderstatus = Order.ORDER_ACTIVE;
					}else if( status.equalsIgnoreCase("Closed") ) {
						orderstatus = Order.ORDER_CLOSED;
					}else if( status.equalsIgnoreCase("Cancelled") ) {
						orderstatus = Order.ORDER_CANCELED;
					}
					
					return new Order(id,price,orderstatus);
				}
			}catch(Exception y) {
				
			}
		
		return null;
		
	}
    
    public ResultSet searchSalaryById(int id, int month) {		
    	
    	try {
    		String sql = "select eid,hours,salary,emonth from salary where eid = '"+id+"' AND emonth = ? ";
    		
    		PreparedStatement pst = con.prepareStatement(sql);
    		
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
    		  		
    		pst.setString( 1, mo);   				
			
			rs =  pst.executeQuery();			
			
			return rs;
		}catch( SQLException e ) {
			System.err.println("Exception :" +e.getMessage());
		}
		
		return null;
    	
    	
    	
    	
    }
    

	public ResultSet refreshTable() {		
		try {
			getConnection();
			String query = "Select * From employee_details";
			
			pst = con.prepareStatement(query);
			rs = pst.executeQuery(query);			
		} catch (Exception e) {			
			System.out.println("Data Loading Error!!\n Please Check The Connection");
			System.err.println("Exception :" +e.getMessage());
		}		
		return rs;			
	}
	
	public ResultSet refreshMenuTable( ) {		
		try {
			getConnection();
			String query = "Select id,itemname,itemprice,itemtype From menu ";
			
			pst = con.prepareStatement(query);
			rs = pst.executeQuery(query);		
		} catch (Exception e) {			
			System.out.println("Data Loading Error!!\n Please Check The Connection");
			System.err.println("Exception :" +e.getMessage());
		}		
		return rs;			
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*public ResultSet refreshInsertMenuTable( ) {		
		try {
			getConnection();
			String query = "Select image From menu ";
			
			pst = con.prepareStatement(query);
			rs = pst.executeQuery(query);		
		} catch (Exception e) {			
			System.out.println("Data Loading Error!!\n Please Check The Connection");
			System.err.println("Exception :" +e.getMessage());
		}		
		return rs;			
	}*/
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public ResultSet refreshOrderTable() {		
		try {
			getConnection();
			String query = "Select * From myorder";
			
			pst = con.prepareStatement(query);
			rs = pst.executeQuery(query);			
		} catch (Exception e) {			
			System.out.println("Data Loading Error!!\n Please Check The Connection");
			System.err.println("Exception :" +e.getMessage());
		}		
		return rs;			
	}
	
    public ResultSet searchByType(String searchType, String searchText) {
		rs = null;
		try {			
			String query = "select * from employee_details where "+searchType+"= '"+searchText+"' ";
			System.out.println(query);
			pst = con.prepareStatement(query);
			//pst.setInt(0, Integer.parseInt(id));	
			rs = pst.executeQuery(query);			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return rs;
	}
    
    public ResultSet searchByTypeMenu(String searchType, String searchText) {
		
		try {			
			String query = "select id,itemname,itemtype,itemprice from menu where "+searchType+"= '"+searchText+"' ";
			pst = con.prepareStatement(query);
			rs = pst.executeQuery(query);			
		
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
		return rs;
	}
    
    public ResultSet searchByOrderID(String searchText) {
		
		try {			
			String query = "select * from myorder where id= '"+searchText+"' ";
			pst = con.prepareStatement(query);
			rs = pst.executeQuery(query);			
		
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
		return rs;
	}
    
    public ResultSet searchByOrderID(String type, String searchText) {
		
		try {			
			String query = "select * from myorder where "+type+" = '"+searchText+"' ";
			pst = con.prepareStatement(query);
			rs = pst.executeQuery(query);			
		
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
		return rs;
	}
    
    public ResultSet searchSalaryDetailsByOrderID(int id) {
		
		try {			
			String query = "select * from salarydetail where id = '"+id+"' ";
			pst = con.prepareStatement(query);
			rs = pst.executeQuery(query);			
		
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
		return rs;
	}
    
	public int getLastIdfromMyOrder() {
		
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query = "select id from myorder";
			rs = stmt.executeQuery(query);
			rs.last();
			
			int id = rs.getInt(1);
			return id; 
			 
		} catch (SQLException e) {			
			e.printStackTrace();			
		}		
		
			
		
		return 0;		
	}
	
	public int getLastIdfromMenu() {
		
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query = "select id from menu";
			rs = stmt.executeQuery(query);
			rs.last();
			
			int id = rs.getInt(1);
			return id;
			 
		} catch (SQLException e) {			
			e.printStackTrace();
		}			
		
		return 0;		
	}
	
	public int getLastIdfromEmployee() {
		
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query = "select id from employee_details";
			rs = stmt.executeQuery(query);
			rs.last();
			
			int id = rs.getInt(1);
			return id;
			 
		} catch (SQLException e) {			
			e.printStackTrace();
		}			
		
		return 0;		
	}
	public static void insertStock(String insertQuery) {
		try {			
			pst = con.prepareStatement(insertQuery);
			pst.execute();		
		
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

	public static void updateStock(String updateQuery) {
		try {			
			pst = con.prepareStatement(updateQuery);
			pst.executeUpdate(updateQuery);		
		
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}
	
	public static void deleteStock(String deleteQuery) {
		try {			
			pst = con.prepareStatement(deleteQuery);
			pst.executeUpdate(deleteQuery);		
		
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}
	
}

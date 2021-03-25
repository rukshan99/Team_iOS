package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.models.Order;
import com.utill.DBUtill;

public class OrderDao implements OrderDaoInterface{

	static Connection con = DBUtill.getConnection();
	
	@Override
	public int insertOrder(Order order) throws SQLException {
		String state = null;
		
		PreparedStatement pst = con.prepareStatement("insert into myorder (id,staffid,status,total) values(?,?,?,?)");
		pst.setInt(1, order.getOrderID());
		pst.setInt(2, order.getStaffID());
		if(order.getOrderState() == Order.ORDER_ACTIVE) {
			 state = "Active";
		}else if(order.getOrderState() == Order.ORDER_CLOSED) {
			 state = "Closed";
		}else if(order.getOrderState() == Order.ORDER_CANCELED) {
			 state = "Cancelled";
		} 
		pst.setString(3, state);
		pst.setDouble(4, order.getGrandTotal());
		
		int row = pst.executeUpdate();
		
		return row;		
	}

	@Override
	public void deleteOrder(int orderID) throws SQLException {

		PreparedStatement pst = con.prepareStatement("delete from myorder where id = ?");
		pst.setInt( 1, orderID );
		pst.executeUpdate();
		
	}

	@Override
	public void updateOrder(Order order) throws SQLException {
		
		PreparedStatement pst = con.prepareStatement("update myorder set staffid=?,"+"total=?,"+"status=?  where id = ?");;
		
		//pst.setString(1,order.getStaffName());
		pst.setInt(1,order.getStaffID());
		pst.setDouble(2, order.getGrandTotal());
		
		String orderstatus = null;
		if(order.getOrderState()== Order.ORDER_ACTIVE ) {
			orderstatus = "Active";
		}else if( order.getOrderState() ==  Order.ORDER_CLOSED ) {
			orderstatus = "Closed";
		}else if( order.getOrderState() ==  Order.ORDER_CANCELED ) {
			orderstatus = "Cancelled";
		}
		pst.setString(3, orderstatus);
		pst.setInt(4,order.getOrderID());
		
		
		
		pst.executeUpdate();		
	}

	/*@Override
	public ArrayList<Order> getOrderList() throws SQLException {
		ArrayList<Order> list = new ArrayList<>();
		PreparedStatement pst = con.prepareStatement("select * from order");
		ResultSet rst = pst.executeQuery();
		
		while( rst.next() ) {
			
			int orderID = rst.getInt(1);
			int staffID = rst.getInt(2);
			String staffName = rst.getString(3);
		    Double grandTot = rst.getDouble(4);
			Byte status = rst.getByte(5);
		
			
			list.add(new Order(orderID, staffID, grandTot, status));
		}
		return list;
	
	}*/

}

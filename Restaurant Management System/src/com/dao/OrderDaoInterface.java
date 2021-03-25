package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;


import com.models.Order;

public interface OrderDaoInterface {
	public int insertOrder( Order order )throws SQLException;
	public void deleteOrder( int orderID )throws SQLException;
	public void updateOrder( Order order )throws SQLException;	
	//public ArrayList<Order> getOrderList() throws SQLException ;
}

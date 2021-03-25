package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.models.Order;
import com.models.OrderDetails;

public interface OrderDetaisDaoInterface {

	public void insertOrdrDetail(Order order, OrderDetails orderdetail  )throws SQLException;
	public void deleteOrdrDetail( int orderid, int menuid )throws SQLException;
	public void updateOrdrDetail( Order order, OrderDetails orderdetail)throws SQLException;	
	public ArrayList getOrderDetailList(int orderid) throws SQLException;
	//public ResultSet getrDetailList(int orderid) throws SQLException;
}

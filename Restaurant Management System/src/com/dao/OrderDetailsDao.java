package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.models.Order;
import com.models.OrderDetails;
import java.sql.ResultSet;
import com.utill.DBUtill;

public  class OrderDetailsDao implements OrderDetaisDaoInterface {

	static Connection con = DBUtill.getConnection();
	
	@Override
	public void insertOrdrDetail(Order order,OrderDetails orderdetail) throws SQLException {		
		
		PreparedStatement pst = con.prepareStatement("insert into orderdetail  values(?,?,?)");
		pst.setInt(1, order.getOrderID() );
		pst.setInt(2, orderdetail.getItemID());
		pst.setInt(3, orderdetail.getQuantity());		
		
		 pst.executeUpdate();			
	}

	@Override
	public void deleteOrdrDetail(int orderid, int menuid) throws SQLException {
		
		PreparedStatement pst = con.prepareStatement("delete from orderdetail where orderid = ? AND menuid = ? ");
		pst.setInt( 1, orderid );
		pst.setInt( 2, menuid );
		pst.executeUpdate();		
		
	}

	@Override
	public void updateOrdrDetail(Order order, OrderDetails orderdetail) throws SQLException {
		PreparedStatement pst = con.prepareStatement("update orderdetail set orderid=?,"+"menuid=?,"+"quantity=? where orderid = ? AND menuid = ? ");;
				
		pst.setInt(1,order.getOrderID());
		pst.setDouble(2, orderdetail.getItemID());
		pst.setInt(4, orderdetail.getQuantity());		
		
		pst.executeUpdate();		
	}	

	@Override
	public ArrayList<String[]> getOrderDetailList(int orderid) throws SQLException {
		
		ArrayList<String[]> list = new ArrayList<String[]>();
		String query = "SELECT m.id,m.itemname,od.quantity,m.itemprice,o.total,e.id FROM myorder o,orderdetail od,menu m,employee_details e WHERE o.id = '"+orderid+"' AND o.id=od.orderid AND od.menuid = m.id AND o.staffid = e.id";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rst = pst.executeQuery();
		String[] str;
		
			while( rst.next() ) {
			
				str= new String[6];
				 
				str[0] = Integer.toString(rst.getInt(1)); 	//id
				str[1] = rst.getString(2);					//name	
				str[2] = Integer.toString(rst.getInt(3));	//quantity
				str[3] = Double.toString(rst.getDouble(4));	//itemprice
				str[4] = Double.toString(rst.getDouble(5));	//order tot
				str[5] = Integer.toString(rst.getInt(6));
				
				list.add(str);
			}
		
		return list;
	}

	/*@Override
	public ResultSet getrDetailList(int orderid) throws SQLException {
		
		String query = "SELECT m.id,m.itemname,od.quantity,m.itemprice,o.total FROM myorder o,orderdetail od,menu m WHERE o.id = '"+orderid+"' AND o.id=od.orderid AND od.menuid = m.id";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rst = pst.executeQuery();
		
		return rst;
	
	} */

	

}

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.models.Menu;
import com.utill.DBUtill;

public class MenuDao implements MenuDaoInterface {

	static Connection con = DBUtill.getConnection();
	
	@Override
	public void insertMenu(Menu menu, String image) throws SQLException {
		
		PreparedStatement pst = con.prepareStatement("insert into menu values(?,?,?,?,'"+image+"')");
		
		pst.setInt(1, menu.getItemID());
		pst.setString(2, menu.getItemName());
		pst.setDouble(3, menu.getItemPrice());
		pst.setString(4, menu.getType());
		
		
		pst.executeUpdate();		
	}

	@Override
	public void deleteMenu(int menuID) throws SQLException {
		PreparedStatement pst = con.prepareStatement("delete from menu where id = ?");
		pst.setInt( 1, menuID );
		pst.executeUpdate();
		
		
	}

	@Override
	public void updateMenu(Menu menu, String image) throws SQLException {
		
		PreparedStatement pst = con.prepareStatement("update menu set id=?,"+"itemname=?,"+"itemprice=?,"+"itemtype=?,"+" image = '"+image+"'where id = ?");
		
		pst.setInt(1, menu.getItemID());
		pst.setString(2,menu.getItemName());
		pst.setDouble(3, menu.getItemPrice());
		pst.setString(4, menu.getType());
		pst.setInt(5, menu.getItemID());
		
		pst.executeUpdate();		
	}
	
	public void updateMenu(Menu menu) throws SQLException {		
		PreparedStatement pst = con.prepareStatement("update menu set id=?,"+"itemname=?,"+"itemprice=?,"+"itemtype=? where id = ?");
		
		pst.setInt(1, menu.getItemID());
		pst.setString(2,menu.getItemName());
		pst.setDouble(3, menu.getItemPrice());
		pst.setString(4, menu.getType());
		pst.setInt(5, menu.getItemID());
		
		pst.executeUpdate();			
	}

	@Override
	public ArrayList<Menu> getMenuList( String menuType ) throws SQLException {

		PreparedStatement pst = null;
		
		ArrayList<Menu> list = new ArrayList<>();
		
		if( menuType.equalsIgnoreCase("All") ) {
			pst = con.prepareStatement("select id, image from menu ");
		}else {
			pst = con.prepareStatement("select id, image from menu where itemtype='"+menuType+"'");
		}
		
		ResultSet rst = pst.executeQuery();
		
		while( rst.next() ) {
			
			int itemID = rst.getInt(1);
			byte[] img = rst.getBytes("image");			
			
			list.add(new Menu(itemID , img ));
		}
		
		return list;
	}

}

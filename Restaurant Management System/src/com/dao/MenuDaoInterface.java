package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.models.Menu;

public interface MenuDaoInterface {


	public void insertMenu( Menu menu, String image  )throws SQLException;
	public void deleteMenu( int menuID )throws SQLException;
	public void updateMenu( Menu menu, String image)throws SQLException;
	public void updateMenu(Menu menu) throws SQLException;
	public ArrayList<Menu> getMenuList(  String menuType ) throws SQLException ;
}

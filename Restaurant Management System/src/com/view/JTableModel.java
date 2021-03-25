package com.view;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

public class JTableModel extends AbstractTableModel {
	private String[] columns;
	private Object[][] row; 
	
	public JTableModel() {}
	
	public JTableModel(String[] columns) {		
		this.columns = columns;
		
	}
	public JTableModel(String[] columns, Object[][] row) {		
		this.columns = columns;
		this.row = row;
	}
	
	public Class getColumnClass(int column) {
		return Icon.class;
	}
	
	@Override
	public int getRowCount() {
		return this.row.length;
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.row[ rowIndex][columnIndex];
	}
	
	public String getColumnName(int col) {
		return this.columns[col];
	}

}

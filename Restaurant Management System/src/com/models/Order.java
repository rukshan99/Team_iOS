package com.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Order {
	
	private int orderID;	
	private int staffID;
	private String staffName;
	private double grandTotal = 0.0;
	private byte orderState;
	private Date date;
	
	private ArrayList<OrderDetails> orderList = new ArrayList<OrderDetails>();
	
	public static final byte ORDER_ACTIVE   =  1;
	public static final byte ORDER_CLOSED   =  2;
	public static final byte ORDER_CANCELED =  0;	
	
	public Order( int orderID, int staffID) {
		this.orderID = orderID;
		this.staffID = staffID;		
		this.orderState = ORDER_ACTIVE;	
	}
	
	public Order(int orderID, int staffID, double grandTotal, byte orderState,
			ArrayList<OrderDetails> orderList) {
		
		this.orderID = orderID;		
		this.staffID = staffID;
		this.grandTotal = grandTotal;
		this.orderState = orderState;
		this.orderList = orderList;
	}
	
	public Order(int orderID, int staffID, double grandTotal, byte orderState, Date date) {
	
		this.orderID = orderID;	
		this.staffID = staffID;
		this.grandTotal = grandTotal;
		this.orderState = orderState;
	}	

	public Order(int orderID, int staffID, String staffName, double grandTotal, byte orderState, Date date) {
		
		this.orderID = orderID;
		this.staffID = staffID;
		this.staffName = staffName;
		this.grandTotal = grandTotal;
		this.orderState = orderState;
		this.date = date;
	}

	public Order(int orderID, double grandTotal, byte orderState) {
		
		this.orderID = orderID;
		this.grandTotal = grandTotal;
		this.orderState = orderState;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public void setOrderState(byte orderState) {
		this.orderState = orderState;
	}

	public int getOrderID() {
		return orderID;
	}	

	public int getStaffID() {
		return staffID;
	}
	

	public String getStaffName() {
		return staffName;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public byte getOrderState() {
		return orderState;
	}

	public ArrayList<OrderDetails> getorderList() {
		return orderList;
	}	
	
	public boolean addItem( Menu newItem, int quantity ) {		
		Iterator<OrderDetails> olist = orderList.iterator();
		OrderDetails order;
		
		boolean notFound = true;
		
		while( olist.hasNext() && notFound ) {			
			order = olist.next();
			
			if( order.getItemID() == newItem.getItemID() ) {				
					order.addQuantity(quantity);
					notFound = false;
			}			
		}
		
		if(notFound) {			
			orderList.add(new OrderDetails ( newItem, quantity ) );
			
		}
		
		calculateTotal(newItem.getItemPrice() * quantity);
		
		return notFound;
	}
	
	public void editItem( Menu newItem, int quantity ) {		
		Iterator<OrderDetails> olist = orderList.iterator();
		OrderDetails order;		
				
		while( olist.hasNext() ) {			
			order = olist.next();
		
			if( order.getItemID() == newItem.getItemID() ) {
				
					order.calculateTotal();
					calculateTotal( -1 * (order.getTotalPrice()) );
				
					order.setQuantity(quantity);
					order.calculateTotal();
					calculateTotal(order.getTotalPrice());
					break;
			}			
		}				
	}
	
	public void deleteItem( Menu newItem ) {		
		Iterator<OrderDetails> olist = orderList.iterator();
		OrderDetails order;	
		int i = 0;
				
		while( olist.hasNext() ) {			
			order = olist.next();
		
			if( order.getItemID() == newItem.getItemID() ) {
				
					order.calculateTotal();
					this.calculateTotal( -1 * (order.getTotalPrice()) );				
					
					this.orderList.remove(i);
					break;
			}
			
			i++;
		}				
	}
	
	public void calculateTotal(Double tot) {		
		this.grandTotal = this.grandTotal + tot;
	}	
	
}

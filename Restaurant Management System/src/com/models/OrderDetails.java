package com.models;

public class OrderDetails {

	private int ItemID;
	private int quantity;
	private String itemName;
	private double itemPrice;
	private double totalPrice;	
	
	public OrderDetails( Menu item, int quantity ) {		
		this.ItemID = item.getItemID();
		this.quantity = quantity;
		this.itemName = item.getItemName();
		this.itemPrice = item.getItemPrice();
	}

	public int getItemID() {
		return ItemID;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public double getTotalPrice() {		
		return totalPrice;
	}	
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void addQuantity( int quantity ) {		
		this.quantity = this.quantity + quantity;		
	}	
	
	public void calculateTotal() {		
		this.totalPrice = (this.itemPrice * quantity);
	}	
}

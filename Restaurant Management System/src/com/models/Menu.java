package com.models;

public class Menu {

	private static int ID = 1;
	
	private int itemID;
	private String itemName;
	private double itemPrice;
	private String type;	
	private byte[] image;
	

	public Menu(int itemID) {		
		this.itemID = itemID;		
	}
	
	public Menu(int itemID, byte[] image) {		
		this.itemID = itemID;
		this.image = image;
	}
	
	public Menu( int itemID, String itemName, double itemPrice, String type ) {
	    this.itemID = itemID;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.type = type;
	}
	
	public Menu(int itemID, String itemName, double itemPrice, String type, byte[] image) {
		
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.type = type;
		this.image = image;
	}	
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getItemID() {
		return itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public String getType() {
		return type;
	}
	
	public byte[] getImage() {
		return image;
	}
}

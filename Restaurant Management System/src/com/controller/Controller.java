package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.joda.time.LocalDate;

import com.dao.EmployeeDao;
import com.dao.MenuDao;
import com.dao.OrderDao;
import com.dao.OrderDetailsDao;
import com.dao.SalaryDao;
import com.dao.SalaryDetailDao;
import com.models.Employee;
import com.models.Manager;
import com.models.Menu;
import com.models.Order;
import com.models.OrderDetails;
import com.models.StaffMember;
import com.utill.DBUtill;
import com.view.backend.MainUserInterface;
import com.view.frontend.MngOrder;
import com.view.frontend.SignIn;

public class Controller {	
	private File file;
	private File ofile;
	private File pfile;
	
	private Employee emp;
	private Order myOrder;
	private static int currentOrderId;
		
	private static String currentUserName;
	private static int currentUserId;
	
	private byte userType;
	private int orderType;
	private SignIn userSignIn;
	private MainUserInterface myMainInterface;
	private DBUtill database;
	private String errorMessage;
	private EmployeeDao e1;
	private SalaryDao sal;
	private SalaryDetailDao salDetail;
	private MenuDao menuItem;
	private OrderDao order;
	private OrderDetailsDao orderDetails;
	
	public Controller() {
		
		this.database = new DBUtill();
		this.userSignIn = new SignIn(this);
		this.myMainInterface = new MainUserInterface(this);
		this.file = new File("D:\\oop\\Restaurant_Management_System\\Private\\name.txt");	
		this.ofile = new File("D:\\oop\\Restaurant_Management_System\\Private\\address.txt");	
		this.pfile = new File("D:\\oop\\Restaurant_Management_System\\Private\\phone.txt");
		this.e1 = new EmployeeDao();
		this.sal = new SalaryDao();
		this.salDetail = new SalaryDetailDao();
		this.menuItem = new MenuDao();
		this.order = new OrderDao();
		this.orderDetails = new OrderDetailsDao();
		userSignIn.setVisible(true);
		orderType = 0;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}	

	public byte getUserType() {
		return userType;
	}

	public void setUserType(byte userType) {
		this.userType = userType;
	}	

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String getCurrentUserName() {
		return currentUserName;
	}

	public int getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserName(String currentUserName) {
		Controller.currentUserName = currentUserName;
	}

	public void setCurrentUserId(int currentUserId) {
		Controller.currentUserId = currentUserId;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public void runMainInterface() {		
		this.myMainInterface.setVisible(true);
		myMainInterface.changeUserView(userType);	
	}	
	
	public void setTime(JLabel label) {
		new Timer(0,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				SimpleDateFormat s = new SimpleDateFormat("hh-mm-ss a");
				label.setText(s.format(date));				
			}
		}).start();
	}
	
	public void setDate(JLabel label) {
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		label.setText(s.format(date));
	}
	
	public String getRestaurentName() {
		String name = null;
		
		try {
			Scanner scn = new Scanner(file);
			name = scn.nextLine();
			scn.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return name;
	}
	
	public void setRestaurentName(String name) {
		try {
			FileWriter myWitter = new FileWriter(file);
			myWitter.write(name.toUpperCase() + "  " + "RESTAURANT");
			myWitter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String[] getRestaurentAddress() {
		int x= 0;
		String[] address = new String[3];
		
		try {
			Scanner scn = new Scanner(ofile);
			while(scn.hasNext()) {
				address[x] = scn.nextLine();
				x++;
			}	
			scn.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return address;
	}
	
	public void setRestaurentAddress(String[] address) {
		try {
			FileWriter myWritter = new FileWriter(ofile);
			myWritter.write(address[0].toUpperCase() + "\n");
			myWritter.write(address[1].toUpperCase() + "\n");
			myWritter.write(address[2].toUpperCase() + "\n");
			myWritter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getRestaurentPhone() {
		String phone = null;
		
		try {
			Scanner scn = new Scanner(pfile);
			phone = scn.nextLine();
			scn.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return phone;
	}
	
	public void setRestaurentPhone(String phone) {
		try {
			FileWriter myWitter = new FileWriter(pfile);
			myWitter.write(phone);
			myWitter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Boolean loginCheck(int userId, String password, Boolean isManager) {
		
		//Add variables
		boolean userFound = false;
		String className;
		//Employee emp;
		
		//call database method
		this.emp = database.searchByUserId(userId);
		
		//check the user type and get value for variable className
		if(isManager)
			className = "COM.MODELS.MANAGER";  
		else
			className = "COM.MODELS.STAFFMEMBER";
		
		if(emp != null) {
			
			if(emp.getClass().getName().equalsIgnoreCase(className)) {  
				
				if(emp.getPassword().equals(password)) {
					userFound = true;	
					this.setCurrentUserId(userId);
					this.setCurrentUserName(emp.getFullName());
					emp.logInTime();
					
					if(isManager)
						this.setUserType(MainUserInterface.getModeManager());
						
					else
						this.setUserType(MainUserInterface.getModeStaffMember());
				}
				else {
					this.setErrorMessage("Password is Incorrect");  //user password is not correct although user id and type is correct
				}
			}
			else {
				this.setErrorMessage("User Not Found");  //user type not match although there is a matching user id
			}
		}
		else {
			this.setErrorMessage("User Not Found.");  //user id not match
		}
	
		return userFound;
		
	}
	
	public void logOut() {
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		int month = LocalDate.now().getMonthOfYear();	
		
		int opt;
		double sal;
		int workHour;
		
		opt =  showConfirmMessageDialog("Are you sure do you want to log out", "Looging Out");
		
		if(opt == 0) {
			emp.logOutTime();
			workHour = emp.calculateWorkingHours();			
			sal = emp.calculateSalary();			
			ResultSet rs = database.searchSalaryById(emp.getEmpID(),month);					
			
			try {
				if( rs.next() ) {
					
					int eid = rs.getInt(1);
					int wHours = rs.getInt(2);
					double salary = rs.getDouble(3);	
					
					sal += salary; 
					workHour += wHours;
					
					this.sal.updateSalary(emp.getEmpID(), workHour , sal);							
										
				}
				
				else {
					try {
						System.out.println("insert");
						this.sal.insertSalary(emp.getEmpID(), workHour , sal, month );
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.myMainInterface.setVisible(false);
			this.userSignIn.setVisible(true);
		}							
	}
	
	public ResultSet refreshData() {		
		return this.database.refreshTable();
	}	
	
	public ResultSet refreshMenuData() {		
		return this.database.refreshMenuTable();
	}	

	public ResultSet refreshOrderData() {		
		return this.database.refreshOrderTable();
	}	
	
	public Employee getEmployeeData( int id) {		
		return this.database.searchByUserId(id); 
	}
	
	public Menu getMenuData( int id ) {		
		return this.database.searchMenuItemById(id);		
	}
	
	public Order getOrderData( int id ) {		
		return this.database.searchOrderById(id);		
	}

	public ResultSet searchData(String type, String text) {
		return this.database.searchByType(type, text);
	}
	
	public ResultSet searchMenuData(String type, String text) {
		return this.database.searchByTypeMenu(type, text);
	}
	
	public ResultSet searchOrderData( String text) {
		return this.database.searchByOrderID(text);
	}
	
		
	public ResultSet searchOrderData(String type, String text) {
		return this.database.searchByOrderID(type, text);
	}
	
	public ResultSet searchSalaryData(int id) {
		return database.searchSalaryDetailsByOrderID(id);
	}
	
	////////////////Manage Order Menu Methods/////////////////////
	public void createOrder() {
		
		int id = this.getNextOrderID();			
	
		myOrder = new Order(id, this.getCurrentUserId());
		System.out.println(id);
	}
	
	public void createOrder(int id, int staffId) {		
		myOrder = new Order(id, staffId);
	}
	
	public boolean addToOrder(Menu menu, int q) {
		boolean notFound = myOrder.addItem(menu, q);
		
		return notFound;
	}
	
	public void deleteFromOrder(Menu menu) {
		this.myOrder.deleteItem(menu);		
	}
	
	public void setOrder(Menu menu, int quantity) {
		myOrder.editItem(menu, quantity);
	}

	public double getGrandTot() {
		return myOrder.getGrandTotal();
	}	
	
	public ArrayList<Menu> showMenu( String menuType ){
		
		String type = null;	
					
			try {
				return this.menuItem.getMenuList(menuType );
			} catch (SQLException e) {				
				e.printStackTrace();
			}			 
		
		return null;
	}
	
	public int getNextOrderID() {		
		return (database.getLastIdfromMyOrder() + 1);
	}
	
	public int getNextMenuID() {
		return (database.getLastIdfromMenu()+1);
	}
	
	public int getNextEmployeeID() {
		return (database.getLastIdfromEmployee()+1);
	}
	
	public void updateSalAdvance(int id, double advance) {
		try {
			salDetail.updateAdvanceSalaryDetail(id, advance);
			showConfirmMessageDialog("Succesfully rechanged", "Advance change");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateSalLoan(int id, double loan) {
		try {
			salDetail.updateLoanSalaryDetail(id, loan);
			showConfirmMessageDialog("Succesfully rechanged", "Loan change");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateSalRisk(int id, double risk) {
		try {
			salDetail.updateRiskSalaryDetail(id, risk);
			showConfirmMessageDialog("Succesfully rechanged", "Risk change");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateSalOther(int id, double other) {
		try {
			salDetail.updateOtherSalaryDetail(id, other);
			showConfirmMessageDialog("Succesfully rechanged", "Other change");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	////////////////////Update Employee Method///////////////////////
	public void UpdateEmployee(int id, String fname, String lname, String email, String phone, String password) {
		int confirm;
		String changeMsg;
		Employee emp;
		
		emp= this.database.searchByUserId(id);
		changeMsg = "Are you sure you want to update below fields of the employee id :" + id + "\n\n";
		
		if( !( emp.getFirstName().equals(fname) ) ) {			
			changeMsg += "FirstName\n";
			emp.setFirstName(fname);
		}
		if( !( emp.getLastName().equals(lname) ) ) {			
			changeMsg += "LastName\n";
			emp.setLastName(lname);
		}
		if( !( emp.getEmail().equals(email) ) ) {			
			changeMsg += "Email\n";
			emp.setEmail(email);
		}
		if( !( emp.getPhoneNumber().equals(phone) ) ) {
			changeMsg += "PhoneNumber\n";
			emp.setPhoneNumber(phone);
		}
		if( !( emp.getPassword().equals(password) ) ) {
			changeMsg += "Password\n";
			emp.setPassword(password);
		}
		
		confirm =  showConfirmMessageDialog(changeMsg, "Confirm Required");
		
		if( confirm == 0 ) {			
			try {				
				e1.updateEmployee(emp);
				showPlainMessageDialog("Successfully Updated", "Insert");	
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				e.printStackTrace();
				System.out.println("!!!!!!");				
			}
		}	
	}
	////////////////////Update Employee Method///////////////////////
	
	public void UpdateMenuItem( int itemID, String name, double price, String type, String image) {
		
		int confirm;
		String changeMsg;
		Menu menu = null;
		
		menu = this.database.searchMenuItemById(itemID);
		changeMsg = "Are you sure you want to update below fields of the item id : " + itemID + "\n\n";
		
		if( !( menu.getItemName().equals(name) ) ) {			
			changeMsg += "Item Name : " + name;
			menu.setItemName(name);
			
		}
		if( !( menu.getItemPrice() == price ) ) {			
			changeMsg += "\nPrice : " + price;
			menu.setItemPrice(price);
		}
		if( !( menu.getType().equals(type) ) ) {			
			changeMsg += "\nType : " + type;
			menu.setType(type);		
		}
		changeMsg += "\nImage";
		
		confirm =  showConfirmMessageDialog(changeMsg, "Confirm Required");
		
		if( confirm == 0 ) {			
			try {				
				this.menuItem.updateMenu(menu, image);
				showPlainMessageDialog("Successfuly Updated", "Update");
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				System.out.println("!!!!!!");
				
			}
		}
	}
	
	public void UpdateMenuItem( int itemID, String name, double price, String type) {
		
		int confirm;
		String changeMsg;
		Menu menu = null;
		
		menu = this.database.searchMenuItemById(itemID);
		changeMsg = "Are you sure you want to update below fields of the item id :" + itemID + "\n\n";
		
		if( !( menu.getItemName().equals(name) ) ) {			
			changeMsg += "Item Name : " + name;
			menu.setItemName(name);
			
		}
		if( !( menu.getItemPrice() == price ) ) {			
			changeMsg += "\nPrice : " + price;
			menu.setItemPrice(price);
		}
		if( !( menu.getType().equals(type) ) ) {			
			changeMsg += "\nType : " + type;
			menu.setType(type);
		
		}
		
		confirm = showConfirmMessageDialog(changeMsg, "Confirm Required");
		
		if( confirm == 0 ) {			
			try {				
				this.menuItem.updateMenu(menu);
				showPlainMessageDialog("Successfuly Updated", "Update");
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				System.out.println("!!!!!!");
				
			}
		}
	}
	
	public void UpdateOrder( int orderID, String name, int staffID, double price, byte status) {
		
		int confirm;
		String changeMsg;
		Order od = null;
		
		od = this.database.searchOrderById(orderID);
		changeMsg = "Are you sure you want to change the status of the item id :" + orderID + "\n\n";		
		
		if( !( od.getOrderState() == status ) ) {	
			String orderstatus = null;
			if(status== Order.ORDER_ACTIVE ) {
				orderstatus = "Active";
			}else if( status ==  Order.ORDER_CLOSED ) {
				orderstatus = "Closed";
			}else if( status ==  Order.ORDER_CANCELED ) {
				orderstatus = "Cacelled";
			}
			changeMsg += "\nOrder Status :" + orderstatus;
			
			od.setOrderState(status);		
		}
		
		confirm = showConfirmMessageDialog(changeMsg, "Confirm Required");
		
		if( confirm == 0 ) {			
			try {				
				this.order.updateOrder(od);
				showMessageDialog("Successfuly Updated");
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				System.out.println("!!!!!!");
				
			}
		}
	}
	
	public void DeleteEmployee (int id) {
		int confirm;
		
		confirm =  showConfirmMessageDialog("Are you sure You want to delete Employee id : " + id, "Confirm Required");
		
		if( confirm == 0 ) {
			try {	
				e1.deleteEmployee(id);
				showMessageDialog("Successfully Deleted");		
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				e.printStackTrace();
				System.out.println("!!!!!!");				
			} 
		}	
	}
	
	public void DeleteMenuItem(int id) {
		int confirm;
		
		confirm = showConfirmMessageDialog("Are you sure You want to delete Menu Item id : " + id, "Confirm Required");
		
		if( confirm == 0 ) {
			try {
				menuItem.deleteMenu(id);
				showMessageDialog("Successfully Item Deleted");		
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				e.printStackTrace();
				System.out.println("!!!!!!");				
			} 
		}	
	}
	
	public void DeleteOrder (int id) {
		int confirm = 0;
		
		if(MngOrder.orderUpdate == false) {
			confirm = showConfirmMessageDialog("Are you sure You want to delete order id : " + id , "Confirm Required");
		}
		
		if( confirm == 0 ) {
			try {	
				order.deleteOrder(id);
				
				if(MngOrder.orderUpdate == false) {
					showMessageDialog("Successfully Order Deleted");
				}	
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				e.printStackTrace();
				System.out.println("!!!!!!");				
			} 
		}	
	}
	
	public void InsertEmployee (String fname, String lname, String email, String phone, String password, boolean isAdmin) {
		int id = 0;
		String type;
		int eid =  this.getNextEmployeeID();
		
		try {
			if( (this.database.searchByType("phone_number", phone).next() == true) || (this.database.searchByType("email", email).next() == true) ) {
				showWarningMessageDialog("User has already inserted", "Insert Error");			
			}
		
			else {					
				try {	
					if(isAdmin == true) {
						type = "admin";
						e1.insertEmployee(new Manager(id, fname, lname, email, phone, password),type);					
					}
					else {
						type = "staff";
						e1.insertEmployee(new StaffMember(id, fname, lname, email, phone, password),type);
					}	
					sal.insertSalary(eid, 0, 0.0,LocalDate.now().getMonthOfYear());
					salDetail.insertSalaryDetail(eid, 1500, 1000, 0.0, 0.0);
					showMessageDialog("Employee id : " + Integer.toString(eid));
					showPlainMessageDialog("User has succesfully inserted", "Insert Success");					
					
				}catch(Exception e) {
					System.err.println("Exception :" +e.getMessage());
					e.printStackTrace();
					System.out.println("!!!!!!");				
				} 		
			}	
		}catch(Exception e) {
			System.out.println("INSERT EXCEPTION");
		}
	}

	public void insertMenuItem( String name, double price, String type, String image ) {
		
		int itemId = 0;
		
		try {
			if(this.database.searchByTypeMenu("itemname", name).next() == true ) {
				showWarningMessageDialog("Menu Item has already inserted", "Insert Error");
			}else {				
				menuItem.insertMenu(new Menu( itemId, name, price, type), image);	
				this.showPlainMessageDialog("Successfuly Inserted", "Insert");
				this.myMainInterface.setMngMenuInsertId();
			}
		} catch (SQLException e) {			
			System.err.println("Exception :" +e.getMessage());
		}		
	}
	
	public void insertOrderDetail(ArrayList<String[]> orderDetail) {		
		OrderDetails ods;		
		try {		
			order.insertOrder(myOrder);
			
			for(String[] ob : orderDetail) {
				orderDetails.insertOrdrDetail( this.myOrder, new OrderDetails( new Menu(Integer.parseInt( ob[0].toString() )), Integer.parseInt( ob[2].toString() ) ) );				
			}			
			
			if(MngOrder.orderUpdate == false) {
				this.showPlainMessageDialog("Successfuly Inserted", "Insert");
			}
			else {
				this.showPlainMessageDialog("Successfuly Updated", "Insert");
			}
		} catch (SQLException e) {			
			System.err.println("Exception :" +e.getMessage());
	
		}		
	}	
	
	public ArrayList<String[]> getDetailsExistingOrder(int orderid) {
		ArrayList<String[]> det = new ArrayList<String[]>();
		
		try {
			det = orderDetails.getOrderDetailList(orderid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return det;
	}
	
	public void showPlainMessageDialog(String message, String title) {
		JOptionPane.showMessageDialog(myMainInterface, message, title, JOptionPane.PLAIN_MESSAGE);
	}
	
	public void showWarningMessageDialog(String message, String title) {
		JOptionPane.showMessageDialog(myMainInterface, message, title, JOptionPane.WARNING_MESSAGE);
	}
	
	public void showMessageDialog(String message) {
		JOptionPane.showMessageDialog(myMainInterface, message);
	}
	
	public int showConfirmMessageDialog(String message, String title) {
		return JOptionPane.showConfirmDialog(myMainInterface, message, title, JOptionPane.YES_NO_OPTION);
	}
}

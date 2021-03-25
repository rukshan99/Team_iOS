 package com.view.backend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.controller.Controller;
import com.view.frontend.Bill;
import com.view.frontend.Delivery;
import com.view.frontend.MngMenu;
import com.view.frontend.MngOrder;
import com.view.frontend.StaffMember_View;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;

public class MainUserInterface extends JFrame {	
	private final static int searchMenu = 1;
	private final static int insertMenu = 2;
	private final static int deleteMenu = 3;
	private final static int updateMenu = 4;
	
	private final static int searchOrder = 5;
	private final static int insertOrder = 6;
	private final static int deleteOrder = 7;
	private final static int updateOrder = 8;
	
	private final static int searchEmployee = 9;
	private final static int insertEmployee = 10;
	private final static int deleteEmployee = 11;
	private final static int updateEmployee = 12;
	
	private final static int advance = 13;
	private final static int loan = 14;
	private final static int risk = 15;
	private final static int other = 16;	
	
	private final static int orderTypeDineIn = 1;
	private final static int orderTypeTakeAway = 2;
	private final static int orderTypeDelivery = 3;
	
	private final static byte MODE_MANAGER = 1;
	private final static byte MODE_STAFF_MEMBER = 2;
	
	private Manager_View managerView;
	private StaffMember_View staffMemberView;
	private MngEmployee mngEmployee;
	private MngOrder mngOrder;
	private MngMenu mngMenu;
	private MngSalary mngSalary;
	private Controller myController;
	private Delivery delivery;
	private Bill myBill;
	
	private JPanel contentPane;
	private JPanel panel, user_view, manager_options,staffmember_options;
	private JLayeredPane userType;
	private JLayeredPane managerOpt;
	private JLayeredPane staffOpt;

	
	/**
	 * Create the frame.
	 */
	public MainUserInterface(Controller myController) {
		this.myController = myController;
		
		managerView = new Manager_View(this,this.myController);
		staffMemberView = new StaffMember_View(this, this.myController);			
		mngEmployee = new MngEmployee(this.myController,this);
		mngOrder = new MngOrder(this.myController,this);
		mngSalary = new MngSalary(this.myController,this);
		mngMenu = new MngMenu(this.myController,this);
		delivery = new Delivery(this.myController,this);
		delivery.setSize(1366, 768);
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds( 0, 0, 1366, 768);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		panel = new JPanel();
		panel.setBounds(0, 0, 1366, 768);
		contentPane.add(panel);
		panel.setLayout(null);		
		
		manager_options = new JPanel();
		manager_options.setBounds(0, 0, 1366, 768);
		contentPane.add(manager_options);
		manager_options.setLayout(null);
		
		managerOpt = new JLayeredPane();
		managerOpt.setBounds(0, 0,1366, 768);
		managerOpt.add(mngEmployee);
		managerOpt.add(mngSalary);
		managerOpt.add(mngMenu);
		manager_options.add(managerOpt);
		managerOpt.setLayout(new CardLayout(0, 0));
		
		staffmember_options = new JPanel();
		staffmember_options.setBounds(0, 0,1366, 768);
		contentPane.add(staffmember_options);
		staffmember_options.setLayout(null);
		
		staffOpt = new JLayeredPane();
		staffOpt.setBounds(0, 0,1366, 768);
		staffOpt.add(mngOrder);
		staffmember_options.add(staffOpt);
		staffOpt.setLayout(new CardLayout(0,0));
		
		user_view = new JPanel();
		user_view.setBounds(0, 0, 1366, 768);
		contentPane.add(user_view);
		user_view.setLayout(null);
		
		userType = new JLayeredPane();
		userType.setBounds(0, 0,1366, 768);
		userType.add(managerView);
		userType.add(staffMemberView);
		user_view.add(userType);
		userType.setLayout(new CardLayout(0, 0));
		
		contentPane.add(delivery);
	}
	
	public static int getInsertorder() {
		return insertOrder;
	}	

	public static int getSearchmenu() {
		return searchMenu;
	}

	public static int getInsertmenu() {
		return insertMenu;
	}

	public static int getDeletemenu() {
		return deleteMenu;
	}

	public static int getUpdatemenu() {
		return updateMenu;
	}

	public static int getSearchorder() {
		return searchOrder;
	}

	public static int getDeleteorder() {
		return deleteOrder;
	}

	public static int getUpdateorder() {
		return updateOrder;
	}

	public static int getSearchemployee() {
		return searchEmployee;
	}

	public static int getInsertemployee() {
		return insertEmployee;
	}

	public static int getDeleteemployee() {
		return deleteEmployee;
	}

	public static int getUpdateemployee() {
		return updateEmployee;
	}

	public static int getAdvance() {
		return advance;
	}

	public static int getLoan() {
		return loan;
	}

	public static int getRisk() {
		return risk;
	}

	public static int getOther() {
		return other;
	}

	public static int getOrdertypedinein() {
		return orderTypeDineIn;
	}

	public static int getOrdertypetakeaway() {
		return orderTypeTakeAway;
	}

	public static int getOrdertypedelivery() {
		return orderTypeDelivery;
	}

	public static byte getModeManager() {
		return MODE_MANAGER;
	}

	public static byte getModeStaffMember() {
		return MODE_STAFF_MEMBER;
	}
	
	public void setBounds(int length,int width) {
		setBounds( 0, 0, length, width);
	}

	public void changeUserView(byte mode) {
		if(mode == this.MODE_MANAGER) {
			managerView.setRestaurentName();
			managerView.setUserIdName();
			managerView.setDateTime();
			
			panel.setVisible(false);
			user_view.setVisible(true);
			managerView.setVisible(true);
			staffMemberView.setVisible(false);
			manager_options.setVisible(false);
			staffmember_options.setVisible(false);
			delivery.setVisible(false);
		}
		else {
			staffMemberView.setRestaurentName();
			staffMemberView.setUserIdName();
			staffMemberView.setDateTime();
			
			panel.setVisible(false);
			user_view.setVisible(true);
			managerView.setVisible(false);
			staffMemberView.setVisible(true);
			manager_options.setVisible(false);
			staffmember_options.setVisible(false);
			delivery.setVisible(false);
		}
	}
	
	public void changeManagerOptions(int option) {
		switch(option) {
			case searchEmployee :	setBounds(793, 729);
				setLocationRelativeTo(null);
				mngEmployee.showOption((byte)1);
				panel.setVisible(false);
				user_view.setVisible(false);
				manager_options.setVisible(true);
				mngEmployee.setVisible(true);
				mngMenu.setVisible(false);
				mngSalary.setVisible(false);								
				staffmember_options.setVisible(false);	
				mngOrder.setVisible(false);	
				delivery.setVisible(false);	
				
				break;
				
			case insertEmployee :	setBounds(687, 729);
				setLocationRelativeTo(null);
				mngEmployee.showOption((byte)2); 
				panel.setVisible(false);
				user_view.setVisible(false);
				manager_options.setVisible(true);
				mngEmployee.setVisible(true);
				mngMenu.setVisible(false);
				mngSalary.setVisible(false);								
				staffmember_options.setVisible(false);	
				mngOrder.setVisible(false);	
				delivery.setVisible(false);	
		
				break;	
			
			case deleteEmployee :	mngEmployee.showOption((byte)3); 
				panel.setVisible(false);
				user_view.setVisible(false);
				manager_options.setVisible(true);
				mngEmployee.setVisible(true);
				mngMenu.setVisible(false);
				mngSalary.setVisible(false);								
				staffmember_options.setVisible(false);	
				mngOrder.setVisible(false);	
				delivery.setVisible(false);	
		
				break;	
			
			case updateEmployee :	mngEmployee.showOption((byte)4); 
				panel.setVisible(false);
				user_view.setVisible(false);
				manager_options.setVisible(true);
				mngEmployee.setVisible(true);
				mngMenu.setVisible(false);
				mngSalary.setVisible(false);								
				staffmember_options.setVisible(false);	
				mngOrder.setVisible(false);	
				delivery.setVisible(false);	
				
				break;
			
			case searchMenu :	setBounds(716, 768);
				setLocationRelativeTo(null);
				mngMenu.showOption((byte)1);				
				panel.setVisible(false);
				user_view.setVisible(false);
				manager_options.setVisible(true);
				mngEmployee.setVisible(false);
				mngMenu.setVisible(true);
				mngSalary.setVisible(false);				
				staffmember_options.setVisible(false);	
				mngOrder.setVisible(false);					
				delivery.setVisible(false);	
			
				break;
			
			case insertMenu :	setBounds(890, 768);
				setLocationRelativeTo(null);
				mngMenu.showOption((byte)2); 
				panel.setVisible(false);
				user_view.setVisible(false);
				manager_options.setVisible(true);
				mngEmployee.setVisible(false);
				mngMenu.setVisible(true);
				mngSalary.setVisible(false);				
				staffmember_options.setVisible(false);	
				mngOrder.setVisible(false);	
				delivery.setVisible(false);	
			
				break;	
			
			case deleteMenu :	mngMenu.showOption((byte)3); 
				panel.setVisible(false);
				user_view.setVisible(false);
				manager_options.setVisible(true);
				mngEmployee.setVisible(false);
				mngMenu.setVisible(true);
				mngSalary.setVisible(false);				
				staffmember_options.setVisible(false);	
				mngOrder.setVisible(false);						
				delivery.setVisible(false);	
				
				break;	
		
			case updateMenu :	mngMenu.showOption((byte)4);
				panel.setVisible(false);
				user_view.setVisible(false);
				manager_options.setVisible(true);
				mngEmployee.setVisible(false);
				mngMenu.setVisible(true);
				mngSalary.setVisible(false);				
				staffmember_options.setVisible(false);	
				mngOrder.setVisible(false);	
				delivery.setVisible(false);	
		
				break;	
			
			case advance :	setBounds(799, 293);
				setLocationRelativeTo(null);
				mngSalary.showOption((byte)1); 
				panel.setVisible(false);
				user_view.setVisible(false);				
				manager_options.setVisible(true);
				mngEmployee.setVisible(false);
				mngMenu.setVisible(false);
				mngSalary.setVisible(true);			
				staffmember_options.setVisible(false);	
				mngOrder.setVisible(false);	
				delivery.setVisible(false);	
				
				break;
		
			case loan :	setBounds(799, 293);
				setLocationRelativeTo(null);
				mngSalary.showOption((byte)2); 
				panel.setVisible(false);
				user_view.setVisible(false);				
				manager_options.setVisible(true);
				mngEmployee.setVisible(false);
				mngMenu.setVisible(false);
				mngSalary.setVisible(true);			
				staffmember_options.setVisible(false);	
				mngOrder.setVisible(false);
				delivery.setVisible(false);	
				
				break;	
		
			case risk :	setBounds(799, 293);
				setLocationRelativeTo(null);
				mngSalary.showOption((byte)3); 
				panel.setVisible(false);
				user_view.setVisible(false);				
				manager_options.setVisible(true);
				mngEmployee.setVisible(false);
				mngMenu.setVisible(false);
				mngSalary.setVisible(true);			
				staffmember_options.setVisible(false);	
				mngOrder.setVisible(false);	
				delivery.setVisible(false);	
				
				break;	
		
			case other :	setBounds(799, 293);
				setLocationRelativeTo(null);
				mngSalary.showOption((byte)4);  
				panel.setVisible(false);
				user_view.setVisible(false);
				managerView.setVisible(true);
				staffMemberView.setVisible(false);
				manager_options.setVisible(true);
				mngEmployee.setVisible(false);
				mngMenu.setVisible(false);
				mngSalary.setVisible(true);			
				staffmember_options.setVisible(false);	
				mngOrder.setVisible(false);		
				delivery.setVisible(false);	
		
				break;		
		}		
	}
	
	public void changeStaffMemberOptions(int option) {
		
		switch(option) {
			case searchOrder: mngOrder.showOption((byte)1);  
				setBounds(716, 768);
				setLocationRelativeTo(null);
				panel.setVisible(false);
				user_view.setVisible(false);
				manager_options.setVisible(false);
				mngEmployee.setVisible(false);
				mngMenu.setVisible(false);
				mngSalary.setVisible(false);		
				staffmember_options.setVisible(true);	
				mngOrder.setVisible(true);	
				delivery.setVisible(false);	
				
				break;
		
			case insertOrder :	mngOrder.showOption((byte)2); 				
				panel.setVisible(false);
				user_view.setVisible(false);
				manager_options.setVisible(false);
				mngEmployee.setVisible(false);
				mngMenu.setVisible(false);
				mngSalary.setVisible(false);	
				staffmember_options.setVisible(true);	
				mngOrder.setVisible(true);	
				delivery.setVisible(false);	
				
				break;	
			
			case deleteOrder :	mngOrder.showOption((byte)3); 
				panel.setVisible(false);
				user_view.setVisible(false);
				manager_options.setVisible(false);
				mngEmployee.setVisible(false);
				mngMenu.setVisible(false);
				mngSalary.setVisible(false);	
				staffmember_options.setVisible(true);	
				mngOrder.setVisible(true);		
				delivery.setVisible(false);	
				
				break;	
				
			case updateOrder :	mngOrder.showOption((byte)4); 
				panel.setVisible(false);
				user_view.setVisible(false);
				manager_options.setVisible(false);
				mngEmployee.setVisible(false);
				mngMenu.setVisible(false);
				mngSalary.setVisible(false);	
				staffmember_options.setVisible(true);	
				mngOrder.setVisible(true);	
				delivery.setVisible(false);	
				
				break;
				
		}	
	}
	
	public void changeOrderType(int orderType) {
		switch(orderType) {
		
			case orderTypeDineIn :	this.refreshMenuListTable();
				this.changeStaffMemberOptions(this.insertOrder);
				this.myController.setOrderType(this.orderTypeDineIn);
				break;	
			
			case orderTypeTakeAway :	this.refreshMenuListTable();
				this.changeStaffMemberOptions(this.insertOrder);
				this.myController.setOrderType(this.orderTypeTakeAway);
				break;
		
			case orderTypeDelivery :	//setBounds(466, 526);
				//setLocationRelativeTo(null);										
				panel.setVisible(false);
				user_view.setVisible(false);
				manager_options.setVisible(false);
				mngEmployee.setVisible(false);
				mngMenu.setVisible(false);
				mngSalary.setVisible(false);	
				staffmember_options.setVisible(false);
				mngOrder.setVisible(false);	
				delivery.setVisible(true);
				delivery.OrderID();
				this.myController.setOrderType(this.orderTypeDelivery);
				break;			
		}		
	}
	
	public ArrayList<String[]> getOrderDetails() {
		return this.mngOrder.getOrderDetails();
	}
	
	public void refreshMenuListTable() {
		this.mngOrder.refreshMenuListTable_Insert();
	}
	
	public void setDeliveryTotal(Double total) {
		this.delivery.setTextFieldOrderPrice(total);
	}
	
	public void goBack() {
		setBounds(1366, 768);
		setLocationRelativeTo(null);
		this.changeUserView(this.myController.getUserType());
	}
	
	public void makeBill() {
		myBill = new Bill(this.myController,this);
		myBill.setVisible(true);		
	}
	
	public void setMngMenuInsertId() {
		this.mngMenu.setMngMenuInsertId();
	}
}	

package com.view.frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.controller.Controller;
import com.mysql.jdbc.Connection;
import com.view.PanelButtonMouseAdapter;
import com.view.backend.MainUserInterface;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*public class Delivery extends JPanel implements ActionListener{

	static boolean hasOrder = false;
	
	private JTextField textFieldname;
	private JTextField textFieldAddress;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JTextField textFieldOrderPrice;

	private JButton btnBackDelivery, btnConfirmOrder, btnAddOrder;
	
	private MainUserInterface myMainInterface;
	private Controller myController;

	private JLabel cvv_Validate;
	private JLabel namevalidation;
	private JLabel addressValidation;

	private JLabel lblNewLabel_6;
	/**
	 * Create the panel.
	
	public Delivery(Controller myController, MainUserInterface myMainInterface) {
		this.myController = myController;
		this.myMainInterface = myMainInterface;		
		
		setLayout(null);
		setVisible(true);
		setBounds(0, 0, 450, 526);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 450, 526);
		add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(-17, 0, 496, 526);
		panel_1.add(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		JLabel lblDeliveryDetails = new JLabel("Delivery Details");
		lblDeliveryDetails.setForeground(new Color(0, 0, 128));
		lblDeliveryDetails.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblDeliveryDetails.setBounds(29, 22, 161, 42);
		panel.add(lblDeliveryDetails);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Dialog", Font.BOLD, 17));
		lblName.setBounds(55, 113, 82, 31);
		panel.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 17));
		lblAddress.setBounds(55, 172, 82, 31);
		panel.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone ");
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPhone.setBounds(55, 227, 101, 31);
		panel.add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 17));
		lblEmail.setBounds(55, 287, 82, 31);
		panel.add(lblEmail);
		
		btnAddOrder = new JButton("Add Order");		
		btnAddOrder.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAddOrder.setBounds(55, 432, 108, 31);
		panel.add(btnAddOrder);
		btnAddOrder.addActionListener(this); 
		
		textFieldname = new JTextField();
		textFieldname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				namevalidation.setText("");
			}
		});
		textFieldname.setFont(new Font("Dialog", Font.PLAIN, 13));
		textFieldname.setBounds(185, 116, 243, 24);
		panel.add(textFieldname);
		textFieldname.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				addressValidation.setText("");
			}
		});
		textFieldAddress.setForeground(Color.BLACK);
		textFieldAddress.setFont(new Font("Dialog", Font.PLAIN, 13));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(185, 175, 243, 24);
		panel.add(textFieldAddress);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setForeground(Color.RED);
		textFieldPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				String i = textFieldPhone.getText();
				int length = i.length();
				
				char c = evt.getKeyChar();
				
				if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
					if(length < 10) {
						textFieldPhone.setEditable(true);
					}else {

						textFieldPhone.setEditable(false);
						textFieldPhone.setEnabled(true);

					}
			
				}else {
					if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
						textFieldPhone.setEditable(true);
						cvv_Validate.setText("Please enter only 10 digits");
					}else {
						cvv_Validate.setText("Enter valid telephone number");
						textFieldPhone.setEditable(true);
					}
				}
			}
		});
		textFieldPhone.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(185, 230, 243, 24);
		panel.add(textFieldPhone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Dialog", Font.PLAIN, 13));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(185, 290, 243, 24);
		panel.add(textFieldEmail);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPrice.setBounds(55, 354, 82, 31);
		panel.add(lblPrice);
		
		textFieldOrderPrice = new JTextField();
		textFieldOrderPrice.setBackground(Color.GRAY);
		textFieldOrderPrice.setEditable(false);
		textFieldOrderPrice.setFont(new Font("Dialog", Font.PLAIN, 13));
		textFieldOrderPrice.setColumns(10);
		textFieldOrderPrice.setBounds(185, 357, 139, 24);
		panel.add(textFieldOrderPrice);
		
		btnConfirmOrder = new JButton("Confirm Order");
	/*	btnConfirmOrder.addActionListener(new ActionListener() {​​​​

			 public void actionPerformed(ActionEvent e) {​​​​

		
		if(textFieldname.getText().trim().isEmpty() && textFieldAddress.getText().trim().isEmpty()) {​​​​
			 namevalidation.setText("--Please Enter User Name!--");

			 addressValidation.setText("--Please Enter Password!--");

			 }​​​​

			 else if(textFieldname.getText().trim().isEmpty()) {​​​​

				 namevalidation.setText("--Please Enter User Name!--");

			 }​​​​

			 else if(textFieldAddress.getText().trim().isEmpty()) {​​​​

				 addressValidation.setText("--Please Enter Password!--");

			 }​​​​

		
		}
		});
		btnConfirmOrder.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnConfirmOrder.addActionListener(this);
		btnConfirmOrder.setBounds(281, 432, 147, 31);
		panel.add(btnConfirmOrder);
		
		btnBackDelivery = new JButton("Go Back");
		btnBackDelivery.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBackDelivery.addActionListener(this);
		btnBackDelivery.setBounds(355, 27, 85, 31);
		panel.add(btnBackDelivery);
		
		cvv_Validate = new JLabel("");
		cvv_Validate.setBounds(185, 255, 243, 16);
		panel.add(cvv_Validate);
		
		namevalidation = new JLabel("");
		namevalidation.setBounds(185, 142, 243, 16);
		panel.add(namevalidation);
		
		addressValidation = new JLabel("");
		addressValidation.setBounds(185, 201, 243, 16);
		panel.add(addressValidation);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 450, 526);
		panel_1.add(lblNewLabel_6);
		
		ImageIcon icon = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Pictures\\2.jpg");
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(lblNewLabel_6.getWidth(), lblNewLabel_6.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledImgIcn = new ImageIcon(imgScale);
		lblNewLabel_6.setIcon(scaledImgIcn); 
	}	
	
	public void setTextFieldOrderPrice(Double total) {
		this.textFieldOrderPrice.setText(Double.toString(total));;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		

		if(e.getSource() == btnBackDelivery) {
			int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back!! Current order status cancelled", "Order Cancel", JOptionPane.YES_OPTION);
			
			if(confirm == 0) { 		
				
				this.textFieldname.setText(null);
				this.textFieldAddress.setText(null);
				this.textFieldPhone.setText(null);
				this.textFieldEmail.setText(null);
				this.textFieldOrderPrice.setText(null);
				
				hasOrder = false;
				myMainInterface.goBack();
			}	
		}		
		
		if(e.getSource() == btnAddOrder) {	
			if(hasOrder) {			
				myMainInterface.setBounds(1366, 768);
				myMainInterface.changeStaffMemberOptions(myMainInterface.getInsertorder());
			}	
			else {
				myMainInterface.refreshMenuListTable();
				myMainInterface.setBounds(1366, 768);
				myMainInterface.changeStaffMemberOptions(myMainInterface.getInsertorder());
				hasOrder = true;
			}
		}
		
		if(e.getSource() == btnConfirmOrder) {
			this.myController.insertOrderDetail(myMainInterface.getOrderDetails());
			this.myMainInterface.makeBill();
		}
	}
} */



import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class Delivery extends JPanel {

	static boolean hasOrder = false;
	private JPanel contentPane;
	private JLabel lblName;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delivery frame = new Delivery(myController, myMainInterface);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	private static final long serialVersionUID = 1L;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JLabel lblPrice;
	private JLabel lblCustomerDetails;
	private JTextField txtaddre;
	private JTextField txtphone;
	private JTextField txtemail;
	private JTextField txtprice;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtdphone;
	private JTextField txtcname;
	private JButton btnselect;
	private JButton btnview;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnBill;
	private JButton btnprint;
	private JLabel lblNewLabel_2;
	private JLabel lblOrderId;
	private JTextField txtoid;
	private JTextArea textarea;
	private JTextField txtremain;
	private JTextField txtdchar;
	private JTextField txttotal;
	private JLabel lblDeliveryChargers;
	private JLabel lblTotal;
	private JLabel lblreaminjob;
	private JButton btncal1;
	private JButton btncal2;
	private JLabel lblvalidate;
	private JButton btnConfirm;
	private static MainUserInterface myMainInterface;
	private static Controller myController;
	private JButton btnBackDelivery;
	private JLabel lblNewLabel_1;
	
	//Increment the order id automatically when delivery page is opened
	
	public void OrderID() {  
		
		System.out.println("Call");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management_system", "root", "");
		java.sql.Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("Select Max(id) from myorder"); //search the maximum order id
		rs.next();
		
		
		
		System.out.println("data corext");
		if(rs.last()) {
			
			int id = rs.getInt(1);//assign the current value for id variable
			id++;//increment the current order id
			txtoid.setText(Integer.toString(id));//display in the order id text field
		
		}
		else {
			
			txtoid.setText("1");//default value for the first order		
			
		}
	}
		catch (Exception e1){
			//e1.printStackTrace();
			
			
	}};


	/**
	 * Create the frame.
	 */
	
	
	
	public Delivery(Controller myController, MainUserInterface myMainInterface) { 
		this.myController = myController;
		this.myMainInterface = myMainInterface;		
		
		setBounds(0, 0,1366, 768);
		setLayout(null);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBounds(10, 10, 1366, 768);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		add(contentPane);
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delivery Details");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(559, 0, 240, 48);
		contentPane.add(lblNewLabel);
		
		lblName = new JLabel("Name :");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblName.setBounds(39, 167, 84, 25);
		contentPane.add(lblName);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAddress.setBounds(39, 209, 84, 25);
		contentPane.add(lblAddress);
		
		lblPhone = new JLabel("Phone :");
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPhone.setBounds(39, 249, 56, 25);
		contentPane.add(lblPhone);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmail.setBounds(39, 291, 101, 25);
		contentPane.add(lblEmail);
		
		lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPrice.setBounds(39, 363, 91, 25);
		contentPane.add(lblPrice);
		
		lblCustomerDetails = new JLabel(" Customer Details");
		lblCustomerDetails.setForeground(new Color(0, 0, 128));
		lblCustomerDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCustomerDetails.setBounds(38, 76, 187, 25);
		contentPane.add(lblCustomerDetails);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 100, 382, 16);
		contentPane.add(separator);
		
		JLabel lblDeliveryDetails = new JLabel("Delivery Person Details");
		lblDeliveryDetails.setForeground(new Color(0, 0, 128));
		lblDeliveryDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDeliveryDetails.setBounds(27, 516, 290, 25);
		contentPane.add(lblDeliveryDetails);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 542, 382, 16);
		contentPane.add(separator_1);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblId.setBounds(39, 568, 77, 25);
		contentPane.add(lblId);
		
		JLabel lblName_2 = new JLabel("Name :");
		lblName_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblName_2.setBounds(39, 613, 84, 25);
		contentPane.add(lblName_2);
		
		JLabel lblPhone_1 = new JLabel("Phone :");
		lblPhone_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPhone_1.setBounds(39, 655, 77, 25);
		contentPane.add(lblPhone_1);
		
		txtoid = new JTextField();
		txtoid.setEditable(false);
		txtoid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtcname.grabFocus();//move to the next text field when enter key is pressed
			}
		});
		txtoid.setColumns(10);
		txtoid.setBounds(151, 126, 240, 32);
		contentPane.add(txtoid);
		
		txtcname = new JTextField();
		txtcname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtaddre.grabFocus();//move to the next text field when enter key is pressed
				txtcname.setEditable(false);
			}
		});
		txtcname.setColumns(10);
		txtcname.setBounds(151, 165, 240, 32);
		contentPane.add(txtcname);
		
		txtaddre = new JTextField();
		txtaddre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtphone.grabFocus();//move to the next text field when enter key is pressed
			}
		});
		txtaddre.setColumns(10);
		txtaddre.setBounds(151, 207, 240, 32);
		contentPane.add(txtaddre);
		
		txtphone = new JTextField();
		txtphone.setForeground(Color.RED);
		txtphone.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				String phone1 = txtphone.getText();
				int length = phone1.length();
				char c = evt.getKeyChar();
				
				if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9') {//Only input numbers from 0 to 9
					if(length < 10) {//check the length of the number
						txtphone.setEditable(true);
					}else {
						txtphone.setEditable(false);
					}
				}else {
					if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {//set as editable using enter and delete keys
						txtphone.setEditable(true);
					}else {
						txtphone.setEditable(false);
						lblvalidate.setText("*Invalid Input,use only numbers");//Error message if number is entered incorrectly
					}
				}
				}
		});
		txtphone.setColumns(10);
		txtphone.setBounds(151, 247, 240, 32);
		contentPane.add(txtphone);
		
		txtemail = new JTextField();
		txtemail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtprice.grabFocus();
				
			}
		});
		txtemail.setColumns(10);
		txtemail.setBounds(151, 289, 240, 32);
		contentPane.add(txtemail);
		
		txtprice = new JTextField();
		txtprice.setEditable(false);
		txtprice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				txtdchar.grabFocus();
		
			}
		});
		txtprice.setColumns(10);
		txtprice.setBounds(183, 356, 208, 32);
		contentPane.add(txtprice);
		
		txtdchar = new JTextField();
		txtdchar.setEditable(false);
		txtdchar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		txtdchar.setColumns(10);
		txtdchar.setBounds(183, 410, 208, 32);
		contentPane.add(txtdchar);
		
		txttotal = new JTextField();
		txttotal.setEditable(false);
		txttotal.setColumns(10);
		txttotal.setBounds(183, 459, 208, 32);
		contentPane.add(txttotal);
		
		//delivery person's details
		txtid = new JTextField();
		txtid.setEditable(false);
		txtid.setColumns(10);
		txtid.setBounds(188, 566, 240, 32);
		contentPane.add(txtid);
		
		txtname = new JTextField();
		txtname.setEditable(false);
		txtname.setColumns(10);
		txtname.setBounds(188, 611, 240, 32);
		contentPane.add(txtname);
		
		txtdphone = new JTextField();
		txtdphone.setEditable(false);
		txtdphone.setColumns(10);
		txtdphone.setBounds(188, 653, 240, 32);
		contentPane.add(txtdphone);
		
		txtremain = new JTextField();
		txtremain.setEditable(false);
		txtremain.setText("NOT DONE");
		txtremain.setColumns(10);
		txtremain.setBounds(188, 695, 240, 32);
		contentPane.add(txtremain);
		
		
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBackground(Color.BLACK);
		btnConfirm.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.insertOrderDetail(myMainInterface.getOrderDetails());
			
		try {
			//load the MySQL JDBC driver    
			Class.forName("com.mysql.jdbc.Driver");
			 //Create connection to database     
			java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management_system", "root", "");
			//query to insert data to delivery order table
			PreparedStatement ps = con.prepareStatement("insert into deliveryorder(orderid,cname,caddress,cphone,cemail,price,dprice,total,did,dname) values(?,?,?,?,?,?,?,?,?,?);");
			//insert data to relevant table
			ps.setInt(1, Integer.parseInt(txtoid.getText()));
			ps.setString(2, txtcname.getText());
			ps.setString(3, txtaddre.getText());
			ps.setInt(4, Integer.parseInt( txtphone.getText())); 
			ps.setString(5, txtemail.getText()); 
			ps.setString(6, txtprice.getText()); 
			ps.setString(7, txtdchar.getText()); 
			ps.setString(8, txttotal.getText()); 
			ps.setString(9, txtid.getText()); 
			ps.setString(10, txtname.getText()); 
		
			
			int x= ps.executeUpdate();
			
			if(txtremain.getText().equals("NOT DONE")) {//Check whether job status is "NOT DONE"
				String sql2 = "select rjobs from emp_ass where did = '"+ txtid.getText()+"'"; //Check the delivery person to update the number of remaining jobs
				PreparedStatement pst2 = con.prepareStatement(sql2);
				ResultSet rs = pst2.executeQuery();
				int jobs = 0;
				
				while(rs.next()) {
					 jobs = rs.getInt("rjobs");
				} 
				
				int noOfJobs = jobs + 1;
				String sql3 = "update emp_ass set rjobs = " + noOfJobs +" where did = '"+ txtid.getText()+"'";//Increment the number of orders for the relevant delivery person
				PreparedStatement pst3 = con.prepareStatement(sql3);
				pst3.executeUpdate();
			}
			
			Component frame = null;
			if(x>0) {
				JOptionPane.showMessageDialog(frame, "You are succesfully insert data","Insert", 
						JOptionPane.INFORMATION_MESSAGE);
				
				}
				else {
					JOptionPane.showMessageDialog(frame, "Invalid data", "Warning",
							JOptionPane.ERROR_MESSAGE);
					
				}
		}
		
		catch(Exception e1) {
			System.out.println(e1);
		}
		}

	
		});
		btnConfirm.setBounds(552, 695, 127, 41);
		contentPane.add(btnConfirm);
		
		btnselect = new JButton("");
		Image icon1 = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Icons PNG\\tray.jpg").getImage().getScaledInstance(35, 30,Image.SCALE_SMOOTH);
		btnselect.setIcon(new ImageIcon(icon1));
		btnselect.setForeground(new Color(255, 255, 255));
		btnselect.setBackground(Color.BLACK);
		btnselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnselect) {//Retrieve the total price of the order to the delivery page from the menu	
					if(hasOrder) {			
						myMainInterface.setBounds(1366, 768);
						myMainInterface.changeStaffMemberOptions(myMainInterface.getInsertorder());
					}	
					else {
						myMainInterface.refreshMenuListTable();
						myMainInterface.setBounds(1366, 768);
						myMainInterface.changeStaffMemberOptions(myMainInterface.getInsertorder());
						hasOrder = true;
					}
				}
				
			}
		});
		btnselect.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnselect.setBounds(419, 347, 40, 35);
		contentPane.add(btnselect);
		
		btnBackDelivery = new JButton("Go Back");//Navigate to the main interface
		btnBackDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int confirm = JOptionPane.showConfirmDialog(myMainInterface, "Are you sure you want to go back!! Current order status cancelled",  "Order Cancel",JOptionPane.YES_OPTION);
				if(confirm == 0) { 		
					
				
					txtoid.setText(null);
					txtcname.setText(null);
					txtaddre.setText(null);
					txtphone.setText(null);
					txtemail.setText(null);
					txtprice.setText(null);
					txtdchar.setText(null);
					txttotal.setText(null);
					txtid.setText(null);
					txtdphone.setText(null);
					txtname.setText(null);
					textarea.setText(null);
;					hasOrder = false;
					myMainInterface.goBack();
				}	
				
			}
		});
		btnBackDelivery.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBackDelivery.setBounds(1221, 14, 114, 31);
		contentPane.add(btnBackDelivery);
		
		btnview = new JButton("");
		btnview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					////load the MySQL JDBC driver            
					Class.forName("com.mysql.jdbc.Driver");
					//Create connection to database     
					java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management_system", "root", "");
						//Ordering the employees with least number of remaining jobs
						PreparedStatement ps = con.prepareStatement("select * from emp_ass  order By rjobs;");
						ResultSet rs = ps.executeQuery();//execute 
						//retrieve data to the delivery persons' detail table
						DefaultTableModel tm = (DefaultTableModel)table.getModel();
						tm.setRowCount(0);
						
						while(rs.next()) {
							Object o[]= {rs.getString("did"),rs.getString("dname"),rs.getString("dphone"),rs.getString("rjobs")};
				
							tm.addRow(o);
							table.setEnabled(true);
				
							}
						
						
					}
						catch(Exception e2) {
							
						}
			}
		});
		Image icon2 = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Icons PNG\\per.png").getImage().getScaledInstance(35, 30,Image.SCALE_SMOOTH);//adding image to the interface
		btnview.setIcon(new ImageIcon(icon2));
		btnview.setForeground(new Color(0, 0, 0));
		btnview.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnview.setBackground(new Color(255, 255, 255));
		btnview.setBounds(951, 110, 56, 48);
		contentPane.add(btnview);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(458, 100, 452, 122);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(250, 250, 210));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null,null},//adding rows to delivery person detail table
				{null, null, null,null},
				{null, null, null,null},
				{null, null, null,null},
				{null, null, null,null},
				{null, null, null,null},
				
			},
			new String[] {
				"ID", "Name", "Phone","Remaining Jobs"  }));
		
	table.addMouseListener((MouseListener) new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) { 
				
			int srow = table.getSelectedRow();
			DefaultTableModel mod = (DefaultTableModel) table.getModel(); 
			txtid.setText(mod.getValueAt(srow, 0).toString()); //add data from the delivery persons' table to the relevant field 
			txtname.setText(mod.getValueAt(srow, 1).toString());
			txtdphone.setText(mod.getValueAt(srow, 2).toString());
		

			table.setEnabled(false); //put the table to the disable mode
			txtid.setEditable(false);  
			txtname.setEditable(false);
			txtdphone.setEditable(false);
			txtremain.setEditable(false);
			}
	});
			
		scrollPane.setViewportView(table);
		
		lblNewLabel_2 = new JLabel("Billing Details");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(1051, 220, 176, 24);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(815, 251, 404, 427);
		contentPane.add(scrollPane_1);
		
		textarea = new JTextArea();
		textarea.setBackground(Color.BLACK);
		textarea.setForeground(Color.WHITE);
		textarea.setBounds(815, 251, 323, 427);
		scrollPane_1.setViewportView(textarea);
		
		
		//display the bill using text area
		btnBill = new JButton("Bill");
		btnBill.setBackground(new Color(0, 0, 0));
		btnBill.setForeground(new Color(255, 255, 255));
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x;
				int length = myController.getRestaurentName().length();	
				String[] address = myController.getRestaurentAddress();
				ArrayList<String[]> details = myMainInterface.getOrderDetails();
				
				Date d = new Date();
				SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");//print the current system date and time
				String date = s.format(d);
				
				for(x = 0; x < (62 - length); x++) {
					textarea.setText(textarea.getText() + " ");
				}
				
								
				textarea.setText(textarea.getText()+  myController.getRestaurentName().toUpperCase() + "\n\n");
				textarea.setText(textarea.getText()+"  " + address[0].toUpperCase() + ", " + address[1].toUpperCase()  + ", " +  address[2].toUpperCase() + " \n");
				textarea.setText(textarea.getText()+"  Tel : " + myController.getRestaurentPhone() + " "
						+ "                                                          " + "Date : "  + date + "\n");				
				textarea.setText(textarea.getText()+"                                                 Delivery Invoice                           \n ");
				textarea.setText(textarea.getText()+"--------------------------------------------------------------------------------------------------------\n");
				textarea.setText(textarea.getText()+"  Order ID : " +txtoid.getText()+"\n");
				textarea.setText(textarea.getText()+"--------------------------------------------------------------------------------------------------------\t");
				textarea.setText(textarea.getText()+"\n");
				textarea.setText(textarea.getText()+"  Customer Name : "+txtname.getText()+"\n");
				textarea.setText(textarea.getText()+"  Customer Address : "+txtaddre.getText()+"\n");
				textarea.setText(textarea.getText()+"  Customer PhoneNo : "+txtphone.getText()+"\n");
				textarea.setText(textarea.getText()+"  Customer Email : "+txtemail.getText()+"\n");
				textarea.setText(textarea.getText()+"--------------------------------------------------------------------------------------------------------\n");
				textarea.setText(textarea.getText()+"  Delivery Person :"+txtname.getText()+"\n");
				textarea.setText(textarea.getText()+"  Delivery Person's PhoneNo :"+txtdphone.getText()+"\n");
				textarea.setText(textarea.getText()+"--------------------------------------------------------------------------------------------------------\n");
				x = 0;
				for(String[] det : details) {
				
					textarea.setText(textarea.getText() + "  " + (++x) + "   " + det[1].toString() + "\n\t\t\t( " + det[2].toString() + " * " +
																	det[3].toString() + " )     " + det[4].toString() + "\n");
				
				
				}	
				textarea.setText(textarea.getText()+"--------------------------------------------------------------------------------------------------------\n");
				textarea.setText(textarea.getText()+"  Order Chargers  : Rs."+txtprice.getText()+"\n");
				textarea.setText(textarea.getText()+"  Delivery Chargers  : Rs."+txtprice.getText()+"\n");
				textarea.setText(textarea.getText()+"  Total Amount  : Rs."+txttotal.getText()+"\n");
				textarea.setText(textarea.getText()+"--------------------------------------------------------------------------------------------------------\n");
				textarea.setText(textarea.getText()+"\n");
				textarea.setText(textarea.getText()+"                                                   THANK YOU !                           \n ");
				
				
				
			}
		});
		btnBill.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBill.setBounds(1108, 684, 69, 51);
		contentPane.add(btnBill);
		
		btnprint = new JButton("");
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					textarea.setForeground(Color.BLACK);
					textarea.print(); //print the bill
					textarea.setText(null);
				}catch(Exception ex){
						}
					
	
			
			}
		});
		Image icon3 = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Icons PNG\\print.png").getImage().getScaledInstance(35, 30,Image.SCALE_SMOOTH);
		btnprint.setIcon(new ImageIcon(icon3));
		btnprint.setForeground(new Color(0, 0, 0));
		btnprint.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnprint.setBackground(new Color(0, 0, 0));
		btnprint.setBounds(1221, 684, 64, 51);
		contentPane.add(btnprint);
		
	
		lblOrderId = new JLabel("Order ID :");
		lblOrderId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblOrderId.setBounds(39, 126, 84, 25);
		contentPane.add(lblOrderId);
		
		
		lblreaminjob = new JLabel("Job Status :");
		lblreaminjob.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblreaminjob.setBounds(38, 697, 114, 25);
		contentPane.add(lblreaminjob);
		
		lblDeliveryChargers = new JLabel("Delivery Chargers :");
		lblDeliveryChargers.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDeliveryChargers.setBounds(39, 412, 139, 25);
		contentPane.add(lblDeliveryChargers);
		
		lblTotal = new JLabel("Total :");
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTotal.setBounds(41, 461, 132, 25);
		contentPane.add(lblTotal);
		
		btncal1 = new JButton("");
		Image icon4 = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Icons PNG\\cal.png").getImage().getScaledInstance(35, 30,Image.SCALE_SMOOTH);
		btncal1.setIcon(new ImageIcon(icon4));
		btncal1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double d = Double.parseDouble(txtprice.getText());
					double d2 = (d*0.1); //calculate the discount
			
					txtdchar.setText(d2+"0");//get the value for two decimal places
					btncal2.setEnabled(true);

					
					}catch (Exception e2) {
					
						}
			}
		});
		btncal1.setForeground(Color.WHITE);
		btncal1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btncal1.setBackground(Color.BLACK);
		btncal1.setBounds(419, 401, 40, 35);
		contentPane.add(btncal1);
		
		btncal2 = new JButton("");
		btncal2.setEnabled(false);
		Image icon5 = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Icons PNG\\cal.png").getImage().getScaledInstance(35, 30,Image.SCALE_SMOOTH);
		btncal2.setIcon(new ImageIcon(icon4));
		btncal2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {       
					double d = Double.parseDouble(txtprice.getText());
					double d1 = Double.parseDouble(txtdchar.getText());
					double d2 = (d+d1);
					txttotal.setText(d2+"0"); //calculate the total
					btnConfirm.setEnabled(true);//confirm button will be enabled after the total is calculated
					
					}catch (Exception e2) {
					
						}
			}
		});
		btncal2.setForeground(Color.WHITE);
		btncal2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btncal2.setBackground(Color.BLACK);
		btncal2.setBounds(419, 459, 40, 35);
		contentPane.add(btncal2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(27, 336, 382, 16);
		contentPane.add(separator_2);
		
		lblvalidate = new JLabel("* Enter 10 numbers only");
		lblvalidate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblvalidate.setForeground(Color.RED);
		lblvalidate.setBounds(434, 266, 196, 22);
		contentPane.add(lblvalidate);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Image icon6 = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Pictures\\stock2.jpg").getImage().getScaledInstance(462, 665,Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(icon6));
		lblNewLabel_1.setBounds(920, 209, 391, 568);
		contentPane.add(lblNewLabel_1);
		
		
	}
		
		
		
	public void setTextFieldOrderPrice(Double total) {
		this.txtprice.setText(Double.toString(total));;
	}	
}

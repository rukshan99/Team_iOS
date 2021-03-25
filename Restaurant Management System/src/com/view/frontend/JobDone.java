package com.view.frontend;


import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.controller.Controller;
import com.view.backend.MainUserInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class JobDone extends JFrame {
	static boolean hasOrder = false;

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JTextField txtsearch;
	private JTextField txtorderid;
	private JTextField txtcname;
	private JTextField txtxdid;
	private JTextField txtdststus;
	private JButton btnsearch;
	private JButton btnview;
	private JTextField txtdname;
	private JButton btnupdate;
	private JButton btnBackDelivery;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JobDone frame = new JobDone(myMainInterface,myController);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	private static MainUserInterface myMainInterface;
	private static Controller myController;
	/**
	 * Create the frame.
	 */
	
	public JobDone(MainUserInterface myMainInterface, Controller myController) {
		this.myController = myController;
		this.myMainInterface = myMainInterface;		
	
		setBackground(Color.WHITE);
		setTitle("Delivery Review");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds( 80, 30, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 287, 798, 45);
		contentPane.add(scrollPane);
		
		btnview = new JButton("");
		btnview.setBackground(new Color(255, 255, 255));
		Image icon2 = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Icons PNG\\per.png").getImage().getScaledInstance(35, 30,Image.SCALE_SMOOTH);
		btnview.setIcon(new ImageIcon(icon2));
		btnview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
					try {
						//load the MySQL JDBC driver    
						Class.forName("com.mysql.jdbc.Driver");
						 //Create connection to database     
						java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management_system", "root", "");
						//retrieve data from employee assign table
							PreparedStatement ps = con.prepareStatement("select * from emp_ass ");
							ResultSet rs = ps.executeQuery();
							DefaultTableModel tm = (DefaultTableModel)table_1.getModel();
							tm.setRowCount(0);
							
							while(rs.next()) {
								Object o[]= {rs.getString("did"),rs.getString("dname"),rs.getString("dphone"),rs.getString("rjobs")};
					
								tm.addRow(o);
								table_1.setEnabled(true);
					
								}
							
							
						}
							catch(Exception e2) {
								
							}
				}
			
		});
		btnview.setBounds(831, 460, 56, 42);
		contentPane.add(btnview);
		//display employee details in a table
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 15));
		table.setBackground(new Color(238, 232, 170));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
		
			},
			new String[] {
				"Order ID", "Customer Name", "DID", "Delivery Person", "Status"}));
		table.addMouseListener((MouseListener) new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) { 
				
			int srow = table.getSelectedRow();
			DefaultTableModel mod = (DefaultTableModel) table.getModel();
			txtorderid.setText(mod.getValueAt(srow, 0).toString()); //add data to the job detail section from selected row
			txtcname.setText(mod.getValueAt(srow, 1).toString());
			txtxdid.setText(mod.getValueAt(srow, 2).toString());
			txtdname.setText(mod.getValueAt(srow, 3).toString());

			table.setEnabled(false);
			
			}
	});
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 459, 798, 110);
		contentPane.add(scrollPane_1);
		
		txtsearch = new JTextField();
		txtsearch.setBounds(43, 159, 162, 29);
		contentPane.add(txtsearch);
		txtsearch.setColumns(10);
		
		btnsearch = new JButton("");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//load the MySQL JDBC driver      
					Class.forName("com.mysql.jdbc.Driver");
					 //Create connection to database     
					java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management_system", "root", "");
					PreparedStatement ps = con.prepareStatement("select * from deliveryorder where orderid = '"+txtsearch.getText()+"'and dstatus=  '" + "NOT DONE" +"'");// this is chose content according to the NIC number. and it display in table
					//retrieve data of the record which match with the order id where job status is not done
					ResultSet rs = (ResultSet) ps.executeQuery();
					DefaultTableModel tm = (DefaultTableModel)table.getModel();
					tm.setRowCount(0);
					
					while(rs.next()) {
						Object o[]= {rs.getInt("orderid"),rs.getString("cname"),rs.getString("did"),rs.getString("dname"),rs.getString("dstatus")};
						tm.addRow(o); // table content
						table.setEnabled(true);
					}
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Enter Valid OrderID!");
					
				}
			}
			

		});
		btnsearch.setBackground(new Color(255, 255, 255));
		Image icon3 = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Icons PNG\\search.png").getImage().getScaledInstance(35, 30,Image.SCALE_SMOOTH);
		btnsearch.setIcon(new ImageIcon(icon2));
		btnsearch.setBounds(242, 142, 52, 46);
		contentPane.add(btnsearch);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(238, 232, 170));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Phone", "Remaining Jobs"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
	
		
		JLabel lblNewLabel = new JLabel("Order ID :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(939, 236, 101, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblName.setBounds(939, 288, 101, 20);
		contentPane.add(lblName);
		
		JLabel lblDId = new JLabel("D ID :");
		lblDId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDId.setBounds(939, 341, 101, 20);
		contentPane.add(lblDId);
		
		JLabel lblDeliveryPerson = new JLabel("Delivery Person :");
		lblDeliveryPerson.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDeliveryPerson.setBounds(939, 398, 144, 20);
		contentPane.add(lblDeliveryPerson);
		
		JLabel lblNewLabel_4 = new JLabel("Delivery Status :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setBounds(939, 460, 144, 20);
		contentPane.add(lblNewLabel_4);
		
		txtorderid = new JTextField();
		txtorderid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtorderid.setEditable(false);
		txtorderid.setColumns(10);
		txtorderid.setBounds(1095, 234, 190, 29);
		contentPane.add(txtorderid);
		
		txtcname = new JTextField();
		txtcname.setEditable(false);
		txtcname.setColumns(10);
		txtcname.setBounds(1095, 286, 190, 29);
		contentPane.add(txtcname);
		
		txtxdid = new JTextField();
		txtxdid.setEditable(false);
		txtxdid.setColumns(10);
		txtxdid.setBounds(1095, 339, 190, 29);
		contentPane.add(txtxdid);
		
		txtdname = new JTextField();
		txtdname.setEditable(false);
		txtdname.setColumns(10);
		txtdname.setBounds(1095, 396, 190, 29);
		contentPane.add(txtdname);
		
		txtdststus = new JTextField();
		txtdststus.setEditable(false);
		txtdststus.setText("DONE");
		txtdststus.setColumns(10);
		txtdststus.setBounds(1095, 458, 190, 29);
		contentPane.add(txtdststus);
		
		btnupdate = new JButton("Update");
		btnupdate.setBackground(Color.BLACK);
		btnupdate.setForeground(Color.WHITE);
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management_system", "root", "");
					
				if(txtdststus.getText().equals("DONE")) {
					String sql2 = "select rjobs from emp_ass where did = '"+ txtxdid.getText()+"'";
					PreparedStatement pst2 = con.prepareStatement(sql2);
					ResultSet rs = pst2.executeQuery();
					int jobs = 0;
					
					while(rs.next()) {
						 jobs = rs.getInt("rjobs");
					} 
					
					int noOfJobs = jobs - 1;//reduce the number of remaining job is updated
					String sql3 = "update emp_ass set rjobs = " + noOfJobs +" where did = '"+ txtxdid.getText()+"'";
					PreparedStatement pst3 = con.prepareStatement(sql3);
					pst3.executeUpdate();
	

				String sql1 = "update deliveryorder "+
							"set dstatus = replace(dstatus, 'NOT DONE', 'DONE')"
							+ "where orderid = '"+ txtorderid.getText() +"'";
					PreparedStatement pst1 = con.prepareStatement(sql1);
					pst1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Status Updated Succesfully!");
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Record Addition Faild");
				}
				
			}
			catch(Exception e1) {
				System.out.println(e1);
			}
			}
		});
		btnupdate.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnupdate.setBounds(1089, 534, 136, 45);
		contentPane.add(btnupdate);
		
		JLabel lblNewLabel_1 = new JLabel("Delivery Review");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel_1.setBounds(539, 29, 247, 53);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Job Done Details");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(1015, 145, 153, 53);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Remaining Delivery ");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(39, 414, 445, 35);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 443, 385, 8);
		contentPane.add(separator);
		
		JLabel lblOderId = new JLabel("Order ID ");
		lblOderId.setForeground(new Color(0, 0, 128));
		lblOderId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblOderId.setBounds(74, 133, 106, 20);
		contentPane.add(lblOderId);
		
		JLabel lblNewLabel_2_1 = new JLabel("Completed Deliveries");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(28, 229, 445, 35);
		contentPane.add(lblNewLabel_2_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(23, 260, 385, 17);
		contentPane.add(separator_1);
		
		btnBackDelivery = new JButton("Go To Home");
		btnBackDelivery.setBackground(Color.BLACK);
		btnBackDelivery.setForeground(Color.WHITE);
		btnBackDelivery.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent arg0) {
				
				int confirm = JOptionPane.showConfirmDialog((Component) myMainInterface, "Are you sure you want to go Home Page!","Go Back", JOptionPane.YES_OPTION);
				if(confirm == 0) { 	
					
					txtorderid.setText(null);
					txtxdid.setText(null);
					txtcname.setText(null);
;					txtdname.setText(null);					
					exitInter();
				}	
				
			}
		});
		btnBackDelivery.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBackDelivery.setBounds(1089, 603, 136, 41);
		contentPane.add(btnBackDelivery);
		
		
	}
	
	public void exitInter() {
		this.setVisible(false);		
		myMainInterface.setVisible(true);
	}
}

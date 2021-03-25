package com.view.frontend;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.controller.Controller;
import com.utill.DBUtill;
import com.view.backend.MainUserInterface;

import java.awt.SystemColor;
import javax.swing.SwingConstants;
//import com.mysql.jdbc.ResultSet;
//import com.utill.DBUtill;

public class StockView extends JFrame {

	
	static boolean hasOrder = false;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockView frame = new StockView(myMainInterface,myController);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	private JTable table1;
	private JScrollPane scrollPane1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblItemDetails;
	private JTextField txtId;
	private JTextField txtDescri;
	private JTextField txtQue;
	private JTextField txtValue;
	private JTextField txtDis;
	private JTextField txtTota;
	private JButton btnview;
	private JButton btnUpdate;
	private JButton btnEdit_1;
	private JButton btnadd;
	private JButton btnDelete;
	private JButton btnEdit;
	private JLabel lblNewLabel_8;
	private JButton btnBackDelivery;
		
	
	public void ItemID() {  
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management_system", "root", "");
		java.sql.Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("Select Max(ID) from stock ");
		rs.next();
		
		rs.getString("Max(ID)");
		
		if(rs.getString("Max(ID)") == null) {
			txtId.setText("IC0001");
		}
		else {
			Long i = Long.parseLong(rs.getString("Max(ID)").substring(2,rs.getString("Max(ID)").length()));
			i++;
			txtId.setText("IC0" + String.format("%03d", i));
		}
	}
		catch (Exception e1){
			
	}};
	
	private static MainUserInterface myMainInterface;
	private static Controller myController;
	/**
	 * Create the frame.
	 */
	public StockView(MainUserInterface myMainInterface, Controller myController) {
		this.myController = myController;
		this.myMainInterface = myMainInterface;	
	
		setLocationRelativeTo(null);
		setBackground(new Color(192, 192, 192));
		setAutoRequestFocus(false);
		setTitle("Stock view");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366,768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnview = new JButton("View");
		btnview.setForeground(Color.WHITE);
		btnview.setBackground(Color.BLACK);
		btnview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management_system", "root", "");
						PreparedStatement ps = con.prepareStatement("select * from stock");
						ResultSet rs = ps.executeQuery();
						DefaultTableModel tm = (DefaultTableModel)table1.getModel();
						tm.setRowCount(0);
						
						while(rs.next()) {
							Object o[]= {rs.getString("ID"),rs.getString("description"),rs.getString("qty"),rs.getString("value"),rs.getString("discount"),rs.getString("total")};
							tm.addRow(o);
							
							
						
							}
						
						
					}
						catch(Exception e2) {
							
						}
					}
		});
		btnview.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnview.setBounds(101, 514, 122, 42);
		contentPane.add(btnview);		
		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(56, 124, 841, 280);
		contentPane.add(scrollPane1);
		
		table1 = new JTable();
		table1.setBackground(SystemColor.info);
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },
				{null, null,null, null, null,null },

	

			},
			new String[] {
					
					"ID","Description","Quentity","Value","Discount","Total"			} ));
		
			table1.addMouseListener((MouseListener) new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) { 
				
			int srow = table1.getSelectedRow();
			DefaultTableModel mod = (DefaultTableModel) table1.getModel();
			txtId.setText(mod.getValueAt(srow, 0).toString());
			txtDescri.setText(mod.getValueAt(srow, 1).toString());
			txtQue.setText(mod.getValueAt(srow, 2).toString());
			txtValue.setText(mod.getValueAt(srow, 3).toString());
			txtDis.setText(mod.getValueAt(srow, 4).toString());
			txtTota.setText(mod.getValueAt(srow, 5).toString());


		
			txtId.setEditable(false);
			txtDescri.setEditable(false);
			txtQue.setEditable(false);
			txtDis.setEditable(false);
			txtValue.setEditable(false);
			txtTota.setEditable(false);
			btnadd.setEnabled(false);
		
			
				}
			});
		
		scrollPane1.setViewportView(table1);
		
		JLabel lblNewLabel = new JLabel("Stock View");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setBounds(471, 22, 303, 42);
		contentPane.add(lblNewLabel);
	
		lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 19));
		lblNewLabel_1.setBounds(977, 222, 129, 22);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 19));
		lblNewLabel_2.setBounds(961, 273, 145, 22);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Quentity");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 19));
		lblNewLabel_3.setBounds(975, 327, 114, 22);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Value");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 19));
		lblNewLabel_4.setBounds(975, 377, 98, 22);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Discount");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 19));
		lblNewLabel_5.setBounds(975, 433, 98, 22);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Total");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 19));
		lblNewLabel_6.setBounds(975, 484, 98, 22);
		contentPane.add(lblNewLabel_6);
		
		lblItemDetails = new JLabel("Item Details");
		lblItemDetails.setBackground(new Color(255, 160, 122));
		lblItemDetails.setForeground(Color.WHITE);
		lblItemDetails.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblItemDetails.setBounds(1081, 115, 177, 42);
		contentPane.add(lblItemDetails);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDescri.grabFocus();
			}
		});
		txtId.setBounds(1107, 219, 215, 30);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtDescri = new JTextField();
		txtDescri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtQue.grabFocus();
			}
		});
		txtDescri.setColumns(10);
		txtDescri.setBounds(1107, 270, 215, 30);
		contentPane.add(txtDescri);
		
		txtQue = new JTextField();
		txtQue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtValue.grabFocus();
			}
		});
		txtQue.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txtQue.setEditable(true);
				String i = txtQue.getText();

				if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'||(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)) {
			
				}else {

					txtQue.setEditable(false);
					evt.consume();
						
				}
				
			}
		});
		txtQue.setColumns(10);
		txtQue.setBounds(1107, 324, 215, 30);
		contentPane.add(txtQue);
		
		txtValue = new JTextField();
		txtValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDescri.grabFocus();
			}
		});
		txtValue.setColumns(10);
		txtValue.setBounds(1107, 374, 215, 30);
		contentPane.add(txtValue);
		txtValue.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txtValue.setEditable(true);
				String i = txtValue.getText();

				if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'||(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)) {
			
				}else {

					txtValue.setEditable(false);
					evt.consume();
						
				}
				
			}
		});
		
		txtDis = new JTextField();
		
		txtDis.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int i = Integer.parseInt(txtQue.getText());
				double d = Double.parseDouble(txtValue.getText());
				double d1 = Double.parseDouble(txtDis.getText());
				
				double d2 = i * d;
				
				double d3 = d2 * (d1 / 100);
				
				double d4 = d2 - d3;
				txtTota.setText(d4+"0");
			}
			
		});
		txtDis.setColumns(10);
		txtDis.setBounds(1107, 430, 215, 30);
		contentPane.add(txtDis);
		
		txtTota = new JTextField();
		txtTota.setEditable(false);
		txtTota.setColumns(10);
		txtTota.setBounds(1107, 481, 215, 30);
		contentPane.add(txtTota);
		
		btnadd = new JButton("Add");
		btnadd.setForeground(Color.WHITE);
		btnadd.setBackground(Color.BLACK);
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	try {
					
					DBUtill.insertStock("insert into stock values('"+txtId.getText()+"','"+txtDescri.getText()+"','"+txtQue.getText()+"','"+txtValue.getText()+"','"+txtDis.getText()+"','"+txtTota .getText()+"')");
					
					JOptionPane.showMessageDialog(null, "Add Data Successfully !!!");
					
					txtId.setText(null);
					txtDescri.setText(null);
					txtQue.setText(null);
					txtValue.setText(null);
					txtDis.setText(null);
					txtTota.setText(null);
					txtId.grabFocus();
					
					dispose();
					StockView cus = new StockView(myMainInterface,myController);
					cus.setVisible(true);//
				
					
				} catch (Exception e2) {
					e2.printStackTrace();
				
			}}
		});
		btnadd.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnadd.setBounds(286, 514, 122, 42);
		contentPane.add(btnadd);
		
		 btnUpdate = new JButton("Update");
		 btnUpdate.setForeground(Color.WHITE);
		 btnUpdate.setBackground(Color.BLACK);
		btnUpdate.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					try {
						DBUtill.updateStock("update stock set ID = '"+txtId.getText()+"',description = '"+txtDescri.getText()+"',qty = '"+txtQue.getText()+"',value = '"+txtValue.getText()+"',discount = '"+txtDis.getText()+"',total = '"+txtTota.getText()+"' where ID = '"+txtId.getText()+"'");
						JOptionPane.showMessageDialog(null, "Update Data Successfully !!!");
						
						txtId.setText(null);
						txtDescri.setText(null);
						txtQue.setText(null);
						txtValue.setText(null);
						txtDis.setText(null);
						txtTota.setText(null);
						txtId.grabFocus();
						
						dispose();
						StockView cus = new StockView(myMainInterface,myController);
						cus.setVisible(true);//
					
						
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnUpdate.setBounds(472, 514, 122, 42);
		contentPane.add(btnUpdate);
		
		 btnDelete = new JButton("Delete");
		 btnDelete.setForeground(Color.WHITE);
		 btnDelete.setBackground(Color.BLACK);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
						DBUtill.deleteStock("delete from stock where ID = '"+txtId.getText()+"'");
						
						JOptionPane.showMessageDialog(null, "Remove Data Successfully !!!");
						
						dispose();
						StockView cus = new StockView(myMainInterface,myController);
						cus.setVisible(true);//
					
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnDelete.setBounds(652, 514, 122, 42);
		contentPane.add(btnDelete);
		
		 btnEdit = new JButton("Edit");
		btnEdit.setForeground(new Color(255, 255, 255));
		btnEdit.setBackground(new Color(0, 0, 0));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtId.setEditable(true);
				txtDescri.setEditable(true);
				txtQue.setEditable(true);
				txtDis.setEditable(true);
				txtValue.setEditable(true);
				txtTota.setEditable(false);
				txtId.grabFocus();
			
			}
		});
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnEdit.setBounds(1200, 555, 122, 42);
		contentPane.add(btnEdit);
		
		btnEdit_1 = new JButton("Reset");
		btnEdit_1.setBackground(new Color(0, 0, 0));
		btnEdit_1.setForeground(new Color(255, 255, 255));
		btnEdit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtId.setText(null);
				txtDescri.setText(null);
				txtQue.setText(null);
				txtValue.setText(null);
				txtDis.setText(null);
				txtTota.setText(null);
				txtId.grabFocus();
				
				

			}
		});
		btnEdit_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnEdit_1.setBounds(1043, 555, 122, 42);
		contentPane.add(btnEdit_1);
		Image icon6 = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Pictures\\stock3.jpg").getImage().getScaledInstance(1348, 721,Image.SCALE_SMOOTH);
		
		
		btnBackDelivery = new JButton("Go Back");
		btnBackDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int confirm = JOptionPane.showConfirmDialog(myMainInterface, "Are you sure you want to go back from the Stock","Go Back",JOptionPane.YES_OPTION);
				if(confirm == 0) { 					
					
					
					exitInter();
				}	
				
			}
		});
		btnBackDelivery.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBackDelivery.setBounds(1196, 35, 114, 31);
		contentPane.add(btnBackDelivery);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		//Image icon7 = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Pictures\\stock3.jpg").getImage().getScaledInstance(1510, 696,Image.SCALE_SMOOTH);
		lblNewLabel_8.setIcon(new ImageIcon(icon6));
		lblNewLabel_8.setBounds(0, 0, 1348, 721);
		contentPane.add(lblNewLabel_8);
		 ItemID();
	
	}
	
	public void exitInter() {
		this.setVisible(false);		
		myMainInterface.setVisible(true);
	}
}

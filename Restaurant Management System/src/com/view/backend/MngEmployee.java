package com.view.backend;

import javax.swing.JPanel;
import javax.swing.JTable;

import com.controller.Controller;
import com.models.Employee;
import com.utill.DBUtill;
import com.view.Mng;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ColorUIResource;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class MngEmployee extends JPanel implements Mng,KeyListener,ActionListener,MouseListener {
	private Controller myController;
	private MainUserInterface myMainInterface;

	private static final byte search = 1;
	private static final byte insert = 2;
	private static final byte delete = 3;
	private static final byte update = 4;
	
	private static byte option;
	
	private JLayeredPane layeredPane;
	private JPanel panelSearch,panelInsert,panelDelete,panelUpdate;	
	
	private static ResultSet rs  = null;
	
	private JTable table;
	private JTable tableUpdate;
	private JTable tableDelete;
	private JTable tableSearch;
	private JTextField textField_fName;
	private JTextField textField_fName_Delete;
	private JTextField textField_fName_Insert;
	private JTextField textField_fName_Update;
	private JTextField textField_LName;
	private JTextField textField_LName_Delete;
	private JTextField textField_LName_Insert;
	private JTextField textField_LName_Update;
	private JTextField textField_Email;
	private JTextField textField_Email_Delete;
	private JTextField textField_Email_Insert;
	private JTextField textField_Email_Update;
	private JTextField textField_Pnumber;
	private JTextField textField_Pnumber_Delete;
	private JTextField textField_Pnumber_Insert;
	private JTextField textField_Pnumber_Update;
	private JTextField textField_Password;
	private JTextField textField_Password_Delete;
	private JTextField textField_Password_Update;
	private JButton btnRefresh_Update;
	private JButton btnRefresh_Delete;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnInsert;	
	private JTextField textField_ID_Update;
	private JTextField textField_ID_Delete;
	private JTextField textFieldSearchID;
	private JTextField textFieldSearchID_Delete;
	private JTextField textFieldSearchID_Search;
	private JTextField textFieldSearch_Update;
	private JButton btnBack,btnBack_Delete, btnBack_Insert, btnBackSearch;	
	private JButton btnBack_Update;
	private JComboBox comboBoxSelectType_Update;
	private JComboBox comboBoxSelectType_Delete;
	private JComboBox comboBoxSelectType_Search;
	private JLabel lblNewLabel_12;
	private JLabel lblSearchById_Update;
	private JLabel lblSearchById_Delete;
	private JLabel lblSearchById_Search;
	private JLabel lblNewLabel_40;
	private JLabel lblNewLabel_40_1;
	private JLabel lblNewLabel_40_2;
	private JLabel lblNewLabel_40_3;
	private JLabel lblNewLabel_40_4;
	private JCheckBox chckbxAsAdmin_Insert;
	private JPasswordField textField_Password_Insert;
	private JPasswordField textField_RetypePassword_Insert;
	private JLabel lblNewLabel;
	private JPanel panelSearchDet;
	private JLabel lblSearchDetail;
	private JScrollPane scrollPane_Search;
	private JPanel panel;
	private JLabel lblInsertDetails_Insert;
	
	
	/**
	 * Create the panel.
	 */
	public MngEmployee(Controller myController,MainUserInterface myMainInterface) {		
		this.myController = myController;
		this.myMainInterface = myMainInterface;
		
		setBounds(0, 0,1366, 768);
		setLayout(null);		
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1366, 768);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		btnBack = new JButton(" Go Back");
		btnBack.addActionListener(this);
		btnBack.setHorizontalAlignment(SwingConstants.LEADING);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(1170, 39, 96, 37);
		
		panelSearch = new JPanel();
		layeredPane.add(panelSearch, "name_554747890563400");
		panelSearch.setLayout(null);		
		
		panelSearchDet = new JPanel();
		panelSearchDet.setBounds(0, 0, 793, 729);
		panelSearch.add(panelSearchDet);
		panelSearchDet.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(204, 51, 0));
		panel.setSize(660, 371);
		panel.setLocation(58, 224);
		panelSearchDet.add(panel);
		panel.setLayout(null);
		
		lblSearchDetail = new JLabel("SEARCH DETAILS");
		lblSearchDetail.setBounds(40, 32, 185, 42);
		lblSearchDetail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelSearchDet.add(lblSearchDetail);
		
		btnBackSearch = new JButton(" Go Back");
		btnBackSearch.setBounds(628, 34, 112, 42);
		panelSearchDet.add(btnBackSearch);
		btnBackSearch.addActionListener(this);		
		
		scrollPane_Search =  new JScrollPane();
		scrollPane_Search.setBackground(new Color(255, 255, 255, 0));
		scrollPane_Search.setBounds(0, 11, 660, 360);		
		panel.add(scrollPane_Search);
		
		tableSearch = new JTable();		
		tableSearch.addMouseListener(this);			
		
		scrollPane_Search.setViewportView(tableSearch);			
		
		lblSearchById_Search = new JLabel("Search By ID");
		lblSearchById_Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearchById_Search.setBounds(82, 139, 104, 23);
		panelSearchDet.add(lblSearchById_Search);
		
		textFieldSearchID_Search = new JTextField();
		textFieldSearchID_Search.setBounds(444, 139, 218, 28);	
		textFieldSearchID_Search.addKeyListener(this);		
		panelSearchDet.add(textFieldSearchID_Search);
		textFieldSearchID_Search.setColumns(10);
		
		comboBoxSelectType_Search = new JComboBox();
		comboBoxSelectType_Search.setModel(new DefaultComboBoxModel(new String[] {"id", "fname", "lname"}));
		comboBoxSelectType_Search.setBounds(220, 141, 182, 23);		
		panelSearchDet.add(comboBoxSelectType_Search);
		/////////////////////////////////////////////////////////////////////////////////
		panelInsert = new JPanel();
		layeredPane.add(panelInsert, "name_554750887143200");
		panelInsert.setLayout(null);
		
		JPanel panelInsertDetail = new JPanel();
		panelInsertDetail.setBounds(0, 0, 687, 729);
		panelInsert.add(panelInsertDetail);
		panelInsertDetail.setLayout(null);
		
		lblInsertDetails_Insert = new JLabel("INSERT DETAILS");
		lblInsertDetails_Insert.setForeground(Color.WHITE);
		lblInsertDetails_Insert.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInsertDetails_Insert.setBounds(158, 27, 176, 66);
		panelInsertDetail.add(lblInsertDetails_Insert);
		
		btnBack_Insert = new JButton(" Go Back");
		btnBack_Insert.setBackground(new Color(153, 102, 102));
		btnBack_Insert.setBounds(546, 45, 96, 37);
		panelInsertDetail.add(btnBack_Insert);
		btnBack_Insert.addActionListener(this);		
	
		JPanel panelInsert_Det = new JPanel();
		panelInsert_Det.setBounds(158, 130, 501, 529);
		panelInsert_Det.setBackground(new Color(255, 255, 255, 0));
		panelInsert_Det.setLayout(null);
		panelInsertDetail.add(panelInsert_Det);					
		
		lblNewLabel_40 = new JLabel("First Name");
		lblNewLabel_40.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_40.setForeground(new Color(255, 255, 255));
		lblNewLabel_40.setBounds(33, 32, 99, 24);
		panelInsert_Det.add(lblNewLabel_40);		
		
		lblNewLabel_40_1 = new JLabel("Last Name");
		lblNewLabel_40_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_40_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_40_1.setBounds(33, 97, 99, 24);
		panelInsert_Det.add(lblNewLabel_40_1);		
		
		lblNewLabel_40_2 = new JLabel("Email");
		lblNewLabel_40_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_40_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_40_2.setBounds(33, 161, 99, 24);
		panelInsert_Det.add(lblNewLabel_40_2);		
		
		lblNewLabel_40_3 = new JLabel("Phone Number");
		lblNewLabel_40_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_40_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_40_3.setBounds(33, 228, 118, 24);
		panelInsert_Det.add(lblNewLabel_40_3);		
		
		lblNewLabel_40_4 = new JLabel("Password");
		lblNewLabel_40_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_40_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_40_4.setBounds(33, 292, 99, 24);
		panelInsert_Det.add(lblNewLabel_40_4);
		
		textField_fName_Insert = new JTextField();
		textField_fName_Insert.setBounds(172, 32, 274, 28);
		panelInsert_Det.add(textField_fName_Insert);
		textField_fName_Insert.setColumns(10);
		
		textField_LName_Insert = new JTextField();
		textField_LName_Insert.setColumns(10);
		textField_LName_Insert.setBounds(172, 98, 274, 27);
		panelInsert_Det.add(textField_LName_Insert);
		
		textField_Email_Insert = new JTextField();
		textField_Email_Insert.setColumns(10);
		textField_Email_Insert.setBounds(172, 161, 274, 28);
		panelInsert_Det.add(textField_Email_Insert);
		
		textField_Pnumber_Insert = new JTextField();
		textField_Pnumber_Insert.setColumns(10);
		textField_Pnumber_Insert.setBounds(172, 228, 274, 29);
		panelInsert_Det.add(textField_Pnumber_Insert);
		
		btnInsert = new JButton("INSERT");
		btnInsert.setBackground(new Color(0, 204, 255));
		btnInsert.addActionListener(this);
		btnInsert.setBounds(144, 495, 89, 23);
		panelInsert_Det.add(btnInsert);
		
		chckbxAsAdmin_Insert = new JCheckBox("Insert As Admin");
		chckbxAsAdmin_Insert.setForeground(Color.CYAN);
		chckbxAsAdmin_Insert.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		chckbxAsAdmin_Insert.setBounds(123, 437, 150, 23);
		panelInsert_Det.add(chckbxAsAdmin_Insert);
		
		textField_Password_Insert = new JPasswordField();
		textField_Password_Insert.setBounds(172, 293, 274, 27);
		panelInsert_Det.add(textField_Password_Insert);
		
		textField_RetypePassword_Insert = new JPasswordField();
		textField_RetypePassword_Insert.setBounds(172, 354, 274, 28);
		panelInsert_Det.add(textField_RetypePassword_Insert);
		
		lblNewLabel = new JLabel("Retype Password");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(33, 354, 129, 24);
		panelInsert_Det.add(lblNewLabel);
		
		JLabel lblInsertImage = new JLabel("");
		lblInsertImage.setBounds(0, 0, 687, 729);
		panelInsertDetail.add(lblInsertImage);
		
		ImageIcon icon = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Pictures\\5.jpg");
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(lblInsertImage.getWidth(), lblInsertImage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledImgIcn = new ImageIcon(imgScale);
		lblInsertImage.setIcon(scaledImgIcn);
		
		////////////////////////////////////////////////////////////////////////////
		panelDelete = new JPanel();
		panelDelete.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		layeredPane.add(panelDelete, "name_554753847466800");
		panelDelete.setLayout(null);
		
		btnBack_Delete = new JButton(" Go Back");
		btnBack_Delete.addActionListener(this);
		btnBack_Delete.setHorizontalAlignment(SwingConstants.LEADING);
		btnBack_Delete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack_Delete.setBounds(1170, 39, 96, 37);
		panelDelete.add(btnBack_Delete);
	
		btnRefresh_Delete = new JButton("REFRESH");
		btnRefresh_Delete.addActionListener(this);
		btnRefresh_Delete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRefresh_Delete.setBounds(114, 665, 144, 45);
		panelDelete.add(btnRefresh_Delete);
		
		JLabel lblDeleteDetails_Delete = new JLabel("DELETE DETAILS");
		lblDeleteDetails_Delete.setForeground(new Color(128, 0, 0));
		lblDeleteDetails_Delete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeleteDetails_Delete.setBounds(41, 26, 176, 66);
		panelDelete.add(lblDeleteDetails_Delete);
		
		JPanel panelDelete_Det = new JPanel();		
		panelDelete_Det.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "DELETE"
				+ " DETAILS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		panelDelete_Det.setBounds(80, 166, 458, 477);
		panelDelete_Det.setLayout(null);
		panelDelete.add(panelDelete_Det);		
			
		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setBounds(33, 127, 99, 24);
		panelDelete_Det.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Last Name");
		lblNewLabel_2_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_1.setBounds(33, 181, 99, 24);
		panelDelete_Det.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email");
		lblNewLabel_2_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_2.setBounds(33, 229, 99, 24);
		panelDelete_Det.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Phone Number");
		lblNewLabel_2_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_3.setBounds(33, 283, 99, 24);
		panelDelete_Det.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Password");
		lblNewLabel_2_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_4.setBounds(33, 337, 99, 24);
		panelDelete_Det.add(lblNewLabel_2_4);
		
		textField_fName_Delete = new JTextField();
		textField_fName_Delete.setEditable(false);
		textField_fName_Delete.setBounds(172, 129, 221, 20);
		panelDelete_Det.add(textField_fName_Delete);
		textField_fName_Delete.setColumns(10);
		
		textField_LName_Delete = new JTextField();
		textField_LName_Delete.setEditable(false);
		textField_LName_Delete.setColumns(10);
		textField_LName_Delete.setBounds(172, 183, 221, 20);
		panelDelete_Det.add(textField_LName_Delete);
		
		textField_Email_Delete = new JTextField();
		textField_Email_Delete.setEditable(false);
		textField_Email_Delete.setColumns(10);
		textField_Email_Delete.setBounds(172, 231, 221, 20);
		panelDelete_Det.add(textField_Email_Delete);
		
		textField_Pnumber_Delete = new JTextField();
		textField_Pnumber_Delete.setEditable(false);
		textField_Pnumber_Delete.setColumns(10);
		textField_Pnumber_Delete.setBounds(172, 285, 221, 20);
		panelDelete_Det.add(textField_Pnumber_Delete);
		
		textField_Password_Delete = new JTextField();
		textField_Password_Delete.setEditable(false);
		textField_Password_Delete.setColumns(10);
		textField_Password_Delete.setBounds(172, 339, 221, 20);
		panelDelete_Det.add(textField_Password_Delete);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.addActionListener(this);
		btnDelete.setBounds(188, 423, 89, 23);
		panelDelete_Det.add(btnDelete);
		
		JLabel lblNewLabel_2_6 = new JLabel("ID");
		lblNewLabel_2_6.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_6.setBounds(33, 80, 99, 24);
		panelDelete_Det.add(lblNewLabel_2_6);
		
		textField_ID_Delete = new JTextField();
		textField_ID_Delete.setEditable(false);
		textField_ID_Delete.setColumns(10);
		textField_ID_Delete.setBounds(173, 82, 220, 20);
		panelDelete_Det.add(textField_ID_Delete);
		
		JScrollPane scrollPane_Delete =  new JScrollPane();
		scrollPane_Delete.setBounds(606, 173, 660, 371);		
		panelDelete.add(scrollPane_Delete);
		
		tableDelete = new JTable();		
		tableDelete.addMouseListener(this);			
		
		scrollPane_Delete.setViewportView(tableDelete);
		
		JLabel lblNewLabel_12;
		lblSearchById_Delete = new JLabel("Search By ID");
		lblSearchById_Delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearchById_Delete.setBounds(606, 116, 104, 23);
		panelDelete.add(lblSearchById_Delete);
		
		textFieldSearchID_Delete = new JTextField();
		textFieldSearchID_Delete.addKeyListener(this);		
		textFieldSearchID_Delete.setBounds(1002, 115, 218, 28);
		panelDelete.add(textFieldSearchID_Delete);
		textFieldSearchID_Delete.setColumns(10);
		
		comboBoxSelectType_Delete = new JComboBox();
		comboBoxSelectType_Delete.setModel(new DefaultComboBoxModel(new String[] {"id", "fname", "lname"}));
		comboBoxSelectType_Delete.setBounds(763, 118, 182, 23);		
		panelDelete.add(comboBoxSelectType_Delete);
		////////////////////////////////////////////////
		panelUpdate = new JPanel();
		panelUpdate.setBackground(new Color(148, 0, 211));
		layeredPane.add(panelUpdate, "name_554757834715500");
		panelUpdate.setLayout(null);
		
		JScrollPane scrollPane_Update =  new JScrollPane();
		scrollPane_Update.setBounds(606, 173, 660, 371);
		panelUpdate.add(scrollPane_Update);
		
		tableUpdate = new JTable();
		tableUpdate.addMouseListener(this);			
		
		scrollPane_Update.setViewportView(tableUpdate);
		
		btnRefresh_Update = new JButton("REFRESH");
		btnRefresh_Update.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnRefresh_Update.setBackground(new Color(153, 102, 153));
		btnRefresh_Update.addActionListener(this);
		btnRefresh_Update.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRefresh_Update.setBounds(114, 665, 144, 45);
		panelUpdate.add(btnRefresh_Update);
		
		JLabel lblUpdateDetails_Update = new JLabel("UPDATE DETAILS");
		lblUpdateDetails_Update.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDetails_Update.setBounds(41, 26, 176, 66);
		panelUpdate.add(lblUpdateDetails_Update);
		
		JPanel panel_Update = new JPanel();
		panel_Update.setBackground(new Color(106, 90, 205));
		panel_Update.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "UPDATE DETAILS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		panel_Update.setBounds(80, 166, 458, 477);
		panelUpdate.add(panel_Update);
		panel_Update.setLayout(null);
			
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(33, 127, 99, 24);
		panel_Update.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setBounds(33, 181, 99, 24);
		panel_Update.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setBounds(33, 229, 99, 24);
		panel_Update.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone Number");
		lblNewLabel_1_3.setBounds(33, 283, 99, 24);
		panel_Update.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Password");
		lblNewLabel_1_4.setBounds(33, 337, 99, 24);
		panel_Update.add(lblNewLabel_1_4);
		
		textField_fName_Update = new JTextField();
		textField_fName_Update.setBounds(172, 129, 210, 20);
		panel_Update.add(textField_fName_Update);
		textField_fName_Update.setColumns(10);
		
		textField_LName_Update = new JTextField();
		textField_LName_Update.setColumns(10);
		textField_LName_Update.setBounds(172, 183, 210, 20);
		panel_Update.add(textField_LName_Update);
		
		textField_Email_Update = new JTextField();
		textField_Email_Update.setColumns(10);
		textField_Email_Update.setBounds(172, 231, 210, 20);
		panel_Update.add(textField_Email_Update);
		
		textField_Pnumber_Update = new JTextField();
		textField_Pnumber_Update.setColumns(10);
		textField_Pnumber_Update.setBounds(172, 285, 210, 20);
		panel_Update.add(textField_Pnumber_Update);
		
		textField_Password_Update = new JTextField();
		textField_Password_Update.setColumns(10);
		textField_Password_Update.setBounds(172, 339, 210, 20);
		panel_Update.add(textField_Password_Update);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(102, 0, 255));
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(188, 423, 89, 23);
		panel_Update.add(btnUpdate);
		
		JLabel lblNewLabel_1_6 = new JLabel("ID");
		lblNewLabel_1_6.setBounds(33, 80, 99, 24);
		panel_Update.add(lblNewLabel_1_6);
		
		textField_ID_Update = new JTextField();
		textField_ID_Update.setEditable(false);
		textField_ID_Update.setColumns(10);
		textField_ID_Update.setBounds(173, 82, 209, 20);
		panel_Update.add(textField_ID_Update);		
		
		JLabel lblNewLabel_4;
		lblSearchById_Update = new JLabel("Search By ID");
		lblSearchById_Update.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearchById_Update.setBounds(606, 116, 104, 23);
		panelUpdate.add(lblSearchById_Update);
		
		textFieldSearchID = new JTextField();
		textFieldSearch_Update = new JTextField();
		textFieldSearch_Update.addKeyListener(this);		
		textFieldSearch_Update.setBounds(1002, 115, 218, 28);
		panelUpdate.add(textFieldSearch_Update);
		textFieldSearch_Update.setColumns(10);
		
		btnBack_Update = new JButton(" Go Back");
		btnBack_Update.setBackground(new Color(102, 0, 255));
		btnBack_Update.addActionListener(this);
		btnBack_Update.setHorizontalAlignment(SwingConstants.LEADING);
		btnBack_Update.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack_Update.setBounds(1170, 39, 96, 37);
		panelUpdate.add(btnBack_Update);
		
		comboBoxSelectType_Update = new JComboBox();
		comboBoxSelectType_Update.setModel(new DefaultComboBoxModel(new String[] {"id", "fname", "lname"}));
		comboBoxSelectType_Update.setBounds(763, 118, 182, 23);		
		panelUpdate.add(comboBoxSelectType_Update);
	}
	
	public void showOption(byte option) {
		layeredPane.setVisible(true);
		
		switch(option) {
			case search :  	this.refreshTableSearch();
				panelSearch.setVisible(true);
				panelInsert.setVisible(false);
				panelDelete.setVisible(false);
				panelUpdate.setVisible(false);
				
				
		
				try {
		            //here you can put the selected theme class name in JTattoo
		            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
		            SwingUtilities.updateComponentTreeUI(this);
		 
		        } catch (ClassNotFoundException ex) {
		            java.util.logging.Logger.getLogger(MngEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(MngEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(MngEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(MngEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
				
				
				break;
				
			case insert : 
				panelSearch.setVisible(false);
				panelInsert.setVisible(true);
				panelDelete.setVisible(false);
				panelUpdate.setVisible(false);		
				
				break;
				
			case delete :  	this.refreshTableDelete();
				panelSearch.setVisible(false);
				panelInsert.setVisible(false);
				panelDelete.setVisible(true);
				panelUpdate.setVisible(false);
				try {
		            //here you can put the selected theme class name in JTattoo
		            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
		            SwingUtilities.updateComponentTreeUI(this);
		 
		        } catch (ClassNotFoundException ex) {
		            java.util.logging.Logger.getLogger(MngEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(MngEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(MngEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(MngEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
				
				break;	
			
			case update : this.refreshTableUpdate();
				panelSearch.setVisible(false);
				panelInsert.setVisible(false);
				panelDelete.setVisible(false);
				panelUpdate.setVisible(true);
				
				try {
		            //here you can put the selected theme class name in JTattoo
		            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		            SwingUtilities.updateComponentTreeUI(this);
		 
		        } catch (ClassNotFoundException ex) {
		            java.util.logging.Logger.getLogger(MngEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(MngEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(MngEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(MngEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
				
				
				break;					
		}
	}
	
	public void refreshTableUpdate() {
		rs = myController.refreshData();
		this.tableUpdate.setModel(DbUtils.resultSetToTableModel(rs));
		
		textField_ID_Update.setText(null);
		textField_fName_Update.setText(null);
		textField_LName_Update.setText(null);
		textField_Email_Update.setText(null);
		textField_Pnumber_Update.setText(null);
		textField_Password_Update.setText(null);
	}
	
	public void refreshTableDelete() {
		rs = myController.refreshData();
		this.tableDelete.setModel(DbUtils.resultSetToTableModel(rs));
		
		textField_ID_Delete.setText(null);
		textField_fName_Delete.setText(null);
		textField_LName_Delete.setText(null);
		textField_Email_Delete.setText(null);
		textField_Pnumber_Delete.setText(null);
		textField_Password_Delete.setText(null);
	}
	
	public void refreshTableSearch() {
		rs = myController.refreshData();
		this.tableSearch.setModel(DbUtils.resultSetToTableModel(rs));
	}
 	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRefresh_Update) {			
			this.refreshTableUpdate();
		}
		
		if(e.getSource() == btnRefresh_Delete) {			
			this.refreshTableDelete();
		}
		
		if(e.getSource() == btnBack_Update || e.getSource() == btnBack_Delete || e.getSource() == btnBack_Insert || e.getSource() == btnBackSearch) {		
			this.myMainInterface.goBack();
		}
		
		if(e.getSource() == btnUpdate) {
			int id = Integer.parseInt(textField_ID_Update.getText());
			String fname = textField_fName_Update.getText();
			String lname = textField_LName_Update.getText();
			String email = textField_Email_Update.getText();
			String phone = textField_Pnumber_Update.getText();
			String password = textField_Password_Update.getText();
			
			if( password.equals("") ) {
				JOptionPane.showMessageDialog(this, "Password must be provided", "Update Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			myController.UpdateEmployee(id, fname, lname, email, phone, password);
			this.refreshTableUpdate();	
			
			textField_ID_Update.setText(null);
			textField_fName_Update.setText(null);
			textField_LName_Update.setText(null);
			textField_Email_Update.setText(null);
			textField_Pnumber_Update.setText(null);
			textField_Password_Update.setText(null);
		}
		
		if(e.getSource() == btnDelete) {
			int id = Integer.parseInt(textField_ID_Delete.getText().toString());			
			this.myController.DeleteEmployee(id);
			this.refreshTableDelete();
			
			textField_ID_Delete.setText(null);
			textField_fName_Delete.setText(null);
			textField_LName_Delete.setText(null);
			textField_Email_Delete.setText(null);
			textField_Pnumber_Delete.setText(null);
			textField_Password_Delete.setText(null);
			
		}
		
		if(e.getSource() == btnInsert) {	
			char[] passwd;
			char[] rePasswd;
			
			passwd = textField_Password_Insert.getPassword();
			rePasswd = textField_RetypePassword_Insert.getPassword();
			
			boolean isAdmin = chckbxAsAdmin_Insert.isSelected();
			String fname = textField_fName_Insert.getText();
			String lname = textField_LName_Insert.getText();
			String email = textField_Email_Insert.getText();
			String phone = textField_Pnumber_Insert.getText();
			String password = new String(passwd);
			
			if(fname.equals(null)) {
				JOptionPane.showMessageDialog(myMainInterface, "First Name should not be empty", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(phone.length() != 10) {
				JOptionPane.showMessageDialog(myMainInterface, "Phone number should contain 10 digits And no spaces", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if( password.equals("")) {
				JOptionPane.showMessageDialog(myMainInterface, "Password must be provided", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}			
			else {
				if( !(password.equals(new String(rePasswd))) ) {
					JOptionPane.showMessageDialog(myMainInterface, "Password not match Please try again", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}				
			
			this.myController.InsertEmployee(fname, lname, email.toLowerCase(), phone, password, isAdmin);
			
			textField_fName_Insert.setText(null);
			textField_LName_Insert.setText(null);
			textField_Email_Insert.setText(null);
			textField_Pnumber_Insert.setText(null);
			textField_Password_Insert.setText(null);
			textField_RetypePassword_Insert.setText(null);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource() == textFieldSearch_Update  ) {
			String searchType = (String)comboBoxSelectType_Update.getSelectedItem();
			String id = textFieldSearch_Update.getText();
			rs = myController.searchData(searchType, id);						
			tableUpdate.setModel(DbUtils.resultSetToTableModel(rs));					
		}
		
		if(e.getSource() == textFieldSearchID_Delete) {
			String searchType = (String)comboBoxSelectType_Delete.getSelectedItem();
			String id = textFieldSearchID_Delete.getText();
			rs = myController.searchData(searchType, id);						
			tableDelete.setModel(DbUtils.resultSetToTableModel(rs));					
		}
		
		if(e.getSource() == textFieldSearchID_Search) {
			String searchType = (String)comboBoxSelectType_Search.getSelectedItem();
			String id = textFieldSearchID_Search.getText();
			rs = myController.searchData(searchType, id);						
			tableSearch.setModel(DbUtils.resultSetToTableModel(rs));					
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//MOUSE LISTENER 
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == tableUpdate ) {
			int row = tableUpdate.getSelectedRow();
			int ID = Integer.parseInt((tableUpdate.getValueAt(row, 0)).toString());					
		
			Employee emp = MngEmployee.this.myController.getEmployeeData(ID);	
										
			textField_ID_Update.setText(Integer.toString(emp.getEmpID()));
			textField_fName_Update.setText(emp.getFirstName());
			textField_LName_Update.setText(emp.getLastName());
			textField_Email_Update.setText(emp.getEmail());
			textField_Pnumber_Update.setText(emp.getPhoneNumber());
			textField_Password_Update.setText(emp.getPassword());
		}
		
		if( e.getSource() == tableDelete ) {
			int row = tableDelete.getSelectedRow();
			int ID = Integer.parseInt((tableDelete.getValueAt(row, 0)).toString());					
		
			Employee emp = MngEmployee.this.myController.getEmployeeData(ID);	
										
			textField_ID_Delete.setText( Integer.toString(emp.getEmpID()) );
			textField_fName_Delete.setText( emp.getFirstName() );
			textField_LName_Delete.setText( emp.getLastName() );
			textField_Email_Delete.setText( emp.getEmail() );
			textField_Pnumber_Delete.setText( emp.getPhoneNumber() );
			textField_Password_Delete.setText( emp.getPassword());
		}	
	}	
}

package com.view.frontend;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.controller.Controller;
import com.models.Menu;
import com.view.Mng;
import com.view.backend.MainUserInterface;
import com.view.backend.MngEmployee;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;

public class MngMenu extends JPanel implements Mng,ActionListener, MouseListener, KeyListener{
	private Controller myController;
	private MainUserInterface myMainInterface;
	
	private static final byte search = 1;
	private static final byte insert = 2;
	private static final byte delete = 3;
	private static final byte update = 4;
	
	private static byte option;
	
	private JLayeredPane layeredPane;
	private JPanel panelSearch,panelInsert,panelDelete,panelUpdate;
	private JTextField textField_ID_Update;
	private JTextField textField_Name_Update;
	private JTextField textField_Price_Update;
	
	private JButton btnUpdate;
	private JButton btnRefreshT_Delete, btnRefreshSearch ;
	private JButton btnDelete;
	private JComboBox comboBox_Search_Delete,comboBoxSearch_Update;
	private JComboBox comboBox_Search_Search;
	private JTextField textField_ID_Insert;
	private JTextField textField__Price_Insert;
	private JTextField textField__Name_Insert;
	private JTable tableUpdate;
	private JTextField textField_ID_Delete;
	private JTextField textField_Price_Delete;
	private JTextField textField_Type_Delete;
	private JTextField textField__Name_Delete;
	private JTable tableDelete, tableSearch;
	private JButton btnUpdatePhoto;
	private JButton btnInsert;
	private JButton btnChoose_Insert;
	private JButton btnRefresh_update;
	private JTextField textField_ImageLocation_Insert;
	private JLabel lbl_PhotoInserted, lblImg_Search;
	private JLabel lbl_Photo_update;
	private JLabel lbl_Photo_delete;
	private JTextField textField_ImageLocation_Update;
	private JTextField textFieldSearch_Update;
	private ResultSet rs;
	private JTextField textFieldSearch_Delete;
	private JTextField textFieldSearch_Search;
	private JButton btnBackUpdate, btnBackDelete, btnBackInsert, btnBackSearch;
	private JLabel lblNewLabelSearchBy_Search;
	private JComboBox comboBox_insert;
	private JComboBox comboBox_update;
	
	
	/**
	 * Create the panel.
	 */
	public MngMenu(Controller myController,MainUserInterface myMainInterface) {
		this.myController = myController;
		this.myMainInterface = myMainInterface;
		
		setVisible(true);
		setBounds(0, 0, 1366, 768);
		setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0,1366, 768);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelSearch = new JPanel();
		layeredPane.add(panelSearch, "name_554747890563400");
		panelSearch.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 716, 729);
		panelSearch.add(panel_1);
		panel_1.setLayout(null);		
	
		lblNewLabelSearchBy_Search = new JLabel("Search By");
		lblNewLabelSearchBy_Search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabelSearchBy_Search.setBounds(134, 103, 70, 32);
		panel_1.add(lblNewLabelSearchBy_Search);
		
		comboBox_Search_Search = new JComboBox();
		comboBox_Search_Search.setModel(new DefaultComboBoxModel(new String[] {"id", "itemtype", "itemname"}));
		comboBox_Search_Search.setBounds(214, 105, 82, 30);
		panel_1.add(comboBox_Search_Search);
		
		textFieldSearch_Search = new JTextField();
		textFieldSearch_Search.addKeyListener(this);
		textFieldSearch_Search.setColumns(10);
		textFieldSearch_Search.setBounds(317, 106, 216, 30);
		panel_1.add(textFieldSearch_Search);
		
		JScrollPane scrollPaneSearch = new JScrollPane();
		scrollPaneSearch.setBounds(28, 146, 653, 383);
		panel_1.add(scrollPaneSearch);
		
		tableSearch = new JTable();
		tableSearch.addMouseListener(this); 
		scrollPaneSearch.setViewportView(tableSearch);
		
		btnBackSearch = new JButton(" Go Back");
		btnBackSearch.setBounds(569, 32, 112, 39);
		panel_1.add(btnBackSearch);
		
		lblImg_Search = new JLabel("");
		lblImg_Search.setBounds(221, 540, 268, 178);
		panel_1.add(lblImg_Search);
		
		JLabel lblNewLabel_7 = new JLabel("Menu Item Search");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBounds(28, 32, 173, 43);
		panel_1.add(lblNewLabel_7);
		
		btnRefreshSearch = new JButton("Refresh");
		btnRefreshSearch.addActionListener(this);
		btnRefreshSearch.setBounds(569, 105, 112, 30);
		panel_1.add(btnRefreshSearch);
		btnBackSearch.addActionListener(this);	
		
		panelInsert = new JPanel();
		layeredPane.add(panelInsert, "name_554750887143200");
		panelInsert.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 890, 729);
		panelInsert.add(panel_4);
		panel_4.setLayout(null);
		
		btnBackInsert = new JButton(" Go Back");
		btnBackInsert.setBounds(732, 29, 112, 42);
		panel_4.add(btnBackInsert);
		btnBackInsert.addActionListener(this);	
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Item Insert", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(0, 255, 0), new Color(0, 0, 0), new Color(255, 0, 0)), new MatteBorder(11, 11, 11, 11, (Color) new Color(0, 255, 255)))));
		panel_3_1.setBounds(59, 124, 785, 583);
		panel_4.add(panel_3_1);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Item ID ");
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_3_1.setBounds(53, 93, 101, 32);
		panel_3_1.add(lblNewLabel_3_3_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Name");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1.setBounds(53, 151, 101, 32);
		panel_3_1.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_2_2_1 = new JLabel("Price");
		lblNewLabel_3_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_2_1.setBounds(53, 206, 101, 32);
		panel_3_1.add(lblNewLabel_3_2_2_1);
		
		JLabel lblNewLabel_3_2_1_1_1 = new JLabel("Type");
		lblNewLabel_3_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_1_1.setBounds(53, 265, 101, 32);
		panel_3_1.add(lblNewLabel_3_2_1_1_1);
		
		textField_ID_Insert = new JTextField();
		textField_ID_Insert.setBackground(Color.GRAY);
		textField_ID_Insert.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_ID_Insert.setEditable(false);
		textField_ID_Insert.setColumns(10);
		textField_ID_Insert.setBounds(164, 95, 164, 32);
		panel_3_1.add(textField_ID_Insert);
		
	    btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(this); 
		
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnInsert.setBounds(267, 470, 146, 32);
		panel_3_1.add(btnInsert);
		
		JPanel panel_1_1_3_1 = new JPanel();
		panel_1_1_3_1.setBackground(Color.GREEN);
		panel_1_1_3_1.setBounds(164, 179, 164, 4);
		panel_3_1.add(panel_1_1_3_1);
		
		textField__Name_Insert = new JTextField();
		textField__Name_Insert.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField__Name_Insert.setColumns(10);
		textField__Name_Insert.setBounds(164, 151, 164, 32);
		panel_3_1.add(textField__Name_Insert);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Upload Photo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)), new CompoundBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 255, 255), new Color(220, 20, 60), new Color(255, 0, 0)), new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 51, 255))), new MatteBorder(12, 12, 12, 12, (Color) new Color(204, 0, 204)))));
		panel_2_1_1.setBounds(405, 46, 250, 280);
		panel_3_1.add(panel_2_1_1);
		
		lbl_PhotoInserted = new JLabel("");
		lbl_PhotoInserted.setBackground(Color.WHITE);
		lbl_PhotoInserted.setBounds(24, 34, 201, 222);
		panel_2_1_1.add(lbl_PhotoInserted);
		
		btnChoose_Insert = new JButton("Choose Image");
		btnChoose_Insert.addActionListener(this);
		
		btnChoose_Insert.setBounds(546, 355, 109, 24);
		panel_3_1.add(btnChoose_Insert);
		
		JPanel panel_1_1_3_1_1 = new JPanel();
		panel_1_1_3_1_1.setBackground(Color.GREEN);
		panel_1_1_3_1_1.setBounds(164, 234, 164, 4);
		panel_3_1.add(panel_1_1_3_1_1);
		
		textField__Price_Insert = new JTextField();
		textField__Price_Insert.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField__Price_Insert.setColumns(10);
		textField__Price_Insert.setBounds(164, 206, 164, 32);
		panel_3_1.add(textField__Price_Insert);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(297, 355, 217, 24);
		panel_3_1.add(scrollPane_2);
		
		textField_ImageLocation_Insert = new JTextField();
		textField_ImageLocation_Insert.setEditable(false);
		textField_ImageLocation_Insert.setBackground(Color.GRAY);
		scrollPane_2.setViewportView(textField_ImageLocation_Insert);
		textField_ImageLocation_Insert.setColumns(10);
		
		comboBox_insert = new JComboBox();
		comboBox_insert.setModel(new DefaultComboBoxModel(new String[] {"Rice", "Sandwich", "Burger", "Soft Drinks", "Desserts", "Sri Lankan Breakfast", "Smoothy", "Chocolate Drinks", "Faluda", "Omelette", "BBQ chicken", "Chopsuey"}));
		refreshComboBox();
		comboBox_insert.setEditable(true);
		comboBox_insert.setBounds(167, 273, 161, 24);
		panel_3_1.add(comboBox_insert);
		
		JLabel lblNewLabel_4 = new JLabel("Menu Item Insert");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(59, 29, 204, 42);
		panel_4.add(lblNewLabel_4);
		
		panelDelete = new JPanel();
		layeredPane.add(panelDelete, "name_554753847466800");
		panelDelete.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 1352, 729);
		panelDelete.add(panel_3);
		panel_3.setLayout(null);
		
		btnBackDelete = new JButton(" Go Back");
		btnBackDelete.setBounds(1200, 30, 112, 42);
		panel_3.add(btnBackDelete);
		btnBackDelete.addActionListener(this);	
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Item Delete", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)), new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(0, 255, 0), new Color(0, 0, 0), new Color(255, 0, 0)), new MatteBorder(11, 11, 11, 11, (Color) new Color(0, 255, 255)))));
		panel_6.setBounds(67, 134, 719, 507);
		panel_3.add(panel_6);
		
		JLabel lblNewLabel_3_3 = new JLabel("Item ID ");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_3.setBounds(62, 93, 101, 32);
		panel_6.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Name");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(62, 148, 101, 32);
		panel_6.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Price");
		lblNewLabel_3_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_2.setBounds(62, 203, 101, 32);
		panel_6.add(lblNewLabel_3_2_2);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Type");
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_1.setBounds(62, 263, 101, 32);
		panel_6.add(lblNewLabel_3_2_1_1);
		
		textField_ID_Delete = new JTextField();
		textField_ID_Delete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_ID_Delete.setForeground(Color.WHITE);
		textField_ID_Delete.setBackground(Color.DARK_GRAY);
		textField_ID_Delete.setEditable(false);
		textField_ID_Delete.setColumns(10);
		textField_ID_Delete.setBounds(184, 95, 164, 32);
		panel_6.add(textField_ID_Delete);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(this); 
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(241, 402, 146, 32);
		panel_6.add(btnDelete);
		
		JPanel panel_1_1_3 = new JPanel();
		panel_1_1_3.setBackground(new Color(204, 102, 0));
		panel_1_1_3.setBounds(184, 176, 164, 4);
		panel_6.add(panel_1_1_3);
		
		textField__Name_Delete = new JTextField();
		textField__Name_Delete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField__Name_Delete.setForeground(Color.WHITE);
		textField__Name_Delete.setBackground(Color.DARK_GRAY);
		textField__Name_Delete.setEditable(false);
		textField__Name_Delete.setColumns(10);
		textField__Name_Delete.setBounds(184, 150, 164, 32);
		panel_6.add(textField__Name_Delete);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Upload Photo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)), new CompoundBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 255, 255), new Color(220, 20, 60), new Color(255, 0, 0)), new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 51, 255))), new MatteBorder(12, 12, 12, 12, (Color) new Color(204, 0, 204)))));
		panel_2_1.setBounds(395, 80, 234, 253);
		panel_6.add(panel_2_1);
		
		lbl_Photo_delete = new JLabel("");
		lbl_Photo_delete.setBounds(25, 35, 183, 195);
		panel_2_1.add(lbl_Photo_delete);
		
		JPanel panel_1_1_3_2 = new JPanel();
		panel_1_1_3_2.setBackground(Color.LIGHT_GRAY);
		panel_1_1_3_2.setBounds(184, 231, 164, 4);
		panel_6.add(panel_1_1_3_2);
		
		textField_Price_Delete = new JTextField();
		textField_Price_Delete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Price_Delete.setForeground(Color.WHITE);
		textField_Price_Delete.setBackground(Color.DARK_GRAY);
		textField_Price_Delete.setEditable(false);
		textField_Price_Delete.setColumns(10);
		textField_Price_Delete.setBounds(184, 205, 164, 32);
		panel_6.add(textField_Price_Delete);
		
		JPanel panel_1_1_3_3 = new JPanel();
		panel_1_1_3_3.setBackground(new Color(204, 102, 0));
		panel_1_1_3_3.setBounds(184, 291, 164, 4);
		panel_6.add(panel_1_1_3_3);
		
		textField_Type_Delete = new JTextField();
		textField_Type_Delete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Type_Delete.setForeground(Color.WHITE);
		textField_Type_Delete.setBackground(Color.DARK_GRAY);
		textField_Type_Delete.setEditable(false);
		textField_Type_Delete.setColumns(10);
		textField_Type_Delete.setBounds(184, 265, 164, 32);
		panel_6.add(textField_Type_Delete);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(837, 202, 472, 376);
		panel_3.add(scrollPane_1);
		
		tableDelete = new JTable();
		tableDelete.addMouseListener(this); 
		scrollPane_1.setViewportView(tableDelete);
		
		btnRefreshT_Delete = new JButton("Refresh");
		btnRefreshT_Delete.addActionListener(this); 
		btnRefreshT_Delete.setBounds(916, 608, 125, 30);
		panel_3.add(btnRefreshT_Delete);
		
		JLabel lblNewLabel_1_1 = new JLabel("Search By");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(903, 123, 70, 32);
		panel_3.add(lblNewLabel_1_1);
		
		comboBox_Search_Delete = new JComboBox();
		comboBox_Search_Delete.setModel(new DefaultComboBoxModel(new String[] {"id", "itemtype", "itemname"}));
		comboBox_Search_Delete.setBounds(983, 125, 82, 32);
		panel_3.add(comboBox_Search_Delete);
		
		textFieldSearch_Delete = new JTextField();
		textFieldSearch_Delete.addKeyListener(this);
		textFieldSearch_Delete.setColumns(10);
		textFieldSearch_Delete.setBounds(1084, 125, 216, 30);
		panel_3.add(textFieldSearch_Delete);
		
		JLabel lblNewLabel_5 = new JLabel("Menu Item Delete");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setBounds(67, 31, 173, 41);
		panel_3.add(lblNewLabel_5);
		
		panelUpdate = new JPanel();
		layeredPane.add(panelUpdate, "name_554757834715500");
		panelUpdate.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 1352, 729);
		panelUpdate.add(panel_5);
		panel_5.setLayout(null);		
		
		btnBackUpdate = new JButton(" Go Back");
		btnBackUpdate.setBounds(1185, 38, 112, 42);
		panel_5.add(btnBackUpdate);
		btnBackUpdate.addActionListener(this);	
		
		JPanel panel = new JPanel();
		panel.setBounds(53, 172, 671, 507);
		panel_5.add(panel);
		panel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Item Update", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(0, 255, 0), new Color(0, 0, 0), new Color(255, 0, 0)), new MatteBorder(11, 11, 11, 11, (Color) new Color(0, 255, 255)))));
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Item ID ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(71, 95, 101, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Name");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(71, 150, 101, 32);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Price");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(71, 205, 101, 32);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Type");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1.setBounds(71, 265, 101, 32);
		panel.add(lblNewLabel_3_2_1);
		
		textField_ID_Update = new JTextField();
		textField_ID_Update.setBackground(Color.GRAY);
		textField_ID_Update.setEditable(false);
		textField_ID_Update.setBounds(162, 97, 164, 32);
		panel.add(textField_ID_Update);
		textField_ID_Update.setColumns(10);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(this);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(237, 420, 146, 32);
		panel.add(btnUpdate);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GREEN);
		panel_1_1.setBounds(162, 177, 164, 4);
		panel.add(panel_1_1);
		
		textField_Name_Update = new JTextField();
		textField_Name_Update.setColumns(10);
		textField_Name_Update.setBounds(162, 150, 164, 32);
		panel.add(textField_Name_Update);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(380, 57, 250, 280);
		panel.add(panel_2);
		panel_2.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Upload Photo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)), new CompoundBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(0, 255, 255), new Color(220, 20, 60), new Color(255, 0, 0)), new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 51, 255))), new MatteBorder(12, 12, 12, 12, (Color) new Color(204, 0, 204)))));
		panel_2.setLayout(null);
		
		lbl_Photo_update = new JLabel("");
		lbl_Photo_update.setBounds(27, 35, 199, 217);
		panel_2.add(lbl_Photo_update);
		
		btnUpdatePhoto = new JButton("Choose Image");
		btnUpdatePhoto.addActionListener(this); 
		btnUpdatePhoto.setBounds(520, 369, 110, 23);
		panel.add(btnUpdatePhoto);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(Color.GREEN);
		panel_1_1_1.setBounds(162, 232, 164, 4);
		panel.add(panel_1_1_1);
		
		textField_Price_Update = new JTextField();
		textField_Price_Update.setColumns(10);
		textField_Price_Update.setBounds(162, 205, 164, 32);
		panel.add(textField_Price_Update);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(331, 369, 170, 23);
		panel.add(scrollPane_3);
		
		textField_ImageLocation_Update = new JTextField();
		textField_ImageLocation_Update.setBackground(Color.GRAY);
		textField_ImageLocation_Update.setEditable(false);
		scrollPane_3.setViewportView(textField_ImageLocation_Update);
		textField_ImageLocation_Update.setColumns(10);
		
		comboBox_update = new JComboBox();
		comboBox_update.setModel(new DefaultComboBoxModel(new String[] {"Rice", "Sandwich", "Burger", "Soft Drinks", "Desserts", "Sri Lankan Breakfast", "Smoothy", "Chocolate Drinks", "Faluda", "Omelette", "BBQ chicken", "Chopsuey"}));
		comboBox_update.setSelectedItem(null);
		comboBox_update.setBounds(162, 271, 164, 24);
		panel.add(comboBox_update);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(812, 212, 485, 409);
		panel_5.add(scrollPane);
		
		tableUpdate = new JTable();
		scrollPane.setViewportView(tableUpdate);
		
		comboBoxSearch_Update = new JComboBox();
		comboBoxSearch_Update.setModel(new DefaultComboBoxModel(new String[] {"id", "itemtype", "itemname"}));
		comboBoxSearch_Update.setBounds(966, 139, 82, 32);
		panel_5.add(comboBoxSearch_Update);
		
		textFieldSearch_Update = new JTextField();
		textFieldSearch_Update.addKeyListener(this); 
		textFieldSearch_Update.setBounds(1067, 139, 216, 32);
		panel_5.add(textFieldSearch_Update);
		textFieldSearch_Update.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Search By");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(884, 139, 72, 32);
		panel_5.add(lblNewLabel_1);
		
		btnRefresh_update = new JButton("Refresh");
		btnRefresh_update.addActionListener(this); 
		btnRefresh_update.setBounds(812, 653, 107, 26);
		panel_5.add(btnRefresh_update);
		
		JLabel lblNewLabel_6 = new JLabel("Menu Item Update");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(55, 38, 176, 52);
		panel_5.add(lblNewLabel_6);
		tableUpdate.addMouseListener(this); 
	}
		
	public void showOption(byte option) {
		layeredPane.setVisible(true);
		
		switch(option) {
			case search :  this.refreshTableSearch();
			
			try {
	            //here you can put the selected theme class name in JTattoo
	            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
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
				panelSearch.setVisible(true);
				panelInsert.setVisible(false);
				panelDelete.setVisible(false);
				panelUpdate.setVisible(false);
				
				break;
				
			case insert :  
				
				try {
		            //here you can put the selected theme class name in JTattoo
		            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
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
				setMngMenuInsertId();
				refreshComboBox();
				panelSearch.setVisible(false);
				panelInsert.setVisible(true);
				panelDelete.setVisible(false);
				panelUpdate.setVisible(false);		
				
				break;
				
			case delete :	this.refreshTableDelete();  
			
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
			
				panelSearch.setVisible(false);
				panelInsert.setVisible(false);
				panelDelete.setVisible(true);
				panelUpdate.setVisible(false);
				
				break;	
			
			case update :  this.refreshTableUpdate();
			
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
				panelSearch.setVisible(false);
				panelInsert.setVisible(false);
				panelDelete.setVisible(false);
				panelUpdate.setVisible(true);
				
				break;					
		}
	}
	
	public void setMngMenuInsertId() {
		textField_ID_Insert.setText(Integer.toString(myController.getNextMenuID()));
	}
	
	public void refreshTableSearch() {
		rs = myController.refreshMenuData();
		this.tableSearch.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	public void refreshTableUpdate() {
		rs = myController.refreshMenuData();
		this.tableUpdate.setModel(DbUtils.resultSetToTableModel(rs));
		
		textField_ID_Update.setText(null);
		textField_Price_Update.setText(null);
		textField_Name_Update.setText(null);
		lbl_Photo_update.setIcon(null);
		comboBox_update.setSelectedItem(null);
	}
	
	public void refreshComboBox() {
		comboBox_insert.setSelectedItem("select a type");
	}
	
	public void refreshTableDelete() {
		rs = myController.refreshMenuData();
		this.tableDelete.setModel(DbUtils.resultSetToTableModel(rs));
		
		textField_ID_Delete.setText(null);
		textField__Name_Delete.setText(null);
		textField_Price_Delete.setText(null);
		textField_Type_Delete.setText(null);
		lbl_Photo_delete.setIcon(null);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if( e.getSource() == tableSearch ) {
			int row = tableSearch.getSelectedRow();
			int ID = Integer.parseInt((tableSearch.getValueAt(row, 0)).toString());					
		
			Menu menu = MngMenu.this.myController.getMenuData(ID);	
					
			String filepath = new String(menu.getImage());
			ImageIcon icon = new ImageIcon(filepath);
			Image img = icon.getImage();
			Image imgScale = img.getScaledInstance(lblImg_Search.getWidth(), lblImg_Search.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon scaledImgIcn = new ImageIcon(imgScale);
			lblImg_Search.setIcon(scaledImgIcn);
		}	
		
		if( e.getSource() == tableUpdate ) {
			int row = tableUpdate.getSelectedRow();
			int ID = Integer.parseInt((tableUpdate.getValueAt(row, 0)).toString());					
		
			Menu menu = MngMenu.this.myController.getMenuData(ID);	
										
			textField_ID_Update.setText(Integer.toString(menu.getItemID()));
			textField_Name_Update.setText(menu.getItemName());
			textField_Price_Update.setText(Double.toString(menu.getItemPrice()));
			comboBox_update.setSelectedItem(menu.getType());
			textField_ImageLocation_Update.setText("");
		
			String filepath = new String(menu.getImage());
			ImageIcon icon = new ImageIcon(filepath);
			Image img = icon.getImage();
			Image imgScale = img.getScaledInstance(lbl_Photo_update.getWidth(), lbl_Photo_update.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon scaledImgIcn = new ImageIcon(imgScale);
			lbl_Photo_update.setIcon(scaledImgIcn);
		}	
		
		if( e.getSource() == tableDelete) {
			int row = tableDelete.getSelectedRow();
			int ID = Integer.parseInt((tableDelete.getValueAt(row, 0)).toString());					
		
			Menu menu = MngMenu.this.myController.getMenuData(ID);	
										
			textField_ID_Delete.setText(Integer.toString(menu.getItemID()));
			textField__Name_Delete.setText(menu.getItemName());
			textField_Price_Delete.setText(Double.toString(menu.getItemPrice()));
			textField_Type_Delete.setText(menu.getType());
			
			String filepath = new String(menu.getImage());
			ImageIcon icon = new ImageIcon(filepath);
			Image img = icon.getImage();
			Image imgScale = img.getScaledInstance(lbl_Photo_delete.getWidth(), lbl_Photo_delete.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon scaledImgIcn = new ImageIcon(imgScale);
			lbl_Photo_delete.setIcon(scaledImgIcn);		
		}	
		
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == btnBackUpdate || e.getSource() == btnBackDelete || e.getSource() == btnBackInsert || e.getSource() == btnBackSearch) {		
			this.myMainInterface.goBack();
		}
		
		if(e.getSource() == btnUpdate) {
			int id = Integer.parseInt(textField_ID_Update.getText());
			String image;
			double price;		
			
			Menu menu = MngMenu.this.myController.getMenuData(id);
			
			String textPrice = textField_Price_Update.getText();
			String textType  = (String) comboBox_update.getSelectedItem();
			
			String textName  =  textField_Name_Update.getText();
					
			if( textPrice.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Enter a item price", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( textType .equals("") ) {
				JOptionPane.showMessageDialog(this, "Please Select a item type", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( textName.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Enter a item Name", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			
			try {
				price = Double.parseDouble( textPrice );
				
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Inputs are not Valid, Please Check Again ", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}	
			
			if( !((textField_ImageLocation_Update.getText()).equals("")) ) {
				image = textField_ImageLocation_Update.getText();
				image = image.replace("\\", "\\\\");
			 
				this.myController.UpdateMenuItem( id, textName, price, textType, image);
				textField_ImageLocation_Update.setText("");
			}
			else
				this.myController.UpdateMenuItem( id, textName, price, textType);
				
			this.refreshTableUpdate();	
			
			textField_ID_Update.setText(null);
			textField_Price_Update.setText(null);
			textField_Name_Update.setText(null);
			lbl_Photo_update.setIcon(null);
			comboBox_update.setSelectedItem(null);
		}
		
		if(e.getSource() == btnUpdatePhoto) {
		
			try {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File file = chooser.getSelectedFile();
				
				String filename = file.getAbsolutePath();
				textField_ImageLocation_Update.setText(filename);
							
				ImageIcon icon = new ImageIcon(filename);
				Image img = icon.getImage();
				Image imgScale = img.getScaledInstance(lbl_Photo_update.getWidth(), lbl_Photo_update.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon scaledImgIcn = new ImageIcon(imgScale);
				lbl_Photo_update.setIcon(scaledImgIcn);		
			}
			catch(Exception ex) {
				
			}
		}
		
		if(e.getSource() == btnInsert) {	
			double price = 0;			
			
			String textPrice = textField__Price_Insert.getText();
			String textType  = (String)comboBox_insert.getSelectedItem();
			String textName  =  textField__Name_Insert.getText();
			String image = textField_ImageLocation_Insert.getText();
			
			if( textName.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Enter a item Name", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			else  if( textPrice.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Enter a item price", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( textType .equals("select a type") ) {
				JOptionPane.showMessageDialog(this, "Please Select a item type", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( image.equals("") ) {
				JOptionPane.showMessageDialog(this, "Please Enter a image", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			
			try {
				price = Double.parseDouble( textPrice );				
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Inputs are not Valid, Please Check Again ", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}			
									
			image = image.replace("\\", "\\\\");			
			this.myController.insertMenuItem(textName, price, textType, image);
			
			textField_ImageLocation_Insert.setText("");	
			textField__Price_Insert.setText(null);
			textField__Name_Insert.setText(null);
			lbl_PhotoInserted.setIcon(null);	
			refreshComboBox();
		}
		
		if(e.getSource() == btnChoose_Insert ) {			
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			try {
				File file = chooser.getSelectedFile();
				
				String filename = file.getAbsolutePath();
				textField_ImageLocation_Insert.setText(filename);				
				
				ImageIcon icon = new ImageIcon(filename);
				Image img = icon.getImage();
				Image imgScale = img.getScaledInstance(lbl_PhotoInserted.getWidth(), lbl_PhotoInserted.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon scaledImgIcn = new ImageIcon(imgScale);
				lbl_PhotoInserted.setIcon(scaledImgIcn);	
			
			}catch(Exception exception) {
				
			}
		}
		
		if(e.getSource() == btnRefresh_update ) {
			this.refreshTableUpdate();			
		}
		
		if(e.getSource() == btnRefreshT_Delete ) {
			this.refreshTableDelete();
		}
		if(e.getSource() == btnRefreshSearch ) {
			this.refreshTableSearch();
		}
		
		if(e.getSource() == btnDelete) {
			int id = Integer.parseInt(textField_ID_Delete.getText());			
			this.myController.DeleteMenuItem(id);
						
			this.refreshTableDelete();	
			
			textField_ID_Delete.setText(null);
			textField__Name_Delete.setText(null);
			textField_Price_Delete.setText(null);
			textField_Type_Delete.setText(null);
			lbl_Photo_delete.setIcon(null);
		}		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource() == textFieldSearch_Delete) {
			String searchType = (String)comboBox_Search_Delete.getSelectedItem();
			String id = textFieldSearch_Delete.getText();
			rs = myController.searchMenuData(searchType, id);						
			tableDelete.setModel(DbUtils.resultSetToTableModel(rs));					
		}
		
		if(e.getSource() == textFieldSearch_Update) {
			String searchType = (String)comboBoxSearch_Update.getSelectedItem();
			String id = textFieldSearch_Update.getText();
			rs = myController.searchMenuData(searchType, id);						
			tableUpdate.setModel(DbUtils.resultSetToTableModel(rs));					
		}	
		
		if(e.getSource() == textFieldSearch_Search) {
			String searchType = (String)comboBox_Search_Search.getSelectedItem();
			String id = textFieldSearch_Search.getText();
			rs = myController.searchMenuData(searchType, id);						
			tableSearch.setModel(DbUtils.resultSetToTableModel(rs));					
		}		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

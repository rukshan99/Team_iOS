package com.view.frontend;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.controller.Controller;
import com.models.Menu;
import com.models.Order;
import com.view.JTableModel;
import com.view.Mng;
import com.view.backend.MainUserInterface;
import com.view.backend.MngEmployee;
import com.view.frontend.JobDone;

import net.proteanit.sql.DbUtils;

import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableColumn;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
//import java.text.MessageFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.BorderLayout;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.JSeparator;
import java.awt.Button;
import java.awt.List;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import java.awt.TextArea;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import java.awt.Rectangle;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;

public class MngOrder extends JPanel implements Mng,MouseListener, KeyListener, ActionListener{
	
	public static Boolean orderUpdate = false;
	
	private int noOfMenuList;
	private Controller myController;
	private MainUserInterface myMainInterface;
	
	private DefaultTableModel modelTable;
	
	private Integer[][] menuListId;
	
	private static final byte search = 1;
	private static final byte insert = 2;
	private static final byte delete = 3;
	private static final byte update = 4;
	
	private static byte option;
	
	private JLayeredPane layeredPane;
	private JPanel panelSearch,panelInsert,panelDelete,panelUpdate;
	private JTextField textField_orderID_update;
	private JTextField textField_staffName_update;
	private JTextField textField_price_update;
	private JLabel lblStaffID;
	private JPanel panel_1;
	private JTextField textField_staffID_update;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3_3;
	private JLabel lblNewLabel_3_4;
	private JLabel lblNewLabel_3_2_2;
	private JTextField textField_ID_delete;
	private JButton btnDelete;
	private JPanel panel_1_2;
	private JTextField textField_staffName_delete;
	private JPanel panel_1_1_3;
	private JPanel panel_1_1_4;
	private JTextField textField_price_delete;
	private JTextField textField_status_delete;
	private JLabel lblNewLabel_5;
	private JPanel panel_5;
	private JTextField textField_staffId_delete;
	private JTable table_Delete;
	private JTextField textField_Search_delete;
	private JTextField textField_Search_update;
	private JTable table_update;
	private JButton btnUpdate;
	private JButton btnRefresh_update; 
	private JButton btnBack_View;
	private JComboBox comboBox_UPDATE;
	private JButton btnRefresh_Delete;
	private ResultSet rs;
	private JPanel panel_9;
	private JScrollPane scrollPane_4;
	private JTable tableItemList_Insert;
	private JScrollPane scrollPaneItemList_Insert;
	private JLabel lblNewLabel;
	private JLabel textFieldSubTotal;
	private JLabel lblDiscount;
	private JLabel lblNewLabel_1;
	private JLabel textFieldDiscount;
	private JLabel textFieldGrandTotal;
	private JLabel lblOrderUpdate;
	private JButton btnBackUpdate;
	private JButton btnBackDelete;
	private JButton btnBackInsert;
	private JTable tableInsert;
	private JList list;
	private JRadioButton rdbDineIN,rdbTakeAway,rdbDelivery; 
	private ButtonGroup bg;
	private JButton btnEditItem_Insert;
	private JButton btnDeleteItem_Insert;	
	private JButton btnConfirmOrder_Insert;
	private JPanel panel_2;
	private JButton btnRefresh_view;
	private JTextField textField_view;
	private JComboBox comboBox_view;
	private JLabel lblNewLabel_3;
	private JTable table_search_view;
	private JButton btnEditOrderDetail_Update;
	private JButton btnNewOrderInsert;
	private JButton btnEditDeliverStat;
	
	/**
	 * Create the panel.
	 */
	public MngOrder(Controller myController,MainUserInterface myMainInterface) {
		
		this.myController = myController;
		this.myMainInterface = myMainInterface;
				
		setBounds(0, 0,1366, 768);
		setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1366, 768);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelSearch = new JPanel();
		layeredPane.add(panelSearch, "name_554747890563400");
		panelSearch.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 0, 900, 729);
		panelSearch.add(panel_6);
		panel_6.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.YELLOW, null, null));
		panel_2.setBounds(27, 135, 654, 546);
		panel_6.add(panel_2);
		panel_2.setLayout(null);
		
		btnRefresh_view = new JButton("REFRESH");
		btnRefresh_view.addActionListener(this) ;
		btnRefresh_view.setBounds(485, 498, 96, 23);
		panel_2.add(btnRefresh_view);
		
		textField_view = new JTextField();
		textField_view.addKeyListener(this);
		textField_view.setBounds(277, 85, 258, 30);
		textField_view.setColumns(10);
		panel_2.add(textField_view);
		
		comboBox_view = new JComboBox();
		comboBox_view.setModel(new DefaultComboBoxModel(new String[] {"id", "staffid"}));
		comboBox_view.setBounds(134, 85, 133, 30);
		panel_2.add(comboBox_view);
		
		lblNewLabel_3 = new JLabel("Search By");
		lblNewLabel_3.setBounds(50, 85, 119, 30);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(34, 167, 579, 280);
		panel_2.add(scrollPane_2);
		
		table_search_view = new JTable();
		scrollPane_2.setViewportView(table_search_view);
		
		btnBack_View = new JButton("Go Back");
		btnBack_View.addActionListener(this);
		btnBack_View.setBounds(567, 25, 114, 37);
		panel_6.add(btnBack_View);
		
		JLabel lblNewLabel_3_1 = new JLabel("VIEW ORDER DETAILS");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(35, 39, 269, 56);
		panel_6.add(lblNewLabel_3_1);
		
		panelInsert = new JPanel();
		layeredPane.add(panelInsert, "name_554750887143200");
		panelInsert.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 0, 1352, 729);
		panelInsert.add(panel_8);
		panel_8.setLayout(null);
		
		panel_9 = new JPanel();
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, null, null));
		panel_9.setBounds(0, 106, 226, 595);
		panel_8.add(panel_9);
		panel_9.setLayout(null);
		
		Choice choice = new Choice();
		choice.setBounds(24, 21, 178, 20);
		panel_9.add(choice);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.RED);
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 60, 258, 14);
		panel_9.add(separator);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 114, 206, 239);
		panel_9.add(scrollPane_3);
		
		list = new JList();
		list.addMouseListener(this);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"All", "Rice", "Sandwich", "Burger", "Soft Drinks", "Desserts", "Sri Lankan Breakfast", "Smoothy", "Chocolate Drinks", "Faluda", "Omelette", "BBQ chicken", "Chopsuey"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(list);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_4.setBounds(231, 106, 555, 595);
		panel_8.add(scrollPane_4);
		
		tableInsert = new JTable();		
		tableInsert.addMouseListener(this);
		tableInsert.setRowSelectionAllowed(false);
		tableInsert.setCellSelectionEnabled(true);
		scrollPane_4.setViewportView(tableInsert);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.DARK_GRAY, null, null));
		panel_11.setBounds(791, 106, 561, 595);
		panel_8.add(panel_11);
		panel_11.setLayout(null);
		
		scrollPaneItemList_Insert = new JScrollPane();
		scrollPaneItemList_Insert.setBounds(0, 0, 559, 470);
		panel_11.add(scrollPaneItemList_Insert);
		
		tableItemList_Insert = new JTable();
		tableItemList_Insert.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableItemList_Insert.addMouseListener(this);
		scrollPaneItemList_Insert.setViewportView(tableItemList_Insert);
		
		lblNewLabel = new JLabel("SUB TOTAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(10, 512, 84, 22);
		panel_11.add(lblNewLabel);
		
		textFieldSubTotal = new JLabel();			
		textFieldSubTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldSubTotal.setForeground(Color.GREEN);
		textFieldSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSubTotal.setBounds(389, 513, 168, 20);
		panel_11.add(textFieldSubTotal);		
		
		lblDiscount = new JLabel("DISCOUNT");
		lblDiscount.setBackground(Color.ORANGE);
		lblDiscount.setFont(new Font("Sylfaen", Font.BOLD, 11));
		lblDiscount.setBounds(10, 535, 84, 22);
		panel_11.add(lblDiscount);
		
		lblNewLabel_1 = new JLabel("GRAND TOTAL");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 556, 105, 28);
		panel_11.add(lblNewLabel_1);
		
		textFieldDiscount = new JLabel();		
		textFieldDiscount.setForeground(new Color(0, 0, 0));
		textFieldDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDiscount.setBounds(389, 536, 168, 20);
		panel_11.add(textFieldDiscount);
		textFieldDiscount.setText("0");
		
		textFieldGrandTotal = new JLabel();
		textFieldGrandTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldGrandTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGrandTotal.setForeground(Color.GREEN);	
		textFieldGrandTotal.setBounds(389, 562, 168, 20);
		panel_11.add(textFieldGrandTotal);
		
		btnDeleteItem_Insert = new JButton("Delete Iem");
		btnDeleteItem_Insert.addActionListener(this);
		btnDeleteItem_Insert.setBounds(10, 478, 89, 23);
		panel_11.add(btnDeleteItem_Insert);
		
		btnEditItem_Insert = new JButton("Edit Item");
		btnEditItem_Insert.addActionListener(this); 
		btnEditItem_Insert.setBounds(109, 478, 89, 23);
		panel_11.add(btnEditItem_Insert);
		
		btnConfirmOrder_Insert = new JButton("Confirm Order");
		btnConfirmOrder_Insert.addActionListener(this);
		btnConfirmOrder_Insert.setBounds(389, 479, 168, 23);
		panel_11.add(btnConfirmOrder_Insert);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1352, 26);
		panel_8.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		btnBackInsert = new JButton("Go Back");
		btnBackInsert.addActionListener(this);
		btnBackInsert.setBounds(1219, 45, 108, 38);
		panel_8.add(btnBackInsert);
		
		rdbDineIN = new JRadioButton("Dine In");
		rdbDineIN .addActionListener(this);
		rdbDineIN.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbDineIN.setBounds(6, 52, 85, 23);
		panel_8.add(rdbDineIN);
		
		rdbTakeAway = new JRadioButton("Take Away");
		rdbTakeAway.addActionListener(this);
		rdbTakeAway.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbTakeAway.setBounds(108, 52, 118, 23);
		panel_8.add(rdbTakeAway);
		
		rdbDelivery = new JRadioButton("Delivery");
		rdbDelivery.addActionListener(this);
		rdbDelivery.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbDelivery.setBounds(250, 52, 118, 23);
		panel_8.add(rdbDelivery);
		
		bg = new ButtonGroup();
		bg.add(rdbDelivery);
		bg.add(rdbDineIN);
		bg.add(rdbTakeAway);
		
		btnNewOrderInsert = new JButton("New Order");
		btnNewOrderInsert.addActionListener(this);
		btnNewOrderInsert.setBounds(1073, 45, 108, 38);
		panel_8.add(btnNewOrderInsert);
		
		panelDelete = new JPanel();
		layeredPane.add(panelDelete, "name_554753847466800");
		panelDelete.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 2, 1352, 727);
		panelDelete.add(panel_3);
		panel_3.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ORDER DELETE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(0, 255, 0), new Color(0, 0, 0), new Color(255, 0, 0)), new MatteBorder(11, 11, 11, 11, (Color) new Color(0, 255, 255)))));
		panel_4.setBounds(46, 176, 418, 507);
		panel_3.add(panel_4);
		
		lblNewLabel_2 = new JLabel("Order ID ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(67, 95, 101, 32);
		panel_4.add(lblNewLabel_2);
		
		lblNewLabel_3_3 = new JLabel("Staff Name");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_3.setBounds(67, 150, 101, 32);
		panel_4.add(lblNewLabel_3_3);
		
		lblNewLabel_3_4 = new JLabel("Total Price");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_4.setBounds(70, 268, 101, 32);
		panel_4.add(lblNewLabel_3_4);
		
		lblNewLabel_3_2_2 = new JLabel("Order States");
		lblNewLabel_3_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_2.setBounds(71, 328, 101, 32);
		panel_4.add(lblNewLabel_3_2_2);
		
		textField_ID_delete = new JTextField();
		textField_ID_delete.setBackground(Color.GRAY);
		textField_ID_delete.setEditable(false);
		textField_ID_delete.setColumns(10);
		textField_ID_delete.setBounds(187, 94, 164, 32);
		panel_4.add(textField_ID_delete);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(this);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(149, 420, 146, 32);
		panel_4.add(btnDelete);
		
		panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.GREEN);
		panel_1_2.setBounds(187, 176, 164, 4);
		panel_4.add(panel_1_2);
		
		textField_staffName_delete = new JTextField();
		textField_staffName_delete.setBackground(Color.GRAY);
		textField_staffName_delete.setEditable(false);
		textField_staffName_delete.setColumns(10);
		textField_staffName_delete.setBounds(187, 149, 164, 32);
		panel_4.add(textField_staffName_delete);
		
		panel_1_1_3 = new JPanel();
		panel_1_1_3.setBackground(Color.GREEN);
		panel_1_1_3.setBounds(192, 350, 164, 4);
		panel_4.add(panel_1_1_3);
		
		panel_1_1_4 = new JPanel();
		panel_1_1_4.setBackground(Color.GREEN);
		panel_1_1_4.setBounds(191, 296, 164, 4);
		panel_4.add(panel_1_1_4);
		
		textField_price_delete = new JTextField();
		textField_price_delete.setBackground(Color.GRAY);
		textField_price_delete.setEditable(false);
		textField_price_delete.setColumns(10);
		textField_price_delete.setBounds(191, 269, 164, 32);
		panel_4.add(textField_price_delete);
		
		textField_status_delete = new JTextField();
		textField_status_delete.setBackground(Color.GRAY);
		textField_status_delete.setEditable(false);
		textField_status_delete.setColumns(10);
		textField_status_delete.setBounds(192, 324, 164, 32);
		panel_4.add(textField_status_delete);
		
		lblNewLabel_5 = new JLabel("Staff ID ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(68, 210, 101, 32);
		panel_4.add(lblNewLabel_5);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.GREEN);
		panel_5.setBounds(188, 237, 164, 4);
		panel_4.add(panel_5);
		
		textField_staffId_delete = new JTextField();
		textField_staffId_delete.setBackground(Color.GRAY);
		textField_staffId_delete.setEditable(false);
		textField_staffId_delete.setColumns(10);
		textField_staffId_delete.setBounds(188, 210, 164, 32);
		panel_4.add(textField_staffId_delete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(554, 226, 729, 394);
		panel_3.add(scrollPane);
		
		table_Delete = new JTable();
		table_Delete.addMouseListener(this); 
		scrollPane.setViewportView(table_Delete);
		
		JLabel lblNewLabel_1_1 = new JLabel("Search By Order ID");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(747, 164, 146, 26);
		panel_3.add(lblNewLabel_1_1);
		
		textField_Search_delete = new JTextField();
		textField_Search_delete.addKeyListener(this);
		textField_Search_delete.setColumns(10);
		textField_Search_delete.setBounds(916, 166, 216, 26);
		panel_3.add(textField_Search_delete);
		
		btnRefresh_Delete = new JButton("Refresh");
		btnRefresh_Delete.addActionListener(this);
		btnRefresh_Delete.setBounds(722, 657, 107, 26);
		panel_3.add(btnRefresh_Delete);
		
		btnBackDelete = new JButton("Go Back");
		btnBackDelete.addActionListener(this);
		btnBackDelete.setBounds(1143, 46, 114, 37);
		panel_3.add(btnBackDelete);
		
		JLabel lblNewLabel_4 = new JLabel("Order Delete");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_4.setBounds(64, 61, 235, 37);
		panel_3.add(lblNewLabel_4);
		
		panelUpdate = new JPanel();
		layeredPane.add(panelUpdate, "name_554757834715500");
		panelUpdate.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 1, 1352, 728);
		panelUpdate.add(panel);
		panel.setLayout(null);
		
		JPanel panelUpdateOrder = new JPanel();
		panelUpdateOrder.setLayout(null);
		panelUpdateOrder.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Order Update", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(0, 255, 0), new Color(0, 0, 0), new Color(255, 0, 0)), new MatteBorder(11, 11, 11, 11, (Color) new Color(0, 255, 255)))));
		panelUpdateOrder.setBounds(71, 116, 434, 507);
		panel.add(panelUpdateOrder);
		
		JLabel lblOrderId = new JLabel("Order ID ");
		lblOrderId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOrderId.setBounds(67, 95, 101, 32);
		panelUpdateOrder.add(lblOrderId);
		
		JLabel lblStaffName = new JLabel("Staff Name");
		lblStaffName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStaffName.setBounds(67, 150, 101, 32);
		panelUpdateOrder.add(lblStaffName);
		
		JLabel lblNewLabel_3_2 = new JLabel("Total Price");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(70, 268, 101, 32);
		panelUpdateOrder.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Order States");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1.setBounds(71, 328, 101, 32);
		panelUpdateOrder.add(lblNewLabel_3_2_1);
		
		textField_orderID_update = new JTextField();
		textField_orderID_update.setBackground(Color.GRAY);
		textField_orderID_update.setEditable(false);
		textField_orderID_update.setColumns(10);
		textField_orderID_update.setBounds(187, 94, 164, 32);
		panelUpdateOrder.add(textField_orderID_update);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(this);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(149, 420, 146, 32);
		panelUpdateOrder.add(btnUpdate);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GREEN);
		panel_1_1.setBounds(187, 176, 164, 4);
		panelUpdateOrder.add(panel_1_1);
		
		textField_staffName_update = new JTextField();
		textField_staffName_update.setBackground(Color.GRAY);
		textField_staffName_update.setEditable(false);
		textField_staffName_update.setColumns(10);
		textField_staffName_update.setBounds(187, 149, 164, 32);
		panelUpdateOrder.add(textField_staffName_update);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(Color.GREEN);
		panel_1_1_1.setBounds(191, 296, 164, 4);
		panelUpdateOrder.add(panel_1_1_1);
		
		textField_price_update = new JTextField();
		textField_price_update.setBackground(Color.GRAY);
		textField_price_update.setEditable(false);
		textField_price_update.setColumns(10);
		textField_price_update.setBounds(191, 269, 164, 32);
		panelUpdateOrder.add(textField_price_update);
		
		lblStaffID = new JLabel("Staff ID ");
		lblStaffID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStaffID.setBounds(68, 210, 101, 32);
		panelUpdateOrder.add(lblStaffID);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(188, 237, 164, 4);
		panelUpdateOrder.add(panel_1);
		
		textField_staffID_update = new JTextField();
		textField_staffID_update.setBackground(Color.GRAY);
		textField_staffID_update.setEditable(false);
		textField_staffID_update.setColumns(10);
		textField_staffID_update.setBounds(188, 210, 164, 32);
		panelUpdateOrder.add(textField_staffID_update);
		
		comboBox_UPDATE = new JComboBox();
		comboBox_UPDATE.setEditable(true);
		comboBox_UPDATE.setModel(new DefaultComboBoxModel(new String[] {"Active", "Closed", "Cancelled"}));
		comboBox_UPDATE.setSelectedItem(null);
		comboBox_UPDATE.setBounds(191, 336, 164, 24);
		panelUpdateOrder.add(comboBox_UPDATE);
		
		btnEditOrderDetail_Update = new JButton("Edit Order Details");
		btnEditOrderDetail_Update.addActionListener(this);
		btnEditOrderDetail_Update.setBounds(132, 386, 190, 23);
		panelUpdateOrder.add(btnEditOrderDetail_Update);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Search By Order ID");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(739, 129, 152, 32);
		panel.add(lblNewLabel_1_1_1);
		
		textField_Search_update = new JTextField();
		textField_Search_update.addKeyListener(this);
		textField_Search_update.setColumns(10);
		textField_Search_update.setBounds(901, 131, 216, 32);
		panel.add(textField_Search_update);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(575, 183, 677, 389);
		panel.add(scrollPane_1);
		
		table_update = new JTable();
		table_update.addMouseListener(this); 
		scrollPane_1.setViewportView(table_update);
		
		btnRefresh_update = new JButton("Refresh");
		btnRefresh_update.addActionListener(this);
		btnRefresh_update.setBounds(672, 597, 107, 26);
		panel.add(btnRefresh_update);
		
		lblOrderUpdate = new JLabel("Order Update");
		lblOrderUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOrderUpdate.setBounds(71, 29, 157, 44);
		panel.add(lblOrderUpdate);
		
		btnBackUpdate = new JButton("Go Back");
		btnBackUpdate.addActionListener(this);
		btnBackUpdate.setBounds(1145, 43, 107, 38);
		panel.add(btnBackUpdate);		
		
		btnEditDeliverStat = new JButton("Edit Delivery Status"); 
		btnEditDeliverStat.addActionListener(this);
		btnEditDeliverStat.setBounds(210, 662, 175, 23);
		panel.add(btnEditDeliverStat);

		 lookAndFeelYellowBack();
	}
	
	public void lookAndFeelYellowBack() {
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
	}	
	
	public Double getTextFieldSubTotal() {
		return Double.parseDouble( textFieldSubTotal.getText() );
	}

	public Double getTextFieldDiscount() {
		return Double.parseDouble( textFieldDiscount.getText() );
	}

	public Double getTextFieldGrandTotal() {
		return Double.parseDouble( textFieldGrandTotal.getText() );
	}

	public void setTextFieldSubTotal(Double textFieldSubTotal) {
		this.textFieldSubTotal.setText(Double.toString(textFieldSubTotal));
	}

	public void setTextFieldDiscount(Double textFieldDiscount) {
		this.textFieldDiscount.setText(Double.toString(textFieldDiscount));
	}

	public void setTextFieldGrandTotal(Double textFieldGrandTotal) {
		this.textFieldGrandTotal.setText(Double.toString(textFieldGrandTotal));
	}

	public void showOption(byte option) {
		layeredPane.setVisible(true);
		
		switch(option) {
			case search :  this.refreshTableSearch();
				panelSearch.setVisible(true);
				panelInsert.setVisible(false);
				panelDelete.setVisible(false);
				panelUpdate.setVisible(false);
				
				break;
				
			case insert : 	this.refreshTableInsert("All");				
				this.myController.createOrder();
				panelSearch.setVisible(false);
				panelInsert.setVisible(true);
				panelDelete.setVisible(false);
				panelUpdate.setVisible(false);		
				
				break;
				
			case delete :  this.refreshTableDelete();
				panelSearch.setVisible(false);
				panelInsert.setVisible(false);
				panelDelete.setVisible(true);
				panelUpdate.setVisible(false);
				
				break;	
			
			case update :  this.refreshTableUpdate();			
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
				panelSearch.setVisible(false);
				panelInsert.setVisible(false);
				panelDelete.setVisible(false);
				panelUpdate.setVisible(true);
				
				break;					
		}
	}
	
	public void calcTotal() {		
		double subTot = Math.round(myController.getGrandTot() * 100) / 100.0;
		
		this.setTextFieldSubTotal(subTot);
		this.setTextFieldGrandTotal( this.getTextFieldSubTotal() - this.getTextFieldDiscount() );		
	}
	
	public void setMenuListTable_InsertToUpdate(ArrayList<String[]> det) {		
		
		for(String[] s : det) {
		
			int id = Integer.parseInt( s[0].toString() );
			String name = s[1].toString();
			int q = Integer.parseInt( s[2].toString() );
			double price = Double.parseDouble( s[3].toString() );
			
			
		}
	}
	
	public void refreshMenuListTable_Insert() {
		noOfMenuList = 0;
		String[] column = {"No","ID","Name","Quantity","Item Price","Total"};		
		
		modelTable = new DefaultTableModel();
		modelTable.setColumnIdentifiers(column);
		
		this.tableItemList_Insert.setModel(modelTable);
		tableItemList_Insert.getColumnModel().getColumn(0).setPreferredWidth(27);
		tableItemList_Insert.getColumnModel().getColumn(1).setPreferredWidth(51);
		tableItemList_Insert.getColumnModel().getColumn(2).setPreferredWidth(180);
		tableItemList_Insert.getColumnModel().getColumn(3).setPreferredWidth(71);
		tableItemList_Insert.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableItemList_Insert.getColumnModel().getColumn(5).setPreferredWidth(130);
		
	}
	
	public void addToMenuListTable_Insert(Menu myMenuItem, int quantity) {
		int x;
		noOfMenuList++;
		
		Object[] row = new Object[6];
			
		row[0] = noOfMenuList;
		row[1] = myMenuItem.getItemID();
		row[2] = myMenuItem.getItemName();
		row[3] = quantity;
		row[4] = myMenuItem.getItemPrice();
		row[5] = Double.parseDouble(row[3].toString()) * Double.parseDouble(row[4].toString()); 	
		
		modelTable.addRow(row);
	}
	
	public void resetMenuListTable_Insert(Menu myMenuItem) {	
		int i;
					
		for(i = 0; i < tableItemList_Insert.getRowCount(); i++) {	
			
			if( Integer.parseInt(tableItemList_Insert.getValueAt(i, 1).toString()) == myMenuItem.getItemID()) {	
				int correction = Integer.parseInt(tableItemList_Insert.getValueAt(i, 3).toString()) + 1;								
				tableItemList_Insert.setValueAt(correction, i, 3);
				
				double correcrTot = (Double)( Integer.parseInt(tableItemList_Insert.getValueAt(i, 3).toString()) * Double.parseDouble(tableItemList_Insert.getValueAt(i, 4).toString()) );
				tableItemList_Insert.setValueAt(correcrTot, i, 5);
			}			
		}		
	}
	
	public ArrayList<String[]> getOrderDetails() {
		int x;
		ArrayList<String[]> orderDetail = new ArrayList();
		String[] s; 
		
		for(x = 0; x < tableItemList_Insert.getRowCount(); x++) {	
			s = new String[5];
			
			s[0] = tableItemList_Insert.getValueAt(x, 1).toString();
			s[1] = tableItemList_Insert.getValueAt(x, 2).toString();
			s[2] = tableItemList_Insert.getValueAt(x, 3).toString();
			s[3] = tableItemList_Insert.getValueAt(x, 4).toString();
			s[4] = tableItemList_Insert.getValueAt(x, 5).toString();
			
			orderDetail.add(s);
		}
		
		return orderDetail;
	}
	
	public void refreshTableInsert(String type) {				
		ArrayList<Menu> myMenu = myController.showMenu(type);
		this.menuListId = new Integer[(myMenu.size()/4) + 1][4];	
		
		int x = 0,y = 0;	
		String[] column = {"","","",""};
		Object[][] row = new Object[(myMenu.size()/4) + 1][4];
		
		for( Menu menu : myMenu) {
			String filepath = new String(menu.getImage());
			ImageIcon icon = new ImageIcon(filepath);
			Image img = icon.getImage();
			Image imgScale = img.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
			ImageIcon scaledImgIcn = new ImageIcon(imgScale);
						
			row[x][y] = scaledImgIcn;
			menuListId[x][y] = menu.getItemID();
			y++;
			
			if(y == 4) {
				y = 0;
				x++;
			}
		}		
		
		JTableModel model = new JTableModel(column,row);
		this.tableInsert.setModel(model);
		this.tableInsert.setRowHeight(121);
	}	
	
	public void refreshTableDelete() {
		rs = myController.refreshOrderData();
		this.table_Delete.setModel(DbUtils.resultSetToTableModel(rs));
		textField_staffName_delete.setText(null);
		textField_staffId_delete.setText(null);
		textField_price_delete.setText(null);
		textField_status_delete.setText(null);
		textField_ID_delete.setText(null);
	}
	
	public void refreshTableUpdate() {
		rs = myController.refreshOrderData();
		this.table_update.setModel(DbUtils.resultSetToTableModel(rs));
		textField_orderID_update.setText(null);
		textField_staffName_update.setText(null);
		textField_staffID_update.setText(null);
		textField_price_update.setText(null);
		comboBox_UPDATE.setSelectedItem(null);
	}
	
	public void refreshTableSearch() {
		rs = myController.refreshOrderData();
		this.table_search_view.setModel(DbUtils.resultSetToTableModel(rs));
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBackUpdate || e.getSource() == btnBackDelete || e.getSource() == btnBack_View) {	
			this.lookAndFeelYellowBack();
			this.myMainInterface.goBack();
		}
		
		if(e.getSource() == btnEditDeliverStat) {	
			myMainInterface.setVisible(false);
			JobDone jb= new JobDone(myMainInterface,myController);
			jb.setVisible(true);
		}
		
		if(e.getSource() == rdbDineIN) {
			this.myController.setOrderType(MainUserInterface.getOrdertypedinein());
		}
		
		if(e.getSource() == rdbDelivery) {
			Delivery.hasOrder = true;
			this.myController.setOrderType(MainUserInterface.getOrdertypedelivery());
		}
		
		if(e.getSource() == rdbTakeAway) {
			this.myController.setOrderType(MainUserInterface.getOrdertypetakeaway());
		}
		
		if(e.getSource() == btnBackInsert) {
			if(orderUpdate == true) {
				panelSearch.setVisible(false);
				panelInsert.setVisible(false);
				panelDelete.setVisible(false);
				panelUpdate.setVisible(true);
				
				return;
			}
			
			int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back!! Current order status cancelled", "Order Cancel", JOptionPane.YES_OPTION);
			
			if(confirm == 0) {
				this.setTextFieldSubTotal(0.0);
				this.setTextFieldGrandTotal(0.0);
				this.myMainInterface.goBack();
			}	
		}
		
		if(e.getSource() == btnUpdate) {
			
			String textStaffName = textField_staffName_update.getText();
			String textID  =  textField_staffID_update.getText();
			String textPrice  =  textField_price_update.getText();
			String textStatus =  (String)comboBox_UPDATE.getSelectedItem();
			
			if( textField_orderID_update.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please Select A Data To Update", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			
			int orderID  = Integer.parseInt(textField_orderID_update.getText());
			int staffid  = Integer.parseInt(textField_staffID_update.getText());
			String name = textStaffName;
			double price = 0.0;
			try {
				 price = Double.parseDouble( textPrice );
			}catch(Exception exp) {
				JOptionPane.showMessageDialog(this, "Invalid Price", "Input Error", JOptionPane.WARNING_MESSAGE);
			}
			byte status = 0;
			
			if( textStatus.equalsIgnoreCase("Active") ) {
				status = Order.ORDER_ACTIVE;
			}else if( textStatus.equalsIgnoreCase("Closed") ) {
				status = Order.ORDER_CLOSED;
			}else if( textStatus.equalsIgnoreCase("Cancelled") ) {
				status = Order.ORDER_CANCELED;
			}						
					 
			this.myController.UpdateOrder( orderID, name, staffid, price, status);	
			
			textField_staffName_update.setText(null);
			textField_staffID_update.setText(null);
			textField_price_update.setText(null);
			comboBox_UPDATE.setSelectedItem(null);
			textField_orderID_update.setText(null);
		}
		
		if(e.getSource() == btnRefresh_update) { 			
			refreshTableUpdate();
		}	
		
		if(e.getSource() == btnRefresh_Delete) {			
			refreshTableDelete();
		}
		
		if(e.getSource() == btnRefresh_view) {			
			refreshTableSearch();
		}				
		
		if(e.getSource() == btnDelete) {
			
			if((textField_ID_delete.getText()).equals("")) {
				JOptionPane.showMessageDialog(this, "Select Order From the Table", "Notice", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			int id = Integer.parseInt(textField_ID_delete.getText());			
			this.myController.DeleteOrder(id);
			this.refreshTableDelete();
			
			
			textField_staffName_delete.setText(null);
			textField_staffId_delete.setText(null);
			textField_price_delete.setText(null);
			textField_status_delete.setText(null);
		}		
		
		if(e.getSource() == btnDeleteItem_Insert) {
			
			int row;
			int id;
			int count;
			
			try {					
				row =  tableItemList_Insert.getSelectedRow();				
				id = Integer.parseInt( tableItemList_Insert.getValueAt(row,  1).toString() );	
				count = this.tableItemList_Insert.getRowCount();				
				
				this.myController.deleteFromOrder(new Menu(id));	
				this.modelTable.removeRow(row);							
				
				this.calcTotal();
				
				for(noOfMenuList = row; noOfMenuList < count; noOfMenuList++) {
					row++;
					this.tableItemList_Insert.setValueAt(row, noOfMenuList, 0);				
				}
			}
			catch(Exception ex) {
				
			}				
		}  
		
		if(e.getSource() == btnEditItem_Insert) {
			int row;
			int id;
			
			try {					
				row =  tableItemList_Insert.getSelectedRow();
				id = Integer.parseInt( tableItemList_Insert.getValueAt(row,  1).toString() );
				
				String quantity = JOptionPane.showInputDialog(this, "Input the Quantity : ");
				tableItemList_Insert.setValueAt(Integer.parseInt(quantity), row, 3);
				
				double tot = ( Double.parseDouble( tableItemList_Insert.getValueAt(row,  4).toString() ) * Double.parseDouble(quantity) ); 
				tableItemList_Insert.setValueAt(tot, row, 5);
				
				this.myController.setOrder(new Menu(id), Integer.parseInt(quantity));
				this.calcTotal();
			}
			catch(Exception ex) {
				
			}				
		} 
		
		if(e.getSource() == btnConfirmOrder_Insert) {
			int orderType = myController.getOrderType(); 
			
			if(orderUpdate == true) {
				panelSearch.setVisible(false);
				panelInsert.setVisible(false);
				panelDelete.setVisible(false);
				panelUpdate.setVisible(true);
				
				textField_price_update.setText(textFieldGrandTotal.getText());				
				
				this.myController.DeleteOrder(Integer.parseInt( textField_orderID_update.getText() ));
				this.myController.insertOrderDetail(this.getOrderDetails());
				
				refreshTableUpdate();
				orderUpdate = false;
			}
			else if(orderType == 1 || orderType == 2) {
				this.myController.insertOrderDetail(this.getOrderDetails());
				this.myMainInterface.makeBill();					
			}
			else if(orderType == 3) {
				this.myMainInterface.setDeliveryTotal(getTextFieldGrandTotal());
				this.myMainInterface.changeOrderType(MainUserInterface.getOrdertypedelivery());
			}
			else {
				JOptionPane.showMessageDialog(this, "Please select the Order Type", "Confirming Order", JOptionPane.INFORMATION_MESSAGE);
			}				
		}
		
		if(e.getSource() == btnEditOrderDetail_Update) {
			orderUpdate = true;
			
			int id;
			int staffId;
			Menu menu;
			
			if((textField_orderID_update.getText()).equals("")) {
				JOptionPane.showMessageDialog(this, "Select Order From the Table", "Notice", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			id = Integer.parseInt(textField_orderID_update.getText());			
						
			try {
				ArrayList<String[]> det = myController.getDetailsExistingOrder( id );
				staffId = Integer.parseInt( det.get(0)[5].toString() );
			
				showOption(insert);
				refreshMenuListTable_Insert();
				
					myController.createOrder(id, staffId);
					
					for(String[] s : det) {
						
						int menuId = Integer.parseInt( s[0].toString() );
						String name = s[1].toString();
						int q = Integer.parseInt( s[2].toString() );
						double price = Double.parseDouble( s[3].toString() );
						
						menu = new Menu(menuId, name, price, null);
						myController.addToOrder(menu,q);
						this.addToMenuListTable_Insert(menu,q);
					}
					
					this.calcTotal();
			}catch(Exception g) {
				JOptionPane.showMessageDialog(this, "ORDER DATA NOT FOUND ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource() == btnNewOrderInsert) {
			this.myController.createOrder();
			refreshMenuListTable_Insert();
			
			calcTotal();
		}
	}	

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getSource() == textField_Search_update ) {
			
			String id = textField_Search_update.getText();
			rs = myController.searchOrderData( id);						
				
			table_update.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		if(e.getSource() == textField_Search_delete ) {
			
			String id = textField_Search_delete.getText();
			rs = myController.searchOrderData( id);						
				
			table_Delete.setModel(DbUtils.resultSetToTableModel(rs));
		}		
		
		if(e.getSource() == textField_view) {
			String searchType = (String)comboBox_view.getSelectedItem();
			String id = textField_view.getText();
			rs = myController.searchOrderData(searchType, id);						
			table_search_view.setModel(DbUtils.resultSetToTableModel(rs));					
		}
	}		
	
	@Override
	public void mouseClicked(MouseEvent e ) {
		
		if( e.getSource() == table_update ) {			
			int row = table_update.getSelectedRow();
			int ID = Integer.parseInt((table_update.getValueAt(row, 0)).toString());			
			
			Order order = this.myController.getOrderData(ID);
			
			textField_orderID_update.setText(Integer.toString(order.getOrderID()));
			textField_price_update.setText(Double.toString(order.getGrandTotal()));	
			try {
			
				textField_staffID_update.setText(Integer.toString(order.getStaffID()));
				if(order.getStaffName().equals("")){
					textField_staffName_update.setText("NULL");
				}else
					textField_staffName_update.setText(order.getStaffName());
			}
			catch(Exception v){
				textField_staffID_update.setText("No Longer Exists");
				textField_staffName_update.setText("No Longer Exists");
			}
			
			String status =  null;;
			if( order.getOrderState() == Order.ORDER_ACTIVE ) {
				status = "Active";
			}else if(order.getOrderState() == Order.ORDER_CLOSED)  {
				status = "Closed";
			}else if(order.getOrderState() == Order.ORDER_CANCELED )  {
				status = "Cancelled";
			}
			
			comboBox_UPDATE.setSelectedItem(status);			
		}	
		
		if( e.getSource() == table_Delete) {
			int row = table_Delete.getSelectedRow();
			int ID = Integer.parseInt((table_Delete.getValueAt(row, 0)).toString());			
			
			Order order = this.myController.getOrderData(ID);
			
			textField_ID_delete.setText(Integer.toString(order.getOrderID()));			
			textField_staffId_delete.setText(Integer.toString(order.getStaffID()));
			textField_price_delete.setText(Double.toString(order.getGrandTotal()));	
			textField_staffName_delete.setText(order.getStaffName());
			
			String status =  null;;
			if( order.getOrderState() == Order.ORDER_ACTIVE ) {
				status = "Active";
			}else if(order.getOrderState() == Order.ORDER_CLOSED)  {
				status = "Closed";
			}else if(order.getOrderState() == Order.ORDER_CANCELED )  {
				status = "Cancelled";
			}
			
			textField_status_delete.setText(status);
		}	
		
		if( e.getSource() == tableInsert) {
			int row = tableInsert.getSelectedRow();
			int column = tableInsert.getSelectedColumn();			
			
			if(menuListId[row][column] == null) {
				return;
			}
			
			Menu menu = this.myController.getMenuData(menuListId[row][column]);
			boolean notFound = this.myController.addToOrder(menu,1);
			
			if(notFound) {
				this.addToMenuListTable_Insert(menu,1);
			}else {
				this.resetMenuListTable_Insert(menu);
			}
			
			this.calcTotal();
		}
		
		if( e.getSource() == list) {
			String type = (String)list.getSelectedValue();
			this.refreshTableInsert(type);			
		}		
	}	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

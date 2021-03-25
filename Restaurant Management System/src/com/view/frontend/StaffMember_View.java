package com.view.frontend;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;

import java.awt.Component;
import java.awt.CardLayout;
import javax.swing.border.EtchedBorder;

import com.controller.Controller;
import com.view.EmployeeInterface;
import com.view.PanelButtonMouseAdapter;
import com.view.backend.MainUserInterface;
import com.view.backend.MngEmployee;

import java.awt.BorderLayout;
import java.awt.SystemColor;

public class StaffMember_View extends JPanel implements EmployeeInterface{	
	private MainUserInterface myMainInterface;
	private Controller myController;	
	private JPanel menu;
	private JPanel orderDetail;
	private JPanel logOut;
	private JLabel lblMenu;	
	private JLabel lblOrderDetails;
	private JLabel lblOut;	
	
	//Labels for date,time restaurent name
	private JLabel lblRestaurantName;
	private JLabel lblTime;
	private JLabel lblDate;
	
	private JLabel lblIdName;
	
	private JPanel dineIn;
	private JPanel takeAway; 
	private JPanel delivery;
	private JLabel lblDineIN;
	private JLabel lblTakeAway;	
	private JLabel lblDelivery;
	private JLabel lblStore_10,lblStore_11,lblStore_12;
	
	//Layered Pane and Panels
	private JLayeredPane layeredPane;
	private JPanel orderDetailsPanel;
	private JPanel menuPanel;
	
	private JLabel lblMenuPanel;
	private JLabel lblOrderPanel;
		
	private JPanel searchMenu;	
	private JPanel insertMenu;
	private JPanel deleteMenu;
	private JPanel updateMenu;
	private JLabel lblSearchMenu;
	private JLabel lblInsertMenu;	
	private JLabel lblDeleteMenu;	
	private JLabel lblUpdateMenu;	
		
	private JPanel searchOrder;
	private JPanel insertOrder;
	private JPanel deleteOrder;
	private JPanel updateOrder;
	private JLabel lblInsertOrder;
	private JLabel lblSearchOrder;
	private JLabel lblDeleteOrder;
	private JLabel lblUpdateOrder;	
	
	//Setup Background Image attributes 
	private JPanel panel;
	private JLabel lblManagerPanelImage;
	
	
	 /**
	 * Create the panel.
	 */
	public StaffMember_View(MainUserInterface myMainInterface, Controller myController) {
		
		this.myMainInterface = myMainInterface;
		this.myController = myController;
				
		addMouseListener(new PanelButtonMouseAdapter(this,this));
		setFocusTraversalPolicyProvider(true);		
		setBounds(0, 0, 1366, 768);	
		setLayout(null);
		
		logOut = new JPanel();
		logOut.setLayout(null);
		logOut.setBackground(new Color(0, 0, 0, 0));
		logOut.setBounds(10, 553, 715, 55);
		logOut.addMouseListener(new PanelButtonMouseAdapter(logOut,this));
		add(logOut);
		
		lblOut = new JLabel("Log Out");
		lblOut.setForeground(Color.GREEN);
		lblOut.setFont(new Font("Chaparral Pro", Font.BOLD, 40));
		lblOut.setBounds(209, 0, 368, 55);
		logOut.add(lblOut);
				
		orderDetail = new JPanel();
		orderDetail.setLayout(null);
		orderDetail.setBackground(new Color(0, 0, 0, 0));
		orderDetail.setBounds(10, 395, 715, 55);
		orderDetail.addMouseListener(new PanelButtonMouseAdapter(orderDetail,this));
		add(orderDetail);
		
		lblOrderDetails = new JLabel("Order Details");
		lblOrderDetails.setForeground(Color.GREEN);
		lblOrderDetails.setFont(new Font("Chaparral Pro", Font.BOLD, 40));
		lblOrderDetails.setBounds(209, 0, 368, 55);
		orderDetail.add(lblOrderDetails);
		
		menu = new JPanel();
		menu.setLayout(null);
		menu.setBackground(new Color(0, 0, 0, 0));
		menu.setBounds(10, 243, 715, 55);
		menu.addMouseListener(new PanelButtonMouseAdapter(menu,this));
		add(menu);
		
		lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.GREEN);
		lblMenu.setFont(new Font("Chaparral Pro", Font.BOLD, 40));
		lblMenu.setBounds(209, 0, 369, 55);
		menu.add(lblMenu);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(756, 158, 592, 568);
		layeredPane.setBackground(new Color(0, 0, 0, 0));
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.setVisible(false);
		
		menuPanel = new JPanel();
		menuPanel.setBackground(new Color(0, 0, 0, 0));
		layeredPane.add(menuPanel, "name_62903482836600");
		menuPanel.setLayout(null);
		
		lblMenuPanel = new JLabel("Menu");
		lblMenuPanel.setForeground(new Color(255, 0, 255));
		lblMenuPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPanel.setBounds(10, 5, 572, 72);
		lblMenuPanel.setFont(new Font("Sitka Subheading", Font.BOLD, 54));
		menuPanel.add(lblMenuPanel);
		
		searchMenu = new JPanel();
		searchMenu.setBackground(new Color(0, 0, 0, 0));
		searchMenu.setBounds(149, 97, 344, 55);
		menuPanel.add(searchMenu);
		searchMenu.addMouseListener(new PanelButtonMouseAdapter(searchMenu,this));
		searchMenu.setLayout(null);
		
		lblSearchMenu = new JLabel("Show Menu");
		lblSearchMenu.setForeground(Color.CYAN);
		lblSearchMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchMenu.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblSearchMenu.setBounds(10, 0, 324, 55);
		searchMenu.add(lblSearchMenu);
		
		insertMenu = new JPanel();
		insertMenu .setBackground(new Color(0, 0, 0, 0));
		insertMenu.setBounds(149, 202, 344, 55);
		menuPanel.add(insertMenu);
		insertMenu.addMouseListener(new PanelButtonMouseAdapter(insertMenu,this));
		insertMenu.setLayout(null);
		
		lblInsertMenu = new JLabel("Edit Menu");
		lblInsertMenu.setForeground(Color.CYAN);
		lblInsertMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertMenu.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblInsertMenu.setBounds(10, 0, 324, 55);
		insertMenu.add(lblInsertMenu);
		
		deleteMenu = new JPanel();
		deleteMenu.setBackground(new Color(0, 0, 0, 0));
		deleteMenu.setBounds(149, 313, 344, 55);
		menuPanel.add(deleteMenu);
		deleteMenu.addMouseListener(new PanelButtonMouseAdapter(deleteMenu,this));
		deleteMenu.setLayout(null);
		
		lblDeleteMenu = new JLabel("Delete Menu");
		lblDeleteMenu.setForeground(Color.CYAN);
		lblDeleteMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteMenu.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblDeleteMenu.setBounds(10, 0, 324, 55);
		deleteMenu.add(lblDeleteMenu);
		
		updateMenu = new JPanel();
		updateMenu.setBackground(new Color(0, 0, 0, 0));
		updateMenu.setBounds(149, 426, 344, 55);
		menuPanel.add(updateMenu);
		updateMenu.addMouseListener(new PanelButtonMouseAdapter(updateMenu,this));
		updateMenu.setLayout(null);
		
		lblUpdateMenu = new JLabel("Update Menu");
		lblUpdateMenu.setForeground(Color.CYAN);
		lblUpdateMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateMenu.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblUpdateMenu.setBounds(10, 0, 324, 55);
		updateMenu.add(lblUpdateMenu);
		
		orderDetailsPanel = new JPanel();
		orderDetailsPanel.setForeground(Color.CYAN);
		orderDetailsPanel.setBackground(new Color(0, 0, 0, 0));
		layeredPane.add(orderDetailsPanel, "name_62915648566600");
		orderDetailsPanel.setLayout(null);
		
		lblOrderPanel = new JLabel("Orders");
		lblOrderPanel.setForeground(new Color(255, 0, 255));
		lblOrderPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderPanel.setBounds(10, 5, 572, 72);
		lblOrderPanel.setFont(new Font("Sitka Subheading", Font.BOLD, 54));
		orderDetailsPanel.add(lblOrderPanel);
		
		searchOrder = new JPanel();
		searchOrder.setBackground(new Color(0, 0, 0, 0));
		searchOrder.setBounds(149, 97, 344, 55);
		orderDetailsPanel.add(searchOrder);
		searchOrder.addMouseListener(new PanelButtonMouseAdapter(searchOrder,this));
		searchOrder.setLayout(null);
		
		lblSearchOrder = new JLabel("Order Details");
		lblSearchOrder.setForeground(Color.CYAN);
		lblSearchOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchOrder.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblSearchOrder.setBounds(10, 0, 324, 55);
		searchOrder.add(lblSearchOrder);
		
		insertOrder = new JPanel();
		insertOrder.setBackground(new Color(0, 0, 0, 0));
		insertOrder.setBounds(149, 202, 344, 55);
		orderDetailsPanel.add(insertOrder);
		insertOrder.addMouseListener(new PanelButtonMouseAdapter(insertOrder,this));
		insertOrder.setLayout(null);
		
		lblInsertOrder = new JLabel("Add Orders");
		lblInsertOrder.setForeground(Color.CYAN);
		lblInsertOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertOrder.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblInsertOrder.setBounds(10, 0, 324, 55);
		insertOrder.add(lblInsertOrder);
		
		deleteOrder = new JPanel();
		deleteOrder.setBackground(new Color(0, 0, 0, 0));
		deleteOrder.setBounds(149, 313, 344, 55);
		orderDetailsPanel.add(deleteOrder);
		deleteOrder.addMouseListener(new PanelButtonMouseAdapter(deleteOrder,this));
		deleteOrder.setLayout(null);
		
		lblDeleteOrder = new JLabel("Delete Orders");
		lblDeleteOrder.setForeground(Color.CYAN);
		lblDeleteOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteOrder.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblDeleteOrder.setBounds(10, 0, 324, 55);
		deleteOrder.add(lblDeleteOrder);
		
		updateOrder = new JPanel();
		updateOrder.setBackground(new Color(0, 0, 0, 0));
		updateOrder.setBounds(149, 426, 344, 55);
		orderDetailsPanel.add(updateOrder);
		updateOrder.addMouseListener(new PanelButtonMouseAdapter(updateOrder,this));
		updateOrder.setLayout(null);
		
		lblUpdateOrder = new JLabel("Update Orders");
		lblUpdateOrder.setForeground(Color.CYAN);
		lblUpdateOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateOrder.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblUpdateOrder.setBounds(10, 0, 324, 55);
		updateOrder.add(lblUpdateOrder);
		
		dineIn = new JPanel();
		dineIn.setBackground(new Color(0, 0, 0, 0));
		dineIn.setBounds(34, 92, 145, 49);
		dineIn.addMouseListener(new PanelButtonMouseAdapter(dineIn,this));
		add(dineIn);
		dineIn.setLayout(null);
		
		lblDineIN = new JLabel("Dine In");
		lblDineIN.setForeground(Color.YELLOW);
		lblDineIN.setHorizontalAlignment(SwingConstants.CENTER);
		lblDineIN.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDineIN.setBounds(10, 0, 125, 49);
		dineIn.add(lblDineIN);
		
		takeAway = new JPanel();
		takeAway.setBackground(new Color(0, 0, 0, 0));
		takeAway.setBounds(247, 92, 145, 49);
		takeAway.addMouseListener(new PanelButtonMouseAdapter(takeAway,this));
		add(takeAway);
		takeAway.setLayout(null);
		
		lblTakeAway = new JLabel("Take Away");
		lblTakeAway.setForeground(Color.YELLOW);
		lblTakeAway.setHorizontalAlignment(SwingConstants.CENTER);
		lblTakeAway.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTakeAway.setBounds(10, 0, 125, 49);
		takeAway.add(lblTakeAway);
		
		delivery = new JPanel();
		delivery.setBackground(new Color(0, 0, 0, 0));
		delivery.setBounds(456, 92, 145, 49);
		delivery.addMouseListener(new PanelButtonMouseAdapter(delivery,this));
		add(delivery);
		delivery.setLayout(null);
		
		lblDelivery = new JLabel("Delivery");
		lblDelivery.setForeground(Color.YELLOW);
		lblDelivery.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelivery.setBounds(10, 0, 125, 49);
		delivery.add(lblDelivery);
		//showTime();
		
		lblRestaurantName = new JLabel();
		lblRestaurantName.setForeground(Color.CYAN);
		lblRestaurantName.setText("Restaurent Name");
		lblRestaurantName.setBounds(0, 0, 1001, 59);
		add(lblRestaurantName);
		lblRestaurantName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		
		lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTime.setForeground(Color.CYAN);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTime.setBounds(1146, 1, 202, 49);
		add(lblTime);
		
		lblDate = new JLabel();
		lblDate.setText("Date");
		lblDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDate.setForeground(Color.CYAN);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblDate.setBounds(943, 0, 193, 50);
		add(lblDate);
		
		lblIdName = new JLabel();
		lblIdName.setText("User ID Name");
		lblIdName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIdName.setForeground(Color.YELLOW);
		lblIdName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIdName.setBounds(747, 75, 601, 52);
		add(lblIdName);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1366, 768);
		add(panel);
		
		lblStore_10 = new JLabel("");
		lblStore_10.setHorizontalAlignment(SwingConstants.CENTER);		
		lblStore_10.setBounds(162, 100, 46, 33);
		panel.add(lblStore_10);
		
		lblStore_11 = new JLabel("");		
		lblStore_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblStore_11.setBounds(385, 100, 46, 33);
		panel.add(lblStore_11);
		
		lblStore_12 = new JLabel("");		
		lblStore_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblStore_12.setBounds(593, 100, 46, 33);
		panel.add(lblStore_12);
		
		lblManagerPanelImage = new JLabel();
		lblManagerPanelImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerPanelImage.setBounds(0, 0, 1366, 768);
		panel.add(lblManagerPanelImage);	
		
		ImageIcon icon = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Pictures\\12.jpg");
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(lblManagerPanelImage.getWidth(), lblManagerPanelImage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledImgIcn = new ImageIcon(imgScale);
		lblManagerPanelImage.setIcon(scaledImgIcn);
		
		ImageIcon icon1 = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Icons PNG\\1.png");
		Image img1 = icon1.getImage();
		Image imgScale1 = img1.getScaledInstance(lblStore_10.getWidth(), lblStore_10.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledImgIcn1 = new ImageIcon(imgScale1);
		lblStore_10.setIcon(scaledImgIcn1);
		
		ImageIcon icon2 = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Icons PNG\\2.png");
		Image img2 = icon2.getImage();
		Image imgScale2 = img2.getScaledInstance(lblStore_11.getWidth(), lblStore_11.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledImgIcn2 = new ImageIcon(imgScale2);
		lblStore_11.setIcon(scaledImgIcn2);
		
		ImageIcon icon3 = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Icons PNG\\3.png");
		Image img3 = icon3.getImage();
		Image imgScale3 = img3.getScaledInstance(lblStore_12.getWidth(), lblStore_12.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledImgIcn3 = new ImageIcon(imgScale3);
		lblStore_12.setIcon(scaledImgIcn3);
	}
	
	public void setRestaurentName() {
		lblRestaurantName.setText(this.myController.getRestaurentName());
	}
	
	public void setUserIdName() {
		lblIdName.setText( Integer.toString(this.myController.getCurrentUserId()) + "  " + this.myController.getCurrentUserName() );
	}
		
	public void setDateTime() {
		this.myController.setTime(lblTime);
		this.myController.setDate(lblDate);
	}
	
	public void showLayeredPane(MouseEvent e) {
		layeredPane.setVisible(true);
		
		if(e.getSource() == menu ) {
			menuPanel.setVisible(true);
			orderDetailsPanel.setVisible(false);			
		}
		else if(e.getSource() == orderDetail ) {
			menuPanel.setVisible(false);
			orderDetailsPanel.setVisible(true);				
		}			
		else if(e.getSource() == logOut) {
			this.myController.logOut();		
		}
		else if(e.getSource() == searchOrder) {
			this.myMainInterface.changeStaffMemberOptions(this.myMainInterface.getSearchorder());			
		}
		else if(e.getSource() == insertOrder) {
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
			this.myMainInterface.refreshMenuListTable();
			this.myController.setOrderType(0);
			this.myMainInterface.changeStaffMemberOptions(this.myMainInterface.getInsertorder());				
		}
		else if(e.getSource() == deleteOrder) {
			this.myMainInterface.changeStaffMemberOptions(this.myMainInterface.getDeleteorder());				
		}
		else if(e.getSource() == updateOrder) {
			this.myMainInterface.changeStaffMemberOptions(this.myMainInterface.getUpdateorder());				
		}
		else if(e.getSource() == delivery) {
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
			this.myController.setOrderType(3);
			this.myMainInterface.changeOrderType(this.myMainInterface.getOrdertypedelivery());				
		}
		else if(e.getSource() == dineIn) {
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
			this.myController.setOrderType(1);
			this.myMainInterface.changeOrderType(this.myMainInterface.getOrdertypedinein());				
		}
		else if(e.getSource() == takeAway) {
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
			this.myController.setOrderType(2);
			this.myMainInterface.changeOrderType(this.myMainInterface.getOrdertypetakeaway());				
		}
		else
			layeredPane.setVisible(false);
		
	}	
}


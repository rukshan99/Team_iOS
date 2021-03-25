package com.view.backend;

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
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

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
import com.utill.DBUtill;
import com.view.EmployeeInterface;
import com.view.PanelButtonMouseAdapter;
import com.view.frontend.Delivery;
import com.view.frontend.StockView;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.BorderLayout;
import java.awt.SystemColor;

public class Manager_View extends JPanel implements EmployeeInterface,ActionListener{	
	private MainUserInterface myMainInterface;
	private Controller myController;
	
	private JPanel empMng;
	private JPanel genReport;
	private JPanel store;
	private JPanel settings;
	private JPanel menu;
	private JPanel orderDetail;
	private JPanel logOut;
	
	private JLabel lblEmployeeManagement;	
	private JLabel lblGenerateReport;	
	private JLabel lblStore;	
	private JLabel lblSettings;	
	private JLabel lblMenu;	
	private JLabel lblOrderDetails;
	private JLabel lblOut;	
	
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
	
	
	//Layered Pane and Panels
	private JLayeredPane layeredPane;
	
	private JPanel reportsPanel;
	private JPanel settingsPanel;
	private JPanel orderDetailsPanel;
	private JPanel employeeMngPanel;
	private JPanel menuPanel;
	private JPanel salaryDetailPanel;
	
	private JLabel lblMenuPanel;
	private JLabel lblOrderPanel;
	private JLabel lblSalaryDetail;
	private JLabel lblEmployeeMng;
	private JLabel lblReportPanel;
	private JLabel lblSettingsPanel;
		
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
	
	private JPanel searchEmployee;
	private JPanel insertEmployee;
	private JPanel deleteEmployee;
	private JPanel updateEmployee;
	private JLabel lblSearchEmployee;	
	private JLabel lblInsertEmployee;	
	private JLabel lblDeleteEmployee;	
	private JLabel lblUpdateEmployee;
	
	private JButton stock;
	private JButton btnEmployeeDetReport;
	private JButton btnMenuDetReport;
	private JButton btnOrderDetReport;
	private JButton btnSalaryReport;
	private JButton btnDeliveryReport;
	private JButton btnStockReport;
	
	private JPanel giveAdvance;
	private JPanel giveLoan;
	private JPanel risk;
	private JPanel Other;
	private JLabel lblAdvance;	
	private JLabel lblLoan;	
	private JLabel lblRisk;	
	private JLabel lblOther;
	
	private JPanel addRestrntNme;
	private JLabel lblSetRestaurentName;
	private JPanel addRestrntAddress;
	private JLabel lblSetRestaurentAddress;
	private JPanel addRestrntPhone;
	private JLabel lblSetRestaurentPhone;
	
	//Set up Background Icon
	private JPanel panel;
	private JLabel lblManagerPanelImage;
	private JLabel lblStore_10;
	private JLabel lblStore_11;
	private JLabel lblStore_12;
	
	
	 /**
	 * Create the panel.
	 */
	public Manager_View(MainUserInterface myMainInterface,Controller myController) {
		
		this.myMainInterface = myMainInterface;
		this.myController = myController;
				
		addMouseListener(new PanelButtonMouseAdapter(this,this));
		setFocusTraversalPolicyProvider(true);		
		setBounds(0, 0, 1366, 768);	
		
		setLayout(null);		
		
		stock = new JButton("Stock");
		stock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				myMainInterface.setVisible(false);
				StockView su = new StockView(myMainInterface,myController);
				su.setVisible(true);
				
			}
		});
		stock.setIcon(new ImageIcon("D:\\oop\\Restaurant_Management_System\\Icons PNG\\store-icon.png"));
		stock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		stock.setBounds(655, 72, 124, 69);
		stock.setBackground(new Color(0, 0, 0, 0));
		add(stock);
		
		logOut = new JPanel();
		logOut.setLayout(null);
		logOut.setBackground(new Color(0, 0, 0, 0));
		logOut.setBounds(10, 666, 715, 55);
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
		orderDetail.setBounds(10, 241, 715, 55);
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
		menu.setBounds(10, 158, 715, 55);
		menu.addMouseListener(new PanelButtonMouseAdapter(menu,this));
		add(menu);
		
		lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.GREEN);
		lblMenu.setFont(new Font("Chaparral Pro", Font.BOLD, 40));
		lblMenu.setBounds(209, 0, 369, 55);
		menu.add(lblMenu);
		
		settings = new JPanel();
		settings.setLayout(null);
		settings.setBackground(new Color(0, 0, 0, 0));
		settings.setBounds(10, 583, 715, 55);
		settings.addMouseListener(new PanelButtonMouseAdapter(settings,this));
		add(settings);
		
		lblSettings = new JLabel("Settings");
		lblSettings.setForeground(Color.GREEN);
		lblSettings.setFont(new Font("Chaparral Pro", Font.BOLD, 40));
		lblSettings.setBounds(209, 0, 368, 55);
		settings.add(lblSettings);
		
		store = new JPanel();
		store.setLayout(null);
		store.setBackground(new Color(0, 0, 0, 0));
		store.setBounds(10, 413, 715, 55);
		store.addMouseListener(new PanelButtonMouseAdapter(store,this));
		add(store);
		
		lblStore = new JLabel("Salary Detail");
		lblStore.setForeground(Color.GREEN);
		lblStore.setFont(new Font("Chaparral Pro", Font.BOLD, 40));
		lblStore.setBounds(204, 0, 368, 55);
		store.add(lblStore);
		
		genReport = new JPanel();
		genReport.setLayout(null);
		genReport.setBackground(new Color(0, 0, 0, 0));
		genReport.setBounds(10, 499, 715, 55);
		genReport.addMouseListener(new PanelButtonMouseAdapter(genReport,this));
		add(genReport);
		
		lblGenerateReport = new JLabel("Generate Report");
		lblGenerateReport.setForeground(Color.GREEN);
		lblGenerateReport.setFont(new Font("Chaparral Pro", Font.BOLD, 40));
		lblGenerateReport.setBounds(209, 0, 368, 55);
		genReport.add(lblGenerateReport);
		
		empMng = new JPanel();
		empMng.setLayout(null);
		empMng.setBackground(new Color(0, 0, 0, 0));
		empMng.setBounds(10, 325, 715, 55);
		empMng.addMouseListener(new PanelButtonMouseAdapter(empMng,this));
		add(empMng);
		
		lblEmployeeManagement = new JLabel("Employee Management");
		lblEmployeeManagement.setForeground(Color.GREEN);
		lblEmployeeManagement.setFont(new Font("Chaparral Pro", Font.BOLD, 40));
		lblEmployeeManagement.setBounds(209, 0, 491, 55);
		empMng.add(lblEmployeeManagement);
		
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
		
		employeeMngPanel = new JPanel();
		employeeMngPanel.setForeground(Color.CYAN);
		employeeMngPanel.setBackground(new Color(0, 0, 0, 0));
		layeredPane.add(employeeMngPanel, "name_62919248220300");
		employeeMngPanel.setLayout(null);
		
		lblEmployeeMng = new JLabel("Employee Management");
		lblEmployeeMng.setForeground(new Color(255, 0, 255));
		lblEmployeeMng.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeMng.setBounds(10, 11, 572, 72);
		lblEmployeeMng.setFont(new Font("Sitka Subheading", Font.BOLD, 47));
		employeeMngPanel.add(lblEmployeeMng);
		
		searchEmployee = new JPanel();
		searchEmployee.setBackground(new Color(0, 0, 0, 0));
		searchEmployee.setBounds(149, 97, 344, 55);
		employeeMngPanel.add(searchEmployee);
		searchEmployee.addMouseListener(new PanelButtonMouseAdapter(searchEmployee,this));
		searchEmployee.setLayout(null);
		
		lblSearchEmployee = new JLabel("Search Employee");
		lblSearchEmployee.setForeground(Color.CYAN);
		lblSearchEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchEmployee.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblSearchEmployee.setBounds(10, 0, 324, 55);
		searchEmployee.add(lblSearchEmployee);
		
		insertEmployee = new JPanel();
		insertEmployee.setBackground(new Color(0, 0, 0, 0));
		insertEmployee.setLayout(null);
		insertEmployee.setBounds(149, 202, 344, 55);
		insertEmployee.addMouseListener(new PanelButtonMouseAdapter(insertEmployee,this));
		employeeMngPanel.add(insertEmployee);
		
		lblInsertEmployee = new JLabel("Insert Employee");
		lblInsertEmployee.setForeground(Color.CYAN);
		lblInsertEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertEmployee.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblInsertEmployee.setBounds(10, 0, 324, 55);
		insertEmployee.add(lblInsertEmployee);
		
		deleteEmployee = new JPanel();
		deleteEmployee.setBackground(new Color(0, 0, 0, 0));
		deleteEmployee.setLayout(null);
		deleteEmployee.setBounds(149, 313, 344, 55);
		deleteEmployee.addMouseListener(new PanelButtonMouseAdapter(deleteEmployee,this));
		employeeMngPanel.add(deleteEmployee);
		
		lblDeleteEmployee = new JLabel("Delete Employee");
		lblDeleteEmployee.setForeground(Color.CYAN);
		lblDeleteEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteEmployee.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblDeleteEmployee.setBounds(10, 0, 324, 55);
		deleteEmployee.add(lblDeleteEmployee);
		
		updateEmployee = new JPanel();
		updateEmployee.setBackground(new Color(0, 0, 0, 0));
		updateEmployee.setLayout(null);
		updateEmployee.setBounds(149, 426, 344, 55);
		updateEmployee.addMouseListener(new PanelButtonMouseAdapter(updateEmployee,this));
		employeeMngPanel.add(updateEmployee);
		
		lblUpdateEmployee = new JLabel("Update Employee ");
		lblUpdateEmployee.setForeground(Color.CYAN);
		lblUpdateEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateEmployee.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblUpdateEmployee.setBounds(10, 0, 324, 55);
		updateEmployee.add(lblUpdateEmployee);
		
		salaryDetailPanel = new JPanel();
		salaryDetailPanel.setBackground(new Color(0, 0, 0, 0));
		layeredPane.add(salaryDetailPanel, "name_62955001831500");
		salaryDetailPanel.setLayout(null);
		
		lblSalaryDetail = new JLabel("Salary Details");
		lblSalaryDetail.setForeground(new Color(255, 0, 255));
		lblSalaryDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalaryDetail.setBounds(10, 5, 572, 72);
		lblSalaryDetail.setFont(new Font("Sitka Subheading", Font.BOLD, 54));
		salaryDetailPanel.add(lblSalaryDetail);
		
		giveAdvance = new JPanel();
		giveAdvance.setBackground(new Color(0, 0, 0, 0));
		giveAdvance.setBounds(149, 97, 344, 55);
		salaryDetailPanel.add(giveAdvance);
		giveAdvance.addMouseListener(new PanelButtonMouseAdapter(giveAdvance,this));
		giveAdvance.setLayout(null);
		
		lblAdvance = new JLabel("Advance");
		lblAdvance.setForeground(Color.CYAN);
		lblAdvance.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdvance.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblAdvance.setBounds(10, 0, 324, 55);
		giveAdvance.add(lblAdvance);
		
		giveLoan = new JPanel();
		giveLoan.setBackground(new Color(0, 0, 0, 0));
		giveLoan.setLayout(null);
		giveLoan.setBounds(149, 202, 344, 55);
		giveLoan.addMouseListener(new PanelButtonMouseAdapter(giveLoan,this));
		salaryDetailPanel.add(giveLoan);
		
		lblLoan = new JLabel("Loan");
		lblLoan.setForeground(Color.CYAN);
		lblLoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoan.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblLoan.setBounds(10, 0, 324, 55);
		giveLoan.add(lblLoan);
		
		risk = new JPanel();
		risk.setBackground(new Color(0, 0, 0, 0));
		risk.setLayout(null);
		risk.setBounds(149, 313, 344, 55);
		risk.addMouseListener(new PanelButtonMouseAdapter(risk,this));
		salaryDetailPanel.add(risk);
		
		lblRisk = new JLabel("Risk");
		lblRisk.setForeground(Color.CYAN);
		lblRisk.setHorizontalAlignment(SwingConstants.CENTER);
		lblRisk.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblRisk.setBounds(10, 0, 324, 55);
		risk.add(lblRisk);
		
		Other = new JPanel();
		Other.setBackground(new Color(0, 0, 0, 0));
		Other.setLayout(null);
		Other.setBounds(149, 426, 344, 55);
		Other.addMouseListener(new PanelButtonMouseAdapter(Other,this));
		salaryDetailPanel.add(Other);
		
		lblOther = new JLabel("Other");
		lblOther.setForeground(Color.CYAN);
		lblOther.setHorizontalAlignment(SwingConstants.CENTER);
		lblOther.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblOther.setBounds(10, 0, 324, 55);
		Other.add(lblOther);
		
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manager_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manager_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manager_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manager_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		reportsPanel = new JPanel();
		reportsPanel.setBackground(new Color(0, 0, 0, 0));
		layeredPane.add(reportsPanel, "name_62957535129000");
		reportsPanel.setLayout(null);
		
		lblReportPanel = new JLabel("Report");
		lblReportPanel.setForeground(new Color(255, 0, 255));
		lblReportPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportPanel.setBounds(10, 5, 572, 72);
		lblReportPanel.setFont(new Font("Sitka Subheading", Font.BOLD, 54));
		reportsPanel.add(lblReportPanel);
		
		btnEmployeeDetReport = new JButton("Employee Details");
		btnEmployeeDetReport.addActionListener(this); 
		btnEmployeeDetReport.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnEmployeeDetReport.setBounds(223, 101, 188, 38);
		reportsPanel.add(btnEmployeeDetReport);
		
		btnMenuDetReport = new JButton("Menu Items Details");
		btnMenuDetReport.addActionListener(this);
		btnMenuDetReport.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnMenuDetReport.setBounds(223, 182, 188, 38);
		reportsPanel.add(btnMenuDetReport);
		
		btnOrderDetReport = new JButton("Order Detail ");
		btnOrderDetReport.addActionListener(this);
		btnOrderDetReport.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnOrderDetReport.setBounds(223, 267, 188, 38);
		reportsPanel.add(btnOrderDetReport);
		
		btnSalaryReport = new JButton("Salary Report");
		btnSalaryReport.addActionListener(this);
		btnSalaryReport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalaryReport.setBounds(223, 355, 188, 38);
		reportsPanel.add(btnSalaryReport);
		
		
		
		btnDeliveryReport = new JButton("Delivery Details");
		btnDeliveryReport.addActionListener(this);
		btnDeliveryReport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeliveryReport.setBounds(223, 441, 188, 38);
		reportsPanel.add(btnDeliveryReport);
		
		btnStockReport = new JButton("Stock Report");
		btnStockReport.addActionListener(this);
		btnStockReport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStockReport.setBounds(223, 517, 188, 38);
		reportsPanel.add(btnStockReport);
		
		settingsPanel = new JPanel();
		settingsPanel.setBackground(new Color(0, 0, 0, 0));
		layeredPane.add(settingsPanel, "name_62972583832400");
		settingsPanel.setLayout(null);
		
		lblSettingsPanel = new JLabel("Settings");
		lblSettingsPanel.setForeground(new Color(255, 0, 255));
		lblSettingsPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettingsPanel.setBounds(10, 5, 572, 72);
		lblSettingsPanel.setFont(new Font("Sitka Subheading", Font.BOLD, 54));
		settingsPanel.add(lblSettingsPanel);
		
		addRestrntNme = new JPanel();
		addRestrntNme.setBackground(new Color(0, 0, 0, 0));
		addRestrntNme.setBounds(70, 97, 467, 55);
		settingsPanel.add(addRestrntNme);
		addRestrntNme.addMouseListener(new PanelButtonMouseAdapter(addRestrntNme,this));
		addRestrntNme.setLayout(null);
		
		lblSetRestaurentName = new JLabel("Set Up Restaurant Name");
		lblSetRestaurentName.setForeground(Color.CYAN);
		lblSetRestaurentName.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetRestaurentName.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblSetRestaurentName.setBounds(10, 0, 447, 55);
		addRestrntNme.add(lblSetRestaurentName);
		
		addRestrntAddress = new JPanel();
		addRestrntAddress.setLayout(null);
		addRestrntAddress.addMouseListener(new PanelButtonMouseAdapter(addRestrntAddress,this));
		addRestrntAddress.setBackground(new Color(0, 0, 0, 0));
		addRestrntAddress.setBounds(70, 220, 467, 55);
		settingsPanel.add(addRestrntAddress);
		
		lblSetRestaurentAddress = new JLabel("Set Up Restaurant Address");
		lblSetRestaurentAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetRestaurentAddress.setForeground(Color.CYAN);
		lblSetRestaurentAddress.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblSetRestaurentAddress.setBounds(10, 0, 447, 55);
		addRestrntAddress.add(lblSetRestaurentAddress);
		
		addRestrntPhone = new JPanel();
		addRestrntPhone.setLayout(null);
		addRestrntPhone.addMouseListener(new PanelButtonMouseAdapter(addRestrntPhone,this));
		addRestrntPhone.setBackground(new Color(0, 0, 0, 0));
		addRestrntPhone.setBounds(70, 345, 467, 55);
		settingsPanel.add(addRestrntPhone);
		
		lblSetRestaurentPhone = new JLabel("Set Up Restaurant Phone");
		lblSetRestaurentPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetRestaurentPhone.setForeground(Color.CYAN);
		lblSetRestaurentPhone.setFont(new Font("Chaparral Pro", Font.BOLD, 36));
		lblSetRestaurentPhone.setBounds(10, 0, 447, 55);
		addRestrntPhone.add(lblSetRestaurentPhone);
		
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
		/*lblDelivery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myMainInterface.setVisible(false);
				Delivery su = new Delivery(myController,myMainInterface);
				su.setVisible(true);
			}
		});*/
		lblDelivery.setForeground(Color.YELLOW);
		lblDelivery.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelivery.setBounds(10, 0, 125, 49);
		delivery.add(lblDelivery);
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		lblRestaurantName = new JLabel();
		lblRestaurantName.setText("Restaurent name");
		lblRestaurantName.setForeground(Color.CYAN);
		lblRestaurantName.setBounds(0, 0, 1001, 59);
		add(lblRestaurantName);
		lblRestaurantName.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 40));
		
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
		lblIdName.setBounds(815, 92, 533, 49);
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
		lblStore_11.setBounds(385, 100, 46, 33);
		panel.add(lblStore_11);
		
		lblStore_12 = new JLabel("");		
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
			employeeMngPanel.setVisible(false);
			salaryDetailPanel.setVisible(false);
			reportsPanel.setVisible(false);
			settingsPanel.setVisible(false);
		}
		else if(e.getSource() == orderDetail ) {
			
			
			menuPanel.setVisible(false);
			orderDetailsPanel.setVisible(true);
			employeeMngPanel.setVisible(false);
			salaryDetailPanel.setVisible(false);
			reportsPanel.setVisible(false);
			settingsPanel.setVisible(false);
		}
		else if(e.getSource() == empMng) {
			menuPanel.setVisible(false);
			orderDetailsPanel.setVisible(false);
			employeeMngPanel.setVisible(true);
			salaryDetailPanel.setVisible(false);
			reportsPanel.setVisible(false);
			settingsPanel.setVisible(false);
		}
		else if(e.getSource() == store) {
			menuPanel.setVisible(false);
			orderDetailsPanel.setVisible(false);
			employeeMngPanel.setVisible(false);
			salaryDetailPanel.setVisible(true);
			reportsPanel.setVisible(false);
			settingsPanel.setVisible(false);
			
		}
		else if(e.getSource() == genReport) {
			menuPanel.setVisible(false);
			orderDetailsPanel.setVisible(false);
			employeeMngPanel.setVisible(false);
			salaryDetailPanel.setVisible(false);
			reportsPanel.setVisible(true);
			settingsPanel.setVisible(false);
		}		
		else if(e.getSource() == settings) {
			menuPanel.setVisible(false);
			orderDetailsPanel.setVisible(false);
			employeeMngPanel.setVisible(false);
			salaryDetailPanel.setVisible(false);
			reportsPanel.setVisible(false);
			settingsPanel.setVisible(true);
		}
		else if(e.getSource() == logOut) {
			this.myController.logOut();		
		}
		else if(e.getSource() == searchMenu) {
			this.myMainInterface.changeManagerOptions(this.myMainInterface.getSearchmenu());			
		}
		else if(e.getSource() == insertMenu) {
			this.myMainInterface.changeManagerOptions(this.myMainInterface.getInsertmenu());				
		}
		else if(e.getSource() == deleteMenu) {
			this.myMainInterface.changeManagerOptions(this.myMainInterface.getDeletemenu());			
		}
		else if(e.getSource() == updateMenu) {
			this.myMainInterface.changeManagerOptions(this.myMainInterface.getUpdatemenu());			
		}
		else if(e.getSource() == searchEmployee) {
			this.myMainInterface.changeManagerOptions(this.myMainInterface.getSearchemployee());			
		}
		else if(e.getSource() == insertEmployee) {
			this.myMainInterface.changeManagerOptions(this.myMainInterface.getInsertemployee());			
		}
		else if(e.getSource() == deleteEmployee) {
			this.myMainInterface.changeManagerOptions(this.myMainInterface.getDeleteemployee());			
		}
		else if(e.getSource() == updateEmployee) {
			this.myMainInterface.changeManagerOptions(this.myMainInterface.getUpdateemployee());				
		}
		else if(e.getSource() == giveAdvance) {
			this.myMainInterface.changeManagerOptions(this.myMainInterface.getAdvance());					
		}
		else if(e.getSource() == giveLoan) {
			this.myMainInterface.changeManagerOptions(this.myMainInterface.getLoan());					
		}
		else if(e.getSource() == risk) {
			this.myMainInterface.changeManagerOptions(this.myMainInterface.getRisk());			
		}
		else if(e.getSource() == Other) {
			this.myMainInterface.changeManagerOptions(this.myMainInterface.getOther());				
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
			this.myController.setOrderType(0);
			this.myMainInterface.refreshMenuListTable();
			this.myMainInterface.changeStaffMemberOptions(this.myMainInterface.getInsertorder());				
		}
		else if(e.getSource() == deleteOrder) {
			this.myMainInterface.changeStaffMemberOptions(this.myMainInterface.getDeleteorder());				
		}
		else if(e.getSource() == updateOrder) {
			this.myMainInterface.changeStaffMemberOptions(this.myMainInterface.getUpdateorder());				
		}
		else if(e.getSource() == addRestrntNme) {
			String name = JOptionPane.showInputDialog(this, "Please Input The Restaurent Name :");
			
			this.myController.setRestaurentName(name);			
			this.setRestaurentName(); 
		}
		else if(e.getSource() == addRestrntAddress) {
			String address[] = new String[3];
			
			address[0] = JOptionPane.showInputDialog(this, "Please Input The No Of Address :");
			address[1] = JOptionPane.showInputDialog(this, "Please Input The Street Of Address :");
			address[2] = JOptionPane.showInputDialog(this, "Please Input The City Of Address :");
			
			this.myController.setRestaurentAddress(address);			
		}
		else if(e.getSource() == addRestrntPhone) {
			String phone = JOptionPane.showInputDialog(this, "Please Input The Restaurent Phone Number :");
			
			this.myController.setRestaurentPhone(phone);			 
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnEmployeeDetReport) {

			
			Connection con = DBUtill.getConnection();
			 try{
				 
				 	InputStream in = new FileInputStream(new File("D:\\oop\\Restaurant_Management_System\\src\\report\\EmployeeDetails.jrxml"));
		            JasperDesign jd = JRXmlLoader.load(in);
		            String sql= "select * from employee_details group by u_Type,id";
		            		//+ "group by u_Type,id ";
		            //String sql= "select * from menu group by itemtype,id";
		            JRDesignQuery newQuery = new JRDesignQuery();
		            newQuery.setText(sql);
		            jd.setQuery(newQuery);
		            JasperReport jr = JasperCompileManager.compileReport(jd);
		            HashMap para = new HashMap();
		            JasperPrint j = JasperFillManager.fillReport(jr, para,con);
		            JasperViewer.viewReport(j,false);
		    // String report = "D:\\oop\\Restaurant_Management_System\\report\\MenuReport.jrxml";
			/* JasperDesign report = JRXmlLoader.load("D:\\oop\\Restaurant_Management_System\\src\\report\\EmployeeDetails.jrxml");
			 JasperReport jr = JasperCompileManager.compileReport(report);
			 JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
			 JasperViewer.viewReport(jp);*/
	        }catch(Exception ec){
	            JOptionPane.showMessageDialog(null, e);
	            
	        }
		}
		
		if(e.getSource() == btnMenuDetReport) {
			
				Connection con = DBUtill.getConnection();
			 try{
				 
				 	InputStream in = new FileInputStream(new File("D:\\oop\\Restaurant_Management_System\\src\\report\\MenuReport.jrxml"));
		            JasperDesign jd = JRXmlLoader.load(in);
		            String sql= "select * from menu group by itemtype,id ";
		            
		            JRDesignQuery newQuery = new JRDesignQuery();
		            newQuery.setText(sql);
		            jd.setQuery(newQuery);
		            JasperReport jr = JasperCompileManager.compileReport(jd);
		            HashMap para = new HashMap();
		            JasperPrint j = JasperFillManager.fillReport(jr, para,con);
		            JasperViewer.viewReport(j,false);
			/* String report = "D:\\oop\\Restaurant_Management_System\\report\\MenuReport.jrxml";
			 JasperReport jr = JasperCompileManager.compileReport(report);
			 JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
			 JasperViewer.viewReport(jp);*/
	        }catch(Exception ec){
	            JOptionPane.showMessageDialog(null, e);
	            
	        }
		}

		if(e.getSource() == btnOrderDetReport) {
				Connection con = DBUtill.getConnection();
			 try{
				 

				 	InputStream in = new FileInputStream(new File("D:\\oop\\Restaurant_Management_System\\src\\report\\Invoice.jrxml"));
		            JasperDesign jd = JRXmlLoader.load(in);
		            String sql= "select o.id,o.staffid,e.fname,m.itemname,m.itemprice,o.status,o.datetime,od.quantity,o.total\r\n" + 
		            		" from orderdetail od,myorder o,menu m,employee_details e \r\n" + 
		            		" where od.orderid = o.id AND od.menuid=m.id AND o.staffid = e.id ";
		            
		            JRDesignQuery newQuery = new JRDesignQuery();
		            newQuery.setText(sql);
		            jd.setQuery(newQuery);
		            JasperReport jr = JasperCompileManager.compileReport(jd);
		            HashMap para = new HashMap();
		            JasperPrint j = JasperFillManager.fillReport(jr, para,con);
		            JasperViewer.viewReport(j,false);
			 /*String report = "D:\\oop\\Restaurant_Management_System\\report\\Invoice.jrxm";
			 JasperReport jr = JasperCompileManager.compileReport(report);
			 JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
			 JasperViewer.viewReport(jp);*/
	        }catch(Exception ec){
	            JOptionPane.showMessageDialog(null, e);
	            
	        }
		}
		
		if(e.getSource() == btnSalaryReport) {
			Connection con = DBUtill.getConnection();
		 try{
			 

			 	InputStream in = new FileInputStream(new File("D:\\oop\\Restaurant_Management_System\\src\\report\\Salary.jrxml"));
	            JasperDesign jd = JRXmlLoader.load(in);
	            String sql= "select e.id,e.fname,e.lname,s.salary,s.hours,s.emonth,d.risk,d.other,d.advance,d.loan from salary s,employee_details e ,salarydetail d\r\n" + 
	            		"where e.id = s.eid AND s.eid = d.id ";
	            
	            JRDesignQuery newQuery = new JRDesignQuery();
	            newQuery.setText(sql);
	            jd.setQuery(newQuery);
	            JasperReport jr = JasperCompileManager.compileReport(jd);
	            HashMap para = new HashMap();
	            JasperPrint j = JasperFillManager.fillReport(jr, para,con);
	            JasperViewer.viewReport(j,false);
		 /*String report = "D:\\oop\\Restaurant_Management_System\\report\\Invoice.jrxm";
		 JasperReport jr = JasperCompileManager.compileReport(report);
		 JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
		 JasperViewer.viewReport(jp);*/
        }catch(Exception ec){
            JOptionPane.showMessageDialog(null, e);
            
        }
	}
		
		if(e.getSource() == btnDeliveryReport) {
			Connection con = DBUtill.getConnection();
		 try{
			 

			 	InputStream in = new FileInputStream(new File("D:\\oop\\Restaurant_Management_System\\src\\report\\Delivery.jrxml"));
	            JasperDesign jd = JRXmlLoader.load(in);
	            String sql= "select * from deliveryorder ";
	            
	            JRDesignQuery newQuery = new JRDesignQuery();
	            newQuery.setText(sql);
	            jd.setQuery(newQuery);
	            JasperReport jr = JasperCompileManager.compileReport(jd);
	            HashMap para = new HashMap();
	            JasperPrint j = JasperFillManager.fillReport(jr, para,con);
	            JasperViewer.viewReport(j,false);
		 /*String report = "D:\\oop\\Restaurant_Management_System\\report\\Invoice.jrxm";
		 JasperReport jr = JasperCompileManager.compileReport(report);
		 JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
		 JasperViewer.viewReport(jp);*/
        }catch(Exception ec){
            JOptionPane.showMessageDialog(null, e);
            
        }
	}
		
		if(e.getSource() == btnStockReport) {
			Connection con = DBUtill.getConnection();
		 try{
			 

			 	InputStream in = new FileInputStream(new File("D:\\oop\\Restaurant_Management_System\\src\\report\\Stock.jrxml"));
	            JasperDesign jd = JRXmlLoader.load(in);
	            String sql= "select * from stock ";
	            
	            JRDesignQuery newQuery = new JRDesignQuery();
	            newQuery.setText(sql);
	            jd.setQuery(newQuery);
	            JasperReport jr = JasperCompileManager.compileReport(jd);
	            HashMap para = new HashMap();
	            JasperPrint j = JasperFillManager.fillReport(jr, para,con);
	            JasperViewer.viewReport(j,false);
		 /*String report = "D:\\oop\\Restaurant_Management_System\\report\\Invoice.jrxm";
		 JasperReport jr = JasperCompileManager.compileReport(report);
		 JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
		 JasperViewer.viewReport(jp);*/
        }catch(Exception ec){
            JOptionPane.showMessageDialog(null, e);
            
        }
	}
	}	
}


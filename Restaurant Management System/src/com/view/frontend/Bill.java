package com.view.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controller.Controller;
import com.view.backend.MainUserInterface;
import com.view.backend.MngEmployee;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JScrollPane;


public class Bill extends JDialog implements ActionListener {
	private MainUserInterface myMainInterface;
	private Controller myController;
	
	private final JPanel contentPanel = new JPanel();	
	private JTextArea bill;
	private JButton printButton;
	private JButton cancelButton;

	/**
	 * Create the dialog.
	 */
	public Bill(Controller myController, MainUserInterface myMainInterface) {
		setUndecorated(true);
		setResizable(false);
		this.myController = myController;
		this.myMainInterface = myMainInterface;
		
		setBounds(100, 100, 404, 494);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 404, 411);
		contentPanel.add(scrollPane);
		
		bill = new JTextArea();
		scrollPane.setViewportView(bill);
		bill.setEditable(false);
		bill.setRows(8);
		bill.setColumns(5);	
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
		printButton = new JButton("Print Bill");				
		buttonPane.add(printButton);
		printButton.addActionListener(this);
		getRootPane().setDefaultButton(printButton);
	
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		buttonPane.add(cancelButton);
		
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
		
		billPrint();
	}
	
	private void billPrint() {		
		int x;
		int length = myController.getRestaurentName().length();	
		String[] address = myController.getRestaurentAddress();
		ArrayList<String[]> details = myMainInterface.getOrderDetails();
		
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		String date = s.format(d);
		
		for(x = 0; x < (62 - length); x++) {
			bill.setText(bill.getText() + " ");
		}
		
		bill.setText(bill.getText() + myController.getRestaurentName().toUpperCase() + " \n\n");
		bill.setText(bill.getText() +  address[0].toUpperCase() + ", " + address[1].toUpperCase()  + ", " +  address[2].toUpperCase() + " \n");
		bill.setText(bill.getText() +  "Tel : " + this.myController.getRestaurentPhone() + " "
				+ "                                                            " + "Date : "  + date + "\n");
		
		bill.setText(bill.getText() + "=======================================================\n");
		bill.setText(bill.getText() + "=======================================================\n");
		
		x = 0;
		for(String[] det : details) {
		
			bill.setText(bill.getText() + "  " + (++x) + "   " + det[1].toString() + "\n\t\t\t( " + det[2].toString() + " * " +
															det[3].toString() + " )     " + det[4].toString() + "\n");
		
		
		}	
		
		bill.setText(bill.getText() + "\n\t\t\t    " + "Total    " + myController.getGrandTot() + "\n\n");
		bill.setText(bill.getText() + "=======================================================\n");
		bill.setText(bill.getText() + "=================THANK YOU COME AGAIN=================\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == printButton) {
			try {
				bill.print();
			}catch(PrinterException ex) {
				
			}		
		}
		
		if(e.getSource() == cancelButton) {
			setVisible(false);
		}
	}
}

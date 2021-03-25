package com.view.backend;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.controller.Controller;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class MngSalary extends JPanel implements ActionListener, KeyListener {
	private Controller myController;
	private MainUserInterface myMainInterface;
	
	private String id;
	private DefaultTableModel modelTable;
	private static final byte advance = 1;
	private static final byte loan = 2;
	private static final byte risk = 3;
	private static final byte other = 4;
	
	private static byte option;
	private static ResultSet rs;
	
	private JLayeredPane layeredPane;
	private JPanel panelAdvance,panelLoan,panelRisk,panelOther;
	private JTable tableAdvance;
	private JTextField textFieldOther;
	private JTextField textFieldRisk;
	private JTextField textFieldLoan;
	private JTextField textFieldAdvance;
	
	private JButton btncloseOther;
	private JButton btncloseRisk;
	private JButton btncloseLoan;
	private JButton btncloseAdvance;
	private JButton btnOKOther;
	private JButton btnOKRisk;
	private JButton btnOKLoan;
	private JButton btnOKAdvance;
	private JTextField textFieldAdvanceId;
	private JTextField textFieldLoanId;
	private JTextField textFieldRiskId;
	private JTextField textFieldOtherId;
	private JTable tableLoan;
	private JTable tableRisk;
	private JTable tableOther;
	/**
	 * Create the panel.
	 */
	public MngSalary(Controller myController,MainUserInterface myMainInterface) {
		this.myController = myController;
		this.myMainInterface = myMainInterface;
		
		setBounds(0, 0,1366, 768);
		setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1366, 768);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelAdvance = new JPanel();
		layeredPane.add(panelAdvance, "name_554747890563400");
		panelAdvance.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(0, 0, 799, 293);
		panelAdvance.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 111, 662, 44);
		panel.add(scrollPane);
		
		tableAdvance = new JTable();
		scrollPane.setViewportView(tableAdvance);
		
		textFieldAdvance = new JTextField();
		textFieldAdvance.setColumns(10);
		textFieldAdvance.setBounds(342, 190, 198, 29);
		panel.add(textFieldAdvance);
		
		JLabel lblNewLabel_4 = new JLabel("New Value");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(215, 190, 104, 29);
		panel.add(lblNewLabel_4);
		
		btncloseAdvance = new JButton("X");
		btncloseAdvance.setBackground(Color.RED);
		btncloseAdvance.addActionListener(this);
		btncloseAdvance.setHorizontalAlignment(SwingConstants.CENTER);
		btncloseAdvance.setFont(new Font("Tahoma", Font.BOLD, 14));
		btncloseAdvance.setBounds(753, 3, 43, 41);
		panel.add(btncloseAdvance);
		
		btnOKAdvance = new JButton("OK");
		btnOKAdvance.addActionListener(this);
		btnOKAdvance.setBounds(728, 259, 61, 23);
		panel.add(btnOKAdvance);
		
		textFieldAdvanceId = new JTextField();
		textFieldAdvanceId.addKeyListener(this);		
		textFieldAdvanceId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldAdvanceId.setBounds(570, 59, 86, 20);
		panel.add(textFieldAdvanceId);
		textFieldAdvanceId.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ID :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(537, 59, 23, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Advance");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 15, 155, 26);
		panel.add(lblNewLabel_5);
		
		panelLoan = new JPanel();
		layeredPane.add(panelLoan, "name_554750887143200");
		panelLoan.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 799, 293);
		panelLoan.add(panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(74, 129, 662, 44);
		panel_1.add(scrollPane_1);
		
		tableLoan = new JTable();
		scrollPane_1.setViewportView(tableLoan);
		
		textFieldLoan = new JTextField();
		textFieldLoan.setColumns(10);
		textFieldLoan.setBounds(378, 208, 198, 29);
		panel_1.add(textFieldLoan);
		
		JLabel lblNewLabel_2 = new JLabel("New Value");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(260, 208, 108, 29);
		panel_1.add(lblNewLabel_2);
		
		btncloseLoan = new JButton("X");
		btncloseLoan.setBackground(Color.RED);
		btncloseLoan.addActionListener(this);
		btncloseLoan.setHorizontalAlignment(SwingConstants.CENTER);
		btncloseLoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btncloseLoan.setBounds(753, 3, 43, 37);
		panel_1.add(btncloseLoan);
		
		btnOKLoan = new JButton("OK");
		btnOKLoan.addActionListener(this);
		btnOKLoan.setBounds(728, 259, 61, 23);
		panel_1.add(btnOKLoan);
		
		JLabel lblNewLabel_6 = new JLabel("Loan");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 13, 151, 29);
		panel_1.add(lblNewLabel_6);
		
		textFieldLoanId = new JTextField();
		textFieldLoanId.addKeyListener(this);		
		textFieldLoanId.setBounds(566, 76, 86, 20);
		panel_1.add(textFieldLoanId);
		textFieldLoanId.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel(" ID :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(527, 75, 37, 20);
		panel_1.add(lblNewLabel_7);
		
		panelRisk = new JPanel();
		panelRisk.setBorder(null);
		layeredPane.add(panelRisk, "name_554753847466800");
		panelRisk.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2.setLayout(null);
		panel_2.setBounds(0, 0, 799, 293);
		panelRisk.add(panel_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(68, 107, 662, 44);
		panel_2.add(scrollPane_2);
		
		tableRisk = new JTable();
		scrollPane_2.setViewportView(tableRisk);
		
		textFieldRisk = new JTextField();
		textFieldRisk.setColumns(10);
		textFieldRisk.setBounds(371, 186, 198, 29);
		panel_2.add(textFieldRisk);
		
		JLabel lblNewLabel_1 = new JLabel("New Value");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(263, 182, 98, 29);
		panel_2.add(lblNewLabel_1);
		
		btncloseRisk = new JButton("X");
		btncloseRisk.addActionListener(this);
		btncloseRisk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btncloseRisk.setBackground(Color.RED);
		btncloseRisk.setBounds(753, 3, 43, 35);
		panel_2.add(btncloseRisk);
		
		btnOKRisk = new JButton("OK");
		btnOKRisk.addActionListener(this);
		btnOKRisk.setBounds(716, 259, 61, 23);
		panel_2.add(btnOKRisk);
		
		JLabel lblNewLabel_8 = new JLabel("ID :");
		lblNewLabel_8.setBounds(544, 52, 31, 23);
		panel_2.add(lblNewLabel_8);
		
		textFieldRiskId = new JTextField();
		textFieldRiskId.addKeyListener(this);
		textFieldRiskId.setColumns(10);
		textFieldRiskId.setBounds(579, 52, 81, 22);
		panel_2.add(textFieldRiskId);
		textFieldRiskId.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Risk");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(10, 9, 144, 29);
		panel_2.add(lblNewLabel_9);
		
		panelOther = new JPanel();
		layeredPane.add(panelOther, "name_554757834715500");
		panelOther.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 799, 293);
		panelOther.add(panel_3);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(65, 125, 662, 44);
		panel_3.add(scrollPane_4);
		
		tableOther = new JTable();
		scrollPane_4.setViewportView(tableOther);
		
		textFieldOther = new JTextField();
		textFieldOther.setBounds(398, 212, 198, 29);
		panel_3.add(textFieldOther);
		textFieldOther.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New Value");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(289, 212, 99, 29);
		panel_3.add(lblNewLabel);
		
		btncloseOther = new JButton("X");
		btncloseOther.setBackground(Color.RED);
		btncloseOther.addActionListener(this);
		btncloseOther.setFont(new Font("Tahoma", Font.BOLD, 14));
		btncloseOther.setBounds(753, 3, 43, 35);
		panel_3.add(btncloseOther);
		
		btnOKOther = new JButton("OK");
		btnOKOther.addActionListener(this);
		btnOKOther.setBounds(703, 259, 61, 23);
		panel_3.add(btnOKOther);
		
		JLabel lblNewLabel_10 = new JLabel("Other");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_10.setBounds(10, 15, 127, 29);
		panel_3.add(lblNewLabel_10);
		
		textFieldOtherId = new JTextField();
		textFieldOtherId.addKeyListener(this);
		textFieldOtherId.setBounds(569, 73, 86, 20);		
		panel_3.add(textFieldOtherId);
		textFieldOtherId.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("ID :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(529, 71, 30, 20);
		panel_3.add(lblNewLabel_11);		
	}
	
	public void showOption(byte option) {
		layeredPane.setVisible(true);
		
		switch(option) {
			case advance :  
				panelAdvance.setVisible(true);
				panelLoan.setVisible(false);
				panelRisk.setVisible(false);
				panelOther.setVisible(false);
				
				break;
				
			case loan :  
				panelAdvance.setVisible(false);
				panelLoan.setVisible(true);
				panelRisk.setVisible(false);
				panelOther.setVisible(false);		
				
				break;
				
			case risk :  
				panelAdvance.setVisible(false);
				panelLoan.setVisible(false);
				panelRisk.setVisible(true);
				panelOther.setVisible(false);
				
				break;	
			
			case other :  
				panelAdvance.setVisible(false);
				panelLoan.setVisible(false);
				panelRisk.setVisible(false);
				panelOther.setVisible(true);
				
				break;					
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {	
			if(e.getSource() == btncloseOther || e.getSource() == btncloseRisk || e.getSource() == btncloseAdvance || e.getSource() == btncloseLoan) {
				myMainInterface.goBack();
			}
			
			if(e.getSource() == btnOKAdvance) {
				int id = Integer.parseInt(textFieldAdvanceId.getText());
				double val = Double.parseDouble(textFieldAdvance.getText());
				
				myController.updateSalAdvance(id, val);
				textFieldAdvanceId.setText(null);
				textFieldAdvance.setText(null);
				tableAdvance.setModel(DbUtils.resultSetToTableModel(rs));
			}
			
			if(e.getSource() == btnOKLoan) {
				int id = Integer.parseInt(textFieldLoanId.getText());
				double val = Double.parseDouble(textFieldLoan.getText());
				
				myController.updateSalLoan(id, val);
				textFieldLoanId.setText(null);
				textFieldLoan.setText(null);
				tableLoan.setModel(DbUtils.resultSetToTableModel(rs));
			}
			
			if(e.getSource() == btnOKRisk) {
				int id = Integer.parseInt(textFieldRiskId.getText());
				double val = Double.parseDouble(textFieldRisk.getText());
				
				myController.updateSalRisk(id, val);
				textFieldRiskId.setText(null);
				textFieldRisk.setText(null);
				tableRisk.setModel(DbUtils.resultSetToTableModel(rs));
			}
			
			if(e.getSource() == btnOKOther) {
				int id = Integer.parseInt(textFieldOtherId.getText());
				double val = Double.parseDouble(textFieldOther.getText());
				
				myController.updateSalOther(id, val);	
				textFieldOtherId.setText(null);
				textFieldOther.setText(null);
				tableOther.setModel(DbUtils.resultSetToTableModel(rs));
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(this, "Please fill the Data first", "Error",JOptionPane.WARNING_MESSAGE);
		}	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		try {	
			if(e.getSource() == textFieldAdvanceId) {					
				id = textFieldAdvanceId.getText();
				rs = myController.searchSalaryData(Integer.parseInt(id));						
				tableAdvance.setModel(DbUtils.resultSetToTableModel(rs));					
			}
			
			if(e.getSource() == textFieldLoanId) {
				id = textFieldLoanId.getText();
				rs = myController.searchSalaryData(Integer.parseInt(id));					
				tableLoan.setModel(DbUtils.resultSetToTableModel(rs));					
			}
			
			if(e.getSource() == textFieldOtherId) {			
				id = textFieldOtherId.getText();
				rs = myController.searchSalaryData(Integer.parseInt(id));					
				tableOther.setModel(DbUtils.resultSetToTableModel(rs));					
			}
			
			if(e.getSource() == textFieldRiskId) {			
				id = textFieldRiskId.getText();
				rs = myController.searchSalaryData(Integer.parseInt(id));						
				tableRisk.setModel(DbUtils.resultSetToTableModel(rs));					
			}
		}catch(Exception ex) {
			//if backspace all integer in each id fields null pointer exception occured
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

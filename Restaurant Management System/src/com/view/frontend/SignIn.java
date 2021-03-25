package com.view.frontend;

import com.controller.Controller;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;


public class SignIn extends JFrame implements ActionListener{
	
	private Controller myController;

	private JPanel contentPane;
	private JPanel panel_1,panel;
	private JLabel lblLoginForm,lblLoginPageImage,lblEmployeeId,lblPassword,lblUserType;
	private JPasswordField userPassword;
	private JTextField userId;
	private JButton signIn;
	private Choice choice;
	
	/**
	 * Create the frame.
	 */
	public SignIn(Controller myController) {
		
		this.myController = myController;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 342);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginForm.setForeground(Color.CYAN);
		lblLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblLoginForm.setBackground(new Color(205, 133, 63));
		lblLoginForm.setBounds(0, 0, 413, 58);
		contentPane.add(lblLoginForm);
	
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 0, 20));		
		panel_1.setBounds(10, 69, 393, 223);
		contentPane.add(panel_1);
		
		lblEmployeeId = new JLabel("Employee ID :");
		lblEmployeeId.setForeground(Color.CYAN);
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmployeeId.setBounds(28, 40, 128, 24);
		panel_1.add(lblEmployeeId);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.CYAN);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(28, 128, 128, 24);
		panel_1.add(lblPassword);
		
		userPassword = new JPasswordField();
		userPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		userPassword.setBounds(177, 128, 176, 24);
		panel_1.add(userPassword);
		
		userId = new JTextField();
		userId.setBounds(177, 43, 176, 24);
		userId.setColumns(10);
		panel_1.add(userId);
				
		signIn = new JButton("Sign In");
		signIn.addActionListener(this); 
		signIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signIn.setBounds(154, 177, 89, 23);
		signIn.setBackground(new Color(51, 153, 255));
		panel_1.add(signIn);
		getRootPane().setDefaultButton(signIn);
		
		lblUserType = new JLabel("User Type :");
		lblUserType.setForeground(Color.CYAN);
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserType.setBounds(28, 85, 128, 24);
		panel_1.add(lblUserType);
		
		choice = new Choice();
		choice.setBounds(177, 85, 176, 24);
		choice.add("Admin");
		choice.add("Staff");
		panel_1.add(choice);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 413, 303);
		contentPane.add(panel);
		panel.setLayout(null);
					
		lblLoginPageImage = new JLabel("");
		lblLoginPageImage.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblLoginPageImage.setLabelFor(this);
		lblLoginPageImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPageImage.setBounds(0, 0, 413, 303);
		
		//Scale Image Icon for the size of label and set the label icon
		ImageIcon icon = new ImageIcon("D:\\oop\\Restaurant_Management_System\\Pictures\\4.jpg");
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(lblLoginPageImage.getWidth(), lblLoginPageImage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledImgIcn = new ImageIcon(imgScale);
		lblLoginPageImage.setIcon(scaledImgIcn);
		panel.add(lblLoginPageImage);
			
	}
			
	public void setUserPassword(JPasswordField userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserId(JTextField userId) {
		this.userId = userId;
	}

	
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == signIn) {
			
			boolean isManager;
			char[] password;
			String inputPassword;
			Integer inputId;
			String id;
			
			id = this.userId.getText();			   //declare a new String variable and assigned the value on text area
			
			if(id.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Input Id","Warning!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			try {
				inputId = Integer.parseInt(id);
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(rootPane, "ID contains only numbers");
				return;
			}
			
			password = this.userPassword.getPassword(); //Save the password field characters to a char array
			inputPassword = new String(password);	   //declare a new String variable and assigned the char array which get above
			
			if(choice.getItem(choice.getSelectedIndex()).equals("Admin")) //This will getItem as string value on selected array index
				isManager = true;
				
			else
				isManager = false;
				
			if(inputPassword.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Input Password","Warning!", JOptionPane.WARNING_MESSAGE);
				return;
			}
				
			if( myController.loginCheck(inputId, inputPassword, isManager)) {
				JOptionPane.showMessageDialog(this, "Succesfully Login!!");
				this.userId.setText(null);
				this.userPassword.setText(null);
				this.setVisible(false);
				myController.runMainInterface();
			}
			else {
				JOptionPane.showMessageDialog(this, myController.getErrorMessage(),"Warning!", JOptionPane.WARNING_MESSAGE);
			}
						
		}		

	}
	
	
}

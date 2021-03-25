package com.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.view.backend.Manager_View;
import com.view.frontend.StaffMember_View;

public class PanelButtonMouseAdapter<E> extends MouseAdapter{
	
	E view;
	private JPanel panel;
	
	public PanelButtonMouseAdapter(JPanel panel,E view) {
		this.panel = panel;	
		this.view =view;
	}		
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(view.getClass().getName().equalsIgnoreCase("com.view.backend.Manager_View") )
			((Manager_View) view).showLayeredPane(e);		
		
		else
			((StaffMember_View) view).showLayeredPane(e);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		panel.setBackground(new Color(112, 128, 144, 80));
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		panel.setBackground(new Color(0, 0, 0, 0));
	}
}	
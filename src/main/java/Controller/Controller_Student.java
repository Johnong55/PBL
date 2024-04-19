package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import View.ChangePassword;
import View.ViewStudent;

public class Controller_Student implements ActionListener  {
	private ViewStudent s;

	public Controller_Student(ViewStudent s) {
		super();
		this.s = s;
	}
	public void setPanel_4() {
		s.panel_4.removeAll();
		s.panel_4.revalidate();
		s.panel_4.repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == s.BtnHome)
			
		{
			setPanel_4();
			s.view_home(); 
			
		}
		else if(e.getSource() == s.btnTests)
		{
			
			setPanel_4();
			s.view_test();
		}	
			
		else if(e.getSource() == s.btnProfile) 
		{
			
			setPanel_4();
			s.view_profile();
		}
			
		else if(e.getSource() == s.btnChangePer)
		{
			
			ChangePassword frame = new ChangePassword();
			frame.setVisible(true);
			// Trong phần tạo form mới
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


		}	
		
		s.panel_4.setBounds(171, 0, 713, 661); 
	}
}

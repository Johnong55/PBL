package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.MatteBorder;

import View.viewLogin;
public class Controller_Login implements MouseListener{
	private viewLogin v ;
	MatteBorder border1 = new MatteBorder(0,0,2,0,Color.BLUE);
	MatteBorder border2 =new MatteBorder(0,0,1,0,Color.BLACK);
	public Controller_Login(viewLogin v) {
		super();
		this.v = v;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == v.textField) 
		{
			v.textField_1.setBorder(border2);
			v.textField.setBorder(border1);
		} else if(e.getSource() == v.textField_1) 
		{
			v.textField.setBorder(border2);
			v.textField_1.setBorder(border1);
		}
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

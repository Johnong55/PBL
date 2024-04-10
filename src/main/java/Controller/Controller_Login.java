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
	public Controller_Login(viewLogin v) {
		super();
		this.v = v;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == v.textField) 
		{
			MatteBorder border = new MatteBorder(0,0,2,0,Color.BLUE);
			v.textField_1.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
			v.textField.setBorder(border);
		} else if(e.getSource() == v.textField_1) 
		{
			MatteBorder border = new MatteBorder(0,0,2,0,Color.BLUE);
			v.textField.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
			v.textField_1.setBorder(border);
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

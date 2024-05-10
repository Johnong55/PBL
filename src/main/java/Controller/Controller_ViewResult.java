package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JScrollBar;

import View.ViewResult;
import View.ViewStudent;

public class Controller_ViewResult implements ActionListener, MouseWheelListener{

	private ViewResult rs;
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == rs.scrollPane) {
			JScrollBar vertical = rs.scrollPane.getVerticalScrollBar();
			vertical.setValue(vertical.getValue() + e.getUnitsToScroll() * 5);
		}
		if(e.getSource() == rs.btnNewButton)
		{
			rs.dispose();
			ViewStudent v = new ViewStudent(rs.v);
			v.setVisible(true);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	public Controller_ViewResult(ViewResult rs) {
		super();
		this.rs = rs;
	}

}

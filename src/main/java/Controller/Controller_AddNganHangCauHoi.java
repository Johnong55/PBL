package Controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import View.ViewAddNganHangCauHoi;
import View.ViewTeacher;

public class Controller_AddNganHangCauHoi implements Action {
	
	public ViewAddNganHangCauHoi addNGCH;
	public Controller_AddNganHangCauHoi(ViewAddNganHangCauHoi addNGCH) {
		super();
		this.addNGCH = addNGCH;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addNGCH.buttonOK) {
			addNGCH.insertNganHangCauHoi(addNGCH.tenNGCH.getText(), 0, addNGCH.g);
			addNGCH.setVisible(false);
		}else if(e.getSource() == addNGCH.buttonHuy) {
			addNGCH.setVisible(false);
		}
		
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}

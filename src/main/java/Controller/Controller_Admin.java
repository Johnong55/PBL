package Controller;



import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import View.ViewAdmin;
import View.viewLogin;


public class Controller_Admin implements Action {
	public ViewAdmin viewadmin;
	
	public Controller_Admin(ViewAdmin viewadmin) {
		super();
		this.viewadmin = viewadmin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == viewadmin.btnNewButton) {
	
		}else if(e.getSource() == viewadmin.btnNewButton1) {
			this.viewadmin.ViewClass();
		}else if(e.getSource() == viewadmin.btnNewButton2) {
			this.viewadmin.ViewTeacher();
		}else if(e.getSource() == viewadmin.btnNewButton3_1) {
			this.viewadmin.ViewStudent();
		}else if(e.getSource() == viewadmin.btnNewButton5) {
			this.viewadmin.setVisible(false);
			viewLogin v = new viewLogin();
			v.setVisible(true);
		}else if(e.getSource() == viewadmin.buttonAddClass) {
			
		}else if(e.getSource() == viewadmin.buttonDeleteClass) {
			
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

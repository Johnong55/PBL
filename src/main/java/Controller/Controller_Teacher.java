package Controller;


import javax.swing.Action;

import DAO.Gv_dao;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import View.ViewAddNganHangCauHoi;
import View.ViewChangePassword;
import View.ViewTeacher;
import View.viewLogin;



public class Controller_Teacher implements Action {
	
	public ViewTeacher viewteacher;
	
	public Controller_Teacher(ViewTeacher viewteacher) {
		super();
		this.viewteacher = viewteacher;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewteacher.buttonHome) {
			this.viewteacher.ViewHome();
		}else if(e.getSource() == viewteacher.buttonClass) {
			this.viewteacher.ViewClass(viewteacher.getModelClasses(viewteacher.g));
			this.viewteacher.setTableClass( "  Tên lớp");
		}else if(e.getSource() == viewteacher.buttonExam) {
			this.viewteacher.ViewExam();
		}else if(e.getSource() == viewteacher.buttonProfile) {
			this.viewteacher.ViewProfile();
		}else if(e.getSource() == viewteacher.buttonNew) {
			this.viewteacher.ViewCreateNew();
		}else if(e.getSource() == viewteacher.buttonLogout) {
			this.viewteacher.setVisible(false);
			viewLogin v = new viewLogin();
			v.setVisible(true);
		}else if(e.getSource() == viewteacher.buttonCreateExam) {
			this.viewteacher.ViewCreateExam();
		}else if(e.getSource() == viewteacher.buttonChangePass) {
			ViewChangePassword v = new ViewChangePassword(viewteacher.g);
		}else if(e.getSource() == viewteacher.NewQuestion) {
			this.viewteacher.ViewCreateQuestion();
		}else if(e.getSource() == viewteacher.NewExam) {
			this.viewteacher.ViewCreateExam();
		}else if(e.getSource() == viewteacher.comboBoxSortClass) {
			String selectedColumn = (String) viewteacher.comboBoxSortClass.getSelectedItem();
			this.viewteacher.setTableClass(selectedColumn);
		}else if(e.getSource() == viewteacher.comboBoxExam) {
			String selectedColumn = (String) viewteacher.comboBoxExam.getSelectedItem();
			this.viewteacher.setTableExam(selectedColumn);
		}else if(e.getSource() == viewteacher.comboBoxNganHangCauHoi) {
			String check = viewteacher.comboBoxNganHangCauHoi.getSelectedItem().toString();
			if(check.equals("Thêm")) {
				this.viewteacher.ViewCreateNew();
				ViewAddNganHangCauHoi t = new ViewAddNganHangCauHoi(viewteacher.g);
				t.setVisible(true);
			}
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




















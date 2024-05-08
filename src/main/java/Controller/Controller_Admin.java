package Controller;



import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import View.ViewAdmin;
import View.ViewTeacher;
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
			this.viewadmin.ViewAddClass();
		}else if(e.getSource() == viewadmin.buttonOkAddClass) {
			String tenLop = viewadmin.textField.getText();
			viewadmin.insertClass(tenLop);
			viewadmin.updateTableClass(viewadmin.table);
			viewadmin.j.setVisible(false);
		}else if(e.getSource() == viewadmin.buttonHuyAddClass) {
			viewadmin.j.setVisible(false);
		}
		else if(e.getSource() == viewadmin.buttonDeleteClass) {
			String idclass =(String) viewadmin.table.getValueAt(viewadmin.table.getSelectedRow(), 2);
			System.out.println(idclass);
			viewadmin.deleteClass(idclass);
			viewadmin.updateTableClass(viewadmin.table);
		}else if(e.getSource() == viewadmin.comboBoxSortClass) {
			String m = (String) viewadmin.comboBoxSortClass.getSelectedItem();
			viewadmin.SortTableClass(m);
			viewadmin.updateTableClass(viewadmin.table);
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

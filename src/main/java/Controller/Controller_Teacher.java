package Controller;


import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import DAO.Gv_dao;
import DAO.Sv_dao;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

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
			this.viewteacher.SortTableClass( "  Tên lớp");
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
			this.viewteacher.SortTableClass(selectedColumn);
		}else if(e.getSource() == viewteacher.comboBoxExam) {
			String selectedColumn = (String) viewteacher.comboBoxExam.getSelectedItem();
			this.viewteacher.setTableExam(selectedColumn);
		}else if(e.getSource() == viewteacher.comboBoxNganHangCauHoi) {
			String check = viewteacher.comboBoxNganHangCauHoi.getSelectedItem().toString();
			if(check.equals("Thêm")) {
				this.viewteacher.ViewAddNganHangCauHoi();
			}
		}else if(e.getSource() == viewteacher.buttonOK) {
			this.viewteacher.insertNganHangCauHoi(viewteacher.tenNGCH.getText(), 0);
			this.viewteacher.updateComboBoxNganHangCauHoi();
			this.viewteacher.j.setVisible(false);
		}else if(e.getSource() == viewteacher.buttonHuy) {
			this.viewteacher.j.setVisible(false);
		}else if(e.getSource() == viewteacher.buttonDeleteSv) {
			if(viewteacher.table.getSelectedRowCount() != 0) {
			String idclass = (String) viewteacher.table.getValueAt(viewteacher.table.getSelectedRow(), 3);
			String id =(String) viewteacher.table.getValueAt(viewteacher.table.getSelectedRow(), 2);
			viewteacher.deleteSv(id);
			viewteacher.upadteTableSv(viewteacher.table, idclass);
			}else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn học sinh muốn xóa","Lỗi",JOptionPane.INFORMATION_MESSAGE);
			}
		}else if(e.getSource() == viewteacher.buttonAddExam) {
			this.viewteacher.ViewCreateExam();
		}else if(e.getSource() == viewteacher.buttonDeleteExam) {
			if(viewteacher.table.getSelectedRowCount() != 0) {
			String idkithi =(String) viewteacher.table.getValueAt(viewteacher.table.getSelectedRow(), 7);
			viewteacher.deleteExam(idkithi);
			viewteacher.updateTableExam(viewteacher.table);
			}else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng để xóa","Lỗi",JOptionPane.INFORMATION_MESSAGE);
			}
		}else if(e.getSource() == viewteacher.buttonChangeImage) {
			viewteacher.saveAnh();
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




















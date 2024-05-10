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
		}
		else if(e.getSource() == viewteacher.buttonClass) {
			this.viewteacher.ViewClass();
		}
		else if(e.getSource() == viewteacher.buttonExam) {
			this.viewteacher.ViewExam();
		}
		else if(e.getSource() == viewteacher.buttonProfile) {
			this.viewteacher.ViewProfile();
		}
		else if(e.getSource() == viewteacher.buttonNew) {
			this.viewteacher.ViewCreateNew();
		}
		else if(e.getSource() == viewteacher.buttonLogout) {
			this.viewteacher.setVisible(false);
			viewLogin v = new viewLogin();
			v.setVisible(true);
		}
		else if(e.getSource() == viewteacher.buttonCreateExam) {
			this.viewteacher.ViewCreateExam();
		}
		else if(e.getSource() == viewteacher.buttonChangePass) {
			ViewChangePassword v = new ViewChangePassword(viewteacher.g);
		}
		else if(e.getSource() == viewteacher.NewQuestion) {
			this.viewteacher.ViewCreateQuestion();
		}
		else if(e.getSource() == viewteacher.NewExam) {
			this.viewteacher.ViewCreateExam();
		}
		else if(e.getSource() == viewteacher.comboBoxSortClass) {
			String selectedColumn = (String) viewteacher.comboBoxSortClass.getSelectedItem();
			this.viewteacher.SortTable(selectedColumn);
		}
		else if(e.getSource() == viewteacher.comboBoxExam) {
			String selectedColumn = (String) viewteacher.comboBoxExam.getSelectedItem();
			this.viewteacher.SortTable(selectedColumn);
		}
		else if(e.getSource() == viewteacher.comboBoxNganHangCauHoi) {
			String check = viewteacher.comboBoxNganHangCauHoi.getSelectedItem().toString();
			if(check.equals("Thêm")) {
				this.viewteacher.ViewAddNganHangCauHoi();
			}
		}
		else if(e.getSource() == viewteacher.buttonOK) {
			this.viewteacher.insertNganHangCauHoi(viewteacher.tenNGCH.getText(), 0);
			this.viewteacher.updateComboBoxNganHangCauHoi();
			this.viewteacher.j.setVisible(false);
		}
		else if(e.getSource() == viewteacher.buttonHuy) {
			this.viewteacher.j.setVisible(false);
		}
		else if(e.getSource() == viewteacher.buttonAddExam) {
			this.viewteacher.ViewCreateExam();
		}
		else if(e.getSource() == viewteacher.buttonDeleteExam) {
			
			if(viewteacher.table.getSelectedRowCount() == 1) {
				
				int option = JOptionPane.showOptionDialog(null, "Bạn có muốn tiếp tục không?","Xác nhận", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,null, new String[] {"Yes", "No"},"Yes");

					if (option == JOptionPane.YES_OPTION) {

						String idkithi =(String) viewteacher.table.getValueAt(viewteacher.table.getSelectedRow(), 7);
						viewteacher.deleteExam(idkithi);
						viewteacher.updateTableExam(viewteacher.table);
						JOptionPane.showMessageDialog(null, "Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
					}
			}else {
				JOptionPane.showMessageDialog(null, "Chọn 1 dòng để xóa","Lỗi",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(e.getSource() == viewteacher.buttonChangeImage) {
			viewteacher.saveAnh();
		}
		else if(e.getSource() == viewteacher.buttonTaoCauHoi) {
			this.viewteacher.ViewCreateQuestion();
		}
		else if(e.getSource() == viewteacher.buttonLuuCauHoi) {
			viewteacher.InsertCauhoi();
			JOptionPane.showMessageDialog(null, "Tạo câu hỏi thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == viewteacher.buttonExitAddQuestion) {
			this.viewteacher.ViewCreateNew();
		}
		else if(e.getSource() == viewteacher.buttonHuyUpdateExam) {
			this.viewteacher.ViewExam();
		}
		else if(e.getSource() == viewteacher.buttonLuuExam) {
			viewteacher.LuuExam();
			JOptionPane.showMessageDialog(null, "Tạo kì thi thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == viewteacher.buttonUpdateExam) {
			viewteacher.CapNhatExam();
			this.viewteacher.ViewExam();
			JOptionPane.showMessageDialog(null, "Cập nhật thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == viewteacher.comboBoxSortSVinClass) {
			                                                                         //// sort sv in class
		}
		else if(e.getSource() == viewteacher.buttonHuyCreateExam) {
			this.viewteacher.ViewCreateNew();
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




















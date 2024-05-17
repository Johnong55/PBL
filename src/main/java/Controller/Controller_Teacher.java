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
import View.ViewTakeTest;
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
			// giao diện trang chủ
			this.viewteacher.ViewHome();
		}
		else if(e.getSource() == viewteacher.buttonClass) {
			// giao diện lớp
			this.viewteacher.ViewClass();
		}
		else if(e.getSource() == viewteacher.buttonExam) {
			// giao diện kì thi
			this.viewteacher.ViewExam();
		}
		else if(e.getSource() == viewteacher.buttonProfile) {
			// giao diện cá nhân
			this.viewteacher.ViewProfile();
		}
		else if(e.getSource() == viewteacher.buttonLogout) {
			// đăng suất
			this.viewteacher.setVisible(false);
			viewLogin v = new viewLogin();
			v.setVisible(true);
		}
		else if(e.getSource() == viewteacher.buttonChangePass) {
			// giao diện thay đổi mật khẩu
			ViewChangePassword v = new ViewChangePassword(viewteacher.g);
		}
		else if(e.getSource() == viewteacher.buttonTaoCauHoi) {
			// giao diện tạo câu hỏi
			this.viewteacher.ViewCreateQuestion();
		}
		else if(e.getSource() == viewteacher.comboBoxSortClass) {
			// sắp xếp trong giao diện lớp
			String selectedColumn = (String) viewteacher.comboBoxSortClass.getSelectedItem();
			this.viewteacher.SortTable(selectedColumn);
		}
		else if(e.getSource() == viewteacher.comboBoxExam) {
			// sắp xếp trong giao diện kì thi
			String selectedColumn = (String) viewteacher.comboBoxExam.getSelectedItem();
			this.viewteacher.SortTable(selectedColumn);
		}
		else if(e.getSource() == viewteacher.buttonOK) {
			// thêm ngân hàng câu hỏi
			this.viewteacher.insertNganHangCauHoi(viewteacher.tenNGCH.getText(), 0);
			this.viewteacher.updateComboBoxNganHangCauHoi();
			this.viewteacher.j.setVisible(false);
		}
		else if(e.getSource() == viewteacher.buttonHuy) {
			// hủy thêm ngân hàng câu hỏi
			this.viewteacher.j.setVisible(false);
		}
		else if(e.getSource() == viewteacher.buttonAddExam) {
			// giao diên tạo kì thi
			this.viewteacher.ViewCreateExam();
		}
		else if(e.getSource() == viewteacher.buttonDeleteExam) {
			// xóa kì thi
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
			// đổi ava
			viewteacher.saveAnh();
		}
		else if(e.getSource() == viewteacher.buttonHuyUpdateExam) {
			// hủy cập nhật kì thi
			this.viewteacher.ViewExam();
		}
		else if(e.getSource() == viewteacher.buttonLuuExam) {
			// lưu kì thi
			viewteacher.LuuExam();
			JOptionPane.showMessageDialog(null, "Tạo kì thi thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == viewteacher.buttonUpdateExam) {
			// cập nhật kì thi
			viewteacher.CapNhatExam();
			this.viewteacher.ViewExam();
			JOptionPane.showMessageDialog(null, "Cập nhật thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == viewteacher.comboBoxSortSVinClass) {
			                                                                         //// sort sv in class (đợi bài làm)
		}
		else if(e.getSource() == viewteacher.buttonHuyCreateExam) {
			// bấm hủy tạo kì thi
			this.viewteacher.ViewExam();
		}
		else if(e.getSource() == viewteacher.buttonQuestion) {
			// giao diện kho câu hỏi
			this.viewteacher.ViewQuestions();
		}
		else if(e.getSource() == viewteacher.comboBoxNHCH) {
			// giao diện thêm ngân hàng câu hỏi trong tạo câu hỏi
			String check = viewteacher.comboBoxNHCH.getSelectedItem().toString();
			if(check.equals("Thêm")) {
				this.viewteacher.ViewAddNganHangCauHoi();
			}else {
				String idNHCH = (String) viewteacher.comboBoxNHCH.getSelectedItem();
				this.viewteacher.NHCH = viewteacher.getNHCHByName(idNHCH);
				viewteacher.DrawQuestion(viewteacher.NHCH.getSoluong());
			}
		}else if(e.getSource() == viewteacher.buttonSelectAllRadiobutton) {
			// chọn tất cả câu hỏi
			viewteacher.SelectAllRadiobutton();
		}else if(e.getSource() == viewteacher.buttonHuyAllRadiobutton) {
			// hủy chọn tất cả câu hỏi
			viewteacher.HuyAllRadiobutton();
		}
		else if(e.getSource() == viewteacher.buttonAddQuestion) {
			// giao diện tạo câu hỏi
			this.viewteacher.ViewCreateQuestion();
		}
		else if(e.getSource() == viewteacher.buttonLuuCauHoi) {
			// lưu câu hỏi
			viewteacher.InsertCauhoi();
			JOptionPane.showMessageDialog(null, "Tạo câu hỏi thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == viewteacher.buttonExitAddQuestion) {
			// hủy lưu câu hỏi
			this.viewteacher.ViewQuestions();
		}else if(e.getSource() == viewteacher.buttonDeleteQuestion) {
			// xóa câu hỏi
			viewteacher.deleteCauhoi();
			viewteacher.DrawQuestion(viewteacher.NHCH.getSoluong());
		}else if(e.getSource() == viewteacher.buttonEditQuestion) {
			// chỉnh sửa câu hỏi
			viewteacher.editCauhoi();
		}else if(e.getSource() == viewteacher.buttonCapNhatCauHoi) {
			viewteacher.UpdateCauhoi();
			this.viewteacher.ViewQuestions();
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



















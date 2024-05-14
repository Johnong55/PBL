package Controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.JOptionPane;

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

		if (e.getSource() == viewadmin.btnNewButton1) {
			// giao diện lớp
			this.viewadmin.ViewClass();
		} else if (e.getSource() == viewadmin.btnNewButton2) {
			// giap diện giáo viên
			this.viewadmin.ViewTeacher();
		} else if (e.getSource() == viewadmin.btnNewButton3_1) {
			// giao diện học sinh
			this.viewadmin.ViewStudent();
		} else if (e.getSource() == viewadmin.btnNewButton5) {
			// đăng suất
			this.viewadmin.setVisible(false);
			viewLogin v = new viewLogin();
			v.setVisible(true);
		} else if (e.getSource() == viewadmin.buttonAddClass) {
			// giao diện thêm lớp
			this.viewadmin.ViewAddClass();
		} else if (e.getSource() == viewadmin.buttonOkAddClass) {
			// thêm lớp trong giao diện lớp
			String tenLop = viewadmin.textField.getText();
			viewadmin.insertClass(tenLop);
		} else if (e.getSource() == viewadmin.buttonHuyAddClass) {
			viewadmin.j.setVisible(false);
		} else if (e.getSource() == viewadmin.buttonDeleteClass) {
			/// xóa lớp trong giao diện lớp
			if (viewadmin.table.getSelectedRowCount() > 0) {

				int option = JOptionPane.showOptionDialog(null, "Bạn có muốn tiếp tục không?", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
						"Yes");
				if (option == JOptionPane.YES_OPTION) {
					int[] indexRow = viewadmin.table.getSelectedRows();
					List<String> idclasses = new ArrayList<String>();
					for (int i : indexRow) {
						idclasses.add(viewadmin.table.getValueAt(i, 2).toString());
					}
					viewadmin.deleteClass(idclasses);
					viewadmin.updateTableClass();
					JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Chọn ít nhất 1 dòng để xóa", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == viewadmin.comboBoxSortClass) {
			// sắp xếp trong giao diện lớp
			String m = (String) viewadmin.comboBoxSortClass.getSelectedItem();
			viewadmin.SortTable(m);
		} else if (e.getSource() == viewadmin.comboBoxSortALLSV) {
			// sắp xếp trong giao diện học sinh
			String m = (String) viewadmin.comboBoxSortALLSV.getSelectedItem();
			viewadmin.SortTable(m);
		} else if (e.getSource() == viewadmin.buttonDeleteSvFromClass) {
			// xóa sinh viên khỏi lớp
			if (viewadmin.table.getSelectedRowCount() > 0) {

				int option = JOptionPane.showOptionDialog(null, "Bạn có muốn tiếp tục không?", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
						"Yes");
				if (option == JOptionPane.YES_OPTION) {
					int[] indexRow = viewadmin.table.getSelectedRows();
					List<String> idSvs = new ArrayList<String>();
					for (int i : indexRow) {
						idSvs.add(viewadmin.table.getValueAt(i, 2).toString());
					}
					viewadmin.deleteSvFromClass(idSvs);
					viewadmin.updateTabelSvinClass(viewadmin.idclass);
					JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Chọn ít nhất 1 dòng để xóa", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == viewadmin.buttonAddSvInClass) {
			// giao diện thêm sinh viên vào lớp
			viewadmin.ViewAddSvInClass();
		} else if (e.getSource() == viewadmin.buttonChonSvAddIntoClass) {
			// thêm sinh viên vào lớp
			if(viewadmin.table1.getSelectedRowCount() > 0) {
				List<String> idSvs = new ArrayList<>();
				
				int[] indexRow = viewadmin.table1.getSelectedRows();
				for (int i : indexRow) {
					idSvs.add(viewadmin.table1.getValueAt(i, 2).toString());
				}
				
				viewadmin.addSvinClass(idSvs);
			}
		}
		else if(e.getSource() == viewadmin.buttonAddGv) {
			// giao diện thêm giáo viên
			viewadmin.ViewAddGv();
			
		}else if(e.getSource() == viewadmin.buttonOkAddGv) {
			// thêm giáo viên
			String NameGv = viewadmin.textNameGv.getText();
			String IdGv = viewadmin.textIdGv.getText();
			String user = viewadmin.textUser.getText();
			String pass = viewadmin.textPass.getText();
			
			viewadmin.AddGv(NameGv, IdGv, user, pass);
		}
		
		else if(e.getSource() == viewadmin.buttonDeleteGv) {
			// xóa giáo viên
			if(viewadmin.table.getSelectedRowCount() > 0) {
			
			int option = JOptionPane.showOptionDialog(null, "Bạn có muốn tiếp tục không?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
					"Yes");
			if (option == JOptionPane.YES_OPTION) {
				int[] indexRow = viewadmin.table.getSelectedRows();
				List<String> idGvs = new ArrayList<String>();
				for (int i : indexRow) {
					idGvs.add(viewadmin.table.getValueAt(i, 1).toString());
				}
				
				viewadmin.deleteGv(idGvs);
				viewadmin.updateTableTeacher();
				JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Chọn ít nhất 1 dòng để xóa", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
			}
		}else if(e.getSource() == viewadmin.buttonAddClassInGv) {
			// giao diện thêm lớp cho giáo viên
			viewadmin.ViewAddClassInGv();
		}else if(e.getSource() == viewadmin.buttonChonClassAddIntoGv) {
			// thêm lớp cho giáo viên
			if(viewadmin.table2.getSelectedRowCount() > 0) {
				List<String> idClass = new ArrayList<>();
				
				int[] indexRow = viewadmin.table2.getSelectedRows();
				for (int i : indexRow) {
					idClass.add(viewadmin.table2.getValueAt(i, 2).toString());
				}				
				viewadmin.AddClassIntoGv(idClass);
				viewadmin.updateTabelClassOfGv(viewadmin.idGv);
				viewadmin.z.setVisible(false);
				JOptionPane.showMessageDialog(null, "Thêm lớp thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(e.getSource() == viewadmin.buttonDeleteClassInGv) {	
			// xóa lớp khỏi giáo viên
			if(viewadmin.table.getSelectedRowCount() > 0) {			
				int option = JOptionPane.showOptionDialog(null, "Bạn có muốn tiếp tục không?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
					"Yes");
			if (option == JOptionPane.YES_OPTION) {
				int[] indexRow = viewadmin.table.getSelectedRows();
				List<String> idClasses = new ArrayList<String>();
				for (int i : indexRow) {
					idClasses.add(viewadmin.table.getValueAt(i, 2).toString());
				}
				
				String idgv = viewadmin.table.getValueAt(viewadmin.table.getSelectedRow(), 1).toString();
				viewadmin.DeleteClassIntoGv(idClasses, idgv);
				viewadmin.updateTabelClassOfGv(idgv);
				JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Chọn ít nhất 1 dòng để xóa", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}else if(e.getSource() == viewadmin.buttonAddSvInStudent) {
				//// thêm sinh viên trong giao diện sinh viên
			this.viewadmin.ViewAddSv();
		}else if(e.getSource() == viewadmin.buttonOkAddSv) {
			String NameGv = viewadmin.textNameSv.getText();
			String IdGv = viewadmin.textIdSv.getText();
			String user = viewadmin.textUserSv.getText();
			String pass = viewadmin.textPassSv.getText();
			String tenlop =(String) viewadmin.comboBoxLOP.getSelectedItem();
			
			viewadmin.AddSv(NameGv, IdGv, user, pass, tenlop);
		}
		else if(e.getSource() == viewadmin.buttonDeleteSvInStudent) {
				//// xóa sinh viên trong giao diện sinh viên
			System.out.println("aaaa");
			if(viewadmin.table.getSelectedRowCount() > 0) {			
				int option = JOptionPane.showOptionDialog(null, "Bạn có muốn tiếp tục không?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
					"Yes");
			if (option == JOptionPane.YES_OPTION) {
				List<String> idSvs = new ArrayList<String>();
				
				int[] indexRow = viewadmin.table.getSelectedRows();
				
				for (int i : indexRow) {
					String idclass = viewadmin.table.getValueAt(i, 3).toString();
					idSvs.add(idclass);
				}
				viewadmin.deleteSvInStudent(idSvs);
				viewadmin.updateTableStudent();
				
				JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Chọn ít nhất 1 dòng để xóa", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
			}
		}else if(e.getSource() == viewadmin.buttonExam) {
			// giao diện kì thi
			this.viewadmin.ViewExam();
		}
		else if(e.getSource() == viewadmin.comboBoxExam) {
			// sắp xếp trong giao diện kì thi
			String selectedColumn = (String) viewadmin.comboBoxExam.getSelectedItem();
			this.viewadmin.SortTable(selectedColumn);
		}else if(e.getSource() == viewadmin.buttonDeleteExam) {
			// xóa kì thi
			if(viewadmin.table.getSelectedRowCount() == 1) {
				
				int option = JOptionPane.showOptionDialog(null, "Bạn có muốn tiếp tục không?","Xác nhận", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,null, new String[] {"Yes", "No"},"Yes");

					if (option == JOptionPane.YES_OPTION) {

						String idkithi =(String) viewadmin.table.getValueAt(viewadmin.table.getSelectedRow(), 7);
						viewadmin.deleteExam(idkithi);
						viewadmin.updateTableExam(viewadmin.table);
						JOptionPane.showMessageDialog(null, "Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
					}
			}else {
				JOptionPane.showMessageDialog(null, "Chọn 1 dòng để xóa","Lỗi",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(e.getSource() == viewadmin.buttonTest) {
			// giao diện bài làm
		}else if(e.getSource() == viewadmin.buttonQuestion) {
			// giao diện ngân hàng câu hỏi
			this.viewadmin.ViewQuestions();
		}else if(e.getSource() == viewadmin.comboBoxNHCH) {
			// thay đổi ngân hàng câu hỏi
			String idNHCH = (String) viewadmin.comboBoxNHCH.getSelectedItem();
			this.viewadmin.NHCH = viewadmin.getNHCHByName(idNHCH);
	//		viewadmin.DrawQuestion(viewadmin.NHCH.getSoluong());

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

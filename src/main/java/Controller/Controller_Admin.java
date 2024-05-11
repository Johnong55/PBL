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
			this.viewadmin.ViewClass();
		} else if (e.getSource() == viewadmin.btnNewButton2) {
			this.viewadmin.ViewTeacher();
		} else if (e.getSource() == viewadmin.btnNewButton3_1) {
			this.viewadmin.ViewStudent();
		} else if (e.getSource() == viewadmin.btnNewButton5) {
			this.viewadmin.setVisible(false);
			viewLogin v = new viewLogin();
			v.setVisible(true);
		} else if (e.getSource() == viewadmin.buttonAddClass) {
			this.viewadmin.ViewAddClass();
		} else if (e.getSource() == viewadmin.buttonOkAddClass) {
			String tenLop = viewadmin.textField.getText();
			viewadmin.insertClass(tenLop);
		} else if (e.getSource() == viewadmin.buttonHuyAddClass) {
			viewadmin.j.setVisible(false);
		} else if (e.getSource() == viewadmin.buttonDeleteClass) {

			if (viewadmin.table.getSelectedRowCount() == 1) {

				int option = JOptionPane.showOptionDialog(null, "Bạn có muốn tiếp tục không?", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
						"Yes");
				if (option == JOptionPane.YES_OPTION) {
					String idclass = (String) viewadmin.table.getValueAt(viewadmin.table.getSelectedRow(), 2);
					viewadmin.deleteClass(idclass);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Chọn 1 dòng để xóa", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == viewadmin.comboBoxSortClass) {
			String m = (String) viewadmin.comboBoxSortClass.getSelectedItem();
			viewadmin.SortTable(m);
		} else if (e.getSource() == viewadmin.comboBoxSortALLSV) {
			String m = (String) viewadmin.comboBoxSortALLSV.getSelectedItem();
			viewadmin.SortTable(m);
		} else if (e.getSource() == viewadmin.buttonDeleteSvFromClass) {

			if (viewadmin.table.getSelectedRowCount() == 1) {

				int option = JOptionPane.showOptionDialog(null, "Bạn có muốn tiếp tục không?", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
						"Yes");
				if (option == JOptionPane.YES_OPTION) {
					String idsv = viewadmin.table.getValueAt(viewadmin.table.getSelectedRow(), 2).toString();
					viewadmin.deleteSvFromClass(idsv);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Chọn 1 dòng để xóa", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == viewadmin.buttonAddSvInClass) {
			viewadmin.ViewAddSvInClass();
		} else if (e.getSource() == viewadmin.buttonChonSvAddIntoClass) {
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
			viewadmin.ViewAddGv();
			
		}else if(e.getSource() == viewadmin.buttonOkAddGv) {
			String NameGv = viewadmin.textNameGv.getText();
			String IdGv = viewadmin.textIdGv.getText();
			String user = viewadmin.textUser.getText();
			String pass = viewadmin.textPass.getText();
			
			viewadmin.AddGv(NameGv, IdGv, user, pass);
			viewadmin.updateTableTeacher();
			viewadmin.l.setVisible(false);
			JOptionPane.showMessageDialog(null, "Thêm giáo viên thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(e.getSource() == viewadmin.buttonDeleteGv) {
			if(viewadmin.table.getSelectedRowCount() == 1) {
			
			int option = JOptionPane.showOptionDialog(null, "Bạn có muốn tiếp tục không?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
					"Yes");
			if (option == JOptionPane.YES_OPTION) {
				String idgv = viewadmin.table.getValueAt(viewadmin.table.getSelectedRow(), 1).toString();
				viewadmin.deleteGv(idgv);
				viewadmin.updateTableTeacher();
				JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Chọn 1 dòng để xóa", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
			}
		}else if(e.getSource() == viewadmin.buttonAddClassInGv) {
			
		}else if(e.getSource() == viewadmin.buttonDeleteClassInGv) {			
			if(viewadmin.table.getSelectedRowCount() == 1) {			
				int option = JOptionPane.showOptionDialog(null, "Bạn có muốn tiếp tục không?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
					"Yes");
			if (option == JOptionPane.YES_OPTION) {
				String idclass = viewadmin.table.getValueAt(viewadmin.table.getSelectedRow(), 2).toString();
				String idgv = viewadmin.table.getValueAt(viewadmin.table.getSelectedRow(), 1).toString();
				viewadmin.DeleteClassIntoGv(idclass, idgv);
				viewadmin.updateTabelClassOfGv(idgv);
				

				JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Chọn 1 dòng để xóa", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
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

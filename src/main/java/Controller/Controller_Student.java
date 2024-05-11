package Controller;

import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;

import DAO.Account_dao;
import DAO.BaiLam_dao;
import DAO.KiThi_dao;
import DAO.Sv_dao;
import View.ChangePassword;
import View.GoingTest;
import View.ViewStudent;
import View.viewLogin;
import model.BaiLam;

public class Controller_Student implements ActionListener , MouseListener {
	private ViewStudent s;

	public Controller_Student(ViewStudent s) {
		super();
		this.s = s;

	}

	public void setPanel_4() {
		s.panel_4.removeAll();
		s.panel_4.revalidate();
		s.panel_4.repaint();
	}

	public void timkiemtheoten(String t) {
		s.bailamsv = BaiLam_dao.Instance().selectbailambysv(s.v);

		for (int i = 0; i < s.bailamsv.size(); i++)

			if (s.bailamsv.get(i).getKiThi().getMota().toLowerCase().contains(t.toLowerCase())) {
				String diem = String.format("%.3f", s.bailamsv.get(i).getDiem());
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String ngay = (sdf.format(s.bailamsv.get(i).getKiThi().getDate()).toString());
				s.model.addRow(new Object[] { s.bailamsv.get(i).getKiThi().getMota(), ngay,
						s.bailamsv.get(i).getKiThi().getThoigianlambai(), s.bailamsv.get(i).getSocaudung(),
						s.bailamsv.get(i).getSocausai(), diem });
			}

	}

	public void timkiemtheodiem(String t) {
		s.bailamsv = BaiLam_dao.Instance().selectbailambysv(s.v);

		for (int i = 0; i < s.bailamsv.size(); i++)

			if (String.format("%.3f", s.bailamsv.get(i).getDiem()).toLowerCase().contains(t.toLowerCase())) {
				String diem = String.format("%.3f", s.bailamsv.get(i).getDiem());
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String ngay = (sdf.format(s.bailamsv.get(i).getKiThi().getDate()).toString());
				s.model.addRow(new Object[] { s.bailamsv.get(i).getKiThi().getMota(), ngay,
						s.bailamsv.get(i).getKiThi().getThoigianlambai(), s.bailamsv.get(i).getSocaudung(),
						s.bailamsv.get(i).getSocausai(), diem });
			}

	}
	private static void sortTableByColumn(JTable table, int columnIndex) {
	    TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
	    table.setRowSorter(sorter);

	    List<RowSorter.SortKey> sortKeys = new ArrayList<>();
	    sortKeys.add(new RowSorter.SortKey(columnIndex, SortOrder.ASCENDING));
	    sorter.setSortKeys(sortKeys);
	    sorter.sort();
	}
	public void timkiemtheongaythi(String t) {
		s.bailamsv = BaiLam_dao.Instance().selectbailambysv(s.v);

		for (int i = 0; i < s.bailamsv.size(); i++)

			if (s.bailamsv.get(i).getKiThi().getDate().toString().toLowerCase().contains(t.toLowerCase())) {
				String diem = String.format("%.3f", s.bailamsv.get(i).getDiem());
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String ngay = (sdf.format(s.bailamsv.get(i).getKiThi().getDate()).toString());
				s.model.addRow(new Object[] { s.bailamsv.get(i).getKiThi().getMota(), ngay,
						s.bailamsv.get(i).getKiThi().getThoigianlambai(), s.bailamsv.get(i).getSocaudung(),
						s.bailamsv.get(i).getSocausai(), diem });
			}

	}

	public void hienthi() {
		s.bailamsv = BaiLam_dao.Instance().selectbailambysv(s.v);

		for (int i = 0; i < s.bailamsv.size(); i++)

		{
			String diem = String.format("%.3f", s.bailamsv.get(i).getDiem());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String ngay = (sdf.format(s.bailamsv.get(i).getKiThi().getDate()).toString());
			s.model.addRow(new Object[] { s.bailamsv.get(i).getKiThi().getMota(), ngay,
					s.bailamsv.get(i).getKiThi().getThoigianlambai(), s.bailamsv.get(i).getSocaudung(),
					s.bailamsv.get(i).getSocausai(), diem });
		}

	}

	public void timkiem() {
		int selectedColumn = s.comboBox.getSelectedIndex();
		if (selectedColumn == 0) {
			hienthi();
			s.textField.setText("");
			s.lblNewLabel_9.setText("ALL");

			return;
		} else
		if (selectedColumn == 1) {
			timkiemtheoten(s.textField.getText());
			s.lblNewLabel_9.setText("Tên kì thi");

			return;
		} else
		if (selectedColumn == 2) {
			timkiemtheongaythi(s.textField.getText());
			s.lblNewLabel_9.setText("Ngày thi");

			return;
		}else
		if (selectedColumn == 3) {
			timkiemtheodiem(s.textField.getText());
			s.lblNewLabel_9.setText("Điểm");

			return;
		}

	}

	private void displayImage(File imageFile, JLabel label) {
		try {
			Image image = Toolkit.getDefaultToolkit().createImage(imageFile.toString());
			image = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
			label.setIcon(new ImageIcon(image));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == s.BtnHome)

		{
			setPanel_4();
			s.view_home();

		} else if (e.getSource() == s.btnTests) {
			s.model.setRowCount(0);
			setPanel_4();
			hienthi();
			s.view_test();

		}

		else if (e.getSource() == s.btnProfile) {

			setPanel_4();
			s.view_profile();
		}
		else if (e.getSource() == s.exit) {
			s.dispose();
			viewLogin v = new viewLogin();
			v.setVisible(true);
		}

		else if (e.getSource() == s.mbtnBtuLm) {
			if (s.ktOngoing.getId() != null) {
				GoingTest frame = new GoingTest(s.v, s.ktOngoing);
				frame.setVisible(true);
				s.dispose();
			}

		} else if (e.getSource() == s.comboBox) {
			s.model.setRowCount(0);
			timkiem();

		} else if (e.getSource() == s.btnChangePer) {

			ChangePassword frame = new ChangePassword(s.v.getPassword());
			frame.setVisible(true);
			// Trong phần tạo form mới
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			
			if(frame.isDisposed)
			{
				s.v.setPassword(frame.password);
				Sv_dao.Instance().update(s.v);
			}
			

		} else if (e.getSource() == s.BtnChangeImagePer) {
			JFileChooser saveFile = new JFileChooser();
			int result = saveFile.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				// Lấy file được chọn
				File sourceFile = saveFile.getSelectedFile();

				// Lấy file được chọn để lưu
				File destinationFile = new File(
						"T:\\jdbc\\hibernate7\\src\\main\\java\\View\\image\\" + sourceFile.getName());

				try {
					Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					displayImage(destinationFile, s.lblNewLabel_14);
					s.v.setLinkAnh("/View/image/" + sourceFile.getName());
					Sv_dao.Instance().update(s.v);
					JOptionPane.showMessageDialog(null, destinationFile.toString());
				} catch (Exception q) {
					System.out.println(q);
				}
				

			}
		}

		s.panel_4.setBounds(171, 0, 713, 661);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 1) {
            int columnIndex = s.table.getColumnModel().getColumnIndexAtX(e.getX());
            sortTableByColumn(s.table, columnIndex);
        }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

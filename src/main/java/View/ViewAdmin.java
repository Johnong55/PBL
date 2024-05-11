package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Controller.Controller_Admin;
import DAO.Cauhoi_Dao;
import DAO.Class_dao;
import DAO.Giangday_dao;
import DAO.Gv_dao;
import DAO.KiThi_dao;
import DAO.NganhangDao;
import DAO.Sv_dao;
import DAO.truonghoc_dao;
import model.Cauhoi;
import model.Class;
import model.Giangday;
import model.Gv;
import model.Nganhangcauhoi;
import model.Sv;
import model.truonghoc;
import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

import javax.swing.JComboBox;

public class ViewAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pView,contentPane1,contentPane2,pView1,contentPane3;
	public MyTable table,table1;
	public MyButton btnNewButton1, btnNewButton2, btnNewButton3_1, btnNewButton5,buttonAddClass,
	buttonDeleteClass,buttonAddSvInClass,buttonHuyAddClass,buttonOkAddClass,buttonDeleteSvFromClass,
	buttonChonSvAddIntoClass,buttonAddGv,buttonDeleteGv,buttonOkAddGv,buttonDeleteClassInGv,buttonAddClassInGv;
	public JComboBox<String> comboBoxSortClass,comboBoxSortALLSV;
	public JTextField textField,textNameGv,textIdGv,textUser,textPass;
	public JFrame j,k,l;
	public JLabel lblNewLabel_1;
	public String idclass;

	/**
	 * Launch the application.
	 */

	Controller_Admin actionAdmin = new Controller_Admin(this);

	public ViewAdmin() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(45, 51, 63));
		panel.setBounds(0, 0, 170, 661);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(45, 11, 75, 70);

		lblNewLabel.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/logo.png"))
						.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH)));

		panel.add(lblNewLabel);

		btnNewButton1 = new MyButton("Lớp");
		btnNewButton1.setForeground(new Color(255, 255, 255));
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton1.setBounds(10, 90, 137, 37);
		btnNewButton1.setBackground(new Color(45, 51, 63));
		btnNewButton1.setColorClick(new Color(45, 51, 63));
		btnNewButton1.setColorOver(new Color(86, 98, 120));
		btnNewButton1.setRadius(10);
		btnNewButton1.setBorderColor(new Color(45, 51, 63));
		btnNewButton1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-class-20.png"))));
		panel.add(btnNewButton1);
		btnNewButton1.addActionListener(actionAdmin);

		btnNewButton2 = new MyButton("Giáo viên");
		btnNewButton2.setForeground(new Color(255, 255, 255));
		btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton2.setBounds(10, 138, 137, 37);
		btnNewButton2.setBackground(new Color(45, 51, 63));
		btnNewButton2.setColorClick(new Color(45, 51, 63));
		btnNewButton2.setColorOver(new Color(86, 98, 120));
		btnNewButton2.setRadius(10);
		btnNewButton2.setBorderColor(new Color(45, 51, 63));
		btnNewButton2.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-result-20.png"))));
		panel.add(btnNewButton2);
		btnNewButton2.addActionListener(actionAdmin);

		btnNewButton3_1 = new MyButton("Học sinh");
		btnNewButton3_1.setRadius(10);
		btnNewButton3_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton3_1.setForeground(Color.WHITE);
		btnNewButton3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton3_1.setColorOver(new Color(86, 98, 120));
		btnNewButton3_1.setColorClick(new Color(45, 51, 63));
		btnNewButton3_1.setBorderColor(new Color(45, 51, 63));
		btnNewButton3_1.setBackground(new Color(45, 51, 63));
		btnNewButton3_1.setBounds(10, 186, 137, 37);
		btnNewButton3_1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-student-20.png"))));
		panel.add(btnNewButton3_1);
		btnNewButton3_1.addActionListener(actionAdmin);

		btnNewButton5 = new MyButton("Đăng xuất");
		btnNewButton5.setForeground(new Color(255, 255, 255));
		btnNewButton5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton5.setBounds(10, 550, 137, 37);
		btnNewButton5.setBackground(new Color(45, 51, 63));
		btnNewButton5.setColorClick(new Color(45, 51, 63));
		btnNewButton5.setColorOver(new Color(86, 98, 120));
		btnNewButton5.setRadius(10);
		btnNewButton5.setBorderColor(new Color(45, 51, 63));
		btnNewButton5.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-logout-20.png"))));
		btnNewButton5.addActionListener(actionAdmin);
		panel.add(btnNewButton5);

		//////////////////////////////////////////////////

		pView = new JPanel();
		pView.setBorder(null);
		pView.setBackground(Color.WHITE);
		pView.setBounds(170, 0, 714, 661);
		contentPane.add(pView);
		pView.setLayout(null);
		
		setVisible(true);
		
		ViewClass();

		//////////////////////////////////////////////////

	}

	public void ViewClass() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("LỚP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth() + 1, (int) size.getHeight() + 1);

		pView.add(lblNewLabel);

		String[] list = { "  Tên lớp", "  Số học sinh"};

		comboBoxSortClass = new JComboBox<>(list);
		comboBoxSortClass.setBounds(615, 35, 90, 22);
		pView.add(comboBoxSortClass);
		comboBoxSortClass.addActionListener(actionAdmin);

		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(550, 30, 59, 28);
		pView.add(lblNewLabel_1);

		buttonAddClass = new MyButton("Thêm lớp");
		buttonAddClass.setRadius(10);
		buttonAddClass.setForeground(Color.WHITE);
		buttonAddClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonAddClass.setColorOver(new Color(86, 98, 120));
		buttonAddClass.setColorClick(new Color(45, 51, 63));
		buttonAddClass.setColor(new Color(45, 51, 63));
		buttonAddClass.setBorderColor(Color.white);
		buttonAddClass.setBackground(new Color(45, 51, 63));
		buttonAddClass.setBounds(10, 600, 110, 30);

		pView.add(buttonAddClass);
		
		buttonAddClass.addActionListener(actionAdmin);

		buttonDeleteClass = new MyButton("Xóa lớp");
		buttonDeleteClass.setRadius(10);
		buttonDeleteClass.setForeground(Color.WHITE);
		buttonDeleteClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonDeleteClass.setColorOver(new Color(86, 98, 120));
		buttonDeleteClass.setColorClick(new Color(45, 51, 63));
		buttonDeleteClass.setColor(new Color(45, 51, 63));
		buttonDeleteClass.setBorderColor(Color.white);
		buttonDeleteClass.setBackground(new Color(45, 51, 63));
		buttonDeleteClass.setBounds(130, 600, 110, 30);
		pView.add(buttonDeleteClass);
		buttonDeleteClass.addActionListener(actionAdmin);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 695, 500);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));

		pView.add(scrollPane);

		table = new MyTable();
		table.setRowHeight(30);
		table.setColor1(Color.WHITE);
		table.setColor2(Color.WHITE);
		table.setGridColor(new Color(201, 201, 201));
		// table.setShowGrid(false);
		table.setColumnAlignment(0, JLabel.LEFT);
		table.setCellAlignment(0, JLabel.LEFT);

		JTableHeader header = table.getTableHeader();
		header.setDefaultRenderer(new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				comp.setBackground(new Color(45, 51, 63));
				comp.setForeground(Color.WHITE);
				setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201, 201, 201)));

				return comp;
			}
		});
		table.getTableHeader().setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "  Tên lớp", "  Số học sinh", "  Mã lớp" }));

		table.setModel(getModelClasses(table));
		SortTable("  Tên lớp");
		table.setDefaultEditor(Object.class, null);
		
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column3 = columnModel.getColumn(2);
		column3.setMinWidth(0);
		column3.setMaxWidth(0);
		column3.setWidth(0);
		column3.setPreferredWidth(0);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int i = table.getSelectedRow();
					String m = table.getValueAt(i, 0).toString();
					ViewListSVinClass(m);
				}
			}
		});
		

		scrollPane.setViewportView(table);

	}
	
	public void ViewAddClass() {
		j = new JFrame();
		j.setBounds(100, 100, 276, 161);
		j.setLocationRelativeTo(null);
		contentPane1 = new JPanel();
		contentPane1.setBackground(new Color(255, 255, 255));
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

		j.setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên lớp: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 33, 66, 17);
		contentPane1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(86, 33, 123, 20);
		contentPane1.add(textField);
		textField.setColumns(10);
		
		buttonOkAddClass = new MyButton("Ok");
		buttonOkAddClass.setBounds(36, 88, 89, 23);
		contentPane1.add(buttonOkAddClass);
		buttonOkAddClass.addActionListener(actionAdmin);
		
		buttonHuyAddClass = new MyButton("Hủy");
		buttonHuyAddClass.setBounds(135, 88, 89, 23);
		contentPane1.add(buttonHuyAddClass);
		buttonHuyAddClass.addActionListener(actionAdmin);
		j.setVisible(true);
	}

	public void ViewListSVinClass(String m) {
		idclass = getIdLopbyName(m);
		System.out.println(idclass);
		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("LỚP " + m);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth() + 1, (int) size.getHeight() + 1);

		pView.add(lblNewLabel);
		
		buttonAddSvInClass = new MyButton("Thêm học sinh");
		buttonAddSvInClass.setRadius(10);
		buttonAddSvInClass.setForeground(Color.WHITE);
		buttonAddSvInClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonAddSvInClass.setColorOver(new Color(86, 98, 120));
		buttonAddSvInClass.setColorClick(new Color(45, 51, 63));
		buttonAddSvInClass.setColor(new Color(45, 51, 63));
		buttonAddSvInClass.setBorderColor(Color.white);
		buttonAddSvInClass.setBackground(new Color(45, 51, 63));
		buttonAddSvInClass.setBounds(10, 600, 110, 30);

		pView.add(buttonAddSvInClass);
		buttonAddSvInClass.addActionListener(actionAdmin);
		
		buttonDeleteSvFromClass = new MyButton("Xóa học sinh");
		buttonDeleteSvFromClass.setRadius(10);
		buttonDeleteSvFromClass.setForeground(Color.WHITE);
		buttonDeleteSvFromClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonDeleteSvFromClass.setColorOver(new Color(86, 98, 120));
		buttonDeleteSvFromClass.setColorClick(new Color(45, 51, 63));
		buttonDeleteSvFromClass.setColor(new Color(45, 51, 63));
		buttonDeleteSvFromClass.setBorderColor(Color.white);
		buttonDeleteSvFromClass.setBackground(new Color(45, 51, 63));
		buttonDeleteSvFromClass.setBounds(130, 600, 110, 30);
		pView.add(buttonDeleteSvFromClass);
		
		buttonDeleteSvFromClass.addActionListener(actionAdmin);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(10, 89, 695, 500);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));
		pView.add(scrollPane);

		table = new MyTable();
		table.setRowHeight(30);
		table.setColor1(Color.WHITE);
		table.setColor2(Color.WHITE);
		table.setGridColor(new Color(201, 201, 201));
	//	 table.setShowGrid(false);
		table.setColumnAlignment(0, JLabel.LEFT);
		table.setCellAlignment(0, JLabel.LEFT);

		JTableHeader header = table.getTableHeader();
		header.setDefaultRenderer(new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				comp.setBackground(new Color(45, 51, 63));
				comp.setForeground(Color.WHITE);
				setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201, 201, 201)));

				return comp;
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"  Danh sách học sinh", "  Tên", " Mã học sinh", " Mã lớp"}));
		table.setModel(getModelSVinClass(idclass));
		table.setDefaultEditor(Object.class, null);
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column = columnModel.getColumn(1);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);
		
		TableColumn column1 = columnModel.getColumn(2);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);
		column1.setWidth(0);
		column1.setPreferredWidth(0);
		
		TableColumn column2 = columnModel.getColumn(3);
		column2.setMinWidth(0);
		column2.setMaxWidth(0);
		column2.setWidth(0);
		column2.setPreferredWidth(0);
		
		SortTable("  Tên");	
		scrollPane.setViewportView(table);
	}
	
	public void ViewAddSvInClass() {
		k = new JFrame();
		k.setBounds(100, 100, 749, 623);
		k.setLocationRelativeTo(null);
		
		contentPane2 = new JPanel();
		contentPane2.setBackground(new Color(255, 255, 255));
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setLayout(null);
		
		k.setContentPane(contentPane2);

		pView1 = new JPanel();
		pView1.setBorder(null);
		pView1.setBackground(Color.WHITE);
		pView1.setBounds(10, 11, 714, 562);
		contentPane2.add(pView1);
		pView1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 695, 500);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "  Danh sách học sinh chưa có lớp", "  Tên", "  Mã học sinh" });
		table1 = new MyTable();
		table1.setModel(model);
		table1.setRowHeight(30);
		table1.setColor1(Color.WHITE);
		table1.setColor2(Color.WHITE);
		table1.setGridColor(new Color(201, 201, 201));
		// table.setShowGrid(false);
		table1.setColumnAlignment(0, JLabel.LEFT);
		table1.setCellAlignment(0, JLabel.LEFT);

		JTableHeader header = table1.getTableHeader();
		header.setDefaultRenderer(new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				comp.setBackground(new Color(45, 51, 63));
				comp.setForeground(Color.WHITE);
				setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201, 201, 201)));

				return comp;
			}
		});

		table1.setModel(getModelStudentNoClass(table1));
		TableColumnModel columnModel = table1.getColumnModel();
		TableColumn column = columnModel.getColumn(1);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);
		
		TableColumn column1 = columnModel.getColumn(2);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);
		column1.setWidth(0);
		column1.setPreferredWidth(0);
		
		table1.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table1);
		pView1.add(scrollPane);
		
		buttonChonSvAddIntoClass = new MyButton("Thêm học sinh");
		buttonChonSvAddIntoClass.setRadius(10);
		buttonChonSvAddIntoClass.setForeground(Color.WHITE);
		buttonChonSvAddIntoClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonChonSvAddIntoClass.setColorOver(new Color(86, 98, 120));
		buttonChonSvAddIntoClass.setColorClick(new Color(45, 51, 63));
		buttonChonSvAddIntoClass.setColor(new Color(45, 51, 63));
		buttonChonSvAddIntoClass.setBorderColor(Color.white);
		buttonChonSvAddIntoClass.setBackground(new Color(45, 51, 63));
		buttonChonSvAddIntoClass.setBounds(297, 522, 116, 33);

		pView1.add(buttonChonSvAddIntoClass);
		
		buttonChonSvAddIntoClass.addActionListener(actionAdmin);
		
		k.setVisible(true);
		
	}

	public void ViewTeacher() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("GIÁO VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth() + 1, (int) size.getHeight() + 1);

		pView.add(lblNewLabel);

		buttonAddGv = new MyButton("Thêm giáo viên");
		buttonAddGv.setRadius(10);
		buttonAddGv.setForeground(Color.WHITE);
		buttonAddGv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonAddGv.setColorOver(new Color(86, 98, 120));
		buttonAddGv.setColorClick(new Color(45, 51, 63));
		buttonAddGv.setColor(new Color(45, 51, 63));
		buttonAddGv.setBorderColor(Color.white);
		buttonAddGv.setBackground(new Color(45, 51, 63));
		buttonAddGv.setBounds(10, 600, 110, 30);

		pView.add(buttonAddGv);
		
		buttonAddGv.addActionListener(actionAdmin);

		buttonDeleteGv = new MyButton("Xóa giáo viên");
		buttonDeleteGv.setRadius(10);
		buttonDeleteGv.setForeground(Color.WHITE);
		buttonDeleteGv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonDeleteGv.setColorOver(new Color(86, 98, 120));
		buttonDeleteGv.setColorClick(new Color(45, 51, 63));
		buttonDeleteGv.setColor(new Color(45, 51, 63));
		buttonDeleteGv.setBorderColor(Color.white);
		buttonDeleteGv.setBackground(new Color(45, 51, 63));
		buttonDeleteGv.setBounds(130, 600, 110, 30);
		pView.add(buttonDeleteGv);
		
		buttonDeleteGv.addActionListener(actionAdmin);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 695, 500);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));
		scrollPane.getViewport().setBackground(Color.WHITE);

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "  Danh sách giáo viên", "  Mã Gv" });
		table = new MyTable();
		table.setModel(model);
		table.setBackground(new Color(255, 255, 255));
		table.setRowHeight(30);
		table.setColor1(Color.WHITE);
		table.setColor2(Color.WHITE);
		table.setGridColor(new Color(201, 201, 201));
		// table.setShowGrid(false);
		table.setColumnAlignment(0, JLabel.LEFT);
		table.setCellAlignment(0, JLabel.LEFT);

		JTableHeader header = table.getTableHeader();
		header.setDefaultRenderer(new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				comp.setBackground(new Color(45, 51, 63));
				comp.setForeground(Color.WHITE);
				setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201, 201, 201)));

				return comp;
			}
		});
		table.setModel(getModelTeacher());
		
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column = columnModel.getColumn(1);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);
		
		table.setDefaultEditor(Object.class, null);

		scrollPane.setViewportView(table);
		pView.add(scrollPane);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
				int i = table.getSelectedRow();
				String m = table.getValueAt(i, 0).toString();
				ViewClassOfTeacher(m);
				}
			}
		});

	}

	public void ViewClassOfTeacher(String m) {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("GIÁO VIÊN " + m);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth() + 1, (int) size.getHeight() + 1);

		pView.add(lblNewLabel);
		
		buttonAddClassInGv = new MyButton("Thêm lớp");
		buttonAddClassInGv.setRadius(10);
		buttonAddClassInGv.setForeground(Color.WHITE);
		buttonAddClassInGv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonAddClassInGv.setColorOver(new Color(86, 98, 120));
		buttonAddClassInGv.setColorClick(new Color(45, 51, 63));
		buttonAddClassInGv.setColor(new Color(45, 51, 63));
		buttonAddClassInGv.setBorderColor(Color.white);
		buttonAddClassInGv.setBackground(new Color(45, 51, 63));
		buttonAddClassInGv.setBounds(10, 600, 110, 30);

		pView.add(buttonAddClassInGv);
		buttonAddClassInGv.addActionListener(actionAdmin);

		buttonDeleteClassInGv = new MyButton("Xóa lớp");
		buttonDeleteClassInGv.setRadius(10);
		buttonDeleteClassInGv.setForeground(Color.WHITE);
		buttonDeleteClassInGv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonDeleteClassInGv.setColorOver(new Color(86, 98, 120));
		buttonDeleteClassInGv.setColorClick(new Color(45, 51, 63));
		buttonDeleteClassInGv.setColor(new Color(45, 51, 63));
		buttonDeleteClassInGv.setBorderColor(Color.white);
		buttonDeleteClassInGv.setBackground(new Color(45, 51, 63));
		buttonDeleteClassInGv.setBounds(130, 600, 110, 30);
		pView.add(buttonDeleteClassInGv);
		buttonDeleteClassInGv.addActionListener(actionAdmin);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(10, 89, 695, 500);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));
		pView.add(scrollPane);

		table = new MyTable();
		table.setRowHeight(30);
		table.setColor1(Color.WHITE);
		table.setColor2(Color.WHITE);
		table.setGridColor(new Color(201, 201, 201));
		// table.setShowGrid(false);
		table.setColumnAlignment(0, JLabel.LEFT);
		table.setCellAlignment(0, JLabel.LEFT);

		JTableHeader header = table.getTableHeader();
		header.setDefaultRenderer(new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				comp.setBackground(new Color(45, 51, 63));
				comp.setForeground(Color.WHITE);
				setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201, 201, 201)));

				return comp;
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "  Danh sách lớp", "  Mã Gv", "  Mã lớp" }));
		table.setModel(getModelClassOfGv(m));
		
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column = columnModel.getColumn(1);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);
		
		TableColumn column1 = columnModel.getColumn(2);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);
		column1.setWidth(0);
		column1.setPreferredWidth(0);
		
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
	}

	public void ViewStudent() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("HỌC SINH");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth() + 1, (int) size.getHeight() + 1);

		pView.add(lblNewLabel);

		String[] list = { "  Tên", "  Lớp" };

		comboBoxSortALLSV = new JComboBox<>(list);
		comboBoxSortALLSV.setBounds(615, 35, 90, 22);
		pView.add(comboBoxSortALLSV);
		comboBoxSortALLSV.addActionListener(actionAdmin);

		JLabel lblNewLabel_2 = new JLabel("Sắp xếp :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(550, 30, 59, 28);
		pView.add(lblNewLabel_2);

		MyButton btnNewButton_1_1 = new MyButton("Thêm học sinh");
		btnNewButton_1_1.setRadius(10);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setColorOver(new Color(86, 98, 120));
		btnNewButton_1_1.setColorClick(new Color(45, 51, 63));
		btnNewButton_1_1.setColor(new Color(45, 51, 63));
		btnNewButton_1_1.setBorderColor(Color.white);
		btnNewButton_1_1.setBackground(new Color(45, 51, 63));
		btnNewButton_1_1.setBounds(10, 600, 110, 30);

		pView.add(btnNewButton_1_1);

		MyButton btnNewButton_1_1_1 = new MyButton("Xóa học sinh");
		btnNewButton_1_1_1.setRadius(10);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1.setColorOver(new Color(86, 98, 120));
		btnNewButton_1_1_1.setColorClick(new Color(45, 51, 63));
		btnNewButton_1_1_1.setColor(new Color(45, 51, 63));
		btnNewButton_1_1_1.setBorderColor(Color.white);
		btnNewButton_1_1_1.setBackground(new Color(45, 51, 63));
		btnNewButton_1_1_1.setBounds(130, 600, 110, 30);
		pView.add(btnNewButton_1_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 695, 500);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "  Tên học sinh", "  Lớp", "  Tên" });
		table = new MyTable();
		table.setModel(model);
		table.setRowHeight(30);
		table.setColor1(Color.WHITE);
		table.setColor2(Color.WHITE);
		table.setGridColor(new Color(201, 201, 201));
		// table.setShowGrid(false);
		table.setColumnAlignment(0, JLabel.LEFT);
		table.setCellAlignment(0, JLabel.LEFT);

		JTableHeader header = table.getTableHeader();
		header.setDefaultRenderer(new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				comp.setBackground(new Color(45, 51, 63));
				comp.setForeground(Color.WHITE);
				setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201, 201, 201)));

				return comp;
			}
		});

		table.setModel(getModelStudent(table));
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column = columnModel.getColumn(2);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);
		table.setDefaultEditor(Object.class, null);
		SortTable("  Tên");
		scrollPane.setViewportView(table);
		pView.add(scrollPane);

	}
	public void ViewAddGv() {
		l = new JFrame();
		l.setBounds(100, 100, 407, 391);
		l.setLocationRelativeTo(null);
		contentPane3 = new JPanel();
		contentPane3.setBackground(new Color(255, 255, 255));
		contentPane3.setBorder(new EmptyBorder(5, 5, 5, 5));

		l.setContentPane(contentPane3);
		contentPane3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã giáo viên :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(45, 90, 95, 41);
		contentPane3.add(lblNewLabel);
		
		JLabel lblTnTiKhon = new JLabel("Tên tài khoản :");
		lblTnTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnTiKhon.setBounds(45, 140, 95, 41);
		contentPane3.add(lblTnTiKhon);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu :");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtKhu.setBounds(45, 190, 95, 41);
		contentPane3.add(lblMtKhu);
		
		JLabel lblNewLabel_1 = new JLabel("Tên giáo viên :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(45, 40, 95, 41);
		contentPane3.add(lblNewLabel_1);
		
		textNameGv = new JTextField();
		textNameGv.setBounds(168, 52, 86, 20);
		contentPane3.add(textNameGv);
		textNameGv.setColumns(10);
		
		textIdGv = new JTextField();
		textIdGv.setBounds(168, 102, 86, 20);
		contentPane3.add(textIdGv);
		textIdGv.setColumns(10);
		
		textUser = new JTextField();
		textUser.setBounds(168, 152, 86, 20);
		contentPane3.add(textUser);
		textUser.setColumns(10);
		
		textPass = new JTextField();
		textPass.setBounds(168, 202, 86, 20);
		contentPane3.add(textPass);
		textPass.setColumns(10);
		
		buttonOkAddGv = new MyButton("OK");
		buttonOkAddGv.setBounds(132, 267, 89, 23);
		contentPane3.add(buttonOkAddGv);
		buttonOkAddGv.addActionListener(actionAdmin);
		
		l.setVisible(true);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	public DefaultTableModel getModelClasses(JTable table) {
		List<Class> classes = Class_dao.Instance().selectall();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Class c : classes) {
			List<Sv> listSV = Class_dao.Instance().selectSVinclass(c);
			Object[] row = { c.getTenlop(),String.valueOf(listSV.size()) , c.getIdclass() };
			model.addRow(row);
		}
		return model;
	}
	
	public void updateTableClass() {
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		table.setModel(getModelClasses(table));
	}
	public void updateTabelSvinClass(String idClass) {
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		System.out.println(idClass);
		table.setModel(getModelSVinClass(idClass));
	}

	public DefaultTableModel getModelTeacher() {
		List<Gv> listgv = Gv_dao.Instance().selectall();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Gv g : listgv) {
			Object[] row = { g.getTen() , g.getId()};
			model.addRow(row);
		}
		return model;
	}
	public void updateTableTeacher() {
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column3 = columnModel.getColumn(1);
		column3.setMinWidth(0);
		column3.setMaxWidth(0);
		column3.setWidth(0);
		column3.setPreferredWidth(0);
		table.setModel(getModelTeacher());
	}

	public DefaultTableModel getModelStudent(JTable table) {
		List<Sv> listSV = Sv_dao.Instance().selectall();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Sv s : listSV) {
			int lastIndex = s.getTen().lastIndexOf(" ");
			String lastName = s.getTen().substring(lastIndex + 1);
			if(s.getIdclass() != null) {
			Object[] row = { s.getTen(), s.getIdclass().getTenlop() ,lastName};
			model.addRow(row);
			}else {
				Object[] row = { s.getTen(), "Chưa có lớp", lastName };
				model.addRow(row);
			}
			
		}
		return model;
	}
	
	public DefaultTableModel getModelStudentNoClass(JTable table) {
		List<Sv> listSV = Sv_dao.Instance().selectall();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Sv s : listSV) {
			if(s.getIdclass() == null) {			
				int lastIndex = s.getTen().lastIndexOf(" ");
				String lastName = s.getTen().substring(lastIndex + 1);
				Object[] row = { s.getTen(), lastName,s.getIdSv() };
				model.addRow(row);
			}			
		}
		return model;
	}
	
	public DefaultTableModel getModelSVinClass(String idLop) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		List<Sv> listSV = Sv_dao.Instance().selectall();
		for (Sv s : listSV) {	
			if(s.getIdclass() != null) {
			if (s.getIdclass().getIdclass().equalsIgnoreCase(idLop)) {
				int lastIndex = s.getTen().lastIndexOf(" ");
				String lastName = s.getTen().substring(lastIndex + 1);
				model.addRow(new Object[] { s.getTen(), lastName ,s.getId(), idLop});
			}
			}
		}
		return model;
	}

	public String getIdLopbyName(String m) {
		List<Class> classes = Class_dao.Instance().selectall();
		for (Class c : classes) {
			if (c.getTenlop().equalsIgnoreCase(m)) {
				return c.getIdclass();
			}
		}
		return null;
	}

	public Gv getGvbyName(String m) {
		List<Gv> listgv = Gv_dao.Instance().selectall();
		for (Gv g : listgv) {
			if (g.getTen().equalsIgnoreCase(m)) {
				return g;
			}
		}
		return null;
	}

	public DefaultTableModel getModelClassOfGv(String m) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Gv g = getGvbyName(m);
		System.out.println(g);

		List<Giangday> dslop = g.getDanhsachlop();
		for (Giangday gd : dslop) {
			Object[] row = {gd.getMalop().getTenlop(), g.getMaGv(),gd.getMalop().getIdclass() };
			model.addRow(row);
		}
		return model;
	}
	public void updateTabelClassOfGv(String idgv) {
		Gv g = Gv_dao.Instance().selectbyid(idgv);
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column3 = columnModel.getColumn(1);
		column3.setMinWidth(0);
		column3.setMaxWidth(0);
		column3.setWidth(0);
		column3.setPreferredWidth(0);
		table.setModel(getModelClassOfGv(g.getTen()));
	}
	public void deleteClass(String idclass) {
		Sv_dao.Instance().updateSvBeforeDeleteClass(idclass);
		Class_dao.Instance().deletebyid(Class_dao.Instance().selectbyid(idclass));
	}
	public void deleteSvFromClass(String idsv) {
		Sv_dao.Instance().deleteSvFromClass(idsv);
	}
	public void addSvinClass(List<String> idSvs) {
		for (String idsv : idSvs) {
			System.out.println(idsv);
			Sv s = Sv_dao.Instance().selectbyid(idsv);
			s.setIdclass(Class_dao.Instance().selectbyid(idclass));
			System.out.println(s);
			Sv_dao.Instance().update(s);
		}
	}
	
	public void SortTable(String selectedColumn) {

	    TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
	    table.setRowSorter(sorter);

	    int columnIndex = table.getColumnModel().getColumnIndex(selectedColumn);
	    sorter.setComparator(columnIndex, new VietnameseComparator());
	    sorter.toggleSortOrder(columnIndex);
	}
	public void insertClass(String tenLop) {
		String id = UUID.randomUUID().toString();
		Class_dao.Instance().insert(new Class(id,tenLop,truonghoc_dao.Instance().selectbyid("01")));
	}
	public void deleteGv(String idgv) {
		
		Gv g = Gv_dao.Instance().selectbyid(idgv);
		
		if(g.getDanhsachlop() != null) {
			Giangday_dao.Instance().updateGiangDayBeforeDeleteGv(idgv);
		}
		for (Cauhoi c : Cauhoi_Dao.Instance().selectall()) {
			if(c.getNH()!= null) {
				System.out.println("a");
				if(c.getNH().getGiaovienquanli() !=null) {
					if(c.getNH().getGiaovienquanli().getMaGv().equals(idgv)) {
					System.out.println("aa");
						Cauhoi_Dao.Instance().updateBeforeDeleteGv(idgv,c.getNH().getIdNganHang());
					}
				}
			}
		}
		if(g.getKithi() != null) {
			KiThi_dao.Instance().updateKithiBeforeDeleteGv(idgv);
			if(g.getNH() != null) {
				NganhangDao.Instance().updateNGCHBeforeDeleteGv(idgv);
			}
		}
		Gv_dao.Instance().deletebyid(g);
	}
	public void AddGv(String name, String id, String user, String pass) {
		truonghoc truong = new truonghoc();
		truong.setId("01");
		Gv g = new Gv(id,name,truonghoc_dao.Instance().selectbyid(truong));
		g.setMaquyen(3);
		g.setId(id);
		
		Gv_dao.Instance().insert(g);
	}
	public void AddClassIntoGv() {
		
	}
	public void DeleteClassIntoGv(String idclass, String idgv) {
		Giangday_dao.Instance().deleteClassFromGv(idgv, idclass);
	}

}

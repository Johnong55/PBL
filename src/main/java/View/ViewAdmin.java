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
import DAO.Class_dao;
import DAO.Gv_dao;
import DAO.Sv_dao;
import DAO.truonghoc_dao;
import model.Class;
import model.Giangday;
import model.Gv;
import model.Sv;
import model.truonghoc;

import javax.swing.JComboBox;

public class ViewAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pView,contentPane1;
	public MyTable table;
	public MyButton btnNewButton, btnNewButton1, btnNewButton2, btnNewButton3_1, btnNewButton5,buttonAddClass,buttonDeleteClass,buttonAddSvInClass,buttonHuyAddClass,buttonOkAddClass;
	public JComboBox<String> comboBoxSortClass;
	public JTextField textField;
	public JFrame j;
	public JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAdmin frame = new ViewAdmin();
				frame.ViewHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Controller_Admin actionAdmin = new Controller_Admin(this);

	public ViewAdmin() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
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

		btnNewButton = new MyButton("Trang chủ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(10, 90, 137, 37);
		btnNewButton.setBackground(new Color(45, 51, 63));
		btnNewButton.setColorClick(new Color(45, 51, 63));
		btnNewButton.setColorOver(new Color(86, 98, 120));
		btnNewButton.setRadius(10);
		btnNewButton.setBorderColor(new Color(45, 51, 63));
		btnNewButton.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-home-20.png"))));
		panel.add(btnNewButton);
		btnNewButton.addActionListener(actionAdmin);

		btnNewButton1 = new MyButton("Lớp");
		btnNewButton1.setForeground(new Color(255, 255, 255));
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton1.setBounds(10, 138, 137, 37);
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
		btnNewButton2.setBounds(10, 186, 137, 37);
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
		btnNewButton3_1.setBounds(10, 234, 137, 37);
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

		//////////////////////////////////////////////////

	}

	public void ViewHome() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 11, 694, 639);
		lblNewLabel_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/homadmin.jpg"))));
		pView.add(lblNewLabel_1);

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
					String j =  table.getValueAt(i, 1).toString();
					ViewListSVinClass(m,j);
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

	public void ViewListSVinClass(String m,String soSv) {
		System.out.println(m);
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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "  Danh sách học sinh" }));
		table.setModel(getModelSVinClass(m, table,soSv));
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
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

		MyButton btnNewButton_1_1 = new MyButton("Thêm giáo viên");
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

		MyButton btnNewButton_1_1_1 = new MyButton("Xóa giáo viên");
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
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));
		scrollPane.getViewport().setBackground(Color.WHITE);

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "  Danh sách giáo viên" });
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
		table.setModel(getModelTeacher(table));
		table.setDefaultEditor(Object.class, null);

		scrollPane.setViewportView(table);
		pView.add(scrollPane);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
				int i = table.getSelectedRow();
				String m = table.getValueAt(i, 0).toString().substring(3);
				ViewClassOfTeacher(m);
				}
			}
		});

	}

	public void ViewClassOfTeacher(String m) {
		System.out.println(m);
		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("GIÁO VIÊN " + m);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth() + 1, (int) size.getHeight() + 1);

		pView.add(lblNewLabel);
		
		MyButton btnNewButton_1_1 = new MyButton("Thêm lớp");
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

		MyButton btnNewButton_1_1_1 = new MyButton("Xóa lớp");
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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "  Danh sách lớp" }));
		table.setModel(getModelNameClassOfGv(m, table));
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

		String[] list = { "Tên" };

		JComboBox<String> comboBox_1 = new JComboBox(list);
		comboBox_1.setBounds(615, 35, 90, 22);
		pView.add(comboBox_1);

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

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "  Tên học sinh", "  Lớp" });
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
		table.setDefaultEditor(Object.class, null);

		scrollPane.setViewportView(table);
		pView.add(scrollPane);

	}

	public DefaultTableModel getModelClasses(JTable table) {
		List<Class> classes = Class_dao.Instance().selectall();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Class c : classes) {
			List<Sv> listSV = Class_dao.Instance().selectSVinclass(c);
			Object[] row = { c.getTenlop(), listSV.size(), c.getIdclass() };
			model.addRow(row);
		}
		return model;
	}
	
	public void updateTableClass(JTable table) {
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		table.setModel(getModelClasses(table));
	}

	public DefaultTableModel getModelTeacher(JTable table) {
		List<Gv> listgv = Gv_dao.Instance().selectall();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int i =1;
		for (Gv g : listgv) {
			Object[] row = {i + ". " + g.getTen() };
			model.addRow(row);
			i++;
		}
		return model;
	}

	public DefaultTableModel getModelStudent(JTable table) {
		List<Sv> listSV = Sv_dao.Instance().selectall();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int i =1;
		for (Sv s : listSV) {
			if(s.getIdclass() != null) {
			Object[] row = { i + ". " + s.getTen(), s.getIdclass().getTenlop() };
			model.addRow(row);
			}else {
				Object[] row = { i + ". " + s.getTen(), "Chưa có lớp" };
				model.addRow(row);
			}
			i++;
			
		}
		return model;
	}

	public DefaultTableModel getModelSVinClass(String m, JTable table,String soSv) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if(soSv.equals("0")) {
		String idLop = getIdLopbyName(m);
		List<Sv> listSV = Sv_dao.Instance().selectall();
		int i =1;
		for (Sv s : listSV) {
			
			if (s.getIdclass().getIdclass().equalsIgnoreCase(idLop)) {
				model.addRow(new Object[] { i + ". " + s.getTen() });
				i++;
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

	public DefaultTableModel getModelNameClassOfGv(String m, JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Gv g = getGvbyName(m);
		System.out.println(g);

		List<Giangday> dslop = g.getDanhsachlop();
		int i = 1;
		for (Giangday gd : dslop) {
			Object[] row = { i + ". " + gd.getMalop().getTenlop() };
			model.addRow(row);
			i++;
		}
		return model;
	}
	public void deleteClass(String idclass) {
		List<Sv> listSv = new ArrayList<Sv>();
		listSv = Sv_dao.Instance().selectall();
		for (Sv s : listSv) {
			if(s.getIdclass().getIdclass().equals(idclass)) {
				Sv_dao.Instance().updateSvBeforeDeleteClass(idclass);;
			}
		}
		Class_dao.Instance().deletebyid(Class_dao.Instance().selectbyid(idclass));
	}
	
	public void SortTableClass(String selectedColumn) {

		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);

		int columnIndex = table.getColumnModel().getColumnIndex(selectedColumn);
		sorter.toggleSortOrder(columnIndex);
	}
	public void insertClass(String tenLop) {
		String id = UUID.randomUUID().toString();
		Class_dao.Instance().insert(new Class(id,tenLop,truonghoc_dao.Instance().selectbyid("01")));
	}

}

package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.persistence.Convert;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.FlowLayout;

import Controller.Controller_Admin;
import DAO.Cauhoi_Dao;
import DAO.Class_dao;
import DAO.DeThi_dao;
import DAO.Giangday_dao;
import DAO.Gv_dao;
import DAO.KiThi_dao;
import DAO.NganhangDao;
import DAO.Sv_dao;
import DAO.truonghoc_dao;
import model.Cauhoi;
import model.Class;
import model.DeThi;
import model.Giangday;
import model.Gv;
import model.KiThi;
import model.Nganhangcauhoi;
import model.Sv;
import model.truonghoc;
import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

import javax.swing.JComboBox;

public class ViewAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pView,contentPane1,contentPane2,pView1,contentPane3,pView2,contentPane4,contentPane5;
	public MyTable table,table1,table2;
	public MyButton btnNewButton1, btnNewButton2, btnNewButton3_1, btnNewButton5,buttonAddClass,
	buttonDeleteClass,buttonAddSvInClass,buttonHuyAddClass,buttonOkAddClass,buttonDeleteSvFromClass,
	buttonChonSvAddIntoClass,buttonAddGv,buttonDeleteGv,buttonOkAddGv,buttonDeleteClassInGv,buttonAddClassInGv,
	buttonChonClassAddIntoGv,buttonDeleteSvInStudent,buttonAddSvInStudent,buttonOkAddSv,buttonAddExam,buttonDeleteExam,
	buttonExam,buttonTest,buttonQuestion;
	public JComboBox<String> comboBoxSortClass,comboBoxSortALLSV,comboBoxLOP,comboBoxExam,comboBoxNHCH;
	public JTextField textField,textNameGv,textIdGv,textUser,textPass,textNameSv,textIdSv,textUserSv,textPassSv;
	public JScrollPane scrollPane = new JScrollPane();
	public JFrame j,k,l,z,x;
	public JLabel lblNewLabel_1;
	public String idclass,tenGv, idGv;
	public List<Sv> listSv = new ArrayList<Sv>();
	public List<Class> listClass = new ArrayList<Class>();
	public List<Gv> listgv = Gv_dao.Instance().selectall();
	public List<Nganhangcauhoi> NHCHs = NganhangDao.Instance().selectall();
	public Nganhangcauhoi NHCH = null;
	/**
	 * Launch the application.
	 */

	Controller_Admin actionAdmin = new Controller_Admin(this);

	public ViewAdmin(List<Sv> listsv,List<Class> listclass) {
		this.listSv= listsv;
		this.listClass = listclass;
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
		
		buttonExam = new MyButton("Kì thi");
		buttonExam.setRadius(10);
		buttonExam.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExam.setForeground(Color.WHITE);
		buttonExam.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonExam.setColorOver(new Color(86, 98, 120));
		buttonExam.setColorClick(new Color(45, 51, 63));
		buttonExam.setBorderColor(new Color(45, 51, 63));
		buttonExam.setBackground(new Color(45, 51, 63));
		buttonExam.setBounds(10, 234, 137, 37);
		buttonExam.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-result-20.png"))));
		panel.add(buttonExam);
		buttonExam.addActionListener(actionAdmin);
		
		buttonTest = new MyButton("Bài thi");
		buttonTest.setRadius(10);
		buttonTest.setHorizontalAlignment(SwingConstants.LEFT);
		buttonTest.setForeground(Color.WHITE);
		buttonTest.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonTest.setColorOver(new Color(86, 98, 120));
		buttonTest.setColorClick(new Color(45, 51, 63));
		buttonTest.setBorderColor(new Color(45, 51, 63));
		buttonTest.setBackground(new Color(45, 51, 63));
		buttonTest.setBounds(10, 282, 137, 37);
		buttonTest.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-test-20.png"))));
		panel.add(buttonTest);
		buttonTest.addActionListener(actionAdmin);
		
		buttonQuestion = new MyButton("Kho câu hỏi");
		buttonQuestion.setRadius(10);
		buttonQuestion.setHorizontalAlignment(SwingConstants.LEFT);
		buttonQuestion.setForeground(Color.WHITE);
		buttonQuestion.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonQuestion.setColorOver(new Color(86, 98, 120));
		buttonQuestion.setColorClick(new Color(45, 51, 63));
		buttonQuestion.setBorderColor(new Color(45, 51, 63));
		buttonQuestion.setBackground(new Color(45, 51, 63));
		buttonQuestion.setBounds(10, 330, 137, 37);
		buttonQuestion.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-question-20.png"))));
		panel.add(buttonQuestion);
		buttonQuestion.addActionListener(actionAdmin);

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
		this.tenGv = m;
		idGv = getGvbyName(m).getMaGv();
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
	
	public void ViewAddClassInGv() {
		z = new JFrame();
		z.setBounds(100, 100, 749, 623);
		z.setLocationRelativeTo(null);
		
		contentPane4 = new JPanel();
		contentPane4.setBackground(new Color(255, 255, 255));
		contentPane4.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane4.setLayout(null);
		
		z.setContentPane(contentPane4);

		pView2 = new JPanel();
		pView2.setBorder(null);
		pView2.setBackground(Color.WHITE);
		pView2.setBounds(10, 11, 714, 562);
		contentPane4.add(pView2);
		pView2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 695, 500);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "  Danh sách lớp", "  Số học sinh", "  Mã lớp" });
		table2 = new MyTable();
		table2.setModel(model);
		table2.setRowHeight(30);
		table2.setColor1(Color.WHITE);
		table2.setColor2(Color.WHITE);
		table2.setGridColor(new Color(201, 201, 201));
		// table.setShowGrid(false);
		table2.setColumnAlignment(0, JLabel.LEFT);
		table2.setCellAlignment(0, JLabel.LEFT);

		JTableHeader header = table2.getTableHeader();
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

		table2.setModel(getModelClassesAdd(table2));
		TableColumnModel columnModel = table2.getColumnModel();
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
		
		table2.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table2);
		pView2.add(scrollPane);
		
		buttonChonClassAddIntoGv = new MyButton("Thêm lớp");
		buttonChonClassAddIntoGv.setRadius(10);
		buttonChonClassAddIntoGv.setForeground(Color.WHITE);
		buttonChonClassAddIntoGv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonChonClassAddIntoGv.setColorOver(new Color(86, 98, 120));
		buttonChonClassAddIntoGv.setColorClick(new Color(45, 51, 63));
		buttonChonClassAddIntoGv.setColor(new Color(45, 51, 63));
		buttonChonClassAddIntoGv.setBorderColor(Color.white);
		buttonChonClassAddIntoGv.setBackground(new Color(45, 51, 63));
		buttonChonClassAddIntoGv.setBounds(297, 522, 116, 33);

		pView2.add(buttonChonClassAddIntoGv);
		
		buttonChonClassAddIntoGv.addActionListener(actionAdmin);
		
		z.setVisible(true);
		
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

		buttonAddSvInStudent = new MyButton("Thêm học sinh");
		buttonAddSvInStudent.setRadius(10);
		buttonAddSvInStudent.setForeground(Color.WHITE);
		buttonAddSvInStudent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonAddSvInStudent.setColorOver(new Color(86, 98, 120));
		buttonAddSvInStudent.setColorClick(new Color(45, 51, 63));
		buttonAddSvInStudent.setColor(new Color(45, 51, 63));
		buttonAddSvInStudent.setBorderColor(Color.white);
		buttonAddSvInStudent.setBackground(new Color(45, 51, 63));
		buttonAddSvInStudent.setBounds(10, 600, 110, 30);

		pView.add(buttonAddSvInStudent);
		buttonAddSvInStudent.addActionListener(actionAdmin);

		buttonDeleteSvInStudent = new MyButton("Xóa học sinh");
		buttonDeleteSvInStudent.setRadius(10);
		buttonDeleteSvInStudent.setForeground(Color.WHITE);
		buttonDeleteSvInStudent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonDeleteSvInStudent.setColorOver(new Color(86, 98, 120));
		buttonDeleteSvInStudent.setColorClick(new Color(45, 51, 63));
		buttonDeleteSvInStudent.setColor(new Color(45, 51, 63));
		buttonDeleteSvInStudent.setBorderColor(Color.white);
		buttonDeleteSvInStudent.setBackground(new Color(45, 51, 63));
		buttonDeleteSvInStudent.setBounds(130, 600, 110, 30);
		pView.add(buttonDeleteSvInStudent);
		
		buttonDeleteSvInStudent.addActionListener(actionAdmin);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 695, 500);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "  Tên học sinh", "  Lớp", "  Tên", "  Mã học sinh" });
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
		
		TableColumn column1 = columnModel.getColumn(3);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);
		column1.setWidth(0);
		column1.setPreferredWidth(0);
		
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
	public void ViewAddSv() {
		x = new JFrame();
		x.setBounds(100, 100, 407, 391);
		x.setLocationRelativeTo(null);
		contentPane5 = new JPanel();
		contentPane5.setBackground(new Color(255, 255, 255));
		contentPane5.setBorder(new EmptyBorder(5, 5, 5, 5));

		x.setContentPane(contentPane5);
		contentPane5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã học sinh :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(45, 90, 95, 41);
		contentPane5.add(lblNewLabel);
		
		JLabel lblTnTiKhon = new JLabel("Tên tài khoản :");
		lblTnTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnTiKhon.setBounds(45, 140, 95, 41);
		contentPane5.add(lblTnTiKhon);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu :");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtKhu.setBounds(45, 190, 95, 41);
		contentPane5.add(lblMtKhu);
		
		JLabel lblNewLabel_1 = new JLabel("Tên học sinh :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(45, 40, 95, 41);
		contentPane5.add(lblNewLabel_1);
		
		textNameSv = new JTextField();
		textNameSv.setBounds(168, 52, 86, 20);
		contentPane5.add(textNameSv);
		textNameSv.setColumns(10);
		
		textIdSv = new JTextField();
		textIdSv.setBounds(168, 102, 86, 20);
		contentPane5.add(textIdSv);
		textIdSv.setColumns(10);
		
		textUserSv = new JTextField();
		textUserSv.setBounds(168, 152, 86, 20);
		contentPane5.add(textUserSv);
		textUserSv.setColumns(10);
		
		textPassSv = new JTextField();
		textPassSv.setBounds(168, 202, 86, 20);
		contentPane5.add(textPassSv);
		textPassSv.setColumns(10);
		
		buttonOkAddSv = new MyButton("OK");
		buttonOkAddSv.setBounds(132, 267, 89, 23);
		contentPane5.add(buttonOkAddSv);
		buttonOkAddSv.addActionListener(actionAdmin);
		
		comboBoxLOP = new JComboBox<String>();
		for (Class c : listClass) {
			comboBoxLOP.addItem(c.getTenlop());
		}
		comboBoxLOP.setBackground(new Color(255, 255, 255));
		comboBoxLOP.setBounds(293, 51, 65, 22);
		contentPane5.add(comboBoxLOP);
		
		x.setVisible(true);
	}
	
	public void ViewExam() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("KÌ THI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth() + 1, (int) size.getHeight() + 1);
		
		buttonDeleteExam = new MyButton("Xóa kì thi");
		buttonDeleteExam.setRadius(10);
		buttonDeleteExam.setForeground(Color.WHITE);
		buttonDeleteExam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonDeleteExam.setColorOver(new Color(86, 98, 120));
		buttonDeleteExam.setColorClick(new Color(45, 51, 63));
		buttonDeleteExam.setColor(new Color(45, 51, 63));
		buttonDeleteExam.setBorderColor(Color.WHITE);
		buttonDeleteExam.setBackground(new Color(45, 51, 63));
		buttonDeleteExam.setBounds(10, 600, 110, 30);

		pView.add(buttonDeleteExam);
		buttonDeleteExam.addActionListener(actionAdmin);

		pView.add(lblNewLabel);

		String[] list = { "  Lớp", "  Môn", "  Tên kì thi", "  Ngày thi", "  Thời gian bắt đầu", "  Thời gian thi",
				"  Số câu hỏi" };

		comboBoxExam = new JComboBox<>(list);
		comboBoxExam.setBounds(615, 35, 90, 22);
		pView.add(comboBoxExam);

		comboBoxExam.addActionListener(actionAdmin);

		JLabel lblNewLabel_2 = new JLabel("Sắp xếp :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(550, 30, 59, 28);
		pView.add(lblNewLabel_2);

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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "  Lớp", "  Môn", "  Tên kì thi",
				"  Ngày thi", "  Thời gian bắt đầu", "  Thời gian thi", "  Số câu hỏi", "  Mã kì thi" }));
		table.setModel(getModelExam());
		table.setDefaultEditor(Object.class, null);
		// ẩn mã kì thi
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column = columnModel.getColumn(7);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);
		scrollPane.setViewportView(table);

		TableColumnModel columnresize = table.getColumnModel();
		columnresize.getColumn(0).setPreferredWidth(30);
		columnresize.getColumn(1).setPreferredWidth(40);
		columnresize.getColumn(2).setPreferredWidth(60);
		columnresize.getColumn(5).setPreferredWidth(50);
		columnresize.getColumn(6).setPreferredWidth(50);
	}
	
	public void ViewQuestions() {
		
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		int size = NHCHs.size();
		String[] tenNHCH = new String[size];

		for (int i = 0; i < size; i++) {
		    tenNHCH[i] = NHCHs.get(i).getIdNganHang();
		}
		
		comboBoxNHCH = new JComboBox<>(tenNHCH);
		comboBoxNHCH.setBounds(615, 35, 90, 22);
		pView.add(comboBoxNHCH);
		comboBoxNHCH.addActionListener(actionAdmin);


		JLabel lblNewLabel_2 = new JLabel("Ngân hàng câu hỏi :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(478, 30, 131, 28);
		pView.add(lblNewLabel_2);
		
		this.NHCH = getNHCHByName(NHCHs.get(0).getIdNganHang());
		
		DrawQuestion(NHCHs.get(0).getSoluong());
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Nganhangcauhoi getNHCHByName(String name) {
		for (Nganhangcauhoi nganhangcauhoi : NHCHs) {
			if(nganhangcauhoi.getIdNganHang().equals(name)) {
				return nganhangcauhoi;
			}
		}
		return null;
	}
	
	public void DrawQuestion(int sl) {
        JViewport viewport = scrollPane.getViewport();
        viewport.removeAll();
		scrollPane.repaint();
		scrollPane.revalidate();
		if(sl == 0) {
			scrollPane.setVisible(false);
			JLabel l = new JLabel("CHƯA CÓ CÂU HỎI");
			l.setFont(new Font("Tahoma", Font.PLAIN, 14));
			l.setHorizontalAlignment(SwingConstants.CENTER);
			l.setBounds(250, 200, 208, 52);
			pView.add(l);
		}else {
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.getViewport().setBackground(Color.WHITE);
			scrollPane.setBounds(10, 89, 695, 500);
			scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));
			pView.add(scrollPane);
			
			JPanel panel_1 = new JPanel();
			scrollPane.setViewportView(panel_1);
			panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
			
			for (int i = 0; i < sl; i++) {
			    JPanel questionPanel = createQuestionPanel(i);
			    panel_1.add(questionPanel);
			}
		}
	}
	
	public DefaultTableModel getModelExam() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		List<KiThi> kthi = KiThi_dao.Instance().selectall();
		for (Gv g : listgv) {
			String idgv = g.getId();
			for (KiThi k : kthi) {
				if (idgv.equalsIgnoreCase(k.getGv().getId())) {
					Object[] row = {k.getLop().getTenlop(), k.getNganhangcauhoi().getIdNganHang(), k.getMota(),
							k.getDate().toString(), k.getThoigianbatdau().toString(),
						String.valueOf(k.getThoigianlambai()),String.valueOf(k.getSl()),k.getId() };
					model.addRow(row);
				}
			}
		}
		return model;
	}

	public DefaultTableModel getModelClasses(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Class c : listClass) {
			if(!c.getIdclass().equals("00")) {
				Object[] row = { c.getTenlop(),(c.getSvs() == null) ? "0" : String.valueOf(c.getSvs().size()) , c.getIdclass() };
				model.addRow(row);
			}
		}
		return model;
	}
	
	public DefaultTableModel getModelClassesAdd(JTable table) {
		Gv g = getGvbyName(tenGv);
		List<Giangday> gd = g.getDanhsachlop();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int i = 1;
		for (Class c : listClass) {
			for (Giangday giangday : gd) {
				if(giangday.getMalop().getIdclass().equals(c.getIdclass())) {
					i = -1;
					break;
				}
			}
			if(!c.getIdclass().equals("00") && i == 1) {
				Object[] row = { c.getTenlop(),(c.getSvs() == null) ? "0" : String.valueOf(c.getSvs().size()) , c.getIdclass() };
				model.addRow(row);
			}else if(i == -1){
				i = 1;
			}
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
		table.setModel(getModelSVinClass(idClass));
	}

	public DefaultTableModel getModelTeacher() {
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
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Sv s : listSv) {
			int lastIndex = s.getTen().lastIndexOf(" ");
			String lastName = s.getTen().substring(lastIndex + 1);
			if(s.getIdclass() != null) {
			Object[] row = { s.getTen(), s.getIdclass().getTenlop() ,lastName,s.getIdSv()};
			model.addRow(row);
			}else {
				Object[] row = { s.getTen(), "Chưa có lớp", lastName, s.getIdSv() };
				model.addRow(row);
			}
			
		}
		return model;
	}
	public void updateTableStudent() {
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		table.setModel(getModelStudent(table));
	}
	
	public DefaultTableModel getModelStudentNoClass(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Sv s : listSv) {
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
		
		for (Sv s : listSv ) {
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
		for (Class c : listClass) {
			if (c.getTenlop().equalsIgnoreCase(m)) {
				return c.getIdclass();
			}
		}
		return null;
	}

	public Gv getGvbyName(String m) {
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
	public Class getClassById(String id) {
	    for (Class class1 : listClass) {
	        if (class1.getIdclass().equals(id)) {
	            return class1;
	        }
	    }
	    return null;
	}

	public void deleteClass(List<String> idclasses) {
		for (String id : idclasses) {
			Class c = getClassById(id);
			listClass.remove(c);
		
		for (Sv sv : listSv) {
			if(sv.getIdclass() != null) {
				if(sv.getIdclass().getIdclass().equals(id)) {
					sv.setIdclass(null);
				}
			}
		}
		List<Giangday> GD = Giangday_dao.Instance().selectall();
		for (Giangday giangday : GD) {
			if(giangday.getMalop().getIdclass().equals(id)) {
				Giangday_dao.Instance().deletebyid(giangday);
			}
		}
		for (Gv gv : listgv) {
			List<Giangday> GD1 = gv.getDanhsachlop();
			for (Giangday giangday : GD1) {
				if(giangday.getMalop().getIdclass().equals(id)) {
					GD1.remove(giangday);
					break;
				}
			}
		}
		Sv_dao.Instance().updateSvBeforeDeleteClass(id);
		Class_dao.Instance().deletebyid(Class_dao.Instance().selectbyid(id));
		}
	}
	public void deleteSvFromClass(List<String> idSvs) {
		Class c = getClassById(idclass);
		List<Sv> svs = c.getSvs();
		for (String idsv : idSvs) {
			Sv s = getSvById(idsv);
			s.setIdclass(null);
			svs.remove(s);
			Sv_dao.Instance().deleteSvFromClass(idsv);
		}
		c.setSvs(svs);
	}
	public Sv getSvById(String id) {
		for (Sv sv : listSv) {
			if(sv.getIdSv().equals(id)) {
				return sv;
			}
		}
		return null;
	}
	public Gv getGvById(String id) {
		for (Gv gv : listgv) {
			if(gv.getMaGv().equals(id)) {
				return gv;
			}
		}
		return null;
	}
	public void addSvinClass(List<String> idSv) {
		Class c = getClassById(idclass);
		System.out.println(c);
		List<Sv> svs = c.getSvs();
		for (String idsv : idSv) {
			Sv s = getSvById(idsv);
			s.setIdclass(c);
			svs.add(s);
			Sv_dao.Instance().update(s);
		}
		updateTabelSvinClass(idclass);
		c.setSvs(svs);
		k.setVisible(false);
		JOptionPane.showMessageDialog(null, "Thêm học sinh thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
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
		Class c = new Class(id,tenLop,truonghoc_dao.Instance().selectbyid("01"));
		listClass.add(c);
		updateTableClass();
		j.setVisible(false);
		JOptionPane.showMessageDialog(null, "Tạo lớp thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		Class_dao.Instance().insert(c);
	}
	public void deleteGv(List<String> idGvs) {
		for (String idgv : idGvs) {
			Gv g = getGvById(idgv);
			SetupBeforeDelGv(g, idgv);
			listgv.remove(g);
			g.setGiangDay(null);
			Gv_dao.Instance().deletebyid(g);
		}
	}
	public void SetupBeforeDelGv(Gv g, String idgv) {
		if(g.getDanhsachlop() != null) {
			System.out.println("ấ");
			for (Giangday gd : g.getDanhsachlop()) {
				System.out.println(gd);
				Giangday_dao.Instance().deletebyid(gd);
			}
		}
		for (Cauhoi c : Cauhoi_Dao.Instance().selectall()) {
			if(c.getNH()!= null) {
				if(c.getNH().getGiaovienquanli() !=null) {
					if(c.getNH().getGiaovienquanli().getMaGv().equals(idgv)) {
						Cauhoi_Dao.Instance().updateBeforeDeleteGv(idgv,c.getNH().getIdNganHang());
					}
				}
			}
		}
		List<DeThi> dethi = DeThi_dao.Instance().selectall();
		for (KiThi kt : g.getKithi()) {
			if(kt.getId() != null) {
				for (DeThi deThi2 : dethi) {
					if(deThi2.getKithi().getId() != null) {
						if(deThi2.getKithi().getId().equals(kt.getId())) {
							DeThi_dao.Instance().DethiNULLKithiFromGv(kt.getId());
						}
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
	}
	
	public void AddGv(String name, String id, String user, String pass) {
		int i = 1;
		for (Gv gv : listgv) {
			if(gv.getId().equals(id)) {
				i = -1;
				break;
			}else if(gv.getUsername().equals(user)) {
				i = -2;
				break;
			}
		}
		if(i == 1) {
			truonghoc truong = new truonghoc();
			truong.setId("01");
			Gv g = new Gv(id,name,truonghoc_dao.Instance().selectbyid(truong));
			g.setMaquyen(1);
			g.setId(id);
			g.setUsername(user);
			listgv.add(g);
			updateTableTeacher();
			l.setVisible(false);
			Gv_dao.Instance().insert(g);
			JOptionPane.showMessageDialog(null, "Tạo giáo viên thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}else if(i == -1) {
			JOptionPane.showMessageDialog(null, "Mã giáo viên đã tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}else if(i == -2) {
			JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void AddClassIntoGv(List<String> idClasses) {
		Gv g = getGvbyName(tenGv);
		List<Giangday> GD = g.getDanhsachlop();
		for (String idclass : idClasses) {
			Giangday gd = new Giangday(g, getClassById(idclass));
			
			int idGD = Integer.parseInt(g.getMaGv() + idclass);
			gd.setId(idGD);
			GD.add(gd);
			Giangday_dao.Instance().insert(gd);
		}
		g.setGiangDay(GD);
	}
	public void DeleteClassIntoGv(List<String> idClasses, String idgv) {
		Gv g = getGvById(idgv);
		List<Giangday> GD = g.getDanhsachlop();
		for (String idclass : idClasses) {
			for (Giangday gd : GD) {
				if(gd.getMalop().getIdclass().equals(idclass)) {
					GD.remove(gd);
					System.out.println(gd.getId());
					System.out.println(gd.getMaGv());
					System.out.println(gd.getMalop());
					Giangday_dao.Instance().deletebyid(gd);
					break;
				}
			}
		}
		g.setGiangDay(GD);
	}
	public void deleteSvInStudent(List<String> idSvs) {
		for (String idsv : idSvs) {
			Sv s = getSvById(idsv);
			Sv_dao.Instance().deletebyid(s);
			listSv.remove(s);
		}
	}
	public void AddSv(String name, String id, String user, String pass, String tenlop) {
		int i = 1;
		for (Sv sv : listSv) {
			if(sv.getId().equals(id)) {
				i = -1;
				break;
			}else if(sv.getUsername() != null) {
				if(sv.getUsername().equals(user)) {
					i = -2;
					break;
				}
			}
		}
		if(i == 1) {
			Class c = new Class("00","Chưa có lớp",new truonghoc("01"));
			for (Class class1 : listClass) {
				if(class1.getTenlop().equals(tenlop)) {
					c = class1;
				}
			}
			Sv s = new Sv(id,name,c);
			s.setMaquyen(2);
			s.setId(id);
			s.setUsername(user);
			listSv.add(s);
			updateTableStudent();
			x.setVisible(false);
			Sv_dao.Instance().insert(s);
			JOptionPane.showMessageDialog(null, "Tạo giáo viên thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}else if(i == -1) {
			JOptionPane.showMessageDialog(null, "Mã giáo viên đã tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}else if(i == -2) {
			JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void deleteExam(String id) {
		KiThi_dao.Instance().deletebyid(KiThi_dao.Instance().selectbyid(id));
	}
	public void updateTableExam(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		table.setModel(getModelExam());
	}
	///////////////////////////////////////////////////////////////////////////////////////////////
	private JPanel createQuestionPanel(int questionIndex) {
	    JPanel questionPanel = new JPanel();
	    questionPanel.setLayout(new GridLayout(0, 1, 10, 10));
	    questionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	    JPanel questionLabelPanel = createQuestionLabelPanel(questionIndex);
	    JPanel questionContentPanel = createQuestionContentPanel(questionIndex);
	    JPanel answerPanel = createAnswerPanel(questionIndex);

	    questionPanel.add(questionLabelPanel);
	    questionPanel.add(questionContentPanel);
	    questionPanel.add(answerPanel);

	    return questionPanel;
	}

	private JPanel createQuestionLabelPanel(int questionIndex) {
	    JPanel questionLabelPanel = new JPanel();
	    questionLabelPanel.setLayout(new BorderLayout());

	    JLabel questionLabel = new JLabel("Câu hỏi " + (questionIndex + 1));
	    questionLabel.setFont(new Font("Arial", Font.BOLD, 14));
	    questionLabelPanel.add(questionLabel, BorderLayout.CENTER);
	    
	    JLabel difficultyLabel = new JLabel("Mức độ : " + NHCH.getListcauhoi().get(questionIndex).getMucdo());
	    difficultyLabel.setFont(new Font("Arial", Font.ITALIC, 12));
	    questionLabelPanel.add(difficultyLabel, BorderLayout.EAST);

	    return questionLabelPanel;
	}

	private JPanel createQuestionContentPanel(int questionIndex) {
	    JPanel questionContentPanel = new JPanel();
	    questionContentPanel.setLayout(new BorderLayout());

	    JTextArea questionTextArea = new JTextArea();
	    questionTextArea.setText(NHCH.getListcauhoi().get(questionIndex).getNoidung());
	    questionTextArea.setLineWrap(true);
	    questionTextArea.setWrapStyleWord(true);
	    questionTextArea.setEditable(false);

	    questionContentPanel.add(new JScrollPane(questionTextArea), BorderLayout.CENTER);

	    return questionContentPanel;
	}

	private JPanel createAnswerPanel(int questionIndex) {
	    JPanel answerPanel = new JPanel();
	    answerPanel.setLayout(new GridLayout(4, 1, 5, 5));

	    for (int i = 0; i < 4; i++) {
	        JPanel answerItemPanel = createAnswerItemPanel(questionIndex, i);
	        answerPanel.add(answerItemPanel);
	    }

	    return answerPanel;
	}

	private JPanel createAnswerItemPanel(int questionIndex, int answerIndex) {
	    JPanel answerItemPanel = new JPanel();
	    answerItemPanel.setLayout(new BorderLayout());

	    JLabel answerLabel = new JLabel("Đáp án " + (char)(65 + answerIndex) + ": ");
	    answerLabel.setFont(new Font("Arial", Font.BOLD, 13));

	    JTextArea answerTextArea = new JTextArea();
	    String dapan = NHCH.getListcauhoi().get(questionIndex).getDapan();
	    if(answerIndex == 0) {
	    	String dapanA = NHCH.getListcauhoi().get(questionIndex).getDapAnA();
	    	if(dapanA.equals(dapan)) {
	    		answerTextArea.setForeground(Color.red);
	    	}
		    answerTextArea.setText(dapanA);
	    }else if(answerIndex == 1) {
	    	String dapanB = NHCH.getListcauhoi().get(questionIndex).getDapAnB();
	    	if(dapanB.equals(dapan)) {
	    		answerTextArea.setForeground(Color.red);
	    	}
		    answerTextArea.setText(dapanB);	    
		}else if(answerIndex == 2) {
	    	String dapanC = NHCH.getListcauhoi().get(questionIndex).getDapAnC();
	    	if(dapanC.equals(dapan)) {
	    		answerTextArea.setForeground(Color.red);
	    	}
		    answerTextArea.setText(dapanC);	
	    }else if(answerIndex == 3) {
	    	String dapanD = NHCH.getListcauhoi().get(questionIndex).getDapAnD();
	    	if(dapanD.equals(dapan)) {
	    		answerTextArea.setForeground(Color.red);
	    	}
		    answerTextArea.setText(dapanD);	
	    }
	    answerTextArea.setLineWrap(true);
	    answerTextArea.setWrapStyleWord(true);
	    answerTextArea.setEditable(false);

	    answerItemPanel.add(answerLabel, BorderLayout.WEST);
	    answerItemPanel.add(new JScrollPane(answerTextArea), BorderLayout.CENTER);

	    return answerItemPanel;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
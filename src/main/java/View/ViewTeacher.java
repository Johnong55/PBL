package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.UIManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.Gv;
import model.KiThi;
import model.Nganhangcauhoi;
import DAO.Cauhoi_Dao;
import DAO.Class_dao;
import DAO.Gv_dao;
import DAO.KiThi_dao;
import DAO.NganhangDao;
import DAO.Sv_dao;
import model.Sv;
import model.Cauhoi;
import model.Class;
import model.Giangday;
import Controller.Controller_Teacher;

public class ViewTeacher extends JFrame {

	private JPanel contentPane, contentPane1;
	public JFrame j;
	public JPanel pView;
	public MyButton buttonClass, buttonHome, buttonProfile, buttonExam, buttonNew, buttonLogout, buttonCreateExam,
			buttonChangePass, NewQuestion, NewExam, buttonDeleteSv, buttonAddExam, buttonDeleteExam, buttonChangeImage,
			buttonTaoCauHoi, buttonLuuCauHoi, buttonExitAddQuestion, buttonHuyUpdateExam, buttonLuuExam,
			buttonUpdateExam;
	public JPlaceholderTextField textField, textField_1, textField_2, textField_3, textField_4, textMoTa;
	public JComboBox<String> comboBoxSortClass, comboBoxExam, comboBoxNganHangCauHoi, comboBoxMucDo, comboBoxTenLop,
			comboBoxTenNGCH;
	public MyTable table;
	public JLabel labelImage, labelIdKitThi;
	public JTextField tenNGCH;
	public JButton buttonOK, buttonHuy;
	public JTextArea DapAnA, DapAnB, DapAnC, DapAnD, NoiDung;
	public JRadioButton rdbtnNewRadioButton, rdbtnNewRadioButton_1, rdbtnNewRadioButton_2, rdbtnNewRadioButton_3;
	public PlaceholderFormattedTextField dateField;
	public PlaceholderFormattedTextField timeField;
	public ButtonGroup onechoice;
	public Gv g;

	Controller_Teacher actionTeacher = new Controller_Teacher(this);

	public ViewTeacher(Gv gv) {
		this.g = gv;
		System.out.println(g);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 900, 700);
		ViewMenu();
		ViewHome();
		setVisible(true);
	}

	public void ViewMenu() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		pView = new JPanel();
		pView.setBorder(null);
		pView.setBackground(new Color(255, 255, 255));
		pView.setBounds(170, 0, 715, 661);
		contentPane.add(pView);
		pView.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 185, 185));
		panel.setBounds(0, 0, 170, 661);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(45, 11, 75, 70);

		lblNewLabel.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/logo.png"))
						.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH)));

		panel.add(lblNewLabel);

		buttonHome = new MyButton("Trang chủ");
		buttonHome.setForeground(new Color(255, 255, 255));
		buttonHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonHome.setHorizontalAlignment(SwingConstants.LEFT);
		buttonHome.setBounds(10, 90, 137, 37);
		buttonHome.setBackground(new Color(50, 185, 185));
		buttonHome.setColorClick(new Color(50, 185, 185));
		buttonHome.setColorOver(new Color(100, 241, 241));
		buttonHome.setRadius(10);
		buttonHome.setBorderColor(new Color(50, 185, 185));
		buttonHome.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-home-20.png"))));
		buttonHome.addActionListener(actionTeacher);
		panel.add(buttonHome);

		buttonClass = new MyButton("Lớp");
		buttonClass.setForeground(new Color(255, 255, 255));
		buttonClass.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonClass.setHorizontalAlignment(SwingConstants.LEFT);
		buttonClass.setBounds(10, 138, 137, 37);
		buttonClass.setBackground(new Color(50, 185, 185));
		buttonClass.setColorClick(new Color(50, 185, 185));
		buttonClass.setColorOver(new Color(100, 241, 241));
		buttonClass.setRadius(10);
		buttonClass.setBorderColor(new Color(50, 185, 185));
		buttonClass.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-class-20.png"))));
		buttonClass.addActionListener(actionTeacher);
		panel.add(buttonClass);

		buttonExam = new MyButton("Kì thi");
		buttonExam.setForeground(new Color(255, 255, 255));
		buttonExam.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonExam.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExam.setBounds(10, 186, 137, 37);
		buttonExam.setBackground(new Color(50, 185, 185));
		buttonExam.setColorClick(new Color(50, 185, 185));
		buttonExam.setColorOver(new Color(100, 241, 241));
		buttonExam.setRadius(10);
		buttonExam.setBorderColor(new Color(50, 185, 185));
		buttonExam.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-result-20.png"))));
		buttonExam.addActionListener(actionTeacher);
		panel.add(buttonExam);

		buttonProfile = new MyButton("Cá nhân");
		buttonProfile.setForeground(new Color(255, 255, 255));
		buttonProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonProfile.setHorizontalAlignment(SwingConstants.LEFT);
		buttonProfile.setBounds(10, 234, 137, 37);
		buttonProfile.setBackground(new Color(50, 185, 185));
		buttonProfile.setColorClick(new Color(50, 185, 185));
		buttonProfile.setColorOver(new Color(100, 241, 241));
		buttonProfile.setRadius(10);
		buttonProfile.setBorderColor(new Color(50, 185, 185));
		buttonProfile.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(getClass().getResource("/view/image/icons8-male-user-20.png"))));
		buttonProfile.addActionListener(actionTeacher);
		panel.add(buttonProfile);

		buttonNew = new MyButton("Tạo mới");
		buttonNew.setForeground(new Color(255, 255, 255));
		buttonNew.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonNew.setHorizontalAlignment(SwingConstants.LEFT);
		buttonNew.setBounds(10, 282, 137, 37);
		buttonNew.setBackground(new Color(50, 185, 185));
		buttonNew.setColorClick(new Color(50, 185, 185));
		buttonNew.setColorOver(new Color(100, 241, 241));
		buttonNew.setRadius(10);
		buttonNew.setBorderColor(new Color(50, 185, 185));
		buttonNew.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-add-new-20.png"))));
		buttonNew.addActionListener(actionTeacher);
		panel.add(buttonNew);

		buttonLogout = new MyButton("Đăng xuất");
		buttonLogout.setForeground(new Color(255, 255, 255));
		buttonLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonLogout.setHorizontalAlignment(SwingConstants.LEFT);
		buttonLogout.setBounds(10, 550, 137, 37);
		buttonLogout.setBackground(new Color(50, 185, 185));
		buttonLogout.setColorClick(new Color(50, 185, 185));
		buttonLogout.setColorOver(new Color(100, 241, 241));
		buttonLogout.setRadius(10);
		buttonLogout.setBorderColor(new Color(50, 185, 185));
		buttonLogout.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-logout-20.png"))));
		buttonLogout.addActionListener(actionTeacher);
		panel.add(buttonLogout);

	}

	/**
	 * Create the frame.
	 */
	public void ViewHome() {

		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		// panel chua bieu do
		PanelRound panel_1 = new PanelRound(15);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 80, 440, 280);
		panel_1.setBground(Color.WHITE);
		panel_1.setLayout(null);
		// bỉu do
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Dưới 5 điểm", 15);
		dataset.setValue("5-6,5 điểm", 10);
		dataset.setValue("6,5-8 điểm", 66);
		dataset.setValue("8-10 điểm", 9);

		JFreeChart chart = ChartFactory.createPieChart("Recent test results", dataset, true, true, true);
		PiePlot pie = (PiePlot) chart.getPlot();
		pie.setSectionPaint("Dưới 5 điểm", new Color(50, 185, 185));
		pie.setSectionPaint("5-6,5 điểm", Color.yellow);
		pie.setSectionPaint("6,5-8 điểm", Color.red);
		pie.setSectionPaint("8-10 điểm", Color.green);
		pie.setBackgroundPaint(Color.WHITE);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(null);
		chartPanel.setForeground(new Color(255, 255, 255));
		chartPanel.setBounds(10, 10, 420, 260);
		chartPanel.setBackground(new Color(255, 255, 255));

		panel_1.add(chartPanel);

		pView.add(panel_1);

		// panel chua creat test ben phai
		PanelRound panel_2 = new PanelRound(15);
		panel_2.setBackground(new Color(221, 221, 221));
		panel_2.setBounds(455, 391, 255, 255);
		panel_2.setBorderColor(getBackground());
		panel_2.setBground(Color.WHITE);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tạo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 11, 55, 18);
		panel_2.add(lblNewLabel_1);

		buttonCreateExam = new MyButton("Tạo kì thi");
		buttonCreateExam.setForeground(new Color(255, 255, 255));
		buttonCreateExam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonCreateExam.setBounds(37, 200, 181, 40);
		buttonCreateExam.setBackground(new Color(50, 185, 185));
		buttonCreateExam.setRadius(10);
		buttonCreateExam.setColor(new Color(50, 185, 185));
		buttonCreateExam.setBorderColor(Color.WHITE);
		buttonCreateExam.setColorOver(new Color(100, 241, 241));
		buttonCreateExam.setColorClick(new Color(50, 185, 185));
		panel_2.add(buttonCreateExam);

		buttonCreateExam.addActionListener(actionTeacher);

		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(10, 36, 235, 153);
		lblNewLabel_3.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/study.jpg"))
						.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH)));

		panel_2.add(lblNewLabel_3);

		pView.add(panel_2);

		JLabel lblNewLabel = new JLabel("Chào, " + g.getTen());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 0, (int) size.getWidth() + 1, (int) size.getHeight() + 1);

		pView.add(lblNewLabel);

		// panel chua schedule test ben phai 455, 105, 255, 255 455, 391, 255, 255
		PanelRound panel_2_1 = new PanelRound(15);
		panel_2_1.setLayout(null);
		panel_2_1.setBorderColor(UIManager.getColor("Button.background"));
		panel_2_1.setBground(Color.WHITE);
		panel_2_1.setBackground(new Color(221, 221, 221));
		panel_2_1.setBounds(455, 105, 255, 255);

		JLabel lblNewLabel_1_1 = new JLabel("Tạo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 11, 116, 18);
		panel_2_1.add(lblNewLabel_1_1);

		buttonTaoCauHoi = new MyButton("Tạo câu hỏi");
		buttonTaoCauHoi.setRadius(10);
		buttonTaoCauHoi.setForeground(Color.WHITE);
		buttonTaoCauHoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonTaoCauHoi.setColorOver(new Color(100, 241, 241));
		buttonTaoCauHoi.setColorClick(new Color(50, 185, 185));
		buttonTaoCauHoi.setColor(new Color(50, 185, 185));
		buttonTaoCauHoi.setBorderColor(Color.WHITE);
		buttonTaoCauHoi.setBackground(new Color(50, 185, 185));
		buttonTaoCauHoi.setBounds(37, 200, 181, 40);
		panel_2_1.add(buttonTaoCauHoi);

		buttonTaoCauHoi.addActionListener(actionTeacher);

		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setBounds(10, 36, 235, 153);

		lblNewLabel_3_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(getClass().getResource("/view/image/question.jpg"))
				.getScaledInstance(lblNewLabel_3_1.getWidth(), lblNewLabel_3_1.getHeight(), Image.SCALE_SMOOTH)));

		panel_2_1.add(lblNewLabel_3_1);

		pView.add(panel_2_1);

		// panel duoi bieu do
		PanelRound panel_1_1 = new PanelRound(15);
		panel_1_1.setLayout(null);
		panel_1_1.setBorderColor(UIManager.getColor("Button.background"));
		panel_1_1.setBground(Color.WHITE);
		panel_1_1.setBackground(new Color(221, 221, 221));
		panel_1_1.setBounds(10, 390, 440, 250);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 440, 250);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));
		panel_1_1.add(scrollPane);

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
				comp.setBackground(new Color(50, 185, 185));
				comp.setForeground(Color.WHITE);
				setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201, 201, 201)));

				return comp;
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "  Lớp", "  Môn", "  Tên kì thi",
				"  Ngày thi", "  Thời gian bắt đầu", "  Thời gian thi", "  Số câu hỏi", "  Mã kì thi" }));
		table.setModel(getModelExam(g));
		table.setDefaultEditor(Object.class, null);
		// ẩn mã kì thi
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column = columnModel.getColumn(7);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);
		scrollPane.setViewportView(table);

		TableColumnModel columnModel1 = table.getColumnModel();
		TableColumn column1 = columnModel1.getColumn(5);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);
		column1.setWidth(0);
		column1.setPreferredWidth(0);
		scrollPane.setViewportView(table);

		TableColumnModel columnModel2 = table.getColumnModel();
		TableColumn column2 = columnModel2.getColumn(6);
		column2.setMinWidth(0);
		column2.setMaxWidth(0);
		column2.setWidth(0);
		column2.setPreferredWidth(0);
		scrollPane.setViewportView(table);

		TableColumnModel columnresize = table.getColumnModel();
		columnresize.getColumn(0).setPreferredWidth(30);
		columnresize.getColumn(1).setPreferredWidth(30);
		columnresize.getColumn(2).setPreferredWidth(40);
		columnresize.getColumn(3).setPreferredWidth(60);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					ViewExam();
				}
			}
		});

		pView.add(panel_1_1);

	}

	public void ViewClass(DefaultTableModel model) {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		JLabel lblNewLabel = new JLabel("LỚP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth() + 1, (int) size.getHeight() + 1);

		pView.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(550, 30, 59, 28);
		pView.add(lblNewLabel_1);

		String[] list = { "  Tên lớp", "  Số học sinh" };

		comboBoxSortClass = new JComboBox<>(list);
		comboBoxSortClass.setBounds(615, 35, 90, 22);
		pView.add(comboBoxSortClass);

		comboBoxSortClass.addActionListener(actionTeacher);

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
				comp.setBackground(new Color(50, 185, 185));
				comp.setForeground(Color.WHITE);
				setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201, 201, 201)));

				return comp;
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "  Tên lớp", "  Số học sinh" }));

		table.setModel(model);
		table.setDefaultEditor(Object.class, null);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int i = table.getSelectedRow();
					String m = table.getValueAt(i, 0).toString();
					ViewListSVinClass(getClassbyNameClass(m, g));
				}
			}
		});

		scrollPane.setViewportView(table);
	}

	public void ViewListSVinClass(Class c) {

		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("LỚP " + c.getTenlop());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth() + 1, (int) size.getHeight() + 1);

		pView.add(lblNewLabel);

		String[] list = { "  Tên", "  Điểm trung bình" };

		JComboBox<String> comboBox_1 = new JComboBox<>(list);
		comboBox_1.setBounds(615, 35, 90, 22);
		pView.add(comboBox_1);

		JLabel lblNewLabel_2 = new JLabel("Sắp xếp :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(550, 30, 59, 28);
		pView.add(lblNewLabel_2);

		buttonDeleteSv = new MyButton("Xóa học sinh");
		buttonDeleteSv.setRadius(10);
		buttonDeleteSv.setForeground(Color.WHITE);
		buttonDeleteSv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonDeleteSv.setColorOver(new Color(100, 241, 241));
		buttonDeleteSv.setColorClick(new Color(50, 185, 185));
		buttonDeleteSv.setColor(new Color(50, 185, 185));
		buttonDeleteSv.setBorderColor(Color.WHITE);
		buttonDeleteSv.setBackground(new Color(50, 185, 185));
		buttonDeleteSv.setBounds(10, 600, 110, 30);
		pView.add(buttonDeleteSv);

		buttonDeleteSv.addActionListener(actionTeacher);

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
				comp.setBackground(new Color(50, 185, 185));
				comp.setForeground(Color.WHITE);
				setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201, 201, 201)));

				return comp;
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "  Tên", "  Điểm trung bình", "  Mã học sinh", "  Mã lớp" }));

		table.setModel(getModelSv(table, c));
		table.setDefaultEditor(Object.class, null);
		// ẩn cột mã học sinh
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column = columnModel.getColumn(2);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);
		// ẩn cột mã lớp
		TableColumnModel columnModel1 = table.getColumnModel();
		TableColumn column1 = columnModel1.getColumn(3);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);
		column1.setWidth(0);
		column1.setPreferredWidth(0);

		scrollPane.setViewportView(table);
	}

	public void ViewExam() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("KÌ THI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth() + 1, (int) size.getHeight() + 1);

		pView.add(lblNewLabel);

		String[] list = { "  Lớp", "  Môn", "  Tên kì thi", "  Ngày thi", "  Thời gian bắt đầu", "  Thời gian thi",
				"  Số câu hỏi" };

		comboBoxExam = new JComboBox<>(list);
		comboBoxExam.setBounds(615, 35, 90, 22);
		pView.add(comboBoxExam);

		comboBoxExam.addActionListener(actionTeacher);

		JLabel lblNewLabel_2 = new JLabel("Sắp xếp :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(550, 30, 59, 28);
		pView.add(lblNewLabel_2);

		buttonAddExam = new MyButton("Thêm kì thi");
		buttonAddExam.setRadius(10);
		buttonAddExam.setForeground(Color.WHITE);
		buttonAddExam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonAddExam.setColorOver(new Color(100, 241, 241));
		buttonAddExam.setColorClick(new Color(50, 185, 185));
		buttonAddExam.setColor(new Color(50, 185, 185));
		buttonAddExam.setBorderColor(Color.WHITE);
		buttonAddExam.setBackground(new Color(50, 185, 185));
		buttonAddExam.setBounds(10, 600, 110, 30);

		pView.add(buttonAddExam);
		buttonAddExam.addActionListener(actionTeacher);

		buttonDeleteExam = new MyButton("Xóa kì thi");
		buttonDeleteExam.setRadius(10);
		buttonDeleteExam.setForeground(Color.WHITE);
		buttonDeleteExam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonDeleteExam.setColorOver(new Color(100, 241, 241));
		buttonDeleteExam.setColorClick(new Color(50, 185, 185));
		buttonDeleteExam.setColor(new Color(50, 185, 185));
		buttonDeleteExam.setBorderColor(Color.WHITE);
		buttonDeleteExam.setBackground(new Color(50, 185, 185));
		buttonDeleteExam.setBounds(130, 600, 110, 30);

		pView.add(buttonDeleteExam);
		buttonDeleteExam.addActionListener(actionTeacher);

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
				comp.setBackground(new Color(50, 185, 185));
				comp.setForeground(Color.WHITE);
				setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201, 201, 201)));

				return comp;
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "  Lớp", "  Môn", "  Tên kì thi",
				"  Ngày thi", "  Thời gian bắt đầu", "  Thời gian thi", "  Số câu hỏi", "  Mã kì thi" }));
		table.setModel(getModelExam(g));
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

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int i = table.getSelectedRow();
					String IdKiThi = table.getValueAt(i, 7).toString();
					ViewUpdateExam(getKithibyID(IdKiThi));
				}
			}
		});
	}

	public void setTableExam(String selectedColumn) {
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);

		int columnIndex = table.getColumnModel().getColumnIndex(selectedColumn);
		sorter.toggleSortOrder(columnIndex);
	}

	public void ViewProfile() {

		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("CÁ NHÂN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth() + 1, (int) size.getHeight() + 1);
		pView.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Thông tin cá nhân");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Dimension size_1 = lblNewLabel_1.getPreferredSize();
		lblNewLabel_1.setBounds(10, 60, (int) size_1.getWidth() + 1, (int) size_1.getHeight() + 1);
		pView.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Mã giáo viên :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_2 = lblNewLabel_1.getPreferredSize();
		lblNewLabel_2.setBounds(10, 100, (int) size_2.getWidth() + 1, (int) size_2.getHeight() + 1);
		pView.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Tên : ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_2_1 = lblNewLabel_1.getPreferredSize();
		lblNewLabel_2_1.setBounds(10, 140, (int) size_2_1.getWidth() + 1, (int) size_2_1.getHeight() + 1);
		pView.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Mật khẩu :");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_2_1_1 = lblNewLabel_1.getPreferredSize();
		lblNewLabel_2_1_1.setBounds(10, 180, (int) size_2_1_1.getWidth() + 1, (int) size_2_1_1.getHeight() + 1);
		pView.add(lblNewLabel_2_1_1);

		labelImage = new JLabel();
		labelImage.setHorizontalAlignment(SwingConstants.CENTER);
		labelImage.setBounds(558, 60, 80, 100);
		labelImage.setOpaque(true);
		String q = g.getLinkAnh(); // /view/image/ava.jpg
		labelImage.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource(q))
				.getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH)));
		System.out.println(q);

		pView.add(labelImage);

		buttonChangePass = new MyButton("Thay đổi mật khẩu");
		buttonChangePass.setRadius(10);
		buttonChangePass.setForeground(Color.WHITE);
		buttonChangePass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonChangePass.setColorOver(new Color(100, 241, 241));
		buttonChangePass.setColorClick(new Color(50, 185, 185));
		buttonChangePass.setColor(new Color(50, 185, 185));
		buttonChangePass.setBorderColor(Color.WHITE);
		buttonChangePass.setBackground(new Color(50, 185, 185));
		buttonChangePass.setBounds(10, 220, 150, 30);

		pView.add(buttonChangePass);

		buttonChangePass.addActionListener(actionTeacher);

		buttonChangeImage = new MyButton("Thay đổi hình ảnh");
		buttonChangeImage.setRadius(10);
		buttonChangeImage.setForeground(Color.WHITE);
		buttonChangeImage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonChangeImage.setColorOver(new Color(100, 241, 241));
		buttonChangeImage.setColorClick(new Color(50, 185, 185));
		buttonChangeImage.setColor(new Color(50, 185, 185));
		buttonChangeImage.setBorderColor(Color.WHITE);
		buttonChangeImage.setBackground(new Color(50, 185, 185));
		buttonChangeImage.setBounds(524, 220, 150, 30);
		pView.add(buttonChangeImage);

		buttonChangeImage.addActionListener(actionTeacher);

		JLabel lblNewLabel_4 = new JLabel(g.getId());
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_4 = lblNewLabel_4.getPreferredSize();
		lblNewLabel_4.setBounds(130, 100, (int) size_4.getWidth() + 1, (int) size_4.getHeight() + 1);
		pView.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel(g.getTen());
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_4_1 = lblNewLabel_4_1.getPreferredSize();
		lblNewLabel_4_1.setBounds(130, 140, (int) size_4_1.getWidth() + 1, (int) size_4_1.getHeight() + 1);
		pView.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("********");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_4_2 = lblNewLabel_4_2.getPreferredSize();
		lblNewLabel_4_2.setBounds(130, 180, (int) size_4_2.getWidth() + 1, (int) size_4_2.getHeight() + 1);
		pView.add(lblNewLabel_4_2);

	}

	public void ViewCreateNew() {

		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("TẠO MỚI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth() + 1, (int) size.getHeight() + 1);

		pView.add(lblNewLabel);

		NewQuestion = new MyButton("Tạo câu hỏi");
		NewQuestion.setForeground(new Color(255, 255, 255));
		NewQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		NewQuestion.setBounds(150, 250, 160, 80);
		NewQuestion.setBackground(new Color(50, 185, 185));
		NewQuestion.setRadius(10);
		NewQuestion.setColor(new Color(50, 185, 185));
		NewQuestion.setBorderColor(Color.WHITE);
		NewQuestion.setColorOver(new Color(100, 241, 241));
		NewQuestion.setColorClick(new Color(50, 185, 185));

		pView.add(NewQuestion);

		NewQuestion.addActionListener(actionTeacher);

		NewExam = new MyButton("Tạo kì thi");
		NewExam.setRadius(10);
		NewExam.setForeground(Color.WHITE);
		NewExam.setFont(new Font("Tahoma", Font.BOLD, 14));
		NewExam.setColorOver(new Color(100, 241, 241));
		NewExam.setColorClick(new Color(50, 185, 185));
		NewExam.setColor(new Color(50, 185, 185));
		NewExam.setBorderColor(Color.WHITE);
		NewExam.setBackground(new Color(50, 185, 185));
		NewExam.setBounds(385, 250, 160, 80);

		pView.add(NewExam);

		NewExam.addActionListener(actionTeacher);
	}

	public void ViewCreateExam() {

		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("TẠO KÌ THI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 150, 20);

		pView.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 41, 694, 609);
		panel_3.setBackground(Color.white);
		pView.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Lớp : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 30, 50, 18);

		panel_3.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Ngân hàng câu hỏi :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(339, 30, 150, 18);
		panel_3.add(lblNewLabel_1_1);

		comboBoxTenLop = new JComboBox<>(getTenLop(g));
		comboBoxTenLop.setBackground(new Color(255, 255, 255));
		comboBoxTenLop.setBounds(60, 30, 102, 22);
		panel_3.add(comboBoxTenLop);

		comboBoxTenNGCH = new JComboBox<>(getTenMon());
		comboBoxTenNGCH.setBackground(new Color(255, 255, 255));
		comboBoxTenNGCH.setBounds(480, 30, 102, 22);
		panel_3.add(comboBoxTenNGCH);

		JLabel lblNewLabel_1_2 = new JLabel("Số câu hỏi :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 90, 137, 18);
		panel_3.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Số câu dễ :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 150, 169, 18);
		panel_3.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("Số câu trung bình :");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(10, 210, 190, 18);
		panel_3.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_3 = new JLabel("Số câu khó :");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3.setBounds(10, 270, 169, 18);
		panel_3.add(lblNewLabel_1_2_3);

		JLabel lblNewLabel_1_2_3_1 = new JLabel("Ngày thi :");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_1.setBounds(10, 330, 80, 18);
		panel_3.add(lblNewLabel_1_2_3_1);

		JLabel lblNewLabel_1_2_3_2 = new JLabel("Thời gian bắt đầu :");
		lblNewLabel_1_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_2.setBounds(10, 390, 150, 18);
		panel_3.add(lblNewLabel_1_2_3_2);

		JLabel lblNewLabel_1_2_3_3 = new JLabel("Thời gian thi :");
		lblNewLabel_1_2_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_3.setBounds(10, 450, 100, 18);
		panel_3.add(lblNewLabel_1_2_3_3);

		textField = new JPlaceholderTextField("");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(210, 206, 100, 30);
		textField.setBorder(null);
		textField.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		textField.setCornerRadius(20);
		panel_3.add(textField);
		textField.setColumns(10);

		textField_1 = new JPlaceholderTextField("");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(150, 146, 100, 30);
		textField_1.setBorder(null);
		textField_1.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		textField_1.setCornerRadius(20);
		panel_3.add(textField_1);

		textField_2 = new JPlaceholderTextField("");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		textField_2.setCornerRadius(20);
		textField_2.setBounds(140, 86, 100, 30);
		panel_3.add(textField_2);

		textField_3 = new JPlaceholderTextField("");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(160, 266, 100, 30);
		textField_3.setBorder(null);
		textField_3.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		textField_3.setCornerRadius(20);
		panel_3.add(textField_3);

		textField_4 = new JPlaceholderTextField("");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(150, 446, 100, 30);
		textField_4.setBorder(null);
		textField_4.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		textField_4.setCornerRadius(20);
		panel_3.add(textField_4);

		textMoTa = new JPlaceholderTextField("");
		textMoTa.setHorizontalAlignment(SwingConstants.CENTER);
		textMoTa.setCornerRadius(20);
		textMoTa.setColumns(10);
		textMoTa.setBorder(null);
		textMoTa.setBounds(130, 506, 100, 30);
		textMoTa.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		panel_3.add(textMoTa);

		MaskFormatter dateformatter = null;
		MaskFormatter timeformatter = null;
		try {
			dateformatter = new MaskFormatter("####-##-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			timeformatter = new MaskFormatter("##:##:##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		dateField = new PlaceholderFormattedTextField(dateformatter);
		dateField.setHorizontalAlignment(SwingConstants.CENTER);
		dateField.setColumns(10);
		dateField.setBounds(120, 326, 100, 30);
		dateField.setBorder(null);
		dateField.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		dateField.setCornerRadius(20);

		timeField = new PlaceholderFormattedTextField(timeformatter);
		timeField.setHorizontalAlignment(SwingConstants.CENTER);
		timeField.setColumns(10);
		timeField.setBounds(200, 386, 100, 30);
		timeField.setBorder(null);
		timeField.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		timeField.setCornerRadius(20);
		panel_3.add(dateField);
		panel_3.add(timeField);

		JLabel lblNewLabel_1_2_3_3_1 = new JLabel("Mô tả :");
		lblNewLabel_1_2_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_3_1.setBounds(10, 510, 100, 18);
		panel_3.add(lblNewLabel_1_2_3_3_1);

		JLabel lblNewLabel_2 = new JLabel("( VD: 2004/04/07)");
		lblNewLabel_2.setForeground(new Color(192, 192, 192));
		lblNewLabel_2.setBounds(230, 334, 102, 14);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("( VD: 09:00:00)");
		lblNewLabel_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1.setBounds(310, 394, 102, 14);
		panel_3.add(lblNewLabel_2_1);

		buttonLuuExam = new MyButton("Tạo");
		buttonLuuExam.setRadius(10);
		buttonLuuExam.setForeground(Color.WHITE);
		buttonLuuExam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonLuuExam.setColorOver(new Color(100, 241, 241));
		buttonLuuExam.setColorClick(new Color(50, 185, 185));
		buttonLuuExam.setColor(new Color(50, 185, 185));
		buttonLuuExam.setBorderColor(Color.WHITE);
		buttonLuuExam.setBackground(new Color(50, 185, 185));
		buttonLuuExam.setBounds(520, 560, 150, 30);

		buttonLuuExam.addActionListener(actionTeacher);

		panel_3.add(buttonLuuExam);

		buttonHuyUpdateExam = new MyButton("Hủy");
		buttonHuyUpdateExam.setRadius(10);
		buttonHuyUpdateExam.setForeground(new Color(50, 185, 185));
		buttonHuyUpdateExam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonHuyUpdateExam.setColorOver(new Color(207, 231, 231));
		buttonHuyUpdateExam.setColorClick(Color.WHITE);
		buttonHuyUpdateExam.setColor(Color.WHITE);
		buttonHuyUpdateExam.setBorderColor(new Color(50, 185, 185));
		buttonHuyUpdateExam.setBackground(Color.white);
		buttonHuyUpdateExam.setBounds(354, 562, 146, 26);

		buttonHuyUpdateExam.addActionListener(actionTeacher);

		panel_3.add(buttonHuyUpdateExam);
	}

	public void ViewUpdateExam(KiThi kt) {

		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("CẬP NHẬT THÔNG TIN KÌ THI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 300, 20);

		pView.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 41, 694, 609);
		panel_3.setBackground(Color.white);
		pView.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Lớp : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 30, 50, 18);

		panel_3.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Ngân hàng câu hỏi :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(339, 30, 150, 18);
		panel_3.add(lblNewLabel_1_1);

		comboBoxTenLop = new JComboBox<>(getTenLop(g));

		comboBoxTenLop.setSelectedIndex(getIndexofArray(getTenLop(g), kt.getLop().getTenlop()));

		comboBoxTenLop.setBackground(new Color(255, 255, 255));
		comboBoxTenLop.setBounds(60, 30, 102, 22);
		panel_3.add(comboBoxTenLop);

		comboBoxTenNGCH = new JComboBox<>(getTenMon());
		comboBoxTenNGCH.setSelectedIndex(getIndexofArray(getTenMon(), kt.getNganhangcauhoi().getIdNganHang()));
		comboBoxTenNGCH.setBackground(new Color(255, 255, 255));
		comboBoxTenNGCH.setBounds(480, 30, 102, 22);
		panel_3.add(comboBoxTenNGCH);

		JLabel lblNewLabel_1_2 = new JLabel("Số câu hỏi :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 90, 137, 18);
		panel_3.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Số câu hỏi dễ :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 150, 169, 18);
		panel_3.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("Số câu hỏi trung bình :");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(10, 210, 190, 18);
		panel_3.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_3 = new JLabel("Số câu hỏi khó :");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3.setBounds(10, 270, 169, 18);
		panel_3.add(lblNewLabel_1_2_3);

		JLabel lblNewLabel_1_2_3_1 = new JLabel("Ngày thi :");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_1.setBounds(10, 330, 80, 18);
		panel_3.add(lblNewLabel_1_2_3_1);

		JLabel lblNewLabel_1_2_3_2 = new JLabel("Thời gian bắt đầu :");
		lblNewLabel_1_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_2.setBounds(10, 390, 150, 18);
		panel_3.add(lblNewLabel_1_2_3_2);

		JLabel lblNewLabel_1_2_3_3 = new JLabel("Thời gian thi :");
		lblNewLabel_1_2_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_3.setBounds(10, 450, 100, 18);
		panel_3.add(lblNewLabel_1_2_3_3);

		textField = new JPlaceholderTextField("");
		textField.setText(String.valueOf(kt.getSocautb()));
		textField.setHorizontalAlignment(JPlaceholderTextField.CENTER);
		textField.setBounds(210, 206, 100, 30);
		textField.setBorder(null);
		textField.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		textField.setCornerRadius(20);
		panel_3.add(textField);
		textField.setColumns(10);

		textField_1 = new JPlaceholderTextField("");
		textField_1.setText(String.valueOf(kt.getSocauDe()));
		textField_1.setHorizontalAlignment(JPlaceholderTextField.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(150, 146, 100, 30);
		textField_1.setBorder(null);
		textField_1.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		textField_1.setCornerRadius(20);
		panel_3.add(textField_1);

		textField_2 = new JPlaceholderTextField("");
		textField_2.setText(String.valueOf(kt.getSl()));
		textField_2.setHorizontalAlignment(JPlaceholderTextField.CENTER);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		textField_2.setCornerRadius(20);
		textField_2.setBounds(140, 86, 100, 30);
		panel_3.add(textField_2);

		textField_3 = new JPlaceholderTextField("");
		textField_3.setText(String.valueOf(kt.getSocaukho()));
		textField_3.setHorizontalAlignment(JPlaceholderTextField.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(160, 266, 100, 30);
		textField_3.setBorder(null);
		textField_3.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		textField_3.setCornerRadius(20);
		panel_3.add(textField_3);

		textField_4 = new JPlaceholderTextField("");
		textField_4.setText(String.valueOf(kt.getThoigianlambai()));
		textField_4.setHorizontalAlignment(JPlaceholderTextField.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(150, 446, 100, 30);
		textField_4.setBorder(null);
		textField_4.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		textField_4.setCornerRadius(20);
		panel_3.add(textField_4);

		MaskFormatter dateformatter = null;
		MaskFormatter timeformatter = null;
		try {
			dateformatter = new MaskFormatter("####-##-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			timeformatter = new MaskFormatter("##:##:##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		dateField = new PlaceholderFormattedTextField(dateformatter);
		dateField.setValue(kt.getDate());
		System.out.println(kt.getDate());
		dateField.setHorizontalAlignment(SwingConstants.CENTER);
		dateField.setColumns(10);
		dateField.setBounds(120, 326, 100, 30);
		dateField.setBorder(null);
		dateField.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		dateField.setCornerRadius(20);

		timeField = new PlaceholderFormattedTextField(timeformatter);
		timeField.setValue(kt.getThoigianbatdau());
		timeField.setHorizontalAlignment(SwingConstants.CENTER);
		timeField.setColumns(10);
		timeField.setBounds(200, 386, 100, 30);
		timeField.setBorder(null);
		timeField.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		timeField.setCornerRadius(20);
		panel_3.add(dateField);
		panel_3.add(timeField);

		JLabel lblNewLabel_1_2_3_3_1 = new JLabel("Mô tả :");
		lblNewLabel_1_2_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_3_1.setBounds(10, 510, 100, 18);
		panel_3.add(lblNewLabel_1_2_3_3_1);

		textMoTa = new JPlaceholderTextField("");
		textMoTa.setText(kt.getMota());
		textMoTa.setHorizontalAlignment(JPlaceholderTextField.CENTER);
		textMoTa.setCornerRadius(20);
		textMoTa.setColumns(10);
		textMoTa.setBorder(null);
		textMoTa.setBounds(130, 506, 100, 30);
		textMoTa.setGradientColors(new Color(50, 185, 185), new Color(50, 185, 185));
		panel_3.add(textMoTa);

		JLabel lblNewLabel_2 = new JLabel("( VD: 2004/04/07)");
		lblNewLabel_2.setForeground(new Color(192, 192, 192));
		lblNewLabel_2.setBounds(230, 334, 102, 14);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("( VD: 09:00:00)");
		lblNewLabel_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1.setBounds(310, 394, 102, 14);
		panel_3.add(lblNewLabel_2_1);

		buttonUpdateExam = new MyButton("Cập nhật");
		buttonUpdateExam.setRadius(10);
		buttonUpdateExam.setForeground(Color.WHITE);
		buttonUpdateExam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonUpdateExam.setColorOver(new Color(100, 241, 241));
		buttonUpdateExam.setColorClick(new Color(50, 185, 185));
		buttonUpdateExam.setColor(new Color(50, 185, 185));
		buttonUpdateExam.setBorderColor(Color.WHITE);
		buttonUpdateExam.setBackground(new Color(50, 185, 185));
		buttonUpdateExam.setBounds(520, 560, 110, 30);

		buttonUpdateExam.addActionListener(actionTeacher);

		panel_3.add(buttonUpdateExam);

		buttonHuyUpdateExam = new MyButton("Hủy");
		buttonHuyUpdateExam.setRadius(10);
		buttonHuyUpdateExam.setForeground(new Color(50, 185, 185));
		buttonHuyUpdateExam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonHuyUpdateExam.setColorOver(new Color(207, 231, 231));
		buttonHuyUpdateExam.setColorClick(Color.WHITE);
		buttonHuyUpdateExam.setColor(Color.WHITE);
		buttonHuyUpdateExam.setBorderColor(new Color(50, 185, 185));
		buttonHuyUpdateExam.setBackground(Color.white);
		buttonHuyUpdateExam.setBounds(354, 562, 110, 26);

		buttonHuyUpdateExam.addActionListener(actionTeacher);

		panel_3.add(buttonHuyUpdateExam);

		labelIdKitThi = new JLabel();
		labelIdKitThi.setText(kt.getId());

	}

	public void ViewCreateQuestion() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();

		JLabel lblNewLabel = new JLabel("TẠO CÂU HỎI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 150, 20);

		pView.add(lblNewLabel);

		PanelRound panel_1 = new PanelRound(50);
		panel_1.setBorderWidth(1);
		panel_1.setBorderGradientColor(new Color(50, 185, 185), new Color(50, 185, 185));
		panel_1.setBounds(10, 41, 694, 550);
		panel_1.setBground(Color.red);
		pView.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Ngân hàng câu hỏi :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(30, 30, 150, 18);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Mức độ :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(390, 30, 60, 18);
		panel_1.add(lblNewLabel_1_1_1);

		String[] listNganHang = Arrays.copyOf(getTenMon(), getTenMon().length + 1);
		listNganHang[listNganHang.length - 1] = "Thêm";
		comboBoxNganHangCauHoi = new JComboBox<>(listNganHang);
		comboBoxNganHangCauHoi.setBackground(new Color(255, 255, 255));
		comboBoxNganHangCauHoi.setBounds(180, 30, 102, 22);
		panel_1.add(comboBoxNganHangCauHoi);

		comboBoxNganHangCauHoi.addActionListener(actionTeacher);

		String[] list = { "1", "2", "3" };

		comboBoxMucDo = new JComboBox<>(list);
		comboBoxMucDo.setBackground(new Color(255, 255, 255));
		comboBoxMucDo.setBounds(470, 30, 102, 22);
		panel_1.add(comboBoxMucDo);

		JLabel lblNewLabel_1_1_2 = new JLabel("Câu hỏi :");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(30, 110, 75, 18);
		panel_1.add(lblNewLabel_1_1_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 110, 520, 75);
		panel_1.add(scrollPane);

		NoiDung = new JTextArea();
		NoiDung.setLineWrap(true);
		NoiDung.setWrapStyleWord(true);
		scrollPane.setViewportView(NoiDung);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Đáp án A :");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1.setBounds(30, 210, 75, 18);
		panel_1.add(lblNewLabel_1_1_2_1);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Đáp án B :");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1_1.setBounds(30, 290, 75, 18);
		panel_1.add(lblNewLabel_1_1_2_1_1);

		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("Đáp án C :");
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1_1_1.setBounds(30, 370, 75, 18);
		panel_1.add(lblNewLabel_1_1_2_1_1_1);

		JLabel lblNewLabel_1_1_2_1_1_1_1 = new JLabel("Đáp án D :");
		lblNewLabel_1_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1_1_1_1.setBounds(30, 450, 75, 18);
		panel_1.add(lblNewLabel_1_1_2_1_1_1_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(130, 210, 520, 45);
		panel_1.add(scrollPane_1);

		DapAnA = new JTextArea();
		DapAnA.setLineWrap(true);
		DapAnA.setWrapStyleWord(true);
		scrollPane_1.setViewportView(DapAnA);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(130, 290, 520, 45);
		panel_1.add(scrollPane_1_1);

		DapAnB = new JTextArea();
		DapAnB.setLineWrap(true);
		DapAnB.setWrapStyleWord(true);
		scrollPane_1_1.setViewportView(DapAnB);

		JScrollPane scrollPane_1_2 = new JScrollPane();
		scrollPane_1_2.setBounds(130, 370, 520, 45);
		panel_1.add(scrollPane_1_2);

		DapAnC = new JTextArea();
		DapAnC.setLineWrap(true);
		DapAnC.setWrapStyleWord(true);
		scrollPane_1_2.setViewportView(DapAnC);

		JScrollPane scrollPane_1_3 = new JScrollPane();
		scrollPane_1_3.setBounds(130, 450, 520, 45);
		panel_1.add(scrollPane_1_3);

		DapAnD = new JTextArea();
		DapAnD.setLineWrap(true);
		DapAnD.setWrapStyleWord(true);
		scrollPane_1_3.setViewportView(DapAnD);

		rdbtnNewRadioButton = new JRadioButton("Đáp án đúng");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBounds(130, 260, 109, 23);
		panel_1.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Đáp án đúng");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setBounds(130, 342, 109, 23);
		panel_1.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("Đáp án đúng");
		rdbtnNewRadioButton_2.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_2.setBounds(130, 422, 109, 23);
		panel_1.add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_3 = new JRadioButton("Đáp án đúng");
		rdbtnNewRadioButton_3.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_3.setBounds(130, 502, 109, 23);
		panel_1.add(rdbtnNewRadioButton_3);

		onechoice = new ButtonGroup();
		onechoice.add(rdbtnNewRadioButton);
		onechoice.add(rdbtnNewRadioButton_1);
		onechoice.add(rdbtnNewRadioButton_2);
		onechoice.add(rdbtnNewRadioButton_3);

		buttonLuuCauHoi = new MyButton("Lưu và tiếp tục");
		buttonLuuCauHoi.setRadius(10);
		buttonLuuCauHoi.setForeground(Color.WHITE);
		buttonLuuCauHoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonLuuCauHoi.setColorOver(new Color(100, 241, 241));
		buttonLuuCauHoi.setColorClick(new Color(50, 185, 185));
		buttonLuuCauHoi.setColor(new Color(50, 185, 185));
		buttonLuuCauHoi.setBorderColor(Color.WHITE);
		buttonLuuCauHoi.setBackground(new Color(50, 185, 185));
		buttonLuuCauHoi.setBounds(554, 607, 150, 30);

		pView.add(buttonLuuCauHoi);

		buttonLuuCauHoi.addActionListener(actionTeacher);

		buttonExitAddQuestion = new MyButton("Thoát");
		buttonExitAddQuestion.setRadius(10);
		buttonExitAddQuestion.setForeground(new Color(50, 185, 185));
		buttonExitAddQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonExitAddQuestion.setColorOver(new Color(207, 231, 231));
		buttonExitAddQuestion.setColorClick(Color.WHITE);
		buttonExitAddQuestion.setColor(Color.WHITE);
		buttonExitAddQuestion.setBorderColor(new Color(50, 185, 185));
		buttonExitAddQuestion.setBackground(Color.white);
		buttonExitAddQuestion.setBounds(382, 609, 146, 26);

		pView.add(buttonExitAddQuestion);

		buttonExitAddQuestion.addActionListener(actionTeacher);
	}

	public void ViewAddNganHangCauHoi() {
		j = new JFrame();
		j.setBounds(100, 100, 320, 150);
		j.setLocationRelativeTo(null);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

		j.setContentPane(contentPane1);
		contentPane1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên ngân hàng :");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel.setBounds(48, 28, 123, 27);
		contentPane1.add(lblNewLabel);

		tenNGCH = new JTextField();
		tenNGCH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tenNGCH.setBounds(166, 31, 86, 20);
		contentPane1.add(tenNGCH);
		tenNGCH.setColumns(10);

		buttonOK = new JButton("Ok");
		buttonOK.setBounds(62, 77, 89, 23);
		contentPane1.add(buttonOK);
		buttonOK.addActionListener(actionTeacher);

		buttonHuy = new JButton("Hủy");
		buttonHuy.setBounds(161, 77, 89, 23);
		contentPane1.add(buttonHuy);
		buttonHuy.addActionListener(actionTeacher);

		j.setVisible(true);
	}

	//////////////////////////////////////////////////////////////

	public DefaultTableModel getModelClasses(Gv g) {
		List<Giangday> dslop = g.getDanhsachlop();
		System.out.println(dslop);

		JTable t = new JTable();

		t.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "  Tên lớp", "  Số học sinh" }));

		DefaultTableModel model = (DefaultTableModel) t.getModel();
		for (Giangday giangday : dslop) {
			List<Sv> listSV = Class_dao.Instance().selectSVinclass(giangday.getMalop());
			Object[] row = { giangday.getMalop().getTenlop(), listSV.size() };
			model.addRow(row);
		}
		return model;
	}

	public DefaultTableModel getModelExam(Gv g) {
		List<KiThi> kthi = KiThi_dao.Instance().selectall();
		String idgv = g.getId();

		JTable t = new JTable();
		t.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "  Lớp", "  Môn", "  Tên kì thi",
				"  Ngày thi", "  Thời gian bắt đầu", "  Thời gian thi", "  Số câu hỏi", "  Mã kì thi" }));

		DefaultTableModel model = (DefaultTableModel) t.getModel();
		for (KiThi k : kthi) {
			if (idgv.equalsIgnoreCase(k.getGv().getId())) {
				Object[] row = { k.getLop().getTenlop(), k.getNganhangcauhoi().getIdNganHang(), k.getMota(),
						k.getDate(), k.getThoigianbatdau(), k.getThoigianlambai(), k.getSl(), k.getId() };
				model.addRow(row);
			}
		}
		return model;
	}

	public DefaultTableModel getModelSv(JTable table, Class c) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		List<Sv> temp = Class_dao.Instance().selectSVinclass(c);
		for (Sv sv : temp) {
			Object[] row = { sv.getTen(), "", sv.getId(), sv.getIdclass().getIdclass() };
			model.addRow(row);
		}
		return model;
	}

	public void upadteTableSv(JTable table, String id) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		table.setModel(getModelSv(table, Class_dao.Instance().selectbyid(id)));
	}

	public void updateTableExam(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		table.setModel(getModelExam(g));
	}

	public Class getClassbyNameClass(String m, Gv g) {
		for (Giangday giangday : g.getDanhsachlop()) {
			if (m == giangday.getMalop().getTenlop()) {
				return giangday.getMalop();
			}
		}
		return null;
	}

	public String[] getTenLop(Gv g) {
		int i = 0;
		String[] tenlop = new String[g.getDanhsachlop().size()];
		for (Giangday giangday : g.getDanhsachlop()) {
			tenlop[i] = giangday.getMalop().getTenlop();
			i++;
		}
		return tenlop;
	}

	public String[] getTenMon() {
		int i = 0;
		List<Nganhangcauhoi> NganHangCauHoi = NganhangDao.Instance().selectall();
		String[] nganhang = new String[NganHangCauHoi.size()];
		for (Nganhangcauhoi ng : NganHangCauHoi) {
			nganhang[i] = ng.getIdNganHang();
			i++;
		}
		return nganhang;
	}

	public Nganhangcauhoi getNganhangcauhoibyName(String name) {
		List<Nganhangcauhoi> NganHangCauHoi = NganhangDao.Instance().selectall();
		for (Nganhangcauhoi nganhangcauhoi2 : NganHangCauHoi) {
			if (name.equalsIgnoreCase(nganhangcauhoi2.getIdNganHang())) {
				return nganhangcauhoi2;
			}
		}
		return null;
	}

	public KiThi getKithibyID(String id) {
		KiThi k = KiThi_dao.Instance().selectbyid(id);
		return k;
	}

	public int getIndexofArray(String[] arr, String s) {
		for (int i = 0; i < arr.length; i++) {
			if (s.equalsIgnoreCase(arr[i])) {
				return i;
			}
		}
		return -1;
	}

	public void InsertExam(KiThi k) {
		KiThi_dao.Instance().insert(k);
	}

	public void LuuExam() {

		String tenlop = comboBoxTenLop.getSelectedItem().toString();
		String tenmon = comboBoxTenNGCH.getSelectedItem().toString();
		String mota = textMoTa.getText();
		int total = Integer.parseInt(textField_2.getText());
		int easy = Integer.parseInt(textField_1.getText());
		int medium = Integer.parseInt(textField.getText());
		int hard = Integer.parseInt(textField_3.getText());
		int duringtime = Integer.parseInt(textField_4.getText());
		String date = dateField.getText();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date datE = null;
		try {
			java.util.Date utilDate = dateFormat.parse(date);
			datE = new java.sql.Date(utilDate.getTime());
		} catch (ParseException p) {
			p.printStackTrace();
		}
		String time = timeField.getText();
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		java.sql.Time timE = null;
		try {
			Date utilDate = timeFormat.parse(time);
			timE = new java.sql.Time(utilDate.getTime());
		} catch (ParseException l) {
			l.printStackTrace();
		}
		String m = UUID.randomUUID().toString();
		KiThi kt = new KiThi(m, getClassbyNameClass(tenlop, g), timE, duringtime, mota, datE, g, total, hard, easy,
				medium, getNganhangcauhoibyName(tenmon));

		textMoTa.setText("");
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		dateField.setText("");
		timeField.setText("");

		KiThi_dao.Instance().insert(kt);
	}

	public void CapNhatExam() {

		String tenlop = comboBoxTenLop.getSelectedItem().toString();
		String tenmon = comboBoxTenNGCH.getSelectedItem().toString();
		String mota = textMoTa.getText();
		int total = Integer.parseInt(textField_2.getText());
		int easy = Integer.parseInt(textField_1.getText());
		int medium = Integer.parseInt(textField.getText());
		int hard = Integer.parseInt(textField_3.getText());
		int duringtime = Integer.parseInt(textField_4.getText());
		String date = dateField.getText();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date datE = null;
		try {
			java.util.Date utilDate = dateFormat.parse(date);
			datE = new java.sql.Date(utilDate.getTime());
		} catch (ParseException p) {
			p.printStackTrace();
		}
		String time = timeField.getText();
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		java.sql.Time timE = null;
		try {
			Date utilDate = timeFormat.parse(time);
			timE = new java.sql.Time(utilDate.getTime());
		} catch (ParseException l) {
			l.printStackTrace();
		}
		String m = labelIdKitThi.getText();
		KiThi kt = new KiThi(m, getClassbyNameClass(tenlop, g), timE, duringtime, mota, datE, g, total, hard, easy,
				medium, getNganhangcauhoibyName(tenmon));

		textMoTa.setText("");
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		dateField.setText("");
		timeField.setText("");

		KiThi_dao.Instance().update(kt);
	}

	public void InsertCauhoi() {

		String question = NoiDung.getText();
		String dapanA = DapAnA.getText();
		String dapanB = DapAnB.getText();
		String dapanC = DapAnC.getText();
		String dapanD = DapAnD.getText();
		String dapanDung = null;
		String tenMon = comboBoxNganHangCauHoi.getSelectedItem().toString();
		int mucdo = Integer.parseInt(comboBoxMucDo.getSelectedItem().toString());
		if (rdbtnNewRadioButton.isSelected()) {
			dapanDung = DapAnA.getText();
		} else if (rdbtnNewRadioButton_1.isSelected()) {
			dapanDung = DapAnB.getText();
		} else if (rdbtnNewRadioButton_2.isSelected()) {
			dapanDung = DapAnC.getText();
		} else if (rdbtnNewRadioButton_3.isSelected()) {
			dapanDung = DapAnD.getText();
		} else {
			JOptionPane.showMessageDialog(null, "Bạn cần chọn câu trả lời đúng", "LỖI",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		// tạo id bằng phương pháp UUID
		String id = UUID.randomUUID().toString();

		Cauhoi c = new Cauhoi(id, question, dapanA, dapanB, dapanC, dapanD, mucdo, dapanDung,
				getNganhangcauhoibyName(tenMon));
		NoiDung.setText("");
		DapAnA.setText("");
		DapAnB.setText("");
		DapAnC.setText("");
		DapAnD.setText("");
		onechoice.clearSelection();

		Cauhoi_Dao.Instance().insert(c);
	}

	public void updateComboBoxNganHangCauHoi() {
		String[] listNganHang = Arrays.copyOf(getTenMon(), getTenMon().length + 1);
		listNganHang[listNganHang.length - 1] = "Thêm";
		this.comboBoxNganHangCauHoi.setModel(new DefaultComboBoxModel<String>(listNganHang));
	}

	public void insertNganHangCauHoi(String idNganHang, int soluong) {
		Nganhangcauhoi c = new Nganhangcauhoi(idNganHang, soluong, g);
		NganhangDao.Instance().insert(c);
	}

	public void deleteSv(String id) {
		Sv_dao.Instance().deletebyid(Sv_dao.Instance().selectbyid(id));
	}

	public void SortTableClass(String selectedColumn) {

		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);

		int columnIndex = table.getColumnModel().getColumnIndex(selectedColumn);
		sorter.toggleSortOrder(columnIndex);
	}

	public void deleteExam(String id) {
		KiThi_dao.Instance().deletebyid(KiThi_dao.Instance().selectbyid(id));
	}

	public void displayImage(File imageFile, JLabel label) {
		try {
			Image image = Toolkit.getDefaultToolkit().createImage(imageFile.toString());
			image = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
			label.setIcon(new ImageIcon(image));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveAnh() {
		JFileChooser saveFile = new JFileChooser();
		int result = saveFile.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			// Lấy file được chọn
			File sourceFile = saveFile.getSelectedFile();

			// Lấy file được chọn để lưu
			File destinationFile = new File(
					"C:\\Users\\ASUS\\git\\PBL\\src\\main\\java\\View\\image\\" + sourceFile.getName());

			try {
				Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				displayImage(destinationFile, labelImage);
				g.setLinkAnh("/view/image/" + sourceFile.getName());
				Sv_dao.Instance().update(g);
				JOptionPane.showMessageDialog(null, destinationFile.toString());
			} catch (IOException q) {
				JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi sao chép file: " + q.getMessage());
			}
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////

}

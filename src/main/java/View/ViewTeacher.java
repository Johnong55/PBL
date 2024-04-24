package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.text.View;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterGraphics;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.dial.DialPointer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import model.Gv;
import model.KiThi;
import model.Giangday;
import DAO.Class_dao;
import DAO.KiThi_dao;
import model.Sv;
import model.Class;
import Controller.Controller_Teacher;

public class ViewTeacher extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JPanel pView;
	MyButton btnNewButton1,btnNewButton,btnNewButton3,btnNewButton2,btnNewButton4,ViewStudent,ViewTest;
	private JPlaceholderTextField textField,textField_1,textField_2,textField_3,textField_4;
	private JTable table;
	public Gv g;
	public Class_dao ClassDao = new Class_dao();
	public Controller_Teacher controlGV = new Controller_Teacher();
	public KiThi_dao kthi = new KiThi_dao();
	
	public ViewTeacher(Gv gv) {
		this.g = gv;
		System.out.println(g);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 900, 700);
		ViewMenu();
		ViewHome();
		setVisible(true);
	}
	
	/*
	 * public void showpView() { pView = new JPanel(); pView.setBorder(null);
	 * pView.setBackground(new Color(255, 255, 255)); pView.setBounds(170, 0, 715,
	 * 661); contentPane.add(pView); pView.setLayout(null); }
	 */
	
	
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

		btnNewButton = new MyButton("Home");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(10, 90, 137, 37);
		btnNewButton.setBackground(new Color(50, 185, 185));
		btnNewButton.setColorClick(new Color(50, 185, 185));
		btnNewButton.setColorOver(new Color(100, 241, 241));
		btnNewButton.setRadius(10);
		btnNewButton.setBorderColor(new Color(50, 185, 185));
		btnNewButton.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-home-20.png"))));
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);

		btnNewButton1 = new MyButton("Classes");
		btnNewButton1.setForeground(new Color(255, 255, 255));
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton1.setBounds(10, 138, 137, 37);
		btnNewButton1.setBackground(new Color(50, 185, 185));
		btnNewButton1.setColorClick(new Color(50, 185, 185));
		btnNewButton1.setColorOver(new Color(100, 241, 241));
		btnNewButton1.setRadius(10);
		btnNewButton1.setBorderColor(new Color(50, 185, 185));
		btnNewButton1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-class-20.png"))));
		btnNewButton1.addActionListener(this);
		panel.add(btnNewButton1);

		btnNewButton2 = new MyButton("Results");
		btnNewButton2.setForeground(new Color(255, 255, 255));
		btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton2.setBounds(10, 186, 137, 37);
		btnNewButton2.setBackground(new Color(50, 185, 185));
		btnNewButton2.setColorClick(new Color(50, 185, 185));
		btnNewButton2.setColorOver(new Color(100, 241, 241));
		btnNewButton2.setRadius(10);
		btnNewButton2.setBorderColor(new Color(50, 185, 185));
		btnNewButton2.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-result-20.png"))));
		btnNewButton2.addActionListener(this);
		panel.add(btnNewButton2);

		btnNewButton3 = new MyButton("Profile");
		btnNewButton3.setForeground(new Color(255, 255, 255));
		btnNewButton3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton3.setBounds(10, 234, 137, 37);
		btnNewButton3.setBackground(new Color(50, 185, 185));
		btnNewButton3.setColorClick(new Color(50, 185, 185));
		btnNewButton3.setColorOver(new Color(100, 241, 241));
		btnNewButton3.setRadius(10);
		btnNewButton3.setBorderColor(new Color(50, 185, 185));
		btnNewButton3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(getClass().getResource("/view/image/icons8-male-user-20.png"))));
		btnNewButton3.addActionListener(this);
		panel.add(btnNewButton3);

		btnNewButton4 = new MyButton("Create new");
		btnNewButton4.setForeground(new Color(255, 255, 255));
		btnNewButton4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton4.setBounds(10, 282, 137, 37);
		btnNewButton4.setBackground(new Color(50, 185, 185));
		btnNewButton4.setColorClick(new Color(50, 185, 185));
		btnNewButton4.setColorOver(new Color(100, 241, 241));
		btnNewButton4.setRadius(10);
		btnNewButton4.setBorderColor(new Color(50, 185, 185));
		btnNewButton4.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-add-new-20.png"))));
		btnNewButton4.addActionListener(this);
		panel.add(btnNewButton4);
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
		panel_1.setBackground(new Color(221, 221, 221));
		panel_1.setBorderColor(getBackground());
		panel_1.setBounds(10, 80, 440, 280);
		panel_1.setBground(Color.WHITE);
		panel_1.setLayout(null);
		// bỉu do
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("C Grade", 15);
        dataset.setValue("B Grade", 66);
        dataset.setValue("Failing", 9);
        dataset.setValue("A Grade", 10);
    	
        JFreeChart chart = ChartFactory.createPieChart(
                "Recent test results", dataset, true, true, true);
        PiePlot pie = (PiePlot) chart.getPlot();
        pie.setSectionPaint("B Grade",new Color(50, 185, 185));
        pie.setSectionPaint("A Grade",Color.red);
        pie.setSectionPaint("C Grade",Color.green);
        pie.setSectionPaint("Failing",Color.yellow);
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
		panel_2.setBounds(455, 95, 255, 255);
		panel_2.setBorderColor(getBackground());
		panel_2.setBground(Color.WHITE);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Create");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 11, 55, 14);
		panel_2.add(lblNewLabel_1);

		MyButton btnNewButton_1 = new MyButton("Create test");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(37, 200, 181, 40);
		btnNewButton_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1.setRadius(10);
		btnNewButton_1.setColor(new Color(50, 185, 185));
		btnNewButton_1.setBorderColor(Color.WHITE);
		btnNewButton_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1.setColorClick(new Color(50, 185, 185));
		panel_2.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(10, 36, 235, 153);
		lblNewLabel_3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(getClass().getResource("/view/image/study.jpg"))
				.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH)));
		
		panel_2.add(lblNewLabel_3);
		
		pView.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Hi, " + g.getTen());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 0,(int) size.getWidth()+1,(int) size.getHeight()+1);
		
		pView.add(lblNewLabel);
		
		
		//panel chua schedule test ben phai
		PanelRound panel_2_1 = new PanelRound(15);
		panel_2_1.setLayout(null);
		panel_2_1.setBorderColor(UIManager.getColor("Button.background"));
		panel_2_1.setBground(Color.WHITE);
		panel_2_1.setBackground(new Color(221, 221, 221));
		panel_2_1.setBounds(455, 371, 255, 255);
		
		JLabel lblNewLabel_1_1 = new JLabel("Schedules test");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 11, 116, 14);
		panel_2_1.add(lblNewLabel_1_1);
		
		MyButton btnNewButton_1_1 = new MyButton("Set another");
		btnNewButton_1_1.setRadius(10);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1_1.setColorClick(new Color(50, 185, 185));
		btnNewButton_1_1.setColor(new Color(50, 185, 185));
		btnNewButton_1_1.setBorderColor(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1_1.setBounds(37, 200, 181, 40);
		panel_2_1.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setBounds(10, 36, 235, 153);
		/*
		 * lblNewLabel_3_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
		 * .createImage(getClass().getResource("/view/image/schedule.jpg"))
		 * .getScaledInstance(lblNewLabel_3_1.getWidth(), lblNewLabel_3_1.getHeight(),
		 * Image.SCALE_SMOOTH)));
		 */
		panel_2_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edit");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(199, 13, 46, 14);
		panel_2_1.add(lblNewLabel_2);
		
		
		pView.add(panel_2_1);
		
		// panel duoi bieu do
		PanelRound panel_1_1 = new PanelRound(15);
		panel_1_1.setLayout(null);
		panel_1_1.setBorderColor(UIManager.getColor("Button.background"));
		panel_1_1.setBground(Color.WHITE);
		panel_1_1.setBackground(new Color(221, 221, 221));
		panel_1_1.setBounds(10, 360, 440, 280);
		
		pView.add(panel_1_1);
		
        
	}
	
	public void ViewClass() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		JLabel lblNewLabel = new JLabel("CLASSES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);
		
		MyButton btnNewButton_1 = new MyButton("New class");

		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(555, 48, 150, 30);
		btnNewButton_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1.setRadius(10);
		btnNewButton_1.setColor(new Color(50, 185, 185));
		btnNewButton_1.setBorderColor(Color.WHITE);
		btnNewButton_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1.setColorClick(new Color(50, 185, 185));
		
		pView.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 89, 715, 668);
		scrollPane.getViewport().setBackground(Color.WHITE);
		
		pView.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.getTableHeader().setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name class", "Students"
			}
		));		
		
        table.setModel(controlGV.getModelClasses(g, table));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int i = table.getSelectedRow();
            	String m = table.getValueAt(i, 0).toString();
            	ViewClassDetails(controlGV.getClassbyNameClass(m, g));
            }
        });
		
		scrollPane.setViewportView(table);
	}
	
	public void ViewClassDetails(Class c) {
		
		pView.removeAll();
		pView.repaint();
		pView.revalidate();	 
		
		JLabel lblNewLabel = new JLabel("CLASSES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);
		
		ViewStudent = new MyButton("New class");
		ViewStudent.setText("View students");

		ViewStudent.setForeground(new Color(255, 255, 255));
		ViewStudent.setFont(new Font("Tahoma", Font.BOLD, 14));
		ViewStudent.setBounds(150, 250, 160, 80);
		ViewStudent.setBackground(new Color(50, 185, 185));
		ViewStudent.setRadius(10);
		ViewStudent.setColor(new Color(50, 185, 185));
		ViewStudent.setBorderColor(Color.WHITE);
		ViewStudent.setColorOver(new Color(100, 241, 241));
		ViewStudent.setColorClick(new Color(50, 185, 185));
		
		pView.add(ViewStudent);
		
	    ViewStudent.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {	
	        	ViewListSVinClass(c);
	        }
	    });

		
		ViewTest = new MyButton("New class");
		ViewTest.setText("View tests");
		ViewTest.setRadius(10);
		ViewTest.setForeground(Color.WHITE);
		ViewTest.setFont(new Font("Tahoma", Font.BOLD, 14));
		ViewTest.setColorOver(new Color(100, 241, 241));
		ViewTest.setColorClick(new Color(50, 185, 185));
		ViewTest.setColor(new Color(50, 185, 185));
		ViewTest.setBorderColor(Color.WHITE);
		ViewTest.setBackground(new Color(50, 185, 185));
		ViewTest.setBounds(385, 250, 160, 80);
		pView.add(ViewTest);
		
		// chua xu li nut view tests
		
	    ViewTest.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Thực hiện xử lý khi nút được kick view tests
	        }
	    });
	}
	
	public void ViewListSVinClass(Class c) {
		
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("CLASSES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(0, 41, 715, 620);
		pView.add(scrollPane);
		
		table = new JTable();
		table.getTableHeader().setBackground(Color.WHITE);
		table.setBorder(null);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "GPA", "Passed/Total"
			}
		));
		
		
		// chua xu li controler
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		List<Sv> temp = ClassDao.selectSVinclass(c);
	    for (Sv sv : temp) { 
	    	Object[] row = {sv.getTen(),"",""};
	    	model.addRow(row);
	    }
		scrollPane.setViewportView(table);
	}
	
	public void ViewResult() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("RESULTS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(0, 41, 715, 620);
		pView.add(scrollPane);
		
		table = new JTable();
		table.getTableHeader().setBackground(Color.WHITE);
		table.setBorder(null);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name exam", "Exam day", "Students attended", "Starting time"
			}
		));
		scrollPane.setViewportView(table);
	}
	
	public void ViewProfile() {
		
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("PROFILE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		pView.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Personal details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Dimension size_1 = lblNewLabel_1.getPreferredSize();
		lblNewLabel_1.setBounds(10, 60, (int) size_1.getWidth()+1 , (int) size_1.getHeight()+1);
		pView.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Teacher ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_2 = lblNewLabel_1.getPreferredSize();
		lblNewLabel_2.setBounds(10, 100, (int) size_2.getWidth()+1 , (int) size_2.getHeight()+1);
		pView.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name: ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_2_1 = lblNewLabel_1.getPreferredSize();
		lblNewLabel_2_1.setBounds(10, 140, (int) size_2_1.getWidth()+1 , (int) size_2_1.getHeight()+1);
		pView.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Password");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_2_1_1 = lblNewLabel_1.getPreferredSize();
		lblNewLabel_2_1_1.setBounds(10, 180, (int) size_2_1_1.getWidth()+1 , (int) size_2_1_1.getHeight()+1);
		pView.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("ẢNH");
		lblNewLabel_3.setBackground(new Color(255, 255, 168));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(558, 60, 80, 100);
		lblNewLabel_3.setOpaque(true);
		
		pView.add(lblNewLabel_3);
		
		MyButton btnNewButton_1_1 = new MyButton("Change password");
		btnNewButton_1_1.setRadius(10);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1_1.setColorClick(new Color(50, 185, 185));
		btnNewButton_1_1.setColor(new Color(50, 185, 185));
		btnNewButton_1_1.setBorderColor(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1_1.setBounds(10, 220, 150, 30);
		
		pView.add(btnNewButton_1_1);
		
		MyButton btnNewButton_1_1_1 = new MyButton("Change image");
		btnNewButton_1_1_1.setRadius(10);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1_1_1.setColorClick(new Color(50, 185, 185));
		btnNewButton_1_1_1.setColor(new Color(50, 185, 185));
		btnNewButton_1_1_1.setBorderColor(Color.WHITE);
		btnNewButton_1_1_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1_1_1.setBounds(524, 220, 150, 30);
		pView.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_4 = new JLabel(g.getId());
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_4 = lblNewLabel_4.getPreferredSize();
		lblNewLabel_4.setBounds(130, 100, (int) size_4.getWidth()+1 , (int) size_4.getHeight()+1);
		pView.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel(g.getTen());
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_4_1 = lblNewLabel_4_1.getPreferredSize();
		lblNewLabel_4_1.setBounds(130, 140, (int) size_4_1.getWidth()+1 , (int) size_4_1.getHeight()+1);
		pView.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("bí mật");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_4_2 = lblNewLabel_4_2.getPreferredSize();
		lblNewLabel_4_2.setBounds(130, 180, (int) size_4_2.getWidth()+1 , (int) size_4_2.getHeight()+1);
		pView.add(lblNewLabel_4_2);
		
		
	}
	public void ViewCreateNew() {
		
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("CREATE NEW");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);
		
		MyButton NewQuestion = new MyButton("New question");
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
		
		MyButton NewExam = new MyButton("New exam");
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
		
		NewExam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ViewCreateExam();
			}
		});
	}
	public void ViewCreateExam() {
		
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("CREATE EXAM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 150 , 20);
		
		pView.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 41, 694, 609);
		panel_3.setBackground(Color.white);
		pView.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Class : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 30, 50 , 18);
		
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Subject :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(339, 30, 60 , 18);
		panel_3.add(lblNewLabel_1_1);
		
		
		JComboBox<String> comboBox = new JComboBox<>(controlGV.getTenLop(g));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(60, 30, 102, 22);
		panel_3.add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<>(controlGV.getTenMon());
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(402, 30, 102, 22);
		panel_3.add(comboBox_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Number of questions :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 90, 137 , 18);
		panel_3.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Number of easy questions :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 150, 169, 18);
		panel_3.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Number of medium questions :");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(10, 210, 190, 18);
		panel_3.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Number of hard questions :");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3.setBounds(10, 270, 169, 18);
		panel_3.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Exam day :");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_1.setBounds(10, 330, 70, 18);
		panel_3.add(lblNewLabel_1_2_3_1);
		
		JLabel lblNewLabel_1_2_3_2 = new JLabel("Starting time :");
		lblNewLabel_1_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_2.setBounds(10, 390, 88, 18);
		panel_3.add(lblNewLabel_1_2_3_2);
		
		JLabel lblNewLabel_1_2_3_3 = new JLabel("Exam duration :");
		lblNewLabel_1_2_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_3.setBounds(10, 450, 100, 18);
		panel_3.add(lblNewLabel_1_2_3_3);
		
		textField = new JPlaceholderTextField("");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(210, 206, 100, 30);
		textField.setBorder(null);
		textField.setGradientColors(new Color(50,185,185), Color.white);
		textField.setCornerRadius(20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPlaceholderTextField("");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(210, 146, 100, 30);
		textField_1.setBorder(null);
		textField_1.setGradientColors(new Color(50,185,185), Color.white);
		textField_1.setCornerRadius(20);
		panel_3.add(textField_1);
		
		textField_2 = new JPlaceholderTextField("");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setGradientColors(new Color(50,185,185), Color.white);
		textField_2.setCornerRadius(20);
		textField_2.setBounds(210, 86, 100, 30);
		panel_3.add(textField_2);
		
		textField_3 = new JPlaceholderTextField("");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(210, 266, 100, 30);
		textField_3.setBorder(null);
		textField_3.setGradientColors(new Color(50,185,185), Color.white);
		textField_3.setCornerRadius(20);
		panel_3.add(textField_3);
		
		textField_4 = new JPlaceholderTextField("");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(210, 446, 100, 30);
		textField_4.setBorder(null);
		textField_4.setGradientColors(new Color(50,185,185), Color.white);
		textField_4.setCornerRadius(20);
		panel_3.add(textField_4);
		
        MaskFormatter dateformatter = null;
        MaskFormatter timeformatter = null;
        try {
            dateformatter = new MaskFormatter(" ####/##/## ");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            timeformatter = new MaskFormatter(" ##:##:## ");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        PlaceholderFormattedTextField dateField = new PlaceholderFormattedTextField(dateformatter);
        dateField.setHorizontalAlignment(SwingConstants.CENTER);
        dateField.setColumns(10);
        dateField.setBounds(210, 326, 100, 30);
        dateField.setBorder(null);
        dateField.setGradientColors(new Color(50,185,185), Color.white);
        dateField.setCornerRadius(20);
        PlaceholderFormattedTextField timeField = new PlaceholderFormattedTextField(timeformatter);
        timeField.setHorizontalAlignment(SwingConstants.CENTER);
        timeField.setColumns(10);
        timeField.setBounds(210, 386, 100, 30);
        timeField.setBorder(null);
        timeField.setGradientColors(new Color(50,185,185), Color.white);
		timeField.setCornerRadius(20);
        panel_3.add(dateField);
		panel_3.add(timeField);
		
		JLabel lblNewLabel_1_2_3_3_1 = new JLabel("Describe :");
		lblNewLabel_1_2_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_3_1.setBounds(10, 510, 100, 18);
		panel_3.add(lblNewLabel_1_2_3_3_1);
		
		JPlaceholderTextField textField_4_1 = new JPlaceholderTextField("");
		textField_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4_1.setCornerRadius(20);
		textField_4_1.setColumns(10);
		textField_4_1.setBorder(null);
		textField_4_1.setBounds(210, 511, 100, 30);
		panel_3.add(textField_4_1);
		
		JLabel lblNewLabel_2 = new JLabel("( VD: 2004/04/07)");
		lblNewLabel_2.setForeground(new Color(192, 192, 192));
		lblNewLabel_2.setBounds(320, 334, 102, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("( VD: 09:00:00)");
		lblNewLabel_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1.setBounds(320, 394, 102, 14);
		panel_3.add(lblNewLabel_2_1);
		
		MyButton btnNewButton_1_1 = new MyButton("Create");
		btnNewButton_1_1.setRadius(10);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1_1.setColorClick(new Color(50, 185, 185));
		btnNewButton_1_1.setColor(new Color(50, 185, 185));
		btnNewButton_1_1.setBorderColor(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1_1.setBounds(520, 530, 150, 30);
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tenlop = comboBox.getSelectedItem().toString();
				String tenmon = comboBox_1.getSelectedItem().toString();
				String mota = textField_4_1.getText();
				int total = Integer.parseInt(textField_2.getText());
				int easy = Integer.parseInt(textField_1.getText());
				int medium = Integer.parseInt(textField.getText());
				int hard = Integer.parseInt(textField_3.getText());
				int duringtime = Integer.parseInt(textField_4.getText());
				String date = dateField.getText();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				java.sql.Date datE = null;
		        try {
		        	java.util.Date utilDate = dateFormat.parse(date);
		            datE = new java.sql.Date(utilDate.getTime());
		        } catch (ParseException k) {
		            k.printStackTrace();
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
		        String m = time.replace(":", "");
		        KiThi kt = new KiThi(m,controlGV.getClassbyNameClass(tenlop, g),timE,duringtime,mota,datE,g,total,hard,easy,medium,controlGV.getNganhangcauhoibyName(tenmon));    
		        kthi.insert(kt);
			}
		});
		
		panel_3.add(btnNewButton_1_1);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton1) {
			ViewClass();			
		}else if(e.getSource() == btnNewButton ) {
			ViewHome();
		}else if(e.getSource()==btnNewButton2) {
			ViewResult();
		}else if(e.getSource()==btnNewButton3) {
			ViewProfile();
		}else if(e.getSource()==btnNewButton4) {
			ViewCreateNew();
		}	
	}
}

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
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;


import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.UIManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;


import model.Gv;
import model.KiThi;
import model.Nganhangcauhoi;
import DAO.Cauhoi_Dao;
import DAO.Class_dao;
import DAO.Gv_dao;
import DAO.KiThi_dao;
import DAO.NganhangDao;
import model.Sv;
import model.Cauhoi;
import model.Class;
import model.Giangday;
import Controller.Controller_Teacher;

public class ViewTeacher extends JFrame {

	private JPanel contentPane;
	public static JPanel pView;
	public MyButton btnNewButton1,btnNewButton,btnNewButton3,btnNewButton2,btnNewButton4, btnNewButton5, ViewStudent,ViewTest;
	private JPlaceholderTextField textField,textField_1,textField_2,textField_3,textField_4,textField_4_1;
	private MyTable table;
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

		btnNewButton = new MyButton("Trang chủ");
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
		btnNewButton.addActionListener(actionTeacher);
		panel.add(btnNewButton);

		btnNewButton1 = new MyButton("Lớp");
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
		btnNewButton1.addActionListener(actionTeacher);
		panel.add(btnNewButton1);

		btnNewButton2 = new MyButton("Kì thi");
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
		btnNewButton2.addActionListener(actionTeacher);
		panel.add(btnNewButton2);

		btnNewButton3 = new MyButton("Cá nhân");
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
		btnNewButton3.addActionListener(actionTeacher);
		panel.add(btnNewButton3);

		btnNewButton4 = new MyButton("Tạo mới");
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
		btnNewButton4.addActionListener(actionTeacher);
		panel.add(btnNewButton4);
		
		btnNewButton5 = new MyButton("Đăng xuất");
		btnNewButton5.setForeground(new Color(255, 255, 255));
		btnNewButton5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton5.setBounds(10, 550, 137, 37);
		btnNewButton5.setBackground(new Color(50, 185, 185));
		btnNewButton5.setColorClick(new Color(50, 185, 185));
		btnNewButton5.setColorOver(new Color(100, 241, 241));
		btnNewButton5.setRadius(10);
		btnNewButton5.setBorderColor(new Color(50, 185, 185));
		btnNewButton5.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-logout-20.png"))));
		btnNewButton5.addActionListener(actionTeacher);
		panel.add(btnNewButton5);
		
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
        dataset.setValue("Điểm C", 15);
        dataset.setValue("Điểm B", 66);
        dataset.setValue("Rớt", 9);
        dataset.setValue("Điểm A", 10);
    	
        JFreeChart chart = ChartFactory.createPieChart(
                "Recent test results", dataset, true, true, true);
        PiePlot pie = (PiePlot) chart.getPlot();
        pie.setSectionPaint("Điểm B",new Color(50, 185, 185));
        pie.setSectionPaint("Điểm A",Color.red);
        pie.setSectionPaint("Điểm C",Color.green);
        pie.setSectionPaint("Rớt",Color.yellow);
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

		JLabel lblNewLabel_1 = new JLabel("Tạo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 11, 55, 18);
		panel_2.add(lblNewLabel_1);

		MyButton btnNewButton_1 = new MyButton("Tạo kì thi");
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
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewCreateExam();
			}
		});

		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(10, 36, 235, 153);
		lblNewLabel_3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(getClass().getResource("/view/image/study.jpg"))
				.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH)));
		
		panel_2.add(lblNewLabel_3);
		
		pView.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Chào, " + g.getTen());
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Lịch thi");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 11, 116, 18);
		panel_2_1.add(lblNewLabel_1_1);
		
		MyButton btnNewButton_1_1 = new MyButton("Cài đặt khác");
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
		
		JLabel lblNewLabel_2 = new JLabel("Sửa");
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
		JLabel lblNewLabel = new JLabel("LỚP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);
		
		String[] list = {"ALL"};
		
		JComboBox<String> comboBox = new JComboBox<>(list);
		comboBox.setBounds(615, 35, 90, 22);
		pView.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Lớp :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(571, 30, 46, 28);
		pView.add(lblNewLabel_1);
		
		MyButton btnNewButton_1_1 = new MyButton("Thêm lớp");
		btnNewButton_1_1.setRadius(10);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1_1.setColorClick(new Color(50, 185, 185));
		btnNewButton_1_1.setColor(new Color(50, 185, 185));
		btnNewButton_1_1.setBorderColor(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1_1.setBounds(10, 600, 110, 30);
		
		pView.add(btnNewButton_1_1);
		
		MyButton btnNewButton_1_1_1 = new MyButton("Xóa lớp");
		btnNewButton_1_1_1.setRadius(10);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1_1_1.setColorClick(new Color(50, 185, 185));
		btnNewButton_1_1_1.setColor(new Color(50, 185, 185));
		btnNewButton_1_1_1.setBorderColor(Color.WHITE);
		btnNewButton_1_1_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1_1_1.setBounds(130, 600, 110, 30);
		pView.add(btnNewButton_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 695, 500);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201,201,201)));
		
		pView.add(scrollPane);
		
		table = new MyTable();
		table.setRowHeight(30);
		table.setColor1(Color.WHITE);
		table.setColor2(Color.WHITE);
		table.setGridColor(new Color(201,201,201));
	//	table.setShowGrid(false);
		table.setColumnAlignment(0, JLabel.LEFT);
		table.setCellAlignment(0, JLabel.LEFT);
		
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                comp.setBackground(new Color(50, 185, 185));
                comp.setForeground(Color.WHITE);
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201,201,201)));
               
                return comp;
            }
        });
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"  Tên lớp", "  Số học sinh"
			}
		));		
		
        table.setModel(getModelClasses(g, table));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int i = table.getSelectedRow();
            	String m = table.getValueAt(i, 0).toString();
            	ViewListSVinClass(getClassbyNameClass(m, g));
     //       	ViewClassDetails(controlGV.getClassbyNameClass(m, g));
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
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);
		
		String[] list = {"Tên"};
		
		JComboBox comboBox_1 = new JComboBox(list);
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
		btnNewButton_1_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1_1.setColorClick(new Color(50, 185, 185));
		btnNewButton_1_1.setColor(new Color(50, 185, 185));
		btnNewButton_1_1.setBorderColor(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1_1.setBounds(10, 600, 110, 30);
		
		pView.add(btnNewButton_1_1);
		
		MyButton btnNewButton_1_1_1 = new MyButton("Xóa học sinh");
		btnNewButton_1_1_1.setRadius(10);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1_1_1.setColorClick(new Color(50, 185, 185));
		btnNewButton_1_1_1.setColor(new Color(50, 185, 185));
		btnNewButton_1_1_1.setBorderColor(Color.WHITE);
		btnNewButton_1_1_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1_1_1.setBounds(130, 600, 110, 30);
		pView.add(btnNewButton_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(10, 89, 695, 500);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201,201,201)));
		pView.add(scrollPane);
		
		table = new MyTable();
		table.setRowHeight(30);
		table.setColor1(Color.WHITE);
		table.setColor2(Color.WHITE);
		table.setGridColor(new Color(201,201,201));
	//	table.setShowGrid(false);
		table.setColumnAlignment(0, JLabel.LEFT);
		table.setCellAlignment(0, JLabel.LEFT);
		
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                comp.setBackground(new Color(50, 185, 185));
                comp.setForeground(Color.WHITE);
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201,201,201)));
               
                return comp;
            }
        });
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"  Tên", "  Điểm trung bình", "  Bài vượt qua/Tổng số"
			}
		));
		
		
		// chua xu li controler
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		List<Sv> temp = Class_dao.Instance().selectSVinclass(c);
	    for (Sv sv : temp) { 
	    	Object[] row = {sv.getTen(),"",""};
	    	model.addRow(row);
	    }
		scrollPane.setViewportView(table);
	}
	
	public void ViewExam() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("KÌ THI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);
		
		String[] list = {"Lớp"};
		
		JComboBox comboBox_1 = new JComboBox(list);
		comboBox_1.setBounds(615, 35, 90, 22);
		pView.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sắp xếp :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(550, 30, 59, 28);
		pView.add(lblNewLabel_2);
		
		MyButton btnNewButton_1_1 = new MyButton("Thêm kì thi");
		btnNewButton_1_1.setRadius(10);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1_1.setColorClick(new Color(50, 185, 185));
		btnNewButton_1_1.setColor(new Color(50, 185, 185));
		btnNewButton_1_1.setBorderColor(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1_1.setBounds(10, 600, 110, 30);
		
		pView.add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(10, 89, 695, 500);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201,201,201)));
		pView.add(scrollPane);
		
		table = new MyTable();
		table.setRowHeight(30);
		table.setColor1(Color.WHITE);
		table.setColor2(Color.WHITE);
		table.setGridColor(new Color(201,201,201));
	//	table.setShowGrid(false);
		table.setColumnAlignment(0, JLabel.LEFT);
		table.setCellAlignment(0, JLabel.LEFT);
		
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                comp.setBackground(new Color(50, 185, 185));
                comp.setForeground(Color.WHITE);
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201,201,201)));
               
                return comp;
            }
        });
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"  Lớp", "  Môn", "  Tên kì thi", "  Ngày thi", "  Thời gian bắt đầu", "  Thời gian thi", "  Số câu hỏi"
			}
		));
		table.setModel(getModelExam(g, table));
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				String IdKiThi = table.getValueAt(i,1).toString() + table.getValueAt(i,3).toString().replace("-", "") + table.getValueAt(i,0);
				ViewUpdateExam(getKithibyID(IdKiThi));
				
			}
		});
	}
	
	public void ViewProfile() {
		
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("CÁ NHÂN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		pView.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin cá nhân");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Dimension size_1 = lblNewLabel_1.getPreferredSize();
		lblNewLabel_1.setBounds(10, 60, (int) size_1.getWidth()+1 , (int) size_1.getHeight()+1);
		pView.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã giáo viên :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_2 = lblNewLabel_1.getPreferredSize();
		lblNewLabel_2.setBounds(10, 100, (int) size_2.getWidth()+1 , (int) size_2.getHeight()+1);
		pView.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên : ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_2_1 = lblNewLabel_1.getPreferredSize();
		lblNewLabel_2_1.setBounds(10, 140, (int) size_2_1.getWidth()+1 , (int) size_2_1.getHeight()+1);
		pView.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Mật khẩu :");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_2_1_1 = lblNewLabel_1.getPreferredSize();
		lblNewLabel_2_1_1.setBounds(10, 180, (int) size_2_1_1.getWidth()+1 , (int) size_2_1_1.getHeight()+1);
		pView.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(558, 60, 80, 100);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-avatar-50.png"))));
		
		
		btnNewButton3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(getClass().getResource("/view/image/icons8-male-user-20.png"))));
		
		pView.add(lblNewLabel_3);
		
		MyButton btnNewButton_1_1 = new MyButton("Thay đổi mật khẩu");
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
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				ViewChangePassword v = new ViewChangePassword(g);			
			}
		});
		
		MyButton btnNewButton_1_1_1 = new MyButton("Thay đổi hình ảnh");
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
		
		JLabel lblNewLabel_4_2 = new JLabel("********");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dimension size_4_2 = lblNewLabel_4_2.getPreferredSize();
		lblNewLabel_4_2.setBounds(130, 180, (int) size_4_2.getWidth()+1 , (int) size_4_2.getHeight()+1);
		pView.add(lblNewLabel_4_2);
		
		
	}
	public void ViewCreateNew() {
		
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("TẠO MỚI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);
		
		MyButton NewQuestion = new MyButton("Tạo câu hỏi");
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
		
		NewQuestion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewCreateQuestion();
				
			}
		});
		
		MyButton NewExam = new MyButton("Tạo kì thi");
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
		
		JLabel lblNewLabel = new JLabel("TẠO KÌ THI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 150 , 20);
		
		pView.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 41, 694, 609);
		panel_3.setBackground(Color.white);
		pView.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Lớp : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 30, 50 , 18);
		
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Môn :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(339, 30, 60 , 18);
		panel_3.add(lblNewLabel_1_1);
		
		
		JComboBox<String> comboBox = new JComboBox<>(getTenLop(g));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(60, 30, 102, 22);
		panel_3.add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<>(getTenMon());
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(402, 30, 102, 22);
		panel_3.add(comboBox_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số câu hỏi :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 90, 137 , 18);
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
		textField.setGradientColors(new Color(50,185,185), new Color(50,185,185));
		textField.setCornerRadius(20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPlaceholderTextField("");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(150, 146, 100, 30);
		textField_1.setBorder(null);
		textField_1.setGradientColors(new Color(50,185,185), new Color(50,185,185));
		textField_1.setCornerRadius(20);
		panel_3.add(textField_1);
		
		textField_2 = new JPlaceholderTextField("");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setGradientColors(new Color(50,185,185), new Color(50,185,185));
		textField_2.setCornerRadius(20);
		textField_2.setBounds(140, 86, 100, 30);
		panel_3.add(textField_2);
		
		textField_3 = new JPlaceholderTextField("");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(160, 266, 100, 30);
		textField_3.setBorder(null);
		textField_3.setGradientColors(new Color(50,185,185), new Color(50,185,185));
		textField_3.setCornerRadius(20);
		panel_3.add(textField_3);
		
		textField_4 = new JPlaceholderTextField("");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(150, 446, 100, 30);
		textField_4.setBorder(null);
		textField_4.setGradientColors(new Color(50,185,185), new Color(50,185,185));
		textField_4.setCornerRadius(20);
		panel_3.add(textField_4);
		
		textField_4_1 = new JPlaceholderTextField("");
		textField_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4_1.setCornerRadius(20);
		textField_4_1.setColumns(10);
		textField_4_1.setBorder(null);
		textField_4_1.setBounds(130, 511, 100, 30);
		textField_4_1.setGradientColors(new Color(50,185,185), new Color(50,185,185));
		panel_3.add(textField_4_1);
		
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

        PlaceholderFormattedTextField dateField = new PlaceholderFormattedTextField(dateformatter);
        dateField.setHorizontalAlignment(SwingConstants.CENTER);
        dateField.setColumns(10);
        dateField.setBounds(120, 326, 100, 30);
        dateField.setBorder(null);
        dateField.setGradientColors(new Color(50,185,185), new Color(50,185,185));
        dateField.setCornerRadius(20);
        PlaceholderFormattedTextField timeField = new PlaceholderFormattedTextField(timeformatter);
        timeField.setHorizontalAlignment(SwingConstants.CENTER);
        timeField.setColumns(10);
        timeField.setBounds(200, 386, 100, 30);
        timeField.setBorder(null);
        timeField.setGradientColors(new Color(50,185,185), new Color(50,185,185));
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
		
		MyButton btnNewButton_1_1 = new MyButton("Tạo");
		btnNewButton_1_1.setRadius(10);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1_1.setColorClick(new Color(50, 185, 185));
		btnNewButton_1_1.setColor(new Color(50, 185, 185));
		btnNewButton_1_1.setBorderColor(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1_1.setBounds(520, 560, 150, 30);
		
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
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
		        String m = tenmon + date.replace("-", "") + tenlop;
		        KiThi kt = new KiThi(m,getClassbyNameClass(tenlop, g),timE,duringtime,mota,datE,g,total,hard,easy,medium,getNganhangcauhoibyName(tenmon));    
		        
		  //      System.out.println(datE);

		        InsertExam(kt);
			}
		});
		
		panel_3.add(btnNewButton_1_1);
		
		MyButton btnNewButton_1_1_1 = new MyButton("Hủy");
		btnNewButton_1_1_1.setRadius(10);
		btnNewButton_1_1_1.setForeground(new Color(50, 185, 185));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1.setColorOver(new Color(207, 231, 231));
		btnNewButton_1_1_1.setColorClick(Color.WHITE);
		btnNewButton_1_1_1.setColor(Color.WHITE);
		btnNewButton_1_1_1.setBorderColor(new Color(50, 185, 185));
		btnNewButton_1_1_1.setBackground(Color.white);
		btnNewButton_1_1_1.setBounds(354, 562, 146, 26);
		
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewCreateNew();
				
			}
		});
		
		panel_3.add(btnNewButton_1_1_1);
	}
	
	public void ViewUpdateExam(KiThi kt) {
		
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("CẬP NHẬT THÔNG TIN KÌ THI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 300 , 20);
		
		pView.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 41, 694, 609);
		panel_3.setBackground(Color.white);
		pView.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Lớp : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 30, 50 , 18);
		
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Môn :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(339, 30, 60 , 18);
		panel_3.add(lblNewLabel_1_1);
		
		
		JComboBox<String> comboBox = new JComboBox<>(getTenLop(g));
		
		comboBox.setSelectedIndex(getIndexofArray(getTenLop(g), kt.getLop().getTenlop()));
		
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(60, 30, 102, 22);
		panel_3.add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<>(getTenMon());
		comboBox_1.setSelectedIndex(getIndexofArray(getTenMon(), kt.getNganhangcauhoi().getIdNganHang()));
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(402, 30, 102, 22);
		panel_3.add(comboBox_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số câu hỏi :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 90, 137 , 18);
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
		textField.setGradientColors(new Color(50,185,185), new Color(50,185,185));
		textField.setCornerRadius(20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPlaceholderTextField("");
		textField_1.setText(String.valueOf(kt.getSocauDe()));
		textField_1.setHorizontalAlignment(JPlaceholderTextField.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(150, 146, 100, 30);
		textField_1.setBorder(null);
		textField_1.setGradientColors(new Color(50,185,185), new Color(50,185,185));
		textField_1.setCornerRadius(20);
		panel_3.add(textField_1);
		
		textField_2 = new JPlaceholderTextField("");
		textField_2.setText(String.valueOf(kt.getSl()));
		textField_2.setHorizontalAlignment(JPlaceholderTextField.CENTER);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setGradientColors(new Color(50,185,185), new Color(50,185,185));
		textField_2.setCornerRadius(20);
		textField_2.setBounds(140, 86, 100, 30);
		panel_3.add(textField_2);
		
		textField_3 = new JPlaceholderTextField("");
		textField_3.setText(String.valueOf(kt.getSocaukho()));
		textField_3.setHorizontalAlignment(JPlaceholderTextField.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(160, 266, 100, 30);
		textField_3.setBorder(null);
		textField_3.setGradientColors(new Color(50,185,185), new Color(50,185,185));
		textField_3.setCornerRadius(20);
		panel_3.add(textField_3);
		
		textField_4 = new JPlaceholderTextField("");
		textField_4.setText(String.valueOf(kt.getThoigianlambai()));
		textField_4.setHorizontalAlignment(JPlaceholderTextField.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(150, 446, 100, 30);
		textField_4.setBorder(null);
		textField_4.setGradientColors(new Color(50,185,185), new Color(50,185,185));
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

        PlaceholderFormattedTextField dateField = new PlaceholderFormattedTextField(dateformatter);
        dateField.setValue(kt.getDate());
        System.out.println(kt.getDate());
        dateField.setHorizontalAlignment(SwingConstants.CENTER);
        dateField.setColumns(10);
        dateField.setBounds(120, 326, 100, 30);
        dateField.setBorder(null);
        dateField.setGradientColors(new Color(50,185,185), new Color(50,185,185));
        dateField.setCornerRadius(20);
        PlaceholderFormattedTextField timeField = new PlaceholderFormattedTextField(timeformatter);
        timeField.setValue(kt.getThoigianbatdau());
        timeField.setHorizontalAlignment(SwingConstants.CENTER);
        timeField.setColumns(10);
        timeField.setBounds(200, 386, 100, 30);
        timeField.setBorder(null);
        timeField.setGradientColors(new Color(50,185,185), new Color(50,185,185));
		timeField.setCornerRadius(20);
        panel_3.add(dateField);
		panel_3.add(timeField);
		
		JLabel lblNewLabel_1_2_3_3_1 = new JLabel("Mô tả :");
		lblNewLabel_1_2_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_3_1.setBounds(10, 510, 100, 18);
		panel_3.add(lblNewLabel_1_2_3_3_1);
		
		JPlaceholderTextField textField_4_1 = new JPlaceholderTextField("");
		textField_4_1.setText(kt.getMota());
		textField_4_1.setHorizontalAlignment(JPlaceholderTextField.CENTER);
		textField_4_1.setCornerRadius(20);
		textField_4_1.setColumns(10);
		textField_4_1.setBorder(null);
		textField_4_1.setBounds(130, 511, 100, 30);
		textField_4_1.setGradientColors(new Color(50,185,185), new Color(50,185,185));
		panel_3.add(textField_4_1);
		
		JLabel lblNewLabel_2 = new JLabel("( VD: 2004/04/07)");
		lblNewLabel_2.setForeground(new Color(192, 192, 192));
		lblNewLabel_2.setBounds(230, 334, 102, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("( VD: 09:00:00)");
		lblNewLabel_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1.setBounds(310, 394, 102, 14);
		panel_3.add(lblNewLabel_2_1);
		
		MyButton btnNewButton_1_1_1 = new MyButton("Cập nhật");
		btnNewButton_1_1_1.setRadius(10);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1_1_1.setColorClick(new Color(50, 185, 185));
		btnNewButton_1_1_1.setColor(new Color(50, 185, 185));
		btnNewButton_1_1_1.setBorderColor(Color.WHITE);
		btnNewButton_1_1_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1_1_1.setBounds(520, 560, 110, 30);
		
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			
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
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
		        String m = tenmon + date.replace("-", "") + tenlop;
		        KiThi kt = new KiThi(m,getClassbyNameClass(tenlop, g),timE,duringtime,mota,datE,g,total,hard,easy,medium,getNganhangcauhoibyName(tenmon));    
		        		        
		        UpdateExam(kt);
			}
		});
		
		panel_3.add(btnNewButton_1_1_1);
		
		MyButton btnNewButton_1_1_2 = new MyButton("Hủy");
		btnNewButton_1_1_2.setRadius(10);
		btnNewButton_1_1_2.setForeground(new Color(50, 185, 185));
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_2.setColorOver(new Color(207, 231, 231));
		btnNewButton_1_1_2.setColorClick(Color.WHITE);
		btnNewButton_1_1_2.setColor(Color.WHITE);
		btnNewButton_1_1_2.setBorderColor(new Color(50, 185, 185));
		btnNewButton_1_1_2.setBackground(Color.white);
		btnNewButton_1_1_2.setBounds(354, 562, 110, 26);
		
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				ViewExam();
			}
		});
		
		panel_3.add(btnNewButton_1_1_2);
		
		MyButton btnNewButton_2 = new MyButton("Xóa kì thi");
		btnNewButton_2.setRadius(10);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setColorOver(new Color(100, 241, 241));
		btnNewButton_2.setColorClick(new Color(50, 185, 185));
		btnNewButton_2.setColor(new Color(50, 185, 185));
		btnNewButton_2.setBorderColor(Color.WHITE);
		btnNewButton_2.setBackground(new Color(50, 185, 185));
		btnNewButton_2.setBounds(10, 560, 110, 30);
		
		panel_3.add(btnNewButton_2);
	}
	public void ViewCreateQuestion() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("TẠO CÂU HỎI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 150 , 20);
		
		pView.add(lblNewLabel);
		
		PanelRound panel_1 = new PanelRound(50);
		panel_1.setBorderWidth(1);
		panel_1.setBorderGradientColor(new Color(50, 185, 185), new Color(50, 185, 185));
		panel_1.setBounds(10, 41, 694, 550);
		panel_1.setBground(Color.red);
		pView.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Môn :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(30, 30, 60 , 18);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mức độ :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(370, 30, 60, 18);
		panel_1.add(lblNewLabel_1_1_1);
		
		JComboBox<String> comboBox = new JComboBox<>(getTenMon());
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(130, 30, 102, 22);
		panel_1.add(comboBox);
		
		String[] list = {"1","2","3"};
		
		JComboBox<String> comboBox_1 = new JComboBox<>(list);
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(470, 30, 102, 22);
		panel_1.add(comboBox_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Câu hỏi :");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(30, 110, 75, 18);
		panel_1.add(lblNewLabel_1_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 110, 520, 75);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		
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
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		scrollPane_1.setViewportView(textArea_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(130, 290, 520, 45);
		panel_1.add(scrollPane_1_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		textArea_2.setWrapStyleWord(true);
		scrollPane_1_1.setViewportView(textArea_2);
		
		JScrollPane scrollPane_1_2 = new JScrollPane();
		scrollPane_1_2.setBounds(130, 370, 520, 45);
		panel_1.add(scrollPane_1_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setLineWrap(true);
		textArea_3.setWrapStyleWord(true);
		scrollPane_1_2.setViewportView(textArea_3);
		
		JScrollPane scrollPane_1_3 = new JScrollPane();
		scrollPane_1_3.setBounds(130, 450, 520, 45);
		panel_1.add(scrollPane_1_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setLineWrap(true);
		textArea_4.setWrapStyleWord(true);
		scrollPane_1_3.setViewportView(textArea_4);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Đáp án đúng");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBounds(130, 260, 109, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Đáp án đúng");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setBounds(130, 342, 109, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Đáp án đúng");
		rdbtnNewRadioButton_2.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_2.setBounds(130, 422, 109, 23);
		panel_1.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Đáp án đúng");
		rdbtnNewRadioButton_3.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_3.setBounds(130, 502, 109, 23);
		panel_1.add(rdbtnNewRadioButton_3);
		
		ButtonGroup onechoice = new ButtonGroup();
		onechoice.add(rdbtnNewRadioButton);
		onechoice.add(rdbtnNewRadioButton_1);
		onechoice.add(rdbtnNewRadioButton_2);
		onechoice.add(rdbtnNewRadioButton_3);
		
		MyButton btnNewButton_1_1 = new MyButton("Lưu và tiếp tục");
		btnNewButton_1_1.setRadius(10);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1_1.setColorClick(new Color(50, 185, 185));
		btnNewButton_1_1.setColor(new Color(50, 185, 185));
		btnNewButton_1_1.setBorderColor(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1_1.setBounds(554, 607, 150, 30);
		
		pView.add(btnNewButton_1_1);
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			                                                                ///// đang làm dở //////////////////////////////////////////
			@Override
			public void actionPerformed(ActionEvent e) {
				String question = textArea.getText();
				String dapanA = textArea_1.getText();
				String dapanB = textArea_2.getText();
				String dapanC = textArea_3.getText();
				String dapanD = textArea_4.getText();
				String dapanDung=null;
				String tenMon = comboBox.getSelectedItem().toString();
				int mucdo = Integer.parseInt(comboBox_1.getSelectedItem().toString());
				if(rdbtnNewRadioButton.isSelected()) {
					dapanDung = textArea_1.getText();
				}else if(rdbtnNewRadioButton_1.isSelected()) {
					dapanDung = textArea_2.getText();
				}else if(rdbtnNewRadioButton_2.isSelected()) {
					dapanDung = textArea_3.getText();
				}else if(rdbtnNewRadioButton_3.isSelected()) {
					dapanDung = textArea_4.getText();
				}else {
					JOptionPane.showMessageDialog(null, "Bạn cần chọn câu trả lời đúng","LỖI",JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				// tạo id bằng phương pháp UUID
				String id = UUID.randomUUID().toString();
				
				Cauhoi c = new Cauhoi(id,question,dapanA,dapanB,dapanC,dapanD,mucdo,dapanDung,getNganhangcauhoibyName(tenMon));
				
				InsertCauhoi(c);
			}
		});
		
		MyButton btnNewButton_1_1_1 = new MyButton("Thoát");
		btnNewButton_1_1_1.setRadius(10);
		btnNewButton_1_1_1.setForeground(new Color(50, 185, 185));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1.setColorOver(new Color(207, 231, 231));
		btnNewButton_1_1_1.setColorClick(Color.WHITE);
		btnNewButton_1_1_1.setColor(Color.WHITE);
		btnNewButton_1_1_1.setBorderColor(new Color(50, 185, 185));
		btnNewButton_1_1_1.setBackground(Color.white);
		btnNewButton_1_1_1.setBounds(382, 609, 146, 26);
		
		pView.add(btnNewButton_1_1_1);
		
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ViewCreateNew();
			}
		});
	}
	
	
	
	
	//////////////////////////////////////////////////////////////
	
	
	
	public List<Giangday> getClasses(Gv g) {
		return g.getDanhsachlop();
	}
	public DefaultTableModel getModelClasses(Gv g, JTable table) {
		List<Giangday> dslop = g.getDanhsachlop();
		System.out.println(dslop);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Giangday giangday : dslop) {
			List<Sv> listSV = Class_dao.Instance().selectSVinclass(giangday.getMalop());
			Object[] row = {giangday.getMalop().getTenlop(),listSV.size()};
			model.addRow(row);
		}
		return model;
	}
	public DefaultTableModel getModelExam(Gv g, JTable table) {
		List<KiThi> kthi = KiThi_dao.Instance().selectall();
		String idgv = g.getId();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (KiThi k : kthi) {
			if(idgv.equalsIgnoreCase(k.getGv().getId())) {
				Object[] row = {k.getLop().getTenlop(),k.getNganhangcauhoi().getIdNganHang(), k.getMota(),
						k.getDate(), k.getThoigianbatdau(), k.getThoigianlambai(), k.getSl()};
				model.addRow(row);
			}
		}
		return model;
	}
	public Class getClassbyNameClass(String m, Gv g) {
    	for (Giangday giangday : g.getDanhsachlop()) {
			if(m == giangday.getMalop().getTenlop()) {
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
		String[] tenmon = new String[NganHangCauHoi.size()];
		for (Nganhangcauhoi cauhoi : NganHangCauHoi) {
			tenmon[i] = cauhoi.getIdNganHang();
			i++;
		}
		return tenmon;
	}
	public Nganhangcauhoi getNganhangcauhoibyName(String name) {
		List<Nganhangcauhoi> NganHangCauHoi = NganhangDao.Instance().selectall();
		for (Nganhangcauhoi nganhangcauhoi2 : NganHangCauHoi) {
			if(name.equalsIgnoreCase(nganhangcauhoi2.getIdNganHang())) {
				return nganhangcauhoi2;
			}
		}
		return null;
	}
	public KiThi getKithibyID(String id) {
		KiThi k = KiThi_dao.Instance().selectbyid(id);
		return k;
	}
	public int getIndexofArray(String[] arr,String s) {
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
	public void UpdateExam(KiThi k) {
		KiThi_dao.Instance().update(k);
	}
	public void InsertCauhoi(Cauhoi c) {
		Cauhoi_Dao.Instance().insert(c);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
}
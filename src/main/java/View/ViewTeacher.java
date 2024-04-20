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
import javax.swing.text.View;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class ViewTeacher extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JPanel pView;
	MyButton btnNewButton1,btnNewButton,btnNewButton3,btnNewButton2,btnNewButton4;
	private JTable table;
	public Gv g;
	
	public ViewTeacher(Gv gv) {
		this.g = gv;
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
		btnNewButton3.addActionListener(this);
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
		
		JLabel lblNewLabel = new JLabel("Hi " + "\n" + g.getTen());
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
		JLabel lblNewLabel = new JLabel("Classes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 11, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
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
		scrollPane.setBounds(10, 89, 695, 561);
		scrollPane.getViewport().setBackground(Color.WHITE);
		
		pView.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.getTableHeader().setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Title", "Students"
			}
		));
		scrollPane.setViewportView(table);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton1) {
		//	pView.removeAll();
			ViewClass();
			System.out.println("cc \n");
			
		}else if(e.getSource() == btnNewButton ) {
		//	pView.removeAll();
			ViewHome();
			System.out.println("cc \n");
		}
		
	}
}

package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;

public class ViewResult extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	Color Blue=  new Color(17, 49, 123);
	Color Gray = new Color(122, 122, 129);
	Color Green = new Color(44, 173, 167);
	Color purple = new Color(221, 0, 221);
	
	public MyButton btnNewButton;
	public JPanel pn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewResult frame = new ViewResult();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewResult() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1299, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 1290, 1000);
		contentPane.add(scrollPane);
		
		pn = new JPanel();
		scrollPane.setViewportView(pn);
		pn.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Blue);
		panel.setBounds(0, 0, 1286, 79);
		pn.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(36, 136, 490, 5);
		lblNewLabel_1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/recTrai.png"))
						.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH)));
		pn.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(744, 136, 490, 5);
		lblNewLabel_2.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/RecPhai.png"))
						.getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH)));
		
		pn.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("HOÀN THÀNH");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNewLabel.setForeground(Green);
		lblNewLabel.setBounds(557, 118, 177, 41);
		pn.add(lblNewLabel);
		
		PanelRound panel_1 = new PanelRound();
		panel_1.setRadius(20);
		panel_1.setBounds(36, 170, 662, 258);
		pn.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(279, 11, 373, 247);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(6, 2, 10, 10));
		
		JLabel lblNewLabel_3 = new JLabel("Bài thi: ");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(Gray);
		panel_2.add(lblNewLabel_3);
		
		JLabel TextBaiThi = new JLabel("Tên bài thi");
		TextBaiThi.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel_2.add(TextBaiThi);
		
		JLabel lblNewLabel_3_1 = new JLabel("Thời gian làm bài: ");
		lblNewLabel_3_1.setForeground(new Color(122, 122, 129));
		lblNewLabel_3_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_3_1);
		
		JLabel TextThoiGian = new JLabel("Tên bài thi");
		TextThoiGian.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel_2.add(TextThoiGian);
		
		JLabel lblNewLabel_3_2 = new JLabel("Số câu hỏi: ");
		lblNewLabel_3_2.setForeground(new Color(122, 122, 129));
		lblNewLabel_3_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_3_2);
		
		JLabel TextSoCauHoi = new JLabel("Tên bài thi");
		TextSoCauHoi.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel_2.add(TextSoCauHoi);
		
		JLabel lblNewLabel_3_3 = new JLabel("Số câu đúng: ");
		lblNewLabel_3_3.setForeground(new Color(122, 122, 129));
		lblNewLabel_3_3.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_3_3);
		
		JLabel TextSoCauDung = new JLabel("Tên bài thi");
		TextSoCauDung.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel_2.add(TextSoCauDung);
		
		JLabel lblNewLabel_3_4 = new JLabel("Số câu sai: ");
		lblNewLabel_3_4.setForeground(new Color(122, 122, 129));
		lblNewLabel_3_4.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_3_4);
		
		JLabel TextSoCauSai = new JLabel("Tên bài thi");
		TextSoCauSai.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel_2.add(TextSoCauSai);
		
		JLabel lblNewLabel_3_5 = new JLabel("Số điểm: ");
		lblNewLabel_3_5.setForeground(new Color(122, 122, 129));
		lblNewLabel_3_5.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_3_5);
		
		JLabel TextSoDiem = new JLabel("Tên bài thi");
		TextSoDiem.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel_2.add(TextSoDiem);
		
		PanelRound panel_3 = new PanelRound();
		panel_3.setBorderWidth(2);
		panel_3.setRadius(160);
		panel_3.setBounds(42, 51, 160, 160);
		panel_3.setBorderColor(Green);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_4 = new JLabel("Center");
		lblNewLabel_4.setForeground(Green);
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setVerticalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_4,BorderLayout.CENTER);
		
		 btnNewButton = new MyButton("Thoát");
		 btnNewButton.setColorOver(Green);
		 btnNewButton.setRadius(20);
		btnNewButton.setBounds(1128, 394, 127, 34);
		pn.add(btnNewButton);
		
		PanelRound panel_1_1 = new PanelRound();
		panel_1_1.setLayout(null);
		panel_1_1.setRadius(20);
		panel_1_1.setBounds(36, 439, 1219, 510);
		pn.add(panel_1_1);
		
		JLabel lblCuTrLi = new JLabel("Câu trả lời");
		lblCuTrLi.setForeground(new Color(0, 0, 0));
		lblCuTrLi.setFont(new Font("Calibri", Font.BOLD, 26));
		lblCuTrLi.setBounds(10, 11, 132, 41);
		panel_1_1.add(lblCuTrLi);
		
		JLabel lblNewLabel_3_6 = new JLabel("Hiển thị:");
		lblNewLabel_3_6.setForeground(new Color(122, 122, 129));
		lblNewLabel_3_6.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_3_6.setBounds(1069, 17, 65, 32);
		panel_1_1.add(lblNewLabel_3_6);
		
		JLabel lblTtC = new JLabel("Tất cả");
		lblTtC.setForeground(Color.BLACK);
		lblTtC.setFont(new Font("Calibri", Font.BOLD, 18));
		lblTtC.setBounds(1144, 16, 65, 32);
		panel_1_1.add(lblTtC);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 63, 1199, 436);
		panel_1_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Câu hỏi 1");
		lblNewLabel_1_1.setForeground(new Color(17, 49, 123));
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNewLabel_1_1.setBounds(10, 11, 153, 37);
		panel_4.add(lblNewLabel_1_1);
		
		JTextArea Cauhoi = new JTextArea();
		Cauhoi.setText("Who is the author of 'To Kill a Mockingbird'?");
		Cauhoi.setFont(new Font("Calibri", Font.BOLD, 24));
		Cauhoi.setEditable(false);
		Cauhoi.setBounds(10, 59, 723, 119);
		panel_4.add(Cauhoi);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(787, 175, 25, 25);
		panel_4.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 189, 723, 236);
		panel_4.add(panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0};
		gbl_panel_6.rowHeights = new int[]{0};
		gbl_panel_6.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
	}
}

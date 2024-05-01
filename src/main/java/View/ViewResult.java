package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller_ViewResult;
import DAO.Sv_dao;
import model.Cauhoi;
import model.DeThi;
import model.KiThi;
import model.Sv;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

public class ViewResult extends JFrame {

	private static final long serialVersionUID = 1L;
	Controller_ViewResult rs = new Controller_ViewResult(this);
	private JPanel contentPane;
	public String[] checkAnswer;
	public List<Cauhoi> listCauhoi = new ArrayList<Cauhoi>();
	public Sv v;
	public KiThi ktOngoing;
	
	public DeThi dethi; public int socaudung = 0 , socausai = 0 ; public double diem;
	Color Blue=  new Color(17, 49, 123);
	Color Gray = new Color(122, 122, 129);
	Color Green = new Color(44, 173, 167);
	Color purple = new Color(221, 0, 221);
	int vx = 10 , vy = 63;
	int socauhoi = 1;
	public MyButton btnNewButton;
	public JPanel pn;
	public JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public ViewResult(Sv sv, KiThi onl, DeThi dt, List<Cauhoi> ls, String[] answer) {
		this.v = sv;
		this.ktOngoing = Sv_dao.Instance().findKithiOnl(v);
		this.dethi = dt ; this.listCauhoi = ls ; this.checkAnswer = answer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 1000, 700);
		ViewResult1();
		setVisible(true);
	}
	public String dapan(int i) {
		String q = "";
		if(this.checkAnswer[i] == "A") q= this.listCauhoi.get(i).getDapAnA();
		if(this.checkAnswer[i] == "B") q= this.listCauhoi.get(i).getDapAnB();
		if(this.checkAnswer[i] == "C") q= this.listCauhoi.get(i).getDapAnC();
		if(this.checkAnswer[i] == "D") q= this.listCauhoi.get(i).getDapAnD();
		return q;

	}
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ViewResult frame = new ViewResult();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public JPanel addCau(int i) {
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(vx,vy, 1199, 436);
		vy = vy + 486;
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Câu hỏi " + socauhoi); socauhoi+= 1;
		lblNewLabel_1_1.setForeground(new Color(17, 49, 123));
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNewLabel_1_1.setBounds(10, 11, 153, 37);
		panel_4.add(lblNewLabel_1_1);
		
		JTextArea Cauhoi = new JTextArea();
		Cauhoi.setText(listCauhoi.get(socauhoi-2).getNoidung());
		Cauhoi.setFont(new Font("Calibri", Font.BOLD, 24));
		Cauhoi.setEditable(false);
		Cauhoi.setBounds(10, 59, 723, 119);
		panel_4.add(Cauhoi);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 190, 767, 236);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		PanelRound panel_5= new PanelRound();
		panel_5.setRadius(25);
		panel_5.setBorderWidth(2);		
		panel_5.setBounds(10, 31 , 25, 25);
		panel_6.add(panel_5);
		
		JLabel lblNewLabel_5 = new JLabel(listCauhoi.get(socauhoi-2).getDapAnA());
		lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblNewLabel_5.setBounds(57, 31, 448, 32);
		panel_6.add(lblNewLabel_5);
		
		
		PanelRound panel_5_1 = new PanelRound();
		panel_5_1.setRadius(25);
		panel_5_1.setBorderWidth(2);
		panel_5_1.setBounds(10, 31 + 58 * 1 , 25, 25);
		panel_6.add(panel_5_1);
		
		JLabel lblNewLabel_5_1 = new JLabel(listCauhoi.get(socauhoi-2).getDapAnB());
		lblNewLabel_5_1.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblNewLabel_5_1.setBounds(57, 31 + 58 * 1, 448, 32);
		panel_6.add(lblNewLabel_5_1);
		
		PanelRound panel_5_2 = new PanelRound();
		panel_5_2.setRadius(25);
		panel_5_2.setBorderWidth(2);
		panel_5_2.setBounds(10, 31 + 58 * 2 , 25, 25);
		panel_6.add(panel_5_2);
		
		JLabel lblNewLabel_5_2 = new JLabel(listCauhoi.get(socauhoi-2).getDapAnC());
		lblNewLabel_5_2.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblNewLabel_5_2.setBounds(57, 31 + 58 * 2, 448, 32);
		panel_6.add(lblNewLabel_5_2);
		
		PanelRound panel_5_3 = new PanelRound();
		panel_5_3.setRadius(25);
		panel_5_3.setBorderWidth(2);
		panel_5_3.setBounds(10, 31 + 58 * 3 , 25, 25);
		panel_6.add(panel_5_3);
		
		JLabel lblNewLabel_5_3 = new JLabel(listCauhoi.get(socauhoi-2).getDapAnD());
		lblNewLabel_5_3.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblNewLabel_5_3.setBounds(57, 31 + 58 * 3, 448, 32);
		panel_6.add(lblNewLabel_5_3);

		MyButton mbtnng = new MyButton("");
		mbtnng.setFont(new Font("Calibri", Font.BOLD, 23));
		mbtnng.setRadius(20);
		mbtnng.setColor(Green);
		mbtnng.setForeground(Color.white);
		mbtnng.setBounds(1042, 23, 127, 34);
		mbtnng.setEnabled(false);
		panel_4.add(mbtnng);
		
		double socau1 = listCauhoi.size();
		socau1 = 10/socau1;
		MyButton mbtnim = new MyButton(String.format("%.2f", socau1) + " điểm");
		mbtnim.setRadius(20);
		mbtnim.setFont(new Font("Calibri", Font.BOLD, 23));
		mbtnim.setColor(Color.white);
		mbtnim.setForeground(Green);
		mbtnim.setEnabled(false);
		mbtnim.setBounds(1042, 80, 127, 34);
		panel_4.add(mbtnim);
		if(dapan(i).equals( this.listCauhoi.get(i).getDapan()))
		{
			panel_5.setBorderGradientColor(Green,Green);
			panel_5_1.setBorderGradientColor(Green,Green);
			panel_5_2.setBorderGradientColor(Green,Green);
			panel_5_3.setBorderGradientColor(Green,Green);
			if(this.checkAnswer[i].equals("A")) panel_5.setBground(Green); else 
				if(this.checkAnswer[i].equals("B")) panel_5_1.setBground(Green); else 
					if(this.checkAnswer[i].equals("C")) panel_5_2.setBground(Green); else 
						if(this.checkAnswer[i].equals("D")) panel_5_3.setBground(Green); 
			mbtnng.setText("Đúng")  ;
		} else {
			panel_5.setBorderGradientColor(Color.red,Color.red);
			panel_5_1.setBorderGradientColor(Color.red,Color.red);
			panel_5_2.setBorderGradientColor(Color.red,Color.red);
			panel_5_3.setBorderGradientColor(Color.red,Color.red);
			if(this.checkAnswer[i].equals("A")) { panel_5.setBground(Color.red); System.out.println("ok");} else 
				if(this.checkAnswer[i].equals("B")) panel_5_1.setBground(Color.red); else 
					if(this.checkAnswer[i].equals("C")) panel_5_2.setBground(Color.red); else 
						if(this.checkAnswer[i].equals("D")) panel_5_3.setBground(Color.red); 
			mbtnng.setText("Sai")  ;
		}
		

		
		
		
		return panel_4;
		
	}
	public void ViewResult1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1298, 950);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 1290, 1000);
		scrollPane.addMouseWheelListener(rs);
		scrollPane.setBorder(null);

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
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Gray);
		panel_2.add(lblNewLabel_3);
		
		JLabel TextBaiThi = new JLabel(this.ktOngoing.getMota());
		TextBaiThi.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_2.add(TextBaiThi);
		
		JLabel lblNewLabel_3_1 = new JLabel("Thời gian làm bài: ");
		lblNewLabel_3_1.setForeground(new Color(122, 122, 129));
		lblNewLabel_3_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_3_1);
		
		JLabel TextThoiGian = new JLabel("Tên bài thi");
		int hour = ktOngoing.getThoigianlambai() / 60;
		int minute = ktOngoing.getThoigianlambai() % 60;
		if(hour != 0) TextThoiGian.setText(String.valueOf(hour) + " tiếng " + String.valueOf(minute) + " phút") ;
		else TextThoiGian.setText(String.valueOf(minute) + " phút");
		TextThoiGian.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_2.add(TextThoiGian);
		
		JLabel lblNewLabel_3_2 = new JLabel("Số câu hỏi: ");
		lblNewLabel_3_2.setForeground(new Color(122, 122, 129));
		lblNewLabel_3_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_3_2);
		
		JLabel TextSoCauHoi = new JLabel(this.listCauhoi.size() + "");
		TextSoCauHoi.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_2.add(TextSoCauHoi);
		
		JLabel lblNewLabel_3_3 = new JLabel("Số câu đúng: ");
		lblNewLabel_3_3.setForeground(new Color(122, 122, 129));
		lblNewLabel_3_3.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_3_3);
		

		double socau1 = listCauhoi.size();
		socau1 = 10/socau1;
		for(int i = 0 ; i < this.listCauhoi.size() ; i++) 
		{
			if(dapan(i).equals( this.listCauhoi.get(i).getDapan())) {this.socaudung++; this.diem+=socau1;}
			else this.socausai++;
		}
		JLabel TextSoCauDung = new JLabel(this.socaudung+"");
		TextSoCauDung.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_2.add(TextSoCauDung);
		
		JLabel lblNewLabel_3_4 = new JLabel("Số câu sai: ");
		lblNewLabel_3_4.setForeground(new Color(122, 122, 129));
		lblNewLabel_3_4.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_3_4);
		
		JLabel TextSoCauSai = new JLabel(this.socausai+"");
		TextSoCauSai.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_2.add(TextSoCauSai);
		
		JLabel lblNewLabel_3_5 = new JLabel("Số điểm: ");
		lblNewLabel_3_5.setForeground(new Color(122, 122, 129));
		lblNewLabel_3_5.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_3_5);
		
		JLabel TextSoDiem = new JLabel(String.format("%.2f", this.diem));
		TextSoDiem.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_2.add(TextSoDiem);
		
		PanelRound panel_3 = new PanelRound();
		panel_3.setBorderWidth(2);
		panel_3.setRadius(160);
		panel_3.setBounds(42, 51, 160, 160);
		panel_3.setBorderColor(Green);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_4 = new JLabel(this.socaudung + "/" + this.listCauhoi.size());
		lblNewLabel_4.setForeground(Green);
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 32));
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
		
		for(int i = 0 ; i < listCauhoi.size() ; i++) 
		{
			panel_1_1.setBounds(36, 439, 1219, 74 + 436 * (i+1) + 50 * (i+1)  );
			panel_1_1.add(addCau(i));
			
			
		}
		pn.setPreferredSize(new Dimension(1290,439 + panel_1_1.getHeight() + 200 ));

		
		
		
		/*
		 * JLabel lblNewLabel_1_1 = new JLabel("Câu hỏi 1");
		 * lblNewLabel_1_1.setForeground(new Color(17, 49, 123));
		 * lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD, 26));
		 * lblNewLabel_1_1.setBounds(10, 11, 153, 37); panel_4.add(lblNewLabel_1_1);
		 * 
		 * JTextArea Cauhoi = new JTextArea();
		 * Cauhoi.setText("Who is the author of 'To Kill a Mockingbird'?");
		 * Cauhoi.setFont(new Font("Calibri", Font.BOLD, 24));
		 * Cauhoi.setEditable(false); Cauhoi.setBounds(10, 59, 723, 119);
		 * panel_4.add(Cauhoi);
		 * 
		 * JPanel panel_6 = new JPanel(); panel_6.setBounds(10, 190, 767, 236);
		 * panel_4.add(panel_6); panel_6.setLayout(null);
		 * 
		 * PanelRound panel_5 = new PanelRound(); panel_5.setRadius(25);
		 * panel_5.setBounds(10, 31 , 25, 25); panel_6.add(panel_5);
		 * 
		 * JLabel lblNewLabel_5 = new JLabel("New label"); lblNewLabel_5.setFont(new
		 * Font("Calibri", Font.PLAIN, 24)); lblNewLabel_5.setBounds(57, 31, 448, 32);
		 * panel_6.add(lblNewLabel_5);
		 * 
		 * PanelRound panel_5_1 = new PanelRound(); panel_5_1.setRadius(25);
		 * panel_5_1.setBounds(10, 31 + 58 * 1 , 25, 25); panel_6.add(panel_5_1);
		 * 
		 * JLabel lblNewLabel_5_1 = new JLabel("New label"); lblNewLabel_5_1.setFont(new
		 * Font("Calibri", Font.PLAIN, 24)); lblNewLabel_5_1.setBounds(57, 31 + 58 * 1,
		 * 448, 32); panel_6.add(lblNewLabel_5_1);
		 * 
		 * PanelRound panel_5_2 = new PanelRound(); panel_5_2.setRadius(25);
		 * panel_5_2.setBounds(10, 31 + 58 * 2 , 25, 25); panel_6.add(panel_5_2);
		 * 
		 * JLabel lblNewLabel_5_2 = new JLabel("New label"); lblNewLabel_5_2.setFont(new
		 * Font("Calibri", Font.PLAIN, 24)); lblNewLabel_5_2.setBounds(57, 31 + 58 * 2,
		 * 448, 32); panel_6.add(lblNewLabel_5_2);
		 * 
		 * PanelRound panel_5_3 = new PanelRound(); panel_5_3.setRadius(25);
		 * panel_5_3.setBounds(10, 31 + 58 * 3 , 25, 25); panel_6.add(panel_5_3);
		 * 
		 * JLabel lblNewLabel_5_3 = new JLabel("New label"); lblNewLabel_5_3.setFont(new
		 * Font("Calibri", Font.PLAIN, 24)); lblNewLabel_5_3.setBounds(57, 31 + 58 * 3,
		 * 448, 32); panel_6.add(lblNewLabel_5_3);
		 * 
		 * MyButton mbtnng = new MyButton("Thoát"); mbtnng.setFont(new Font("Calibri",
		 * Font.BOLD, 23)); mbtnng.setText("Đúng"); mbtnng.setRadius(20);
		 * mbtnng.setColorOver(new Color(44, 173, 167)); mbtnng.setBounds(1042, 23, 127,
		 * 34); panel_4.add(mbtnng);
		 * 
		 * MyButton mbtnim = new MyButton("Thoát"); mbtnim.setText("3 điểm");
		 * mbtnim.setRadius(20); mbtnim.setFont(new Font("Calibri", Font.BOLD, 23));
		 * mbtnim.setColorOver(new Color(44, 173, 167)); mbtnim.setBounds(1042, 80, 127,
		 * 34); panel_4.add(mbtnim);
		 */
		
	}
}

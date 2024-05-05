package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller_AddNganHangCauHoi;
import DAO.NganhangDao;
import model.Gv;
import model.Nganhangcauhoi;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewAddNganHangCauHoi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField tenNGCH;
	public JButton buttonOK,buttonHuy;
	public Gv g;
	Controller_AddNganHangCauHoi action = new Controller_AddNganHangCauHoi(this);

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ViewAddNganHangCauHoi frame = new
	 * ViewAddNganHangCauHoi(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public ViewAddNganHangCauHoi(Gv g) {
		this.g =g;
		setBounds(100, 100, 320, 150);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên ngân hàng :");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel.setBounds(48, 28, 123, 27);
		contentPane.add(lblNewLabel);
		
		tenNGCH = new JTextField();
		tenNGCH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tenNGCH.setBounds(166, 31, 86, 20);
		contentPane.add(tenNGCH);
		tenNGCH.setColumns(10);
		
		buttonOK = new JButton("Ok");
		buttonOK.setBounds(62, 77, 89, 23);
		contentPane.add(buttonOK);
		buttonOK.addActionListener(action);
		
		buttonHuy = new JButton("Hủy");
		buttonHuy.setBounds(161, 77, 89, 23);
		contentPane.add(buttonHuy);
		buttonHuy.addActionListener(action);
	}
	public void insertNganHangCauHoi(String idNganHang, int soluong, Gv giaovienquanli) {
		Nganhangcauhoi c = new Nganhangcauhoi(idNganHang, soluong ,giaovienquanli);
		NganhangDao.Instance().insert(c);
	}
}












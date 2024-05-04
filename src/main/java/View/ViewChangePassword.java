package View;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Controller.Controller_Teacher;
import model.Gv;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.beans.Visibility;
import java.text.AttributedCharacterIterator;
import javax.swing.JTextField;

public class ViewChangePassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPlaceholderTextField textField;
	private Gv g;
	public Controller_Teacher controlGV = new Controller_Teacher();


	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ViewChangePassword frame = new
	 * ViewChangePassword(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public ViewChangePassword(Gv gv) {
		this.g = gv;
		setBounds(700, 350, 400, 400);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 185, 185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thay đổi mật khẩu");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Dimension size_4_2 = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(120, 30, (int) size_4_2.getWidth()+1 , (int) size_4_2.getHeight()+1);
		contentPane.add(lblNewLabel);
		
		PanelRound panel = new PanelRound(0);
		panel.setBounds(20, 68, 345, 2);
		panel.setBground(getBackground());
		panel.setBorderWidth(1);
		Border redBorder = BorderFactory.createLineBorder(Color.WHITE, 2);
		panel.setBorder(redBorder);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu hiện tại");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(30, 110, 150, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu mới");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(30, 165, 150, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Xác nhận mật khẩu");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(30, 220, 150, 18);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField = new JPlaceholderTextField("");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(155, 210, 183, 35);
		textField.setForeground(new Color(255, 255, 255));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(new Color(50, 185, 185));
		textField.setSelectedTextColor(Color.WHITE);
		textField.setCornerRadius(15);
		textField.setBorder(null);
		textField.setGradientColors(Color.WHITE,Color.WHITE);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPlaceholderTextField textField_1 = new JPlaceholderTextField("");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setSelectedTextColor(Color.WHITE);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBackground(new Color(50, 185, 185));
		textField_1.setCornerRadius(15);
		textField_1.setBorder(null);
		textField_1.setGradientColors(Color.WHITE,Color.WHITE);
		textField_1.setBounds(155, 155, 183, 35);
		contentPane.add(textField_1);
		
		JPlaceholderTextField textField_2 = new JPlaceholderTextField("");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBackground(new Color(50, 185, 185));
		textField_2.setSelectedTextColor(Color.WHITE);
		textField_2.setCornerRadius(15);
		textField_2.setBorder(null);
		textField_2.setGradientColors(Color.WHITE,Color.WHITE);
		textField_2.setBounds(155, 100, 183, 35);
		contentPane.add(textField_2);
		
		MyButton btnNewButton_1_1 = new MyButton("Ok");
		btnNewButton_1_1.setRadius(10);
		btnNewButton_1_1.setForeground(new Color(50, 185, 185));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setColorOver(new Color(180, 241, 241));
		btnNewButton_1_1.setColorClick(Color.WHITE);
		btnNewButton_1_1.setColor(Color.WHITE);
		btnNewButton_1_1.setBorderColor(new Color(50, 185, 185));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(30, 298, 310, 35);
		contentPane.add(btnNewButton_1_1);
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String passwordNow = textField_2.getText();
				String passwordChange = textField_1.getText();
				String passwordComfirm = textField.getText();
				
				System.out.println(passwordNow + passwordChange + passwordComfirm);
				
				controlGV.ChangePassword(gv, passwordNow, passwordChange, passwordComfirm);
			}
		});
	}
}

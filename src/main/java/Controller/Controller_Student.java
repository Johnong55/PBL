package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;

import DAO.BaiLam_dao;
import DAO.KiThi_dao;
import View.ChangePassword;
import View.GoingTest;
import View.ViewStudent;
import model.BaiLam;

public class Controller_Student implements ActionListener  {
	private ViewStudent s;

	public Controller_Student(ViewStudent s) {
		super();
		this.s = s;
	}
	public void setPanel_4() {
		s.panel_4.removeAll();
		s.panel_4.revalidate();
		s.panel_4.repaint();
	}
	public void hienthi() {
		s.bailamsv = BaiLam_dao.Instance().selectbailambysv(s.v);
		for(int i = 0 ; i< s.bailamsv.size(); i++)
			
		{
			String diem = String.format("%.3f", s.bailamsv.get(i).getDiem());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
			String ngay  = (sdf.format(s.bailamsv.get(i).getKiThi().getDate()).toString());
		s.model.addRow(new Object[] {
				s.bailamsv.get(i).getKiThi().getMota() ,
				ngay, 
				s.bailamsv.get(i).getKiThi().getThoigianlambai(),
				s.bailamsv.get(i).getSocaudung(),
				s.bailamsv.get(i).getSocausai(),
				diem
		});
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == s.BtnHome)
			
		{
			setPanel_4();
			s.view_home(); 
			
		}
		else if(e.getSource() == s.btnTests)
		{
			
			setPanel_4();
			hienthi();
			s.view_test();

		}	
			
		else if(e.getSource() == s.btnProfile) 
		{
			
			setPanel_4();
			s.view_profile();
		}
		
		else if(e.getSource() == s.mbtnBtuLm)
		{
			if(s.ktOngoing.getId() != null)
			{
			GoingTest frame = new GoingTest(s.v,s.ktOngoing);
			frame.setVisible(true);
			s.dispose();
			}

		}
		else if(e.getSource() == s.btnChangePer)
		{
			
			ChangePassword frame = new ChangePassword();
			frame.setVisible(true);
			// Trong phần tạo form mới
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


		}	
		
		s.panel_4.setBounds(171, 0, 713, 661); 
	}
}

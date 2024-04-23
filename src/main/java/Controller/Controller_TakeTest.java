package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;

import DAO.BaiLam_dao;
import View.CompleteTest;
import View.GoingTest;
import View.MyButton;
import View.RadioButtonCustom;
import View.ViewTakeTest;
import model.Cauhoi;

public class Controller_TakeTest implements ActionListener, MouseWheelListener {
	private ViewTakeTest vt;

	public Controller_TakeTest(ViewTakeTest vt) {
		super();
		this.vt = vt;
	}

	public String tendapAn(int q) {
		String k = "";
		if(q == 1) k = "A"; else if(q == 2) k = "B" ; else if(q==3) k = "C"; else if(q == 4) k = "D";
		return k;
	}
	public void checkXem(int vitri,int vitri2) {
		
		if(vt.checkView[vitri] == 0 ) {
			vt.checkView[vitri] = 1;
			vt.setMau(3, vt.listBtnCauhoi.get(vitri)); 
			vt.soCauDaXem +=1;
		}
		
		if(vt.group.getSelection() != null)
		{
			int i = 0;
			Enumeration<AbstractButton> allRadioButtons = vt.group.getElements();
			while (allRadioButtons.hasMoreElements()) {
				i++;
				RadioButtonCustom radioButton = (RadioButtonCustom) allRadioButtons.nextElement();
			    if (radioButton.isSelected()) {
			        vt.selectButton[vitri] = vt.group.getSelection();
			        vt.checkAnswer[vitri]  = tendapAn(i);
			        break;
			    }
			}
			vt.group.clearSelection();
			vt.setMau(2, vt.listBtnCauhoi.get(vitri)); 
		}
		
		if(vt.checkView[vitri2] != 0) 
		{
			vt.group.setSelected(vt.selectButton[vitri2], true);
		} 
	}
	public void setViewCauhoi(int vitricauhoi) {
		Cauhoi c = vt.listCauhoi.get(vitricauhoi);
		vt.lblNewLabel_1.setText("Câu hỏi " + vt.listBtnCauhoi.get(vitricauhoi).getText());
		vt.btnDapAn_A.setText(c.getDapAnA());
		vt.btnDapAn_B.setText(c.getDapAnB());
		vt.btnDapAn_C.setText(c.getDapAnC());
		vt.btnDapAn_D.setText(c.getDapAnD());
		vt.Cauhoi.setText(c.getNoidung());
		vt.dapan = c.getDapan();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getSource() == vt.btnNext && vt.vitriCauhoi < vt.listCauhoi.size()-1) 
		{
			vt.vitriCauhoi++;
			setViewCauhoi(vt.vitriCauhoi);
			checkXem(vt.vitriCauhoi -1 , vt.vitriCauhoi);
					
		}
		else 
		if(e.getSource() == vt.mbtnCuTrc && vt.vitriCauhoi >0) 
		{
			vt.vitriCauhoi--;
			setViewCauhoi(vt.vitriCauhoi);
			checkXem(vt.vitriCauhoi+ 1, vt.vitriCauhoi);
		} 
		else if(e.getSource() == vt.btnExit) {
			 int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc kết thúc bài làm ?", "Xác nhận kết thúc ", JOptionPane.YES_NO_OPTION);
		        
		        if (choice == JOptionPane.YES_OPTION) {
		        	BaiLam_dao.Instance().insert(vt.bailam1);
		            // Xử lý khi người dùng chọn "Yes"
		        	CompleteTest frame = new CompleteTest(vt.v,vt.ktOngoing);
					frame.setVisible(true);
		        	vt.dispose();
		        }
			
			
			
		}else 
			
		for(int i = 0 ; i < 3;i++) {
			if(e.getSource() == vt.listBtnCauhoi.get(i)) {
				setViewCauhoi(i);
				checkXem(vt.vitriCauhoi,i);
				vt.vitriCauhoi = i;
			}
		}
		
		int dem = 0;
		for(int i =  0 ; i< vt.checkAnswer.length;i++) {
			if(vt.checkAnswer[i] != "0") 
			dem++;
			vt.soCauTraLoi.setText(String.valueOf(dem) +"/" + String.valueOf(vt.checkAnswer.length)); 
			vt.btnTL.setText(String.valueOf(dem));
			vt.btnCTL.setText(String.valueOf(vt.soCauDaXem - dem));
			vt.btnCX.setText(String.valueOf(vt.listBtnCauhoi.size()- vt.soCauDaXem));
		}
	
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == vt.scrollPane) {
			JScrollBar vertical = vt.scrollPane.getVerticalScrollBar();
			vertical.setValue(vertical.getValue() + e.getUnitsToScroll() * 3);
		}
	}
}

package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JScrollBar;

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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vt.btnNext && vt.vitriCauhoi < vt.listCauhoi.size()-1) 
		{
			vt.vitriCauhoi++;
			Cauhoi c = vt.listCauhoi.get(vt.vitriCauhoi);
			vt.btnDapAn_A.setText(c.getDapAnA());
			vt.btnDapAn_B.setText(c.getDapAnB());
			vt.btnDapAn_C.setText(c.getDapAnC());
			vt.btnDapAn_D.setText(c.getDapAnD());
			vt.Cauhoi.setText(c.getNoidung());
			vt.dapan = c.getDapan();
			checkXem(vt.vitriCauhoi -1 , vt.vitriCauhoi);
					
			
		}
		else 
		if(e.getSource() == vt.mbtnCuTrc && vt.vitriCauhoi >0) 
		{
			vt.vitriCauhoi--;
			Cauhoi c = vt.listCauhoi.get(vt.vitriCauhoi);
			vt.btnDapAn_A.setText(c.getDapAnA());
			vt.btnDapAn_B.setText(c.getDapAnB());
			vt.btnDapAn_C.setText(c.getDapAnC());
			vt.btnDapAn_D.setText(c.getDapAnD());
			vt.Cauhoi.setText(c.getNoidung());
			vt.dapan = c.getDapan();
			checkXem(vt.vitriCauhoi+ 1, vt.vitriCauhoi);
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

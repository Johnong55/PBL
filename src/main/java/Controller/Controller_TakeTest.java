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

import View.RadioButtonCustom;
import View.ViewTakeTest;
import model.Cauhoi;

public class Controller_TakeTest implements ActionListener, MouseWheelListener {
	private ViewTakeTest vt;

	public Controller_TakeTest(ViewTakeTest vt) {
		super();
		this.vt = vt;
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
			if(vt.checkView[vt.vitriCauhoi-1] == 0)
			{
				vt.checkView[vt.vitriCauhoi -1] = 1;
				vt.setMau(3, vt.listBtnCauhoi.get(vt.vitriCauhoi-1)); 
			}
			if(vt.checkAnswer[vt.vitriCauhoi] != "0")
			{
				vt.group.setSelected(vt.selectButton[vt.vitriCauhoi], true);
			}
			if(vt.group.getSelection() != null)
			{
				
				Enumeration<AbstractButton> allRadioButtons = vt.group.getElements();
				while (allRadioButtons.hasMoreElements()) {
					RadioButtonCustom radioButton = (RadioButtonCustom) allRadioButtons.nextElement();
				    if (radioButton.isSelected()) {
				        vt.checkAnswer[vt.vitriCauhoi-1] = radioButton.getName();
				        vt.selectButton[vt.vitriCauhoi-1] = vt.group.getSelection();
				        break;
				    }
				}
				vt.group.clearSelection();
				vt.setMau(2, vt.listBtnCauhoi.get(vt.vitriCauhoi-1)); 
			}
			
			
		}
		
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

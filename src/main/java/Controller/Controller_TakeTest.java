package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollBar;

import View.ViewTakeTest;
import model.Cauhoi;

public class Controller_TakeTest implements ActionListener ,MouseWheelListener{
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
		if(e.getSource() == vt.scrollPane) 
		{
			JScrollBar vertical = vt.scrollPane.getVerticalScrollBar();
	        vertical.setValue(vertical.getValue() + e.getUnitsToScroll()* 3);
		}
	}
}

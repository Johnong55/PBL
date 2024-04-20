package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import View.ViewTakeTest;
import model.Cauhoi;

public class Controller_TakeTest implements ActionListener{
	private ViewTakeTest vt;
	
	public Controller_TakeTest(ViewTakeTest vt) {
		super();
		this.vt = vt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vt.btnNext) 
		{
			vt.vitriCauhoi++;
			Cauhoi c = vt.listCauhoi.get(vt.vitriCauhoi);
			vt.btnDapAn_A.setText(c.getDapAnA());
			
		}
		
	}
}

package Controller;


import javax.swing.Action;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import View.ViewTeacher;


public class Controller_Teacher implements Action {

	public ViewTeacher viewteacher;
	
	public Controller_Teacher(ViewTeacher viewteacher) {
		super();
		this.viewteacher = viewteacher;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewteacher.btnNewButton) {
			this.viewteacher.ViewHome();
		}else if(e.getSource() == viewteacher.btnNewButton1) {
			this.viewteacher.ViewClass();
		}else if(e.getSource() == viewteacher.btnNewButton2) {
			this.viewteacher.ViewExam();
		}else if(e.getSource() == viewteacher.btnNewButton3) {
			this.viewteacher.ViewProfile();
		}else if(e.getSource() == viewteacher.btnNewButton4) {
			this.viewteacher.ViewCreateNew();
		}else if(e.getSource() == viewteacher.btnNewButton5) {
			
		}
		
	}
	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
}




















package Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.Cauhoi_Dao;
import DAO.Class_dao;
import DAO.Gv_dao;
import DAO.KiThi_dao;
import DAO.NganhangDao;
import DAO.Sv_dao;
import model.Giangday;
import model.Gv;
import model.KiThi;
import model.Nganhangcauhoi;
import model.Sv;
import model.Class;

public class Controller_Admin {
	
	public Gv g;
	public List<Giangday> dslop;
	public List<Class> classes;
	public List<Sv> listSV;
	public List<Gv> listgv;
	public Sv_dao svDAO = new Sv_dao();
	public Class_dao ClassDao = new Class_dao();
	public NganhangDao nganhangDAO = new NganhangDao();
	public List<Nganhangcauhoi> NganHangCauHoi;
	public List<KiThi> kthi;
	public KiThi_dao kt = new KiThi_dao();
	public Cauhoi_Dao cauhoi = new Cauhoi_Dao();
	public Gv_dao gvDAO = new Gv_dao();
	
	
	
	public DefaultTableModel getModelClasses(JTable table) {
		classes = ClassDao.selectall();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Class c : classes) {
			listSV = ClassDao.selectSVinclass(c);
			Object[] row = {c.getTenlop(),listSV.size()};
			model.addRow(row);
		}
		return model;
	}
	public DefaultTableModel getModelTeacher(JTable table) {
		listgv = gvDAO.selectall();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Gv g : listgv) {
			Object[] row = {g.getTen()};
			model.addRow(row);
		}
		return model;
	}
	public DefaultTableModel getModelStudent(JTable table) {
		listSV = svDAO.selectall();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Sv s : listSV) {
			Object[] row = {s.getTen(),s.getIdclass().getTenlop()};
			model.addRow(row);
		}
		return model;
	}
	public DefaultTableModel getModelSVinClass(String m,JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String idLop = getIdLopbyName(m);
		System.out.println(idLop);
		listSV = svDAO.selectall();
		for (Sv s : listSV) {
			if(s.getIdclass().getIdclass().equalsIgnoreCase(idLop)) {
				 model.addRow(new Object[]{s.getTen()});
			}
		}
		return model;
	}
	public String getIdLopbyName(String m) {
		classes = ClassDao.selectall();
		for (Class c : classes) {
			if(c.getTenlop().equalsIgnoreCase(m)) {
				return c.getIdclass();
			}
		}
		return null;
	}
	public Gv getGvbyName(String m) {
		listgv = gvDAO.selectall();
		for (Gv g : listgv) {
			if(g.getTen().equalsIgnoreCase(m)){
				return g;
			}
		}
		return null;
	}
	public DefaultTableModel getModelNameClassOfGv(String m, JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Gv g = getGvbyName(m);
		System.out.println(g);
		
		dslop = g.getDanhsachlop();
		for (Giangday gd : dslop) {
			Object[] row = {gd.getMalop().getTenlop()};
			System.out.println(gd.getMalop().getTenlop());
			model.addRow(row);
		}
		return model;
	}
}





















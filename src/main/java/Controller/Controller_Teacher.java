package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.dial.DialPointer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import model.Gv;
import model.KiThi;
import model.Giangday;
import DAO.Cauhoi_Dao;
import DAO.Class_dao;
import DAO.Gv_dao;
import DAO.KiThi_dao;
import model.Sv;
import model.Cauhoi;
import model.Class;
import DAO.NganhangDao;
import model.Nganhangcauhoi;


public class Controller_Teacher {
	public Gv g;
	public  List<Giangday> dslop;
	public  List<Sv> listSV;
	public Class_dao ClassDao = new Class_dao();
	public NganhangDao nganhangDAO = new NganhangDao();
	public List<Nganhangcauhoi> NganHangCauHoi;
	public List<KiThi> kthi;
	public KiThi_dao kt = new KiThi_dao();
	public Cauhoi_Dao cauhoi = new Cauhoi_Dao();
	public Gv_dao gvDAO = new Gv_dao();
	
	public List<Giangday> getClasses(Gv g) {
		return g.getDanhsachlop();
	}
	public DefaultTableModel getModelClasses(Gv g, JTable table) {
		dslop = g.getDanhsachlop();
		System.out.println(dslop);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Giangday giangday : dslop) {
			listSV = ClassDao.selectSVinclass(giangday.getMalop());
			Object[] row = {giangday.getMalop().getTenlop(),listSV.size()};
			model.addRow(row);
		}
		return model;
	}
	public DefaultTableModel getModelExam(Gv g, JTable table) {
		kthi = kt.selectall();
		String idgv = g.getId();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (KiThi k : kthi) {
			if(idgv.equalsIgnoreCase(k.getGv().getId())) {
				Object[] row = {k.getLop().getTenlop(),k.getNganhangcauhoi().getIdNganHang(), k.getMota(),
						k.getDate(), k.getThoigianbatdau(), k.getThoigianlambai(), k.getSl()};
				model.addRow(row);
			}
		}
		return model;
	}
	public Class getClassbyNameClass(String m, Gv g) {
    	for (Giangday giangday : g.getDanhsachlop()) {
			if(m == giangday.getMalop().getTenlop()) {
				return giangday.getMalop();
			}
		}
    	return null;
	}
	public String[] getTenLop(Gv g) {
		int i = 0;
		String[] tenlop = new String[g.getDanhsachlop().size()];
		for (Giangday giangday : g.getDanhsachlop()) {
			tenlop[i] = giangday.getMalop().getTenlop();
			i++;
		}
		return tenlop;
	}
	public String[] getTenMon() {
		int i = 0;
		NganHangCauHoi = nganhangDAO.selectall();
		String[] tenmon = new String[NganHangCauHoi.size()];
		for (Nganhangcauhoi cauhoi : NganHangCauHoi) {
			tenmon[i] = cauhoi.getIdNganHang();
			i++;
		}
		return tenmon;
	}
	public Nganhangcauhoi getNganhangcauhoibyName(String name) {
		NganHangCauHoi = nganhangDAO.selectall();
		for (Nganhangcauhoi nganhangcauhoi2 : NganHangCauHoi) {
			if(name.equalsIgnoreCase(nganhangcauhoi2.getIdNganHang())) {
				return nganhangcauhoi2;
			}
		}
		return null;
	}
	public KiThi getKithibyID(String id) {
		KiThi k = kt.selectbyid(id);
		return k;
	}
	public int getIndexofArray(String[] arr,String s) {
        for (int i = 0; i < arr.length; i++) {
            if (s.equalsIgnoreCase(arr[i])) {
                return i;
            }
        }
        return -1;
	}
	public void InsertExam(KiThi k) {
		kt.insert(k);
	}
	public void UpdateExam(KiThi k) {
		kt.update(k);
	}
	public void InsertCauhoi(Cauhoi c) {
		cauhoi.insert(c);
	}
	public void ChangePassword(Gv g, String o, String n, String c) {
		System.out.println(o);
		System.out.println(g.getPassword());
		if(o.equals(g.getPassword())) {
			if(n.equals(c)) {
				g.setPassword(n);
				gvDAO.update(g);
				
			}else {
				JOptionPane.showMessageDialog(null, "Confirmation password is incorrect","Error",JOptionPane.INFORMATION_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Password is incorrect","Error",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}




















package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
import model.Giangday;
import DAO.Class_dao;
import model.Sv;
import model.Class;


public class Controller_Teacher {
	public Gv g;
	public  List<Giangday> dslop;
	public  List<Sv> listSV;
	public Class_dao ClassDao = new Class_dao();
	
	public List<Giangday> getClasses(Gv g) {
		return g.getDanhsachlop();
	}
	public DefaultTableModel getModelClasses(Gv g, JTable table) {
		dslop = g.getDanhsachlop();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Giangday giangday : dslop) {
			listSV = ClassDao.selectSVinclass(giangday.getMalop());
			Object[] row = {giangday.getMalop().getTenlop(),listSV.size()};
			model.addRow(row);
		}
		return model;
	}
	public Class getClassbyName(String m, Gv g) {
    	for (Giangday giangday : g.getDanhsachlop()) {
			if(m == giangday.getMalop().getTenlop()) {
				return giangday.getMalop();
			}
		}
    	return null;
	}
	
}




















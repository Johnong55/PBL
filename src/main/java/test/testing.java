package test;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import DAO.Account_dao;
import DAO.Cauhoi_Dao;
import DAO.Gv_dao;
import DAO.NganhangDao;
import DAO.request_dao;
import model.Account;
import model.Cauhoi;
import model.Gv;
import model.Nganhangcauhoi;
import model.request;

public class testing {
    public static void main(String[] args) {
    	Cauhoi c = new Cauhoi();
    	c = Cauhoi_Dao.Instance().selectbyidCauHoi("q23");
    	c.setDapan("Berlin");
    	Cauhoi_Dao.Instance().deletebyid(c);
    }
}
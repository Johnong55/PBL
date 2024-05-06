
package test;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DAO.Account_dao;
import DAO.BaiLam_dao;
import DAO.Cauhoi_Dao;
import DAO.Class_dao;
import DAO.DeThi_dao;
import DAO.Giangday_dao;
import DAO.Gv_dao;
import DAO.KiThi_dao;
import DAO.NganhangDao;
import DAO.Sv_dao;
import DAO.request_dao;
import DAO.truonghoc_dao;
import model.Account;
import model.BaiLam;
import model.Cauhoi;
import model.Cautraloisinhvien;
import model.Class;
import model.DeThi;
import model.Giangday;
import model.Gv;
import model.KiThi;

import model.Nganhangcauhoi;
import model.Sv;
import model.request;
import model.truonghoc;
import util.HibernateUtil;

public class Demo {
	public static void main(String[] args) {

		Account_dao ac_dao = new Account_dao();
		Gv_dao gv = new Gv_dao();
		Sv_dao sv = new Sv_dao();
		truonghoc_dao tr = new truonghoc_dao();
		Class_dao cl = new Class_dao();
		Giangday_dao gd = new Giangday_dao();
		NganhangDao nhdao = new NganhangDao();
		KiThi_dao kt = new KiThi_dao();
		DeThi_dao dt = new DeThi_dao();
		Cauhoi_Dao CHdao = new Cauhoi_Dao();
		truonghoc truong1 = new truonghoc();
		truong1.setId("01");
		truong1.setTentruong("THPT HOA VANG");
	 	tr.insert(truong1);
		Class cl1 = new Class();
		cl1.setIdclass("01");
		cl1.setTenlop("10A");
		cl1.setTruong(truong1);
		Class cl2 = new Class();
		cl2.setIdclass("02");
		cl2.setTenlop("10B");
		cl2.setTruong(truong1);
		Class cl3 = new Class();
		cl3.setIdclass("03");
		cl3.setTenlop("10C");
		cl3.setTruong(truong1);
		
		   cl.insert(cl3); cl.insert(cl2); cl.insert(cl1);
		 
		List<Class> a = new ArrayList<Class>();
		a.add(cl1);
		a.add(cl2);
		a.add(cl3);
		Gv gv1 = new Gv();
		gv1.setId("01");
		gv1.setTen("ONG VAN QUANG TRI");
		gv1.setTruong(truong1);
		gv1.setMaquyen(1);
		gv1.setUsername(gv1.getId());
		gv1.setPassword("1");
		gv1.addclass(cl1);
		gv1.addclass(cl3);
		Gv gv2 = new Gv();
		gv2.setId("02");
		gv2.setTen("ONG ");
		gv2.setTruong(truong1);
		gv2.setMaquyen(1);
		gv2.setUsername(gv2.getId());
		gv2.setPassword("123456");
		gv2.addclass(cl1);
		gv2.addclass(cl2);
		
		   gv.insert(gv2); gv.insert(gv1);
		
		Sv sv1 = new Sv();
		sv1.setId("102220088");
		sv1.setUsername(sv1.getId());
		sv1.setPassword(sv1.getId());
		sv1.setMaquyen(2);
		sv1.setTen("Ong Van Quang Tri");
		Sv sv2 = new Sv();
		sv2.setId("102220089");
		sv2.setUsername(sv2.getId());
		sv2.setPassword(sv2.getId());
		sv2.setMaquyen(2);
		sv2.setTen("Nguyen Thanh Vinh");
		Sv sv3 = new Sv();
		sv3.setId("102220090");
		sv3.setUsername(sv3.getId());
		sv3.setPassword(sv3.getId());
		sv3.setMaquyen(2);
		sv3.setTen("Tran Dang Minh Duc");
		Sv sv4 = new Sv();
		sv4.setId("102220091");
		sv4.setUsername(sv4.getId());
		sv4.setPassword(sv4.getId());
		sv4.setMaquyen(2);
		sv4.setTen("Le Khiet Dan");

		Sv sv5 = new Sv();
		sv5.setId("102220092");
		sv5.setUsername(sv5.getId());
		sv5.setPassword(sv5.getId());
		sv5.setMaquyen(2);
		sv5.setTen("Nguyen Quang Truong");
		sv4.setIdclass(cl3);
		sv2.setIdclass(cl2);
		sv1.setIdclass(cl1);
		sv3.setIdclass(cl2);
		sv5.setIdclass(cl3);
 		sv.insert(sv5);
 		sv.insert(sv4);
 		sv.insert(sv3);
 		sv.insert(sv2);
 		sv.insert(sv1);
		KiThi kithi = new KiThi();
		kithi.setId("02");
		kithi.setLop(cl2);
		kithi.setGv(gv1);
		kithi.setThoigianbatdau(new Time(9, 30, 0));
		kithi.setThoigianlambai(45);
		kithi.setDate(new Date(2024 - 1900, 04, 20));
		kithi.setMota("Van");
		kithi.setSl(12);
		kithi.setSocauDe(3);
		kithi.setSocaukho(3);
		kithi.setSocautb(12-3-3);
		KiThi kithi1 = new KiThi();
		kithi1.setId("03");
		kithi1.setLop(cl2);
		kithi1.setGv(gv2);
		kithi1.setThoigianlambai(45);
		kithi1.setThoigianbatdau(new Time(17, 30, 0));
		kithi1.setDate(new Date(2024 - 1900, 8, 20));
		kithi1.setMota("Dia");
		kithi1.setSl(12);
		kithi1.setSocauDe(3);
		kithi1.setSocaukho(3);
		kithi1.setSocautb(12-3-3);	
		KiThi kithi2 = new KiThi();
		kithi2.setId("04");
		kithi2.setLop(cl2);
		kithi2.setGv(gv2);
		kithi2.setThoigianbatdau(new Time(8, 0, 0));
		kithi2.setThoigianlambai(45);
		kithi2.setDate(new Date(2024 - 1900, 6, 20));
		kithi2.setMota("SU");
		kithi2.setSl(12);
		kithi2.setSocauDe(3);
		kithi2.setSocaukho(3);
		kithi2.setSocautb(4);
	
		Nganhangcauhoi nh = new Nganhangcauhoi();
		nh.setIdNganHang("Li");
		nh.setGiaovienquanli(gv2);
		Nganhangcauhoi nh1 = new Nganhangcauhoi();
		nh1.setIdNganHang("su");
		nh1.setGiaovienquanli(gv1);
 		nhdao.insert(nh1);
 		nhdao.insert(nh);
 		Cauhoi q1 = new Cauhoi("q1", "What is the capital of France?", "Paris", "London", "Berlin", "Madrid", 1, "Paris", nh);
 		Cauhoi q2 = new Cauhoi("q2", "Who wrote 'Romeo and Juliet'?", "William Shakespeare", "Jane Austen", "Charles Dickens", "Mark Twain", 1, "William Shakespeare", nh);
 		Cauhoi q3 = new Cauhoi("q3", "What is the tallest mountain in the world?", "Mount Everest", "K2", "Kangchenjunga", "Lhotse", 3, "Mount Everest", nh);
 		Cauhoi q4 = new Cauhoi("q4", "What is the chemical symbol for water?", "H2O", "CO2", "NaCl", "O2", 1, "H2O", nh);
 		Cauhoi q5 = new Cauhoi("q5", "Who painted the Mona Lisa?", "Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo", 1, "Leonardo da Vinci", nh);
 		Cauhoi q6 = new Cauhoi("q6", "Which planet is known as the Red Planet?", "Mars", "Venus", "Jupiter", "Saturn", 1, "Mars", nh);
 		Cauhoi q7 = new Cauhoi("q7", "What is the currency of Japan?", "Yen", "Dollar", "Euro", "Pound", 2, "Yen", nh);
 		Cauhoi q8 = new Cauhoi("q8", "Who is the author of 'To Kill a Mockingbird'?", "Harper Lee", "J.K. Rowling", "Stephen King", "George Orwell", 1, "Harper Lee", nh);
 		Cauhoi q9 = new Cauhoi("q9", "What is the largest ocean on Earth?", "Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean", 2, "Pacific Ocean", nh);
 		Cauhoi q10 = new Cauhoi("q10", "What is the chemical symbol for gold?", "Au", "Ag", "Cu", "Fe", 1, "Au", nh);
 		Cauhoi q11 = new Cauhoi("q11", "Who painted 'The Starry Night'?", "Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet", 1, "Vincent van Gogh", nh);
 		Cauhoi q12 = new Cauhoi("q12", "Which country is known as the Land of the Rising Sun?", "Japan", "China", "Korea", "Vietnam", 2, "Japan", nh);
 		Cauhoi q13 = new Cauhoi("q13", "What is the boiling point of water in Celsius?", "100°C", "0°C", "-100°C", "50°C", 1, "100°C", nh);
 		Cauhoi q14 = new Cauhoi("q14", "Who was the first person to step on the Moon?", "Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin", "John Glenn", 1, "Neil Armstrong", nh);
 		Cauhoi q15 = new Cauhoi("q15", "What is the chemical symbol for oxygen?", "O2", "H2O", "CO2", "N2", 1, "O2", nh);
 		Cauhoi q16 = new Cauhoi("q16", "Who wrote 'The Great Gatsby'?", "F. Scott Fitzgerald", "Ernest Hemingway", "John Steinbeck", "Virginia Woolf", 1, "F. Scott Fitzgerald", nh);
 		Cauhoi q17 = new Cauhoi("q17", "What is the capital of Italy?", "Rome", "Paris", "Berlin", "Madrid", 1, "Rome", nh);
 		Cauhoi q18 = new Cauhoi("q18", "What is the largest mammal in the world?", "Blue Whale", "Elephant", "Giraffe", "Hippopotamus", 3, "Blue Whale", nh);
 		Cauhoi q19 = new Cauhoi("q19", "Who painted 'The Last Supper'?", "Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo", 1, "Leonardo da Vinci", nh);
 		Cauhoi q20 = new Cauhoi("q20", "Which planet is known as the 'Morning Star' or 'Evening Star'?", "Venus", "Mars", "Mercury", "Jupiter", 2, "Venus", nh);


 		CHdao.insert(q10);
 		CHdao.insert(q1);
 		CHdao.insert(q2);
 		CHdao.insert(q3);
 		CHdao.insert(q4);
 		CHdao.insert(q5);
 		CHdao.insert(q6);
 		CHdao.insert(q7);
 		CHdao.insert(q8);
 		CHdao.insert(q9);
 		CHdao.insert(q20);
 		CHdao.insert(q11);
 		CHdao.insert(q12);
 		CHdao.insert(q13);
 		CHdao.insert(q14);
 		CHdao.insert(q15);
 		CHdao.insert(q16);
 		CHdao.insert(q17);
 		CHdao.insert(q18);
 		CHdao.insert(q19);
		kithi.setNganhangcauhoi(nh1);
		kithi1.setNganhangcauhoi(nh1);
		kithi2.setNganhangcauhoi(nh);
 		kt.insert(kithi2);
 		kt.insert(kithi1);
 		kt.insert(kithi);
 		request request = new request();
 		request.setAccount(gv1);
 		request.setTime(new Date(2024+1900,5,6));
 		request.setId();
 		
 		request request1 = new request();
 		request1.setAccount(sv5);
 		request1.setTime(new Date(2024+1900,10,10));
 		request1.setId();
		 request_dao.Instance().insert(request);
		 request_dao.Instance().insert(request1);
	}	
}


package test;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
 		Class cl4 = new Class();
 		cl4.setIdclass("04");
 		cl4.setTenlop("10D");
 		cl4.setTruong(truong1);

 		Class cl5 = new Class();
 		cl5.setIdclass("05");
 		cl5.setTenlop("11A");
 		cl5.setTruong(truong1);

 		Class cl6 = new Class();
 		cl6.setIdclass("06");
 		cl6.setTenlop("11B");
 		cl6.setTruong(truong1);

 		Class cl7 = new Class();
 		cl7.setIdclass("07");
 		cl7.setTenlop("11C");
 		cl7.setTruong(truong1);

 		Class cl8 = new Class();
 		cl8.setIdclass("08");
 		cl8.setTenlop("11D");
 		cl8.setTruong(truong1);

 		Class cl9 = new Class();
 		cl9.setIdclass("09");
 		cl9.setTenlop("12A");
 		cl9.setTruong(truong1);

 		Class cl10 = new Class();
 		cl10.setIdclass("10");
 		cl10.setTenlop("12B");
 		cl10.setTruong(truong1);
 		//// insert class;
 	cl.insert(cl3); cl.insert(cl2); cl.insert(cl1);cl.insert(cl10);cl.insert(cl4); cl.insert(cl5); cl.insert(cl6);cl.insert(cl9); cl.insert(cl8); cl.insert(cl7);
 		 
 		List<Class> a = new ArrayList<Class>();
 		a.add(cl1);
 		a.add(cl2);
 		a.add(cl3);
 		a.add(cl4);
 		a.add(cl5);
 		a.add(cl6);
 		a.add(cl7);
 		a.add(cl8);
 		a.add(cl9);
 		a.add(cl10);
 	
 	// Tạo 10 giáo viên
 		Gv gv1 = new Gv();
 		gv1.setId("01");
 		gv1.setTen("ONG VAN QUANG TRI");
 		gv1.setTruong(truong1);
 		gv1.setMaquyen(1);
 		gv1.setLinkAnh("/View/image/userProfile.png");
 		gv1.setUsername(gv1.getId());
 		gv1.setPassword("1");
 		gv1.addclass(cl1);
 		gv1.addclass(cl3);
 		gv1.addclass(cl4);
 		Gv gv2 = new Gv();
 		gv2.setId("02");
 		gv2.setTen("ONG ");
 		gv2.setTruong(truong1);
 		gv2.setMaquyen(1);
 		gv2.setUsername(gv2.getId());
 		gv2.setLinkAnh("/View/image/userProfile.png");
 		gv2.setPassword("123456");
 		gv2.addclass(cl1);
 		gv2.addclass(cl2);
 		gv2.addclass(cl5);
 		Gv gv3 = new Gv();
 		gv3.setId("03");
 		gv3.setTen("NGUYEN VAN A");
 		gv3.setTruong(truong1);
 		gv3.setMaquyen(1);
 		gv3.setUsername(gv3.getId());
 		gv3.setLinkAnh("/View/image/userProfile.png");
 		gv3.setPassword("password123");
 		gv3.addclass(cl2);
 		gv3.addclass(cl3);
 		gv3.addclass(cl10);
 		Gv gv4 = new Gv();
 		gv4.setId("04");
 		gv4.setTen("NGUYEN THI B");
 		gv4.setTruong(truong1);
 		gv4.setMaquyen(1);
 		gv4.setUsername(gv4.getId());
 		gv4.setLinkAnh("/View/image/userProfile.png");
 		gv4.setPassword("pass123");
 		gv4.addclass(cl1);
 		gv4.addclass(cl3);
 		gv4.addclass(cl10);
 		Gv gv5 = new Gv();
 		gv5.setId("05");
 		gv5.setTen("TRAN VAN C");
 		gv5.setTruong(truong1);
 		gv5.setMaquyen(1);
 		gv5.setUsername(gv5.getId());
 		gv5.setLinkAnh("/View/image/userProfile.png");
 		gv5.setPassword("123456");
 		gv5.addclass(cl1);
 		gv5.addclass(cl8);
 		Gv gv6 = new Gv();
 		gv6.setId("06");
 		gv6.setTen("PHAM THI D");
 		gv6.setTruong(truong1);
 		gv6.setMaquyen(1);
 		gv6.setUsername(gv6.getId());
 		gv6.setLinkAnh("/View/image/userProfile.png");
 		gv6.setPassword("abc123");
 		gv6.addclass(cl2);
 		gv6.addclass(cl6);
 		Gv gv7 = new Gv();
 		gv7.setId("07");
 		gv7.setTen("HOANG VAN E");
 		gv7.setTruong(truong1);
 		gv7.setMaquyen(1);
 		gv7.setUsername(gv7.getId());
 		gv7.setLinkAnh("/View/image/userProfile.png");
 		gv7.setPassword("password");
 		gv7.addclass(cl3);
 		gv7.addclass(cl6);
 		Gv gv8 = new Gv();
 		gv8.setId("08");
 		gv8.setTen("NGUYEN THI F");
 		gv8.setTruong(truong1);
 		gv8.setMaquyen(1);
 		gv8.setUsername(gv8.getId());
 		gv8.setLinkAnh("/View/image/userProfile.png");
 		gv8.setPassword("teacher123");
 		gv8.addclass(cl1);
 		gv8.addclass(cl8);
 		Gv gv9 = new Gv();
 		gv9.setId("09");
 		gv9.setTen("LE VAN G");
 		gv9.setTruong(truong1);
 		gv9.setMaquyen(1);
 		gv9.setUsername(gv9.getId());
 		gv9.setLinkAnh("/View/image/userProfile.png");
 		gv9.setPassword("123456789");
 		gv9.addclass(cl2);
 		gv9.addclass(cl7);
 		Gv gv10 = new Gv();
 		gv10.setId("10");
 		gv10.setTen("TRAN THI H");
 		gv10.setTruong(truong1);
 		gv10.setMaquyen(1);
 		gv10.setUsername(gv10.getId());
 		gv10.setLinkAnh("/View/image/userProfile.png");
 		gv10.setPassword("teacherpass");
 		gv10.addclass(cl3);
 		gv10.addclass(cl5);
 		   gv.insert(gv2); gv.insert(gv1);   gv.insert(gv5); gv.insert(gv4);   gv.insert(gv7); gv.insert(gv6);   gv.insert(gv9); gv.insert(gv8);gv.insert(gv10);
 		
 		Sv sv1 = new Sv();
 		sv1.setId("102220088");
 		sv1.setUsername(sv1.getId());
 		sv1.setPassword(sv1.getId());
 		sv1.setMaquyen(2);
 		sv1.setLinkAnh("/View/image/userProfile.png");
 		sv1.setTen("Ong Van Quang Tri");
 		Sv sv2 = new Sv();
 		sv2.setId("102220089");
 		sv2.setUsername(sv2.getId());
 		sv2.setPassword(sv2.getId()); 	
 		sv2.setLinkAnh("/View/image/userProfile.png");
 		sv2.setMaquyen(2);
 		sv2.setTen("Nguyen Thanh Vinh");
 		Sv sv4 = new Sv();
 		sv4.setId("102220091");
 		sv4.setUsername(sv4.getId());
 		sv4.setPassword(sv4.getId());
 		sv4.setLinkAnh("/View/image/userProfile.png");
 		sv4.setMaquyen(2);
 		sv4.setTen("Le Khiet Dan");
 
 		Sv sv5 = new Sv();
 		sv5.setId("102220092");
 		sv5.setUsername(sv5.getId());
 		sv5.setPassword(sv5.getId());
 		sv5.setLinkAnh("/View/image/userProfile.png");
 		sv5.setMaquyen(2);
 		sv5.setTen("Nguyen Quang Truong");
 		sv4.setIdclass(cl3);
 		sv2.setIdclass(cl2);
 		sv1.setIdclass(cl1);
 		sv5.setIdclass(cl3);
  		sv.insert(sv5);
  		sv.insert(sv4);
  	
  		sv.insert(sv2);
  		sv.insert(sv1);
 		KiThi kithi = new KiThi();
 		kithi.setId("02");
 		kithi.setLop(cl2);
 		kithi.setGv(gv1);
 		kithi.setThoigianbatdau(new Time(9, 30, 0));
 		kithi.setThoigianlambai(45);
 		Date currentDate = new Date(System.currentTimeMillis());
 		kithi.setDate(currentDate);
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
<<<<<<< HEAD

=======
  		
  		nh.addcauhoi(q1);
  		nh.addcauhoi(q2);
  		nh.addcauhoi(q3);
  		nh.addcauhoi(q4);
  		nh.addcauhoi(q5);
  		nh.addcauhoi(q6);
  		nh.addcauhoi(q7);
  		nh.addcauhoi(q8);
  		nh.addcauhoi(q9);
  		nh.addcauhoi(q10);
  		nh.addcauhoi(q11);
  		nh.addcauhoi(q12);
  		nh.addcauhoi(q13);
  		nh.addcauhoi(q14);
  		nh.addcauhoi(q15);
  		nh.addcauhoi(q16);
  		nh.addcauhoi(q17);
  		nh.addcauhoi(q18);
  		nh.addcauhoi(q19);
  		nh.addcauhoi(q20);
>>>>>>> branch 'master' of https://github.com/Johnong55/PBL.git
  		
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
  		
  		Cauhoi q21 = new Cauhoi("q21", "What is the capital of Japan?", "Kyoto", "Tokyo", "Osaka", "Seoul", 2, "Tokyo", nh1);
  		Cauhoi q22 = new Cauhoi("q22", "Who wrote 'Hamlet'?", "Jane Austen", "William Shakespeare", "Charles Dickens", "Mark Twain", 2, "William Shakespeare", nh1);
  		Cauhoi q23 = new Cauhoi("q23", "What is the deepest ocean in the world?", "Atlantic Ocean", "Pacific Ocean", "Indian Ocean", "Arctic Ocean", 3, "Pacific Ocean", nh1);
  		Cauhoi q24 = new Cauhoi("q24", "What is the chemical symbol for sodium?", "So", "Na", "Sd", "Nm", 2, "Na", nh1);
  		Cauhoi q25 = new Cauhoi("q25", "Who painted 'The Persistence of Memory'?", "Pablo Picasso", "Salvador Dalí", "Vincent van Gogh", "Leonardo da Vinci", 2, "Salvador Dalí", nh1);
  		Cauhoi q26 = new Cauhoi("q26", "Which planet is known as the 'Blue Planet'?", "Mars", "Earth", "Jupiter", "Saturn", 2, "Earth", nh1);
  		Cauhoi q27 = new Cauhoi("q27", "What is the currency of the United Kingdom?", "Euro", "Pound Sterling", "Dollar", "Yen", 2, "Pound Sterling", nh1);
  		Cauhoi q28 = new Cauhoi("q28", "Who wrote '1984'?", "J.K. Rowling", "George Orwell", "Stephen King", "Harper Lee", 2, "George Orwell", nh1);
  		Cauhoi q29 = new Cauhoi("q29", "What is the largest desert in the world?", "Arabian Desert", "Sahara Desert", "Gobi Desert", "Kalahari Desert", 2, "Sahara Desert", nh1);
  		Cauhoi q30 = new Cauhoi("q30", "What is the chemical symbol for silver?", "Au", "Ag", "Cu", "Fe", 2, "Ag", nh1);
  		Cauhoi q31 = new Cauhoi("q31", "Who painted 'Guernica'?", "Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Michelangelo", 2, "Pablo Picasso", nh1);
  		Cauhoi q32 = new Cauhoi("q32", "Which country is known as the 'Emerald Isle'?", "Scotland", "Ireland", "Wales", "England", 2, "Ireland", nh1);
  		Cauhoi q33 = new Cauhoi("q33", "What is the freezing point of water in Celsius?", "-100°C", "0°C", "100°C", "50°C", 2, "0°C", nh1);
  		Cauhoi q34 = new Cauhoi("q34", "Who was the first woman to win a Nobel Prize?", "Mother Teresa", "Marie Curie", "Rosalind Franklin", "Malala Yousafzai", 2, "Marie Curie", nh1);
  		Cauhoi q35 = new Cauhoi("q35", "What is the chemical symbol for carbon dioxide?", "H2O", "CO2", "O2", "N2", 2, "CO2", nh1);
  		Cauhoi q36 = new Cauhoi("q36", "Who wrote 'Pride and Prejudice'?", "F. Scott Fitzgerald", "Jane Austen", "Ernest Hemingway", "George Orwell", 2, "Jane Austen", nh1);
  		Cauhoi q37 = new Cauhoi("q37", "What is the capital of Australia?", "Sydney", "Canberra", "Melbourne", "Brisbane", 2, "Canberra", nh1);
  		Cauhoi q38 = new Cauhoi("q38", "What is the fastest land animal?", "Lion", "Cheetah", "Gazelle", "Leopard", 2, "Cheetah", nh1);
  		Cauhoi q39 = new Cauhoi("q39", "Who painted 'The Scream'?", "Pablo Picasso", "Edvard Munch", "Vincent van Gogh", "Claude Monet", 2, "Edvard Munch", nh1);
  		Cauhoi q40 = new Cauhoi("q40", "Which planet is known as the 'Red Planet'?", "Venus", "Mars", "Mercury", "Jupiter", 2, "Mars", nh1);
<<<<<<< HEAD
  		Cauhoi q41 = new Cauhoi("q41", "What is the capital of Italy?", "Rome", "Milan", "Naples", "Florence", 1, "Rome", nh1);
  		Cauhoi q42 = new Cauhoi("q42", "Who wrote 'The Catcher in the Rye'?", "J.D. Salinger", "F. Scott Fitzgerald", "Ernest Hemingway", "Harper Lee", 1, "J.D. Salinger", nh1);
  		Cauhoi q43 = new Cauhoi("q43", "What is the chemical symbol for potassium?", "Pt", "P", "K", "Po", 1, "K", nh1);
  		Cauhoi q44 = new Cauhoi("q44", "Who painted 'Starry Night'?", "Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet", 1, "Vincent van Gogh", nh1);
  		Cauhoi q45 = new Cauhoi("q45", "Which planet is known as the 'Red Planet'?", "Mars", "Venus", "Mercury", "Jupiter", 1, "Mars", nh1);
  		Cauhoi q46 = new Cauhoi("q46", "What is the currency of Switzerland?", "Pound", "Dollar", "Euro", "Swiss Franc", 1, "Swiss Franc", nh1);
  		Cauhoi q47 = new Cauhoi("q47", "Who wrote 'Alice's Adventures in Wonderland'?", "J.K. Rowling", "Lewis Carroll", "Roald Dahl", "C.S. Lewis", 1, "Lewis Carroll", nh1);
  		Cauhoi q48 = new Cauhoi("q48", "What is the largest island in the world?", "Greenland", "Australia", "Madagascar", "Borneo", 1, "Greenland", nh1);
  		Cauhoi q49 = new Cauhoi("q49", "What is the chemical symbol for gold?", "Ag", "Au", "Cu", "Fe", 1, "Au", nh1);
  		Cauhoi q50 = new Cauhoi("q50", "Who painted 'The Mona Lisa'?", "Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo", 1, "Leonardo da Vinci", nh1);
  		nh1.addcauhoi(q50);
  		nh1.addcauhoi(q21);
  		nh1.addcauhoi(q22);
  		nh1.addcauhoi(q23);
  		nh1.addcauhoi(q24);
  		nh1.addcauhoi(q25);
  		nh1.addcauhoi(q26);
  		nh1.addcauhoi(q27);
  		nh1.addcauhoi(q28);
  		nh1.addcauhoi(q29);
  		nh1.addcauhoi(q30);
  		nh1.addcauhoi(q31);
  		nh1.addcauhoi(q32);
  		nh1.addcauhoi(q33);
  		nh1.addcauhoi(q34);
  		nh1.addcauhoi(q35);
  		nh1.addcauhoi(q36);
  		nh1.addcauhoi(q37);
  		nh1.addcauhoi(q38);
  		nh1.addcauhoi(q39);
  		nh1.addcauhoi(q40);
  		nh1.addcauhoi(q41);
  		nh1.addcauhoi(q42);
  		nh1.addcauhoi(q43);
  		nh1.addcauhoi(q44);
  		nh1.addcauhoi(q45);
  		nh1.addcauhoi(q46);
  		nh1.addcauhoi(q47);
  		nh1.addcauhoi(q48);
  		nh1.addcauhoi(q49);
  		nhdao.update(nh1);
=======
  		nh1.addcauhoi(q21);
  		nh1.addcauhoi(q22);
  		nh1.addcauhoi(q23);
  		nh1.addcauhoi(q24);
  		nh1.addcauhoi(q25);
  		nh1.addcauhoi(q26);
  		nh1.addcauhoi(q27);
  		nh1.addcauhoi(q28);
  		nh1.addcauhoi(q29);
  		nh1.addcauhoi(q30);
  		nh1.addcauhoi(q31);
  		nh1.addcauhoi(q32);
  		nh1.addcauhoi(q33);
  		nh1.addcauhoi(q34);
  		nh1.addcauhoi(q35);
  		nh1.addcauhoi(q36);
  		nh1.addcauhoi(q37);
  		nh1.addcauhoi(q38);
  		nh1.addcauhoi(q39);
  		nh1.addcauhoi(q40);
  		
  		CHdao.insert(q21);
  		CHdao.insert(q22);
  		CHdao.insert(q23);
  		CHdao.insert(q24);
  		CHdao.insert(q25);
  		CHdao.insert(q26);
  		CHdao.insert(q27);	
  		CHdao.insert(q28);
  		CHdao.insert(q29);
  		CHdao.insert(q30);
  		CHdao.insert(q31);
  		CHdao.insert(q32);
  		CHdao.insert(q33);
  		CHdao.insert(q34);
  		CHdao.insert(q35);
  		CHdao.insert(q36);
  		CHdao.insert(q37);
  		CHdao.insert(q38);
  		CHdao.insert(q39);
  		CHdao.insert(q40);
  		
  		nhdao.update(nh1);
  		nhdao.update(nh);
>>>>>>> branch 'master' of https://github.com/Johnong55/PBL.git
  		List<Sv> svList = new ArrayList<>();
///////////////////////////////////////
  		String[] specialNames = {
  		    "Tran Dang Minh Duc", "Nguyen Thi Anh", "Le Van Tuan", "Pham Minh Ngoc",
  		    "Hoang Thi Mai", "Vo Van Hieu", "Truong Thi Lan", "Do Quang Huy",
  		    "Ngo Thi Thu", "Dinh Ngoc Anh", "Vu Thi Kim", "Bui Van Nam",
  		    "Hoang Thi Thao", "Nguyen Van Long", "Tran Thi Huyen", "Phan Van Cuong",
  		    "Le Thi Thu", "Vu Van Thanh", "Nguyen Van Hieu", "Tran Thi Thanh",
  		    "Hoang Van Hung", "Truong Thi Thuy", "Pham Van Tai", "Bui Thi Linh",
  		    "Le Van Hoa", "Nguyen Thi Huong", "Vu Thi Thanh", "Do Van Son",
  		    "Ngo Thi Mai", "Tran Van Dat", "Hoang Van Khanh", "Nguyen Van Anh",
  		    "Le Thi Thao", "Phan Van Son", "Bui Van Hieu", "Nguyen Thi My",
  		    "Hoang Van Duc", "Tran Thi Mai", "Do Van Hien", "Pham Thi Hoa"
  		};

  		for (int i = 0; i < 40; i++) {
  		    Sv sinhvien = new Sv();
  		    String id = ""+(102220094+i);
  		  sinhvien.setId(id);
  		sinhvien.setUsername(id);
  		sinhvien.setPassword(id);
  		sinhvien.setLinkAnh("/View/image/userProfile.png");
  		sinhvien.setMaquyen(2);
  		sinhvien.setTen(specialNames[i]);
  		sinhvien.setIdclass(cl2);
  		    sv.insert(sinhvien);
  		}
  		String[] moreNames = {
  			    "Vo Van Trung", "Nguyen Thi Huong", "Le Van An", "Tran Thi Kim",
  			    "Pham Van Phuc", "Hoang Thi Nga", "Dinh Van Cuong", "Bui Thi Thuy",
  			    "Nguyen Van Binh", "Tran Thi Hong", "Le Van Duc", "Pham Thi Thu",
  			    "Vu Van Phuong", "Nguyen Van Hieu", "Tran Thi Ha", "Hoang Van Tuan",
  			    "Do Thi Thu", "Ngo Van Thanh", "Bui Thi Mai", "Nguyen Van Quan",
  			    "Le Thi Ngoc", "Tran Van Hien", "Hoang Thi Lan", "Phan Van An",
  			    "Vo Thi Hien", "Nguyen Van Cuong", "Le Thi Mai", "Tran Van Quang",
  			    "Hoang Van Anh", "Pham Thi Lan", "Do Van Thanh", "Bui Van Quyen",
  			    "Nguyen Thi Thuy", "Tran Van Luong", "Hoang Thi My", "Vu Van Hieu",
  			    "Nguyen Van Nam", "Le Thi Hoa", "Tran Van Phuong", "Do Thi Hien"
  			};
  		for (int i = 0; i < 40; i++) {
  		    Sv sinhvien = new Sv();
  		    String id = ""+(102220094+40+i);
  		  sinhvien.setId(id);
  		sinhvien.setUsername(id);
  		sinhvien.setPassword(id);
  		sinhvien.setLinkAnh("/View/image/userProfile.png");
  		sinhvien.setMaquyen(2);
  		sinhvien.setTen(moreNames[i]);
  		sinhvien.setIdclass(cl1);
  		    sv.insert(sinhvien);
  		}
  		String[] additionalNames = {
  			    "Nguyen Van Khanh", "Tran Thi Lan", "Le Van Hieu", "Pham Van Huy",
  			    "Hoang Thi An", "Vo Thi Ngoc", "Truong Van Long", "Do Thi My",
  			    "Ngo Van Hieu", "Dinh Thi Hien", "Vu Van Anh", "Bui Van Long",
  			    "Hoang Thi Thanh", "Nguyen Van Thanh", "Tran Thi Ngoc", "Phan Van Khanh",
  			    "Le Thi Thuy", "Vu Van Khanh", "Nguyen Van Phuoc", "Tran Thi Dieu",
  			    "Hoang Van Huy", "Truong Thi Cam", "Pham Van Hoa", "Bui Thi Phuong",
  			    "Le Van Quan", "Nguyen Thi Thao", "Vu Van Phuc", "Do Thi Cam",
  			    "Ngo Van Khanh", "Tran Thi Huong", "Hoang Van Tien", "Nguyen Thi Cam",
  			    "Le Van Tai", "Phan Van Cuong", "Bui Thi Kim", "Nguyen Van Phuc",
  			    "Hoang Thi Hong", "Tran Van Dung", "Do Thi Phuong", "Pham Van Thanh"
  			};
  		
  		for (int i = 0; i < 40; i++) {
  		    Sv sinhvien = new Sv();
  		    String id = ""+(102220094+80+i);
  		  sinhvien.setId(id);
  		sinhvien.setUsername(id);
  		sinhvien.setPassword(id);
  		sinhvien.setLinkAnh("/View/image/userProfile.png");
  		sinhvien.setMaquyen(2);
  		sinhvien.setTen(additionalNames[i]);
  		sinhvien.setIdclass(cl3);
  		    sv.insert(sinhvien);
  		}
  		String[] names1 = {
  			    "Nguyễn Văn A", "Trần Thị B", "Lê Văn C", "Phạm Thị D", "Hoàng Văn E",
  			    "Võ Thị F", "Nguyễn Văn G", "Đặng Thị H", "Bùi Văn I", "Ngô Thị K",
  			    "Lý Văn L", "Đỗ Thị M", "Trần Văn N", "Nguyễn Thị O", "Hoàng Văn P",
  			    "Trương Thị Q", "Vũ Văn R", "Lê Thị S", "Phan Văn T", "Bùi Thị U",
  			    "Hoàng Văn V", "Nguyễn Thị X", "Lê Văn Y", "Võ Thị Z", "Trần Văn An",
  			    "Phạm Thị Bảo", "Nguyễn Văn Công", "Lê Thị Dung", "Vũ Văn Dương",
  			    "Trần Thị Hà", "Lê Văn Hiếu", "Nguyễn Thị Hồng", "Ngô Văn Huy", "Vũ Thị Lan",
  			    "Hoàng Văn Long", "Phan Thị Mai", "Trần Văn Nam", "Phạm Thị Ngọc", "Vũ Văn Phong"
  			};
  		for (int i = 0; i < 39; i++) {
  		    Sv sinhvien = new Sv();
  		    String id = ""+(102220094+120+i);
  		  sinhvien.setId(id);
  		sinhvien.setUsername(id);
  		sinhvien.setPassword(id);
  		sinhvien.setLinkAnh("/View/image/userProfile.png");
  		sinhvien.setMaquyen(2);
  		sinhvien.setTen(names1[i]);
  		sinhvien.setIdclass(cl4);
  		    sv.insert(sinhvien);
  		}


  			String[] names2 = {
  			    "Nguyễn Thị An", "Trần Văn Bình", "Lê Thị Cẩm", "Phạm Văn Đạt", "Nguyễn Thị Dung",
  			    "Võ Văn Dũng", "Nguyễn Thị Giao", "Hoàng Văn Hải", "Nguyễn Thị Kiều", "Trần Văn Lâm",
  			    "Lê Thị Lan", "Phạm Văn Luân", "Nguyễn Thị Mai", "Trần Văn Minh", "Lê Thị Nga",
  			    "Võ Văn Nhân", "Nguyễn Thị Oanh", "Trần Văn Phúc", "Nguyễn Thị Quế", "Lê Văn Quân",
  			    "Phạm Thị Quỳnh", "Nguyễn Văn Sơn", "Trần Thị Tâm", "Nguyễn Văn Thành", "Lê Thị Thảo",
  			    "Võ Văn Tiến", "Nguyễn Thị Trang", "Trần Văn Tuấn", "Nguyễn Thị Uyên", "Trần Văn Việt",
  			    "Hoàng Văn Vượng", "Phạm Thị Yến", "Nguyễn Văn Đại", "Lê Thị Hương", "Võ Văn Phú",
  			    "Nguyễn Thị Thanh", "Trần Văn Đức", "Lê Thị Thủy", "Võ Văn Tú", "Nguyễn Thị Ngọc"
  			};
  			for (int i = 0; i < 40; i++) {
  	  		    Sv sinhvien = new Sv();
  	  		    String id = ""+(102220094+160+i);
  	  		  sinhvien.setId(id);
  	  		sinhvien.setUsername(id);
  	  		sinhvien.setPassword(id);
  	  		sinhvien.setLinkAnh("/View/image/userProfile.png");
  	  		sinhvien.setMaquyen(2);
  	  		sinhvien.setTen(names2[i]);
  	  		sinhvien.setIdclass(cl5);
  	  		    sv.insert(sinhvien);
  	  		}
  			String[] names3 = {
  			    "Nguyễn Văn Hùng", "Trần Thị Hằng", "Lê Văn Hà", "Phạm Thị Hoa", "Nguyễn Văn Hiệp",
  			    "Võ Thị Hồng", "Nguyễn Văn Khôi", "Trần Thị Kim", "Lê Văn Khoa", "Phạm Thị Linh",
  			    "Nguyễn Văn Lợi", "Trần Thị Ly", "Lê Văn Lương", "Phạm Thị Mai", "Nguyễn Văn Minh",
  			    "Võ Thị Mỹ", "Nguyễn Văn Nam", "Trần Thị Ngân", "Lê Văn Nguyên", "Phạm Thị Nguyệt",
  			    "Nguyễn Văn Phong", "Trần Thị Phương", "Lê Văn Phúc", "Phạm Thị Quỳnh", "Nguyễn Văn Quân",
  			    "Võ Thị Quỳnh", "Nguyễn Văn Sáng", "Trần Thị Thảo", "Lê Văn Thắng", "Phạm Thị Thúy",
  			    "Nguyễn Văn Tiến", "Trần Thị Trang", "Lê Văn Trung", "Phạm Thị Tuyết", "Nguyễn Văn Tuấn",
  			    "Võ Thị Uyên", "Nguyễn Văn Vinh", "Trần Thị Xuân", "Lê Văn Xương", "Phạm Thị Yến"
  			};
  			for (int i = 0; i < 40; i++) {
  	  		    Sv sinhvien = new Sv();
  	  		    String id = ""+(102220094+200+i);
  	  		  sinhvien.setId(id);
  	  		sinhvien.setUsername(id);
  	  		sinhvien.setPassword(id);
  	  		sinhvien.setLinkAnh("/View/image/userProfile.png");
  	  		sinhvien.setMaquyen(2);
  	  		sinhvien.setTen(names3[i]);
  	  		sinhvien.setIdclass(cl10);
  	  		    sv.insert(sinhvien);
  	  		}
  			String[] names4 = {
  			    "Nguyễn Văn Hoàng", "Trần Thị Quỳnh", "Lê Văn Tuấn", "Phạm Thị Hằng", "Nguyễn Văn Khánh",
  			    "Võ Thị Lan", "Nguyễn Văn Phúc", "Hoàng Thị Hà", "Nguyễn Văn An", "Trần Thị Thúy",
  			    "Lê Văn Bảo", "Phạm Thị Thu", "Nguyễn Văn Hiệu", "Trần Thị Thuận", "Lê Văn Hòa",
  			    "Phạm Thị Hương", "Nguyễn Văn Thắng", "Võ Thị Kim", "Trần Thị Lan", "Lê Văn Hậu",
  			    "Phạm Thị Nhung", "Nguyễn Văn Linh", "Trần Thị Huệ", "Lê Văn Quốc", "Phạm Thị Thảo",
  			    "Nguyễn Văn Lợn", "Trần Thị Lợi", "Lê Văn Đoàn", "Phạm Thị Tâm", "Nguyễn Văn Đăng",
  			    "Trần Thị Hồng", "Lê Văn Đức", "Phạm Thị Như", "Nguyễn Văn Tuấn", "Trần Thị Ngọc",
  			    "Lê Văn Anh", "Phạm Thị Nhung", "Nguyễn Văn Lâm", "Trần Thị Hằng", "Lê Văn Hải"
  			};
  			for (int i = 0; i < 40; i++) {
  	  		    Sv sinhvien = new Sv();
  	  		    String id = ""+(102220094+240+i);
  	  		  sinhvien.setId(id);
  	  		sinhvien.setUsername(id);
  	  		sinhvien.setPassword(id);
  	  		sinhvien.setLinkAnh("/View/image/userProfile.png");
  	  		sinhvien.setMaquyen(2);
  	  		sinhvien.setTen(names4[i]);
  	  		sinhvien.setIdclass(cl7);
  	  		    sv.insert(sinhvien);
  	  		}
  			String[] names5 = {
  			    "Nguyễn Văn Tiến", "Trần Thị Yến", "Lê Văn Anh", "Phạm Thị Hồng", "Nguyễn Văn Đông",
  			    "Võ Thị Thanh", "Nguyễn Văn Cường", "Hoàng Thị Mai", "Nguyễn Văn Bình", "Trần Thị Hạnh",
  			    "Lê Văn Hải", "Phạm Thị Lan", "Nguyễn Văn Tùng", "Trần Thị Thanh", "Lê Văn Đạo",
  			    "Phạm Thị Thu", "Nguyễn Văn Tuân", "Trần Thị Hương", "Lê Văn Hùng", "Phạm Thị Hoa",
  			    "Nguyễn Văn Lực", "Trần Thị Thu", "Lê Văn Hiên", "Phạm Thị Hạnh", "Nguyễn Văn Thành",
  			    "Trần Thị Thảo", "Lê Văn Sơn", "Phạm Thị Hồng", "Nguyễn Văn Duy", "Trần Thị Mỹ",
  			    "Lê Văn Huy", "Phạm Thị Thúy", "Nguyễn Văn Hào", "Trần Thị Hằng", "Lê Văn Hòa",
  			    "Phạm Thị Hương", "Nguyễn Văn Hợi", "Trần Thị Hà", "Lê Văn Khánh", "Phạm Thị Hoài"
  			};
  			for (int i = 0; i < 40; i++) {
  	  		    Sv sinhvien = new Sv();
  	  		    String id = ""+(102220094+280+i);
  	  		  sinhvien.setId(id);
  	  		sinhvien.setUsername(id);
  	  		sinhvien.setPassword(id);
  	  		sinhvien.setLinkAnh("/View/image/userProfile.png");
  	  		sinhvien.setMaquyen(2);
  	  		sinhvien.setTen(names5[i]);
  	  		sinhvien.setIdclass(cl8);
  	  		    sv.insert(sinhvien);
  	  		}
  			String[] names6 = {
  			    "Nguyễn Văn Thái", "Trần Thị Loan", "Lê Văn Thắng", "Phạm Thị Dung", "Nguyễn Văn Đức",
  			    "Võ Thị Thùy", "Nguyễn Văn Thọ", "Hoàng Thị Hằng", "Nguyễn Văn Anh", "Trần Thị Ngọc",
  			    "Lê Văn Phong", "Phạm Thị Hồng", "Nguyễn Văn Hưng", "Trần Thị Thùy", "Lê Văn Lợi",
  			    "Phạm Thị Linh", "Nguyễn Văn Tiến", "Trần Thị Lan", "Lê Văn Hải", "Phạm Thị Hường",
  			    "Nguyễn Văn Điệp", "Trần Thị Hằng", "Lê Văn Khải", "Phạm Thị Hồng", "Nguyễn Văn Hiếu",
  			    "Trần Thị Thảo", "Lê Văn Đạt", "Phạm Thị Nguyệt", "Nguyễn Văn Khoa", "Trần Thị Thúy",
  			    "Lê Văn Đông", "Phạm Thị Thanh", "Nguyễn Văn Quang", "Trần Thị Hà", "Lê Văn Lâm",
  			    "Phạm Thị Hải", "Nguyễn Văn Sáng", "Trần Thị Hiền", "Lê Văn Quân", "Phạm Thị Hằng"
  			};
  			for (int i = 0; i < 40; i++) {
  	  		    Sv sinhvien = new Sv();
  	  		    String id = ""+(102220094+320+i);
  	  		  sinhvien.setId(id);
  	  		sinhvien.setUsername(id);
  	  		sinhvien.setPassword(id);
  	  		sinhvien.setLinkAnh("/View/image/userProfile.png");
  	  		sinhvien.setMaquyen(2);
  	  		sinhvien.setTen(names6[i]);
  	  		sinhvien.setIdclass(cl9);
  	  		    sv.insert(sinhvien);
  	  		}
  			String[] names7 = {
  			    "Nguyễn Văn Tuấn", "Trần Thị Hạnh", "Lê Văn Tùng", "Phạm Thị Hồng", "Nguyễn Văn Đông",
  			    "Võ Thị Thanh", "Nguyễn Văn Cường", "Hoàng Thị Mai", "Nguyễn Văn Bình", "Trần Thị Hạnh",
  			    "Lê Văn Hải", "Phạm Thị Lan", "Nguyễn Văn Tùng", "Trần Thị Thanh", "Lê Văn Đạo",
  			    "Phạm Thị Thu", "Nguyễn Văn Tuân", "Trần Thị Hương", "Lê Văn Hùng", "Phạm Thị Hoa",
  			    "Nguyễn Văn Lực", "Trần Thị Thu", "Lê Văn Hiên", "Phạm Thị Hạnh", "Nguyễn Văn Thành",
  			    "Trần Thị Thảo", "Lê Văn Sơn", "Phạm Thị Hồng", "Nguyễn Văn Duy", "Trần Thị Mỹ",
  			    "Lê Văn Huy", "Phạm Thị Thúy", "Nguyễn Văn Hào", "Trần Thị Hằng", "Lê Văn Hòa",
  			    "Phạm Thị Hương", "Nguyễn Văn Hợi", "Trần Thị Hà", "Lê Văn Khánh", "Phạm Thị Hoài"
  			};
  			for (int i = 0; i < 40; i++) {
  	  		    Sv sinhvien = new Sv();
  	  		    String id = ""+(102220094+360+i);
  	  		  sinhvien.setId(id);
  	  		sinhvien.setUsername(id);
  	  		sinhvien.setPassword(id);
  	  		sinhvien.setLinkAnh("/View/image/userProfile.png");
  	  		sinhvien.setMaquyen(2);
  	  		sinhvien.setTen(names7[i]);
  	  		sinhvien.setIdclass(cl9);
  	  		    sv.insert(sinhvien);
  	  		}
  			nhdao.update(nh1);
  			nhdao.update(nh);
  		//////
	}	
}
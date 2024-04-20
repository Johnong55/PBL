
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
import DAO.Cauhoi_Dao;
import DAO.Class_dao;
import DAO.DeThi_dao;
import DAO.Giangday_dao;
import DAO.Gv_dao;
import DAO.KiThi_dao;
import DAO.NganhangDao;
import DAO.Sv_dao;
import DAO.truonghoc_dao;
import model.Account;
import model.Cauhoi;
import model.Class;
import model.DeThi;
import model.Giangday;
import model.Gv;
import model.KiThi;

import model.Nganhangcauhoi;
import model.Sv;
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
		//tr.insert(truong1);
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
		/*
		 * cl.insert(cl3); cl.insert(cl2); cl.insert(cl1);
		 */
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
		gv1.setPassword("123456");
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
		/*
		 * gv.insert(gv2); gv.insert(gv1);
		 */
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
//		sv.insert(sv5);
//		sv.insert(sv4);
//		sv.insert(sv3);
//		sv.insert(sv2);
//		sv.insert(sv1);
		KiThi kithi = new KiThi();
		kithi.setId("02");
		kithi.setLop(cl2);
		kithi.setGv(gv1);
		kithi.setThoigianbatdau(new Time(9, 30, 0));
		kithi.setThoigianlambai(45);
		kithi.setDate(new Date(2024 - 1900, 04, 20));
		kithi.setMota("Van");
		kithi.setSl(12);

		KiThi kithi1 = new KiThi();
		kithi1.setId("03");
		kithi1.setLop(cl2);
		kithi1.setGv(gv2);
		kithi1.setThoigianlambai(45);
		kithi1.setThoigianbatdau(new Time(17, 30, 0));
		kithi1.setDate(new Date(2024 - 1900, 8, 20));
		kithi1.setMota("Dia");
		kithi1.setSl(12);

		KiThi kithi2 = new KiThi();
		kithi2.setId("04");
		kithi2.setLop(cl2);
		kithi2.setGv(gv2);
		kithi2.setThoigianbatdau(new Time(8, 0, 0));
		kithi2.setThoigianlambai(45);
		kithi2.setDate(new Date(2024 - 1900, 6, 20));
		kithi2.setMota("SU");
		kithi2.setSl(12);

		DeThi dt1 = new DeThi("01", kithi2);
		DeThi dt2 = new DeThi("02", kithi1);
		DeThi dt3 = new DeThi("03", kithi2);
		DeThi dt4 = new DeThi("04", kithi1);
		Nganhangcauhoi nh = new Nganhangcauhoi();
		nh.setIdNganHang("Li");
		nh.setGiaovienquanli(gv2);
		Nganhangcauhoi nh1 = new Nganhangcauhoi();
		nh1.setIdNganHang("su");
		nh1.setGiaovienquanli(gv1);
//		nhdao.insert(nh1);
//		nhdao.insert(nh);
		Cauhoi q1 = new Cauhoi("q1", "What is the capital of France?", "Paris", "London", "Berlin", "Madrid", 2, 1,
				nh1);
		Cauhoi q2 = new Cauhoi("q2", "Who wrote 'Romeo and Juliet'?", "William Shakespeare", "Jane Austen",
				"Charles Dickens", "Mark Twain", 1, 1, nh);
		Cauhoi q3 = new Cauhoi("q3", "What is the chemical symbol for water?", "H2O", "CO2", "O2", "NaCl", 1, 1, nh);
		Cauhoi q4 = new Cauhoi("q4", "Which planet is known as the Red Planet?", "Mars", "Venus", "Jupiter", "Saturn",
				1, 1, nh1);
		Cauhoi q5 = new Cauhoi("q5", "Who painted the Mona Lisa?", "Leonardo da Vinci", "Vincent van Gogh",
				"Pablo Picasso", "Claude Monet", 1, 1, nh);
		Cauhoi q6 = new Cauhoi("q6", "What year did the Titanic sink?", "1912", "1905", "1920", "1935", 1, 1, nh1);
		Cauhoi q7 = new Cauhoi("q7", "What is the tallest mountain in the world?", "Mount Everest", "Mount Kilimanjaro",
				"K2", "Mount Fuji", 1, 1, nh);
		Cauhoi q8 = new Cauhoi("q8", "Who invented the telephone?", "Alexander Graham Bell", "Thomas Edison",
				"Nikola Tesla", "Guglielmo Marconi", 1, 1, nh);
		Cauhoi q9 = new Cauhoi("q9", "What is the currency of Japan?", "Yen", "Euro", "Dollar", "Pound", 1, 1, nh1);
		Cauhoi q10 = new Cauhoi("q10", "Who is the author of 'To Kill a Mockingbird'?", "Harper Lee", "J.K. Rowling",
				"Stephen King", "Ernest Hemingway", 1, 1, nh1);
//		CHdao.insert(q10);
//		CHdao.insert(q1);
//		CHdao.insert(q2);
//		CHdao.insert(q3);
//		CHdao.insert(q4);
//		CHdao.insert(q5);
//		CHdao.insert(q6);
//		CHdao.insert(q7);
//		CHdao.insert(q8);
//		CHdao.insert(q9);
		DeThi dethi1 = new DeThi();
		dethi1.addCauhoi(q10);
		dethi1.addCauhoi(q2);
		dethi1.addCauhoi(q3);
		dethi1.setId("05");
		dethi1.setKithi(kithi2);

		kithi.setNganhangcauhoi(nh1);
		kithi1.setNganhangcauhoi(nh1);
		kithi2.setNganhangcauhoi(nh);
//		kt.insert(kithi2);
//		kt.insert(kithi1);
//		kt.insert(kithi);
//		dt.insert(dethi1);

		Cauhoi[] danhSachCauHoi = new Cauhoi[10];

		danhSachCauHoi[0] = new Cauhoi("1", "Câu hỏi số 1", "Đáp án A", "Đáp án B", "Đáp án C", "Đáp án D", 1, 1, nh);
		danhSachCauHoi[1] = new Cauhoi("2", "Câu hỏi số 2", "Đáp án A", "Đáp án B", "Đáp án C", "Đáp án D", 2, 2, nh);
		danhSachCauHoi[2] = new Cauhoi("3", "Câu hỏi số 3", "Đáp án A", "Đáp án B", "Đáp án C", "Đáp án D", 3, 3, nh);
		danhSachCauHoi[3] = new Cauhoi("4", "Câu hỏi số 4", "Đáp án A", "Đáp án B", "Đáp án C", "Đáp án D", 1, 4, nh);
		danhSachCauHoi[4] = new Cauhoi("5", "Câu hỏi số 5", "Đáp án A", "Đáp án B", "Đáp án C", "Đáp án D", 2, 1, nh);
		danhSachCauHoi[5] = new Cauhoi("6", "Câu hỏi số 6", "Đáp án A", "Đáp án B", "Đáp án C", "Đáp án D", 3, 2, nh);
		danhSachCauHoi[6] = new Cauhoi("7", "Câu hỏi số 7", "Đáp án A", "Đáp án B", "Đáp án C", "Đáp án D", 1, 3, nh);
		danhSachCauHoi[7] = new Cauhoi("8", "Câu hỏi số 8", "Đáp án A", "Đáp án B", "Đáp án C", "Đáp án D", 2, 4, nh);
		danhSachCauHoi[8] = new Cauhoi("9", "Câu hỏi số 9", "Đáp án A", "Đáp án B", "Đáp án C", "Đáp án D", 3, 1, nh);
		danhSachCauHoi[9] = new Cauhoi("10", "Câu hỏi số 10", "Đáp án A", "Đáp án B", "Đáp án C", "Đáp án D", 1, 2, nh);

//		for (Cauhoi i : danhSachCauHoi) {
//			Cauhoi_Dao.Instance().insert(i);
//		}
		
		DeThi dethimoi  = new DeThi();
		dethimoi.setId("01");
		dethimoi.setMota("GIUA KI");
		dethimoi.setKithi(kithi2);
		dt.Xaydungdethi(2, 3, 4, dethimoi);
		for(Cauhoi i : dethimoi.getList())
		{

			System.out.println(i);
		}
	}	
}

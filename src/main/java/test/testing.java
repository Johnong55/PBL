package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DAO.BaiLam_dao;
import DAO.CautraloiSinhvien_dao;
import model.BaiLam;
import model.Cautraloisinhvien;

public class testing {
	public static void main(String[] args) {
		for(BaiLam i: BaiLam_dao.Instance().selectbailamfromkithi("04"))
			{
			
				System.out.println(i);
			}
	}
}

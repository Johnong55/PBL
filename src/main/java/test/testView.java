package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Cauhoi;

public class testView {
	public static void main(String[] args) {
		  String filePath = "D:\\cauhoi.txt"; // Đường dẫn tới file TXT
	        List<Cauhoi> danhSachCauHoi = new ArrayList<Cauhoi>();

	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            String noiDung = null, dapAnA = null, dapAnB = null, dapAnC = null, dapAnD = null, dapAnDung = null;
	            int mucDo = 0;

	            while ((line = br.readLine()) != null) {
	                if (line.startsWith("Câu hỏi")) {
	                    noiDung = line.substring(line.indexOf(":") + 2);
	                } else if (line.startsWith("A:")) {
	                    dapAnA = line.substring(3);
	                } else if (line.startsWith("B:")) {
	                    dapAnB = line.substring(3);
	                } else if (line.startsWith("C:")) {
	                    dapAnC = line.substring(3);
	                } else if (line.startsWith("D:")) {
	                    dapAnD = line.substring(3);
	                } else if (line.startsWith("Đáp án:")) {
	                    dapAnDung = line.substring(8);
	                } else if (line.startsWith("Mức độ:")) {
	                    mucDo = Integer.parseInt(line.substring(8).trim());
	                    Cauhoi a = new Cauhoi();
	                    a.setNoidung(noiDung);
	                    a.setDapan(dapAnDung);
	                    a.setDapAnA(dapAnA);
	                    a.setDapAnB(dapAnB);
	                    a.setDapAnC(dapAnC);
	                    a.setDapAnD(dapAnD);
	                    a.setMucdo(mucDo);
	                    // Sau khi đọc xong một câu hỏi
	                    danhSachCauHoi.add(a);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // In danh sách các câu hỏi để kiểm tra
	        for (Cauhoi cauHoi : danhSachCauHoi) {
	            System.out.println(cauHoi);
	        }
	    }
	}


package test;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import DAO.request_dao;
import model.request;

public class testing {
    public static void main(String[] args) {
    	for(request i :request_dao.Instance().selectallfromrequest())
    	{
    		System.out.println(i);
    	}
    }
}
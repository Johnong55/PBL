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

public class testing {
    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                
                try {
                	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                	new testing().createUI();
				} catch (Exception e) {
					// TODO: handle exception
				}
            }
            
        };

        EventQueue.invokeLater(r);
    }

    private void createUI() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        JButton saveBtn = new JButton("Save");
        JButton openBtn = new JButton("Open");

        saveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser saveFile = new JFileChooser();
                saveFile.showSaveDialog(null);
            }
        });

        openBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser openFile = new JFileChooser();
                openFile.showOpenDialog(null);
            }
        });

        frame.add(new JLabel("File Chooser"), BorderLayout.NORTH);
        frame.add(saveBtn, BorderLayout.CENTER);
        frame.add(openBtn, BorderLayout.SOUTH);
        frame.setTitle("File Chooser");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import jdk.nashorn.internal.scripts.JD;

/**
 *
 * @author Thien
 */
public class setScores extends JDialog{

    public setScores() {
        setTitle("Save Scores");
        setBounds(100, 100, 300, 150);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JLabel pp = new JLabel();
        JLabel tab = new JLabel();
        if (data.scores > data.maxScores) 
        {
            pp.setText("New Hight Scores!!");
            pp.setFont(new Font("MTCORSVA", Font.BOLD, 20));
            pp.setForeground(Color.red);
        }
        
        
        
        JLabel ss = new JLabel("Name");
        JTextField setTen  = new JTextField();
        setLayout(null);
        setResizable(false);
        setAlwaysOnTop(true);
        pp.setBounds(55, 0, 200, 50);
        ss.setBounds(40, 30, 200, 50);
        setTen.setBounds(80, 45, 150, 25);
        add(pp);
        add(ss);
        add(setTen);
       
        database ssb = new database();
        JButton ok = new JButton("Save");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hoTen = setTen.getText();
                if (hoTen.equals("")) hoTen = new String("No name");
                try {
                    //System.out.println(hoTen);
                   
                    ssb.insert(hoTen, data.scores);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(setScores.class.getName()).log(Level.SEVERE, null, ex);
                }
                data.maxScores = data.dB.getData().diem;
                tabRight.max.setText("Hight Scores: " + data.maxScores);
                dispose();
            }
        });
        ok.setBounds(70, 80, 80, 25);
        
        JButton ex = new JButton("Cancel");
        ex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ssb.close();
                dispose();
                
            }
        });
        ex.setBounds(160, 80, 80, 25);
        add(ok);
        add(ex);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new setScores();
    }
}

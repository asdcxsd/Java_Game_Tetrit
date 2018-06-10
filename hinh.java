/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Thien
 */
public class hinh extends JFrame 
{
    public JPanel a;
    public static mid mid;
    tabRight tabR;
    tabBottem tabB;
    public hinh()
    {
        setTitle("Ve hinh");
        setBounds(10, 10,435, 645);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        setLayout(new BorderLayout());
      //  add(mid);
        mid = new mid();
        add(mid, BorderLayout.CENTER);
        tabR = new tabRight();
        tabB=  new tabBottem();
        add(tabR, BorderLayout.EAST);
        add(tabB, BorderLayout.SOUTH);
        
        setVisible(true);
        setResizable(false);
        setBackground(Color.black);
    }
   
    
  
    
   
}

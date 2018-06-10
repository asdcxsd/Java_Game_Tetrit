/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Thien
 */
public class tabRight extends JPanel{
    private  JButton butStart;
    private  JButton butPause;
    private JButton  butOption;
    public static JLabel max;
    public static JLabel sc;
    public static JLabel nam;
    tabRight()
    {
        new data();
        setLayout(new GridLayout(13, 1));
       // setSize(400, HEIGHT);
        setBackground(Color.black);
        butStart = new JButton("      New Game     ");
        butStart.setSize(new Dimension(20, 200));
        butStart.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
              
                hinh.mid.reset();
                hinh.mid.start();
                
                butPause.setText("Pause");
                tabBottem.action.setText("Game running");
                data.maxScores = data.dB.getData().diem;
                data.name  = data.dB.getData().name;
                tabRight.max.setText(" " + data.name + ": " + data.maxScores);
            }
        });
        
        butPause = new JButton("Pause");
        butPause.setSize(new Dimension(20, 100));
        
        butPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hinh.mid.time == null) return;
                if (hinh.mid.time.isRunning()) 
                {
                    hinh.mid.time.stop();
                    butPause.setText("Continue");
                    tabBottem.action.setText("Game pause");
                }
                else 
                {
                    butPause.setText("Pause");
                    hinh.mid.start();
                    tabBottem.action.setText("Game running");
                }
            }
        });
        sc = new JLabel("Scores: " + data.scores);
        sc.setText("Scores: " + data.scores);
        max = new JLabel();
      
        data.maxScores = data.dB.getData().diem;
        data.name  = data.dB.getData().name;

        max.setText( " " + data.name + ": "+ data.maxScores);
        max.setForeground(Color.red);
//        nam.setForeground(Color.white);
        sc.setForeground(Color.white);
      //  System.out.println("ve.tabRight.<init>()");
        butOption = new JButton("Options");
        butOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog option = new JDialog();
                option.setBounds(100, 100, 200, 120);
                option.setAlwaysOnTop(true);
                option.setVisible(true);
                option.setLayout(null);
                option.setResizable(false);
                
                JLabel lv= new JLabel("Lever");
                lv.setBounds(20, 10, 50, 20);
                JComboBox npp = new JComboBox();
                for(int i= 1; i<= 10; i++) npp.addItem(i);
                npp.setBounds(80, 10, 80, 20);
                
                option.add(lv);
                option.add(npp);
                npp.setSelectedIndex(10-data.constauto);
                JButton ok = new JButton("OK");
                ok.setBounds(60, 50, 70, 30);
                
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int x = npp.getSelectedIndex();
                        
                        System.out.println(x);
                        data.constauto = 10 - x;
                        System.out.println(data.constauto);
                        
                        hinh.mid.reset();
                        //hinh.mid.start();
                        tabBottem.action.setText("Game Stop");
                        option.dispose();
                    }
                    
                });
                option.setTitle("Option lever");
                option.add(ok);
                
            }
        });
        add(new JLabel("Hight scores:"){
            @Override
            public void setForeground(Color fg) {
                super.setForeground(Color.white); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        add(max);
        add(sc);
        add(butStart);
        add(butPause);
        add(butOption);
        
    }
    public static void main(String[] args) {
        JFrame xx = new JFrame();
        xx.add(new tabRight());
        xx.setVisible(true);
    }
}

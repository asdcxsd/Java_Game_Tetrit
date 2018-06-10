/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Thien
 */
public class tabBottem extends JPanel{
    public static JLabel action;
    private JLabel act;
    public tabBottem()
    {
        act = new JLabel("Tetrit - V1.0");
        action = new JLabel("");
        setLayout(new GridLayout(1, 3));
        add(act);
        add(new JLabel("asdcxsd"));
        add(action);
        
    }
}

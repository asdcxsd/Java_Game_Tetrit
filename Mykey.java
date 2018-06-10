/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Thien
 */
public class Mykey extends KeyAdapter{
    private box hop;
    public Mykey(box hop)
    {
        this.hop = hop;
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        hop.keyTyped(e);
    }
    
    @Override 
    public void keyPressed(KeyEvent e)
    {
        hop.keyPressed(e);
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        hop.keyReleased(e);
    }
}

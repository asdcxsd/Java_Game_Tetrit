/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve;

import java.awt.event.KeyEvent;
import static java.lang.Math.*;
import java.util.Random;

/**
 *
 * @author Thien
 */

public class box  {
    public  int n;
        
    public int vt_x, vt_y, huong, hinh;
    public int dx, dy;
    public data da;
    public pair[] list;
    
    public boolean online = false;
    public boolean checkDao = false; 
    public boolean daDao = false;
    public Random rand = new Random();
    public box()
    {
        
      hinh = rand.nextInt(6);
      da = new data(hinh);
      n = da.n;
      huong = 0;
      list = new pair[n];      
      vt_x = 5;
      vt_y = 1;
      for(int i= 0; i<n; i++) list[i] = da.get(hinh, huong, i);
    }
    
   
    
    public void move()
    {
        vt_x += dx;
        vt_y += dy;
    }
    
    public void autoMove()
    {
         vt_y += 1;
      
    }
    
    
    public int getx(int i)
    {
        return vt_x + list[i].x;
    }
    
    public int gety(int i)
    {
        return vt_y + list[i].y;
    }
   
    public void dao(mid same)
    {
       
        huong++;
        if (huong >=4) huong = 0;
        boolean ok = true;
        for(int i= 0; i<n; i++) {
            pair tam = da.get(hinh, huong, i);
            int vtx = vt_x + tam.x;
            int vty = vt_y + tam.y;
            if (same.check(vtx, vty)) ok = false;
        }
        
        if (ok)
        {
            for(int i= 0; i<n; i++) 
            list[i] = da.get(hinh, huong, i);
        }else
        {
            huong--;
            if (huong<0) huong = 3;
        }
            
    }
    public void keyTyped(KeyEvent e)
    {
        int key = e.getKeyChar();
        if (key == 'n') online = false;
    }
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        switch(key)
        {
            case KeyEvent.VK_LEFT:
            {
                dx = -1;
                break;
            }
            
            case KeyEvent.VK_RIGHT:
            {
                dx = 1;
                break;
            }
            case KeyEvent.VK_DOWN:
            {
                dy = 1;
                break;
            }
            case KeyEvent.VK_UP:
            {
               
                checkDao = true;
                break;
            }
        }
             
    }
    
    
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
         switch(key)
        {
            case KeyEvent.VK_LEFT:
            {
                dx = 0;
                break;
            }
            
            case KeyEvent.VK_RIGHT:
            {
                dx = 0;
                break;
            }
            case KeyEvent.VK_DOWN:
            {
                dy = 0;
                break;
            }
             case KeyEvent.VK_UP:
            {
      
                checkDao = false;
                daDao = false;
                break;
            }
        }
                
    }
}

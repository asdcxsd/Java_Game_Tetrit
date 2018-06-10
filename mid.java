/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;
import static ve.data.dB;
import static ve.data.maxScores;


/**
 *
 * @author Thien
 */
public class mid extends JPanel implements ActionListener{
    // data 
    public  int size_w = data.size_w;
    public  int size_h = data.size_h; 
    public int box_size = data.box_size;
    
  
    public int constTime = data.constTime;
    
    //
    private int boxOnline = 1;
    private  boolean stopGame = false;
    private  box[] a =new box[10];
    public static  Timer time;
    private Mykey ap;
    private  int[][] bord = new  int[size_w + 5][size_h+ 5];
    private void memset()
    {
        for(int i = 1; i<= size_w; i++)
            for(int j= 1; j<= size_h; j++) if (bord[i][j] >= 1 && bord[i][j] <= 3) bord[i][j] = 0;
    }
    mid() 
    {
        repaint();
        
    }       
    
    public  void reset()
    {
        if (time != null)
            if (time.isRunning() == true) time.stop();
        time = new Timer(constTime, this);
        memsetBord();         
        for(int h= 1; h<= 3; h++) {
            a[h] = new box();
            a[h].vt_x += (h-2)*3;
        }
        data.scores = 0;
        boxOnline = 1;
        a[1].online = true;
        stopGame = false;
        ap = new Mykey(a[1]);
        addKeyListener(ap);
    }
    public void start()
    {
        this.grabFocus();
        time.start();
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics gp =  (Graphics2D)g;
        
        gp.setColor(Color.red);
        memset();
        for(int j= 1; j<= 3; j++)
        {
            
            if (a[j] == null) continue;
            for(int i= 0 ;i< a[j].n; i++) 
            {
               // System.out.println(a.list[i].x + " " + a.list[i].y);
                bord[a[j].getx(i)][a[j].gety(i)] = j;
            }
        }
        if (a[boxOnline] != null)
        for(int i= 0 ;i< a[boxOnline].n; i++) 
            {
               // System.out.println(a.list[i].x + " " + a.list[i].y);
                bord[a[boxOnline].getx(i)][a[boxOnline].gety(i)] = boxOnline;
            }
        
        for(int i= 0 ;i<size_w; i++)
            for(int j= 0; j<size_h; j++) 
            {
                if (bord[i+1][j+1] >= 1 && bord[i+1][j+1] <= 3)  gp.setColor(Color.RED);
                
                else if (bord[i+1][j+1] == -50) gp.setColor(Color.GRAY);
                else gp.setColor(Color.BLUE);
                
                 if (bord[i+1][j+1] == boxOnline) gp.setColor(Color.orange);
                gp.fillRect(i*box_size, j*box_size, box_size, box_size);
                
                
                gp.setColor(Color.BLUE);
                int vx = i*box_size;
                int vy = j*box_size;
                int ux = vx + box_size-1;
                int uy = vy + box_size-1;
                gp.drawLine(vx, vy, vx, uy);
                gp.drawLine(vx, vy, ux, vy);
            }   
        if (stopGame == true) {
            memset();
            memsetBord();
        }
    }
    
    private int dem =  0;
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
  //      System.out.println(data.scores);
        if (a[boxOnline].online == false)
        {
            removeKeyListener(ap);
            boxOnline++;
            if (boxOnline > 3)  boxOnline = 1;
            ap = new Mykey(a[boxOnline]);
            a[boxOnline].online = true;
            addKeyListener(ap);
        }
        for(int h= 1; h<= 3; h++)
        {
            if (a[h] == null )continue;
            if (checkGiao(a[h]) ) a[h].move();
            if (checkDie(a[h])) {
                if (checkover())
                {
                    gameOver();
                    //time = new Timer(constTime, this);
                    return;
                }
                if (a[h].online)
                {
                    a[h] = new box();
                    a[h].vt_x += (h-2)*3;
                    ap = new Mykey(a[h]);
                    a[h].online = true;
                    addKeyListener(ap);
                }else 
                {
                    a[h] = new box();
                    a[h].vt_x += (h-2)*3;
                }

            }
        }
        
        if (dem >= data.constauto) {
            for(int h=1; h<= 3; h++)
            {
                if (a[h] == null) continue;
                a[h].autoMove(); 
            }
        //    System.out.println(data.constauto);
            dem = 0;

        }else dem++;

      
        if (a[boxOnline].daDao == false && a[boxOnline].checkDao == true)
        {
            a[boxOnline].daDao = true;
            a[boxOnline].dao(this);
        }

        tabRight.sc.setText("Scores: "+ data.scores);
        repaint();
    }
    private void memsetBord()
    {
        for(int i = 1; i<= size_w; i++)
            for(int j= 1; j<= size_h; j++) bord[i][j] = 0;
        for(int i= 0; i<= size_w+ 1; i++) bord[i][0] = bord[i][size_h+1] = -100;
        for(int i= 0; i<= size_h + 1; i++) bord[0][i] = bord[size_w+1][i] = -100;
    }
    private boolean checkGiao(box a)
    {
       boolean ans = true;
       for(int i= 0; i<a.n; i++) 
       {
           int temp = bord[a.getx(i) + a.dx][a.gety(i) + a.dy];
           if ( temp == -100 || temp == -50) ans = false;
       }
       return ans;
    }
    
    private boolean checkDie(box a)
    {
        boolean ans = false;
       for(int i= 0; i<a.n; i++) 
       {
           int temp = bord[a.getx(i)][a.gety(i)+ 1];
           if ( temp == -50 || temp == -100){
               ans = true;
           }
       }
       if (ans)
       {
            int slan = 0;
            for(int i= 0; i<a.n; i++) 
            {
                bord[a.getx(i)][a.gety(i)] = -50;
            }
            for(int i= size_h; i>= 1; i--)
            {
                int ok = 1;
                for(int j= 1; j<= size_w; j++) if (bord[j][i] != -50) ok = 0;
                if (ok ==1 )
                {
                    slan++;
                    data.scores+= (2 + (11 - data.constauto))*slan;
                    for(int k = i; k>1; k--)
                    for(int j= 1; j<= size_w; j++) bord[j][k] = bord[j][k-1];
                    i++;
                }
                  
            }
       }
       return ans;
    }
    boolean checkover()
    {
        for(int i= 1; i<=size_w; i++) if(bord[i][1] == -50) return true;
        return false;
               
    }
    
    private  void gameOver()
    {
        stopGame = true;
        repaint();
        tabBottem.action.setText("Game over");
        new setScores();
        data.maxScores = data.dB.getData().diem;
        data.name  = data.dB.getData().name;
        tabRight.max.setText(" " + data.name + ": " + data.maxScores);
        time.stop();
    }
            
    
    public boolean check(int x, int y)
    {
        if (bord[x][y] == 0|| (bord[x][y] >=1 && bord[x][y] <= 3)) return false;
        else return true;
    }
    
}

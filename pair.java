/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve;

/**
 *
 * @author Thien
 */
public class pair {
    public int x, y;
    
    
    public pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public pair(pair temp)
    {
        x = temp.x;
        y = temp.y;
    }
    
    public pair(){
        x= y = 0;
    }

   
}

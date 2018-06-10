/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve;

import java.util.ArrayList;

/**
 *
 * @author Thien
 */
public class data {
    public  static int size_w = 15;
    public  static int size_h = 30; 
    public static int box_size = 20;
    public static String name = "thien";
    public static int constauto = 3;
    public static int constTime = 100;
    public static int maxScores = 0;
    public static int scores = 0;
    public int n;
    public pair[] list;
    pair[][] p = new pair[10][100];
    public int[] pn = new int[10];
    
    
    // database 
    public static database dB = new database();
    data()
    {
        maxScores = dB.getData().diem;
    }
    data(int x) {

        //  11
        //  10
      //  dataBase();
        
        dataKhoi(x);
        
    }
    
    public void dataKhoi(int x)
    {
         pn[0] = 3;
        p[0][0] = new pair(0, 0);
        p[0][1] = new pair(1, 0);
        p[0][2] = new pair(0, 1);

        p[0][3] = new pair(0, 0);
        p[0][4] = new pair(1, 0);
        p[0][5] = new pair(1, 1);

        p[0][6] = new pair(1, 1);
        p[0][7] = new pair(1, 0);
        p[0][8] = new pair(0, 1);

        p[0][9] = new pair(0, 0);
        p[0][10] = new pair(1, 1);
        p[0][11] = new pair(0, 1);

        //  11
        //  11
        pn[1] = 4;
        p[1][0] = new pair(0, 0);
        p[1][1] = new pair(0, 1);
        p[1][2] = new pair(1, 0);
        p[1][3] = new pair(1, 1);

        p[1][4] = new pair(0, 0);
        p[1][5] = new pair(0, 1);
        p[1][6] = new pair(1, 0);
        p[1][7] = new pair(1, 1);

        p[1][8] = new pair(0, 0);
        p[1][9] = new pair(0, 1);
        p[1][10] = new pair(1, 0);
        p[1][11] = new pair(1, 1);

        p[1][12] = new pair(0, 0);
        p[1][13] = new pair(0, 1);
        p[1][14] = new pair(1, 0);
        p[1][15] = new pair(1, 1);

        // 
        pn[2] = 4;
        p[2][0] = new pair(1, 0);
        p[2][1] = new pair(1, 1);
        p[2][2] = new pair(1, 2);
        p[2][3] = new pair(1, 3);

        p[2][4] = new pair(0, 1);
        p[2][5] = new pair(1, 1);
        p[2][6] = new pair(2, 1);
        p[2][7] = new pair(3, 1);

        p[2][8] = new pair(1, 0);
        p[2][9] = new pair(1, 1);
        p[2][10] = new pair(1, 2);
        p[2][11] = new pair(1, 3);

        p[2][12] = new pair(0, 0);
        p[2][13] = new pair(1, 0);
        p[2][14] = new pair(2, 0);
        p[2][15] = new pair(3, 0);

        pn[3] = 4;
        p[3][0] = new pair(0, 1);
        p[3][1] = new pair(1, 1);
        p[3][2] = new pair(2, 1);
        p[3][3] = new pair(1, 2);

        p[3][4] = new pair(1, 0);
        p[3][5] = new pair(0, 1);
        p[3][6] = new pair(1, 1);
        p[3][7] = new pair(1, 2);

        p[3][8] = new pair(1, 0);
        p[3][9] = new pair(0, 1);
        p[3][10] = new pair(1, 1);
        p[3][11] = new pair(2, 1);

        p[3][12] = new pair(1, 0);
        p[3][13] = new pair(1, 1);
        p[3][14] = new pair(2, 1);
        p[3][15] = new pair(1, 2);

        pn[4] = 4;
        p[4][0] = new pair(1, 0);
        p[4][1] = new pair(1, 1);
        p[4][2] = new pair(0, 1);
        p[4][3] = new pair(0, 2);

        p[4][4] = new pair(0, 0);
        p[4][5] = new pair(1, 1);
        p[4][6] = new pair(1, 0);
        p[4][7] = new pair(2, 1);

        p[4][8] = new pair(1, 0);
        p[4][9] = new pair(1, 1);
        p[4][10] = new pair(0, 1);
        p[4][11] = new pair(0, 2);

        p[4][12] = new pair(0, 0);
        p[4][13] = new pair(1, 1);
        p[4][14] = new pair(1, 0);
        p[4][15] = new pair(2, 1);
        
        
        pn[5] = 4;
        p[5][0] = new pair(0, 0);
        p[5][1] = new pair(1, 0);
        p[5][2] = new pair(1, 1);
        p[5][3] = new pair(1, 2);

        p[5][4] = new pair(0, 1);
        p[5][5] = new pair(1, 1);
        p[5][6] = new pair(2, 1);
        p[5][7] = new pair(2, 0);

        p[5][8] = new pair(0, 0);
        p[5][9] = new pair(0, 1);
        p[5][10] = new pair(0, 2);
        p[5][11] = new pair(1, 2);

        p[5][12] = new pair(0, 0);
        p[5][13] = new pair(0, 1);
        p[5][14] = new pair(1, 0);
        p[5][15] = new pair(2, 0);
        
        this.n = pn[x];
    }
    public pair get (int hinh, int huong, int i) {
        pair tam = new pair();
        tam = p[hinh][huong * pn[hinh] + i];
        return tam;
    }
}

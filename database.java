/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve;
import  java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Collation;
/**
 *
 * @author Thien
 */
public class database {
 
    static final String DB_URL = "jdbc:sqlite:d:/gametetrit.sqlite";
    public static Connection conn = null;
    public static Statement stmt = null;
    public static ArrayList<player> arr = new ArrayList<player>();
    public database() 
    {
        try{
           Class.forName("org.sqlite.JDBC");
           conn = DriverManager.getConnection(DB_URL);
           stmt = conn.createStatement();
           makeTable();
        }catch(SQLException se){
     
           se.printStackTrace();
        }catch(Exception e){
     
           e.printStackTrace();
        }
         close();
       
    }// Ket thuc main
    public static void insert(String name, int diem) throws SQLException
    {
         try{
           Class.forName("org.sqlite.JDBC");
           conn = DriverManager.getConnection(DB_URL);
  
           String sql = "INSERT INTO tetrit ('Name', Diem) values ( ? , ?)";
        // ystem.out.println(conn.toString());
            PreparedStatement ss = conn.prepareStatement(sql);
            ss.setString(1, name);
            ss.setInt(2, diem);
            ss.executeUpdate();
         
        }catch(SQLException se){
     
           se.printStackTrace();
        }catch(Exception e){
     
           e.printStackTrace();
        }
         close();
    }
    
    public void edit(String name, int diem) throws SQLException
    {
        try{
           Class.forName("org.sqlite.JDBC");
           conn = DriverManager.getConnection(DB_URL);
            
            String sql = "UPDATE tetrit set  Diem = ? where Name = ? ";
            PreparedStatement ss = conn.prepareStatement(sql);
            ss.setString(2, name);
            ss.setInt(1, diem);
            ss.executeUpdate();
         
        }catch(SQLException se){
     
           se.printStackTrace();
        }catch(Exception e){
     
           e.printStackTrace();
        }
         close();
        
    }
    
    public void makeTable() throws SQLException
    {
        String sql = "CREATE TABLE IF NOT EXISTS tetrit (\n Name text, Diem integer);";
        stmt.execute(sql);
    }
    
    
    public player getData()
    {
        int dMax = 0;
        String ten = new String("No Name");
        try
        {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            String sql;
               sql = "SELECT Name, Diem FROM tetrit Order by Diem ASC";
               ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                  String  hoTen = rs.getString("Name");
                  int diem = rs.getInt("Diem");
                  if (dMax < diem){
                      dMax = diem;
                      ten= hoTen;
                  }
                //   System.out.println("ve.database.<init>()");
               }
           rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        System.out.println(dMax);
        
        player ans = new player(ten, dMax);

        return ans;
    }
    
    
    public static void close()
    {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           } 
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }
    }
    
}


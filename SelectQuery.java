/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestPackage;

/**
 *
 * @author shiva
 */
import java.sql.*;
public class SelectQuery {
    public static void main(String[] args) {
        
        try{Connection con = GetConnection.getConnection();
        
        //Usiing Result set
        String q = "select * from student";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(q);
        
        while(rs.next())
        {
            int id = rs.getInt(1);  //column number as parameter or column name in string format
            String name = rs.getString(2);
            String Address = rs.getString(3);
            String City = rs.getString(4);
            
            System.out.println("The student's ID is "+id+".The Student's name is "+name+".The Student's Address is "
                    +Address+".The Student's city is "+City+".");
        }
        
        
        
        }
        
        catch(Exception e)
        {e.printStackTrace();}
        
        
        
    }
}

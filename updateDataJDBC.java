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
import java.util.Scanner;
import javax.swing.JOptionPane;
public class updateDataJDBC {
    public static void main(String args[])
    {
        try {
            Connection con = GetConnection.getConnection();
            
            //Direct;y setting new vaue 
            String q = "Update Student set Address = \"This is altered address\" where StudentID=1";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Description updated");
            
            //Asking input from user and updating values
            String query2 = "Update Student set StudentCity=? where StudentID=?";
            PreparedStatement pstmt = con.prepareStatement(query2);
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter the new Student City");
            String city = sc.next();
            
            System.out.println("Enter the studentID whose City you want to alter");
            int id = sc.nextInt();
            
            pstmt.setString(1, city);
            pstmt.setInt(2, id);
            
            pstmt.executeUpdate();
            
            System.out.println("Update student information");
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

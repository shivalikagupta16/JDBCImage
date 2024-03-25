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
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        try{
        Connection c = GetConnection.getConnection();
        
        //Here we are giving the image path ourselves
        String q = "Insert into Images(ImageDescription,pic) values(?,?)";
        
        PreparedStatement pstmt = c.prepareStatement(q);
        
        FileInputStream fis = new FileInputStream("C:\\Users\\shiva\\OneDrive\\Pictures\\javaScript output.png");
        
        pstmt.setString(1, "This is javascript image");
        pstmt.setBinaryStream(2,fis,fis.available());
        
        
        //This is file chooser
        JFileChooser JFile = new JFileChooser();
        JFile.showOpenDialog(null);
        File file = JFile.getSelectedFile();
        FileInputStream fis2 = new FileInputStream(file);
        
        pstmt.setString(1, "This is chosen image");
        pstmt.setBinaryStream(2,fis2,fis2.available());
        
        pstmt.executeUpdate();
        
        //To show message box with success
        JOptionPane.showMessageDialog(null, "success");
        
        }catch(Exception e)
        {e.printStackTrace();}
    }
    
    
    
}

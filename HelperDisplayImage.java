/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestPackage;

/**
 *
 * @author shiva
 */
import java.awt.Image;
import java.io.InputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class HelperDisplayImage {
    public static ImageIcon getImageIconByID(int id, Connection con)
    {
        ImageIcon icon = null;
        
        try{
            String q = "select pic from images where ImageID=?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1,id);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                Blob b = rs.getBlob("pic");
                InputStream is = b.getBinaryStream();
                Image image = ImageIO.read(is);
                icon = new ImageIcon(image);
                
            }
            
            
        }catch(Exception e )
        {
            e.printStackTrace();
        }
       
        return icon;
    }
}

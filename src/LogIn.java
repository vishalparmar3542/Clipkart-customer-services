/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author visha
 */
public class LogIn {
    Connection con;
     public  LogIn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            }catch(Exception e){ System.out.println(e);}
                    }
     public String login(String id,String password)
     {
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","parmar3542");
            Statement stmt=con.createStatement();
            
            String query="select * from login";
            
            ResultSet rs = stmt.executeQuery(query);
           
           
            
            while(rs.next())
            {
                if(rs.getString("personid").equals(id) && rs.getString("pass").equals(password))
                {
                    System.out.println(" person found and its ID is "+rs.getString("PersonId"));
                    String name=rs.getString("username");
                     con.close();
                    return name;
                }
            }
            
           con.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "NOTFOUND";
     } 
     
    
        

    
    
}

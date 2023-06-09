/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author visha
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class Admin {
    Connection con;
    ResultSet rs;
     public  Admin(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","parmar3542");
            
            }catch(Exception e)
            { System.out.println(e);}
                    }
     public ResultSet showAllUsers()
     {
        try {
        
            Statement stmt=con.createStatement();
            
            String query="select * from login";
            
             rs = stmt.executeQuery(query);
           
           
            
          
            
           //con.close(); 
           System.out.println("about to close");
           return rs; 
        } catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}
      public ResultSet showAllOrders()
     {
        try {
         
            Statement stmt=con.createStatement();
            
            String query="select * from orders";
            
             rs = stmt.executeQuery(query);
           
           
            
          
            
           //con.close(); 
           System.out.println("about to close");
           return rs; 
        } catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}
      public boolean addUser(String name,String id,String pass)
      {
           try {
            
            Statement stmt=con.createStatement();
            
            String query="INSERT INTO  login VALUES ('"+id+"','"+name+"','"+pass+"');";
            
              stmt.executeUpdate(query);
           
           
            
          
            System.out.println("done");
          
          
           
        }
           catch (SQLIntegrityConstraintViolationException e)
           {
               System.out.print("hereeeeee");
               return false;
           }
           catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;  
      }
      public boolean updateUser(String name,String id,String pass)
      {
           try {
            
            Statement stmt=con.createStatement();
            
            String query="UPdatE login SET username='"+name+"',pass='"+pass+"' where PersonID="+id+";";
            
              stmt.executeUpdate(query);
           
           
            
          
            System.out.println("doneupdatinguser");
          
          
           
        }
           catch (SQLIntegrityConstraintViolationException e)
           {
               System.out.print("not updated");
               return false;
           }
           catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
          
          
          
       return true;   
      }
      public boolean deleteUser(String id)
      {
           try {
            
            Statement stmt=con.createStatement();
            
            String query="delete  from login  where PersonID="+id+";";
            
              stmt.executeUpdate(query);
            System.out.println("doneupdatinguser");   
        }
           catch (SQLIntegrityConstraintViolationException e)
           {
               System.out.print("not updated");
               return false;
           }
           catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
          
          return true;
          
      }
      public boolean addOrder(StoreOrder od)
      {
          try {
            
            Statement stmt=con.createStatement();
            
            String query="INSERT INTO orders values ("+od.id+",'"+od.name+"','"+od.payment+"','"+od.delivery+"',"+od.pid+","+od.price+");";
            
              stmt.executeUpdate(query);
            System.out.println("done");   
        }
           catch (SQLIntegrityConstraintViolationException e)
           {
               System.out.print("hereeeeee");
               return false;
           }
           catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;  
      }
      public boolean deleteOrder(String orderId)
      {
            try {
            
            Statement stmt=con.createStatement();
            
            String query="delete  from orders  where orderID="+orderId+";";
            
              stmt.executeUpdate(query);
            System.out.println("doneupdatingOrder");   
        }
           catch (SQLIntegrityConstraintViolationException e)
           {
               System.out.print("not updated");
               return false;
           }
           catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
          
          return true;
      }
      
      public boolean updateOrder(StoreOrder od)
      {
          
           try {
            
            Statement stmt=con.createStatement();
            
            String query="UPdatE orders SET ordername='"+od.name+"',paystatus='"+od.payment+"',deliverystatus='"+od.delivery+"',personID='"+od.pid+"',price='"+od.price+"' where orderid="+od.id+";";
            
              stmt.executeUpdate(query);
           
           
            
          
            System.out.println("doneupdatinguser");
          
          
           
        }
           catch (SQLIntegrityConstraintViolationException e)
           {
               System.out.print("not updated");
               return false;
           }
           catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
          
          
          
       return true;   
          
          
          
          
      }
      
}
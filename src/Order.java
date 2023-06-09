/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author visha
 */
public class Order {
      String perosnID="";
    
    public ArrayList<String> orderID=new <String> ArrayList();
   public   HashMap<String, String> deliveryStatus=new HashMap<>();
   public  HashMap<String, String> payStatus=new HashMap<>();
   public  HashMap<String, String> orderName=new HashMap<>();
   public  HashMap<String, String> price=new HashMap<>();
   public Order(String name,String pId)
    { 
        this.perosnID=pId;
        //fetching orders
         
       
     try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","parmar3542");
            Statement stmt=con.createStatement();
            
            String query="select * from orders where personID="+pId+";";
            
            ResultSet rs = stmt.executeQuery(query);
           int count=0;
            while(rs.next())
            {
                System.out.println(" id: "+rs.getString("orderId")); 
                orderID.add(rs.getString("orderId"));
                
                deliveryStatus.put(orderID.get(count),rs.getString("deliverystatus"));
                orderName.put(orderID.get(count),rs.getString("ordername"));
                price.put(orderID.get(count),rs.getString("price"));
                payStatus.put(orderID.get(count),rs.getString("paystatus"));
                  count++;
            }
            
           con.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
     catch(Exception e)
     {
         System.out.println(" genric exception => "+e);
     }      
     
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utill;
import java.text.*;
   import java.util.*;
   import java.sql.*;

   public class UserDAO 	
   {
      static Connection currentCon = null;
      static ResultSet rs = null;  
	static Connection currentCon2 = null;
      static ResultSet rs2 = null;  
	
	
      public static UserBean login(UserBean bean) {
	
         //preparing some objects for connection 
         Statement stmt = null;    
	Statement stmt2 = null; 
         String username = bean.getUsername();    
         String password = bean.getPassword();   
	     String email=null;
             String emailv=null;
             String otp=bean.getOtp();
             String otpv=null;
         String searchQuery =
               "select * from role where UserId='"
                        + username
                        + "' AND Password='"
                        + password
                        + "'";
         
	    
      // "System.out.println" prints in the console; Normally used to trace the process
      System.out.println("Your user name is " + username);          
      System.out.println("Your password is " + password);
      System.out.println("Query: "+searchQuery);
	    
      try 
      {
         //connect to DB 
         currentCon = ConnectionManager.getConnection();
         stmt=currentCon.createStatement();
         rs = stmt.executeQuery(searchQuery);	        
         boolean more = rs.next();
	      
         // if user does not exist set the isValid variable to false
         if (!more) 
         {
            System.out.println("Sorry, you are not a registered user! Please sign up first");
            bean.setValid(false);
         } 
	        
         //if user exists set the isValid variable to true
         else if (more) 
         {
            String name = rs.getString("UserId");
            //String lastName = rs.getString("LastName");
	     	bean.setRole(rs.getString("roles"));
                bean.setMailid(rs.getString("EmailId"));
                email=rs.getString("EmailId");
                
            System.out.println("Welcome " + name);
            //bean.setFirstName(firstName);
            //bean.setLastName(lastName);
            //bean.setValid(true);
         }
         String searchQuery2 =
               "select * from emailotp where email='"
                        + email+
                         "'";
         currentCon2 = ConnectionManager.getConnection();
         stmt2=currentCon2.createStatement();
         rs2 = stmt2.executeQuery(searchQuery2);	        
         boolean more2 = rs2.next(); 
           if (!more2) 
         {
            System.out.println("Sorry, you are not a registered user! Please sign up first");
            bean.setValid(false);
         } 
	        
         //if user exists set the isValid variable to true
         else if (more2) 
         {
            //String name = rs2.getString("UserId");
            //String lastName = rs.getString("LastName");
	     emailv=rs2.getString("email");
                otpv=rs2.getString("otp");	
            
            //bean.setFirstName(firstName);
            //bean.setLastName(lastName);
            //bean.setValid(true);
         }
           if(otp.equals(otpv) && email.equals(emailv)){
           bean.setValid(true);
           }
      } 

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
	    
      //some exception handling
      finally 
      {
         if (rs != null)	{
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
         }
         
         
         
          if (rs2 != null)	{
            try {
               rs2.close();
            } catch (Exception e) {}
               rs2 = null;
            }
	
         if (stmt2 != null) {
            try {
               stmt2.close();
            } catch (Exception e) {}
               stmt2 = null;
            }
	
         if (currentCon2 != null) {
            try {
               currentCon2.close();
            } catch (Exception e) {
            }

            currentCon2 = null;
         }
      }

return bean;
	
      }	
   }

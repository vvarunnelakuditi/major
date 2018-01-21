/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import java.sql.*;
import java.io.IOException;  
import java.io.PrintWriter;  

import java.util.Random;
import javax.servlet.RequestDispatcher;
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import utill.ConnectionManager;

import utill.Mailer;
  
  
public class SendMail extends HttpServlet { 
    static Connection currentCon = null;
       
	
public void doPost(HttpServletRequest request,  
 HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();        
    String[] to=new String[1];
            to[0]=request.getParameter("to");  
    String subject="OTP";  
    String msg=generateKey();
    
    //request.setAttribute("mailbean",mb);wrong way
      try 
      {
         //connect to DB 
         currentCon = ConnectionManager.getConnection();
         Statement stmt=currentCon.createStatement();  
         stmt=currentCon.createStatement();
         stmt.executeUpdate("delete from emailotp where email='"+to[0]+"'");
         stmt.executeUpdate("insert into emailotp values('"+to[0]+"','"+msg+"',now())");
      }catch(SQLException ex){
          ex.printStackTrace();
      }
    Mailer.send("venkatvarun.nelakuditi96@gmail.com","varun9016",to, subject, msg);  
    
    System.out.print("message has been sent successfully");  
    //out.close();  
    RequestDispatcher rd = request.getRequestDispatcher("Loginpage.jsp");
                    rd.forward(request,response); 
    }  
  public  static  String generateKey() 
{
 char[] chars =   "1234567890".toCharArray();
      StringBuilder sb = new StringBuilder();
Random random = new Random();
for (int i = 0; i < 8; i++) 
{
    char c = chars[random.nextInt(chars.length)];
    sb.append(c);
}
String output = sb.toString();
return output;
}

}  
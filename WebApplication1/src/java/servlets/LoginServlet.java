/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import utill.UserDAO;
import utill.UserBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

try
{	    

     UserBean user = new UserBean();
     user.setUserName(request.getParameter("un"));
     user.setPassword(request.getParameter("pw"));
     user.setOtp(request.getParameter("otp"));
     //System.out.print(mb.getTo());wrong way
     user = UserDAO.login(user);
     String role="notvalid";
     if (user.isValid())
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",user); 
          role=user.getRole();
          if(role.equals("Admin_Role")){
            response.sendRedirect("AdminPage.jsp");
          }else if(role.equals("Doctor_Role")){
            response.sendRedirect("DoctorPage.jsp");
          }else if(role.equals("Manager_Role")){
            response.sendRedirect("ManagerPage.jsp");
          }
          System.out.println(role+" is"+user.getUsername());
          //response.sendRedirect("userLogged.jsp"); //logged-in page      		
     }
	        
     else {
          role="Not Valid Details";
          request.setAttribute("Unauthorized",role);
          RequestDispatcher rd = request.getRequestDispatcher("Loginpage.jsp");
                    rd.forward(request, response); 
          //response.sendRedirect("Loginpage.jsp"); //error page 
     }
} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}

			
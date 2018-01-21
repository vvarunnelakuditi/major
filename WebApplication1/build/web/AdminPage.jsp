<%-- 
    Document   : AdminPage
    Created on : Jan 11, 2018, 6:25:10 PM
    Author     : apple
--%>
<%@page import="utill.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><script type="text/javascript">
            function preventBack(){
                window.history.forward();
                
            }
            setTimeout("preventBack()",0);
            window.onunload=function(){null};
        </script>
        <h1>Hello World!</h1>
        <% 
            UserBean ub=(UserBean)session.getAttribute("currentSessionUser");
            out.println(ub.getRole());
        %>
        <div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
        
    </body>
</html>


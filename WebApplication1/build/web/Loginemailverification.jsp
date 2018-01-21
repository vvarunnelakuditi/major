<%-- 
    Document   : Loginemailverification
    Created on : Jan 13, 2018, 2:01:40 PM
    Author     : apple
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<script type="text/javascript">
            function preventBack(){
                window.history.forward();
                
            }
            setTimeout("preventBack()",0);
            window.onunload=function(){null};
        </script>
        
        <div class="jumbotron text-center" style="height: 200px; " >
  <h1>Hospital Management System </h1>
  <p>Simple and easy to use!</p> 
</div>
  
<div class="container text-center">
  
  <form  class=form-inline action="SendMail" method="post">
    <div class="form-group">
      <label for="to">Registered Email-Id:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="to">
    </div>
   <input type="submit" class="btn btn-primary"  value="send" />   <span style="color:red"><%=(request.getAttribute("Unauthorized")== null) ? "":request.getAttribute("Unauthorized")%></span>
                        
  </form>
  
  
  
  
</div>
</body>
</html>

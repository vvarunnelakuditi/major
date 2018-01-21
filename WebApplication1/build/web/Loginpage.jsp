<%-- 
    Document   : Loginpage
    Created on : Jan 11, 2018, 12:10:11 PM
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
		
        
        
       
  
<div class="jumbotron text-center" style="height: 200px; ">
  <h1>Login.......</h1>
  <p>OTP is only valid for 2 min.....</p> 
</div>
  
<div class="container text-center">
  
    <form class="form-horizontal text-center" action="LoginServlet" method="post">
                   
                   <div class="form-group ">
      <label for="un" class="control-label col-sm-4">User-Id:</label>
      <div class="col-sm-4">
      <input type="text" class="form-control" id="un" placeholder="Enter UserId" name="un">
    </div></div>
				  <div class="form-group">
      <label for="otp" class="control-label col-sm-4">OTP:</label>
      <div class="col-sm-4">
      <input type="text" class="form-control" id="otp" placeholder="Enter OTP" name="otp">
      </div>
    </div>	
      <div class="form-group">
      <label for="pw" class="control-label col-sm-4">Password:</label>
      <div class="col-sm-4">
      <input type="password" class="form-control" id="pw" placeholder="Enter Password" name="pw">
      </div>
    </div>
                       
			<a href="Loginemailverification.jsp">If Email Is Incorrect!</a>
                        <span style="color:red"><%=(request.getAttribute("Unauthorized")== null) ? "":request.getAttribute("Unauthorized")%></span>
                         <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-5">
			<input type="submit" class="btn btn-primary" value="submit">			
      </div></div>
		</form>
        
        
</body>
</html>

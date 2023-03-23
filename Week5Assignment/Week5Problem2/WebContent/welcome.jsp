
<html>
    <head>
        <title>Welcome Page</title>
    </head>
    <body>
      <%
        if(session.getAttribute("userName")==null){
    	  response.sendRedirect("login.jsp");
        }
      %>
      
       Hello ${userName } 
       <br/>
       <br/>
       <a href="logout.jsp">You can go to Logout Page</a>
    </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br/>
        <h1 align="center">Welcome to the site!</h1>
        <form action="welcome.htm" method="post" name="NameForm"> 
         
            <center> <br/>
            
            Login: <input type="text" name="Login" value=""/> <br/> <br/>
            Password: <input type="Password" name="Password" value=""/> <br/> </br>
            
            <input type="submit" value="input" />
            
            <a href="registration.jsp">Registration</a>
            
            </center>
        </form>
        
    </body>
</html>

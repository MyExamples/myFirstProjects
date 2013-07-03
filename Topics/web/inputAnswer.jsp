<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <form action="inputAnswer.htm" method="GET" name="NameForm"> 
           <input type='hidden' name='idTopic' value="<%= request.getParameter("id") %>"/> 
 
           <br/>
        <h1 align="center">Input your answer</h1>
        <center> <br/>
            
                Answer: <input width="30%" type="text" name="Answer" value=""/> <br/> <br/>
                
                <input type="submit" value="Ok" />
            
         </center>
       </form>
    </body>
</html>

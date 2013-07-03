package shop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormURL extends HttpServlet{
 
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
    res.setContentType("text/html");
    
    res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/index.jsp"));
       
    }
}

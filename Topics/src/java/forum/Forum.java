package forum;

import DAO.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Topics;

/**
 *
 * @author Julia
 */
public class Forum extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        
        res.setContentType("text/html");
        
        
        
        res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/index.jsp"));
        
        
    }
}

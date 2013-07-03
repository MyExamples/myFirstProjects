package forum;

import DAO.Factory;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Users;

/**
 *
 * @author Julia
 */
public class Registration extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    
        String request_Login = req.getParameter("Login");//takes login and password, that user entered
        String request_Password = req.getParameter("Password");
   
        Factory instance = Factory.getInstance();
        
        Users user = new Users();//this object-user will store parameters of current user
        
        user.setLogin(request_Login);
        user.setPassword(request_Password);
        
        
        try {
            
            instance.getUserDAO().addUser(user);//adds current user into database
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/index.jsp"));
       
    }
}

package forum;

import DAO.Factory;
import forum.storage.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Topics;
import logic.Users;

/**
 *
 * @author Julia
 */
public class InputTopic extends HttpServlet{
 
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String topicStr;
        topicStr = req.getParameter("Topic");//take Topic, that current user entered
        
        
        User user = new User();
        user = (User)req.getSession().getAttribute("user");//take object of current user from Session 
        
        Topics topics = new Topics();//this object will store new Topic parameters
        topics.setTopicName(topicStr);
        
        Long id_user;
        id_user = Long.valueOf(user.getId());
        
        Users usersObj = new Users();
        
        Factory instance = Factory.getInstance();
        
        try {
            
            usersObj = instance.getUserDAO().getUserById(id_user);
            
            if(usersObj != null){
            
                topics.setIdUser(usersObj);
                
                instance.getTopicDAO().addTopic(topics);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(InputTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Welcome welcome = new Welcome();
        welcome.updateTopicsAnswers(req);
        
        res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/forum.jsp"));
    }
}

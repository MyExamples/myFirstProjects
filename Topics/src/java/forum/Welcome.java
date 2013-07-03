package forum;

import DAO.Factory;
import forum.storage.Answer;
import forum.storage.Topic;
import forum.storage.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Answers;
import logic.Topics;

/**
 *
 * @author Julia
 */
//this Servlet processes index.jsp (form action="welcome.htm")
public class Welcome extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
    res.setContentType("text/html");
    
    String request_Login = req.getParameter("Login");
    String request_Password = req.getParameter("Password");
   
    
    HttpSession httpSession = req.getSession();

    Enumeration<String> params = httpSession.getAttributeNames();

    PrintWriter out = res.getWriter();

    
    
    //check in database this user
    ResultSet input = ConnectPostgre.executeQuery(" select * from users where login = '"+request_Login+"' and password = '"+request_Password + "'");
      
    User user = new User();
   
    if(input!=null){
     Integer id = 0;
       try {
            if(input.next() != false){ 
                id = input.getInt("id");
                 if(id > 0){
                    user.setId(id);
                    user.setLogin(request_Login);
                    user.setPassword(request_Password);
                
                    req.getSession(true).setAttribute("user", user);
                    
                    
                    updateTopicsAnswers(req);
                    
                    
                    res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/forum.jsp"));
                  }
                 else{   
                    res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/registration.jsp"));
     
                   }
                }
             else{   
                    res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/registration.jsp"));
     
                   }
        } catch (SQLException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------  "+ex);
        }
     }
    else{
        res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/registration.jsp"));
    }
    
    
          
    }
    
    //this function get All topics and answers from database,
    // after set objects (topic and answer) in Session
    public void updateTopicsAnswers(HttpServletRequest req){
        
        ArrayList<Topics> listTopics = new ArrayList<Topics>();
        
        Factory instance = Factory.getInstance();
        
        listTopics = (ArrayList<Topics>) instance.getTopicDAO().getAllTopics();
        
        Topic topic = new Topic();
        
        topic.setListTopics(listTopics);
        
        req.getSession().setAttribute("topic", topic);
        
        
        ArrayList<Answers> listAnswers = new ArrayList<Answers>();
        
        listAnswers = (ArrayList<Answers>) instance.getAnswerDAO().getAllAnswers();
        
        Answer answer = new Answer();
        
        answer.setListAnswers(listAnswers);
        
        req.getSession().setAttribute("answer", answer);
               
    }
    
   
}

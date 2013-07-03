package forum;

import DAO.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Answers;
import logic.Topics;
import logic.Users;

/**
 *
 * @author Julia
 */
public class InputAnswer extends HttpServlet{
 
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        
        res.setContentType("text/html");
                
        String idTopicStr = req.getParameter("idTopic");//takes id of Topic, we want to add answer to
        Long idTopic = Long.valueOf(idTopicStr);
        
        String answerStr;
        answerStr = req.getParameter("Answer");//takes answer entered by user
        
        Answers answers = new Answers();
        answers.setAnswerName(answerStr);
                
        Factory instance = Factory.getInstance();
           
        Topics topics = new Topics();
        
        try {

                topics = instance.getTopicDAO().getTopicById(idTopic);

                if(topics != null){

                    answers.setIdTopic(topics);

                    instance.getAnswerDAO().addAnswer(answers);

                }

        }
        catch (SQLException ex) {
            
                Logger.getLogger(InputTopic.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        
        
        Welcome welcome = new Welcome();
        welcome.updateTopicsAnswers(req);
        
        res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/forum.jsp"));
    }
}

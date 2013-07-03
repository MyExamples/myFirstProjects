package DAO.Impl;

import DAO.AnswerDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import logic.Answers;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Julia
 */
public class AnswerDAOImpl implements AnswerDAO{

    @Override
    public void addAnswer(Answers answer) throws SQLException {
        Session session = null;
    
        try {
      
            session = HibernateUtil.getSessionFactory().openSession();
     
            session.beginTransaction();
      
            session.save(answer);
      
            session.getTransaction().commit();
    
        } catch (Exception e) {
      
            JOptionPane.showMessageDialog(null, e.getMessage(), "Insertion error", JOptionPane.OK_OPTION);
    
        } finally {
      
            if (session != null && session.isOpen()) {

        
                session.close();
      
            }
    
        }
    }


    @Override
    public Collection getAllAnswers() {
        Session session = null;
        List answers = new ArrayList<Answers>();
    
        try {
      
            session = HibernateUtil.getSessionFactory().openSession();
      
            answers = session.createCriteria(Answers.class).list();
    
        } catch (Exception e) {
      
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'getAll'", JOptionPane.OK_OPTION);
    
        } finally {
      
            if (session != null && session.isOpen()) {
        
                session.close();
      
            }
        }
    
        return answers;
 
    }
    
}

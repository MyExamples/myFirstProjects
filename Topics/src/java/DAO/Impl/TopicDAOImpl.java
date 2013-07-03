package DAO.Impl;

import DAO.TopicDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import logic.Topics;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Julia
 */
public class TopicDAOImpl implements TopicDAO{

    @Override
    public void addTopic(Topics topic) throws SQLException {
        Session session = null;
    
        try {
      
            session = HibernateUtil.getSessionFactory().openSession();
     
            session.beginTransaction();
      
            session.save(topic);
      
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
    public Collection getAllTopics() {
        Session session = null;
        List topics = new ArrayList<Topics>();
    
        try {
      
            session = HibernateUtil.getSessionFactory().openSession();
      
            topics = session.createCriteria(Topics.class).list();
    
        } catch (Exception e) {
      
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'getAll'", JOptionPane.OK_OPTION);
    
        } finally {
      
            if (session != null && session.isOpen()) {
        
                session.close();
      
            }
        }
    
        return topics;
 
    }

    @Override
    public Topics getTopicById(Long topic_id) throws SQLException {
  
        Session session = null;
        Topics topicsOb = new Topics();
      
        try {
      
          session = HibernateUtil.getSessionFactory().openSession();
      
          //creates an exemplar of Criteria:
          Criteria crit = session.createCriteria(Topics.class);
          crit.setMaxResults(50);
          List listUsers = crit.list();
          
          for(int i=0; i<listUsers.size(); i++){
              
              topicsOb = (Topics) listUsers.get(i);
              
              Long id = topicsOb.getId();
              
              if(id.equals(topic_id)){
              
                 return topicsOb;
              }
                            
          }

        } catch (Exception e) {
      
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findById'", JOptionPane.OK_OPTION);
        } finally {
      
          if (session != null && session.isOpen()) {
        
              session.close();
          }
      }
      return topicsOb;

    }
    
}

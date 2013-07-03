package DAO.Impl;

import DAO.UserDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import logic.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

public class UserDAOImpl implements UserDAO{
    
    @Override
    public void addUser(Users user) throws SQLException {
        Session session = null;
    
        try {
      
            session = HibernateUtil.getSessionFactory().openSession();
     
            session.beginTransaction();
      
            session.save(user);
      
            session.getTransaction().commit();
    
        } catch (Exception e) {
      
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
    
        } finally {
      
            if (session != null && session.isOpen()) {

        
                session.close();
      
            }
    
        }

    }

    @Override
    public void updateUser(Long user_id, Users user) throws SQLException {
            Session session = null;
   
            try {
      
                session = HibernateUtil.getSessionFactory().openSession();
      
                session.beginTransaction();
      
                session.update(user);
      
                session.getTransaction().commit();
    
            } catch (Exception e) {
      
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
    
            } finally {
      
                if (session != null && session.isOpen()) {
        
                    session.close();
      
                }
    
            }

    }

    @Override
    public Users getUserById(Long user_id) throws SQLException {
        Session session = null;
        Users usersOb = new Users();
      
      try {
      
          session = HibernateUtil.getSessionFactory().openSession();
      
          //создание экзепляра Criteria:
          Criteria crit = session.createCriteria(Users.class);
          crit.setMaxResults(50);
          List listUsers = crit.list();
          
          for(int i=0; i<listUsers.size(); i++){
              
              usersOb = (Users) listUsers.get(i);
              
              Long id = usersOb.getId();
              
              if(id.equals(user_id)){
              
                  //то, что выбрал пользователь
                  
                  return usersOb;
              }
                            
          }
          
          
      } catch (Exception e) {
      
          JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
    
      } finally {
      
          if (session != null && session.isOpen()) {
        
              session.close();
      
          }
    
      }
    
      return usersOb;
    }

    
    @Override
    public Collection getAllUsers() throws SQLException {
        Session session = null;
        List users = new ArrayList<Users>();
    
        try {
      
            session = HibernateUtil.getSessionFactory().openSession();
      
            users = session.createCriteria(Users.class).list();
    
        } catch (Exception e) {
      
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
    
        } finally {
      
            if (session != null && session.isOpen()) {
        
                session.close();
      
            }
        }
    
        return users;
    }

    @Override
    public void deleteUser(Users user) throws SQLException {
        Session session = null;
    
        try {
      
            session = HibernateUtil.getSessionFactory().openSession();
      
            session.beginTransaction();
      
            session.delete(user);
      
            session.getTransaction().commit();
    
        } catch (Exception e) {
      
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
    
        } finally {
      
            if (session != null && session.isOpen()) {
        
                session.close();
      
            }
    
        }

    }
    
}

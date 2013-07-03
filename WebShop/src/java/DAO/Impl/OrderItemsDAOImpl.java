package DAO.Impl;

import DAO.OrderItemsDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import logic.OrderItems;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

public class OrderItemsDAOImpl implements OrderItemsDAO{

    @Override
    public void addOrderItems(OrderItems orderItems) throws SQLException {
        Session session = null;
    
        try {
      
            session = HibernateUtil.getSessionFactory().openSession();
     
            session.beginTransaction();
      
            session.save(orderItems);
      
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
    public Collection getAllOrders() throws SQLException {
        Session session = null;
       List orderItems = new ArrayList<OrderItems>();
      
      try {
      
          session = HibernateUtil.getSessionFactory().openSession();
      
          //создание экзепляра Criteria:
          Criteria crit = session.createCriteria(OrderItems.class);
          crit.setMaxResults(50);
          orderItems = crit.list();
          
                   
          
      } catch (Exception e) {
      
          JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
    
      } finally {
      
          if (session != null && session.isOpen()) {
        
              session.close();
      
          }
    
      }
    
      return orderItems;
    }
    
}

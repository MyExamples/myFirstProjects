package DAO.Impl;

import DAO.OrderDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import logic.Order;
import logic.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import util.HibernateUtil;

public class OrderDAOImpl implements OrderDAO{

    private Object order;
    
    @Override
    public void addOrder(Order order) throws SQLException {
            Session session = null;
    
        try {
      
            session = HibernateUtil.getSessionFactory().openSession();
     
            session.beginTransaction();
      
            session.save(order);
      
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
    public void deleteOrder(Order order) throws SQLException {
            Session session = null;
    
        try {
      
            session = HibernateUtil.getSessionFactory().openSession();
      
            session.beginTransaction();
      
            session.delete(order);
      
            session.getTransaction().commit();
    
        } catch (Exception e) {
      
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
    
        } finally {
      
            if (session != null && session.isOpen()) {
        
                session.close();
      
            }
    
        }

    
    
    }

    @Override
    public Order getOrderById(Long order_id) throws SQLException {
        
      Session session = null;
      Order orderOb = new Order();
      
      try {
      
          session = HibernateUtil.getSessionFactory().openSession();
      
          //создание экзепляра Criteria:
          Criteria crit = session.createCriteria(Order.class);
          crit.setMaxResults(50);
          List products = crit.list();
          
          for(int i=0; i<products.size(); i++){
              
              orderOb = (Order) products.get(i);
              
              Long id = orderOb.getId();
              
              if(id.equals(order_id)){
              
                  //то, что выбрал пользователь
                  
                  return orderOb;
              }
                            
          }
          
          
      } catch (Exception e) {
      
          JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
    
      } finally {
      
          if (session != null && session.isOpen()) {
        
              session.close();
      
          }
    
      }
    
      return orderOb;
    }

    @Override
    public Collection getAllOrders() throws SQLException {
       Session session = null;
       List orders = new ArrayList<Order>();
      
      try {
      
          session = HibernateUtil.getSessionFactory().openSession();
      
          //создание экзепляра Criteria:
          Criteria crit = session.createCriteria(Order.class);
          crit.setMaxResults(50);
          orders = crit.list();
          
                   
          
      } catch (Exception e) {
      
          JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
    
      } finally {
      
          if (session != null && session.isOpen()) {
        
              session.close();
      
          }
    
      }
    
      return orders;
        
    }

    @Override
    public Collection getAllOrdersByIdUser(Long idUser) throws SQLException {
       Session session = null;
       List<Order> orders = null;
       
       try {
      
          session = HibernateUtil.getSessionFactory().openSession();
          
          /*
          Criteria criteria = session.createCriteria(Order.class);
          Criterion criterion = Expression.eq("idUser", idUser);
          criteria.add(criterion);
          orders = criteria.list();
          */
          
          orders = session.createCriteria(Order.class).add(Expression.eq("idUser",idUser)).list();
                             
          
      } catch (Exception e) {
      
          //JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
    
          System.out.println("EXAPTION: ");
          e.printStackTrace();//Вывод в консоль эксепшена
          
      } finally {
      
          if (session != null && session.isOpen()) {
        
              session.close();
      
          }
    
      }
    
      return orders;
    }
    
}

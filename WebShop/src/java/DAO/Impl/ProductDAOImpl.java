package DAO.Impl;

import DAO.ProductDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import logic.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

public class ProductDAOImpl implements ProductDAO{

    @Override
    public void addProduct(Product product) throws SQLException {
        Session session = null;
    
        try {
      
            session = HibernateUtil.getSessionFactory().openSession();
     
            session.beginTransaction();
      
            session.save(product);
      
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
    public Product getProductById(Long product_id) throws SQLException {
      Session session = null;
      Product productOb = new Product();
      
      try {
      
          session = HibernateUtil.getSessionFactory().openSession();
      
          //создание экзепляра Criteria:
          Criteria crit = session.createCriteria(Product.class);
          crit.setMaxResults(50);
          List products = crit.list();
          
          for(int i=0; i<products.size(); i++){
              
              productOb = (Product) products.get(i);
              
              Long id = productOb.getId();
              
              if(id.equals(product_id)){
              
                  //то, что выбрал пользователь
                  
                  return productOb;
              }
                            
          }
          
          
      } catch (Exception e) {
      
          JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
    
      } finally {
      
          if (session != null && session.isOpen()) {
        
              session.close();
      
          }
    
      }
    
      return productOb;
    }

    @Override
    public Collection getAllProducts() throws SQLException {
       Session session = null;
        List products = new ArrayList<Product>();
    
        try {
      
            session = HibernateUtil.getSessionFactory().openSession();
      
            products = session.createCriteria(Product.class).list();
    
        } catch (Exception e) {
      
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
    
        } finally {
      
            if (session != null && session.isOpen()) {
        
                session.close();
      
            }
        }
    
        return products;
    }

}

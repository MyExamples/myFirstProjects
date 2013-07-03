package DAO.Impl;

import DAO.CategoryDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import logic.Category;
import org.hibernate.Session;
import util.HibernateUtil;

public class CategoryDAOImpl implements CategoryDAO{

    @Override
    public void addCategory(Category category) throws SQLException {
        Session session = null;
    
        try {
      
            session = HibernateUtil.getSessionFactory().openSession();
     
            session.beginTransaction();
      
            session.save(category);
      
            session.getTransaction().commit();
    
        } catch (Exception e) {
      
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
    
        } finally {
      
            if (session != null && session.isOpen()) {

        
                session.close();
      
            }
    
        }
    }
    
}

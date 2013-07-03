/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Julia
 */
//This class will be hawala our configuration file (hibernate.cfg.xml)
// and return us to an object of type SessionFactory,
// that  responsible for creating hibernate-Session
public class HibernateUtil {
    
  private static final SessionFactory sessionFactory;//requests will go through this Session
    static{
      try {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
      } catch (Throwable ex) {
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
      }
    }

    public static SessionFactory getSessionFactory() {
      return sessionFactory;
    }


}


package util;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

//этот класс будет хавать наш конфиг-файл (hibernate.cfg.xml) и возвращать нам объект типа SessionFactory,
//который отвечает за создание hibernate-сессии
public class HibernateUtil {
    
  private static final SessionFactory sessionFactory;//через эту сессию будут идти запросы
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
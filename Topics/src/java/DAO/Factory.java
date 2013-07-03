package DAO;

import DAO.Impl.AnswerDAOImpl;
import DAO.Impl.TopicDAOImpl;
import DAO.Impl.UserDAOImpl;

/**
 *
 * @author Julia
 */
//By this class we will call methods, that will be get from DAO-realizations 
//(methods, get from DAO-realizations, are called by this class) 
public class Factory {
    
    private static Factory instance = null;
    private static UserDAO userDAO = null;
    private static TopicDAO topicDAO = null;
    private static AnswerDAO answerDAO = null;
    
    //this method is static synchronized, because the object must be the one
  public static synchronized Factory getInstance(){
    if (instance == null){
      instance = new Factory();
    }
    return instance;
  }
  
  public UserDAO getUserDAO(){
    if (userDAO == null){
      userDAO = new UserDAOImpl();
    }
    return userDAO;
  }

  public TopicDAO getTopicDAO(){
    if (topicDAO == null){
      topicDAO = new TopicDAOImpl();
    }
    return topicDAO;
  }
  
  public AnswerDAO getAnswerDAO(){
      if(answerDAO == null){
          answerDAO = new AnswerDAOImpl();
      }
      return answerDAO;
  }
  
}

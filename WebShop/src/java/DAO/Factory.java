package DAO;

import DAO.Impl.*;

public class Factory {
  
  private static UserDAO userDAO = null;
  private static OrderDAO orderDAO = null;
  private static OrderItemsDAO orderItemsDAO = null;
  private static ProductDAO productDAO = null;
  private static CategoryDAO categoryDAO = null;
  private static Factory instance = null;

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

  public OrderDAO getOrderDAO(){
    if (orderDAO == null){
      orderDAO = new OrderDAOImpl();
    }
    return orderDAO;
  }

   public OrderItemsDAO getOrderItemsDAO(){
    if (orderItemsDAO == null){
      orderItemsDAO = new OrderItemsDAOImpl();
    }
    return orderItemsDAO;
  }
   
  public ProductDAO getProductDAO(){
    if (productDAO == null){
      productDAO = new ProductDAOImpl();
    }
    return productDAO;
  }

  public CategoryDAO getCategoryDAO(){
    if (categoryDAO == null){
      categoryDAO = new CategoryDAOImpl();
    }
    return categoryDAO;
  }

}
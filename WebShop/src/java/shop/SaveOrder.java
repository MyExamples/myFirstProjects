package shop;

import DAO.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.lang.System.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import logic.Order;
import logic.OrderItems;
import logic.Product;
import logic.Users;

public class SaveOrder extends HttpServlet{
    
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        //take massiv from session , do Order, and basket will null
        Basket basket = new Basket();
        
        basket = (Basket)req.getSession().getAttribute("basket");
        if(basket == null){
            out.println("Errrrroorrr BASKET = NULL !!!");
        }
        
        ArrayList<Product> listProducts = new ArrayList<Product>();
        listProducts = basket.getlistProducts();//so now massiv has list Orders
        
        Order order = new Order();
        OrderItems orderItems = new OrderItems();
        //take id user-online
        Long id_user;
            
        User user = new User();
        
        user = (User)req.getSession().getAttribute("user"); 
        id_user = Long.valueOf(user.id);//must create order for this user
        
        //order.setId_user(user);
        Factory instance = Factory.getInstance();
        Users usersObj = new Users();
        
        try {
            usersObj = instance.getUserDAO().getUserById(id_user);
            
            if(usersObj != null){
                 
                //must create order for this user
                order.setIdUser(usersObj);//.setId_user(usersObj);
                //orderItems-list
        
                List<OrderItems> listOrderItems = new ArrayList<OrderItems>();
                
                for(int i = 0; i < listProducts.size(); i ++){
                    Product p = listProducts.get(i);
                    orderItems.setIdProduct(p);
                    
                    listOrderItems.add(orderItems);
                }
                /*
                for (Iterator<Product> iter = listProducts.iterator(); iter.hasNext();){
                    orderItems.setId_product(iter.next());
                    
                    listOrderItems.add(orderItems);//moron-WALL
                }
                */
                orderItems.setIdOrder(order);
        
                order.setOrderItems(listOrderItems);
                
        try {
            
            instance.getOrderDAO().addOrder(order);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                
                //must set to zero of basket
                basket = new Basket();
                req.getSession().setAttribute("basket", basket);
        
                getServletContext().getRequestDispatcher("/shop.jsp").forward(req, res);
                
            }
            else{
                System.out.println("usersObj = NULL !!!");
            }
         }
         catch (SQLException ex) {
            ex.printStackTrace();
         }
        
              
       
    }
    
}

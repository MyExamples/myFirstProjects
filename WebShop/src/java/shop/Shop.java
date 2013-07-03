package shop;

import DAO.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Category;
import logic.Product;

public class Shop extends HttpServlet{
 
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    
    try{
    
    out.print("test");
    
    String login;
    String password;
    
    User user = new User();
    
    user = (User)req.getSession().getAttribute("user"); 
    login = user.login;
    password = user.password;
   
    //out.print(" "+login);//вывод на page
    //out.print(" "+password);
    
    
    String id = req.getParameter("id");
    //out.print(" "+id+" ");
    
    
    Basket basket = (Basket)req.getSession().getAttribute("basket");
    if(basket == null){
        basket = new Basket();
    }
    
    
    
    Factory instance = Factory.getInstance();
        
   
        //достать продукт по id из базы данных
        //объект корзины положить в сессию
        
        Product productObj = new Product();
        Long id_Long = Long.valueOf(id);//id=24
        
        try {
            productObj = instance.getProductDAO().getProductById(id_Long);
            
            if(productObj!=null){
                        
                basket.addProductToBasket(productObj);
                        
                //объект корзины в сессию:
                req.getSession().setAttribute("basket", basket);
            
                getServletContext().getRequestDispatcher("/shop.jsp").forward(req, res);
                //res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/shop.jsp"));

            }
            else{
                System.out.println("productObj = NULL !!!");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
       
    
      
       
      
    
  }
  catch (Exception ex) {
      System.out.println("Eeeerrrrrrrrrrrrooooorr ");
       ex.printStackTrace();  
       out.print(ex.getMessage());
  }
  out.flush();//выгружает данные из потока
    }
    
}


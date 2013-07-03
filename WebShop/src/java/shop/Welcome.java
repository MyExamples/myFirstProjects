package shop;

import DAO.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Product;

public class Welcome extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    
    displayProductsInShop(req);
    
    String request_Login = req.getParameter("Login");
    String request_Password = req.getParameter("Password");
   
    
    //проверку на наличие в базе данных
    ResultSet input = ConnectPostgre.executeQuery(" select * from users where login = '"+request_Login+"' and password = '"+request_Password + "'");
      
    User user = new User();
   
    if(input!=null){
     Integer id = 0;
       try {
            if(input.next() != false){ //
                id = input.getInt("id");
                 if(id > 0){
                    user.setId(id);
                    user.setLogin(request_Login);
                    user.setPassword(request_Password);
                
                    req.getSession(true).setAttribute("user", user);
                    res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/shop.jsp"));
                  }
                 else{   
                    res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/registration.jsp"));
     
                   }
                }
             else{   
                    res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/registration.jsp"));//перейти на index.jsp
     
                   }
        } catch (SQLException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------  "+ex);
        }
     }
    
    
          
    }
    
    private void displayProductsInShop(HttpServletRequest req){
        
        List products = new ArrayList<Product>();
        
        Factory instance = Factory.getInstance();
        
        try{
            products = (List) instance.getProductDAO().getAllProducts();
            
            if(products.size()!=0){
                req.getSession().setAttribute("products", products);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
}

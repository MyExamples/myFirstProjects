package shop;

import DAO.Factory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Category;
import logic.Product;
import logic.Users;


public class Registration extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    
        String request_Login = req.getParameter("Login");
        String request_Password = req.getParameter("Password");
   
        Factory instance = Factory.getInstance();
        
        Category category = new Category();
        Users user = new Users();
        
        category.setCategoryName("name");
        user.setLogin(request_Login);
        user.setPassword(request_Password);
        
        /*
        Product p1 = new Product();
        p1.setId_category(category);
        p1.setProductName("p1");
        
        Product p2 = new Product();
        p2.setId_category(category);
        p2.setProductName("p2");
        
        List<Product> lstProduct = new ArrayList<Product>();
        
        lstProduct.add(p1);
        lstProduct.add(p2);
        
        category.setProducts(lstProduct);
        */
        try {
            instance.getUserDAO().addUser(user);
            //instance.getCategoryDAO().addCategory(category);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //ConnectPostgre.executeQuery("INSERT INTO users(id, login, password) VALUES('2', '"+request_Login+"', '"+request_Password+"');");
    
        res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/index.jsp"));
       
    }
    
}

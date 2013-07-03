package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Product;


public class RemoveFromBasket extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
    
        Basket basket = (Basket)req.getSession().getAttribute("basket");
        
        ArrayList<Product> listProducts = new ArrayList<Product>();
        
        listProducts = basket.getlistProducts();
       
        //must get index of order, that must delete
        int index_remove = new Integer(req.getParameter("index"));
        
        listProducts.remove(index_remove);
        
        
        basket.setListProducts(listProducts);
        
        //object "basket" in Session
        req.getSession().setAttribute("basket", basket);
        
        //res.sendRedirect(req.getContextPath()+"/shop.jsp");
        getServletContext().getRequestDispatcher("/shop.jsp").forward(req, res);
    }
    
}

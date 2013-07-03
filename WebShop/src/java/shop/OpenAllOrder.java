package shop;

import DAO.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Order;
import logic.OrderItems;
import logic.Users;
import static java.lang.System.*;

public class OpenAllOrder extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        User user = new User();
        Long idUser;
        user = (User)req.getSession().getAttribute("user"); 
        idUser = Long.valueOf(user.id);//must open all orders for this user (current-текущий)
        
        //List orderItems = new ArrayList<Order>();
        List orders = new ArrayList<Order>();
                
        Order orderObj = new Order();
        
        try{
        
            Factory instance = Factory.getInstance();
                   
            orders = (List) instance.getOrderDAO().getAllOrdersByIdUser(idUser);//orders for this user
            
            for(int i=0; i<orders.size(); i++){
                orderObj = (Order) orders.get(i);
                
            }
        } 
        catch (Exception e) {
            
        }
        
        /*
        //_________________________________________
        try{
        
        Factory instance = Factory.getInstance();
        Long id_maybe_user;
        
        
            
            orders = (List) instance.getOrderDAO().getAllOrders();
            
            for(int i=0; i<orders.size(); i++){
                orderObj = (Order) orders.get(i);
                
                Users us_id = orderObj.getId_user();//!!!
                id_maybe_user = us_id.getId();//org.hibernate.LazyInitializationException: could not initialize proxy - no Session
                out.flush();//выгружает данные из потока
                out.println("");
                if(id_maybe_user == id_user){
                    //good
                    out.println("____GOOD________________________________________");
                }
            }
        } 
        catch (Exception e) {
            
        }
        */
    }
    
}

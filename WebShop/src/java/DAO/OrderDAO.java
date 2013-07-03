package DAO;

import java.util.Collection;
import java.sql.SQLException;
import logic.Order;
import logic.Users;

public interface OrderDAO {
    
    public void addOrder(Order order) throws SQLException;
    public void deleteOrder(Order order) throws SQLException;
    
    public Collection getAllOrders() throws SQLException;
    public Order getOrderById(Long order_id) throws SQLException;
    public Collection getAllOrdersByIdUser(Long id_user) throws SQLException;
}

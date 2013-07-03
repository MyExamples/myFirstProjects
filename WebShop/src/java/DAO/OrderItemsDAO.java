package DAO;

import java.util.Collection;
import java.sql.SQLException;
import logic.OrderItems;

public interface OrderItemsDAO {
    
    public void addOrderItems(OrderItems orderItems) throws SQLException;
    
    public Collection getAllOrders() throws SQLException;
}

package DAO;

import java.util.Collection;
import java.sql.SQLException;
import logic.Product;

public interface ProductDAO {
    
        public void addProduct(Product product) throws SQLException;

        /**
     *
     * @param product_id
     * @return
     * @throws SQLException
     */
    public Product getProductById(Long product_id) throws SQLException;
    
    public Collection getAllProducts() throws SQLException;
}

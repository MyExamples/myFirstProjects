package DAO;

import java.util.Collection;
import java.sql.SQLException;
import logic.Category;

public interface CategoryDAO {
    
    public void addCategory(Category category) throws SQLException;
    
}

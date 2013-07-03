package DAO;

import java.sql.SQLException;
import java.util.Collection;
import logic.Users;

/**
 *
 * @author Julia
 */
public interface UserDAO {
    
    public void addUser(Users user) throws SQLException;
    public Users getUserById(Long user_id) throws SQLException;
    
}

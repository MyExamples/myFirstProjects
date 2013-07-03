package DAO;

import java.util.Collection;
import java.sql.SQLException;
import logic.Users;

public interface UserDAO {
    
    public void addUser(Users user) throws SQLException;
    public void updateUser(Long user_id, Users user) throws SQLException;
    public Users getUserById(Long user_id) throws SQLException;
    public Collection getAllUsers() throws SQLException;
    public void deleteUser(Users user) throws SQLException;
}

package dao;

import domain.User;

import java.io.Serializable;
import java.util.List;


public interface UserDAO {
    public void add(User user);
    public void update(User user);
    public void delete(User user);
    public User getById(Long id);
    public List<User> getAll();
}

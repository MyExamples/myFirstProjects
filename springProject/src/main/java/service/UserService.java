package service;

import dao.UserDAO;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

//Класс сервиса, делегирующего дао-методы, будет использоваться в контроллере
public class UserService {

    private UserDAO userDAO;

    @Autowired
    //- через данную аннотацию указывается бин, который необходимо проинжектить в текущий класс
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void add(User user) {
        userDAO.add(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

    public User getById(Long id) {
        return userDAO.getById(id);
    }

    public List<User> getAll() {
        return userDAO.getAll();
    }
}
